package com.deepdark.world.dimension;

import com.deepdark.deepdark;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> deepdark_key = RegistryKey.of(RegistryKeys.DIMENSION, new Identifier(deepdark.MOD_ID, "deepdark"));
    public static final RegistryKey<World> deepdark_level_key = RegistryKey.of(RegistryKeys.WORLD, new Identifier(deepdark.MOD_ID, "deepdark"));
    public static final RegistryKey<DimensionType> deepdark_type = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(deepdark.MOD_ID, "deepdark_type"));
}
