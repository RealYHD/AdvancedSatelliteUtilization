package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TransparentBlockOfASHAD extends Block {

	public TransparentBlockOfASHAD() {
    	super(Material.glass);
    	this.setCreativeTab(ModCreativeTabs.TabASU);
        setBlockName("TransparentBlockOfASHAD");
        setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
        setHardness(1);
        setResistance(3);
    }

	public boolean isOpaqueCube() {
		return false;
	}
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
