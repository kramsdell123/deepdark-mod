package com.deepdark.entity.client;

import com.deepdark.entity.types.WardenBossEntity;
import com.google.common.collect.ImmutableList;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.animation.WardenAnimations;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class WardenBossModel<T extends WardenBossEntity> extends SinglePartEntityModel<T> {
   private final ModelPart root;
   protected final ModelPart bone;
   protected final ModelPart body;
   protected final ModelPart head;
   protected final ModelPart rightTendril;
   protected final ModelPart leftTendril;
   protected final ModelPart leftLeg;
   protected final ModelPart leftArm;
   protected final ModelPart leftRibcage;
   protected final ModelPart rightArm;
   protected final ModelPart rightLeg;
   protected final ModelPart rightRibcage;
   private final List<ModelPart> tendrils;
   private final List<ModelPart> justBody;
   private final List<ModelPart> headAndLimbs;
   private final List<ModelPart> bodyHeadAndLimbs;

   public WardenBossModel(ModelPart root) {
      super(RenderLayer::getEntityCutoutNoCull);
      this.root = root;
      this.bone = root.getChild("bone");
      this.body = this.bone.getChild("body");
      this.head = this.body.getChild("head");
      this.rightLeg = this.bone.getChild("right_leg");
      this.leftLeg = this.bone.getChild("left_leg");
      this.rightArm = this.body.getChild("right_arm");
      this.leftArm = this.body.getChild("left_arm");
      this.rightTendril = this.head.getChild("right_tendril");
      this.leftTendril = this.head.getChild("left_tendril");
      this.rightRibcage = this.body.getChild("right_ribcage");
      this.leftRibcage = this.body.getChild("left_ribcage");
      this.tendrils = ImmutableList.of(this.leftTendril, this.rightTendril);
      this.justBody = ImmutableList.of(this.body);
      this.headAndLimbs = ImmutableList.of(this.head, this.leftArm, this.rightArm, this.leftLeg, this.rightLeg);
      this.bodyHeadAndLimbs = ImmutableList.of(this.body, this.head, this.leftArm, this.rightArm, this.leftLeg, this.rightLeg);
   }

   public static TexturedModelData getTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      ModelPartData modelPartData2 = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
      ModelPartData modelPartData3 = modelPartData2.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -13.0F, -4.0F, 18.0F, 21.0F, 11.0F), ModelTransform.pivot(0.0F, -21.0F, 0.0F));
      modelPartData3.addChild("right_ribcage", ModelPartBuilder.create().uv(90, 11).cuboid(-2.0F, -11.0F, -0.1F, 9.0F, 21.0F, 0.0F), ModelTransform.pivot(-7.0F, -2.0F, -4.0F));
      modelPartData3.addChild("left_ribcage", ModelPartBuilder.create().uv(90, 11).mirrored().cuboid(-7.0F, -11.0F, -0.1F, 9.0F, 21.0F, 0.0F).mirrored(false), ModelTransform.pivot(7.0F, -2.0F, -4.0F));
      ModelPartData modelPartData4 = modelPartData3.addChild("head", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0F, -16.0F, -5.0F, 16.0F, 16.0F, 10.0F), ModelTransform.pivot(0.0F, -13.0F, 0.0F));
      modelPartData4.addChild("right_tendril", ModelPartBuilder.create().uv(52, 32).cuboid(-16.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), ModelTransform.pivot(-8.0F, -12.0F, 0.0F));
      modelPartData4.addChild("left_tendril", ModelPartBuilder.create().uv(58, 0).cuboid(0.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), ModelTransform.pivot(8.0F, -12.0F, 0.0F));
      modelPartData3.addChild("right_arm", ModelPartBuilder.create().uv(44, 50).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 28.0F, 8.0F), ModelTransform.pivot(-13.0F, -13.0F, 1.0F));
      modelPartData3.addChild("left_arm", ModelPartBuilder.create().uv(0, 58).cuboid(-4.0F, 0.0F, -4.0F, 8.0F, 28.0F, 8.0F), ModelTransform.pivot(13.0F, -13.0F, 1.0F));
      modelPartData2.addChild("right_leg", ModelPartBuilder.create().uv(76, 48).cuboid(-3.1F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), ModelTransform.pivot(-5.9F, -13.0F, 0.0F));
      modelPartData2.addChild("left_leg", ModelPartBuilder.create().uv(76, 76).cuboid(-2.9F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), ModelTransform.pivot(5.9F, -13.0F, 0.0F));
      return TexturedModelData.of(modelData, 128, 128);
   }

   public void setAngles(T wardenEntity, float f, float g, float h, float i, float j) {
      this.getPart().traverse().forEach(ModelPart::resetTransform);
      float k = h - (float)wardenEntity.age;
      this.setHeadAngle(i, j);
      this.setLimbAngles(f, g);
      this.setHeadAndBodyAngles(h);
      this.setTendrilPitches(wardenEntity, h, k);
      this.updateAnimation(wardenEntity.attackingAnimationStateb, WardenAnimations.ATTACKING, h);
      this.updateAnimation(wardenEntity.chargingSonicBoomAnimationStateb, WardenAnimations.CHARGING_SONIC_BOOM, h);
      this.updateAnimation(wardenEntity.diggingAnimationStateb, WardenAnimations.DIGGING, h);
      this.updateAnimation(wardenEntity.emergingAnimationStateb, WardenAnimations.EMERGING, h);
      this.updateAnimation(wardenEntity.roaringAnimationStateb, WardenAnimations.ROARING, h);
      this.updateAnimation(wardenEntity.sniffingAnimationStateb, WardenAnimations.SNIFFING, h);
   }

   private void setHeadAngle(float yaw, float pitch) {
      this.head.pitch = pitch * 0.017453292F;
      this.head.yaw = yaw * 0.017453292F;
   }

   private void setHeadAndBodyAngles(float animationProgress) {
      float f = animationProgress * 0.1F;
      float g = MathHelper.cos(f);
      float h = MathHelper.sin(f);
      ModelPart var10000 = this.head;
      var10000.roll += 0.06F * g;
      var10000 = this.head;
      var10000.pitch += 0.06F * h;
      var10000 = this.body;
      var10000.roll += 0.025F * h;
      var10000 = this.body;
      var10000.pitch += 0.025F * g;
   }

   private void setLimbAngles(float angle, float distance) {
      float f = Math.min(0.5F, 3.0F * distance);
      float g = angle * 0.8662F;
      float h = MathHelper.cos(g);
      float i = MathHelper.sin(g);
      float j = Math.min(0.35F, f);
      ModelPart var10000 = this.head;
      var10000.roll += 0.3F * i * f;
      var10000 = this.head;
      var10000.pitch += 1.2F * MathHelper.cos(g + 1.5707964F) * j;
      this.body.roll = 0.1F * i * f;
      this.body.pitch = 1.0F * h * j;
      this.leftLeg.pitch = 1.0F * h * f;
      this.rightLeg.pitch = 1.0F * MathHelper.cos(g + 3.1415927F) * f;
      this.leftArm.pitch = -(0.8F * h * f);
      this.leftArm.roll = 0.0F;
      this.rightArm.pitch = -(0.8F * i * f);
      this.rightArm.roll = 0.0F;
      this.setArmPivots();
   }

   private void setArmPivots() {
      this.leftArm.yaw = 0.0F;
      this.leftArm.pivotZ = 1.0F;
      this.leftArm.pivotX = 13.0F;
      this.leftArm.pivotY = -13.0F;
      this.rightArm.yaw = 0.0F;
      this.rightArm.pivotZ = 1.0F;
      this.rightArm.pivotX = -13.0F;
      this.rightArm.pivotY = -13.0F;
   }

   private void setTendrilPitches(T warden, float animationProgress, float tickDelta) {
      float f = warden.getTendrilPitch(tickDelta) * (float)(Math.cos((double)animationProgress * 2.25) * Math.PI * 0.10000000149011612);
      this.leftTendril.pitch = f;
      this.rightTendril.pitch = -f;
   }

   public ModelPart getPart() {
      return this.root;
   }

   public List<ModelPart> getTendrils() {
      return this.tendrils;
   }

   public List<ModelPart> getBody() {
      return this.justBody;
   }

   public List<ModelPart> getHeadAndLimbs() {
      return this.headAndLimbs;
   }

   public List<ModelPart> getBodyHeadAndLimbs() {
      return this.bodyHeadAndLimbs;
   }
}
