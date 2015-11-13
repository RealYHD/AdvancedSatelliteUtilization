package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

public class ASHADBrick extends ModBasicItemTemplate {
	public ASHADBrick() {
		setUnlocalizedName("ASHADBrick");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
