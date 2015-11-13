package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Blocker extends Block {

	protected Blocker() {
		super(Material.cloth);
		setBlockName("B-Lock-er");
		setBlockTextureName(ModInfo.MODID + ":" + getUnlocalizedName().substring(5));
		setHardness(1F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.addChatMessage(new ChatComponentText("YOU'VE BEEN B-LOCK-ER'ed (thomasvermette did some graphics for this mod so ya...)"));
		}

	    return true;
	}
	
	public boolean isOpaque() {
		return false;
	}
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
