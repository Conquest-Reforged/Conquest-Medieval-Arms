package com.conquestreforged.arms.util;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.items.ModBow;
import com.conquestreforged.arms.items.ModCrossbow;
import com.conquestreforged.arms.items.ModShield;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.stream.Collectors;

public class ModItemProperties {

    public static final Identifier HAS_PROP = new Identifier(ConquestMedievalArms.MOD_ID, "blocking");

    public static void addCustomItemProperties() {
        //Create properties for Shield items
        List<Item> shields = Registries.ITEM.stream()
                .filter(shield -> shield instanceof ModShield)
                .collect(Collectors.toList());
        shields.forEach(shield -> makeShield(shield));

        //Create properties for Bow Items
        List<Item> bows = Registries.ITEM.stream()
                .filter(bow -> bow instanceof ModBow)
                .collect(Collectors.toList());
        bows.forEach(bow -> makeBow(bow));

        //Create properties for Crossbow Items
        List<Item> xbows = Registries.ITEM.stream()
                .filter(xbow -> xbow instanceof ModCrossbow)
                .collect(Collectors.toList());
        xbows.forEach(xbow -> makeCrossbow(xbow));
    }

    private static void makeShield(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> {
            return p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getActiveItem() == p_174590_ ? 1.0F : 0.0F;
        });
    }

    private static void makeBow(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getActiveItem() != p_174635_ ? 0.0F : (float)(p_174635_.getMaxUseTime() - p_174637_.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(item, new Identifier("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getActiveItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }

    private static void makeCrossbow(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pull"), (p_174620_, p_174621_, p_174622_, p_174623_) -> {
            if (p_174622_ == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getMaxUseTime() - p_174622_.getItemUseTimeLeft()) / (float)CrossbowItem.getPullTime(p_174620_);
            }
        });
        ModelPredicateProviderRegistry.register(item, new Identifier("pulling"), (p_174615_, p_174616_, p_174617_, p_174618_) -> {
            return p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getActiveItem() == p_174615_ && !CrossbowItem.isCharged(p_174615_) ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(item, new Identifier("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return p_174612_ != null && CrossbowItem.isCharged(p_174610_) ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(item, new Identifier("firework"), (p_174605_, p_174606_, p_174607_, p_174608_) -> {
            return p_174607_ != null && CrossbowItem.isCharged(p_174605_) && CrossbowItem.hasProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}
