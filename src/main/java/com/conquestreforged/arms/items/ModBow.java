package com.conquestreforged.arms.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModBow extends BowItem {
    private final String toolTipname;
    private final int linesAmt;

    public ModBow(Properties props, String name, Integer linesAmt) {
        super(props);
        this.toolTipname = name;
        this.linesAmt = linesAmt;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> pTooltip, TooltipFlag pFlag) {
        for (int i = 1; i <= linesAmt; i++) {
            pTooltip.add(new TranslatableComponent("tooltip." + MOD_ID + ".item." + toolTipname + i));
        }
    }
}
