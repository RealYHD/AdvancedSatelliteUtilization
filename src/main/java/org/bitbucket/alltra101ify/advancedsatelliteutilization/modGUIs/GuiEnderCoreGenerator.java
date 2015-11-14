package org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.AdvancedSatelliteUtilization;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.ContainerEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.packets.ASUCoreTogglePacket;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import cpw.mods.fml.client.config.GuiCheckBox;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiEnderCoreGenerator extends GuiContainer {
	
	int scaledtobar, scaledtopercentage, scaledtofueltransfer, currentcooldown, currentpower;
	
	private ResourceLocation resource = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/GuiCoreGenerator.png");
	private TileEntityEnderCoreGenerator tileentity;
	
	public GuiEnderCoreGenerator(InventoryPlayer inventoryplayer, TileEntityEnderCoreGenerator tileentityendercoregenerator) {
		super(new ContainerEnderCoreGenerator(inventoryplayer, tileentityendercoregenerator));
		this.tileentity = tileentityendercoregenerator;
		this.xSize = 176;
		this.ySize = 149;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		buttonList.add(new GuiCheckBox(0, guiLeft+112+10, guiTop+14, null, tileentity.toggle));
	}
	
	@Override
	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 0:
		if (!tileentity.toggle) {
			tileentity.toggle = true;
			AdvancedSatelliteUtilization.packet.sendToServer(new ASUCoreTogglePacket(1,tileentity.xCoord, tileentity.yCoord, tileentity.zCoord));	
		} else {
			tileentity.toggle = false;
			AdvancedSatelliteUtilization.packet.sendToServer(new ASUCoreTogglePacket(0, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord));	
		}
		break;
		}
		super.actionPerformed(guibutton);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mx, int my) {
		this.mc.getTextureManager().bindTexture(resource);
		scaledtobar = this.tileentity.powerScaled(100);
		scaledtopercentage = this.tileentity.powerScaled(100);
		scaledtofueltransfer = this.tileentity.genscaled(100);
		currentcooldown = this.tileentity.cooldownscaled(100);
		currentpower = this.tileentity.currentPower;
		int percentagefontcolor;
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		

		drawTexturedModalRect(guiLeft+7, guiTop+8, 0, 149, scaledtobar, 16);
		drawTexturedModalRect(guiLeft+7, guiTop+8 + 12, 100, 149, scaledtofueltransfer, 4);
		drawTexturedModalRect(guiLeft+7, guiTop+8 + 12 + 3, 100, 149 + 4, currentcooldown, 3);

		
		drawCenteredString(fontRendererObj, "Ender Core Generator", guiLeft+90, guiTop-10, 0xFFFFFF);
		if (currentpower == 0) {
			percentagefontcolor = 0xFF0000;
		} else {
			percentagefontcolor = 1111111;
		}
		drawString(fontRendererObj, scaledtopercentage + "% full", guiLeft+40, guiTop+30, percentagefontcolor);
		
		drawString(fontRendererObj, scaledtofueltransfer + "% fuel", guiLeft+40, guiTop+38, percentagefontcolor);
		
		if (mx >= guiLeft+7 && mx <= guiLeft +7+100 && my >= guiTop +8 && my <= guiTop + 16 +8) {
			
			drawString(fontRendererObj, "MoE: " + currentpower + "/" + tileentity.maxpower, guiLeft+12, guiTop+12, 0xa8a8a8);
		}
		
	}
}
