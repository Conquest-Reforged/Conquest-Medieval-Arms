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
    public static final List<RegistryObject<Item>> BEARDED_GREAT_AXE = ItemBuilders.registerAxeSet("bearded_great_axe", 6, -3.1F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> BEARDED_AXE = ItemBuilders.registerAxeSet("bearded_axe", 6, -3.1F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> CROWBEAK_HATCHET = ItemBuilders.registerAxeSet("crowbeak_hatchet", 6, -3.1F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> LARGE_BEC_DE_CORBIN = ItemBuilders.registerSwordSet("large_bec_de_corbin", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> BILL = ItemBuilders.registerSwordSet("bill", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> BILL_HOOK = ItemBuilders.registerSwordSet("bill_hook", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> BROADAXE = ItemBuilders.registerAxeSet("broadaxe", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> CRUSADER_SWORD = ItemBuilders.registerSwordSet("crusader_sword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> DOUBLE_FLAIL = ItemBuilders.registerSwordSet("double_flail", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> POLEHAMMER = ItemBuilders.registerSwordSet("polehammer", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> FLAIL = ItemBuilders.registerSwordSet("flail", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SPIKED_FLAIL = ItemBuilders.registerSwordSet("spiked_flail", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> FLAMMENSCHWERT = ItemBuilders.registerSwordSet("flammenschwert", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> FLANGED_MACE = ItemBuilders.registerSwordSet("flanged_mace", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> HORSEMANS_AXE = ItemBuilders.registerAxeSet("horsemans_axe", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> HUNTING_KNIFE = ItemBuilders.registerSwordSet("hunting_knife", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> LARGE_VIKING_SWORD = ItemBuilders.registerSwordSet("large_viking_sword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> LEAFBLADE_CLAYMORE = ItemBuilders.registerSwordSet("leafblade_claymore", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> LONGSWORD = ItemBuilders.registerSwordSet("longsword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> POLE_FLAIL = ItemBuilders.registerSwordSet("pole_flail", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> QUILLON_DAGGER = ItemBuilders.registerSwordSet("quillon_dagger", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SCIMITAR = ItemBuilders.registerSwordSet("scimitar", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SHESTOPYOR = ItemBuilders.registerSwordSet("shestopyor", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SHORTSWORD = ItemBuilders.registerSwordSet("shortsword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SHORTSWORD_WITH_GILDED_HILT = ItemBuilders.registerSwordSet("shortsword_with_gilded_hilt", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SPIKED_MACE = ItemBuilders.registerSwordSet("spiked_mace", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> STUDDED_BATTLE_AXE = ItemBuilders.registerAxeSet("studded_battle_axe", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> VIKING_SWORD = ItemBuilders.registerSwordSet("viking_sword", 3, -2.4F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> ZWEIHANDER = ItemBuilders.registerSwordSet("zweihander", 3, -2.4F, genericCombatProps, metalTiers, 0);


    public static final List<RegistryObject<Item>> GLAIVE = ItemBuilders.registerLongWepSet("glaive", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> HEAVY_HALBERD = ItemBuilders.registerLongWepSet("heavy_halberd", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> HEAVY_VOULGE = ItemBuilders.registerLongWepSet("heavy_voulge", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> VOULGE = ItemBuilders.registerLongWepSet("voulge", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> WAR_SCYTHE = ItemBuilders.registerLongWepSet("war_scythe", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<RegistryObject<Item>> SIMPLE_HALBERD = ItemBuilders.registerLongWepSet("simple_halberd",5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> SWISS_HALBERD = ItemBuilders.registerLongWepSet("swiss_halberd",5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> POLEAXE = ItemBuilders.registerLongWepSet("poleaxe", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> RANSEUR = ItemBuilders.registerLongWepSet("ranseur",5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<RegistryObject<Item>> PITCHFORK = ItemBuilders.registerLongWepSet("pitchfork", 5.0F, 5, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<RegistryObject<Item>> JOUSTING_LANCE = ItemBuilders.registerLongWepSet("jousting_lance", 7.0F, 6, -4.0F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> BARDICHE = ItemBuilders.registerLongWepSet("bardiche", 5.0F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> WINGED_SPEAR = ItemBuilders.registerLongWepSet("winged_spear", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<RegistryObject<Item>> WINGED_LEAF_SHAPED_SPEAR = ItemBuilders.registerLongWepSet("winged_leaf_shaped_spear", 5.5F, 8, -2.9F, genericCombatProps, metalTiers, 0);



}
