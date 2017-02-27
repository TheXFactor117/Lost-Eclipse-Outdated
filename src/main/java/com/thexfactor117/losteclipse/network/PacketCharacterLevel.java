package com.thexfactor117.losteclipse.network;

import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;

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
public class PacketCharacterLevel implements IMessage
{
	private int level;
	private int experience;
	private int skillPoints;
	
	public PacketCharacterLevel() {}
	
	public PacketCharacterLevel(int level, int experience, int skillPoints)
	{
		this.level = level;
		this.experience = experience;
		this.skillPoints = skillPoints;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		level = buf.readInt();
		experience = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(level);
		buf.writeInt(experience);
		buf.writeInt(skillPoints);
	}
	
	public static class Handler implements IMessageHandler<PacketCharacterLevel, IMessage>
	{
		@Override
		public IMessage onMessage(final PacketCharacterLevel message, MessageContext ctx) 
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
						final ICharacterLevel charLevel = CapabilityCharacterLevel.getCharacterLevel(entity);
						charLevel.setLevel(message.level);
						charLevel.setExperience(message.experience);
						charLevel.setSkillPoints(message.skillPoints);
					}
				}
			});
			
			return null;
		}
	}
}
