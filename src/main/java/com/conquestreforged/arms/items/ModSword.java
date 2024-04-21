package com.conquestreforged.arms.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModSword extends SwordItem {

    private final double range;
    private final double knockback;
    private final AttackStyleEnum attackStyle;
    private final String toolTipName;
    private final int linesAmt;
    private final float speed;

    public ModSword(ToolMaterial tier, int dmg, float speed, double range, double knockback, AttackStyleEnum attackStyle, Item.Settings props, String toolTipName, int linesAmt) {
        super(tier, dmg, speed, props);
        this.knockback = knockback;
        this.attackStyle = attackStyle;
        this.toolTipName = toolTipName;
        this.linesAmt = linesAmt;
        this.range = range;
        this.speed = speed;
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
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            NbtCompound nbt = stack.getNbt();
            NbtElement nbtelement = nbt.get("material");
            if (nbtelement != null) {
                switch (nbtelement.asString()) {
                    case "iron":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.getAttackDamage() + 3, EntityAttributeModifier.Operation.ADDITION));
                        break;
                    case "diamond":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.getAttackDamage() + 4, EntityAttributeModifier.Operation.ADDITION));
                        break;
                    case "netherite":
                        attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.getAttackDamage() + 5, EntityAttributeModifier.Operation.ADDITION));
                        break;

                }
            } else {
                attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "attribute.name.generic.attack_damage", this.getAttackDamage(), EntityAttributeModifier.Operation.ADDITION));
            }
            attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", this.speed, EntityAttributeModifier.Operation.ADDITION));
        }
        return attributeModifiers;
    }
}
