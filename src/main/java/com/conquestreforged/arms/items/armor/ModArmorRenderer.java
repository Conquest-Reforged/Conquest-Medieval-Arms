package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModArmorModel;
import software.bernie.example.item.GeckoArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ModArmorRenderer extends GeoArmorRenderer<ArmorModelItem> {
    public ModArmorRenderer() {
        super(new ModArmorModel()); // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
}
