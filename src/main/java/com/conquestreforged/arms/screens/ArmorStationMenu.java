package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.MenuTypeInit;
import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class ArmorStationMenu extends ScreenHandler {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ScreenHandlerContext access;
    private final Property selectedRecipe = Property.create();
    private final World level;
    private List<ArmorStationRecipe> recipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {
    };
    public final Inventory input;
    final CraftingResultInventory output;

    public ArmorStationMenu(int i, PlayerInventory inventory) {
        this(i, inventory, ScreenHandlerContext.EMPTY);
    }


    public ArmorStationMenu(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(MenuTypeInit.ARMS_STATION_MENU, syncId);
        this.access = context;
        this.level = playerInventory.player.getWorld();
        this.input = new SimpleInventory(1) {
            public void markDirty() {
                super.markDirty();
                ArmorStationMenu.this.onContentChanged(this);
                ArmorStationMenu.this.slotUpdateListener.run();
            }
        };
        this.output = new CraftingResultInventory();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraft(player.getWorld(), player, stack.getCount());
                ArmorStationMenu.this.output.unlockLastRecipe(player, this.getInputStacks());
                ItemStack itemStack = ArmorStationMenu.this.inputSlot.takeStack(1);
                if (!itemStack.isEmpty()) {
                    ArmorStationMenu.this.populateResult();
                }

                context.run((world, pos) -> {
                    long l = world.getTime();
                    if (ArmorStationMenu.this.lastSoundTime != l) {
                        world.playSound((PlayerEntity)null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        ArmorStationMenu.this.lastSoundTime = l;
                    }

                });
                super.onTakeItem(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(ArmorStationMenu.this.inputSlot.getStack());
            }
        });


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

        this.addProperty(this.selectedRecipe);
    }



    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public List<ArmorStationRecipe> getAvailableRecipes() {
        return this.recipes;
    }

    public int getAvailableRecipeCount() {
        return this.recipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasStack() && !this.recipes.isEmpty();
    }

    public boolean canUse(PlayerEntity player) {
        return true;
        //return canUse(this.access, player, BlockInit.ARMS_STATION_BLOCK);
    }

    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }

        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.recipes.size();
    }

    public void onContentChanged(Inventory inventory) {
        ItemStack itemstack = this.inputSlot.getStack();
        if (!itemstack.isOf(this.inputStack.getItem())) {
            this.inputStack = itemstack.copy();
            this.updateInput(inventory, itemstack);
        }

    }

    private void updateInput(Inventory input, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipe.set(-1);
        this.resultSlot.setStackNoCallbacks(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getAllMatches(ArmorStationRecipe.Type.INSTANCE, input, this.level);
        }

    }

    void populateResult() {
        if (!this.recipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            ArmorStationRecipe stonecuttingRecipe = this.recipes.get(this.selectedRecipe.get());
            ItemStack itemStack = stonecuttingRecipe.craft(this.input, this.level.getRegistryManager());
            if (itemStack.isItemEnabled(this.level.getEnabledFeatures())) {
                this.output.setLastRecipe(stonecuttingRecipe);
                this.resultSlot.setStackNoCallbacks(itemStack);
            } else {
                this.resultSlot.setStackNoCallbacks(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.setStackNoCallbacks(ItemStack.EMPTY);
        }

        this.sendContentUpdates();
    }

    public ScreenHandlerType<?> getType() {
        return MenuTypeInit.ARMS_STATION_MENU;
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.slotUpdateListener = contentsChangedListener;
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraft(itemStack2, player.getWorld(), player);
                if (!this.insertItem(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.insertItem(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getFirstMatch(ArmorStationRecipe.Type.INSTANCE, new SimpleInventory(new ItemStack[]{itemStack2}), this.level).isPresent()) {
                if (!this.insertItem(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 2 && slot < 29) {
                if (!this.insertItem(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 29 && slot < 38 && !this.insertItem(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            }

            slot2.markDirty();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
            this.sendContentUpdates();
        }

        return itemStack;
    }

    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.output.removeStack(1);
        this.access.run((world, pos) -> {
            this.dropInventory(player, this.input);
        });
    }
}