package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCoreStabilizer extends TileEntity {
	byte type;
	
	public TileEntityCoreStabilizer (byte type) {
		this.type = type;
	}
	
	public TileEntityCoreStabilizer() {
	}
	
	public float rotationY;
	float speed;
	
	public byte version;
	public boolean multiblock;	
	@Override
	public void updateEntity() {
		rotationY += speed;
		if (rotationY >= 6.3f) {
			rotationY = 0f;
		}

		if (multiblock && speed < 0.08f) {
			speed += 0.001f;
		} else if (multiblock == false && speed > 0f) {
			speed -= 0.001f;
		}

	}
	
	@Override
	public void readFromNBT(NBTTagCompound var1) {
		this.rotationY = var1.getFloat("rotationY");
		this.speed = var1.getFloat("speed");
		this.multiblock = var1.getBoolean("multiblock");
		super.readFromNBT(var1);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound var1) {
		var1.setFloat("rotationY", this.rotationY);
		var1.setFloat("speed", this.speed);
		var1.setBoolean("multiblock", this.multiblock);
		super.writeToNBT(var1);
	}
	
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public byte getType() {
		return type;
	}
}
