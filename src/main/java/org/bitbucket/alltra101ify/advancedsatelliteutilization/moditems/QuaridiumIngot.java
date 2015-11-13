package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

public class QuaridiumIngot extends ModBasicItemTemplate {
	
	public QuaridiumIngot() {
		setUnlocalizedName("QuaridiumIngot");
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
}
