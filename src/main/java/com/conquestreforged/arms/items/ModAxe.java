package com.conquestreforged.arms.items;

import com.conquestreforged.arms.util.AttributeUUID;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModAxe extends AxeItem {

    private final double range;
    private final double knockback;
    private final AttackStyleEnum attackStyle;
    private final String toolTipName;
    private final int linesAmt;

    public ModAxe(ToolMaterial tier, float dmg, float speed, double range, double knockback, AttackStyleEnum attackStyle, Item.Settings props, String toolTipName, int linesAmt) {
        super(tier, dmg, speed, props);
        this.knockback = knockback;
        this.toolTipName = toolTipName;
        this.linesAmt = linesAmt;
        this.attackStyle = attackStyle;
        this.range = range;
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
}
