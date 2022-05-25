package com.conquestreforged.arms.events;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConquestMedievalArms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, ArmorStationRecipe.Type.ID, ArmorStationRecipe.Type.INSTANCE);
    }
}
