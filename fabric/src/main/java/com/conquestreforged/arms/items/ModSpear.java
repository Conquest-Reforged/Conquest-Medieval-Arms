package com.conquestreforged.arms.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModSpear extends TieredItem {

    private double range;
    private final double knockback;
    private final AttackStyleEnum attackStyle;
    private int dmg;
    private float speed;
    private final int linesAmt;
    private final String toolTipName;
    private Tiers nbtMaterial;


    public ModSpear(Item.Properties props, String toolTipName, double range, double knockback, AttackStyleEnum attackStyle, Tier tier, int dmg, float speed, int linesAmt) {
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
    public int getEnchantmentValue() {
        if (nbtMaterial != null) {
            return nbtMaterial.getEnchantmentValue();
        } else {
            return super.getEnchantmentValue();
        }
    }

    @Override
    public Tier getTier() {
        if (nbtMaterial != null) {
            return nbtMaterial;
        } else {
            return super.getTier();
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        if (nbtMaterial != null) {
            return nbtMaterial.getRepairIngredient().test(ingredient);
        } else {
            return super.isValidRepairItem(stack, ingredient);
        }
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

        for (int i = 1; i <= linesAmt; i++) {
            tooltip.add(Component.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }

    public double getRange() {
        return range + 3.0d;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        float attackDamage = this.getTier().getAttackDamageBonus();
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID,
                                attackDamage, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID,
                                this.speed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .build();
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
