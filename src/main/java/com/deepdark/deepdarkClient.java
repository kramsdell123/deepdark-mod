package com.deepdark;
import com.deepdark.entity.ModEntities;
import com.deepdark.entity.client.ModModelLayers;
import com.deepdark.entity.client.WardenBossModel;
import com.deepdark.entity.client.WardenBossRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class deepdarkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.warden_boss, WardenBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.warden_boss, WardenBossModel::getTexturedModelData);
    }
}
