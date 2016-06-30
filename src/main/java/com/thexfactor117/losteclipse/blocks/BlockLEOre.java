package com.thexfactor117.losteclipse.blocks;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.init.ModTabs;
import com.thexfactor117.xlib.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * 
 * @author TheXFactor117
 *
 */
public class BlockLEOre extends BlockBase
{
	public BlockLEOre(String name, float hardness, float resistance, float lightValue, int harvestLevel)
	{
		super(Material.ROCK, name, Reference.MODID);
		this.setCreativeTab(ModTabs.tabLE);
		this.setSoundType(SoundType.STONE);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightValue);
		this.setHarvestLevel("pickaxe", harvestLevel);
	}
}
