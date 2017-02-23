package com.thexfactor117.losteclipse.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFrostbite extends EntityThrowable
{
	public EntityFrostbite(World world)
    {
        super(world);
    }
    
    public EntityFrostbite(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityFrostbite(World world, double x, double y, double z, float velocity, float inaccuracy)
    {
        super(world, x, y, z);
        this.setThrowableHeading(x, y, z, velocity, inaccuracy);
    }

    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	if (this.getEntityWorld().isRemote)
    	{
    		if (!this.inGround && !this.isDead) this.getEntityWorld().spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0F, 0F, 0F, new int[0]);
    		if (this.inGround) this.setDead();
    	}
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {	
    	if (!this.getEntityWorld().isRemote)
    	{
    		if (result.entityHit != null)
    		{	
    			if (result.entityHit instanceof EntityLivingBase)
    			{
    				EntityLivingBase enemy = (EntityLivingBase) result.entityHit;
    				
    				enemy.attackEntityFrom(DamageSource.MAGIC, 4.0F);
    				enemy.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 20 * 4, 10));
    			}
    		}
    		
    		this.setDead();
    	}
    }
    
    @Override
    protected float getGravityVelocity()
    {
    	return 0.0F;
    } 
}
