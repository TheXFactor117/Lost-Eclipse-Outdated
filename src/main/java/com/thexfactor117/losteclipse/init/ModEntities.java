package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModEntities 
{
	public static int id;
	public static int index;
	
	public static void registerEntities()
	{
		registerModProjectile(EntityMagic.class, "losteclipse.entityMagic");
	}
	
	/**
	 * Registers an entity projectile using #registerModEntity (e.g. a spell/arrow)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void registerModProjectile(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, ++id, LostEclipse.INSTANCE, 64, 10, true);
		LostEclipse.LOGGER.info("Registering mod projectile " + name + " with ID = " + id);
	}
	
	/**
	 * Registers an entity using #registerModEntity (e.g. a mob without an egg)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void registerModEntity(Class entityClass, String name)
	{
        EntityRegistry.registerModEntity(entityClass, name, ++id, LostEclipse.INSTANCE, 80, 3, false);
        LostEclipse.LOGGER.info("Registering mod entity " + name + " with ID = " + id);
	}
	
	/**
	 * Generates a unique ID for every entity to reduce ID mismatches.
	 */
	public static int getUniqueEntityId()
    {
    	do
    	{
    		id++;
    	}
    	while (EntityList.getClassFromID(id) != null);
    	
    	return id;
    }
}
