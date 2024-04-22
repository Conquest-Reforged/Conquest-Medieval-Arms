package com.conquestreforged.arms.init.builders;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.AttackStyleEnum;
import com.conquestreforged.arms.items.ModAxe;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.ModSword;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import net.minecraft.item.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemBuilders {
    public static List<Item> registerAxeSet(String name, int damage, float speed, double rangeMod,
                                            double knockback, AttackStyleEnum attackStyle, Item.Settings props, List<ToolMaterial> tiers, Integer linesAmt) {
        List<Item> axeList = new ArrayList<>();

        {
            {
                ItemInit.registerItem(name, new ModAxe(ToolMaterials.IRON, damage, speed, rangeMod, knockback, attackStyle, props, name, linesAmt));
            }
        };
        ItemInit.dataGenItemModels.addAll(axeList);
        ItemInit.dataGenItemRecipes.addAll(axeList);
        return axeList;
    }

    public static List<Item> registerSwordSet(String name, int dmg, float spd, double rangeMod, double knockback, AttackStyleEnum attackStyle, Item.Settings props,
                                                              List<ToolMaterial> tiers, Integer linesAmt) {
        List<Item> swordsList = new ArrayList<>();

        {
            ItemInit.registerItem(name, new ModSword(ToolMaterials.IRON, dmg, spd, rangeMod, knockback, attackStyle, props, name, linesAmt));
        };
        ItemInit.dataGenItemModels.addAll(swordsList);
        ItemInit.dataGenItemRecipes.addAll(swordsList);
        return swordsList;
    }

    public static List<Item> registerLongWepSet(String name, double length, double knockback, AttackStyleEnum attackStyle, int dmg, float spd, Item.Settings props,
                                                              List<ToolMaterial> tiers, Integer linesAmt) {
        List<Item> longWepList = new ArrayList<>();

        {
            ItemInit.registerItem(name, new ModSpear(props.maxDamage(ToolMaterials.IRON.getDurability()), name, length, knockback, attackStyle, ToolMaterials.IRON, dmg, spd, linesAmt));
        };
        //ItemInit.dataGenItemModels.addAll(longWepList);
        //ItemInit.dataGenItemRecipes.addAll(longWepList);
        return longWepList;
    }

    private static String getTierItemPrefix(ToolMaterial tier) {
        if (ToolMaterials.DIAMOND.equals(tier)) {
            return "refined_";
        } else if (ToolMaterials.NETHERITE.equals(tier)) {
            return "exquisite_";
        } else {
            return "";
        }
    }

    public static <T extends Item> Item registerTierlessWeapon(String name, Class<T> type, Item.Settings props, Integer linesAmt) {
        Item item = null;
        try {
            item = type.getConstructor(Item.Settings.class, String.class, Integer.class)
                    .newInstance(props, name, linesAmt);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        ItemInit.registerItem(name, item);
        ItemInit.dataGenItemModels.add(item);
        ItemInit.dataGenItemRecipes.add(item);
        return item;
    }

    public static List<Item> registerArmorModelMats(String name, Item.Settings props, ArmorItem.Type slot, Class<? extends GenericArmorItem> itemClass, List<ArmorMaterial> armorMaterials, float cloth, float mail, float plate) {
        List<Item> armorsList = new ArrayList<>();

        armorMaterials.forEach(armorMaterial -> {
            GenericArmorItem item = null;
            switch (armorMaterial.getName()) {
                case "bronze":
                case "quilt":
                case "cloth":
                case "leather":
                case "iron":
                    try {
                        item = itemClass.getConstructor(ArmorMaterial.class, ArmorItem.Type.class, Item.Settings.class, String.class, Float.class, Float.class, Float.class)
                                .newInstance(armorMaterial, slot, props, constructArmorModelTexPath(name, false), cloth, mail, plate);
                        ItemInit.registerItem(name, item);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });
        ItemInit.dataGenItemModels.addAll(armorsList);
        ItemInit.dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }

    private static String constructArmorModelTexPath(String textureName, boolean isPants) {
        String path = MOD_ID + ":" + "textures/models/armor/";
        return path + textureName + ".png";
    }

}
