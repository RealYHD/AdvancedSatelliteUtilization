package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import net.minecraft.creativetab.CreativeTabs;

public class FocusModule extends ModBasicItemTemplate {
	public FocusModule() {
		setUnlocalizedName("EarthTargetingFocus");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setMaxStackSize(16);
	}
}
