package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.levels.leveling.Rarity;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemRing extends ItemLEBauble implements IBauble
{
	public ItemRing(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return BaubleType.RING;
	}
}
