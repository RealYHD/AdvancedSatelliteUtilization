package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityGenerator;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityEnderCoreGenerator extends TileEntityGenerator implements ISidedInventory {
	int[] fuelqueue;
	
	public TileEntityEnderCoreGenerator() {
		fuelqueue = new int[1];
		fuelqueue[0] = 100;
		itemValidityByString("ender");
		configureVars(fuelqueue);
		configureVars(150);
		setMaxPower(40000);
		setItems(new ItemStack[4]);
		setUpgradeslotstart(1);
		setFuelConversionSpeed(15F);
	}
	
//	@Override
//	public void readFromNBT(NBTTagCompound var1) {
//		this.rotationY = var1.getFloat("rotationY");
//		this.rotationX = var1.getFloat("rotationX");
//		this.speed = var1.getFloat("speed");
//		this.toggle = var1.getBoolean("toggle");
//		this.speedSlower = var1.getFloat("speedSlower");
//		this.currentPower = var1.getInteger("currentPower");
//		this.multiblock = var1.getBoolean("multiblock");
//		this.currentPower = var1.getInteger("currentPower");
//		this.currentfuelqueue = var1.getInteger("Fuel");
//		this.currentcooldown = var1.getInteger("currentCooldown");
//		this.cooldown = var1.getInteger("cooldown");
//
//		NBTTagList slots = var1.getTagList("items", 10);
//		this.items = new ItemStack[getSizeInventory()];
//
//		for (int i = 0; i < slots.tagCount(); i++) {
//			NBTTagCompound item = slots.getCompoundTagAt(i);
//			byte itemPos = item.getByte("itemPos");
//
//			if (itemPos >= 0 && itemPos < this.items.length) {
//				this.items[itemPos] = ItemStack.loadItemStackFromNBT(item);
//			}
//
//			if (var1.hasKey("customName")) {
//				this.setCustomInventoryName(var1.getString("customName"));
//			}
//
//		}
//
//		super.readFromNBT(var1);
//	}
//
//	@Override
//	public void writeToNBT(NBTTagCompound var1) {
//		var1.setFloat("rotationY", this.rotationY);
//		var1.setFloat("rotationX", this.rotationX);
//		var1.setFloat("speed", this.speed);
//		var1.setBoolean("toggle", this.toggle);
//		var1.setFloat("speedSlower", this.speedSlower);
//		var1.setBoolean("multiblock", this.multiblock);
//		var1.setInteger("currentPower", this.currentPower);
//		var1.setInteger("Fuel", this.currentfuelqueue);
//		var1.setInteger("currentCooldown", this.currentcooldown);
//		var1.setInteger("cooldown", this.cooldown);
//
//		NBTTagList slots = new NBTTagList();
//		for (int i = 0; i < items.length; i++) {
//			if (this.items[i] != null) {
//				NBTTagCompound item = new NBTTagCompound();
//				item.setByte("itemPos", (byte) i);
//				this.items[i].writeToNBT(item);
//				slots.appendTag(item);
//			}
//		}
//
//		if (this.hasCustomInventoryName()) {
//			var1.setString("customName", this.customName);
//		}
//		var1.setTag("items", slots);
//		super.writeToNBT(var1);
//
//	}
}
