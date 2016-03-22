package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityFrameSupport;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicMachineBlock;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FrameSupport extends ModBasicMachineBlock {

	protected FrameSupport() {
		super(Material.rock);
		setCreativeTab(ModCreativeTabs.TabASU);
		setBlockName("FrameSupport");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.4f);
		this.isBlockContainer = true;
		
	}

	
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random r) {
		checkSurrounding(world, x, y, z);
		super.updateTick(world, x, y, z, r);
	}
	
	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block p_149695_5_) {
		w.scheduleBlockUpdate(x, y, z, w.getBlock(x, y, z), 1);
	}
	
	public void checkSurrounding(World world, int x, int y, int z) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (world.getBlock(x+i, y, z+j) == ModBlocks.frameProjector_False || world.getBlock(x+i, y, z+j) == ModBlocks.frameProjector_True) {
					world.scheduleBlockUpdate(x+i, y, z+j, world.getBlock(x+i, y, z+j), 1);
				}
			}
		}
	}
	
}
