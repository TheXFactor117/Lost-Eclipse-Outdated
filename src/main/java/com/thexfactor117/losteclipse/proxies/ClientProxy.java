package com.thexfactor117.losteclipse.proxies;

import org.lwjgl.input.Keyboard;

import com.thexfactor117.losteclipse.client.gui.GuiMana;
import com.thexfactor117.losteclipse.client.rendering.monsters.RenderBanshee;
import com.thexfactor117.losteclipse.client.rendering.monsters.RenderBarbarian;
import com.thexfactor117.losteclipse.client.rendering.monsters.RenderGhost;
import com.thexfactor117.losteclipse.client.rendering.projectiles.RenderDarkMagic;
import com.thexfactor117.losteclipse.client.rendering.projectiles.RenderFireball;
import com.thexfactor117.losteclipse.client.rendering.projectiles.RenderFrostbite;
import com.thexfactor117.losteclipse.client.rendering.projectiles.RenderLightning;
import com.thexfactor117.losteclipse.client.rendering.projectiles.RenderMagic;
import com.thexfactor117.losteclipse.entities.monsters.EntityBanshee;
import com.thexfactor117.losteclipse.entities.monsters.EntityBarbarian;
import com.thexfactor117.losteclipse.entities.monsters.EntityGhost;
import com.thexfactor117.losteclipse.entities.projectiles.EntityDarkMagic;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.entities.projectiles.EntityLightning;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;
import com.thexfactor117.losteclipse.events.EventInput;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	public static KeyBinding keyBinding;
	
	@Override
	public void preInit()
	{
		MinecraftForge.EVENT_BUS.register(new GuiMana(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new EventInput());
	}
	
	@Override
	public void init()
	{
		keyBinding = new KeyBinding("Character Level GUI", Keyboard.KEY_C, "key.losteclipse");
		
		ClientRegistry.registerKeyBinding(keyBinding);
	}
	
	@Override
	public void registerItemRenderers(Item item, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerRenderers()
	{
		// monsters
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, RenderBarbarian::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, RenderGhost::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBanshee.class, RenderBanshee::new);
		
		// projectiles
		RenderingRegistry.registerEntityRenderingHandler(EntityMagic.class, RenderMagic::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMagic.class, RenderDarkMagic::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFireball.class, RenderFireball::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbite.class, RenderFrostbite::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityLightning.class, RenderLightning::new);
	}
}
