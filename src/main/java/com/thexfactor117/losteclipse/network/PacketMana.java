package com.thexfactor117.losteclipse.network;

import com.thexfactor117.losteclipse.capabilities.api.IMana;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;

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
public class PacketMana implements IMessage
{
	private int mana;
	
	public PacketMana() {}
	
	public PacketMana(int mana)
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
	
	public static class Handler implements IMessageHandler<PacketMana, IMessage>
	{
		@Override
		public IMessage onMessage(final PacketMana message, MessageContext ctx) 
		{			
			IThreadListener mainThread = Minecraft.getMinecraft();
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run() 
				{	
					EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
					
					if (entity instanceof EntityPlayer)
					{
						final IMana mana = CapabilityMana.getMana(entity);
						mana.setMana(message.mana);
					}
				}
			});
			
			return null;
		}
	}
}
