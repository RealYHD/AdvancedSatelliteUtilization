package org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.AdvancedSatelliteUtilization;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.ModGUIs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.ModBlocks;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public abstract class ModMachineBlock extends BlockContainer {
	protected ModMachineBlock(Material material) {
		super(material);
	}
	/**
	 * @param player EntityPlayer
	 * @param world world
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 * @param multiblock if this is a multiblock or not. If does not belong to a multiblock, always true.
	 * @param currentPower current power of the block. For debugging purposes.
	 * @param scale percentage of power
	 * @param itemtogive item to return when using wrench to break
	 * @return returns 1 on array [1] on servers if it is valid for opening gui while 2 is for destroying and giving item to player. Array [0] is to set the new power.
	 */
	public int[] wrenched(EntityPlayer player, World world, int x, int y, int z, boolean multiblock, int currentPower, byte scale, ItemStack itemtogive) {
		int[] info = new int[2];
		info[0] = currentPower;
		info[1] = 0;
		
		if (player.getCurrentEquippedItem().stackTagCompound != null) {
			byte mode = player.getCurrentEquippedItem().stackTagCompound.getByte("Mode");

			switch (mode) {
			case 0:
				if (!world.isRemote && multiblock == true && world.getTileEntity(x, y, z) != null) {
					info[1] = 1;
				}
			break;
			
			case 1: info[1] = 2; world.setBlockToAir(x, y, z); world.removeTileEntity(x, y, z); player.inventory.addItemStackToInventory(itemtogive);
			break;
			
			case 2: info[0] += 100; if(world.isRemote) {player.addChatMessage(new ChatComponentText("added 100 power. " + "Current power: " + info[0]));};
			break;
			
			case 3: if(world.isRemote) {player.addChatMessage(new ChatComponentText("Current power: " + currentPower));}
			break;
			
			case 4: if(world.isRemote) {player.addChatMessage(new ChatComponentText("Current percentage calculation: " + scale));}
			break;
			
			case 5: info[0] -= 100; if(world.isRemote) {player.addChatMessage(new ChatComponentText("removed 100 power. " + "Current power: " + info[0]));};
			break;
			}

		}
		return info;
	}
}
