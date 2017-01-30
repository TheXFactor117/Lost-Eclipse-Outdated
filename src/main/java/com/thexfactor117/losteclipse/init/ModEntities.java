package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.entities.monsters.EntityBandit;
import com.thexfactor117.losteclipse.entities.monsters.EntityBanshee;
import com.thexfactor117.losteclipse.entities.monsters.EntityBarbarian;
import com.thexfactor117.losteclipse.entities.monsters.EntityGhost;
import com.thexfactor117.losteclipse.entities.monsters.EntityGolem;
import com.thexfactor117.losteclipse.entities.monsters.EntityMiniGolem;
import com.thexfactor117.losteclipse.entities.monsters.EntityMummy;
import com.thexfactor117.losteclipse.entities.monsters.EntityTroll;
import com.thexfactor117.losteclipse.entities.projectiles.EntityDarkMagic;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.entities.projectiles.EntityLightning;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.util.ResourceLocation;
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
		registerModEntity(EntityBandit.class, "bandit");
		registerModEntity(EntityBanshee.class, "banshee");
		registerModEntity(EntityBarbarian.class, "barbarian");
		registerModEntity(EntityGhost.class, "ghost");
		registerModEntity(EntityGolem.class, "golem");
		registerModEntity(EntityMiniGolem.class, "mini-golem");
		registerModEntity(EntityMummy.class, "mummy");
		registerModEntity(EntityTroll.class, "troll");
		
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
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entityClass, name, ++id, LostEclipse.instance, 64, 10, true);
		LostEclipse.LOGGER.info("Registering mod projectile " + name + " with ID = " + id);
	}
	
	/**
	 * Registers an entity using #registerModEntity (e.g. a mob without an egg)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void registerModEntity(Class entityClass, String name)
	{
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entityClass, name, ++id, LostEclipse.instance, 80, 3, false);
        LostEclipse.LOGGER.info("Registering mod entity " + name + " with ID = " + id);
	}
}
