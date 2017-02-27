package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.api.IFlameCloak;
import com.thexfactor117.losteclipse.capabilities.api.IMana;
import com.thexfactor117.losteclipse.capabilities.api.IMaxMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMaxMana;
import com.thexfactor117.losteclipse.network.PacketMana;
import com.thexfactor117.losteclipse.network.PacketMaxMana;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventLivingUpdate 
{
	private int manaTick = 0;
	private int flameCloakTick = 0;
	
	@SubscribeEvent
	public void updateLiving(LivingUpdateEvent event)
	{
		updatePlayer(event);
		updateEnemy(event);
	}
	
	private void updatePlayer(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			updateMana(player);
			updateFlameCloak(player);
		}
	}
	
	private void updateEnemy(LivingUpdateEvent event)
	{
		
	}
	
	private void updateMana(EntityPlayer player)
	{
		if (!player.getEntityWorld().isRemote)
		{
			IMaxMana capMaxMana = (IMaxMana) player.getCapability(CapabilityMaxMana.MAX_MANA_CAP, null);
			IMana capMana = (IMana) player.getCapability(CapabilityMana.MANA_CAP, null);
			
			if (capMaxMana != null && capMana != null)
			{
				// set max mana if at 0
				if (capMaxMana.getMaxMana() == 0)
				{
					int startingMaxMana = 100;
					capMaxMana.setMaxMana(startingMaxMana);
					capMana.setMana(capMaxMana.getMaxMana());
					LostEclipse.network.sendTo(new PacketMana(capMana.getMana()), (EntityPlayerMP) player);
					LostEclipse.network.sendTo(new PacketMaxMana(capMaxMana.getMaxMana()), (EntityPlayerMP) player);
				}
								
				if (capMana.getMana() != capMaxMana.getMaxMana())
				{
					manaTick++;
					
					if (manaTick % 20 == 0)
					{
						int manaRegenRate = 1;
						capMana.setMana(capMana.getMana() + manaRegenRate);
						
						if (capMana.getMana() > capMaxMana.getMaxMana())
							capMana.setMana(capMaxMana.getMaxMana());

						LostEclipse.network.sendTo(new PacketMana(capMana.getMana()), (EntityPlayerMP) player);
						LostEclipse.network.sendTo(new PacketMaxMana(capMaxMana.getMaxMana()), (EntityPlayerMP) player);
						manaTick = 0;
					}
				}
			}
		}
	}
	
	private void updateFlameCloak(EntityPlayer player)
	{
		if (!player.getEntityWorld().isRemote)
		{
			IFlameCloak cloak = (IFlameCloak) player.getCapability(CapabilityFlameCloak.FLAME_CLOAK_CAP, null);
			
			if (cloak != null)
			{
				if (cloak.hasFlameCloak())
				{
					flameCloakTick++;

					if (flameCloakTick == 20 * 30)
					{
						cloak.setFlameCloak(false);
						flameCloakTick = 0;
					}
				}
			}
		}
	}
}
