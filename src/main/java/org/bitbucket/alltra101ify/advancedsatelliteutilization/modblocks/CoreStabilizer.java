package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.TileEntityCoreGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CoreStabilizer extends ModMachineBlock {
	protected CoreStabilizer() {
		super(Material.rock);
		setBlockName("CoreStabilizer");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModCreativeTabs.TabASU);
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var) {
		return new TileEntityCoreStabilizer(world);
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			isMultBlock(world, x, y, z);
		}
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.wrench) {
			int[] info = this.wrenched(player, world, x, y, z, false, 0, (byte) 0, new ItemStack(ModBlocks.CoreStabilizer, 1));
		}
		return true;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
		isMultBlock(world, x, y, z);
		super.onNeighborBlockChange(world, x, y, z, b);
	}
	
	public void isMultBlock(World world, int x, int y, int z) {
		
		if (world.getTileEntity(x, y+1, z) instanceof TileEntityCoreGenerator) {
			world.scheduleBlockUpdate(x, y+1, z, world.getBlock(x, y+1, z), 0);
			((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).version = 2;
			if (((TileEntityCoreGenerator)world.getTileEntity(x, y+1, z)).multiblock == true) {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).multiblock = true;
			} else {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).multiblock = false;
			}
		} else if (world.getTileEntity(x, y-1, z) instanceof TileEntityCoreGenerator) {
			world.scheduleBlockUpdate(x, y-1, z, world.getBlock(x, y-1, z), 0);
			((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).version = 1;
			if (((TileEntityCoreGenerator)world.getTileEntity(x, y-1, z)).multiblock == true) {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).multiblock = true;
			} else {
				((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).multiblock = false;
			}
		} else {
			((TileEntityCoreStabilizer)world.getTileEntity(x, y, z)).version = 0;
		}
		world.markBlockForUpdate(x, y, z);
	}
}
