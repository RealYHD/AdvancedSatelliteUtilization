package org.bitbucket.alltra101ify.advancedsatelliteutilization.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.ModBlocks;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityASUPedestal;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityNetherCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.RenderASUPedestal;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.RenderCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.RenderEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.RenderNetherCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.inventoryrender.ItemRenderASUPedestal;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.inventoryrender.ItemRenderCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer.inventoryrender.ItemRenderEnderCoreGenerator;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRender() {
		
		TileEntitySpecialRenderer renderASUPedestal = new RenderASUPedestal();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityASUPedestal.class, renderASUPedestal);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.ASUPedestal), new ItemRenderASUPedestal(renderASUPedestal, new TileEntityASUPedestal()));
		
		TileEntitySpecialRenderer renderEnderCore = new RenderEnderCoreGenerator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderCoreGenerator.class, renderEnderCore);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.EnderCoreGenerator), new ItemRenderEnderCoreGenerator(renderEnderCore, new TileEntityEnderCoreGenerator()));
		
		TileEntitySpecialRenderer renderCoreStabilizer_default = new RenderCoreStabilizer((byte) 0);
		TileEntitySpecialRenderer renderCoreStabilizer_nether = new RenderCoreStabilizer((byte) 2);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoreStabilizer.class, renderCoreStabilizer_default);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.CoreStabilizer_default), new ItemRenderCoreStabilizer(renderCoreStabilizer_default, new TileEntityCoreStabilizer()));
		
		TileEntitySpecialRenderer renderNetherCore = new RenderNetherCoreGenerator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherCoreGenerator.class, renderNetherCore);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.netherCoreGenerator), new ItemRenderEnderCoreGenerator(renderNetherCore, new TileEntityNetherCoreGenerator()));
	}
	
	
	
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
