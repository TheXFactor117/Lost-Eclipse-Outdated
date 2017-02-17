package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 * 
 * @author TheXFactor117
 *
 */
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
	
	public void registerItemRenderer()
	{
		LostEclipse.proxy.registerItemRenderers(this, 0);
	}
}
