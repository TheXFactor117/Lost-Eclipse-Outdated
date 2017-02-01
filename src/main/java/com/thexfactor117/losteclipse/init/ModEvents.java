package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.events.EventFlameCloak;
import com.thexfactor117.losteclipse.events.EventUpdatePlayer;

import net.minecraftforge.common.MinecraftForge;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModEvents 
{
	public static void registerEvents()
	{
		LostEclipse.LOGGER.info("Registering events...");
		
		MinecraftForge.EVENT_BUS.register(new EventFlameCloak());
		MinecraftForge.EVENT_BUS.register(new EventUpdatePlayer());
		
		LostEclipse.LOGGER.info("Event registration finished.");
	}
}
