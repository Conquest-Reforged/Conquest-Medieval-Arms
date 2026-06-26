package com.conquestreforged.arms.init;

import com.conquestreforged.arms.init.builders.ItemBuilders;
import com.conquestreforged.arms.items.*;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.VanillaHelmetItem;
import com.conquestreforged.arms.items.armor.materials.ModArmorMaterials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ItemInit {

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(BuiltInRegistries.ITEM, MOD_ID);

    public static final Item.Properties genericCombatProps = new Item.Properties()
            .stacksTo(1);
    public static final Item.Properties shieldProps = new Item.Properties()
            .stacksTo(1)
            .durability(336);
    public static final List<Tier> metalTiers = new ArrayList<>(Arrays.asList(
            Tiers.IRON,
            Tiers.DIAMOND,
            Tiers.NETHERITE
    ));


    //public static final Item DAGGER = REGISTER.register("dagger", () ->
    //        new ModDagger(Tiers.IRON, 3, -2.4F, genericCombatProps));

    ////////////////--------------------------START REGISTRATION----------------------------------///////////////////
    public static final DeferredHolder<Item, ArmorModelItem> WINGED_HUSSAR_BOOTS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> WINGED_HUSSAR_CHEST = ItemBuilders.registerArmorModelMats(
            "winged_hussar_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> WINGED_HUSSAR_LEGS = ItemBuilders.registerArmorModelMats(
            "winged_hussar_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> WINGED_HUSSAR_HELMET = ItemBuilders.registerArmorModelMats(
            "winged_hussar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> TEUTONIC_HORNED_GREAT_HELM = ItemBuilders.registerArmorModelMats(
            "teutonic_horned_great_helm", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CICAK_HELMET = ItemBuilders.registerArmorModelMats(
            "cicak_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLUE_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "blue_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "red_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> YELLOW_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "yellow_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> GREEN_CRESTED_JOUSTING_HELMET = ItemBuilders.registerArmorModelMats(
            "green_crested_jousting_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FATIMID_CAP = ItemBuilders.registerArmorModelMats(
            "fatimid_cap", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ARABIAN_HELMET = ItemBuilders.registerArmorModelMats(
            "arabian_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> GILDED_VIKING_HELMET = ItemBuilders.registerArmorModelMats(
            "gilded_viking_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LAMELLAR_HELMET = ItemBuilders.registerArmorModelMats(
            "lamellar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FEATHERED_LAMELLAR_HELMET = ItemBuilders.registerArmorModelMats(
            "feathered_lamellar_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> MONGOLIAN_SPIKED_HELMET = ItemBuilders.registerArmorModelMats(
            "mongolian_spiked_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_GREAT_BASCINET = ItemBuilders.registerArmorModelMats(
            "knights_great_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> PLAIN_BASCINET = ItemBuilders.registerArmorModelMats(
            "plain_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_HAUBERGEON = ItemBuilders.registerArmorModelMats(
            "black_haubergeon", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "black_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_SABATONS = ItemBuilders.registerArmorModelMats(
            "black_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> CHAINMAIL_COIF = ItemBuilders.registerArmorModelMats(
            "chainmail_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CHAINMAIL_HAUBERK = ItemBuilders.registerArmorModelMats(
            "chainmail_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CHAINMAIL_HAUBERK_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "chainmail_hauberk_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CHAINMAIL_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "chainmail_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> CRUSADER_GREAT_HELM = ItemBuilders.registerArmorModelMats(
            "crusader_great_helm", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CRUSADER_HAUBERGEON = ItemBuilders.registerArmorModelMats(
            "crusader_haubergeon", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CRUSADER_PADDED_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "crusader_padded_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CRUSADER_BOOTS = ItemBuilders.registerArmorModelMats(
            "crusader_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> GILDED_VISOR_BASCINET = ItemBuilders.registerArmorModelMats(
            "gilded_visor_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> GILDED_CUIRASS_AND_HAUBERK = ItemBuilders.registerArmorModelMats(
            "gilded_cuirass_and_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> GILDED_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "gilded_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> GILDED_SABATONS = ItemBuilders.registerArmorModelMats(
            "gilded_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> ENGLISH_KNIGHTS_VISORED_BASCINET = ItemBuilders.registerArmorModelMats(
            "english_knights_visored_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "english_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "english_knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_TAPERED_SABATONS = ItemBuilders.registerArmorModelMats(
            "english_tapered_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> PEASANTS_COIF = ItemBuilders.registerArmorModelMats(
            "peasants_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.CLOTH,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PADDED_GAMBESON = ItemBuilders.registerArmorModelMats(
            "padded_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PEASANTS_PANTS = ItemBuilders.registerArmorModelMats(
            "peasants_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.CLOTH,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PEASANTS_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "peasants_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_HAUBERK = ItemBuilders.registerArmorModelMats(
            "black_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LEATHER_PANTS = ItemBuilders.registerArmorModelMats(
            "leather_pants", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LEATHER_POULAINES = ItemBuilders.registerArmorModelMats(
            "leather_poulaines", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> BURGUNDIAN_GILDED_BASCINET = ItemBuilders.registerArmorModelMats(
            "burgundian_gilded_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BURGUNDIAN_BLUE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "burgundian_blue_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BURGUNDIAN_PADDED_LEGGINGS = ItemBuilders.registerArmorModelMats(
            "burgundian_padded_leggings", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "black_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> FRENCH_KNIGHTS_VISORED_BASCINET = ItemBuilders.registerArmorModelMats(
            "french_knights_round_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FRENCH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "french_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FRENCH_KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "french_knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FRENCH_TAPERED_SABATONS = ItemBuilders.registerArmorModelMats(
            "french_tapered_sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);

    public static final DeferredHolder<Item, VanillaHelmetItem> IRON_CAP_AND_COIF = ItemBuilders.registerArmorModelMats(
            "iron_cap_and_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PADDED_LEATHER_GAMBESON = ItemBuilders.registerArmorModelMats(
            "padded_leather_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PADDED_TROUSERS = ItemBuilders.registerArmorModelMats(
            "padded_trousers", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LEATHER_SHOES = ItemBuilders.registerArmorModelMats(
            "leather_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PADDED_SOLLERETS = ItemBuilders.registerArmorModelMats(
            "padded_sollerets", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> KETTLE_HELMET_AND_COIF = ItemBuilders.registerArmorModelMats(
            "kettle_helmet_and_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_AND_WHITE_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_and_white_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LEATHER_PANTS_WITH_POLEYNS = ItemBuilders.registerArmorModelMats(
            "leather_pants_with_poleyns", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PADDED_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "padded_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> KNIGHTS_BASCINET = ItemBuilders.registerArmorModelMats(
            "knights_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_PLATELEGS = ItemBuilders.registerArmorModelMats(
            "knights_platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_SOLLERETS = ItemBuilders.registerArmorModelMats(
            "knights_sollerets", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> ENGLISH_LONGBOWMANS_BASCINET = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_LONGBOWMANS_GAMBESON = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_LONGBOWMANS_TROUSERS = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_trousers", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_LONGBNOWMANS_SHOES = ItemBuilders.registerArmorModelMats(
            "english_longbowmans_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> WHITE_SUGAR_LOAF_HELMET = ItemBuilders.registerArmorModelMats(
            "white_sugar_loaf_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> CRIMSON_HAUBERK = ItemBuilders.registerArmorModelMats(
            "crimson_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_TROUSERS_WITH_GREAVES = ItemBuilders.registerArmorModelMats(
            "red_trousers_with_greaves", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> SABATONS = ItemBuilders.registerArmorModelMats(
            "sabatons", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> ROUND_BASCINET = ItemBuilders.registerArmorModelMats(
            "round_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_AND_WHITE_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "red_and_white_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PLATELEGS = ItemBuilders.registerArmorModelMats(
            "platelegs", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> SABATONS_1 = ItemBuilders.registerArmorModelMats(
            "sabatons_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> CROWN = ItemBuilders.registerArmorModelMats(
            "crown", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ArmorMaterials.GOLD,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_AND_WHITE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "red_and_white_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_BREECHES_WITH_GREAVES = ItemBuilders.registerArmorModelMats(
            "red_breeches_with_greaves", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> STRAPPED_MAIL_CHAUSSES = ItemBuilders.registerArmorModelMats(
            "strapped_mail_chausses", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> NORMAN_NASAL_HELMET = ItemBuilders.registerArmorModelMats(
            "norman_nasal_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> NORMAN_MAIL_HAUBERK = ItemBuilders.registerArmorModelMats(
            "norman_mail_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> NORMAN_PADDED_BREECHES = ItemBuilders.registerArmorModelMats(
            "norman_padded_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> NORMAN_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "norman_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> BLACK_COIF = ItemBuilders.registerArmorModelMats(
            "black_coif", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> BLACK_GAMBESON = ItemBuilders.registerArmorModelMats(
            "black_gambeson", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> DARK_BREECHES = ItemBuilders.registerArmorModelMats(
            "dark_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> STRAPPED_DARK_LEATHER_BOOTS = ItemBuilders.registerArmorModelMats(
            "strapped_dark_leather_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> POLISH_KNIGHTS_BASCINET = ItemBuilders.registerArmorModelMats(
            "polish_knights_bascinet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> POLISH_KNIGHTS_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "polish_knights_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> POLISH_KNIGHTS_CUISSES = ItemBuilders.registerArmorModelMats(
            "polish_knights_cuisses", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> POLISH_KNIGHTS_PLATED_BOOTS = ItemBuilders.registerArmorModelMats(
            "polish_knights_plated_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> ENGLISH_SALLET = ItemBuilders.registerArmorModelMats(
            "english_sallet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_CHESTPLATE = ItemBuilders.registerArmorModelMats(
            "english_chestplate", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_CUISSES = ItemBuilders.registerArmorModelMats(
            "english_cuisses", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> ENGLISH_PLATED_BOOTS = ItemBuilders.registerArmorModelMats(
            "english_plated_boots", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);

    public static final DeferredHolder<Item, ArmorModelItem> FATIMID_SCALE_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "fatimid_scale_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FATIMID_BREECHES = ItemBuilders.registerArmorModelMats(
            "fatimid_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FATIMID_LEATHER_SHOES = ItemBuilders.registerArmorModelMats(
            "fatimid_leather_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> RED_AND_WHITE_SALLET = ItemBuilders.registerArmorModelMats(
            "red_and_white_sallet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LAMELLAR_BRIGANDINE = ItemBuilders.registerArmorModelMats(
            "lamellar_brigandine", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> WOOLEN_BREECHES = ItemBuilders.registerArmorModelMats(
            "woolen_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.QUILT,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> FUR_LINED_POULAINES = ItemBuilders.registerArmorModelMats(
            "fur_lined_poulaines", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.CLOTH,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> SUGAR_LOAF_HELMET = ItemBuilders.registerArmorModelMats(
            "sugar_loaf_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> RED_HERALDIC_HAUBERK = ItemBuilders.registerArmorModelMats(
            "red_heraldic_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> SLEEVELESS_HAUBERK = ItemBuilders.registerArmorModelMats(
            "sleeveless_hauberk", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> LEATHER_SHOES_1 = ItemBuilders.registerArmorModelMats(
            "leather_shoes_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, VanillaHelmetItem> PURPLE_NASAL_HELMET = ItemBuilders.registerArmorModelMats(
            "purple_nasal_helmet", genericCombatProps,
            ArmorItem.Type.HELMET,
            VanillaHelmetItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> PURPLE_HAUBERK = ItemBuilders.registerArmorModelMats(
            "purple_hauberk", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> VIKING_LEATHER_BREECHES = ItemBuilders.registerArmorModelMats(
            "viking_leather_breeches", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> VIKING_LEATHER_WRAPPED_SHOES = ItemBuilders.registerArmorModelMats(
            "viking_leather_wrapped_shoes", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ArmorMaterials.LEATHER,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_CHESTPLATE_1 = ItemBuilders.registerArmorModelMats(
            "knights_chestplate_1", genericCombatProps,
            ArmorItem.Type.CHESTPLATE,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_PLATELEGS_1 = ItemBuilders.registerArmorModelMats(
            "knights_platelegs_1", genericCombatProps,
            ArmorItem.Type.LEGGINGS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);
    public static final DeferredHolder<Item, ArmorModelItem> KNIGHTS_SOLLERETS_1 = ItemBuilders.registerArmorModelMats(
            "knights_sollerets_1", genericCombatProps,
            ArmorItem.Type.BOOTS,
            ArmorModelItem.class,
            ModArmorMaterials.METAL_GENERIC,
            0.0f, 0.0f, 0.0f);

    //Shields
    public static final DeferredHolder<Item, ModShield> HERALDIC_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> HERALDIC_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_pavise_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> HERALDIC_ROUNDED_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_rounded_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> HERALDIC_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_wankel_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> JOUSTING_SHIELD = ItemBuilders.registerTierlessWeapon("jousting_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> NORMAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("norman_kite_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("pavise_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> TARGE_SHIELD = ItemBuilders.registerTierlessWeapon("targe_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> WOODEN_PAVISE_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_pavise_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> WOODEN_WANKEL_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_wankel_shield", ModShield.class, shieldProps, 0);
    //updated models
    public static final DeferredHolder<Item, ModShield> HERALDIC_SHARP_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_sharp_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> HERALDIC_EAGLE_HEATER_SHIELD_1 = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> HERALDIC_EAGLE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("heraldic_eagle_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> FLEUR_DE_LIS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("fleur_de_lis_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> CRUSADERS_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> BLUE_HEATER_SHIELD = ItemBuilders.registerTierlessWeapon("blue_heater_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> ARABIAN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> WOODEN_KITESHIELD = ItemBuilders.registerTierlessWeapon("wooden_kiteshield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> YELLOW_KITESHIELD = ItemBuilders.registerTierlessWeapon("yellow_kiteshield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> CRUSADERS_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("crusaders_kite_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> ARABIAN_KITE_SHIELD = ItemBuilders.registerTierlessWeapon("arabian_kite_shield", ModShield.class, shieldProps, 0);
    //roundshields
    public static final DeferredHolder<Item, ModShield> BLUE_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> BLUE_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> BLUE_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("blue_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> BLUE_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("blue_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> RED_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> RED_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> RED_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("red_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> RED_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("red_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> ROUND_SHIELD_WITH_BIRDS = ItemBuilders.registerTierlessWeapon("round_shield_with_birds", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> ROUND_SHIELD_WITH_TRISKELE = ItemBuilders.registerTierlessWeapon("round_shield_with_triskele", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> WOODEN_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("wooden_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> YELLOW_AND_BLACK_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> YELLOW_AND_BLACK_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_and_black_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> YELLOW_ROUND_SHIELD = ItemBuilders.registerTierlessWeapon("yellow_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> YELLOW_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("yellow_round_shield_1", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> GREEN_ROUND_SHIELD_ = ItemBuilders.registerTierlessWeapon("green_round_shield", ModShield.class, shieldProps, 0);
    public static final DeferredHolder<Item, ModShield> GREEN_ROUND_SHIELD_1 = ItemBuilders.registerTierlessWeapon("green_round_shield_1", ModShield.class, shieldProps, 0);



    //Ranged
    public static final DeferredHolder<Item, ModBow> STEPPE_RECURVE_BOW = ItemBuilders.registerTierlessWeapon("steppe_recurve_bow", ModBow.class, genericCombatProps.durability(384),0);
    public static final DeferredHolder<Item, ModBow> ENGLISH_LONGBOW = ItemBuilders.registerTierlessWeapon("english_longbow", ModBow.class, genericCombatProps.durability(384), 0);
    public static final DeferredHolder<Item, ModBow> HEAVY_WARBOW = ItemBuilders.registerTierlessWeapon("heavy_warbow", ModBow.class, genericCombatProps.durability(384), 0);
    public static final DeferredHolder<Item, ModBow> SMALL_WARBOW = ItemBuilders.registerTierlessWeapon("small_warbow", ModBow.class, genericCombatProps.durability(384), 0);
    public static final DeferredHolder<Item, ModBow> SHORTBOW = ItemBuilders.registerTierlessWeapon("shortbow", ModBow.class, genericCombatProps.durability(384), 0);
    public static final DeferredHolder<Item, ModCrossbow> LIGHT_CROSSBOW = ItemBuilders.registerTierlessWeapon("light_crossbow", ModCrossbow.class, genericCombatProps.durability(465), 0);
    public static final DeferredHolder<Item, ModCrossbow> MEDIUM_CROSSBOW = ItemBuilders.registerTierlessWeapon("medium_crossbow", ModCrossbow.class, genericCombatProps.durability(465), 0);
    public static final DeferredHolder<Item, ModCrossbow> HEAVY_CROSSBOW = ItemBuilders.registerTierlessWeapon("heavy_crossbow", ModCrossbow.class, genericCombatProps.durability(465), 0);

    //Melee
    public static final DeferredHolder<Item, ModSword> BASTARD_SWORD = ItemBuilders.registerSwordSet("bastard_sword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH,  genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> VIKING_BEARDED_AXE = ItemBuilders.registerAxeSet("viking_bearded_axe", 0, -3.1F, 10.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> BEARDED_GREAT_AXE = ItemBuilders.registerAxeSet("bearded_great_axe", 0, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> BEARDED_AXE = ItemBuilders.registerAxeSet("bearded_axe", 0, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> CROWBEAK_HATCHET = ItemBuilders.registerAxeSet("crowbeak_hatchet", 0, -3.1F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> LARGE_BEC_DE_CORBIN = ItemBuilders.registerSwordSet("large_bec_de_corbin", 0, -2.4F, 2.5D, 3.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> BILL = ItemBuilders.registerSwordSet("bill", 0, -2.4F, 2.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> BILL_HOOK = ItemBuilders.registerSwordSet("bill_hook", 0, -2.4F, 2.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> BROADAXE = ItemBuilders.registerAxeSet("broadaxe", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> CRUSADER_SWORD = ItemBuilders.registerSwordSet("crusader_sword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> DOUBLE_FLAIL = ItemBuilders.registerSwordSet("double_flail", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> POLEHAMMER = ItemBuilders.registerSwordSet("polehammer", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> FLAIL = ItemBuilders.registerSwordSet("flail", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SPIKED_FLAIL = ItemBuilders.registerSwordSet("spiked_flail", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> FLAMMENSCHWERT = ItemBuilders.registerSwordSet("flammenschwert", 0, -2.4F,0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> FLANGED_MACE = ItemBuilders.registerSwordSet("flanged_mace", 0, -2.4F,0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> HORSEMANS_AXE = ItemBuilders.registerAxeSet("horsemans_axe", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> HUNTING_KNIFE = ItemBuilders.registerSwordSet("hunting_knife", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> LARGE_VIKING_SWORD = ItemBuilders.registerSwordSet("large_viking_sword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> LEAFBLADE_CLAYMORE = ItemBuilders.registerSwordSet("leafblade_claymore", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> LONGSWORD = ItemBuilders.registerSwordSet("longsword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> POLE_FLAIL = ItemBuilders.registerSwordSet("pole_flail", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> QUILLON_DAGGER = ItemBuilders.registerSwordSet("quillon_dagger", 0, -2.4F,-1.5D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SCIMITAR = ItemBuilders.registerSwordSet("scimitar", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SHESTOPYOR = ItemBuilders.registerSwordSet("shestopyor", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SHORTSWORD = ItemBuilders.registerSwordSet("shortsword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SHORTSWORD_WITH_GILDED_HILT = ItemBuilders.registerSwordSet("shortsword_with_gilded_hilt", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> SPIKED_MACE = ItemBuilders.registerSwordSet("spiked_mace", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModAxe> STUDDED_BATTLE_AXE = ItemBuilders.registerAxeSet("studded_battle_axe", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> VIKING_SWORD = ItemBuilders.registerSwordSet("viking_sword", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSword> ZWEIHANDER = ItemBuilders.registerSwordSet("zweihander", 0, -2.4F, 0.0D, 0.0D, AttackStyleEnum.SLASH, genericCombatProps, metalTiers, 0);

    public static final DeferredHolder<Item, ModSpear> GLAIVE = ItemBuilders.registerLongWepSet("glaive", 2.5D,  0.0D, AttackStyleEnum.SLASH,0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> HEAVY_HALBERD = ItemBuilders.registerLongWepSet("heavy_halberd", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> HEAVY_VOULGE = ItemBuilders.registerLongWepSet("heavy_voulge", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> VOULGE = ItemBuilders.registerLongWepSet("voulge", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> WAR_SCYTHE = ItemBuilders.registerLongWepSet("war_scythe", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);

    public static final DeferredHolder<Item, ModSpear> SIMPLE_HALBERD = ItemBuilders.registerLongWepSet("simple_halberd",2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> SWISS_HALBERD = ItemBuilders.registerLongWepSet("swiss_halberd",2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> POLEAXE = ItemBuilders.registerLongWepSet("poleaxe", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> RANSEUR = ItemBuilders.registerLongWepSet("ranseur",2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);

    public static final DeferredHolder<Item, ModSpear> PITCHFORK = ItemBuilders.registerLongWepSet("pitchfork", 2.0D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);

    public static final DeferredHolder<Item, ModSpear> JOUSTING_LANCE = ItemBuilders.registerLongWepSet("jousting_lance", 4.0D, 0.0D, AttackStyleEnum.SLASH, 0, -4.0F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> BARDICHE = ItemBuilders.registerLongWepSet("bardiche", 2.0F, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> WINGED_SPEAR = ItemBuilders.registerLongWepSet("winged_spear", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);
    public static final DeferredHolder<Item, ModSpear> WINGED_LEAF_SHAPED_SPEAR = ItemBuilders.registerLongWepSet("winged_leaf_shaped_spear", 2.5D, 0.0D, AttackStyleEnum.SLASH, 0, -2.9F, genericCombatProps, metalTiers, 0);


}
