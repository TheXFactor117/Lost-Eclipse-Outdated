package com.thexfactor117.losteclipse.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * 
 * @author TheXFactor117
 *
 */
public class BlockBase extends Block
{
	public BlockBase(Material material, String name, String modid)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public BlockBase(Material material, String name, String modid, CreativeTabs tab)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
	
	public BlockBase(Material material, String name, String modid, CreativeTabs tab, SoundType soundType, float hardness, float resistance, float lightValue, String harvestType, int harvestLevel)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		this.setSoundType(soundType);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightValue);
		this.setHarvestLevel(harvestType, harvestLevel);
	}
}
