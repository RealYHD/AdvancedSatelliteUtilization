package org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityNetherCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.models.blockmodel.ModelCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderNetherCoreGenerator extends TileEntitySpecialRenderer {
	private ModelCoreGenerator modelASU = new ModelCoreGenerator();
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" + "/textures/models/ModelNetherCore.png");

	public void renderTileEntityAt(TileEntityNetherCoreGenerator tileentity, double x, double y,
			double z, float f) {
        float f1 = tileentity.rotationY;
        float f2 = tileentity.rotationX;
        

		GL11.glPushMatrix();
		modelASU.MainCrystal.rotateAngleY = f1;
		modelASU.MainCrystal.rotateAngleX = f2;
		
		GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		modelASU.renderModel(0.0625f);

		GL11.glPopMatrix();

	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x,
			double y, double z, float f) {
		this.renderTileEntityAt((TileEntityNetherCoreGenerator)tileentity, x, y, z, f);
		
	}

}
