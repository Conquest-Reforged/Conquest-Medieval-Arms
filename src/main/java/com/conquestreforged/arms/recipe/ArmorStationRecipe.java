package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.init.BlockInit;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ArmorStationRecipe extends SingleItemRecipe {
    public ArmorStationRecipe(Identifier id, String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeType.ARMS_STATION, ModRecipeSerializer.ARMS_STATION, id, group, ingredient, result);
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.input.test(inventory.getStack(0));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockInit.ARMS_STATION_BLOCK);
    }

    //Suppress warnings being logged due to MC not knowing into which category to put these recipes
    //Armor Station doesn't use the recipe book, regardless
    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        ItemStack resultItem = this.output.copy();
        ItemStack inputItemStack = inventory.getStack(0);
        Item inputItem = inputItemStack.getItem();
        NbtCompound nbt = inputItemStack.getNbt();

        //copy over existing NBT (eg: trims, enchants, renames)
        resultItem.setNbt(nbt.copy());

        //check material of input item and add it as NBT to be read elsewhere
        if (inputItem.getName().toString().contains("iron")) {
            resultItem.getOrCreateNbt().putString("material", "iron");
        }
        else if (inputItem.getName().toString().contains("netherite")) {
            resultItem.getOrCreateNbt().putString("material", "netherite");
        }
        else if (inputItem.getName().toString().contains("diamond")) {
            resultItem.getOrCreateNbt().putString("material", "diamond");
        }

        return resultItem;
    }
}