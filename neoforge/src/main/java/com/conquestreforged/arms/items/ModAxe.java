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

public class ModAxe extends AxeItem {

    private final double range;
    private final double knockback;
    private final AttackStyleEnum attackStyle;
    private final String toolTipName;
    private final int linesAmt;
    private final float speed;
    private Tier nbtMaterial;

    public ModAxe(Tier tier, float dmg, float speed, double range, double knockback, AttackStyleEnum attackStyle, Item.Properties props, String toolTipName, int linesAmt) {
        super(tier, props);
        this.knockback = knockback;
        this.toolTipName = toolTipName;
        this.linesAmt = linesAmt;
        this.attackStyle = attackStyle;
        this.range = range;
        this.speed = speed;
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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltip, TooltipFlag flag) {
        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            String material = customData.copyTag().getString("material");
            switch (material) {
                case "iron"      -> tooltip.add(Component.translatable("\u00A7eMaterial: Iron\u00A7r"));
                case "diamond"   -> tooltip.add(Component.translatable("\u00A7eMaterial: Diamond\u00A7r"));
                case "netherite" -> tooltip.add(Component.translatable("\u00A7eMaterial: Netherite\u00A7r"));
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
        // Fallback (no material component): base AxeItem damage + our speed.
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

}
