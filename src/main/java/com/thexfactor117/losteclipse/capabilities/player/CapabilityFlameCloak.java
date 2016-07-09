package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.levels.capabilities.SimpleCapabilityProvider;
import com.thexfactor117.levels.misc.CapabilityUtils;
import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.api.capabilities.IFlameCloak;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author TheXFactor117
 *
 */
public class CapabilityFlameCloak 
{
	@CapabilityInject(IFlameCloak.class)
	public static final Capability<IFlameCloak> FLAME_CLOAK_CAP = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "FlameCloak");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(IFlameCloak.class, new Capability.IStorage<IFlameCloak>() 
		{
			@Override
			public NBTBase writeNBT(Capability<IFlameCloak> capability, IFlameCloak instance, EnumFacing side) 
			{
				return new NBTTagByte((byte) (instance.hasFlameCloak() ? 1 : 0));
			}

			@Override
			public void readNBT(Capability<IFlameCloak> capability, IFlameCloak instance, EnumFacing side, NBTBase nbt) 
			{
				instance.setFlameCloak(((NBTPrimitive)nbt).getByte() == 1);
			}
		}, () -> new FlameCloak(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static IFlameCloak getFlameCloak(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, FLAME_CLOAK_CAP, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(IFlameCloak cloak) 
	{
		return new SimpleCapabilityProvider<>(FLAME_CLOAK_CAP, DEFAULT_FACING, cloak);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent.Entity event) 
		{
			if (event.getEntity() instanceof EntityPlayer) 
			{
				final FlameCloak flameCloak = new FlameCloak((EntityPlayer) event.getEntity());
				event.addCapability(ID, createProvider(flameCloak));
			}
		}
	}
}
