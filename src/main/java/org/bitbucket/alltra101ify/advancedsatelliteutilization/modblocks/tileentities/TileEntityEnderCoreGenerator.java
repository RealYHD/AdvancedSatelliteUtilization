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

}
