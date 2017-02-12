package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.IMaxMana;
import com.thexfactor117.losteclipse.util.CapabilityUtils;
import com.thexfactor117.losteclipse.util.Reference;
import com.thexfactor117.losteclipse.util.SimpleCapabilityProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
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
public class CapabilityMaxMana 
{
	@CapabilityInject(IMaxMana.class)
	public static final Capability<IMaxMana> MAX_MANA_CAP = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "MaxMana");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(IMaxMana.class, new Capability.IStorage<IMaxMana>() 
		{
			@Override
			public NBTBase writeNBT(Capability<IMaxMana> capability, IMaxMana instance, EnumFacing side) 
			{
				return new NBTTagInt(instance.getMaxMana());
			}

			@Override
			public void readNBT(Capability<IMaxMana> capability, IMaxMana instance, EnumFacing side, NBTBase nbt) 
			{
				instance.setMaxMana(((NBTTagInt)nbt).getInt());
			}
		}, () -> new MaxMana(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static IMaxMana getMaxMana(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, MAX_MANA_CAP, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(IMaxMana mana) 
	{
		return new SimpleCapabilityProvider<>(MAX_MANA_CAP, DEFAULT_FACING, mana);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) 
		{
			if (event.getObject() instanceof EntityPlayer) 
			{
				final MaxMana mana = new MaxMana((EntityPlayer) event.getObject());
				event.addCapability(ID, createProvider(mana));
			}
		}
		
		@SubscribeEvent
		public void playerClone(PlayerEvent.Clone event) 
		{
			IMaxMana oldMana = getMaxMana(event.getOriginal());
			IMaxMana newMana = getMaxMana(event.getEntityLiving());

			if (newMana != null && oldMana != null) newMana.setMaxMana(oldMana.getMaxMana());
		}
	}
}
