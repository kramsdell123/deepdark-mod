package com.deepdark.entity.client;

import com.deepdark.deepdark;
import com.deepdark.entity.types.WardenBossEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class WardenBossRenderer extends MobEntityRenderer<WardenBossEntity, WardenBossModel<WardenBossEntity>> {
   private static final Identifier TEXTURE = new Identifier(deepdark.MOD_ID, "textures/entity/warden_boss/warden_boss.png");
   private static final Identifier BIOLUMINESCENT_LAYER_TEXTURE = new Identifier(deepdark.MOD_ID, "textures/entity/warden_boss/warden_boss_bioluminescent_layer.png");
   private static final Identifier HEART_TEXTURE = new Identifier(deepdark.MOD_ID, "textures/entity/warden_boss/warden_boss_heart.png");
   private static final Identifier PULSATING_SPOTS_1_TEXTURE = new Identifier(deepdark.MOD_ID, "textures/entity/warden_boss/warden_boss_pulsating_spots_1.png");
   private static final Identifier PULSATING_SPOTS_2_TEXTURE = new Identifier(deepdark.MOD_ID, "textures/entity/warden_boss/warden_boss_pulsating_spots_2.png");

   public WardenBossRenderer(EntityRendererFactory.Context context) {
      super(context, new WardenBossModel<>(context.getPart(ModModelLayers.warden_boss)), 0.9F);
      this.addFeature(new WardenBossFeatureRenderer<>(this, BIOLUMINESCENT_LAYER_TEXTURE, (warden, tickDelta, animationProgress) -> {
         return 1.0F;
      }, WardenBossModel::getHeadAndLimbs));
      this.addFeature(new WardenBossFeatureRenderer<>(this, PULSATING_SPOTS_1_TEXTURE, (warden, tickDelta, animationProgress) -> {
         return Math.max(0.0F, MathHelper.cos(animationProgress * 0.045F) * 0.25F);
      }, WardenBossModel::getBodyHeadAndLimbs));
      this.addFeature(new WardenBossFeatureRenderer<>(this, PULSATING_SPOTS_2_TEXTURE, (warden, tickDelta, animationProgress) -> {
         return Math.max(0.0F, MathHelper.cos(animationProgress * 0.045F + 3.1415927F) * 0.25F);
      }, WardenBossModel::getBodyHeadAndLimbs));
      this.addFeature(new WardenBossFeatureRenderer<>(this, TEXTURE, (warden, tickDelta, animationProgress) -> {
         return warden.getTendrilPitch(tickDelta);
      }, WardenBossModel::getTendrils));
      this.addFeature(new WardenBossFeatureRenderer<>(this, HEART_TEXTURE, (warden, tickDelta, animationProgress) -> {
         return warden.getHeartPitch(tickDelta);
      }, WardenBossModel::getBody));
   }

   @Override
   public void render(WardenBossEntity mobEntity, float f, float g, MatrixStack matrixStack,
           VertexConsumerProvider vertexConsumerProvider, int i) {
       matrixStack.scale(3, 3, 3);
       super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }

   public Identifier getTexture(WardenBossEntity wardenEntity) {
      return TEXTURE;
   }
}
