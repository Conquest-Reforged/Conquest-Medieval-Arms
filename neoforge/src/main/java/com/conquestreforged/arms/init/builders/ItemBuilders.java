package com.conquestreforged.arms.init.builders;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.AttackStyleEnum;
import com.conquestreforged.arms.items.ModAxe;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.ModSword;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemBuilders {
    public static DeferredHolder<Item, ModAxe> registerAxeSet(String name, int damage, float speed,
                                                              double rangeMod, double knockback, AttackStyleEnum attackStyle,
                                                              Item.Properties props, List<Tier> tiers, Integer linesAmt) {
        return ItemInit.REGISTER.register(name,
                () -> new ModAxe(Tiers.IRON, damage, speed, rangeMod, knockback, attackStyle, props, name, linesAmt));
    }

    public static DeferredHolder<Item, ModSword> registerSwordSet(String name, int dmg, float spd,
                                                                  double rangeMod, double knockback, AttackStyleEnum attackStyle,
                                                                  Item.Properties props, List<Tier> tiers, Integer linesAmt) {
        return ItemInit.REGISTER.register(name,
                () -> new ModSword(Tiers.IRON, dmg, spd, rangeMod, knockback, attackStyle, props, name, linesAmt));
    }

    public static DeferredHolder<Item, ModSpear> registerLongWepSet(String name, double length,
                                                                    double knockback, AttackStyleEnum attackStyle, int dmg, float spd,
                                                                    Item.Properties props, List<Tier> tiers, Integer linesAmt) {
        return ItemInit.REGISTER.register(name,
                () -> new ModSpear(props.durability(Tiers.IRON.getUses()), name, length, knockback, attackStyle, Tiers.IRON, dmg, spd, linesAmt));
    }

    public static <T extends Item> DeferredHolder<Item, T> registerTierlessWeapon(
            String name, Class<T> type, Item.Properties props, Integer linesAmt) {
        return ItemInit.REGISTER.register(name, () -> {
            try {
                return type.getConstructor(Item.Properties.class, String.class, Integer.class)
                        .newInstance(props, name, linesAmt);
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate tierless weapon: " + name, e);
            }
        });
    }

    public static <T extends GenericArmorItem> DeferredHolder<Item, T> registerArmorModelMats(
            String name, Item.Properties props, ArmorItem.Type slot,
            Class<T> itemClass, Holder<ArmorMaterial> armorMaterials,
            float cloth, float mail, float plate) {
        return ItemInit.REGISTER.register(name, () -> {
            try {
                return itemClass.getConstructor(Holder.class, ArmorItem.Type.class, Item.Properties.class,
                                String.class, Float.class, Float.class, Float.class)
                        .newInstance(armorMaterials, slot, props,
                                constructArmorModelTexPath(name, false), cloth, mail, plate);
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate armor item: " + name, e);
            }
        });
    }

    private static String constructArmorModelTexPath(String textureName, boolean isPants) {
        String path = MOD_ID + ":" + "textures/models/armor/";
        return path + textureName + ".png";
    }

}
