package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AdvancedProcessingChip extends ModBasicItemTemplate {
	public AdvancedProcessingChip() {
		setUnlocalizedName("AdvancedProcessingUnit");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
