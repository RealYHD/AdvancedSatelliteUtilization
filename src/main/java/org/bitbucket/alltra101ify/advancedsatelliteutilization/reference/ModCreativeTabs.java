package org.bitbucket.alltra101ify.advancedsatelliteutilization.reference;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {
	public static final CreativeTabs TabASU = new CreativeTabs(CreativeTabs.getNextID(), "asu") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.basicChip;
		}
	};
}
