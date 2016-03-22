package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import net.minecraft.item.Item;

public class satelliteFrame extends ModBasicItemTemplate {
	byte tier;
	public satelliteFrame(byte tier) {
		this.tier = tier;
		
		setTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5) + "T" + tier);
	}
	
}
