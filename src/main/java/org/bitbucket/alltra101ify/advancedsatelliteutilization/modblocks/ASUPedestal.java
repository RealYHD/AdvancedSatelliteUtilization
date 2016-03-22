package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityASUPedestal;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

public class ASUPedestal extends BlockContainer {

	protected ASUPedestal() {
		super(Material.rock);
		setHardness(2);
		setLightLevel(0.3f);
		setBlockName("ASUPedestal");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModCreativeTabs.TabASU);
		setLightOpacity(1);
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
	public TileEntity createNewTileEntity(World world, int var) {
		return new TileEntityASUPedestal();
	}

}
