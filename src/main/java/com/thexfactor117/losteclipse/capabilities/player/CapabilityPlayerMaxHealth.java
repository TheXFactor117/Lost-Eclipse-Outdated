package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.levels.capabilities.SimpleCapabilityProvider;
import com.thexfactor117.levels.misc.CapabilityUtils;
import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.api.capabilities.IPlayerMaxHealth;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
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
public class CapabilityPlayerMaxHealth 
{
	@CapabilityInject(IPlayerMaxHealth.class)
	public static final Capability<IPlayerMaxHealth> PLAYER_MAX_HEALTH_CAP = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "PlayerMaxHealth");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(IPlayerMaxHealth.class, new Capability.IStorage<IPlayerMaxHealth>() 
		{
			@Override
			public NBTBase writeNBT(Capability<IPlayerMaxHealth> capability, IPlayerMaxHealth instance, EnumFacing side) 
			{
				return new NBTTagFloat(instance.getMaxHealth());
			}

			@Override
			public void readNBT(Capability<IPlayerMaxHealth> capability, IPlayerMaxHealth instance, EnumFacing side, NBTBase nbt) 
			{
				instance.setMaxHealth(((NBTTagFloat)nbt).getFloat());
			}
		}, () -> new PlayerMaxHealth(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static IPlayerMaxHealth getPlayerMaxHealth(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, PLAYER_MAX_HEALTH_CAP, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(IPlayerMaxHealth maxHealth) 
	{
		return new SimpleCapabilityProvider<>(PLAYER_MAX_HEALTH_CAP, DEFAULT_FACING, maxHealth);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent.Entity event) 
		{
			if (event.getEntity() instanceof EntityPlayer) 
			{
				final PlayerMaxHealth maxHealth = new PlayerMaxHealth((EntityPlayer) event.getEntity());
				event.addCapability(ID, createProvider(maxHealth));
			}
		}
		
		@SubscribeEvent
		public void playerClone(PlayerEvent.Clone event) 
		{
			IPlayerMaxHealth oldMaxHealth = getPlayerMaxHealth(event.getOriginal());
			IPlayerMaxHealth newMaxHealth = getPlayerMaxHealth(event.getEntityPlayer());

			if (newMaxHealth != null && oldMaxHealth != null) newMaxHealth.setMaxHealth(oldMaxHealth.getMaxHealth());
		}
	}
}
