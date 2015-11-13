package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockOfASHAD extends Block {

	protected BlockOfASHAD() {
		super(Material.iron);
		setBlockName("BlockOfASHAD");
		setHardness(8);
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setHarvestLevel("pickaxe", 2);
		setResistance(2100F);
		setCreativeTab(ModCreativeTabs.TabASU);
	}
}
