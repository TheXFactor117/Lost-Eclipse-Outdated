package com.thexfactor117.losteclipse.entities.monsters;

import com.thexfactor117.levels.capabilities.CapabilityEnemyLevel;
import com.thexfactor117.levels.capabilities.IEnemyLevel;
import com.thexfactor117.losteclipse.config.Config;
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
import net.minecraft.world.storage.loot.LootTableList;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityMiniGolem extends EntityLEMonster
{
	private double health = 150;
	private double damage = 10;
	private double speed = 0.3;
	private double range = 24;
	private double knockback = 0.4;
	
	public EntityMiniGolem(World world) 
	{
		super(world);
		this.experienceValue = 10;
		this.setSize(1.0F, 2.0F);
		this.initEntityAI();
	}
	
	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		applyEntityAI();
	}
	
	protected void applyEntityAI()
	{
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
		this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		switch (Config.difficulty)
		{
			case 0:
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health * difficulty0);
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(damage * difficulty0);
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(speed * difficulty0);
				this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(range * difficulty0);
				this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(knockback * difficulty0);
				break;
			case 1:
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(damage * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(speed * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(range * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(knockback * difficulty1);
				break;
			case 2:
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(damage * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(speed * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(range * difficulty1);
				this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(knockback * difficulty2);
				break;
		}
	}
	
	@Override
	protected ResourceLocation getLootTable()
    {
		if (this != null)
		{
			IEnemyLevel enemyLevel = this.getCapability(CapabilityEnemyLevel.ENEMY_LEVEL_CAP, null);
			
			if (enemyLevel != null && enemyLevel.getEnemyLevel() > 0)
			{
				int level = enemyLevel.getEnemyLevel();
				
				switch (level)
				{
					case 0: return LootTableList.EMPTY;
					case 1: return LootTableList.EMPTY;
					case 2: return ModLootTables.ENTITY_SEMI_BOSS_NORMAL;
					case 3: return ModLootTables.ENTITY_SEMI_BOSS_HARDENED;
					case 4: return ModLootTables.ENTITY_SEMI_BOSS_SUPERIOR;
					case 5: return ModLootTables.ENTITY_SEMI_BOSS_ELITE;
					case 6: return ModLootTables.ENTITY_SEMI_BOSS_LEGENDARY;
				}
			}
		}
		
		return LootTableList.EMPTY;
    }
}
