package com.conquestreforged.arms.events;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (world instanceof ServerWorld && !player.isSpectator()) {
            if (entity instanceof LivingEntity) {
                ItemStack stack = player.getMainHandStack();
                if (stack.isIn(ItemTags.SWORDS)) {
                    //String material = stack.getNbt().getString("material");
                    int maxdmg = stack.getMaxDamage();
                    float dmg = stack.getDamage();
                    float dmgPercentage = ((maxdmg - dmg) / maxdmg);
                    float damageAmount = ((float) (player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)) * dmgPercentage);
                    entity.damage(world.getDamageSources().playerAttack(player), damageAmount);
                    player.sendMessage(Text.literal( String.valueOf(damageAmount)));
                    stack.damage(1, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                    return ActionResult.SUCCESS;
                }
            }
        }

        return ActionResult.PASS;
    }
}
