package com.deepdark;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import com.deepdark.block.ModBlocks;
import com.deepdark.entity.ModEntities;
import com.deepdark.entity.effect.ModStatusEffects;
import com.deepdark.item.ModItemGroups;
import com.deepdark.item.ModItems;
import com.deepdark.world.gen.ModWorldGeneration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Dev References:<br></br>
 * 
 * {@link Items}<br></br>
 * {@link Blocks}<br></br>
 * {@link ToolMaterials}
*/

public class deepdark implements ModInitializer {
	public static final String MOD_ID = "deepdark";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEntities.registerEntities();
		ModStatusEffects.registerStatusEffects();
		ModWorldGeneration.generateModWorldGen();

		CustomPortalBuilder.beginPortal()
			.frameBlock(Blocks.REINFORCED_DEEPSLATE)
			.destDimID(new Identifier(MOD_ID, "deepdark"))
			.tintColor(0x015D52)
			.registerPortal();
	}
}