package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeType {
    public static RecipeType<ArmorStationRecipe> ARMS_STATION;

    private static <T extends Recipe<?>> RecipeType<T> registerRecipe(final String id) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(ConquestMedievalArms.MOD_ID, id), new RecipeType<T>(){
            public String toString() {
                return id;
            }
        });
    }

    public static void register() {
        ARMS_STATION = registerRecipe("arms_station");
    }
}