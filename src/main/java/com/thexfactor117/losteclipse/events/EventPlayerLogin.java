package com.thexfactor117.losteclipse.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventPlayerLogin 
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (event.player != null && !event.player.getEntityWorld().isRemote)
		{
			createCapabilities(event.player);
		}
	}
	
	private void createCapabilities(EntityPlayer player)
	{
		
	}
}
