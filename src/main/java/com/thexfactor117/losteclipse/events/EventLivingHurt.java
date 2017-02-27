package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.capabilities.api.IFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventLivingHurt 
{
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		enemyHurt(event);
		playerHurt(event);
	}
	
	private void enemyHurt(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityLivingBase && event.getSource().getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
			EntityLivingBase enemy = (EntityLivingBase) event.getEntityLiving();
			
			if (player != null && enemy != null)
			{
				
			}
		}
	}
	
	private void playerHurt(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer && event.getSource().getSourceOfDamage() instanceof EntityLivingBase)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			EntityLivingBase attacker = (EntityLivingBase) event.getSource().getSourceOfDamage();
			
			if (player != null && attacker != null)
				useFlameCloak(player, attacker);
		}
	}
	
	private void useFlameCloak(EntityPlayer player, EntityLivingBase attacker)
	{
		IFlameCloak flameCloak = player.getCapability(CapabilityFlameCloak.FLAME_CLOAK_CAP, null);
		
		if (flameCloak != null && flameCloak.hasFlameCloak())
			attacker.setFire(4);
	}
}
