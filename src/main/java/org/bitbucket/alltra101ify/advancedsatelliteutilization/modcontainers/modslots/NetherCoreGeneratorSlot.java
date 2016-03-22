package org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.modslots;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityNetherCoreGenerator;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class NetherCoreGeneratorSlot extends Slot {
	public TileEntityNetherCoreGenerator tileentity;
	public NetherCoreGeneratorSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_, TileEntityNetherCoreGenerator tileentity) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		this.tileentity = tileentity;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack) {
	
		return tileentity.isItemValidForFuelSlot(itemStack);
	}
}
