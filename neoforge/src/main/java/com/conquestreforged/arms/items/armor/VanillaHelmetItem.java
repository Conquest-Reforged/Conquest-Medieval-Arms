package com.conquestreforged.arms.items.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;

public class VanillaHelmetItem extends GenericArmorItem {

    public final Holder<ArmorMaterial> customMaterial;

    public VanillaHelmetItem(Holder<ArmorMaterial> material, Type type, Properties props,
                             String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, type, props, armorTexture, cloth, mail, plate);
        this.customMaterial = material;
    }
}