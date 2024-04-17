package com.conquestreforged.arms.init;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.init.builders.ItemBuilders;
import com.conquestreforged.arms.items.AttackStyleEnum;
import com.conquestreforged.arms.items.ModBow;
import com.conquestreforged.arms.items.ModCrossbow;
import com.conquestreforged.arms.items.ModShield;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.materials.ModArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemInit {

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        //entries.add()
        //entries.add(BlockInit.ARMS_STATION_BLOCK);
    }
    public static void registerModItems() {
        ConquestMedievalArms.LOGGER.info("Registering Conquest Medieval Arms items.");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ItemInit::addItemsToIngredientItemGroup);
    }
    //Here we store a list of our items that get automatically generated model files
    public static final List<Item> dataGenItemModels = new ArrayList<>();
    //Here we store a list of our items that get automatically generated recipe+advancement files
    public static final List<Item> dataGenItemRecipes = new ArrayList<>();

    public static final Item.Settings genericCombatProps = new FabricItemSettings()
            .maxCount(1)
            .maxDamage(100);
    public static final Item.Settings shieldProps = new FabricItemSettings()
            .maxCount(1)
            .maxDamage(336);
    public static final List<ArmorMaterial> metalMaterials = new ArrayList<>(Arrays.asList(
            ArmorMaterials.IRON,
            ArmorMaterials.DIAMOND,
            ArmorMaterials.NETHERITE
    ));
    public static final List<ArmorMaterial> quiltMaterials = new ArrayList<>(Arrays.asList(
            ModArmorMaterials.QUILT
    ));
    public static final List<ArmorMaterial> clothMaterials = new ArrayList<>(Arrays.asList(
            ModArmorMaterials.CLOTH
    ));
    public static final List<ArmorMaterial> leatherMaterials = new ArrayList<>(Arrays.asList(
            ArmorMaterials.LEATHER
    ));
    public static final List<ArmorMaterial> ornamentalMaterials = new ArrayList<>(Arrays.asList(
            ArmorMaterials.GOLD
    ));
    public static final List<ToolMaterial> metalTiers = new ArrayList<>(Arrays.asList(
            ToolMaterials.IRON,
            ToolMaterials.DIAMOND,
            ToolMaterials.NETHERITE
    ));

    //public static final Item DAGGER = REGISTER.register("dagger", () ->
    //        new ModDagger(Tiers.IRON, 3, -2.4F, genericCombatProps));

    ////////////////--------------------------START REGISTRATION----------------------------------///////////////////
    public static final List<Item> WINGED_HUSSAR_BOOTS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> WINGED_HUSSAR_CHEST = ItemBuilders.registerArmorModelMats(
            "winged_hussar_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> WINGED_HUSSAR_LEGS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> WINGED_HUSSAR_HELMET = ItemBuilders.registerArmorModelMats(
            "winged_hussar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> TEUTONIC_HORNED_GREAT_HELM = ItemBuilders.registerArmorModelMats(
            "teutonic_horned_great_helm", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CICAK_HELMET = ItemBuilders.registerArmorModelMats(
            "cicak_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLUE_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "blue_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "red_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> YELLOW_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "yellow_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GREEN_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "green_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FATIMID_CAP = ItemBuilders.registerArmorModelMats(
            "fatimid_cap", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ARABIAN_HELMET = ItemBuilders.registerArmorModelMats(
            "arabian_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GILDED_VIKING_HELMET = ItemBuilders.registerArmorModelMats(
            "gilded_viking_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LAMELLAR_HELMET = ItemBuilders.registerArmorModelMats(
            "lamellar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FEATHERED_LAMELLAR_HELMET = ItemBuilders.registerArmorModelMats(
            "feathered_lamellar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> MONGOLIAN_SPIKED_HELMET = ItemBuilders.registerArmorModelMats(
            "mongolian_spiked_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_GREAT_BASCINET = ItemBuilders.registerArmorModelMats(
            "knights_great_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PLAIN_BASCINET = ItemBuilders.registerArmorModelMats(
            "plain_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_HAUBERGEON = ItemBuilders.registerArmorModelMats(
            "black_haubergeon", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "black_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_SABATONS = ItemBuilders.registerArmorModelMats(
            "black_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CHAINMAIL_COIF = ItemBuilders.registerArmorModelMats(
            "chainmail_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CHAINMAIL_HAUBERK = ItemBuilders.registerArmorModelMats(
            "chainmail_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CHAINMAIL_HAUBERK_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "chainmail_hauberk_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CHAINMAIL_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "chainmail_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CRUSADER_GREAT_HELM = ItemBuilders.registerArmorModelMats(
            "crusader_great_helm", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CRUSADER_HAUBERGEON = ItemBuilders.registerArmorModelMats(
            "crusader_haubergeon", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CRUSADER_PADDED_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "crusader_padded_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CRUSADER_BOOTS = ItemBuilders.registerArmorModelMats(
            "crusader_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GILDED_VISOR_BASCINET = ItemBuilders.registerArmorModelMats(
            "gilded_visor_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GILDED_CUIRASS_AND_HAUBERK = ItemBuilders.registerArmorModelMats(
            "gilded_cuirass_and_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GILDED_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "gilded_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> GILDED_SABATONS = ItemBuilders.registerArmorModelMats(
            "gilded_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_KNIGHTS_VISORED_BASCINET = ItemBuilders.registerArmorModelMats(
            "english_knights_visored_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "english_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "english_knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_TAPERED_SABATONS = ItemBuilders.registerArmorModelMats(
            "english_tapered_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PEASANTS_COIF = ItemBuilders.registerArmorModelMats(
            "peasants_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            clothMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PADDED_GAMBESON = ItemBuilders.registerArmorModelMats(
            "padded_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PEASANTS_PANTS = ItemBuilders.registerArmorModelMats(
            "peasants_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            clothMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PEASANTS_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "peasants_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_HAUBERK = ItemBuilders.registerArmorModelMats(
            "black_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LEATHER_PANTS = ItemBuilders.registerArmorModelMats(
            "leather_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LEATHER_POULAINES = ItemBuilders.registerArmorModelMats(
            "leather_poulaines", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BURGUNDIAN_GILDED_BASCINET = ItemBuilders.registerArmorModelMats(
            "burgundian_gilded_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BURGUNDIAN_BLUE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "burgundian_blue_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BURGUNDIAN_PADDED_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "burgundian_padded_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "black_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FRENCH_KNIGHTS_VISORED_BASCINET = ItemBuilders.registerArmorModelMats(
            "french_knights_round_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FRENCH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "french_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FRENCH_KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "french_knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FRENCH_TAPERED_SABATONS = ItemBuilders.registerArmorModelMats(
            "french_tapered_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);

    public static final List<Item> IRON_CAP_AND_COIF = ItemBuilders.registerArmorModelMats(
            "iron_cap_and_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PADDED_LEATHER_GAMBESON = ItemBuilders.registerArmorModelMats(
            "padded_leather_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PADDED_TROUSERS = ItemBuilders.registerArmorModelMats(
            "padded_trousers", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LEATHER_SHOES = ItemBuilders.registerArmorModelMats(
            "leather_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PADDED_SOLLERETS = ItemBuilders.registerArmorModelMats(
            "padded_sollerets", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KETTLE_HELMET_AND_COIF = ItemBuilders.registerArmorModelMats(
            "kettle_helmet_and_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_AND_WHITE_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_and_white_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LEATHER_PANTS_WITH_POLEYNS = ItemBuilders.registerArmorModelMats(
            "leather_pants_with_poleyns", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PADDED_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "padded_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_BASCINET = ItemBuilders.registerArmorModelMats(
            "knights_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_SOLLERETS = ItemBuilders.registerArmorModelMats(
            "knights_sollerets", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_LONGBOWMANS_BASCINET = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_LONGBOWMANS_GAMBESON = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_LONGBOWMANS_TROUSERS = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_trousers", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_LONGBNOWMANS_SHOES = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> WHITE_SUGAR_LOAF_HELMET = ItemBuilders.registerArmorModelMats(
            "white_sugar_loaf_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CRIMSON_HAUBERK = ItemBuilders.registerArmorModelMats(
            "crimson_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_TROUSERS_WITH_GREAVES = ItemBuilders.registerArmorModelMats(
            "red_trousers_with_greaves", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> SABATONS = ItemBuilders.registerArmorModelMats(
            "sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ROUND_BASCINET = ItemBuilders.registerArmorModelMats(
            "round_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_AND_WHITE_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "red_and_white_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PLATELEGS = ItemBuilders.registerArmorModelMats(
            "platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> SABATONS_1 = ItemBuilders.registerArmorModelMats(
            "sabatons_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> CROWN = ItemBuilders.registerArmorModelMats(
            "crown", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ornamentalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_AND_WHITE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "red_and_white_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_BREECHES_WITH_GREAVES = ItemBuilders.registerArmorModelMats(
            "red_breeches_with_greaves", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> STRAPPED_MAIL_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "strapped_mail_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> NORMAN_NASAL_HELMET = ItemBuilders.registerArmorModelMats(
            "norman_nasal_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> NORMAN_MAIL_HAUBERK = ItemBuilders.registerArmorModelMats(
            "norman_mail_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> NORMAN_PADDED_BREECHES = ItemBuilders.registerArmorModelMats(
            "norman_padded_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> NORMAN_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "norman_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_COIF = ItemBuilders.registerArmorModelMats(
            "black_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> BLACK_GAMBESON = ItemBuilders.registerArmorModelMats(
            "black_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> DARK_BREECHES = ItemBuilders.registerArmorModelMats(
            "dark_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> STRAPPED_DARK_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "strapped_dark_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> POLISH_KNIGHTS_BASCINET = ItemBuilders.registerArmorModelMats(
            "polish_knights_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> POLISH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "polish_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> POLISH_KNIGHTS_CUISSES = ItemBuilders.registerArmorModelMats(
            "polish_knights_cuisses", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> POLISH_KNIGHTS_PLATED_BOOTS = ItemBuilders.registerArmorModelMats(
            "polish_knights_plated_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_SALLET = ItemBuilders.registerArmorModelMats(
            "english_sallet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "english_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_CUISSES = ItemBuilders.registerArmorModelMats(
            "english_cuisses", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> ENGLISH_PLATED_BOOTS = ItemBuilders.registerArmorModelMats(
            "english_plated_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);

    public static final List<Item> FATIMID_SCALE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "fatimid_scale_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FATIMID_BREECHES = ItemBuilders.registerArmorModelMats(
            "fatimid_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FATIMID_LEATHER_SHOES = ItemBuilders.registerArmorModelMats(
            "fatimid_leather_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_AND_WHITE_SALLET = ItemBuilders.registerArmorModelMats(
            "red_and_white_sallet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LAMELLAR_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "lamellar_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> WOOLEN_BREECHES = ItemBuilders.registerArmorModelMats(
            "woolen_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            quiltMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> FUR_LINED_POULAINES = ItemBuilders.registerArmorModelMats(
            "fur_lined_poulaines", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            clothMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> SUGAR_LOAF_HELMET = ItemBuilders.registerArmorModelMats(
            "sugar_loaf_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> RED_HERALDIC_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_heraldic_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> SLEEVELESS_HAUBERK = ItemBuilders.registerArmorModelMats(
            "sleeveless_hauberk", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> LEATHER_SHOES_1 = ItemBuilders.registerArmorModelMats(
            "leather_shoes_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PURPLE_NASAL_HELMET = ItemBuilders.registerArmorModelMats(
            "purple_nasal_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> PURPLE_HAUBERK = ItemBuilders.registerArmorModelMats(
            "purple_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> VIKING_LEATHER_BREECHES = ItemBuilders.registerArmorModelMats(
            "viking_leather_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> VIKING_LEATHER_WRAPPED_SHOES = ItemBuilders.registerArmorModelMats(
            "viking_leather_wrapped_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            leatherMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_CHESTPLATE_1 = ItemBuilders.registerArmorModelMats(
            "knights_chestplate_1", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_PLATELEGS_1 = ItemBuilders.registerArmorModelMats(
            "knights_platelegs_1", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);
    public static final List<Item> KNIGHTS_SOLLERETS_1 = ItemBuilders.registerArmorModelMats(
            "knights_sollerets_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            metalMaterials,
            0.0f, 0.0f, 0.0f);

    //Shields
    public static final Item HERALDIC_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item HERALDIC_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_pavise_shield", ModShield.class, shieldProps, 0);
    public static final Item HERALDIC_ROUNDED_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_rounded_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item HERALDIC_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_wankel_shield", ModShield.class, shieldProps, 0);
    public static final Item JOUSTING_SHIELD = ItemBuilders.registerTierlessWeapon("jousting_shield", ModShield.class, shieldProps, 0);
    public static final Item NORMAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("norman_kite_shield", ModShield.class, shieldProps, 0);
    public static final Item PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("pavise_shield", ModShield.class, shieldProps, 0);
    public static final Item TARGE_SHIELD = ItemBuilders.registerTierlessWeapon("targe_shield", ModShield.class, shieldProps, 0);
    public static final Item WOODEN_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_pavise_shield", ModShield.class, shieldProps, 0);
    public static final Item WOODEN_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_wankel_shield", ModShield.class, shieldProps, 0);
    //updated models
    public static final Item HERALDIC_SHARP_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_sharp_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item HERALDIC_EAGLE_HEATER_SHIELD_1 = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield_1", ModShield.class, shieldProps, 0);
    public static final Item HERALDIC_EAGLE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item FLEUR_DE_LIS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("fleur_de_lis_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item CRUSADERS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item BLUE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("blue_heater_shield", ModShield.class, shieldProps, 0);
    public static final Item ARABIAN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_round_shield", ModShield.class, shieldProps, 0);
    public static final Item WOODEN_KITESHIELD = ItemBuilders.registerTierlessWeapon("wooden_kiteshield", ModShield.class, shieldProps, 0);
    public static final Item YELLOW_KITESHIELD = ItemBuilders.registerTierlessWeapon("yellow_kiteshield", ModShield.class, shieldProps, 0);
    public static final Item CRUSADERS_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_kite_shield", ModShield.class, shieldProps, 0);
    public static final Item ARABIAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_kite_shield", ModShield.class, shieldProps, 0);
    //roundshields
    public static final Item BLUE_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final Item BLUE_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item BLUE_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_round_shield", ModShield.class, shieldProps, 0);
    public static final Item BLUE_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item RED_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final Item RED_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item RED_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_round_shield", ModShield.class, shieldProps, 0);
    public static final Item RED_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item ROUND_SHIELD_WITH_BIRDS = ItemBuilders.registerTierlessWeapon("round_shield_with_birds", ModShield.class, shieldProps, 0);
    public static final Item ROUND_SHIELD_WITH_TRISKELE = ItemBuilders.registerTierlessWeapon("round_shield_with_triskele", ModShield.class, shieldProps, 0);
    public static final Item WOODEN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_round_shield", ModShield.class, shieldProps, 0);
    public static final Item YELLOW_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final Item YELLOW_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item YELLOW_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_round_shield", ModShield.class, shieldProps, 0);
    public static final Item YELLOW_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_round_shield_1", ModShield.class, shieldProps, 0);
    public static final Item GREEN_ROUND_SHIELD_ = ItemBuilders.registerTierlessWeapon("green_round_shield", ModShield.class, shieldProps, 0);
    public static final Item GREEN_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("green_round_shield_1", ModShield.class, shieldProps, 0);



    //Ranged
    public static final Item STEPPE_RECURVE_BOW = ItemBuilders.registerTierlessWeapon("steppe_recurve_bow", ModBow.class, genericCombatProps.maxDamage(384),0);
    public static final Item ENGLISH_LONGBOW = ItemBuilders.registerTierlessWeapon("english_longbow", ModBow.class, genericCombatProps.maxDamage(384), 0);
    public static final Item HEAVY_WARBOW = ItemBuilders.registerTierlessWeapon("heavy_warbow", ModBow.class, genericCombatProps.maxDamage(384), 0);
    public static final Item SMALL_WARBOW = ItemBuilders.registerTierlessWeapon("small_warbow", ModBow.class, genericCombatProps.maxDamage(384), 0);
    public static final Item SHORTBOW = ItemBuilders.registerTierlessWeapon("shortbow", ModBow.class, genericCombatProps.maxDamage(384), 0);
    public static final Item LIGHT_CROSSBOW = ItemBuilders.registerTierlessWeapon("light_crossbow", ModCrossbow.class, genericCombatProps.maxDamage(465), 0);
    public static final Item MEDIUM_CROSSBOW = ItemBuilders.registerTierlessWeapon("medium_crossbow", ModCrossbow.class, genericCombatProps.maxDamage(465), 0);
    public static final Item HEAVY_CROSSBOW = ItemBuilders.registerTierlessWeapon("heavy_crossbow", ModCrossbow.class, genericCombatProps.maxDamage(465), 0);

    //Melee
    public static final List<Item> BASTARD_SWORD = ItemBuilders.registerSwordSet("bastard_sword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH,  genericCombatProps, metalTiers, 0);
    public static final List<Item> VIKING_BEARDED_AXE = ItemBuilders.registerAxeSet("viking_bearded_axe", 6, -3.1F, 10.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> BEARDED_GREAT_AXE = ItemBuilders.registerAxeSet("bearded_great_axe", 6, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> BEARDED_AXE = ItemBuilders.registerAxeSet("bearded_axe", 6, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> CROWBEAK_HATCHET = ItemBuilders.registerAxeSet("crowbeak_hatchet", 6, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> LARGE_BEC_DE_CORBIN = ItemBuilders.registerSwordSet("large_bec_de_corbin", 3, -2.4F, 2.5D, 3.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> BILL = ItemBuilders.registerSwordSet("bill", 3, -2.4F, 2.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> BILL_HOOK = ItemBuilders.registerSwordSet("bill_hook", 3, -2.4F, 2.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> BROADAXE = ItemBuilders.registerAxeSet("broadaxe", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> CRUSADER_SWORD = ItemBuilders.registerSwordSet("crusader_sword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> DOUBLE_FLAIL = ItemBuilders.registerSwordSet("double_flail", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> POLEHAMMER = ItemBuilders.registerSwordSet("polehammer", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> FLAIL = ItemBuilders.registerSwordSet("flail", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SPIKED_FLAIL = ItemBuilders.registerSwordSet("spiked_flail", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> FLAMMENSCHWERT = ItemBuilders.registerSwordSet("flammenschwert", 3, -2.4F,0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> FLANGED_MACE = ItemBuilders.registerSwordSet("flanged_mace", 3, -2.4F,0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> HORSEMANS_AXE = ItemBuilders.registerAxeSet("horsemans_axe", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> HUNTING_KNIFE = ItemBuilders.registerSwordSet("hunting_knife", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> LARGE_VIKING_SWORD = ItemBuilders.registerSwordSet("large_viking_sword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> LEAFBLADE_CLAYMORE = ItemBuilders.registerSwordSet("leafblade_claymore", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> LONGSWORD = ItemBuilders.registerSwordSet("longsword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> POLE_FLAIL = ItemBuilders.registerSwordSet("pole_flail", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> QUILLON_DAGGER = ItemBuilders.registerSwordSet("quillon_dagger", 3, -2.4F,-1.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SCIMITAR = ItemBuilders.registerSwordSet("scimitar", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SHESTOPYOR = ItemBuilders.registerSwordSet("shestopyor", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SHORTSWORD = ItemBuilders.registerSwordSet("shortsword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SHORTSWORD_WITH_GILDED_HILT = ItemBuilders.registerSwordSet("shortsword_with_gilded_hilt", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> SPIKED_MACE = ItemBuilders.registerSwordSet("spiked_mace", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> STUDDED_BATTLE_AXE = ItemBuilders.registerAxeSet("studded_battle_axe", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> VIKING_SWORD = ItemBuilders.registerSwordSet("viking_sword", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final List<Item> ZWEIHANDER = ItemBuilders.registerSwordSet("zweihander", 3, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);

    public static final List<Item> GLAIVE = ItemBuilders.registerLongWepSet("glaive", 2.5D,  0.0D, AttackStyleEnum.SLASH,8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> HEAVY_HALBERD = ItemBuilders.registerLongWepSet("heavy_halberd", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> HEAVY_VOULGE = ItemBuilders.registerLongWepSet("heavy_voulge", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> VOULGE = ItemBuilders.registerLongWepSet("voulge", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> WAR_SCYTHE = ItemBuilders.registerLongWepSet("war_scythe", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<Item> SIMPLE_HALBERD = ItemBuilders.registerLongWepSet("simple_halberd",2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> SWISS_HALBERD = ItemBuilders.registerLongWepSet("swiss_halberd",2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> POLEAXE = ItemBuilders.registerLongWepSet("poleaxe", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> RANSEUR = ItemBuilders.registerLongWepSet("ranseur",2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<Item> PITCHFORK = ItemBuilders.registerLongWepSet("pitchfork", 2.0D, 0.0D, AttackStyleEnum.SLASH, 5, -2.9F, genericCombatProps, metalTiers, 0);

    public static final List<Item> JOUSTING_LANCE = ItemBuilders.registerLongWepSet("jousting_lance", 4.0D, 0.0D, AttackStyleEnum.SLASH, 6, -4.0F, genericCombatProps, metalTiers, 0);
    public static final List<Item> BARDICHE = ItemBuilders.registerLongWepSet("bardiche", 2.0F, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> WINGED_SPEAR = ItemBuilders.registerLongWepSet("winged_spear", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);
    public static final List<Item> WINGED_LEAF_SHAPED_SPEAR = ItemBuilders.registerLongWepSet("winged_leaf_shaped_spear", 2.5D, 0.0D, AttackStyleEnum.SLASH, 8, -2.9F, genericCombatProps, metalTiers, 0);



}
