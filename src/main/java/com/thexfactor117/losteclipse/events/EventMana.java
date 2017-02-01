package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMaxMana;
import com.thexfactor117.losteclipse.capabilities.player.Mana;
import com.thexfactor117.losteclipse.capabilities.player.MaxMana;
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
public class EventMana 
{
	private int tick = 0;
	
	@SubscribeEvent
	public void updateMana(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if (!player.getEntityWorld().isRemote)
			{
				MaxMana capMaxMana = (MaxMana) player.getCapability(CapabilityMaxMana.MAX_MANA_CAP, null);
				Mana capMana = (Mana) player.getCapability(CapabilityMana.MANA_CAP, null);
				
				if (capMaxMana != null && capMana != null)
				{
					// set max mana if at 0
					if (capMaxMana.getMaxMana() == 0)
					{
						int startingMaxMana = 100;
						LostEclipse.network.sendTo(new PacketMaxMana(startingMaxMana), (EntityPlayerMP) player); 
						LostEclipse.network.sendTo(new PacketMana(startingMaxMana), (EntityPlayerMP) player);
						capMaxMana.setMaxMana(startingMaxMana);
						capMana.setMana(capMaxMana.getMaxMana());
					}

					if (capMana.getMana() != capMaxMana.getMaxMana())
					{
						tick++;
						
						if (tick % 20 == 0)
						{
							int manaRegenRate = 3;
							capMana.setMana(capMana.getMana() + manaRegenRate);
							
							if (capMana.getMana() > capMaxMana.getMaxMana())
								capMana.setMana(capMaxMana.getMaxMana());
							
							LostEclipse.network.sendTo(new PacketMana(capMana.getMana()), (EntityPlayerMP) player);
						}
					}
				}
			}
		}
	}
}
