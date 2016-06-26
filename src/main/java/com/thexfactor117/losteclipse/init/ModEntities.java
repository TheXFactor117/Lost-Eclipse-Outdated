package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.entities.monsters.EntityBarbarian;
import com.thexfactor117.losteclipse.entities.projectiles.EntityDarkMagic;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.entities.projectiles.EntityLightning;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;

import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModEntities 
{
	public static int id = 0;
	public static int index;
	
	public static void registerEntities()
	{
		// monsters
		registerModEntity(EntityBarbarian.class, "entityBarbarian");
		
		// projectiles
		registerModProjectile(EntityMagic.class, "entityMagic");
		registerModProjectile(EntityFireball.class, "entityFireball");
		registerModProjectile(EntityFrostbite.class, "entityFrostbite");
		registerModProjectile(EntityLightning.class, "entityLightning");
		registerModProjectile(EntityDarkMagic.class, "entityDarkMagic");
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
}
