package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

public class QuaridiumOre extends Block {

	protected QuaridiumOre(Material material) {
		super(material);
		setBlockName("QuaridiumOre");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setHardness(5);
		setLightLevel(0.3f);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(ModCreativeTabs.TabASU);
		}
	
}
