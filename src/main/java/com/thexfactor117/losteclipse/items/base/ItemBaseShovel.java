package com.thexfactor117.losteclipse.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemBaseShovel extends ItemSpade
{
	public ItemBaseShovel(ToolMaterial material, String name, String modid)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBaseShovel(ToolMaterial material, String name, String modid, CreativeTabs tab)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
}
