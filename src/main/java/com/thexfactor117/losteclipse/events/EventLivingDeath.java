package com.thexfactor117.losteclipse.events;

import com.thexfactor117.levels.capabilities.CapabilityEnemyLevel;
import com.thexfactor117.levels.capabilities.IEnemyLevel;
import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;
import com.thexfactor117.losteclipse.network.PacketCharacterLevel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventLivingDeath 
{
	@SubscribeEvent()
	public void onLivingDeath(LivingDeathEvent event)
	{
		enemyDeath(event);
	}
	
	private void enemyDeath(LivingDeathEvent event)
	{
		if (event.getEntityLiving() instanceof EntityLivingBase && event.getSource().getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
			EntityLivingBase enemy = (EntityLivingBase) event.getEntityLiving();
			
			if (player != null && enemy != null)
			{
				if (!player.getEntityWorld().isRemote)
					updateCharacterExperience(player, enemy);
			}
		}
	}
	
	private void updateCharacterExperience(EntityPlayer player, EntityLivingBase enemy)
	{
		int experience = 0;

		if (enemy instanceof EntityPlayer)
			experience = 50;
		else if (enemy instanceof EntityMob)
		{
			IEnemyLevel enemyLevel = enemy.getCapability(CapabilityEnemyLevel.ENEMY_LEVEL_CAP, null);
			ICharacterLevel charLevel = player.getCapability(CapabilityCharacterLevel.CHARACTER_LEVEL, null);
			
			if (enemyLevel != null && charLevel != null)
			{
				switch (enemyLevel.getEnemyLevel())
				{
					case 0:
						break;
					case 1:
						break;
					case 2:
						experience = (int) (enemy.getMaxHealth() * 0.2);
						break;
					case 3:
						experience = (int) (enemy.getMaxHealth() * 0.25);
						break;
					case 4:
						experience = (int) (enemy.getMaxHealth() * 0.3);
						break;
					case 5:
						experience = (int) (enemy.getMaxHealth() * 0.35);
						break;
					case 6:
						experience = (int) (enemy.getMaxHealth() * 0.4);
						break;
				}
				
				charLevel.addExperience(experience);
				LostEclipse.network.sendTo(new PacketCharacterLevel(charLevel.getLevel(), charLevel.getExperience(), charLevel.getSkillPoints()), (EntityPlayerMP) player);
				LostEclipse.LOGGER.info("Adding experience! " + charLevel.getExperience());
			}
		}
	}
}
