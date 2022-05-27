package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.EntityTypes;
import com.conquestreforged.arms.init.builders.ItemBuilders;
import com.conquestreforged.arms.items.*;
import com.conquestreforged.arms.items.armor.models.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemInit {

    //Here we store a list of our items that get automatically generated model files
    public static final List<RegistryObject<Item>> dataGenItemModels = new ArrayList<>();
    //Here we store a list of our items that get automatically generated recipe+advancement files
    public static final List<RegistryObject<Item>> dataGenItemRecipes = new ArrayList<>();

    public static final Item.Properties genericCombatProps = new Item.Properties()
            .tab(CreativeModeTab.TAB_COMBAT)
            .stacksTo(1)
            .durability(100);
    public static final List<ArmorMaterial> metalMaterials = new ArrayList<>(Arrays.asList(
            net.minecraft.world.item.ArmorMaterials.IRON,
            net.minecraft.world.item.ArmorMaterials.DIAMOND,
            net.minecraft.world.item.ArmorMaterials.NETHERITE
    ));
    public static final List<Tier> metalTiers = new ArrayList<>(Arrays.asList(
            Tiers.IRON,
            Tiers.DIAMOND,
            Tiers.NETHERITE
    ));

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);


    ////////////////--------------------------START REGISTRATION----------------------------------///////////////////
    public static final List<RegistryObject<Item>> CRUSADER_GREAT_HELM = ItemBuilders.registerArmorModelMats(
            "crusader_great_helm", genericCombatProps,
            EquipmentSlot.HEAD,
            ModelGenericHelmet.class, EntityClientInit.CRUSADER_HELM_LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_BOOTS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_boots", genericCombatProps,
            EquipmentSlot.FEET,
            ModelGenericBoots.class, ModelGenericBoots.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_CHEST = ItemBuilders.registerArmorModelMats(
            "winged_hussar_chestplate", genericCombatProps,
            EquipmentSlot.CHEST,
            ModelWingedHussarChest.class, ModelWingedHussarChest.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_LEGS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_pants", genericCombatProps,
            EquipmentSlot.LEGS,
            ModelGenericLegs.class, ModelGenericLegs.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_HELMET =ItemBuilders.registerArmorModelMats(
            "winged_hussar_helmet", genericCombatProps,
            EquipmentSlot.HEAD,
            ModelWingedHussarHelmet.class, ModelWingedHussarHelmet.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> TEUTONIC_HORNED_GREAT_HELM =ItemBuilders.registerArmorModelMats(
            "teutonic_horned_great_helm", genericCombatProps,
            EquipmentSlot.HEAD,
            ModelTeutonicHelmet.class, ModelTeutonicHelmet.LAYER_LOCATION,
            metalMaterials);

    //public static final List<RegistryObject<Item>> KNIGHT_ARMORS = ItemBuilders.registerArmorSetMats(
    //        genericCombatProps, "knight", metalMaterials);

    //Shields
    public static final RegistryObject<Item> ARABIAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_kite_shield", ModShield.class,  2);
    public static final RegistryObject<Item> ARABIAN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> BLUE_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> BLUE_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> BLUE_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> BLUE_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_round_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> BLUE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("blue_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> CRUSADERS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> CRUSADERS_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_kite_shield", ModShield.class,  0);
    public static final RegistryObject<Item> FLEUR_DE_LIS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("fleur_de_lis_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_EAGLE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_EAGLE_HEATER_SHIELD_1 = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_pavise_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_ROUNDED_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_rounded_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_SHARP_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_sharp_heater_shield", ModShield.class,  0);
    public static final RegistryObject<Item> HERALDIC_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_wankel_shield", ModShield.class,  0);
    public static final RegistryObject<Item> JOUSTING_SHIELD = ItemBuilders.registerTierlessWeapon("jousting_shield", ModShield.class,  0);
    public static final RegistryObject<Item> NORMAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("norman_kite_shield", ModShield.class,  0);
    public static final RegistryObject<Item> PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("pavise_shield", ModShield.class,  0);
    public static final RegistryObject<Item> RED_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> RED_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> RED_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> RED_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_round_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> ROUND_SHIELD_WITH_BIRDS = ItemBuilders.registerTierlessWeapon("round_shield_with_birds", ModShield.class,  0);
    public static final RegistryObject<Item> ROUND_SHIELD_WITH_TRISKELE = ItemBuilders.registerTierlessWeapon("round_shield_with_triskele", ModShield.class,  0);
    public static final RegistryObject<Item> TARGE_SHIELD = ItemBuilders.registerTierlessWeapon("targe_shield", ModShield.class,  0);
    public static final RegistryObject<Item> WOODEN_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_pavise_shield", ModShield.class,  0);
    public static final RegistryObject<Item> WOODEN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> WOODEN_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_wankel_shield", ModShield.class,  0);
    public static final RegistryObject<Item> YELLOW_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> YELLOW_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield_1", ModShield.class,  0);
    public static final RegistryObject<Item> YELLOW_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_round_shield", ModShield.class,  0);
    public static final RegistryObject<Item> YELLOW_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_round_shield_1", ModShield.class,  0);

    //Ranged
    public static final RegistryObject<Item> STEPPE_RECURVE_BOW = ItemBuilders.registerTierlessWeapon("steppe_recurve_bow", ModBow.class, 0);
    public static final RegistryObject<Item> ENGLISH_LONGBOW = ItemBuilders.registerTierlessWeapon("english_longbow", ModBow.class, 0);
    public static final RegistryObject<Item> HEAVY_WARBOW = ItemBuilders.registerTierlessWeapon("heavy_warbow", ModBow.class, 0);
    public static final RegistryObject<Item> SMALL_WARBOW = ItemBuilders.registerTierlessWeapon("small_warbow", ModBow.class, 0);
    public static final RegistryObject<Item> SHORTBOW = ItemBuilders.registerTierlessWeapon("shortbow", ModBow.class, 0);
    public static final RegistryObject<Item> LIGHT_CROSSBOW = ItemBuilders.registerTierlessWeapon("light_crossbow", ModCrossbow.class, 0);
    public static final RegistryObject<Item> MEDIUM_CROSSBOW = ItemBuilders.registerTierlessWeapon("medium_crossbow", ModCrossbow.class, 0);
    public static final RegistryObject<Item> HEAVY_CROSSBOW = ItemBuilders.registerTierlessWeapon("heavy_crossbow", ModCrossbow.class, 0);

    //Melee
    public static final List<RegistryObject<Item>> BASTARD_SWORD = ItemBuilders.registerSwordSet("bastard_sword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> VIKING_BEARDED_AXE = ItemBuilders.registerAxeSet("viking_bearded_axe", 6, -3.1F, genericCombatProps, metalTiers, 0);
    public static final RegistryObject<Item> WINGED_SPEAR = REGISTER.register("winged_spear", () ->
            new ModSpear(genericCombatProps, 6.0F));
    public static final RegistryObject<Item> WINGED_LEAF_BLADED_SPEAR = REGISTER.register("winged_leaf_shaped_spear", () ->
            new ModSpear(genericCombatProps, 6.0F));



}
