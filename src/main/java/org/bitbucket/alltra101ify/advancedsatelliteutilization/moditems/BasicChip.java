package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;


public class BasicChip extends ModBasicItemTemplate {
	public BasicChip() {
		setUnlocalizedName("BasicProcessingChip");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
}
