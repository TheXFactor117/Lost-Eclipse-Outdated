package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.blocks.BlockLEOre;
import com.thexfactor117.losteclipse.misc.RegisterHelper;

import net.minecraft.block.Block;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModBlocks 
{
	public static Block malachiteOre = new BlockLEOre("malachiteOre", 3.0F, 5.0F, 0F, 1);
	public static Block vexalOre = new BlockLEOre("vexalOre", 3.0F, 5.0F, 0F, 2, ModItems.vexalGem);
	public static Block astrillOre = new BlockLEOre("astrillOre", 3.0F, 5.0F, 0.25F, 3, ModItems.astrillGem);
		
	public static void registerBlocks()
	{
		RegisterHelper.registerBlocks(malachiteOre);
		RegisterHelper.registerBlocks(vexalOre);
		RegisterHelper.registerBlocks(astrillOre);
	}
}
