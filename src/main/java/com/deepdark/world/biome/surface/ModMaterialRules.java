package com.deepdark.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule SCULK = makeStateRule(Blocks.SCULK);
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition allSkulk = MaterialRules.aboveY(YOffset.aboveBottom(1), 0);

        return MaterialRules.sequence(MaterialRules.condition(allSkulk, SCULK), BEDROCK);
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
