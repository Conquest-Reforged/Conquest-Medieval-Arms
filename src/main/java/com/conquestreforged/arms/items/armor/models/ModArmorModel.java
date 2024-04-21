package com.conquestreforged.arms.items.armor.models;

import com.conquestreforged.arms.items.armor.ArmorModelItem;
import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModArmorModel extends GeoModel<ArmorModelItem> {

    @Override
    public Identifier getModelResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();
        return new Identifier(MOD_ID, "geo/" + "crimson_hauberk" + ".geo.json");
    }

    @Override
    public Identifier getTextureResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();
        return new Identifier(MOD_ID, "textures/models/armor/" + "crimson_hauberk" + ".png");

    }

    @Override
    public Identifier getAnimationResource(ArmorModelItem animatable) {
        return null;
    }
}
