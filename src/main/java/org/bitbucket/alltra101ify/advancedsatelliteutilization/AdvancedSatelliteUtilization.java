package org.bitbucket.alltra101ify.advancedsatelliteutilization;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.asuworldgen.WorldGen;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.asuworldgen.oregen.ASUWorldOreGen;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.ASUGuiHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.GuiWrenchOverlay;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.ModBlocks;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.ModTileEntities;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.packets.ASUCoreTogglePacket;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.proxy.CommonProxy;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ASUCrafting;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class AdvancedSatelliteUtilization {

@Mod.Instance(ModInfo.MODID)
public static AdvancedSatelliteUtilization instance;
public static SimpleNetworkWrapper packet;
	
@SidedProxy(clientSide = "org.bitbucket.alltra101ify.advancedsatelliteutilization.proxy.ClientProxy", serverSide = "org.bitbucket.alltra101ify.advancedsatelliteutilization.proxy.CommonProxy")
public static CommonProxy ASUproxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		packet = NetworkRegistry.INSTANCE.newSimpleChannel("ASU");
		ModItems.itemInit();
		ModBlocks.blockInit();
		ModTileEntities.TileEntityInit();
		ASUproxy.registerRender();
		WorldGen.preInitGen();
		packet.registerMessage(ASUCoreTogglePacket.handler.class, ASUCoreTogglePacket.class, 0, Side.SERVER);	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ASUCrafting.recipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ASUGuiHandler());
		

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	    MinecraftForge.EVENT_BUS.register(new GuiWrenchOverlay(Minecraft.getMinecraft()));

	}
}
