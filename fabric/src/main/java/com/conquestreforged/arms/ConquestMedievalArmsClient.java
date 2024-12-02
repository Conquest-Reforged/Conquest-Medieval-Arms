package com.conquestreforged.arms;


import com.conquestreforged.arms.screens.ArmorStationScreen;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import com.conquestreforged.arms.util.ModItemProperties;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;

public class ConquestMedievalArmsClient implements ClientModInitializer {
    public static final String MOD_ID = "conquest_armory";

    public ConquestMedievalArmsClient() {
    }

    @Override
    public void onInitializeClient() {
        ModItemProperties.addCustomItemProperties();
        HandledScreens.register(ModScreenHandlerType.ARMS_STATION_SCREEN, ArmorStationScreen::new);
        Registries.ITEM.stream().filter(block -> Registries.ITEM.getId(block).getNamespace().equals("conquest_armory")).forEach(item -> {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
                entries.add(item);
            });
        });
    }
}
