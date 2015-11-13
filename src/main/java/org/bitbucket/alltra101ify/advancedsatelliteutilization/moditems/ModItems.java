package org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ASURegistryHelper;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ItemBlockMaterial;

import net.minecraft.item.Item;

public class ModItems {
	
	public static Item basicChip = new BasicChip();
	public static Item processingChip = new ProcessingChip();
	public static Item advancedProcessingChip = new AdvancedProcessingChip();
	public static Item focusModule = new FocusModule();
	public static Item spacialFocusingModule = new SpacialFocusingModule();
	public static Item solderingIron = new SolderingIron(ItemBlockMaterial.WorkTool);
	public static Item wrench = new Wrench(ItemBlockMaterial.WorkTool);
	public static Item ashadbrick = new ASHADBrick();
	public static Item quaridiumIngot = new QuaridiumIngot();
	public static Item humanInterfaceGate = new HumanInterfaceGate();
	public static Item conversionSpeedUpgrade = new ConversionSpeedUpgrade();
	public static Item fanModule = new FanModule();
	
	public static void itemInit() {
		ASURegistryHelper.registerItem(basicChip);
		ASURegistryHelper.registerItem(processingChip);
		ASURegistryHelper.registerItem(advancedProcessingChip);
		ASURegistryHelper.registerItem(focusModule);
		ASURegistryHelper.registerItem(spacialFocusingModule);
		ASURegistryHelper.registerItem(solderingIron);
		ASURegistryHelper.registerItem(wrench);
		ASURegistryHelper.registerItem(ashadbrick);
		ASURegistryHelper.registerItem(quaridiumIngot);
		ASURegistryHelper.registerItem(humanInterfaceGate);
		ASURegistryHelper.registerItem(conversionSpeedUpgrade);
		ASURegistryHelper.registerItem(fanModule);
		
	}
}
