package org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGenerator extends TileEntity implements ISidedInventory {
	protected ItemStack[] items;
	public boolean toggle, multiblock;
	protected String customName;
	public int maxpower, cooldown, currentcooldown, fuelqueue[], count, upgradeslotstart;
	public float FuelConversionSpeed, currentfuelqueue, currentPower;
	public float rotationX, rotationY, speed, speedSlower;
	Item[] validItemByItem;
	String validItemByString, particle;
	protected int x, y, z;
	@Override
	public void updateEntity() {
		if (currentcooldown != 0) {
			currentcooldown--;
		}
		for (int i = upgradeslotstart; i < items.length; i++) {
			if (items[i] != null) {
				if (currentcooldown >= 1 && items[i].getItem() == ModItems.fanModule) {
					currentcooldown--;
				} else if (toggle && items[i].getItem() == ModItems.conversionSpeedUpgrade && currentfuelqueue >= 2) {
					currentfuelqueue = currentfuelqueue - 2;
					currentPower = currentPower + 2;
				}
			}
		}

		
		if (!multiblock && toggle) {
			toggle = false;
		}
		
		if (currentfuelqueue > maxpower) {
			currentfuelqueue = maxpower;
		}

		if (currentPower >= maxpower) {
			currentPower = maxpower;
		}
		if (currentPower <= 0) {
			currentPower = 0;
		}
		
		if (toggle) {
			for (int j = 0; j < upgradeslotstart; j++) {
				//Register fuel and such using item and fuel index system
				if (items[j] != null && this.validItemByItem != null) {
					for (int i = 0; i < validItemByItem.length; i++) {
						if (currentcooldown == 0 && currentfuelqueue <= maxpower - fuelqueue[i] && items[j].getItem() == validItemByItem[i]) {
							if (items[j].stackSize == 1) {
								this.items[j] = null;
							} else {
								items[j].splitStack(1);
								if (this.items[j].stackSize == 0) {
									this.items[j] = null;
			
								}
							}
						this.currentfuelqueue += fuelqueue[i];
						this.currentcooldown = cooldown;	
						}
					}
				} else
				//Register fuel and such by default or customized index fuel
				if (items[j] != null && this.validItemByString !=null) {
					if (currentfuelqueue <= maxpower - fuelqueue[0] && currentcooldown == 0) {
						if (items[j].stackSize == 1) {
							this.items[j] = null;
						} else {
							items[j].splitStack(1);
							if (this.items[j].stackSize == 0) {
								this.items[j] = null;
							}
						}
						this.currentfuelqueue += fuelqueue[0];
						this.currentcooldown = cooldown;
					}
				}
			}
	
			if (currentfuelqueue > 0 && currentPower != maxpower) {
				if (currentfuelqueue >= FuelConversionSpeed) {
					currentfuelqueue -= FuelConversionSpeed;
					currentPower += FuelConversionSpeed;
				} else if (currentfuelqueue < FuelConversionSpeed && currentfuelqueue >= 1) {
					currentfuelqueue --;
					currentPower ++;
				} else if (currentfuelqueue >= 0.05F) {
					currentfuelqueue = currentfuelqueue - 0.05F;
					currentPower = currentPower + 0.05F;
				}
			}
		}
		rotationY += speed;
		if (rotationY > 6.3f) {
			rotationY = 0f;
		}

		rotationX += speedSlower;
		if (rotationX >= 6.3f) {
			rotationX = 0f;
		}

		if (toggle && speed < 0.055f) {
			speed += 0.0005f;
			speedSlower += 0.00007f;

		} else if (toggle == false && speed > 0f) {
			speed -= 0.0005f;
			speedSlower -= 0.00007f;

		}
	}

	public int powerScaled(int scale) {
		return (int) (this.currentPower * scale / maxpower);
	}

	public int genscaled(int scale) {
		return (int) (this.currentfuelqueue * scale / maxpower);
	}
	
	public int cooldownscaled(int scale) {
		return (this.currentcooldown * scale / cooldown);
	}
	
	public boolean humanInterface() {
		for (int i = upgradeslotstart; i < items.length; i++) {
			if (items[i] != null && items[i].getItem() == ModItems.humanInterfaceGate) {
				return true;
			}
		}
		return false;
	}
	
	public void setUpgradeslotstart(int upgradeslotstart) {
		this.upgradeslotstart = upgradeslotstart;
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

	@Override
	public int getSizeInventory() {

		return this.items.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotNumber) {

		return this.items[slotNumber];
	}

	@Override
	public ItemStack decrStackSize(int slotNumber, int amountDecr) {

		if (this.items[slotNumber] != null) {
			//how much is returned to the hand
			ItemStack itemstack;

			if (this.items[slotNumber].stackSize <= amountDecr) {
				itemstack = this.items[slotNumber];
				this.items[slotNumber] = null;
			} else {
				itemstack = items[slotNumber].splitStack(amountDecr);
				if (this.items[slotNumber].stackSize == 0) {
					this.items[slotNumber] = null;
				}
			}

			return itemstack;
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {

		return null;
	}
	
	public void setFuelConversionSpeed(float fuelConversionSpeed) {
		FuelConversionSpeed = fuelConversionSpeed;
	}
	
	@Override
	public void setInventorySlotContents(int slotNumber, ItemStack itemstack) {
		this.items[slotNumber] = itemstack;
		if (itemstack != null
				&& itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	protected void setCustomInventoryName(String customName) {

		this.customName = customName;

	}

	@Override
	public boolean hasCustomInventoryName() {
		boolean customname = false;
		if (customName != null) {
			customname = true;
		}
		return customname;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {

		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {

		return null;
	}

	@Override
	public boolean canInsertItem(int p_1020071_, ItemStack p_102007_2_,
			int p_102007_3_) {

		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {

		return false;
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return isItemValidForFuelSlot(itemstack);
	}
	
	public boolean isItemValidForFuelSlot(ItemStack itemstack) {
		boolean itemvalid = false;
			if (this.validItemByString != null && itemstack.getItem().getUnlocalizedName().toLowerCase().contains(this.validItemByString)) {
				itemvalid = true;
			} else if (this.validItemByItem != null) {
				for (int i1 = 0; i1 < this.validItemByItem.length; i1++) {
					if (itemstack.getItem().equals(this.validItemByItem[i1])) {
						itemvalid = true;
						break;
					}
				}
			}
		
		return itemvalid;
	}
	
	
	/**
	 * @param fuelqueue how much more fuel do we give?
	 * @param maxpower self-explanatory
	 * @param cooldown cool down time to transfer next item to fuel (in ticks)
	 */
	public void configureVars(int[] fuelqueue, int maxpower, int cooldown) {
		this.fuelqueue = fuelqueue;
		this.maxpower = maxpower;
		this.cooldown = cooldown;
	}
	
	public void configureVars (int[] fuelqueue) {
		this.fuelqueue = fuelqueue;
	}
	
	public void configureVars (int cooldown) {
		this.cooldown = cooldown;
	}
	
	public void setItems(ItemStack[] items) {
		this.items = items;
	}
	
	public void setMaxPower (int maxpower) {
		this.maxpower = maxpower;
	}
	public void ItemValidityByItem(Item[] item) {
		this.validItemByItem = item;
	}
	/**
	 * 
	 * @param string (should only be used for testing as there is very little control) Sets what is valid by name of item.
	 */
	public void itemValidityByString(String string) {
		this.validItemByString = string;
	}
	
	public int RetrievePower (int amountofpower) {
		if (currentPower >= amountofpower) {
			currentPower = currentPower - amountofpower;
		}
		return amountofpower;
	}
	
	public void setCoords(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setParticle(String particle) {
		this.particle = particle;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound var1) {
		var1.setFloat("rotationY", this.rotationY);
		var1.setFloat("rotationX", this.rotationX);
		var1.setFloat("speed", this.speed);
		var1.setBoolean("toggle", this.toggle);
		var1.setFloat("speedSlower", this.speedSlower);
		var1.setBoolean("multiblock", this.multiblock);
		var1.setFloat("currentPower", this.currentPower);
		var1.setFloat("Fuel", this.currentfuelqueue);
		var1.setInteger("currentCooldown", this.currentcooldown);
		var1.setInteger("cooldown", this.cooldown);

		NBTTagList slots = new NBTTagList();
		for (int i = 0; i < items.length; i++) {
			if (this.items[i] != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("itemPos", (byte) i);
				this.items[i].writeToNBT(item);
				slots.appendTag(item);
			}
		}

		if (this.hasCustomInventoryName()) {
			var1.setString("customName", this.customName);
		}
		var1.setTag("items", slots);
		super.writeToNBT(var1);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound var1) {
		this.rotationY = var1.getFloat("rotationY");
		this.rotationX = var1.getFloat("rotationX");
		this.speed = var1.getFloat("speed");
		this.toggle = var1.getBoolean("toggle");
		this.speedSlower = var1.getFloat("speedSlower");
		this.currentPower = var1.getFloat("currentPower");
		this.multiblock = var1.getBoolean("multiblock");
		this.currentfuelqueue = var1.getFloat("Fuel");
		this.currentcooldown = var1.getInteger("currentCooldown");
		this.cooldown = var1.getInteger("cooldown");

		NBTTagList slots = var1.getTagList("items", 10);
		this.items = new ItemStack[getSizeInventory()];

		for (int i = 0; i < slots.tagCount(); i++) {
			NBTTagCompound item = slots.getCompoundTagAt(i);
			byte itemPos = item.getByte("itemPos");

			if (itemPos >= 0 && itemPos < this.items.length) {
				this.items[itemPos] = ItemStack.loadItemStackFromNBT(item);
			}

			if (var1.hasKey("customName")) {
				this.setCustomInventoryName(var1.getString("customName"));
			}

		}

		super.readFromNBT(var1);
	}
	
	public void setSimple() {
		this.multiblock = true;
		this.toggle = true;
	}
	
}