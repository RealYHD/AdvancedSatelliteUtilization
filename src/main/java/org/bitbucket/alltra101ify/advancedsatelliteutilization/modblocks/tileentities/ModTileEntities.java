package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ASURegistryHelper;

public class ModTileEntities {
	
	public static void TileEntityInit() {
		ASURegistryHelper.registerTileEntity(TileEntityCoreStabilizer.class, "CoreStabilizer");
		ASURegistryHelper.registerTileEntity(TileEntityASUPedestal.class, "ASUPedestal");
		ASURegistryHelper.registerTileEntity(TileEntityEnderCoreGenerator.class, "EnderCore");
		ASURegistryHelper.registerTileEntity(TileEntityNetherCoreGenerator.class, "NetherCore");
		ASURegistryHelper.registerTileEntity(TileEntityAdvancedWasteHandler.class, "AdvancedWasteHandler_true");
		ASURegistryHelper.registerTileEntity(TileEntityAdvancedWasteHandler.class, "AdvancedWasteHandler_false");
	}
	
}
