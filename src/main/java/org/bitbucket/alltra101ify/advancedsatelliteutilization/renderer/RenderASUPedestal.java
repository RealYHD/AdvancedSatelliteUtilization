package org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.models.blockmodel.ModelASUPedestal;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderASUPedestal extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x,
			double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        GL11.glRotatef(180, 0f, 0f, 1f);
        this.bindTexture(texture);
        this.model.renderModel(0.0625f);
        
        GL11.glPopMatrix();
	}
	
	public RenderASUPedestal() {
		this.model = new ModelASUPedestal();
	}
	
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" + "/textures/models/ModelASUPedestal.png");
	
	private static ModelASUPedestal model;

}
