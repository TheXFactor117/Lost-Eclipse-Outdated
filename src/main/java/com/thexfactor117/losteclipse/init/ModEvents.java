package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.events.EventLivingDeath;
import com.thexfactor117.losteclipse.events.EventLivingHurt;
import com.thexfactor117.losteclipse.events.EventLivingUpdate;

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
		
		MinecraftForge.EVENT_BUS.register(new EventLivingHurt());
		MinecraftForge.EVENT_BUS.register(new EventLivingDeath());
		MinecraftForge.EVENT_BUS.register(new EventLivingUpdate());
		
		LostEclipse.LOGGER.info("Event registration finished.");
	}
}
