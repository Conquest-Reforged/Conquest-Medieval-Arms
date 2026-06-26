package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, ConquestMedievalArms.MOD_ID);

    public static RecipeSerializer<ArmorStationRecipe> ARMS_STATION = registerSerializer("arms_station");

    private static <T extends RecipeSerializer<?>> RecipeSerializer<ArmorStationRecipe> registerSerializer(String id) {
        SingleItemRecipe.Serializer serializer =  new SingleItemRecipe.Serializer<>(ArmorStationRecipe::new);

        SERIALIZERS.register(id, () -> serializer);
        return serializer;
    }


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}