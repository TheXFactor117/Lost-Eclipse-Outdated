package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.api.capabilities.IFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventFlameCloak 
{
	@SubscribeEvent
	public void hasFlameCloak(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer && event.getSource().getSourceOfDamage() instanceof EntityLivingBase)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			EntityLivingBase attacker = (EntityLivingBase) event.getSource().getSourceOfDamage();
			
			if (player != null && attacker != null)
			{
				IFlameCloak flameCloak = player.getCapability(CapabilityFlameCloak.FLAME_CLOAK_CAP, null);
				
				if (flameCloak != null && flameCloak.hasFlameCloak())
				{
					attacker.setFire(5);
					flameCloak.setFlameCloak(false);
				}
			}
		}
	}
}
