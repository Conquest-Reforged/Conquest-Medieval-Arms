package com.conquestreforged.arms.items.armor.models;

import com.conquestreforged.arms.items.armor.ArmorModelItem;
import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModArmorModel extends GeoModel<ArmorModelItem> {

    @Override
    public Identifier getModelResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();

        switch (animatable.getSlotType()) {
            case HEAD:
                return new Identifier(MOD_ID, "geo/helmet_generic.geo.json");
            case CHEST:
                return new Identifier(MOD_ID, "geo/chestplate_generic.geo.json");
            case LEGS:
                return new Identifier(MOD_ID, "geo/leggings_generic.geo.json");
            case FEET:
                return new Identifier(MOD_ID, "geo/boots_generic.geo.json");
        }
        return new Identifier(MOD_ID, "geo/" + "crimson_hauberk" + ".geo.json");
    }

    @Override
    public Identifier getTextureResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();
        return new Identifier(texture);

    }

    @Override
    public Identifier getAnimationResource(ArmorModelItem animatable) {
        return null;
    }
}
