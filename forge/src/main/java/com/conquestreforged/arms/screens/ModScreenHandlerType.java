package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModScreenHandlerType {
    public static final DeferredRegister<ScreenHandlerType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ConquestMedievalArms.MOD_ID);

    public static final RegistryObject<ScreenHandlerType<ArmorStationScreenHandler>> ARMS_STATION_SCREEN = registerScreenHandler("arms_station", ArmorStationScreenHandler::new);

    private static <T extends ScreenHandler> RegistryObject<ScreenHandlerType<T>> registerScreenHandler(String id, ScreenHandlerType.Factory<T> factory) {
        return MENUS.register(id, () -> new ScreenHandlerType<>(factory, FeatureFlags.DEFAULT_ENABLED_FEATURES));
    }
}
