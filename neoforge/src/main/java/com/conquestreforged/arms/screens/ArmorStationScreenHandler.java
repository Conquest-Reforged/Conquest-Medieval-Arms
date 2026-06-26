package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import com.conquestreforged.arms.recipe.ModRecipeType;
import com.google.common.collect.Lists;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import java.util.List;

public class ArmorStationScreenHandler extends AbstractContainerMenu {
    private final ContainerLevelAccess context;
    private final DataSlot selectedRecipe = DataSlot.standalone();
    private final Level world;
    private List<RecipeHolder<ArmorStationRecipe>> availableRecipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot outputSlot;
    Runnable contentsChangedListener = () -> {};

    public final SimpleContainer input = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            super.setChanged();
            ArmorStationScreenHandler.this.slotsChanged(this);
            ArmorStationScreenHandler.this.contentsChangedListener.run();
        }
    };

    final ResultContainer output = new ResultContainer();

    public ArmorStationScreenHandler(int syncId, Inventory inventory) {
        this(syncId, inventory, ContainerLevelAccess.NULL);
    }

    public ArmorStationScreenHandler(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(ModScreenHandlerType.ARMS_STATION_SCREEN, syncId);
        this.context = context;
        this.world = playerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                ArmorStationScreenHandler.this.output.awardUsedRecipes(player, this.getInputStacks());
                ItemStack inputStack = ArmorStationScreenHandler.this.inputSlot.remove(1);
                if (!inputStack.isEmpty()) {
                    ArmorStationScreenHandler.this.populateResult();
                }
                context.execute((world, pos) -> {
                    long l = world.getGameTime();
                    if (ArmorStationScreenHandler.this.lastTakeTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0f, 1.0f);
                        ArmorStationScreenHandler.this.lastTakeTime = l;
                    }
                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(ArmorStationScreenHandler.this.inputSlot.getItem());
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
        this.addDataSlot(this.selectedRecipe);
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public List<RecipeHolder<ArmorStationRecipe>> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, BlockInit.ARMS_STATION_BLOCK.get());
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }
        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public void slotsChanged(Container container) {
        ItemStack itemStack = this.inputSlot.getItem();
        if (!itemStack.is(this.inputStack.getItem())) {
            this.inputStack = itemStack.copy();
            this.updateInput(container, itemStack);
        }
    }

    private void updateInput(Container input, ItemStack stack) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.availableRecipes = this.world.getRecipeManager().getRecipesFor(ModRecipeType.ARMS_STATION, new SingleRecipeInput(stack), this.world);
            System.out.println("Recipes found for " + stack + ": " + this.availableRecipes.size());
        }
    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RecipeHolder<ArmorStationRecipe> recipeHolder = this.availableRecipes.get(this.selectedRecipe.get());
            ArmorStationRecipe recipe = recipeHolder.value();
            ItemStack result = recipe.assemble(new SingleRecipeInput(this.inputSlot.getItem()), this.world.registryAccess());
            if (result.isItemEnabled(this.world.enabledFeatures())) {
                this.output.setRecipeUsed(recipeHolder);
                this.outputSlot.set(result);
            } else {
                this.outputSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.set(ItemStack.EMPTY);
        }
        this.broadcastChanges();
    }

    @Override
    public MenuType<?> getType() {
        return ModScreenHandlerType.ARMS_STATION_SCREEN;
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.output && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasItem()) {
            ItemStack itemStack2 = slot2.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot2.onQuickCraft(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.world.getRecipeManager().getRecipeFor(ModRecipeType.ARMS_STATION, new SingleRecipeInput(itemStack2), this.world).isPresent()) {
                    if (!this.moveItemStackTo(itemStack2, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 2 && slot < 29) {
                    if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 29 && slot < 38) {
                    if (!this.moveItemStackTo(itemStack2, 2, 29, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }
            if (itemStack2.isEmpty()) {
                slot2.set(ItemStack.EMPTY);
            }
            slot2.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot2.onTake(player, itemStack2);
            this.broadcastChanges();
        }
        return itemStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.output.removeItemNoUpdate(1);
        this.context.execute((world, pos) -> this.clearContainer(player, this.input));
    }
}