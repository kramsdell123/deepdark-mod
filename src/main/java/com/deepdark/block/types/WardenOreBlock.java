package com.deepdark.block.types;

import com.deepdark.block.ModBlocks;
import com.deepdark.entity.ModEntities;
import com.deepdark.entity.types.WardenBossEntity;
import com.deepdark.world.dimension.ModDimensions;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;

public class WardenOreBlock extends ExperienceDroppingBlock {

    public WardenOreBlock(IntProvider experienceDropped, Settings settings) {
        super(experienceDropped, settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        BlockPos center = getCenter(pos, world);
        WardenBossEntity warden_boss_instance;
        Block block1;
        Block block2;
        Block block3;
        Block block4;
        EntityType<?> warden_boss_type;
        warden_boss_instance = ModEntities.warden_boss.create(world);
        
        if(
            center!=null&&
            world.getRegistryKey() == ModDimensions.deepdark_level_key&&
            (!world.isClient)
        ) {
            block1 = world.getBlockState(new BlockPos(center.getX(), center.getY()-1, center.getZ())).getBlock();
            block2 = world.getBlockState(new BlockPos(center.getX(), center.getY()-2, center.getZ())).getBlock();
            block3 = world.getBlockState(new BlockPos(center.getX()-1, center.getY()-1, center.getZ())).getBlock();
            block4 = world.getBlockState(new BlockPos(center.getX()+1, center.getY()-1, center.getZ())).getBlock();
            if(
                block1 == Blocks.REINFORCED_DEEPSLATE&&
                block2 == Blocks.REINFORCED_DEEPSLATE&&
                block3 == Blocks.REINFORCED_DEEPSLATE&&
                block4 == Blocks.REINFORCED_DEEPSLATE
            ) {
                warden_boss_instance.setPos(center.getX(), center.getY()+5, center.getZ());
                world.breakBlock(center, false);
                world.breakBlock(new BlockPos(center.getX()-1, center.getY(), center.getZ()), false);
                world.breakBlock(new BlockPos(center.getX()+1, center.getY(), center.getZ()), false);
                world.breakBlock(new BlockPos(center.getX()-1, center.getY()-1, center.getZ()), false);
                world.breakBlock(new BlockPos(center.getX()+1, center.getY()-1, center.getZ()), false);
                world.breakBlock(new BlockPos(center.getX(), center.getY()-1, center.getZ()), false);
                world.breakBlock(new BlockPos(center.getX(), center.getY()-2, center.getZ()), false);
                warden_boss_type = warden_boss_instance.getType();
                warden_boss_type.spawn((ServerWorld) world, center, SpawnReason.MOB_SUMMONED);
            } else {
                block3 = world.getBlockState(new BlockPos(center.getX(), center.getY()-1, center.getZ()-1)).getBlock();
                block4 = world.getBlockState(new BlockPos(center.getX(), center.getY()-1, center.getZ()+1)).getBlock();
                if(
                    block1 == Blocks.REINFORCED_DEEPSLATE&&
                    block2 == Blocks.REINFORCED_DEEPSLATE&&
                    block3 == Blocks.REINFORCED_DEEPSLATE&&
                    block4 == Blocks.REINFORCED_DEEPSLATE
                ) {
                    warden_boss_instance.setPos(center.getX(), center.getY()+5, center.getZ());
                    warden_boss_type = warden_boss_instance.getType();
                    world.breakBlock(center, false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY(), center.getZ()-1), false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY(), center.getZ()+1), false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY()-1, center.getZ()-1), false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY()-1, center.getZ()+1), false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY()-1, center.getZ()), false);
                    world.breakBlock(new BlockPos(center.getX(), center.getY()-2, center.getZ()), false);
                    warden_boss_type.spawn((ServerWorld) world, center, SpawnReason.MOB_SUMMONED);
                }
            }
        }
    }
    
    private BlockPos getCenter(BlockPos block, World world) {
        if(
            world.getBlockState(new BlockPos(block.getX()+1, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX()+2, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore
        ) {
            return new BlockPos(block.getX()+1, block.getY(), block.getZ());
        } else if (
            world.getBlockState(new BlockPos(block.getX()-1, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX()+1, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore
        ) {
            return block;
        } else if (
            world.getBlockState(new BlockPos(block.getX()-1, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX()-2, block.getY(), block.getZ())).getBlock() == ModBlocks.warden_ore
        ) {
            return new BlockPos(block.getX()-1, block.getY(), block.getZ());
        } else if(
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()+1)).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()+2)).getBlock() == ModBlocks.warden_ore
        ) {
            return new BlockPos(block.getX(), block.getY(), block.getZ()+1);
        } else if (
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()-1)).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()+1)).getBlock() == ModBlocks.warden_ore
        ) {
            return block;
        } else if (
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()-1)).getBlock() == ModBlocks.warden_ore&&
            world.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ()-2)).getBlock() == ModBlocks.warden_ore
        ) {
            return new BlockPos(block.getX(), block.getY(), block.getZ()-1);
        }
        return null;
    }
}
