package com.conquestreforged.arms.events;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {

    @Override
    public InteractionResult interact(Player player, Level level, InteractionHand interactionHand, net.minecraft.world.entity.Entity entity, net.minecraft.world.phys.@Nullable EntityHitResult entityHitResult) {
        if (level instanceof ServerLevel && !player.isSpectator()) {
            if (entity instanceof LivingEntity) {
                ItemStack stack = player.getMainHandItem();
                if (stack.is(ItemTags.SWORDS)) {
                    //String material = stack.getNbt().getString("material");
                    int maxdmg = stack.getMaxDamage();
                    float dmg = stack.getDamageValue();
                    float dmgPercentage = ((maxdmg - dmg) / maxdmg);
                    float damageAmount = ((float) (player.getAttributeValue(Attributes.ATTACK_DAMAGE)) * dmgPercentage);
                    entity.hurt(level.damageSources().playerAttack(player), damageAmount);
                    player.sendSystemMessage(Component.literal( String.valueOf(damageAmount)));
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
