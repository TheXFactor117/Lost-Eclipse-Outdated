package com.thexfactor117.losteclipse;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thexfactor117.losteclipse.config.Config;
import com.thexfactor117.losteclipse.generation.LEWorldGenerator;
import com.thexfactor117.losteclipse.init.ModArmory;
import com.thexfactor117.losteclipse.init.ModBlocks;
import com.thexfactor117.losteclipse.init.ModCapabilities;
import com.thexfactor117.losteclipse.init.ModEntities;
import com.thexfactor117.losteclipse.init.ModEvents;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.init.ModRecipes;
import com.thexfactor117.losteclipse.network.PacketCharacterLevel;
import com.thexfactor117.losteclipse.network.PacketMana;
import com.thexfactor117.losteclipse.proxies.CommonProxy;
import com.thexfactor117.losteclipse.util.GuiHandler;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
	public static SimpleNetworkWrapper network;
	private static File configDir;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LostEclipse.LOGGER.info("Beginning initialization...");
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		configDir.mkdirs();
		Config.init(configDir);
		
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModArmory.registerItems();
		ModEntities.registerEntities();
		ModRecipes.registerRecipes();
		ModEvents.registerEvents();
		ModCapabilities.registerCapabilities();
		
		proxy.preInit();
		proxy.registerRenderers();
		
		network = NetworkRegistry.INSTANCE.newSimpleChannel("lost_eclipse");
		network.registerMessage(PacketMana.Handler.class, PacketMana.class, 0, Side.CLIENT);
		network.registerMessage(PacketCharacterLevel.Handler.class, PacketCharacterLevel.class, 1, Side.CLIENT);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		GameRegistry.registerWorldGenerator(new LEWorldGenerator(), 100);
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
