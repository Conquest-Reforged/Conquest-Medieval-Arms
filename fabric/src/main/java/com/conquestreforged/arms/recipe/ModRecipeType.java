package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeType {
    public static RecipeType<ArmorStationRecipe> ARMS_STATION;

    private static <T extends Recipe<?>> RecipeType<T> registerRecipe(final String id) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(ConquestMedievalArms.MOD_ID, id), new RecipeType<T>(){
            public String toString() {
                return id;
            }
        });
    }

    public static void register() {
        ARMS_STATION = registerRecipe("arms_station");
    }
}