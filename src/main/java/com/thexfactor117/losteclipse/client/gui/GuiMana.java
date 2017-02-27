package com.thexfactor117.losteclipse.client.gui;

import com.thexfactor117.losteclipse.capabilities.api.IMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
@SideOnly(Side.CLIENT)
public class GuiMana extends Gui
{
	private Minecraft mc;
	private static ResourceLocation location = new ResourceLocation(Reference.MODID, "textures/gui/mana.png");
	
	public GuiMana(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onRenderOverlay(RenderGameOverlayEvent.Post event)
	{
		if (event.getType() != ElementType.EXPERIENCE) return;
		else
		{
			ScaledResolution sr = event.getResolution();
			EntityPlayer player = mc.player;
			
			if (!player.capabilities.isCreativeMode)
			{
				IMana capMana = (IMana) player.getCapability(CapabilityMana.MANA_CAP, null);
				
				if (capMana != null)
				{
					//LostEclipse.LOGGER.info("Mana: " + capMana.getMana() + "\tMax Mana: " + capMaxMana.getMaxMana());

					if (capMana.getMaxMana() != 0)
					{
						double manaBarWidth = (double) capMana.getMana() / capMana.getMaxMana() * 96.0;
						int xPos = sr.getScaledWidth() / 2 + 110;
						int yPos = sr.getScaledHeight() - 20;
						
						mc.renderEngine.bindTexture(location);

						if (capMana.getMana() != capMana.getMaxMana())
						{
							this.drawTexturedModalRect(xPos, yPos, 0, 18, 96, 6);
							this.drawTexturedModalRect(xPos, yPos, 0, 24, (int) manaBarWidth, 5);
						}
					}
				}
			}
		}
	}
}
