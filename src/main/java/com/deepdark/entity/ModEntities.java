package com.deepdark.entity;

import com.deepdark.deepdark;
import com.deepdark.entity.types.WardenBossEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WardenBossEntity> warden_boss = Registry.register(
        Registries.ENTITY_TYPE,
            new Identifier(deepdark.MOD_ID, "warden_boss"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, WardenBossEntity::new)
            .dimensions(EntityDimensions.fixed(2, 3)).build());

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(warden_boss, WardenBossEntity.createWardenBossAttributes());
        deepdark.LOGGER.info("Registered Entities");
    }
}
