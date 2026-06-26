package com.conquestreforged.arms.items.armor;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class ArmorModelDispatcher {

    private static final AzCommand EQUIP_COMMAND = AzCommand.create(
            "base_controller",
            "equipping",
            AzPlayBehaviors.LOOP
    );

    public void equip(Entity entity, ItemStack itemStack) {
        EQUIP_COMMAND.sendForItem(entity, itemStack);
    }
}