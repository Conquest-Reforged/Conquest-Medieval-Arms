package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModArmorModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;

public class ModArmorRenderer extends GeoArmorRenderer<ArmorModelItem> {
    public ModArmorRenderer() {
        super(new ModArmorModel());
    }
}
