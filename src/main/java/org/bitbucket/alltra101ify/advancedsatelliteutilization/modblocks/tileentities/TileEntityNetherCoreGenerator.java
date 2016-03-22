package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities;

import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityGenerator;

public class TileEntityNetherCoreGenerator extends TileEntityGenerator implements ISidedInventory {
	Item[] item;
	int[] fuel;
	public TileEntityNetherCoreGenerator() {
		fuel = new int[1];
		item = new Item[1];
		fuel[0] = 110;
		item[0] = Items.blaze_rod;
		configureVars(fuel, 30000, 125);
		ItemValidityByItem(item);	
		setItems(new ItemStack[4]);
		setUpgradeslotstart(1);
		setFuelConversionSpeed(15F);
	}
} 
