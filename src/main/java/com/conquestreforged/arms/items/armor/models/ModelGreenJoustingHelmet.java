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

public class ModelGreenJoustingHelmet<T extends LivingEntity> extends HumanoidModel<T> {

    private final ModelPart head;

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "green_crested_jousting_helmet"), "main");

    public ModelGreenJoustingHelmet(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        CubeDeformation scale0 = new CubeDeformation(0.55F, 0.55F, 0.55F);
        CubeDeformation scale1 = new CubeDeformation(0.5F, 0.5F, 0.5F);
        CubeDeformation scale2 = new CubeDeformation(1.05F, 1.05F, 1.05F);
        CubeDeformation scale3 = new CubeDeformation(1.55F, 1.55F, 1.55F);
        CubeDeformation scale7 = new CubeDeformation(2.05F, 2.05F, 2.05F);
        CubeDeformation scale4 = new CubeDeformation(0.0F, 0.21F, 0.21F);
        CubeDeformation scale5 = new CubeDeformation(0.61F, 0.9F, 0.0F);
        CubeDeformation scale6 = new CubeDeformation(0.0F, 0.61F, 0.61F);

        //Helmet
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8F, -4.0F, 8.0F, 8.0F, 8.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head1 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, -9.15F, -3.5F, 7.0F, 7.0F, 7.0F, scale1), PartPose.offset(0.0F, 0.0F, 0.0F));
        //PartDefinition head2 = head1.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(17, 48).addBox(-4.5F, -5.18F, -7.5F, 9.0F, 0.0F, 12.0F, scale0), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head3 = head1.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale2), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head4 = head3.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale3), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head2 = head3.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(32, 32).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale7), PartPose.offset(0.0F, 0.0F, 0.0F));


        //crest
        PartDefinition head5 = head4.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(4, 36).addBox(0.0F, -11.70F, -1.5F, 0.0F, 2.0F, 3.0F, scale4), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r0 = head4.addOrReplaceChild("cube_r0", CubeListBuilder.create().texOffs(1, 50).addBox(-11.0F, -23.0F, 0.0F, 21.0F, 13.0F, 0.0F, scale5), PartPose.offset(0.0F, 0.0F, 0.0F));

        //Parts are unused and not rendered but necessary to "add"" to avoid crash
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE.extend(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(1.9F, 12.0F, 0.0F));


        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}
