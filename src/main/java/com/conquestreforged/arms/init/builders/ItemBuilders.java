package com.conquestreforged.arms.init.builders;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemBuilders {
    public static List<RegistryObject<Item>> registerAxeSet(String name, int damage, float speed, Item.Properties props, List<Tier> tiers) {
        List<RegistryObject<Item>> axeList = new ArrayList<>();

        tiers.forEach(tier -> {
            if (Tiers.IRON.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register(name, () -> new AxeItem(tier, damage, speed, props)));
            } else if (Tiers.DIAMOND.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register("refined_" + name, () -> new AxeItem(tier, damage - 1, speed + 0.1F, props)));
            } else if (Tiers.NETHERITE.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register("exquisite_" + name, () -> new AxeItem(tier, damage - 1, speed + 0.1F, props)));
            }
        });
        ItemInit.dataGenItemModels.addAll(axeList);
        ItemInit.dataGenItemRecipes.addAll(axeList);
        return axeList;
    }

    public static List<RegistryObject<Item>> registerSwordSet(String name, int dmg, float spd, Item.Properties props, List<Tier> tiers) {
        List<RegistryObject<Item>> swordsList = new ArrayList<>();

        tiers.forEach(tier -> {
            swordsList.add(ItemInit.REGISTER.register(getTierItemPrefix(tier) + name, () ->
                    new SwordItem(tier, dmg, spd, props)));
        });
        ItemInit.dataGenItemModels.addAll(swordsList);
        ItemInit.dataGenItemRecipes.addAll(swordsList);
        return swordsList;
    }

    private static String getTierItemPrefix(Tier tier) {
        if (Tiers.DIAMOND.equals(tier)) {
            return "refined_";
        } else if (Tiers.NETHERITE.equals(tier)) {
            return "exquisite_";
        } else {
            return "";
        }
    }

    public static <T extends Item> RegistryObject<Item> registerTierlessWeapon(String name, Class<T> type, Integer linesAmt) {
        RegistryObject<Item> item = ItemInit.REGISTER.register(name, () ->
        {
            try {
                return type.getConstructor(Item.Properties.class, String.class, Integer.class)
                        .newInstance(ItemInit.genericCombatProps, name, linesAmt);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        });
        ItemInit.dataGenItemRecipes.add(item);
        return item;
    }

    public static List<RegistryObject<Item>> registerArmorModelMultiMaterials(String name, Item.Properties props, String texture, EquipmentSlot slot, Class modelClass, ModelLayerLocation layerLocation, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();
        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "iron":
                    armorsList.add(ItemInit.REGISTER.register(name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(texture, false))));
                    break;
                case "bronze":
                    armorsList.add(ItemInit.REGISTER.register(name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(texture, false))));
                    break;
                case "diamond":
                    armorsList.add(ItemInit.REGISTER.register("refined_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(texture, false))));
                    break;
                case "netherite":
                    armorsList.add(ItemInit.REGISTER.register("exquisite_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(texture, false))));
                    break;
            }
        });
        ItemInit.dataGenItemModels.addAll(armorsList);
        ItemInit.dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }


    public static List<RegistryObject<Item>> registerArmorSetMultiMaterials(Item.Properties props, String texture, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();

        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "iron":
                    armorsList.addAll(registerArmorsFullSet(props, texture, armorMaterial));
                    break;
                case "bronze":
                    armorsList.addAll(registerArmorsFullSet(props, texture, armorMaterial));
                    break;
                case "diamond":
                    armorsList.addAll(registerArmorsFullSet(props, "refined_" + texture, armorMaterial));
                    break;
                case "netherite":
                    armorsList.addAll(registerArmorsFullSet(props, "exquisite_" + texture, armorMaterial));
                    break;
            }
        });
        return armorsList;
    }

    private static List<RegistryObject<Item>> registerArmorsFullSet(Item.Properties props, String texture, ArmorMaterial armorMaterial) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();

        armorsList.add(ItemInit.REGISTER.register(texture + "_helmet", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.HEAD, props, constructArmorTexPath(texture, false))));
        armorsList.add(ItemInit.REGISTER.register(texture + "_chest", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.CHEST, props, constructArmorTexPath(texture, false))));
        armorsList.add(ItemInit.REGISTER.register(texture + "_legs", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.LEGS, props, constructArmorTexPath(texture, true))));
        armorsList.add(ItemInit.REGISTER.register(texture + "_boots", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.FEET, props, constructArmorTexPath(texture, false))));

        ItemInit.dataGenItemModels.addAll(armorsList);
        ItemInit.dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }

    private static String constructArmorTexPath(String textureName, boolean isPants) {
        String path = MOD_ID + ":" + "textures/models/armor/";

        if (isPants) {
            return path + textureName + "_layer_2.png";
        } else {
            return path + textureName + "_layer_1.png";
        }
    }

    private static String constructArmorModelTexPath(String textureName, boolean isPants) {
        String path = MOD_ID + ":" + "textures/models/armor/";
        return path + textureName + ".png";
    }

}
