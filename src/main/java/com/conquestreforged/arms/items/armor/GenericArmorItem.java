package com.conquestreforged.arms.items.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.List;
import java.util.UUID;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

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
    private ArmorMaterial nbtMaterial;

    public GenericArmorItem(ArmorMaterial material, ArmorItem.Type equipmentSlot, Item.Settings props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, equipmentSlot, props);
        this.armorTexture = armorTexture;
        this.cloth = cloth;
        this.mail = mail;
        this.plate = plate;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        NbtElement nbtelement = nbt.get("material");
        if (nbtelement != null) {
            switch (nbtelement.asString()) {
                case "iron":
                    tooltip.add(Text.translatable("\u00A7eMaterial: Iron\u00A7r"));
                    break;
                case "diamond":
                    tooltip.add(Text.translatable("\u00A7eMaterial: Diamond\u00A7r"));
                    break;
                case "netherite":
                    tooltip.add(Text.translatable("\u00A7eMaterial: Netherite\u00A7r"));
                    break;

            }
        }

        //for (int i = 1; i <= linesAmt; i++) {
        //    tooltip.add(Text.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        //}
    }

    @Override
    public int getEnchantability() {
        if (nbtMaterial != null) {
            return nbtMaterial.getEnchantability();
        } else {
            return super.getEnchantability();
        }
    }

    @Override
    public ArmorMaterial getMaterial() {
        if (nbtMaterial != null) {
            return nbtMaterial;
        } else {
            return super.getMaterial();
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        if (nbtMaterial != null) {
            return nbtMaterial.getRepairIngredient().test(ingredient);
        } else {
            return super.canRepair(stack, ingredient);
        }
    }



    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers = HashMultimap.create();
        if (slot == this.type.getEquipmentSlot()) {
            NbtCompound nbt = stack.getNbt();
            NbtElement nbtelement = nbt.get("material");
            UUID uUID = (UUID)MODIFIERS.get(type);
            if (nbtelement != null) {
                switch (nbtelement.asString()) {
                    case "iron":
                        attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", ArmorMaterials.IRON.getProtection(type), EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ArmorMaterials.IRON;
                        break;
                    case "diamond":
                        attributeModifiers.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness", 2, EntityAttributeModifier.Operation.ADDITION));
                        attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", ArmorMaterials.DIAMOND.getProtection(type), EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ArmorMaterials.DIAMOND;
                        break;
                    case "netherite":
                        attributeModifiers.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uUID, "Armor knockback resistance", 0.1, EntityAttributeModifier.Operation.ADDITION));
                        attributeModifiers.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness", 3, EntityAttributeModifier.Operation.ADDITION));
                        attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", ArmorMaterials.NETHERITE.getProtection(type), EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ArmorMaterials.NETHERITE;
                        break;

                }
            } else {
                attributeModifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", getProtection(), EntityAttributeModifier.Operation.ADDITION));
            }
        }
        return attributeModifiers;
    }

    public String getArmorTexture() {
        return armorTexture;
    }
}
