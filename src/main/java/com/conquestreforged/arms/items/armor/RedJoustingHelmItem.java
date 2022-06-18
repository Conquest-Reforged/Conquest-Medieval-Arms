package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelRedJoustingHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class RedJoustingHelmItem extends ArmorModelItem {

    public RedJoustingHelmItem(ArmorMaterial material, EquipmentSlot head, Properties props, String armorTexture) {
        super(material, head, props, armorTexture);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return new ModelRedJoustingHelmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRedJoustingHelmet.LAYER_LOCATION));
            }
        });
    }
}
