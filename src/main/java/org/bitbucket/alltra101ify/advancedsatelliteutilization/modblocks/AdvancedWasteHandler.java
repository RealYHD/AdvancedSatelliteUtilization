package org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.AdvancedSatelliteUtilization;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modGUIs.ModGUIs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityAdvancedWasteHandler;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.tileentities.TileEntityEnderCoreGenerator;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.moditems.ModItems;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModCreativeTabs;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.ModInfo;
import org.bitbucket.alltra101ify.advancedsatelliteutilization.reference.moditemblockreference.ModMachineBlock;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AdvancedWasteHandler extends ModMachineBlock {
	boolean active;
	
	public IIcon icon[] = new IIcon[4];
	
	protected AdvancedWasteHandler(boolean active) {
		super(Material.rock);
		this.active = active;
		setBlockName("AdvancedWasteHandler_" + active);
		if (!active) setCreativeTab(ModCreativeTabs.TabASU);
		setBlockTextureName(ModInfo.MODID + ":" + "AdvancedWasteHandler/" + getUnlocalizedName().substring(5));
		setResistance(8);
		setHardness(8);
		setHarvestLevel("pickaxe", 2);
		if (active) setLightLevel(0.9f);
	}
	@Override
	public TileEntity createNewTileEntity(World w, int var) {
		return new TileEntityAdvancedWasteHandler();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entitylivingbase, ItemStack item) {
		int i = MathHelper.floor_double((double)(entitylivingbase.rotationYaw * 4.0f/360.0f) + 0.5D) & 3;
		switch (i) {
		case 0: world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		break;
		case 1: world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		break;
		case 2: world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		break;
		case 3: world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		break;
		}
		super.onBlockPlacedBy(world, x, y, z, entitylivingbase, item);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.icon[0] = icon.registerIcon(ModInfo.MODID + ":" + "AdvancedWasteHandler/" + getUnlocalizedName().substring(5) + "_front");
		this.icon[1] = icon.registerIcon(ModInfo.MODID + ":" + "AdvancedWasteHandler/" + getUnlocalizedName().substring(5)+ "_sides");
		this.icon[2] = icon.registerIcon(ModInfo.MODID + ":" + "AdvancedWasteHandler/" + getUnlocalizedName().substring(5)+ "_top");
		this.icon[3] = icon.registerIcon(ModInfo.MODID + ":" + "AdvancedWasteHandler/" + getUnlocalizedName().substring(5)+ "_bottom");
		super.registerBlockIcons(icon);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		IIcon iconreturned;
		if (meta == 0) {
			switch (side) {
			case 0: iconreturned = icon[3];
			break;
			case 1: iconreturned = icon[2];
			break;
			case 3: iconreturned = icon[0];
			break;
			default: iconreturned = icon[1];
			}
		} else if (side == 1) {
			iconreturned = this.icon[2];
		}else if (side == 0) {
			iconreturned = this.icon[3];
		} else if (side != meta) {
			iconreturned = this.icon[1];
		} else {
			iconreturned = this.icon[0];
		}
		return iconreturned;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.wrench) {
			int info[] = this.wrenched(player, world, x, y, z, true, (int) ((TileEntityAdvancedWasteHandler)world.getTileEntity(x, y, z)).currentPower, (byte) ((TileEntityAdvancedWasteHandler)world.getTileEntity(x, y, z)).powerScaled(100), new ItemStack(ModBlocks.AdvancedWasteHandler, 1));
			switch (info[1]) {
			case 0: ((TileEntityAdvancedWasteHandler)world.getTileEntity(x, y, z)).currentPower = info[0];
			break;
			
			case 1: FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ADVANCEDWASTEHANDLERID, world, x, y, z);
			break;
			}
		} else if (((TileEntityAdvancedWasteHandler)world.getTileEntity(x, y, z)).humanInterface() && !world.isRemote) {
			FMLNetworkHandler.openGui(player, AdvancedSatelliteUtilization.instance, ModGUIs.ADVANCEDWASTEHANDLERID, world, x, y, z);
			return true;
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(ModBlocks.AdvancedWasteHandler);
	}
	
	@Override
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
		return Item.getItemFromBlock(ModBlocks.AdvancedWasteHandler);
	}
	
	public static void updateGenerator(World world, int x, int y, int z, boolean active) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity te = (TileEntityAdvancedWasteHandler)world.getTileEntity(x, y, z);
		
		if (active) {
			world.setBlock(x, y, z, ModBlocks.AdvancedWasteHandler_active);
		} else {
			world.setBlock(x, y, z, ModBlocks.AdvancedWasteHandler);
		}
		
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
		
		if (te != null) {
			te.validate();
			world.setTileEntity(x, y, z, te);
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random r) {
		if (active) {
			for (int i = 0; i < 4; i++) {
				world.spawnParticle("explode", x+0.4F, y+1.3F, z+0.55f, 0, 0.01F, 0);
			}
		}
		super.randomDisplayTick(world, x, y, z, r);
	}
	
}
