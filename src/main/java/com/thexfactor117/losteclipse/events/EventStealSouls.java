package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.items.ItemSoulGem;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 * TODO: Optimize this a bit more?
 */
public class EventStealSouls 
{
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if (event.getSource().getSourceOfDamage() instanceof EntityPlayer)
		{
			if (event.getEntityLiving() instanceof EntityMob)
			{
				EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
				EntityMob enemy = (EntityMob) event.getEntityLiving();
				
				if (player != null && enemy != null)
				{
					for (int i = 0; i < player.inventory.mainInventory.size(); i++)
					{
						if (player.inventory.mainInventory.get(i) != null)
						{
							if (player.inventory.mainInventory.get(i).getItem() instanceof ItemSoulGem)
							{
								ItemStack stack = player.inventory.mainInventory.get(i);
								
								if (stack != null)
								{				
									NBTTagCompound nbt = stack.getTagCompound();
									
									if (nbt != null)
									{
										ItemSoulGem soulGem = (ItemSoulGem) stack.getItem();
										
										if (soulGem != null)
										{
											if (enemy.getMaxHealth() <= 40.0F) soulGem.setSouls(nbt, soulGem.getSouls(nbt) + 1);
											if (enemy.getMaxHealth() > 40.0F && enemy.getMaxHealth() < 80.0F) soulGem.setSouls(nbt, soulGem.getSouls(nbt) + 2);
											if (enemy.getMaxHealth() >= 80.0F) soulGem.setSouls(nbt, soulGem.getSouls(nbt) + 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
