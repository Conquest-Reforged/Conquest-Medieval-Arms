package com.conquestreforged.arms.items;

import com.conquestreforged.arms.util.AttributeUUID;
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

    public ModSword(ToolMaterial tier, int dmg, float speed, double range, double knockback, AttackStyleEnum attackStyle, Item.Settings props, String toolTipName, int linesAmt) {
        super(tier, dmg, speed, props);
        this.knockback = knockback;
        this.attackStyle = attackStyle;
        this.toolTipName = toolTipName;
        this.linesAmt = linesAmt;
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
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND) {
            //builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier(AttributeUUID.ATTACK_KNOCKBACK_UUID, "Knockback modifier", this.knockback, EntityAttributeModifier.Operation.ADDITION));
        }
        return builder.build();
    }
}
