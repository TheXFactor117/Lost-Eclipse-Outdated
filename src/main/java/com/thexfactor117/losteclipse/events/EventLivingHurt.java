package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.capabilities.api.IFlameCloak;
import com.thexfactor117.losteclipse.capabilities.api.ISkillTree;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilitySkillTree;
import com.thexfactor117.losteclipse.util.SkillTreeHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventLivingHurt 
{
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onLivingHurt(LivingHurtEvent event)
	{
		enemyHurt(event);
		playerHurt(event);
	}
	
	private void enemyHurt(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityLivingBase && event.getSource().getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
			EntityLivingBase enemy = (EntityLivingBase) event.getEntityLiving();
			
			if (player != null && enemy != null)
			{
				//Skill tree modifications need to go last. Changes to other smaller amounts, like weapon rarity, need to go first.
				
				useSkillTree(event, player, enemy);
			}
		}
	}
	
	private void playerHurt(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer && event.getSource().getSourceOfDamage() instanceof EntityLivingBase)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			EntityLivingBase attacker = (EntityLivingBase) event.getSource().getSourceOfDamage();
			
			if (player != null && attacker != null)
				useFlameCloak(player, attacker);
		}
	}
	
	/*
	 * 
	 * ENEMY HELPERS
	 *
	 */
	
	private void useSkillTree(LivingHurtEvent event, EntityPlayer player, EntityLivingBase enemy)
	{
		ISkillTree tree = player.getCapability(CapabilitySkillTree.SKILL_TREE, null);
		
		if (tree != null)
		{
			/*
			 * Warrior 
			 */
			
			// power
			if (tree.getPowerTier() > 0)
			{
				float multiplier = 1;
				
				switch (tree.getPowerTier())
				{
					case 1:
						multiplier = SkillTreeHelper.POWER_1;
						break;
					case 2:
						multiplier = SkillTreeHelper.POWER_2;
						break;
					case 3:
						multiplier = SkillTreeHelper.POWER_3;
						break;
				}
				
				event.setAmount(event.getAmount() + (event.getAmount() * multiplier));
			}
			
			
		}
	}
	
	/*
	 * 
	 * PLAYER HELPERS
	 *
	 */
	
	private void useFlameCloak(EntityPlayer player, EntityLivingBase attacker)
	{
		IFlameCloak flameCloak = player.getCapability(CapabilityFlameCloak.FLAME_CLOAK_CAP, null);
		
		if (flameCloak != null && flameCloak.hasFlameCloak())
			attacker.setFire(4);
	}
}
