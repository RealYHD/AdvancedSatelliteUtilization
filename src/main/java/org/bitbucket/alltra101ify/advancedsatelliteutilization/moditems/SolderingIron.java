package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ItemBlockMaterial;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

public class SolderingIron extends Item {
	
	public SolderingIron(ToolMaterial material) {
		super();
		setCreativeTab(ModCreativeTabs.TabASU);
		setUnlocalizedName("SolderingIron");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setMaxStackSize(1);
		}

}
