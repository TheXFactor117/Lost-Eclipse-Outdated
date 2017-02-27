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
				
				// hunter
				nbt.setInteger("ProtectionTier", instance.getProtectionTier());
				nbt.setInteger("ArcheryTier", instance.getArcheryTier());
				nbt.setInteger("QuickDrawTier", instance.getQuickDrawTier());
				nbt.setInteger("RecoveryTier", instance.getRecoveryTier());
				nbt.setInteger("ParalyzeTier", instance.getParalyzeTier());
				
				// mage
				nbt.setInteger("ManaTier", instance.getManaTier());
				nbt.setInteger("SorceryTier", instance.getSorceryTier());
				nbt.setInteger("KnowledgeTier", instance.getKnowledgeTier());
				nbt.setInteger("MastermindTier", instance.getMastermindTier());
				
				// assassin
				nbt.setInteger("AgilityTier", instance.getAgilityTier());
				nbt.setInteger("PrecisionTier", instance.getPrecisionTier());
				nbt.setInteger("SlashTier", instance.getSlashTier());
				nbt.setInteger("CriticalTier", instance.getCriticalTier());
				nbt.setInteger("DestructionTier", instance.getDestructionTier());
				
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
				
				// hunter
				instance.setProtectionTier(compound.getInteger("ProtectionTier"));
				instance.setArcheryTier(compound.getInteger("ArcheryTier"));
				instance.setQuickDrawTier(compound.getInteger("QuickDrawTier"));
				instance.setRecoveryTier(compound.getInteger("RecoveryTier"));
				instance.setParalyzeTier(compound.getInteger("ParalyzeTier"));
				
				// mana
				instance.setManaTier(compound.getInteger("ManaTier"));
				instance.setSorceryTier(compound.getInteger("SorceryTier"));
				instance.setKnowledgeTier(compound.getInteger("KnowledgeTier"));
				instance.setMastermindTier(compound.getInteger("MastermindTier"));
				
				// assassin
				instance.setAgilityTier(compound.getInteger("AgilityTier"));
				instance.setPrecisionTier(compound.getInteger("PrecisionTier"));
				instance.setSlashTier(compound.getInteger("SlashTier"));
				instance.setCriticalTier(compound.getInteger("CriticalTier"));
				instance.setDestructionTier(compound.getInteger("DestructionTier"));
			}
		}, () -> new SkillTree(null));

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	@Nullable
	public static ISkillTree getSkillTree(EntityLivingBase entity) 
	{
		return CapabilityUtils.getCapability(entity, SKILL_TREE, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(ISkillTree tree) 
	{
		return new SimpleCapabilityProvider<>(SKILL_TREE, DEFAULT_FACING, tree);
	}
	
	public static class EventHandler 
	{
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) 
		{
			if (event.getObject() instanceof EntityPlayer) 
			{
				final SkillTree tree = new SkillTree((EntityPlayer) event.getObject());
				event.addCapability(ID, createProvider(tree));
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
				
				// hunter
				newTree.setProtectionTier(oldTree.getProtectionTier());
				newTree.setArcheryTier(oldTree.getArcheryTier());
				newTree.setQuickDrawTier(oldTree.getQuickDrawTier());
				newTree.setRecoveryTier(oldTree.getRecoveryTier());
				newTree.setParalyzeTier(oldTree.getParalyzeTier());
				
				// mage
				newTree.setManaTier(oldTree.getManaTier());
				newTree.setSorceryTier(oldTree.getSorceryTier());
				newTree.setKnowledgeTier(oldTree.getKnowledgeTier());
				newTree.setMastermindTier(oldTree.getMastermindTier());
				
				// assassin
				newTree.setAgilityTier(oldTree.getAgilityTier());
				newTree.setPrecisionTier(oldTree.getPrecisionTier());
				newTree.setSlashTier(oldTree.getSlashTier());
				newTree.setCriticalTier(oldTree.getCriticalTier());
				newTree.setDestructionTier(oldTree.getDestructionTier());
			}
		}
	}
}
