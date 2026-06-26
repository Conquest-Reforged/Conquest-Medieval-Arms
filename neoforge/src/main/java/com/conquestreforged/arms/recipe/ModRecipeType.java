package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeType {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, ConquestMedievalArms.MOD_ID);
    public static RecipeType<ArmorStationRecipe> ARMS_STATION = registerRecipe("arms_station");;

    private static <T extends Recipe<?>> RecipeType<T> registerRecipe(final String id) {
        RecipeType recipeType = new RecipeType<ArmorStationRecipe>() {
            public String toString() {
                return "arms_station";
            }
        };
        RECIPE_TYPES.register(id, () -> recipeType);
        return recipeType;
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}