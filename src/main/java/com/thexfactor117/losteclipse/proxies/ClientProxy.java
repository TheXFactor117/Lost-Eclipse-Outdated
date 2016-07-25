package com.thexfactor117.losteclipse.proxies;

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
