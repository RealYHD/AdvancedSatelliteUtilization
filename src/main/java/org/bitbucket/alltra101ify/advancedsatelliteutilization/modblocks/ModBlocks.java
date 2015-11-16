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
	public static Block CoreStabilizer_default = new CoreStabilizer((byte) 0);
	public static Block CoreStabilizer_nether = new CoreStabilizer((byte) 1);
	public static Block CoreStabilizer_ender = new CoreStabilizer((byte) 2);
	public static Block quaridiumOre = new QuaridiumOre(Material.iron);
	public static Block blockofashadwithquaridium = new blockOfASHADWithQuaridium(Material.iron);
	public static Block netherCoreGenerator = new NetherCoreGenerator();
	public static void blockInit() {
		ASURegistryHelper.registerBlock(blockofashad);
		ASURegistryHelper.registerBlock(transparentblockofashad);
		ASURegistryHelper.registerBlock(creditsBlock);
		ASURegistryHelper.registerBlock(ASUPedestal);
		ASURegistryHelper.registerBlock(EnderCoreGenerator);
		ASURegistryHelper.registerBlock(CoreStabilizer_default);
		ASURegistryHelper.registerBlock(CoreStabilizer_nether);
		ASURegistryHelper.registerBlock(quaridiumOre);
		ASURegistryHelper.registerBlock(blockofashadwithquaridium);
		ASURegistryHelper.registerBlock(netherCoreGenerator);
	}
}
