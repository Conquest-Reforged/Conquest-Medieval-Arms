package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.screens.ArmorStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModScreenHandlerType {
    public static ScreenHandlerType<ArmorStationScreenHandler> ARMS_STATION_SCREEN;

    private static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandler(String id, ExtendedScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, id), new ScreenHandlerType<>(factory, FeatureFlags.DEFAULT_ENABLED_FEATURES));
    }

    public static void register() {
        ARMS_STATION_SCREEN = registerScreenHandler("arms_station", ArmorStationScreenHandler::new);
    }
}
