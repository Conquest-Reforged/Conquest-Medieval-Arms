package com.conquestreforged.arms.items.armor;

import mod.azure.azurelib.common.model.AzBakedModel;
import mod.azure.azurelib.common.model.AzBone;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.armor.bone.AzDefaultArmorBoneProvider;
import net.minecraft.resources.ResourceLocation;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModArmorRenderer extends AzArmorRenderer {

    public ModArmorRenderer(String geoPath, String texturePath) {
        super(AzArmorRendererConfig.builder(
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "geo/" + geoPath + ".geo.json"),
                ResourceLocation.parse(texturePath)
        ).setBoneProvider(new BootsOnLegsBoneProvider()).build());
    }


    /**
     * Remaps boot bones to the leg bones so that when the FEET slot is rendered,
     * applyBoneVisibilityBySlot shows the leg geometry instead of separate boot bones.
     */
    private static class BootsOnLegsBoneProvider extends AzDefaultArmorBoneProvider {

        @Override
        public AzBone getRightBootBone(AzBakedModel model) {
            // Fall back to the right leg bone — boots ride on the legs
            return model.getBoneOrNull(BONE_ARMOR_RIGHT_LEG_NAME);
        }

        @Override
        public AzBone getLeftBootBone(AzBakedModel model) {
            return model.getBoneOrNull(BONE_ARMOR_LEFT_LEG_NAME);
        }
    }

}