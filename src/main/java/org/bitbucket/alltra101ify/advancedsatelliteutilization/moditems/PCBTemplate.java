package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModBasicItemTemplate;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class PCBTemplate extends ModBasicItemTemplate {
	byte type;
	public IIcon icon[] = new IIcon[4];

	public PCBTemplate(byte type) {
		this.type = type;
		setUnlocalizedName("PCBTemplate"+type);
		setTextureName(ModInfo.MODID + ":" + "/PCBTemplate/" + getUnlocalizedName().substring(5));
		setMaxStackSize(16);
	}
	
	@Override
	public void registerIcons(IIconRegister icon) {
		for (int i = 0; i < this.icon.length; i++) {
			this.icon[i] = icon.registerIcon(ModInfo.MODID + ":" + "/PCBTemplate/" + getUnlocalizedName().substring(5));
		}
		super.registerIcons(icon);
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		switch (type) {
		case 0: return icon[0];
		case 1: return icon[1];
		case 2: return icon[2];
		case 3: return icon[3];
		}
		return icon[0];
	}
}
