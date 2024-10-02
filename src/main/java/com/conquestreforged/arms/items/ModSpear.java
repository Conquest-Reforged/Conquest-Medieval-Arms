package com.conquestreforged.arms.items;

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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModSpear extends ToolItem implements Vanishable {

    private double range;
    private final double knockback;
    private final AttackStyleEnum attackStyle;
    private int dmg;
    private float speed;
    private final int linesAmt;
    private final String toolTipName;
    private ToolMaterials nbtMaterial;


    public ModSpear(Item.Settings props, String toolTipName, double range, double knockback, AttackStyleEnum attackStyle, ToolMaterial tier, int dmg, float speed, int linesAmt) {
        super(tier, props);
        this.range = range;
        this.knockback = knockback;
        this.attackStyle = attackStyle;
        this.dmg = dmg;
        this.speed = speed;
        this.linesAmt = linesAmt;
        this.toolTipName = toolTipName;
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
    public ToolMaterial getMaterial() {
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

        for (int i = 1; i <= linesAmt; i++) {
            tooltip.add(Text.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }

    public double getRange() {
        return range + 3.0d;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            NbtCompound nbt = stack.getNbt();
            NbtElement nbtelement = nbt.get("material");
            if (nbtelement != null) {
                switch (nbtelement.asString()) {
                    case "iron":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.dmg + 3, EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ToolMaterials.IRON;
                        break;
                    case "diamond":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.dmg + 4, EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ToolMaterials.DIAMOND;
                        break;
                    case "netherite":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.dmg + 5, EntityAttributeModifier.Operation.ADDITION));
                        this.nbtMaterial = ToolMaterials.NETHERITE;
                        break;

                }
            } else {
                attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.dmg, EntityAttributeModifier.Operation.ADDITION));
            }
            attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", this.speed, EntityAttributeModifier.Operation.ADDITION));
        }
        return attributeModifiers;
    }

    /*
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        p_43278_.hurtAndBreak(1, p_43280_, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
            p_43282_.hurtAndBreak(2, p_43286_, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }*/
}
