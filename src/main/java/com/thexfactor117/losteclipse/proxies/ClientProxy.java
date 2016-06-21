package com.thexfactor117.losteclipse.proxies;

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
		//RenderingRegistry.registerEntityRenderingHandler(EntityMagic.class, RenderModProjectile::new);
	}
}
