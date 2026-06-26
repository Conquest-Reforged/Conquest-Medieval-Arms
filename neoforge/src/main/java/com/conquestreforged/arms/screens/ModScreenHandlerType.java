package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModScreenHandlerType {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, ConquestMedievalArms.MOD_ID);
    public static MenuType<ArmorStationScreenHandler> ARMS_STATION_SCREEN = registerScreenHandler("arms_station", ArmorStationScreenHandler::new);

    private static <T extends AbstractContainerMenu> MenuType<T> registerScreenHandler(String id, MenuType.MenuSupplier<T> factory) {
        MenuType menutype = new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS);
        MENUS.register(id, () -> menutype);

        return menutype;
    }
}