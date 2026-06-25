package com.conquestreforged.arms.screens;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModScreenHandlerType {
    public static MenuType<ArmorStationScreenHandler> ARMS_STATION_SCREEN;

    private static <T extends AbstractContainerMenu> MenuType<T> registerScreenHandler(String id, MenuType.MenuSupplier<T> factory) {
        return Registry.register(BuiltInRegistries.MENU, ResourceLocation.fromNamespaceAndPath(MOD_ID, id), new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void register() {
        ARMS_STATION_SCREEN = registerScreenHandler("arms_station", ArmorStationScreenHandler::new);
    }
}