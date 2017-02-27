package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.ISkillTree;
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
public class CapabilitySkillTree 
{
	@CapabilityInject(ISkillTree.class)
	public static final Capability<ISkillTree> SKILL_TREE = null;
	public static final EnumFacing DEFAULT_FACING = null;
	public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, "SkillTree");
	
	public static void register() 
	{
		CapabilityManager.INSTANCE.register(ISkillTree.class, new Capability.IStorage<ISkillTree>() 
		{
			@Override
			public NBTBase writeNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side) 
			{
				NBTTagCompound nbt = new NBTTagCompound();
				
				// warrior
				nbt.setInteger("FortificationTier", instance.getFortificationTier());
				nbt.setInteger("HeavyLiftingTier", instance.getHeavyLiftingTier());
				nbt.setInteger("VigorTier", instance.getVigorTier());
				nbt.setInteger("RegenerationTier", instance.getRegenerationTier());
				nbt.setInteger("PowerTier", instance.getPowerTier());
				nbt.setInteger("SwordsmanTier", instance.getSwordsmanTier());
				nbt.setInteger("BruteTier", instance.getBruteTier());
				
				return nbt;
			}

			@Override
			public void readNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side, NBTBase nbt) 
			{
				NBTTagCompound compound = (NBTTagCompound) nbt;
				
				// warrior
				instance.setFortificationTier(compound.getInteger("FortificationTier"));
				instance.setHeavyLiftingTier(compound.getInteger("HeavyLiftingTier"));
				instance.setVigorTier(compound.getInteger("VigorTier"));
				instance.setRegenerationTier(compound.getInteger("RegenerationTier"));
				instance.setPowerTier(compound.getInteger("PowerTier"));
				instance.setSwordsmanTier(compound.getInteger("SwordsmanTier"));
				instance.setBruteTier(compound.getInteger("BruteTier"));
			}
		}, () -> new SkillTree(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static ISkillTree getSkillTree(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, SKILL_TREE, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(ISkillTree mana) 
	{
		return new SimpleCapabilityProvider<>(SKILL_TREE, DEFAULT_FACING, mana);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) 
		{
			if (event.getObject() instanceof EntityPlayer) 
			{
				final SkillTree warrior = new SkillTree((EntityPlayer) event.getObject());
				event.addCapability(ID, createProvider(warrior));
			}
		}
		
		@SubscribeEvent
		public void playerClone(PlayerEvent.Clone event) 
		{
			ISkillTree oldTree = getSkillTree(event.getOriginal());
			ISkillTree newTree = getSkillTree(event.getEntityLiving());

			if (newTree != null && oldTree != null)
			{
				// warrior
				newTree.setFortificationTier(oldTree.getFortificationTier());
				newTree.setHeavyLiftingTier(oldTree.getHeavyLiftingTier());
				newTree.setVigorTier(oldTree.getVigorTier());
				newTree.setRegenerationTier(oldTree.getRegenerationTier());
				newTree.setPowerTier(oldTree.getPowerTier());
				newTree.setSwordsmanTier(oldTree.getSwordsmanTier());
				newTree.setBruteTier(oldTree.getBruteTier());
			}
		}
	}
}
