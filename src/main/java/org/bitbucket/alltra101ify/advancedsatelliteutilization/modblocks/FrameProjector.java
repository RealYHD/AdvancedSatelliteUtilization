package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityFrameProjector;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FrameProjector extends ModMachineBlock {
	
	boolean multiBlock;
	
	protected FrameProjector(boolean multiBlock) {
		super(Material.iron);
		this.multiBlock = multiBlock;
		if (multiBlock == false) {
			setCreativeTab(ModCreativeTabs.TabASU);
		}
		if (multiBlock == true) {
			setLightLevel(0.8f);
		}
		setBlockName("FrameProjector" + "_" + multiBlock);
		setBlockTextureName(ModInfo.MODID + ":" + "FrameProjector/" + getUnlocalizedName().substring(5));
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
		this.isBlockContainer = true;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityFrameProjector(multiBlock);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 1);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random r) {
		if (isMultiBlock(world, x, y, z)) {
			world.setBlock(x, y, z, ModBlocks.frameProjector_True);
		} else {
			world.setBlock(x, y, z, ModBlocks.frameProjector_False);
		}
	}
	protected boolean isMultiBlock(World world, int x, int y, int z) {
		byte multiBlockCount = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (world.getBlock(x+i, y, z+j) == ModBlocks.frameSupport) {
					multiBlockCount++;
				}
			}
		}
		
		if (multiBlockCount == 8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}