package com.conquestreforged.arms.items;

import com.conquestreforged.arms.util.AttributeUUID;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        for (int i = 1; i <= linesAmt; i++) {
            tooltip.add(Text.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }

    public double getRange() {
        return range + 3.0d;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers = super.getAttributeModifiers(slot);
        //attributeModifiers.put(ForgeMod.ATTACK_RANGE.get(), new EntityAttributeModifier(AttributeUUID.ATK_RNG_UUID, "Attack Reach modifier", range, EntityAttributeModifier.Operation.ADDITION));
        //attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier(AttributeUUID.ATTACK_KNOCKBACK_UUID, "Knockback modifier", this.knockback, EntityAttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(stack, slot);
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
