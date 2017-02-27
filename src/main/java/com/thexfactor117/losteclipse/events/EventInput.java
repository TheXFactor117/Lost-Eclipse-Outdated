package com.thexfactor117.losteclipse.events;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.proxies.ClientProxy;
import com.thexfactor117.losteclipse.util.GuiHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class EventInput 
{
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPress(InputEvent.KeyInputEvent event)
	{
		KeyBinding key = ClientProxy.keyBinding;
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.player;
		
		if (player != null)
		{
			if (key.isPressed())
			{
				player.openGui(LostEclipse.instance, GuiHandler.CHARACTER_LEVELING, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			}
		}
	}
}
