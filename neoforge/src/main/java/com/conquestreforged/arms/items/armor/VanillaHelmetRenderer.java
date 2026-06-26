package com.conquestreforged.arms.items.armor;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class VanillaHelmetRenderer extends AzArmorRenderer {

    public VanillaHelmetRenderer(String geoPath, String texturePath) {
        super(AzArmorRendererConfig.builder(
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/" + geoPath + ".geo.json"),
                ResourceLocation.parse(texturePath)
        ).build());
    }
}