package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities;

import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.AdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityGenerator;

public class TileEntityAdvancedWasteHandler extends TileEntityGenerator implements ISidedInventory {
	int fuelqueue[] = new int[6];
	Item item[] = new Item[6];
	public TileEntityAdvancedWasteHandler() {
		for (int i = 0; i < fuelqueue.length; i++) {
			fuelqueue[i] = 3;
		}
		
		item[0] = Items.bone;
		item[1] = Items.clay_ball;
		item[2] = Items.slime_ball;
		item[3] = Items.egg;
		item[4] = Items.feather;
		item[5] = Items.rotten_flesh;
		
		this.ItemValidityByItem(item);
		this.configureVars(fuelqueue);
		
		this.setSimple();
		
		this.setMaxPower(1000);
		this.configureVars(200);
		setItems(new ItemStack[11]);
		setUpgradeslotstart(8);
		
		setFuelConversionSpeed(0.25F);
	}
	
	@Override
	public void updateEntity() {
		
		AdvancedWasteHandler.updateGenerator(worldObj, xCoord, yCoord, zCoord, this.currentfuelqueue > 0 && this.currentfuelqueue <= 4 || this.currentcooldown > 0);		
		super.updateEntity();
	}
	
}
