package com.conquestreforged.arms.items.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ArmorModelItem extends GenericArmorItem {

    public final Holder<ArmorMaterial> customMaterial;
    public final ArmorModelDispatcher dispatcher;


    public ArmorModelItem(Holder<ArmorMaterial> material, Type type, Properties props,
                          String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, type, props, armorTexture, cloth, mail, plate);
        this.customMaterial = material;
        this.dispatcher = new ArmorModelDispatcher();

    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> swapWithEquipmentSlot(
            Item item,
            Level level,
            Player player,
            InteractionHand hand
    ) {
        var result = super.swapWithEquipmentSlot(item, level, player, hand);

        if (!level.isClientSide) {
            var slot = getEquipmentSlot();
            var itemStack = player.getItemBySlot(slot);
            // This is where you now trigger an animation to play
            dispatcher.equip(player, itemStack);
        }

        return result;
    }

//    // Remove this override entirely if you have no equip animation to trigger.
//    @Override
//    public @NotNull InteractionResultHolder<ItemStack> swapWithEquipmentSlot(
//            Item item, Level level, LivingEntity entity, InteractionHand hand) {
//        var result = super.swapWithEquipmentSlot(item, level, entity, hand);
//        if (!level.isClientSide) {
//            dispatcher.equip(entity, entity.getItemBySlot(getEquipmentSlot()));
//        }
//        return result;
//    }
}