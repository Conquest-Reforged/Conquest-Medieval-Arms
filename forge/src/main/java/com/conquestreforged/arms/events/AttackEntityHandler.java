package com.conquestreforged.arms.events;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttackEntityHandler {

    @Subscribe
    public void attackEvent(LivingAttackEvent event) {
        DamageSource source = event.getSource();
        if (!(source.getAttacker() instanceof PlayerEntity player)) {
            return;
        }
        Entity damagedEntity = event.getEntity();
        {
            if (damagedEntity instanceof LivingEntity && source.getAttacker() instanceof PlayerEntity) {
                ItemStack stack = player.getMainHandStack();
                if (stack.isIn(ItemTags.SWORDS)) {
                    //String material = stack.getNbt().getString("material");
                    int maxdmg = stack.getMaxDamage();
                    float dmg = stack.getDamage();
                    float dmgPercentage = ((maxdmg - dmg) / maxdmg);
                    float damageAmount = ((float) (player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)) * dmgPercentage);
                    damagedEntity.damage(damagedEntity.getDamageSources().playerAttack(player), damageAmount);
                    player.sendMessage(Text.literal( String.valueOf(damageAmount)));
                    stack.damage(1, player, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
            }
        }
    }
}
