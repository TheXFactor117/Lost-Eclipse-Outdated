package com.thexfactor117.losteclipse.proxies;

import com.thexfactor117.losteclipse.entities.projectiles.EntityDarkMagic;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.entities.projectiles.EntityLightning;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;
import com.thexfactor117.losteclipse.rendering.projectiles.RenderDarkMagic;
import com.thexfactor117.losteclipse.rendering.projectiles.RenderFireball;
import com.thexfactor117.losteclipse.rendering.projectiles.RenderFrostbite;
import com.thexfactor117.losteclipse.rendering.projectiles.RenderLightning;
import com.thexfactor117.losteclipse.rendering.projectiles.RenderMagic;

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
		// projectiles
		RenderingRegistry.registerEntityRenderingHandler(EntityMagic.class, RenderMagic::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMagic.class, RenderDarkMagic::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFireball.class, RenderFireball::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbite.class, RenderFrostbite::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityLightning.class, RenderLightning::new);
	}
}
