package com.conquestreforged.arms.init;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AttributeInit {
    //public static final EntityAttribute MATERIAL = register("generic.material", )

    private static EntityAttribute register(String id, EntityAttribute attribute) {
        return Registry.register(Registries.ATTRIBUTE, id, attribute);
    }
}
