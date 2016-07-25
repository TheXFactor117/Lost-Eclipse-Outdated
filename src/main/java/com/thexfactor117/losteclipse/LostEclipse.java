package com.thexfactor117.losteclipse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.generation.LEWorldGenerator;
import com.thexfactor117.losteclipse.init.ModArmory;
import com.thexfactor117.losteclipse.init.ModBlocks;
import com.thexfactor117.losteclipse.init.ModCapabilities;
import com.thexfactor117.losteclipse.init.ModEntities;
import com.thexfactor117.losteclipse.init.ModEvents;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.init.ModRecipes;
import com.thexfactor117.losteclipse.proxies.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 *
 * TODO:
 * + More textures!
 * + Entity models
 * + Dungeon structures
 * + Artifact logic
 * * Structure spawn rate balancing
 * * Cleanup structure spawning
 * * Recipe cleanup
 * * Overall code cleanup and documentation
 * 
 */
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, updateJSON = Reference.UPDATE_URL)
public class LostEclipse 
{
	@Instance(Reference.MODID)
	public static LostEclipse instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	public static final Logger LOGGER = LogManager.getLogger("Lost Eclipse");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LostEclipse.LOGGER.info("Beginning initialization...");
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModArmory.registerItems();
		ModEntities.registerEntities();
		ModRecipes.registerRecipes();
		ModEvents.registerEvents();
		ModCapabilities.registerCapabilities();
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new LEWorldGenerator(), 100);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
