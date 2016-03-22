package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ASURegistryHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static Block blockofashad = new BlockOfASHAD();
	public static Block transparentblockofashad = new TransparentBlockOfASHAD();
	public static Block creditsBlock = new Blocker();
	public static Block ASUPedestal = new ASUPedestal();
	public static Block EnderCoreGenerator = new EnderCoreGenerator();
	public static Block CoreStabilizer = new CoreStabilizer();
	public static Block AdvancedWasteHandler_active = new AdvancedWasteHandler(true);
	public static Block AdvancedWasteHandler = new AdvancedWasteHandler(false);
	public static Block quaridiumOre = new QuaridiumOre(Material.iron);
	public static Block blockofashadwithquaridium = new blockOfASHADWithQuaridium(Material.iron);
	public static Block netherCoreGenerator = new NetherCoreGenerator();
	public static Block frameSupport = new FrameSupport();
	public static Block frameProjector_False = new FrameProjector(false);
	public static Block frameProjector_True = new FrameProjector(true);
	public static void blockInit() {
		ASURegistryHelper.registerBlock(blockofashad);
		ASURegistryHelper.registerBlock(transparentblockofashad);
		ASURegistryHelper.registerBlock(creditsBlock);
		ASURegistryHelper.registerBlock(ASUPedestal);
		ASURegistryHelper.registerBlock(EnderCoreGenerator);
		ASURegistryHelper.registerBlock(CoreStabilizer);
		ASURegistryHelper.registerBlock(quaridiumOre);
		ASURegistryHelper.registerBlock(blockofashadwithquaridium);
		ASURegistryHelper.registerBlock(netherCoreGenerator);
		ASURegistryHelper.registerBlock(AdvancedWasteHandler);
		ASURegistryHelper.registerBlock(AdvancedWasteHandler_active);
		ASURegistryHelper.registerBlock(frameSupport);
		ASURegistryHelper.registerBlock(frameProjector_False);
		ASURegistryHelper.registerBlock(frameProjector_True);
	}
}
