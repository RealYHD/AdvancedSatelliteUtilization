package org.bitbucket.alltra101ify.advancedsatelliteutilization.reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class ASURegistryHelper {
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, ModInfo.MODID + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, ModInfo.MODID + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> tileentity, String unlocalizedname) {
		GameRegistry.registerTileEntity(tileentity, unlocalizedname);
	}
}
