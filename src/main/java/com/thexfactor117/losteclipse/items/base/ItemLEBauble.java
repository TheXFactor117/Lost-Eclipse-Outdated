package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.levels.leveling.Rarity;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author TheXFactor117
 *
 */
public abstract class ItemLEBauble extends ItemLE implements IBauble
{
	public ItemLEBauble(String name, Rarity rarity) 
	{
		super(name, rarity);
		this.setMaxStackSize(1);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return null;
	}

	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.worldObj.isRemote) entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase entity) {}

	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase entity) {}
	
	@Override
	public boolean canEquip(ItemStack stack, EntityLivingBase entity) 
	{
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack stack, EntityLivingBase entity) 
	{
		return true;
	}
}
