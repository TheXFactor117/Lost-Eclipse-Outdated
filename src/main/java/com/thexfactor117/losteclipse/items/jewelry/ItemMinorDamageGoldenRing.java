package com.thexfactor117.losteclipse.items.jewelry;

import com.thexfactor117.levels.leveling.Rarity;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemMinorDamageGoldenRing extends ItemLEBauble implements IBauble
{
	public ItemMinorDamageGoldenRing(String name, Rarity rarity)
	{
		super(name, rarity);
	}
	
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.worldObj.isRemote && entity.ticksExisted%39 == 0) entity.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20*2, 0, false, false));
	}
	
	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.worldObj.isRemote) entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return BaubleType.RING;
	}
}
