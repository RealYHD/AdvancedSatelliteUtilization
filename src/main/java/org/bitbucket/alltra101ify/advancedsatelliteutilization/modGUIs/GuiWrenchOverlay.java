package org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

public class GuiWrenchOverlay extends Gui
{
  private Minecraft mc;
  private ResourceLocation resource = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/WrenchGUI.png");
  private static final byte XSIZE = 12, YSIZE = 11, XSTART = 12, YSTART = 0;
  int xPos = 16;
  int yPos = 8;
  public GuiWrenchOverlay(Minecraft mc)
  {
    super();
    
    this.mc = mc;
  }

  @SubscribeEvent(priority = EventPriority.NORMAL)
  public void onRenderExperienceBar(RenderGameOverlayEvent event)
  {

    if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
    {      
      return;
    }


    if (mc.thePlayer.getCurrentEquippedItem()!= null && mc.thePlayer.getCurrentEquippedItem().getItem().equals(ModItems.wrench) && mc.thePlayer.getCurrentEquippedItem().stackTagCompound != null)
    {
        byte mode = mc.thePlayer.getCurrentEquippedItem().stackTagCompound.getByte("Mode");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(GL11.GL_LIGHTING);      
		this.mc.getTextureManager().bindTexture(resource);
		
		switch (mode) {
		case -1: switchOnOff(false);
		break;
		case 0: this.drawTexturedModalRect(xPos, yPos, XSTART, YSTART, XSIZE, YSIZE); switchOnOff(true);
		break;
		case 1: this.drawTexturedModalRect(xPos, yPos, XSTART + mode*XSIZE, YSTART, XSIZE, YSIZE); switchOnOff(true);
		break;
		case 2: this.drawTexturedModalRect(xPos, yPos, XSTART + mode*XSIZE, YSTART, XSIZE, YSIZE); switchOnOff(true);
		break;
		case 3: this.drawTexturedModalRect(xPos, yPos, XSTART + mode*XSIZE, YSTART, XSIZE, YSIZE); switchOnOff(true);
		break;
		case 4: this.drawTexturedModalRect(xPos, yPos, XSTART + mode*XSIZE, YSTART, XSIZE, YSIZE); switchOnOff(true);
		break;
		case 5: this.drawTexturedModalRect(xPos, yPos, XSTART + mode*XSIZE, YSTART, XSIZE, YSIZE); switchOnOff(true);
      }
    }
  }
  
  void switchOnOff(boolean onOff) {
	  if (onOff) {
		  this.drawTexturedModalRect(xPos-12, yPos, XSTART - 12, YSTART+11, XSIZE, YSIZE);
	  } else {
		  this.drawTexturedModalRect(xPos-12, yPos, XSTART - 12, YSTART, XSIZE, YSIZE);
	  }
   }
}