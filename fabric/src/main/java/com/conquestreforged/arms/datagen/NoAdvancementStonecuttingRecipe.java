package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import com.conquestreforged.arms.recipe.ModRecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class NoAdvancementStonecuttingRecipe extends SingleItemRecipe {
    public NoAdvancementStonecuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeType.ARMS_STATION, ModRecipeSerializer.ARMS_STATION, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput recipeInput, Level level) {
        return false;
    }
}