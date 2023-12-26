package com.deepdark.world.biome.surface;

import com.deepdark.world.biome.ModBiomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule SCULK = makeStateRule(Blocks.SCULK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule sculkSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, SCULK), SCULK);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.deep_dark_dimension),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, SCULK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SCULK)),

                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, sculkSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
