package com.thexfactor117.losteclipse.items.jewelry;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.capabilities.api.IPlayerMaxHealth;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityPlayerMaxHealth;
import com.thexfactor117.losteclipse.items.base.ItemLEBauble;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

public class ItemGoldenRingHealth extends ItemLEBauble implements IBauble
{
	public ItemGoldenRingHealth(String name, Rarity rarity)
	{
		super(name, rarity);
	}
	
	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.worldObj.isRemote) entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
		
		IPlayerMaxHealth maxHealth = entity.getCapability(CapabilityPlayerMaxHealth.PLAYER_MAX_HEALTH_CAP, null);
		
		if (maxHealth != null) maxHealth.setMaxHealth(8F);
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase entity) 
	{
		IPlayerMaxHealth maxHealth = entity.getCapability(CapabilityPlayerMaxHealth.PLAYER_MAX_HEALTH_CAP, null);
		
		if (maxHealth != null) maxHealth.setMaxHealth(-8F);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return BaubleType.RING;
	}
}
