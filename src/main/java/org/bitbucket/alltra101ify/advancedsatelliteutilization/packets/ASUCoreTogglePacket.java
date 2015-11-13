package org.bitbucket.alltra101ify.advancedsatelliteutilization.packets;

import net.minecraft.tileentity.TileEntity;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityCoreGenerator;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ASUCoreTogglePacket implements IMessage {
	private int toggle, x, y, z;
	
	public ASUCoreTogglePacket() {
		
	}
	
	public ASUCoreTogglePacket(int toggle, int x, int y, int z) {
		this.toggle = toggle;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		toggle = ByteBufUtils.readVarInt(buf, 3);
		x = ByteBufUtils.readVarInt(buf, 5);
		y = ByteBufUtils.readVarInt(buf, 5);
		z = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, toggle, 3);
		ByteBufUtils.writeVarInt(buf, x, 5);
		ByteBufUtils.writeVarInt(buf, y, 5);
		ByteBufUtils.writeVarInt(buf, z, 5);
		
	}
	public static class handler implements IMessageHandler<ASUCoreTogglePacket, IMessage> {

		@Override
		public IMessage onMessage(ASUCoreTogglePacket message, MessageContext ctx) {
			TileEntity tileentity = ctx.getServerHandler().playerEntity.getEntityWorld().getTileEntity(message.x, message.y, message.z);
			if (message.toggle == 1) {
				((TileEntityCoreGenerator)tileentity).toggle = true;
			} else {
				((TileEntityCoreGenerator)tileentity).toggle = false;
			}
			return null;
		}
	}
}
