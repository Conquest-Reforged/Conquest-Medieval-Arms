package com.conquestreforged.arms.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModShield extends ShieldItem {
    private final String toolTipName;
    private final int linesAmt;

    public ModShield(Properties props, String name, Integer linesAmt) {
        super(props);
        this.toolTipName = name;
        this.linesAmt = linesAmt;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        for (int i = 1; i <= linesAmt; i++) {
            tooltip.add(Component.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }
}
