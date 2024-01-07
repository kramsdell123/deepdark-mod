package com.deepdark.entity.types;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class WardenBossEntity extends WardenEntity {
    public AnimationState idleAnimationStateb = new AnimationState();
    public AnimationState roaringAnimationStateb = new AnimationState();
    public AnimationState sniffingAnimationStateb = new AnimationState();
    public AnimationState emergingAnimationStateb = new AnimationState();
    public AnimationState diggingAnimationStateb = new AnimationState();
    public AnimationState attackingAnimationStateb = new AnimationState();
    public AnimationState chargingSonicBoomAnimationStateb = new AnimationState();

    private final ServerBossBar bossBar;
    private final World world;

    public WardenBossEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.world = world;
        this.bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.BLUE, BossBar.Style.PROGRESS);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossBar.setName(this.getDisplayName());
        this.bossBar.clearPlayers();
        for(PlayerEntity player : this.world.getPlayers()) {
            if(Math.sqrt(
                (player.getX()-this.getX())*(player.getX()-this.getX())+
                (player.getY()-this.getY())*(player.getY()-this.getY())+
                (player.getZ()-this.getZ())*(player.getZ()-this.getZ())
            )<=75&&this.world.getDimension() == player.getWorld().getDimension()&&(!this.dead)&&(!(player instanceof ClientPlayerEntity))) {
                this.bossBar.addPlayer((ServerPlayerEntity) player);
            }
        }
        this.bossBar.setPercent(this.getHealth()/this.getMaxHealth());
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    public static DefaultAttributeContainer.Builder createWardenBossAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 600)
            .add(EntityAttributes.GENERIC_ARMOR, .5f)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }
    
}
