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
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityCoreGenerator;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
		((TileEntityCoreGenerator)world.getTileEntity(x, y, z)).setCoords(x, y, z);
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
			int[] info = this.wrenched(player, world, x, y, z, ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock, ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).currentPower, (byte) ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).powerScaled(100), new ItemStack(ModBlocks.EnderCoreGenerator, 1));
			switch (info[1]) {
			
			case 0:	((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).currentPower = info[0];
			break;
			
			case 1: FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ENDERCOREGENERATORID, world, x, y, z);
			break;

			}
		} else if (world.getTileEntity(x, y, z) != null && ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).humanInterface() && !world.isRemote && ((TileEntityEnderCoreGenerator)world.getTileEntity(x, y, z)).multiblock) {
				FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ENDERCOREGENERATORID, world, x, y, z);
			}
		return true;
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

}
