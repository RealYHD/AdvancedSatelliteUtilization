package org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityAdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityNetherCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.ContainerAdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.ContainerEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.ContainerNetherCoreGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ASUGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		Object returned = null;
		switch(ID) {
		case ModGUIs.ENDERCOREGENERATORID: if (tileentity instanceof TileEntityEnderCoreGenerator) returned = new ContainerEnderCoreGenerator(player.inventory, (TileEntityEnderCoreGenerator)tileentity);
		break;
		case ModGUIs.NETHERCOREGENERATORID: if (tileentity instanceof TileEntityNetherCoreGenerator) returned = new ContainerNetherCoreGenerator(player.inventory, (TileEntityNetherCoreGenerator)tileentity);
		break;
		case ModGUIs.ADVANCEDWASTEHANDLERID: if (tileentity instanceof TileEntityAdvancedWasteHandler) returned = new ContainerAdvancedWasteHandler(player.inventory, (TileEntityAdvancedWasteHandler)tileentity);
		}
		
		return returned;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		
		Object returned = null;
		
		switch(ID) {
		case ModGUIs.ENDERCOREGENERATORID: if (tileentity instanceof TileEntityEnderCoreGenerator) returned = new GuiEnderCoreGenerator(player.inventory, (TileEntityEnderCoreGenerator)tileentity);
		break;
		case ModGUIs.NETHERCOREGENERATORID: if (tileentity instanceof TileEntityNetherCoreGenerator) returned = new GuiNetherCoreGenerator(player.inventory, (TileEntityNetherCoreGenerator)tileentity);
		break;
		case ModGUIs.ADVANCEDWASTEHANDLERID: if (tileentity instanceof TileEntityAdvancedWasteHandler) returned = new GuiAdvancedWasteHandler(player.inventory, (TileEntityAdvancedWasteHandler)tileentity);
		}
		
		return returned;

	}

}
