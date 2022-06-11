package com.conquestreforged.arms.items;

import com.conquestreforged.arms.util.AttributeUUID;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModSpear extends TieredItem implements Vanishable {

    private final Lazy<Multimap<Attribute, AttributeModifier>> defaultModifiers;
    private double range;
    private int dmg;
    private float speed;
    private final int linesAmt;
    private final String toolTipName;

    public ModSpear(Properties props, String toolTipName, double range, Tier tier, int dmg, float speed, int linesAmt) {
        super(tier, props);
        this.range = range;
        this.dmg = dmg;
        this.speed = speed;
        this.linesAmt = linesAmt;
        this.toolTipName = toolTipName;
        defaultModifiers = Lazy.of(() -> {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", dmg, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double) speed, AttributeModifier.Operation.ADDITION));
            builder.put(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(AttributeUUID.ATK_RNG_UUID, "Attack Reach modifier", range, AttributeModifier.Operation.ADDITION));
            return builder.build();
        });
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(super.getAttributeModifiers(slot, stack));

        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers.get() : super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
        for (int i = 1; i <= linesAmt; i++) {
            pTooltip.add(new TranslatableComponent("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }

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
    }
}
