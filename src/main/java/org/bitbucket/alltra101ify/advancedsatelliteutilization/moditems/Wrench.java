package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import java.util.List;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Wrench extends Item {
	private IIcon[] iconArray;

	public Wrench(ToolMaterial worktool) {

		setCreativeTab(ModCreativeTabs.TabASU);
		setUnlocalizedName("WrenchUtility");
		setMaxStackSize(1);
	}
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {	
		iconArray = new IIcon[2];

		for (int i = 0; i < iconArray.length; ++i) {
			iconArray[i] = register.registerIcon(ModInfo.MODID + ":" + "WrenchUtility/" + getUnlocalizedName().substring(5) + i);
		}
		
		this.itemIcon = iconArray[0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass) {
		if (stack.stackTagCompound != null && stack.stackTagCompound.getByte("Mode") == -1) {
			return iconArray[0];
		} else if (stack.stackTagCompound != null && stack.stackTagCompound.getByte("Mode") != -1) {
			return iconArray[1];
		}
		return iconArray[0];
	};	
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		NBTSetup(itemstack, world, player);
	}

	public byte GetMode(byte current, EntityPlayer player, World world) {
		byte updatedcurrent = current;
		updatedcurrent++;
		if (player.capabilities.isCreativeMode) {
			if (current >= 5) {
				updatedcurrent = -1;
			}
		} else {
			if (current >= 1) {
				updatedcurrent = -1;
			}
		}
		return updatedcurrent;
	}

	public void NBTSetup(ItemStack itemstack, World world, EntityPlayer player) {
		if (!(itemstack.stackTagCompound != null)) {
			itemstack.stackTagCompound = new NBTTagCompound();
			super.onCreated(itemstack, world, player);
			itemstack.stackTagCompound.setByte("Mode", (byte) -1);
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		if (itemstack.stackTagCompound != null && player.isSneaking()) {
			itemstack.stackTagCompound.setByte("Mode", GetMode(itemstack.stackTagCompound.getByte("Mode"), player, world));
		} else {
			NBTSetup(itemstack, world, player);
		}
		return super.onItemRightClick(itemstack, world, player);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean p_77624_4_) {
		if (itemstack.stackTagCompound != null) {
			byte Mode = itemstack.stackTagCompound.getByte("Mode");
			String TextMode = "Mode not set";

			switch (Mode) {
			case -1:
				TextMode = "";

			case 0:
				TextMode = "Configure";
				break;

			case 1:
				TextMode = "Dismantle";
				break;

			case 2:
				TextMode = "Debug 1 (+100 Power)";
				break;

			case 3:
				TextMode = "Debug 2 (Read power)";
				break;

			case 4:
				TextMode = "Debug 3 (Read bar)";
				break;

			case 5:
				TextMode = "Debug 4 (-100 Power)";
			}
			if (Mode == -1) {
				list.add(EnumChatFormatting.GRAY + "Wrench is turned off.");
			} else {
				list.add(EnumChatFormatting.GREEN + "Wrench is turned on");
				list.add("Mode: " + TextMode);
			}

			if (Mode >= 2) {
				list.add(EnumChatFormatting.RED
						+ "Warning, debug mode is enabled.");
			}
		}
		super.addInformation(itemstack, player, list, p_77624_4_);
	}
}
