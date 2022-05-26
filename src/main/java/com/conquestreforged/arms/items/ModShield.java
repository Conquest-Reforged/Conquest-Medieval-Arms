package com.conquestreforged.arms.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

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
    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
        for (int i = 1; i <= linesAmt; i++) {
            pTooltip.add(new TranslatableComponent("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }
}
