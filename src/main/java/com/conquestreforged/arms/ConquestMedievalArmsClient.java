package com.conquestreforged.arms;


import com.conquestreforged.arms.init.MenuTypeInit;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import com.conquestreforged.arms.util.ModItemProperties;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ConquestMedievalArmsClient implements ClientModInitializer {
    public static final String MOD_ID = "conq_medieval_arms";

    public ConquestMedievalArmsClient() {
    }

    @Override
    public void onInitializeClient() {
        ModItemProperties.addCustomItemProperties();
        //HandledScreens.register(MenuTypeInit.ARMS_STATION_MENU, ArmorStationScreen::new);
    }
}
