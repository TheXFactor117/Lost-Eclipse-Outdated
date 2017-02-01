package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.blocks.BlockBase;
import com.thexfactor117.losteclipse.blocks.BlockLEOre;
import com.thexfactor117.losteclipse.util.RegisterHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModBlocks 
{
	// ores
	public static Block verantiumOre = new BlockLEOre("verantium_ore", 3.0F, 5.0F, 0F, 1);
	public static Block vexalOre = new BlockLEOre("vexal_ore", 3.0F, 5.0F, 0F, 2, ModItems.vexalGem);
	public static Block astrillOre = new BlockLEOre("astrill_ore", 3.0F, 5.0F, 0.25F, 3, ModItems.astrillGem);
	
	// misc
	public static Block verantiumBlock = new BlockBase(Material.IRON, "verantium_block", ModTabs.tabLE, SoundType.METAL, 4.0F, 5.0F, 0F, "pickaxe", 2);
	public static Block verantiumBricks = new BlockBase(Material.IRON, "verantium_bricks", ModTabs.tabLE, SoundType.METAL, 4.0F, 5.0F, 0F, "pickaxe", 2);
	public static Block vexalBlock = new BlockBase(Material.IRON, "vexal_block", ModTabs.tabLE, SoundType.METAL, 4.0F, 5.0F, 0F, "pickaxe", 2);
	public static Block astrillBlock = new BlockBase(Material.IRON, "astrill_block", ModTabs.tabLE, SoundType.METAL, 4.0F, 5.0F, 0F, "pickaxe", 2);
	
	public static void registerBlocks()
	{
		// ores
		RegisterHelper.registerBlocks(verantiumOre);
		RegisterHelper.registerBlocks(vexalOre);
		RegisterHelper.registerBlocks(astrillOre);
		
		// misc
		RegisterHelper.registerBlocks(verantiumBlock);
		RegisterHelper.registerBlocks(verantiumBricks);
		RegisterHelper.registerBlocks(vexalBlock);
		RegisterHelper.registerBlocks(astrillBlock);
	}
}
