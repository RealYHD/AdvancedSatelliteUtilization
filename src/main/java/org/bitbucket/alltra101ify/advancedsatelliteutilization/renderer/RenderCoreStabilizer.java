package org.bitbucket.alltra101ify.advancedsatelliteutilization.renderer;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.models.blockmodel.ModelCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.models.blockmodel.ModelCoreStabilizer;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderCoreStabilizer extends TileEntitySpecialRenderer {
	private ModelCoreStabilizer modelASU = new ModelCoreStabilizer();
	public static ResourceLocation[] texture = new ResourceLocation[3];
	public void renderTileEntityAt(TileEntityCoreStabilizer tileentity, double x,
			double y, double z, float f) {
		float f1 = tileentity.rotationY;
		GL11.glPushMatrix();
		modelASU.Support1.rotateAngleY = f1;
		modelASU.Support2.rotateAngleY = f1;
		modelASU.Support3.rotateAngleY = f1;
		modelASU.Support4.rotateAngleY = f1;
		
		GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture[tileentity.version]);

		modelASU.renderModel(0.0625f);

		GL11.glPopMatrix();
		
	}
	
	public  RenderCoreStabilizer() {
		texture[0] = new ResourceLocation(ModInfo.MODID + ":" + "/textures/models/CoreStabilizer/ModelCoreStabilizer0.png");
		texture[1] = new ResourceLocation(ModInfo.MODID + ":" + "/textures/models/CoreStabilizer/ModelCoreStabilizer1.png");
		texture[2] = new ResourceLocation(ModInfo.MODID + ":" + "/textures/models/CoreStabilizer/ModelCoreStabilizer2.png");
	}
	
	

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x,
			double y, double z, float f) {
		this.renderTileEntityAt((TileEntityCoreStabilizer)tileentity, x, y, z, f);
		
	}

}
