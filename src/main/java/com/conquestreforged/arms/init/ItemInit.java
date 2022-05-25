package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.EntityTypes;
import com.conquestreforged.arms.init.builders.ItemBuilders;
import com.conquestreforged.arms.items.ModBow;
import com.conquestreforged.arms.items.ModCrossbow;
import com.conquestreforged.arms.items.ModShield;
import com.conquestreforged.arms.items.ModSpear;
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
    public static final List<RegistryObject<Item>> CRUSADER_HELMET = ItemBuilders.registerArmorModelMultiMaterials(
            "crusader_helmet", genericCombatProps, "crusader_helmet",
            EquipmentSlot.HEAD,
            ModelGenericHelmet.class, EntityClientInit.CRUSADER_HELM_LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_BOOTS = ItemBuilders.registerArmorModelMultiMaterials(
            "winged_hussar_boots", genericCombatProps, "winged_hussar_boots",
            EquipmentSlot.FEET,
            ModelWingedHussarBoots.class, ModelWingedHussarBoots.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_CHEST = ItemBuilders.registerArmorModelMultiMaterials(
            "winged_hussar_chestplate", genericCombatProps, "winged_hussar_chestplate",
            EquipmentSlot.CHEST,
            ModelWingedHussarChest.class, ModelWingedHussarChest.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_LEGS = ItemBuilders.registerArmorModelMultiMaterials(
            "winged_hussar_pants", genericCombatProps, "winged_hussar_pants",
            EquipmentSlot.LEGS,
            ModelWingedHussarLegs.class, ModelWingedHussarLegs.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_HELMET =ItemBuilders. registerArmorModelMultiMaterials(
            "winged_hussar_helmet", genericCombatProps, "winged_hussar_helmet",
            EquipmentSlot.HEAD,
            ModelWingedHussarHelmet.class, ModelWingedHussarHelmet.LAYER_LOCATION,
            metalMaterials);

    public static final RegistryObject<Item> SPEAR_IRON = REGISTER.register("spear_iron", () ->
            new ModSpear(genericCombatProps, EntityTypes.SPEAR_IRON, 7.0F));

    public static final List<RegistryObject<Item>> KNIGHT_ARMORS = ItemBuilders.registerArmorSetMultiMaterials(
            genericCombatProps, "knight", metalMaterials);

    public static final RegistryObject<Item> NORMAN_SHIELD = ItemBuilders.registerTierlessWeapon("norman_shield", ModShield.class,  2);
    public static final RegistryObject<Item> STEPPE_RECURVE_BOW = ItemBuilders.registerTierlessWeapon("steppe_recurve_bow", ModBow.class, 0);
    public static final RegistryObject<Item> LIGHT_CROSSBOW = ItemBuilders.registerTierlessWeapon("light_crossbow", ModCrossbow.class, 0);
    public static final List<RegistryObject<Item>> BASTARD_SWORD = ItemBuilders.registerSwordSet("bastard_sword", 3, -2.4F, genericCombatProps, metalTiers);
    public static final List<RegistryObject<Item>> VIKING_AXE = ItemBuilders.registerAxeSet("viking_axe", 6, -3.1F, genericCombatProps, metalTiers);



}
