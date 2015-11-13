package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.AdvancedSatelliteUtilization;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.ModGUIs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityNetherCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityCoreGenerator;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class NetherCoreGenerator extends ModMachineBlock {

	protected NetherCoreGenerator() {
		super(Material.rock);
		setCreativeTab(ModCreativeTabs.TabASU);
		setBlockName("NetherCoreGenerator");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.6f);
		this.isBlockContainer = true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var) {
		// TODO Auto-generated method stub
		return new TileEntityNetherCoreGenerator();
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
		world.scheduleBlockUpdate(x, y, z, ModBlocks.netherCoreGenerator, 1);
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
			int[] info = this.wrenched(player, world, x, y, z, ((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).multiblock, ((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).currentPower, (byte) ((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).powerScaled(100), new ItemStack(ModBlocks.netherCoreGenerator, 1));
			switch (info[1]) {
			
			case 0:	((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).currentPower = info[0];
			break;
			
			case 1: FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.NETHERCOREGENERATORID, world, x, y, z);
			break;
			}
		} else if (world.getTileEntity(x, y, z) != null && ((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).humanInterface() && !world.isRemote && ((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).multiblock) {
			FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.NETHERCOREGENERATORID, world, x, y, z);
		}
		return true;
	}
	
	public void isMultiBlock(World world, int x, int y, int z) {
		if (world.getBlock(x, y+1, z) == ModBlocks.CoreStabilizer && world.getBlock(x, y-1, z) == ModBlocks.CoreStabilizer && world.getBlock(x, y-2, z) == ModBlocks.blockofashadwithquaridium && world.getBlock(x, y+2, z) == ModBlocks.blockofashadwithquaridium) {
			((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).multiblock = true;
			
		} else {
			((TileEntityNetherCoreGenerator)world.getTileEntity(x, y, z)).multiblock = false;
		}
		world.markBlockForUpdate(x, y, z);
	}
	
}
