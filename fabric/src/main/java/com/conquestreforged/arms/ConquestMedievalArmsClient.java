package com.conquestreforged.arms;


import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.ModArmorRenderer;
import com.conquestreforged.arms.items.armor.VanillaHelmetItem;
import com.conquestreforged.arms.items.armor.VanillaHelmetRenderer;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import com.conquestreforged.arms.util.ModItemProperties;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;

public class ConquestMedievalArmsClient implements ClientModInitializer {
    public static final String MOD_ID = "conquest_armory";

    public ConquestMedievalArmsClient() {
    }

    @Override
    public void onInitializeClient() {
        ModItemProperties.addCustomItemProperties();
        MenuScreens.register(ModScreenHandlerType.ARMS_STATION_SCREEN, ArmorStationScreen::new);
        BuiltInRegistries.ITEM.stream().filter(block -> BuiltInRegistries.ITEM.getKey(block).getNamespace().equals("conquest_armory")).forEach(item -> {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
                entries.accept(item);
            });
            if (item instanceof ArmorModelItem armorModelItem) {
                System.out.println("Found armor item: " + BuiltInRegistries.ITEM.getKey(item));

                switch (armorModelItem.getType()) {
                    case ArmorItem.Type.HELMET -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("helmet_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.CHESTPLATE -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("chestplate_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.LEGGINGS -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("leggings_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.BOOTS -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("boots_generic", armorModelItem.getArmorTexture()), armorModelItem);
                }
//                String geoName = switch (armorModelItem.getType()) {
//                    case ArmorItem.Type.HELMET -> "helmet_generic";
//                    case ArmorItem.Type.CHESTPLATE -> "chestplate_generic";
//                    case ArmorItem.Type.LEGGINGS -> "leggings_generic";
//                    case ArmorItem.Type.BOOTS -> "boots_generic";
//                    default -> "unknown";
//                };
//                System.out.println("Registering renderer for: " + BuiltInRegistries.ITEM.getKey(armorModelItem)
//                        + " | geo: conquest_armory:geo/armor/" + geoName + ".geo.json"
//                        + " | texture: " + armorModelItem.getArmorTexture());
            }
            if (item instanceof VanillaHelmetItem vanillaHelmetItem) {
                if (vanillaHelmetItem.getType() == ArmorItem.Type.HELMET) {
                    AzArmorRendererRegistry.register(() -> new ModArmorRenderer("helmet_vanilla", vanillaHelmetItem.getArmorTexture()), vanillaHelmetItem);
                }
            }
        });
    }
}
