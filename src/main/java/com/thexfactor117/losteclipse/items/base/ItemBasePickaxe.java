package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemBasePickaxe extends ItemPickaxe
{
	public ItemBasePickaxe(ToolMaterial material, String name, String modid)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBasePickaxe(ToolMaterial material, String name, String modid, CreativeTabs tab)
	{
		super(material);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
	
	public void registerItemRenderer()
	{
		LostEclipse.proxy.registerItemRenderers(this, 0);
	}
}
