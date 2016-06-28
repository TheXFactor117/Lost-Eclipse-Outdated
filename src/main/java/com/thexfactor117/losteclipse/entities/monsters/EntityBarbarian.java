package com.thexfactor117.losteclipse.entities.monsters;

import com.thexfactor117.losteclipse.entities.EntityLEMonster;
import com.thexfactor117.losteclipse.init.ModLootTables;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityBarbarian extends EntityLEMonster
{	
	public EntityBarbarian(World world) 
	{
		super(world);
		this.experienceValue = 10;
		this.setSize(1.0F, 2.0F);
	}
	
	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		applyEntityAI();
	}
	
	protected void applyEntityAI()
	{
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
	}
	
	@Override
	protected ResourceLocation getLootTable()
    {
		return ModLootTables.ENTITY_BARBARIAN;
    }
}
