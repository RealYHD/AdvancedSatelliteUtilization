package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import net.minecraft.item.Item;

public class FanModule extends ModBasicItemTemplate {
	public FanModule() {
		setUnlocalizedName("FanModule");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setMaxStackSize(1);
	}
}
