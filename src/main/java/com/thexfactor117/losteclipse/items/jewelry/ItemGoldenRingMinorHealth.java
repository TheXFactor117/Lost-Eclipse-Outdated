package com.thexfactor117.losteclipse.items.jewelry;

import java.util.UUID;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.items.base.ItemLEBauble;
import com.thexfactor117.losteclipse.util.EnumAttributeModifierOperations;

import baubles.api.BaubleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemGoldenRingMinorHealth extends ItemLEBauble
{
	private static double multiplier = 0.1F;
	
	public ItemGoldenRingMinorHealth(String name, Rarity rarity)
	{
		super(name, rarity);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected)
	{
		if (!world.isRemote)
		{
			NBTTagCompound nbt = stack.getTagCompound();

			if (nbt != null)
			{
				if (nbt.getString("UUID") == null)
				{
					nbt.setString("UUID", UUID.randomUUID().toString());
				}
			}
			else
			{
				nbt = new NBTTagCompound();
				stack.setTagCompound(nbt);
				nbt.setString("UUID", UUID.randomUUID().toString());
			}
		}
	}
	
	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase entity) 
	{
		if (entity.worldObj.isRemote) entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
		else
		{	
			NBTTagCompound nbt = stack.getTagCompound();
			
			if (nbt != null)
			{
				AttributeModifier maxHealth = new AttributeModifier(UUID.fromString(nbt.getString("UUID")), "maxHealth", multiplier, EnumAttributeModifierOperations.ADD_PERC_VAL_TO_SUM.ordinal());
				LostEclipse.LOGGER.info("UUID: " + maxHealth.getID());
				
				if (entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(UUID.fromString(nbt.getString("UUID"))) == null)
				{
					entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(maxHealth);
					LostEclipse.LOGGER.info("Max health: " + entity.getMaxHealth());
				}
			}
		}
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase entity) 
	{
		if (!entity.worldObj.isRemote)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			
			if (nbt != null)
			{
				AttributeModifier maxHealth = new AttributeModifier(UUID.fromString(nbt.getString("UUID")), "maxHealth", multiplier, EnumAttributeModifierOperations.ADD_PERC_VAL_TO_SUM.ordinal());
				
				if (entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifier(UUID.fromString(nbt.getString("UUID"))) != null)
				{
					entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(maxHealth);
				}
			}
		}
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack stack) 
	{
		return BaubleType.RING;
	}
}
