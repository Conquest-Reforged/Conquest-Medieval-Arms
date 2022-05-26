package com.conquestreforged.arms.items.armor.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModelGenericChest<T extends LivingEntity> extends HumanoidModel<T> {
    private final ModelPart body;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "winged_hussar_chest"), "main");

    public ModelGenericChest(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.rightarm = root.getChild("right_arm");
        this.leftarm = root.getChild("left_arm");
        this.rightleg = root.getChild("right_leg");
        this.leftleg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale0 = new CubeDeformation(0.262F, 0.262F, 0.262F);
        CubeDeformation scale1 = new CubeDeformation(0.263F, 0.263F, 0.263F);
        CubeDeformation scale2 = new CubeDeformation(0.261F, 0.261F, 0.261F);
        CubeDeformation scale4 = new CubeDeformation(0.259F, 0.259F, 0.259F);

        //Chestplate
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body1 = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(38, 13).addBox(-4.0F, 0.0F, -2.5F, 8.0F, 14.0F, 5.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -19.5F, 2.5F, 0.0F, 32.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Arms
        PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));


        //Right Foot
        PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 16).addBox(-1.98F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Left Foot
        PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.02F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        this.leftleg.visible = true;
        this.rightleg.visible = true;
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay);

    }

}