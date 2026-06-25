package com.conquestreforged.arms.items.armor;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;

import java.util.EnumMap;
import java.util.List;
import java.util.UUID;

public class GenericArmorItem extends ArmorItem {

    //Private in ArmorItem so we recreate the modifier UUIDs here
    private static final EnumMap MODIFIERS = Util.make(new EnumMap(Type.class), (uuidMap) -> {
        uuidMap.put(Type.BOOTS, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        uuidMap.put(Type.LEGGINGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        uuidMap.put(Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        uuidMap.put(Type.HELMET, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    });
    private String armorTexture;
    private float cloth;
    private float mail;
    private float plate;
    private Holder<ArmorMaterial> nbtMaterial;

    public GenericArmorItem(Holder<ArmorMaterial> material, Type equipmentSlot, Properties props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, equipmentSlot, props);
        this.armorTexture = armorTexture;
        this.cloth = cloth;
        this.mail = mail;
        this.plate = plate;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            switch (customData.copyTag().getString("material")) {
                case "iron":
                    tooltip.add(Component.translatable("\u00A7eMaterial: Iron\u00A7r"));
                    break;
                case "diamond":
                    tooltip.add(Component.translatable("\u00A7eMaterial: Diamond\u00A7r"));
                    break;
                case "netherite":
                    tooltip.add(Component.translatable("\u00A7eMaterial: Netherite\u00A7r"));
                    break;

            }
        }

        //for (int i = 1; i <= linesAmt; i++) {
        //    tooltip.add(Text.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        //}
    }

    @Override
    public int getEnchantmentValue() {
        if (nbtMaterial != null) {
            return nbtMaterial.value().enchantmentValue();
        } else {
            return super.getEnchantmentValue();
        }
    }

    @Override
    public Holder<ArmorMaterial> getMaterial() {
        if (nbtMaterial != null) {
            return nbtMaterial;
        } else {
            return super.getMaterial();
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        if (nbtMaterial != null) {
            return nbtMaterial.value().repairIngredient().get().test(ingredient);
        } else {
            return super.isValidRepairItem(stack, ingredient);
        }
    }

    public String getArmorTexture() {
        return armorTexture;
    }
}
