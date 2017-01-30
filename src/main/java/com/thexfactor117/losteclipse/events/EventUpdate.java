package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMaxMana;
import com.thexfactor117.losteclipse.capabilities.player.Mana;
import com.thexfactor117.losteclipse.capabilities.player.MaxMana;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventUpdate 
{
	@SubscribeEvent
	public void updateMana(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			MaxMana capMaxMana = (MaxMana) player.getCapability(CapabilityMaxMana.MAX_MANA_CAP, null);
			Mana capMana = (Mana) player.getCapability(CapabilityMana.MANA_CAP, null);
			
			if (capMaxMana != null && capMana != null)
			{
				// set max mana if at 0
				if (capMaxMana.getMaxMana() == 0)
				{
					int startingMaxMana = 100;
					capMaxMana.setMaxMana(startingMaxMana);
					capMana.setMana(capMaxMana.getMaxMana());
				}
				
				if (capMana.getMana() != capMaxMana.getMaxMana())
				{
					int tick = 0;
					tick++;
					
					if (tick % 20 == 0)
					{
						int manaRegenRate = 3;
						capMana.setMana(capMana.getMana() + manaRegenRate);
						
						if (capMana.getMana() > capMaxMana.getMaxMana())
							capMana.setMana(capMaxMana.getMaxMana());
					}
				}
			}
		}
	}
}
