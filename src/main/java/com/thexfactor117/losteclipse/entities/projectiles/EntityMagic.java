package com.thexfactor117.losteclipse.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EntityMagic extends EntityThrowable
{
	public EntityMagic(World world)
    {
        super(world);
    }
    
    public EntityMagic(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityMagic(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	if (this.worldObj.isRemote)
    	{
    		if (!this.inGround && !this.isDead)
    		{
    			for (int i = 0; i < 4; ++i)
    			{
        			this.worldObj.spawnParticle(EnumParticleTypes.SPELL_INSTANT, this.posX, this.posY, this.posZ, 0F, 0F, 0F, new int[0]);
    			}
    		}
    	}
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {	
    	if (!this.worldObj.isRemote)
    	{
    		if (result.entityHit != null)
    		{
    			result.entityHit.attackEntityFrom(DamageSource.magic, 4.0F);
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
