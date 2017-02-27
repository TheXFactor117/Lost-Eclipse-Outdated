package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.IMana;
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

public class CapabilityMana 
{
	@CapabilityInject(IMana.class)
	public static final Capability<IMana> MANA_CAP = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "Mana");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(IMana.class, new Capability.IStorage<IMana>() 
		{
			@Override
			public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side) 
			{
				NBTTagCompound nbt = new NBTTagCompound();
				
				nbt.setFloat("Mana", instance.getMana());
				nbt.setFloat("MaxMana", instance.getMaxMana());
				nbt.setFloat("ManaPerSec", instance.getManaPerSec());
				
				return nbt;
			}

			@Override
			public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt) 
			{
				NBTTagCompound compound = (NBTTagCompound) nbt;
				
				instance.setMana(compound.getFloat("Mana"));
				instance.setMaxMana(compound.getFloat("MaxMana"));
				instance.setManaPerSec(compound.getFloat("ManaPerSec"));
			}
		}, () -> new Mana(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static IMana getMana(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, MANA_CAP, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(IMana mana) 
	{
		return new SimpleCapabilityProvider<>(MANA_CAP, DEFAULT_FACING, mana);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) 
		{
			if (event.getObject() instanceof EntityPlayer) 
			{
				final Mana mana = new Mana((EntityPlayer) event.getObject());
				event.addCapability(ID, createProvider(mana));
			}
		}
		
		@SubscribeEvent
		public void playerClone(PlayerEvent.Clone event) 
		{
			IMana oldMana = getMana(event.getOriginal());
			IMana newMana = getMana(event.getEntityLiving());

			if (newMana != null && oldMana != null)
			{
				newMana.setMana(oldMana.getMana());
				newMana.setMaxMana(oldMana.getMaxMana());
				newMana.setManaPerSec(oldMana.getManaPerSec());
			}
		}
	}
}
