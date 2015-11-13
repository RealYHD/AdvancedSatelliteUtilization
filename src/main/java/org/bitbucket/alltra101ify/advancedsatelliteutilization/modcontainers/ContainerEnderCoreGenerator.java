package org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.modslots.EnderCoreGeneratorSlot;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityCoreGenerator;

public class ContainerEnderCoreGenerator extends Container {

	public static final int INPUT_1 = 0;

	public TileEntityEnderCoreGenerator endercoregenerator;

	public ContainerEnderCoreGenerator(InventoryPlayer inventoryplayer,
			TileEntityEnderCoreGenerator tileentity) {
		this.endercoregenerator = tileentity;

		this.addSlotToContainer(new EnderCoreGeneratorSlot(tileentity, INPUT_1, 7, 28, tileentity));
		
		for (int i = 0; i < 3; i++) {
			this.addSlotToContainer(new Slot(tileentity, 1 + i, 155, 5 + i * 19));
		}
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18,
					125));
		}

		for (byte i = 0; i < 3; i++) {
			for (byte j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventoryplayer,
						9 + j + i * 9, 8 + j * 18, 67 + i * 18));
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return true;
	}
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2SlotId) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2SlotId);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (par2SlotId == INPUT_1) {
                if (!this.mergeItemStack(itemstack1, INPUT_1+1, INPUT_1+36+1, true))
                {
                    return null;
                }
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (par2SlotId != INPUT_1 && endercoregenerator.isItemValidForSlot(par2SlotId, itemstack1)) {
					if (!this.mergeItemStack(itemstack1, INPUT_1, INPUT_1+1,
							false)) {
						return null;
					} 
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}
		return itemstack;
	}

}
