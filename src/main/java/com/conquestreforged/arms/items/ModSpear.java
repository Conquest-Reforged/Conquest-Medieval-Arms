package com.conquestreforged.arms.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModSpear extends TieredItem {

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private float spearLength;
    private int dmg;
    private float speed;
    private final int linesAmt;
    private final String toolTipName;

    public ModSpear(Properties props, String toolTipName, float spearLength, Tier tier, int dmg, float speed, int linesAmt) {
        super(tier, props);
        this.spearLength = spearLength;
        this.dmg = dmg;
        this.speed = speed;
        this.linesAmt = linesAmt;
        this.toolTipName = toolTipName;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", dmg, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double) speed, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();

    }

    public float getSpearLength() {
        return spearLength;
    }



    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(equipmentSlot);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
        for (int i = 1; i <= linesAmt; i++) {
            pTooltip.add(new TranslatableComponent("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }
}
