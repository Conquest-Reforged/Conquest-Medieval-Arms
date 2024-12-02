package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializer {
    public static RecipeSerializer<ArmorStationRecipe> ARMS_STATION;

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ConquestMedievalArms.MOD_ID, id), serializer);
    }

    public static void register() {
        ARMS_STATION = registerSerializer("arms_station", new SingleItemRecipe.Serializer<>(ArmorStationRecipe::new));
    }
}