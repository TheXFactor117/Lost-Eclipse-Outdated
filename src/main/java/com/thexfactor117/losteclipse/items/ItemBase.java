package com.thexfactor117.losteclipse.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemBase extends Item
{
	public ItemBase(String name, String modid)
	{
		super();
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBase(String name, String modid, CreativeTabs tab)
	{
		super();
		this.setCreativeTab(tab);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
}
