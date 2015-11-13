package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockOfASHADWithQuaridium extends Block {
	
	public blockOfASHADWithQuaridium(Material material) {
		super(material);
		setBlockName("BlockOfASHADWithQuaridium");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setHardness(12);
		setHarvestLevel("pickaxe", 2);
		setResistance(2200F);
		setCreativeTab(ModCreativeTabs.TabASU);

	}
	
}
