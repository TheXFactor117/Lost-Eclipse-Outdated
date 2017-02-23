package com.thexfactor117.losteclipse.network;

import com.thexfactor117.losteclipse.capabilities.api.IMaxMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMaxMana;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * 
 * @author TheXFactor117
 *
 */
public class PacketMaxMana implements IMessage
{
	private int mana;
	
	public PacketMaxMana() {}
	
	public PacketMaxMana(int mana)
	{
		this.mana = mana;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.mana = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.mana);
	}
	
	public static class Handler implements IMessageHandler<PacketMaxMana, IMessage>
	{
		@Override
		public IMessage onMessage(final PacketMaxMana message, MessageContext ctx) 
		{			
			IThreadListener mainThread = Minecraft.getMinecraft();
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run() 
				{	
					EntityPlayer entity = Minecraft.getMinecraft().player;
					
					if (entity instanceof EntityPlayer)
					{
						final IMaxMana mana = CapabilityMaxMana.getMaxMana(entity);
						mana.setMaxMana(message.mana);
					}
				}
			});
			
			return null;
		}
	}
}
