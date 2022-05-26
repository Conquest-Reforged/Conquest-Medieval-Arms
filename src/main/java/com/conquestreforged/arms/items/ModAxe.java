package com.conquestreforged.arms.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModAxe extends AxeItem {
    private final String toolTipName;
    private final int linesAmt;

    public ModAxe(Tier tier, float dmg, float speed, Properties props, String toolTipName, int linesAmt) {
        super(tier, dmg, speed, props);
        this.toolTipName = toolTipName;
        this.linesAmt = linesAmt;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
        for (int i = 1; i <= linesAmt; i++) {
            pTooltip.add(new TranslatableComponent("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }
}
