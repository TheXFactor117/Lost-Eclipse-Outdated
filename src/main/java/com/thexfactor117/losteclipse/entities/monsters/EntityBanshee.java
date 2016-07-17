package com.thexfactor117.losteclipse.entities.monsters;

import com.thexfactor117.levels.capabilities.CapabilityEnemyLevel;
import com.thexfactor117.levels.capabilities.IEnemyLevel;
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
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityBanshee extends EntityLEMonster
{
	public EntityBanshee(World world) 
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(24.0D);
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		
		if (this.ticksExisted % (20 * (rand.nextInt(60) + 1) + 15) == 0)
		{
			if (!this.worldObj.isRemote) this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20*7, 0, false, false));
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
		if (!super.attackEntityFrom(source, amount)) return false;
    	else
    	{
    		if (!this.worldObj.isRemote) this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20*7, 0, false, false));   	
    	}
    	
    	return true;
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
					case 2: return ModLootTables.ENTITY_SEMI_RARE_NORMAL;
					case 3: return ModLootTables.ENTITY_SEMI_RARE_HARDENED;
					case 4: return ModLootTables.ENTITY_SEMI_RARE_SUPERIOR;
					case 5: return ModLootTables.ENTITY_SEMI_RARE_ELITE;
					case 6: return ModLootTables.ENTITY_SEMI_RARE_LEGENDARY;
				}
			}
		}
		
		return LootTableList.EMPTY;
    }
}
