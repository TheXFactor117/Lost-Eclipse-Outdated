package com.thexfactor117.losteclipse.items.jewelry;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.base.ItemLEBauble;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemGoldenRingMinorDamage extends ItemLEBauble implements IBauble
{
	public ItemGoldenRingMinorDamage(String name, Rarity rarity)
	{
		super(name, rarity);
	}
	
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.getEntityWorld().isRemote && entity.ticksExisted%39 == 0) entity.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20*2, 0, false, false));
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return BaubleType.RING;
	}
}
