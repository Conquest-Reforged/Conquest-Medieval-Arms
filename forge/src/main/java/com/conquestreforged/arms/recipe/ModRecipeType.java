package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeType {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ConquestMedievalArms.MOD_ID);
    public static final RegistryObject<RecipeType<ArmorStationRecipe>> ARMS_STATION =
            RECIPE_TYPES.register("arms_station", () -> new RecipeType<ArmorStationRecipe>() {
                public String toString() {
                    return "arms_station";
                }
            });

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}