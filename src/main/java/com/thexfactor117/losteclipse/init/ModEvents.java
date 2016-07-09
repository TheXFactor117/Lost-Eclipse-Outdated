package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.events.EventFlameCloak;
import com.thexfactor117.losteclipse.events.EventStealSouls;

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
		
		MinecraftForge.EVENT_BUS.register(new EventStealSouls());
		MinecraftForge.EVENT_BUS.register(new EventFlameCloak());
		
		LostEclipse.LOGGER.info("Event registration finished.");
	}
}
