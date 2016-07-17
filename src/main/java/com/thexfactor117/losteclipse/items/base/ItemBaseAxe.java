package com.thexfactor117.losteclipse.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemBaseAxe extends ItemAxe
{
	public ItemBaseAxe(ToolMaterial material, String name, String modid)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBaseAxe(ToolMaterial material, String name, String modid, CreativeTabs tab, float damage, float speed)
	{
		super(material, damage, speed);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
}