package com.thexfactor117.losteclipse.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemBaseShovel extends ItemSpade
{
	public final ToolMaterial material;
	
	public ItemBaseShovel(ToolMaterial material, String name, String modid)
	{
		super(material);
		this.material = material;
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBaseShovel(ToolMaterial material, String name, String modid, CreativeTabs tab)
	{
		super(material);
		this.material = material;
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
}
