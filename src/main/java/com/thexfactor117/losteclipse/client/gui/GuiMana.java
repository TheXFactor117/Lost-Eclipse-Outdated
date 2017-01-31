package com.thexfactor117.losteclipse.client.gui;

import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMaxMana;
import com.thexfactor117.losteclipse.capabilities.player.Mana;
import com.thexfactor117.losteclipse.capabilities.player.MaxMana;
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
			EntityPlayer player = mc.thePlayer;
			
			if (!player.capabilities.isCreativeMode)
			{
				MaxMana capMaxMana = (MaxMana) player.getCapability(CapabilityMaxMana.MAX_MANA_CAP, null);
				Mana capMana = (Mana) player.getCapability(CapabilityMana.MANA_CAP, null);
				
				if (capMaxMana != null && capMana != null)
				{
					//LostEclipse.LOGGER.info("Mana: " + capMana.getMana() + "\tMax Mana: " + capMaxMana.getMaxMana());

					if (capMaxMana.getMaxMana() != 0)
					{
						double manaBarWidth = (double) capMana.getMana() / capMaxMana.getMaxMana() * 96.0;
						int xPos = sr.getScaledWidth() / 2 + 110;
						int yPos = sr.getScaledHeight() - 20;
						
						mc.renderEngine.bindTexture(location);

						if (capMana.getMana() != capMaxMana.getMaxMana())
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
