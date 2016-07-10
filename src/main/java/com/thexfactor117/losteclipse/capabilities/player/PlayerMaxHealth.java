package com.thexfactor117.losteclipse.capabilities.player;

import java.util.UUID;

import javax.annotation.Nullable;

import com.thexfactor117.levels.misc.EnumAttributeModifierOperations;
import com.thexfactor117.losteclipse.api.capabilities.IPlayerMaxHealth;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 
 * @author TheXFactor117
 *
 */
public class PlayerMaxHealth implements IPlayerMaxHealth
{
	private float maxHealth;
	private final EntityLivingBase entity;
	
	public PlayerMaxHealth(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	@Override
	public float getMaxHealth() 
	{
		return maxHealth;
	}

	@Override
	public void setMaxHealth(float healthToBeAdded) 
	{
		maxHealth = healthToBeAdded;
		onSetMaxHealth();
	}
	
	protected void onSetMaxHealth()
	{
		if (entity == null) return;
		
		if (entity instanceof EntityPlayer)
		{
			UUID uuid = UUID.randomUUID();
			
			if (entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(uuid) == null)
			{
				AttributeModifier maxHealth = new AttributeModifier(uuid, "maxHealth", this.maxHealth, EnumAttributeModifierOperations.ADD_VAL_TO_BASE.ordinal());
				entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(maxHealth);
				this.maxHealth = 0;
			}
		}
	}
}
