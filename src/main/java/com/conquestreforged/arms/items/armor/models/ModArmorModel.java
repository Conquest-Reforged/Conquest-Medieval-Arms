package com.conquestreforged.arms.items.armor.models;

import com.conquestreforged.arms.items.armor.ArmorModelItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModArmorModel extends GeoModel<ArmorModelItem> {

    @Override
    public Identifier getModelResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();
        return new Identifier(MOD_ID, "geo/" + texture + ".geo.json");
    }

    @Override
    public Identifier getTextureResource(ArmorModelItem animatable) {
        var texture = animatable.getArmorTexture();
        return new Identifier(MOD_ID, "textures/armor/" + texture + ".png");

    }

    @Override
    public Identifier getAnimationResource(ArmorModelItem animatable) {
        return null;
    }
}
