package com.conquestreforged.arms.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModRecipes {

    public static final RecipeSerializer<ArmorStationRecipe> ARMS_STATION_SERIALIZER =
            register("arms_station", ArmorStationRecipe.Serializer.INSTANCE);

    private static <R extends Recipe<?>, T extends RecipeSerializer<R>> T register(String name, T recipe) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MOD_ID, name), recipe);
    }
}
