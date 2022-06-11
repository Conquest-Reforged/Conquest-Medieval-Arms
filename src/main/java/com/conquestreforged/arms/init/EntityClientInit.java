package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.render.ModelSpear;
import com.conquestreforged.arms.entities.render.RenderSpear;
import com.conquestreforged.arms.items.armor.models.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class EntityClientInit {
    public static final ModelLayerLocation GENERIC_HELM_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "crusader_helmet"), "main");
    public static final ModelLayerLocation TOURNEY_KNIGHT_HELM_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "tourney_knight_helmet"), "main");
    public static final ModelLayerLocation KNIGHTS_BASCINET_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "knights_bascinet"), "main");
    public static final ModelLayerLocation PLAIN_BASCINET_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "plain_bascinet"), "main");


    @SubscribeEvent
    public static void layers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelFlatCrestHelmet.LAYER_LOCATION, ModelFlatCrestHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelGenericChest.LAYER_LOCATION, ModelGenericChest::createBodyLayer);
        event.registerLayerDefinition(ModelGenericBoots.LAYER_LOCATION, ModelGenericBoots::createBodyLayer);
        event.registerLayerDefinition(ModelWingedHussarChest.LAYER_LOCATION, ModelWingedHussarChest::createBodyLayer);
        event.registerLayerDefinition(ModelGenericLegs.LAYER_LOCATION, ModelGenericLegs::createBodyLayer);
        event.registerLayerDefinition(ModelWingedHussarHelmet.LAYER_LOCATION, ModelWingedHussarHelmet::createHeadLayer);
        event.registerLayerDefinition(GENERIC_HELM_LAYER_LOCATION, ModelGenericHelmet::createHeadLayer);
        event.registerLayerDefinition(TOURNEY_KNIGHT_HELM_LAYER_LOCATION, ModelGenericHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelTeutonicHelmet.LAYER_LOCATION, ModelTeutonicHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelCicakHelmet.LAYER_LOCATION, ModelCicakHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelJoustingHelmet.LAYER_LOCATION, ModelJoustingHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelRedJoustingHelmet.LAYER_LOCATION, ModelRedJoustingHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelYellowJoustingHelmet.LAYER_LOCATION, ModelYellowJoustingHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelGreenJoustingHelmet.LAYER_LOCATION, ModelGreenJoustingHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelSaracenHelmet.LAYER_LOCATION, ModelSaracenHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelVikingHelmet.LAYER_LOCATION, ModelVikingHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelLamellarHelmet.LAYER_LOCATION, ModelLamellarHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelMongolHelmet.LAYER_LOCATION, ModelMongolHelmet::createHeadLayer);
        event.registerLayerDefinition(KNIGHTS_BASCINET_LAYER_LOCATION, ModelMongolHelmet::createHeadLayer);
        event.registerLayerDefinition(RenderSpear.modelLayerLocation, ModelSpear::createLayer);
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //event.registerEntityRenderer(EntityTypes.SPEAR_IRON, RenderSpear::new);
    }
}
