package org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityAdvancedWasteHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAdvancedWasteHandler extends Container {
	public static byte input[] = new byte[11];
	public TileEntityAdvancedWasteHandler tileentity;
	
	public ContainerAdvancedWasteHandler(InventoryPlayer inventoryplayer, TileEntityAdvancedWasteHandler tileentity) {
		this.tileentity = tileentity;
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 163));
		}

		for (byte i = 0; i < 3; i++) {
			for (byte j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventoryplayer, 9 + j + i * 9, 8 + j * 18, 105 + i * 18));
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			input[i] = (byte) i;
		}
		
		for (int i = 8; i < input.length; i++) {
			this.addSlotToContainer(new Slot(tileentity, input[i], 6 + (i-8)*26, 4));
		}
		
		for (int i = 0; i < 8; i++) {
			this.addSlotToContainer(new Slot(tileentity, input[i], 6 + i*18, 25));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2SlotId) {
		return null;
	}
	
}
