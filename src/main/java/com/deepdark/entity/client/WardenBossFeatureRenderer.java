package com.deepdark.entity.client;

import java.util.List;

import com.deepdark.entity.types.WardenBossEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.WardenFeatureRenderer.AnimationAngleAdjuster;
import net.minecraft.client.render.entity.feature.WardenFeatureRenderer.ModelPartVisibility;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class WardenBossFeatureRenderer<T extends WardenBossEntity, M extends WardenBossModel<T>> extends FeatureRenderer<T, M> {
   private final Identifier texture;
   private final AnimationAngleAdjuster<T> animationAngleAdjuster;
   private final ModelPartVisibility<T, M> modelPartVisibility;

   public WardenBossFeatureRenderer(FeatureRendererContext<T, M> context, Identifier texture, AnimationAngleAdjuster<T> animationAngleAdjuster, ModelPartVisibility<T, M> modelPartVisibility) {
      super(context);
      this.texture = texture;
      this.animationAngleAdjuster = animationAngleAdjuster;
      this.modelPartVisibility = modelPartVisibility;
   }

   public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T wardenEntity, float f, float g, float h, float j, float k, float l) {
      if (!wardenEntity.isInvisible()) {
         this.updateModelPartVisibility();
         VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucentEmissive(this.texture));
         (this.getContextModel()).render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(wardenEntity, 0.0F), 1.0F, 1.0F, 1.0F, this.animationAngleAdjuster.apply(wardenEntity, h, j));
         this.unhideAllModelParts();
      }
   }

   private void updateModelPartVisibility() {
      List<ModelPart> list = this.modelPartVisibility.getPartsToDraw((M)this.getContextModel());
      (this.getContextModel()).getPart().traverse().forEach((part) -> {
         part.hidden = true;
      });
      list.forEach((part) -> {
         part.hidden = false;
      });
   }

   private void unhideAllModelParts() {
      (this.getContextModel()).getPart().traverse().forEach((part) -> {
         part.hidden = false;
      });
   }
}
