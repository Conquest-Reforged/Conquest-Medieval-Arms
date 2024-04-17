package com.conquestreforged.arms.items.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class GenericArmorItem extends ArmorItem {

    private String armorTexture;
    private float cloth;
    private float mail;
    private float plate;

    public GenericArmorItem(ArmorMaterial material, ArmorItem.Type equipmentSlot, Item.Settings props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, equipmentSlot, props);
        this.armorTexture = armorTexture;
        this.cloth = cloth;
        this.mail = mail;
        this.plate = plate;
    }

    public String getArmorTexture() {
        return armorTexture;
    }
}
