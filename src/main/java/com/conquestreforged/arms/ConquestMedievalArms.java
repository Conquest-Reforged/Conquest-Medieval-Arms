package com.conquestreforged.arms;


import com.conquestreforged.arms.events.AttackEntityHandler;
import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import com.conquestreforged.arms.recipe.ModRecipeType;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConquestMedievalArms implements ModInitializer {
    public static final String MOD_ID = "conq_medieval_arms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemInit.registerModItems();
        BlockInit.registerModBlocks();
        ModRecipeType.register();
        ModRecipeSerializer.register();
        ModScreenHandlerType.register();
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
