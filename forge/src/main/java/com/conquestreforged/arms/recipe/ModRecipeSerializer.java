package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ConquestMedievalArms.MOD_ID);

    public static RegistryObject<RecipeSerializer<ArmorStationRecipe>> ARMS_STATION = SERIALIZERS.register("arms_station", () -> new SingleItemRecipe.Serializer<>(ArmorStationRecipe::new));

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}