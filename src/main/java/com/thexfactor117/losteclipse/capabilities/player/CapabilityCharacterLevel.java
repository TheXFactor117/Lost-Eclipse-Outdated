package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.util.CapabilityUtils;
import com.thexfactor117.losteclipse.util.Reference;
import com.thexfactor117.losteclipse.util.SimpleCapabilityProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class CapabilityCharacterLevel 
{
	@CapabilityInject(ICharacterLevel.class)
	public static final Capability<ICharacterLevel> CHARACTER_LEVEL = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "CharacterLevel");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(ICharacterLevel.class, new Capability.IStorage<ICharacterLevel>() 
		{
			@Override
			public NBTBase writeNBT(Capability<ICharacterLevel> capability, ICharacterLevel instance, EnumFacing side) 
			{
				NBTTagCompound nbt = new NBTTagCompound();
				
				nbt.setInteger("CharacterLevel", instance.getLevel());
				nbt.setInteger("CharacterExperience", instance.getExperience());
				nbt.setInteger("CharacterSkillPoints", instance.getSkillPoints());
				
				return nbt;
			}

			@Override
			public void readNBT(Capability<ICharacterLevel> capability, ICharacterLevel instance, EnumFacing side, NBTBase nbt) 
			{
				NBTTagCompound compound = (NBTTagCompound) nbt;
				
				instance.setLevel(compound.getInteger("CharacterLevel"));
				instance.setExperience(compound.getInteger("CharacterExperience"));
				instance.setSkillPoints(compound.getInteger("CharacterSkillPoints"));
			}
		}, () -> new CharacterLevel(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static ICharacterLevel getCharacterLevel(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, CHARACTER_LEVEL, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(ICharacterLevel characterLevel) 
	{
		return new SimpleCapabilityProvider<>(CHARACTER_LEVEL, DEFAULT_FACING, characterLevel);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) 
		{
			if (event.getObject() instanceof EntityPlayer) 
			{
				final CharacterLevel characterLevel = new CharacterLevel((EntityPlayer) event.getObject());
				event.addCapability(ID, createProvider(characterLevel));
			}
		}
		
		@SubscribeEvent
		public void playerClone(PlayerEvent.Clone event) 
		{
			ICharacterLevel oldCharacterLevel = getCharacterLevel(event.getOriginal());
			ICharacterLevel newCharacterLevel = getCharacterLevel(event.getEntityLiving());

			if (newCharacterLevel != null && oldCharacterLevel != null)
			{
				newCharacterLevel.setLevel(oldCharacterLevel.getLevel());
				newCharacterLevel.setExperience(oldCharacterLevel.getExperience());
				newCharacterLevel.setSkillPoints(oldCharacterLevel.getSkillPoints());
			}
		}
	}
}
