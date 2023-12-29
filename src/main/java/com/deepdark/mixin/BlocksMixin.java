package com.deepdark.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

@Mixin(Blocks.class)
public class BlocksMixin {
    @Redirect(
    slice = @Slice(
      from = @At(
        value = "CONSTANT",
        args= {
          "stringValue=reinforced_deepslate"
        },
        ordinal = 0
      )
    ),
    at = @At(
      value = "NEW",
      target = "Lnet/minecraft/block/Block;*",
      ordinal = 0
    ),
    method = "<clinit>")
    private static Block reinforced_deepslate(AbstractBlock.Settings settings) {
        return new Block(Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).requiresTool().instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.DEEPSLATE).strength(55.0F, 1200.0F));
    }
}
