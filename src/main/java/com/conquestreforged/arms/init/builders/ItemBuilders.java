package com.conquestreforged.arms.init.builders;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.ModAxe;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.ModSword;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import com.conquestreforged.arms.items.armor.models.ModelGenericBoots;
import com.conquestreforged.arms.items.armor.models.ModelGenericChest;
import com.conquestreforged.arms.items.armor.models.ModelWingedHussarChest;
import com.conquestreforged.arms.items.armor.models.ModelGenericLegs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemBuilders {
    public static List<RegistryObject<Item>> registerAxeSet(String name, int damage, float speed, double rangeMod, Item.Properties props,
                                                            List<Tier> tiers, Integer linesAmt) {
        List<RegistryObject<Item>> axeList = new ArrayList<>();

        tiers.forEach(tier -> {
            if (Tiers.IRON.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register(name, () -> new ModAxe(tier, damage, speed, rangeMod, props, name, linesAmt)));
            } else if (Tiers.DIAMOND.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register("refined_" + name, () -> new ModAxe(tier, damage - 1, speed + 0.1F, rangeMod, props, name, linesAmt)));
            } else if (Tiers.NETHERITE.equals(tier)) {
                axeList.add(ItemInit.REGISTER.register("exquisite_" + name, () -> new ModAxe(tier, damage - 1, speed + 0.1F, rangeMod, props, name, linesAmt)));
            }
        });
        ItemInit.dataGenItemModels.addAll(axeList);
        ItemInit.dataGenItemRecipes.addAll(axeList);
        return axeList;
    }

    public static List<RegistryObject<Item>> registerSwordSet(String name, int dmg, float spd, double rangeMod, Item.Properties props,
                                                              List<Tier> tiers, Integer linesAmt) {
        List<RegistryObject<Item>> swordsList = new ArrayList<>();

        tiers.forEach(tier -> {
            swordsList.add(ItemInit.REGISTER.register(getTierItemPrefix(tier) + name, () ->
                    new ModSword(tier, dmg, spd, rangeMod, props, name, linesAmt)));
        });
        ItemInit.dataGenItemModels.addAll(swordsList);
        ItemInit.dataGenItemRecipes.addAll(swordsList);
        return swordsList;
    }

    public static List<RegistryObject<Item>> registerLongWepSet(String name, double length, int dmg, float spd, Item.Properties props,
                                                              List<Tier> tiers, Integer linesAmt) {
        List<RegistryObject<Item>> longWepList = new ArrayList<>();

        tiers.forEach(tier -> {
            longWepList.add(ItemInit.REGISTER.register(getTierItemPrefix(tier) + name, () ->
                    new ModSpear(props.durability(tier.getUses()), name, length, tier, dmg, spd, linesAmt)));
        });
        ItemInit.dataGenItemModels.addAll(longWepList);
        ItemInit.dataGenItemRecipes.addAll(longWepList);
        return longWepList;
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

    public static <T extends Item> RegistryObject<Item> registerTierlessWeapon(String name, Class<T> type, Item.Properties props, Integer linesAmt) {
        RegistryObject<Item> item = ItemInit.REGISTER.register(name, () ->
        {
            try {
                return type.getConstructor(Item.Properties.class, String.class, Integer.class)
                        .newInstance(props, name, linesAmt);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        });
        ItemInit.dataGenItemModels.add(item);
        ItemInit.dataGenItemRecipes.add(item);
        return item;
    }

    public static List<RegistryObject<Item>> registerArmorModelMats(String name, Item.Properties props, EquipmentSlot slot, Class modelClass, ModelLayerLocation layerLocation, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();
        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "bronze":
                case "iron":
                    armorsList.add(ItemInit.REGISTER.register(name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(name, false))));
                    break;
                case "diamond":
                    armorsList.add(ItemInit.REGISTER.register("refined_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(name, false))));
                    break;
                case "netherite":
                    armorsList.add(ItemInit.REGISTER.register("exquisite_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorModelTexPath(name, false))));
                    break;
            }
        });
        ItemInit.dataGenItemModels.addAll(armorsList);
        ItemInit.dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }

    public static List<RegistryObject<Item>> registerArmorModelSetMats(String nameHead, String nameBody, String nameLegs,
                                                                       String nameFeet, Item.Properties props, Class headModelClass, List<ModelLayerLocation> layerLocation, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();
        armorMaterials.forEach(armorMaterial -> {
            String prefix = "";
            switch (armorMaterial.getName()) {
                case "bronze":
                case "iron":
                    armorsList.addAll(registerArmorModelSet(nameHead, nameBody, nameLegs, nameFeet, props, headModelClass, layerLocation, armorMaterial));
                    break;
                case "diamond":
                    prefix = "refined_";
                    armorsList.addAll(registerArmorModelSet(prefix + nameHead, prefix + nameBody, prefix + nameLegs,prefix + nameFeet, props, headModelClass, layerLocation, armorMaterial));
                    break;
                case "netherite":
                    prefix = "exquisite_";
                    armorsList.addAll(registerArmorModelSet(prefix + nameHead, prefix + nameBody, prefix + nameLegs,prefix + nameFeet, props, headModelClass, layerLocation, armorMaterial));
                    break;
            }
        });
        ItemInit.dataGenItemModels.addAll(armorsList);
        ItemInit.dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }

    public static List<RegistryObject<Item>> registerArmorModelSet(String nameHead, String nameBody, String nameLegs,
                                                                   String nameFeet, Item.Properties props, Class modelclass, List<ModelLayerLocation> layerLocation, ArmorMaterial armorMaterial) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();
        armorsList.add(ItemInit.REGISTER.register(nameHead, () -> new ArmorModelItem(armorMaterial, EquipmentSlot.HEAD, props, modelclass, layerLocation.get(0), constructArmorTexPath(nameHead, false))));
        armorsList.add(ItemInit.REGISTER.register(nameBody, () -> new ArmorModelItem(armorMaterial, EquipmentSlot.CHEST, props, ModelGenericChest.class, layerLocation.get(1), constructArmorTexPath(nameBody, false))));
        armorsList.add(ItemInit.REGISTER.register(nameLegs, () -> new ArmorModelItem(armorMaterial, EquipmentSlot.LEGS, props, ModelGenericLegs.class, layerLocation.get(2), constructArmorTexPath(nameLegs, true))));
        armorsList.add(ItemInit.REGISTER.register(nameFeet, () -> new ArmorModelItem(armorMaterial, EquipmentSlot.FEET, props, ModelGenericBoots.class, layerLocation.get(3), constructArmorTexPath(nameFeet, false))));

        return armorsList;
    }


    public static List<RegistryObject<Item>> registerArmorSetMats(Item.Properties props, String texture, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();

        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "iron":
                    armorsList.addAll(registerArmorSet(props, texture, armorMaterial));
                    break;
                case "bronze":
                    armorsList.addAll(registerArmorSet(props, texture, armorMaterial));
                    break;
                case "diamond":
                    armorsList.addAll(registerArmorSet(props, "refined_" + texture, armorMaterial));
                    break;
                case "netherite":
                    armorsList.addAll(registerArmorSet(props, "exquisite_" + texture, armorMaterial));
                    break;
            }
        });
        return armorsList;
    }

    private static List<RegistryObject<Item>> registerArmorSet(Item.Properties props, String texture, ArmorMaterial armorMaterial) {
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
