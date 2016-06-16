package com.thexfactor117.losteclipse.items.melee;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.init.ModTabs;

import net.minecraft.item.ItemSword;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemLEMelee extends ItemSword
{
	public final ToolMaterial material;
	
	public ItemLEMelee(ToolMaterial material, String name)
	{
		super(material);
		this.material = material;
		this.setRegistryName(Reference.MODID, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModTabs.tabLE);
	}
}
