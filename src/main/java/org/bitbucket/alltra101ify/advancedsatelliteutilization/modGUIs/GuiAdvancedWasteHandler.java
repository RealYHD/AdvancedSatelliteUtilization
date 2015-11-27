package org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityAdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modcontainers.ContainerAdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiAdvancedWasteHandler extends GuiContainer {
	
	int currentcooldownscaled;

	int currentpowerscaled;
	
	int currentconversion;
	
	private TileEntityAdvancedWasteHandler tileentity;
	
	private ResourceLocation resource = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/GuiAdvancedWasteHandler.png");
	
	public GuiAdvancedWasteHandler(InventoryPlayer inventoryplayer, TileEntityAdvancedWasteHandler tileentity) {
		super(new ContainerAdvancedWasteHandler(inventoryplayer, tileentity));
		this.tileentity = tileentity;
		this.xSize = 176;
		this.ySize = 187;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mx, int my) {
		this.mc.getTextureManager().bindTexture(resource);
		currentcooldownscaled = this.tileentity.cooldownscaled(51);
		currentpowerscaled = this.tileentity.powerScaled(55);
		currentconversion = this.tileentity.genscaled(52);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		drawTexturedModalRect(guiLeft+74, guiTop+44, 176, 0, currentcooldownscaled, 16);
		drawTexturedModalRect(guiLeft+14, guiTop+44, 176, 16, currentpowerscaled, 16);
		drawTexturedModalRect(guiLeft+41, guiTop+65, 176, 32, currentconversion, 16);
		drawCenteredString(fontRendererObj, "Advanced Waste Handler", guiLeft+90, guiTop-10, 0xFFFFFF);
		
		
		if (mx > guiLeft+14 && mx < guiLeft+70 && my > guiTop+44 && my < guiTop+64) {
			drawString(fontRendererObj, tileentity.currentPower + "/" + tileentity.maxpower, guiLeft+110, guiTop+70, 0xa8a8a8);
		}
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
