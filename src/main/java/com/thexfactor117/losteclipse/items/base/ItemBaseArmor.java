package com.thexfactor117.losteclipse.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemBaseArmor extends ItemArmor
{
	public ItemBaseArmor(ArmorMaterial material, EntityEquipmentSlot armorType, String name, String modid)
	{
		super(material, 0, armorType);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
	}
	
	public ItemBaseArmor(ArmorMaterial material, EntityEquipmentSlot armorType, String name, String modid, CreativeTabs tab)
	{
		super(material, 0, armorType);
		this.setRegistryName(modid, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
	}
}
