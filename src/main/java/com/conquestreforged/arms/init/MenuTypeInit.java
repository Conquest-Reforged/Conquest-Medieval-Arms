package com.conquestreforged.arms.init;

import com.conquestreforged.arms.screens.ArmorStationMenu;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class MenuTypeInit {
    public static final ScreenHandlerType<ArmorStationMenu> ARMS_STATION_MENU = register("arms_station_menu",
            new ScreenHandlerType<>(ArmorStationMenu::new, FeatureSet.empty()));

    private static <SH extends ScreenHandler> ScreenHandlerType<SH> register(String name, ScreenHandlerType<SH> type) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, name), type);
    }

    static void init() {}
}
