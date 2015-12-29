package org.bitbucket.alltra101ify.advancedsatelliteutilization.reference;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.ModBlocks;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;



public class ASUCrafting {
	
	private static ItemStack ashadbrick = new ItemStack(ModItems.ashadbrick);
	private static ItemStack quaridiumingot = new ItemStack(ModItems.quaridiumIngot);
	
	public static void recipes() {

		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockofashad), 
				"xxx",
				"xxx",
				"xxx",
				'x', ashadbrick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.wrench),
				"I I",
				" H ",
				" I ",
				'I', new ItemStack(Items.iron_ingot), 'H', ashadbrick);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.solderingIron), 
				"#",
				"R",
				"A",'#', Items.iron_ingot, 'A', Items.brick, 'R', Items.redstone);
		
		GameRegistry.addSmelting(ModBlocks.quaridiumOre, new ItemStack(ModItems.quaridiumIngot ), 0.5f);
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.blockofashadwithquaridium), ashadbrick, ashadbrick, ashadbrick, ashadbrick, ashadbrick, quaridiumingot, quaridiumingot, quaridiumingot, quaridiumingot);
		
		
		
	}

	
}
