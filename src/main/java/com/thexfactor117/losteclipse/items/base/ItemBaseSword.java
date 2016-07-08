package com.thexfactor117.losteclipse.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemBaseSword extends ItemSword
{
	public final ToolMaterial material;
	
	public ItemBaseSword(ToolMaterial material, String name, String modid)
	{
		super(material);
		this.material = material;
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBaseSword(ToolMaterial material, String name, String modid, CreativeTabs tab)
	{
		super(material);
		this.material = material;
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
}
