// Date: 4/29/2015 10:08:14 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package org.bitbucket.alltra101ify.advancedsatelliteutilization.models.blockmodel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCoreStabilizer extends ModelBase
{
  //fields
    ModelRenderer BaseB;
    ModelRenderer BaseT;
    ModelRenderer MiddleStabilizer;
    public ModelRenderer Support1;
    public ModelRenderer Support2;
    public ModelRenderer Support4;
    public ModelRenderer Support3;
  
  public ModelCoreStabilizer()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      BaseB = new ModelRenderer(this, 0, 0);
      BaseB.addBox(0F, 0F, 0F, 16, 3, 16);
      BaseB.setRotationPoint(-8F, 21F, -8F);
      BaseB.setTextureSize(64, 64);
      BaseB.mirror = true;
      setRotation(BaseB, 0F, 0F, 0F);
      BaseT = new ModelRenderer(this, 0, 19);
      BaseT.addBox(0F, 0F, 0F, 16, 3, 16);
      BaseT.setRotationPoint(-8F, 8F, -8F);
      BaseT.setTextureSize(64, 64);
      BaseT.mirror = true;
      setRotation(BaseT, 0F, 0F, 0F);
      MiddleStabilizer = new ModelRenderer(this, 16, 38);
      MiddleStabilizer.addBox(0F, 0F, 0F, 2, 10, 2);
      MiddleStabilizer.setRotationPoint(-1F, 11F, -1F);
      MiddleStabilizer.setTextureSize(64, 64);
      MiddleStabilizer.mirror = true;
      setRotation(MiddleStabilizer, 0F, 0F, 0F);
      Support1 = new ModelRenderer(this, 34, 38);
      Support1.addBox(5F, 0F, -2F, 1, 10, 4);
      Support1.setRotationPoint(0F, 11F, 0F);
      Support1.setTextureSize(64, 64);
      Support1.mirror = true;
      setRotation(Support1, 0F, 0F, 0F);
      Support2 = new ModelRenderer(this, 54, 38);
      Support2.addBox(-6F, 0F, -2F, 1, 10, 4);
      Support2.setRotationPoint(0F, 11F, 0F);
      Support2.setTextureSize(64, 64);
      Support2.mirror = true;
      setRotation(Support2, 0F, 0F, 0F);
      Support4 = new ModelRenderer(this, 44, 38);
      Support4.addBox(-2F, 0F, 5F, 4, 10, 1);
      Support4.setRotationPoint(0F, 11F, 0F);
      Support4.setTextureSize(64, 64);
      Support4.mirror = true;
      setRotation(Support4, 0F, 0F, 0F);
      Support3 = new ModelRenderer(this, 24, 38);
      Support3.addBox(-2F, 0F, -6F, 4, 10, 1);
      Support3.setRotationPoint(0F, 11F, 0F);
      Support3.setTextureSize(64, 64);
      Support3.mirror = true;
      setRotation(Support3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    BaseB.render(f5);
    BaseT.render(f5);
    MiddleStabilizer.render(f5);
    Support1.render(f5);
    Support2.render(f5);
    Support4.render(f5);
    Support3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderModel(float f) {
	    BaseB.render(f);
	    BaseT.render(f);
	    MiddleStabilizer.render(f);
	    Support1.render(f);
	    Support2.render(f);
	    Support4.render(f);
	    Support3.render(f);
}
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
