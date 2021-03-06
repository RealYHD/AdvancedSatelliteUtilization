package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.AdvancedSatelliteUtilization;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.ModGUIs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityGenerator;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EnderCoreGenerator extends ModMachineBlock {

	protected EnderCoreGenerator() {
		super(Material.rock);
		setCreativeTab(ModCreativeTabs.TabASU);
		setBlockName("EnderCoreGenerator");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.4f);
		this.isBlockContainer = true;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		((TileEntityGenerator)world.getTileEntity(x, y, z)).setCoords(x, y, z);
		super.onBlockAdded(world, x, y, z);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var) {
		return new TileEntityEnderCoreGenerator();
	}

	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
		world.scheduleBlockUpdate(x, y, z, ModBlocks.EnderCoreGenerator, 1);
		super.onNeighborBlockChange(world, x, y, z, b);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random r) {
		this.isMultiBlock(world, x, y, z);
		super.updateTick(world, x, y, z, r);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.wrench) {
			int[] info = this.wrenched(player, world, x, y, z, ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock, (int) ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).currentPower, (byte) ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).powerScaled(100), new ItemStack(ModBlocks.EnderCoreGenerator, 1));
			switch (info[1]) {
			
			case 0:	((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).currentPower = info[0];
			break;
			
			case 1: FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ENDERCOREGENERATORID, world, x, y, z);
			break;

			}
		} else if (world.getTileEntity(x, y, z) != null && ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).humanInterface() && !world.isRemote && ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock) {
				FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ENDERCOREGENERATORID, world, x, y, z);
				return true;
			}
		return false;
	}
	
	public void isMultiBlock(World world, int x, int y, int z) {
		if (world.getBlock(x, y+1, z) == ModBlocks.CoreStabilizer && world.getBlock(x, y-1, z) == ModBlocks.CoreStabilizer && world.getBlock(x, y-2, z) == ModBlocks.blockofashadwithquaridium && world.getBlock(x, y+2, z) == ModBlocks.blockofashadwithquaridium) {
			((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock = true;
			((TileEntityCoreStabilizer)world.getTileEntity(x, y+1, z)).multiblock = true;
			((TileEntityCoreStabilizer)world.getTileEntity(x, y-1, z)).multiblock = true;
			world.markBlockForUpdate(x, y+1, z);
			world.markBlockForUpdate(x, y-1, z);
		} else {
			((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock = false;
			if (world.getTileEntity(x, y+1, z) instanceof TileEntityCoreStabilizer) {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y+1, z)).multiblock = false;
				((TileEntityCoreStabilizer)world.getTileEntity(x, y+1, z)).version = 0;
				world.markBlockForUpdate(x, y+1, z);
			}
			if (world.getTileEntity(x, y-1, z) instanceof TileEntityCoreStabilizer) {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y-1, z)).multiblock = false;
				((TileEntityCoreStabilizer)world.getTileEntity(x, y-1, z)).version = 0;
				world.markBlockForUpdate(x, y-1, z);
			}
		}
		world.markBlockForUpdate(x, y, z);
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block b, int i) {
		DropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, b, i);
	}
	public void DropItems(World world, int x, int y, int z) {
		Random r = new Random();
		TileEntityEnderCoreGenerator tileentity = ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z));
		for (int i = 0; i < tileentity.getSizeInventory(); i++) {
			ItemStack itemstack = tileentity.getStackInSlot(i);
			if (itemstack != null) {
				float rand[] = new float[3];
				for (int i1 = 0; i1 < 3; i1++) {
					rand[i1] = r.nextFloat() * 0.8F + 0.1F;
				}
				while (itemstack.stackSize > 0) {
					int j1 = r.nextInt(21) + 10;
					
					if (j1 > itemstack.stackSize) {
						j1 = itemstack.stackSize;
					}
					itemstack.stackSize -= j1;
					EntityItem entityitem = new EntityItem(world, x + rand[0], y + rand[1], z + rand[2], new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
					
					if (itemstack.hasTagCompound()) {
						entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
					}
					 float f3 = 0.05F;
					 entityitem.motionX = r.nextGaussian() * f3;
					 entityitem.motionY = r.nextGaussian() * f3 + 0.2f;
					 entityitem.motionZ = r.nextGaussian() * f3;
					 world.spawnEntityInWorld(entityitem);
				}
			}
		}
	}

}
