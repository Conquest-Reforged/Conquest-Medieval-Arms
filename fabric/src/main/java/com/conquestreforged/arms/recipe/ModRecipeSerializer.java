package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializer {
    public static RecipeSerializer<ArmorStationRecipe> ARMS_STATION;

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(ConquestMedievalArms.MOD_ID, id), serializer);
    }

    public static void register() {
        ARMS_STATION = registerSerializer("arms_station", new SingleItemRecipe.Serializer<>(ArmorStationRecipe::new));
    }
}