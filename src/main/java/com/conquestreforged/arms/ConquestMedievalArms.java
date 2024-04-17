package com.conquestreforged.arms;


import com.conquestreforged.arms.events.AttackEntityHandler;
import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.init.MenuTypeInit;
import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConquestMedievalArms implements ModInitializer {
    public static final String MOD_ID = "conq_medieval_arms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemInit.registerModItems();
        BlockInit.registerModBlocks();
        Registry.register(Registries.RECIPE_TYPE, ArmorStationRecipe.Type.ID, ArmorStationRecipe.Type.INSTANCE);
        HandledScreens.register(MenuTypeInit.ARMS_STATION_MENU, ArmorStationScreen::new);
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
