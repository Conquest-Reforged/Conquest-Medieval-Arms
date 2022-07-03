package com.conquestreforged.arms.items.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GenericArmorItem extends ArmorItem {

    private String armorTexture;
    private float cloth;
    private float mail;
    private float plate;

    public GenericArmorItem(ArmorMaterial material, EquipmentSlot equipmentSlot, Properties props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, equipmentSlot, props);
        this.armorTexture = armorTexture;
        this.cloth = cloth;
        this.mail = mail;
        this.plate = plate;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return armorTexture;
    }
}
