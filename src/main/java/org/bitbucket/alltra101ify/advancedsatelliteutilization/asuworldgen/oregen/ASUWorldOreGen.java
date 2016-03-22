package org.bitbucket.alltra101ify.advancedsatelliteutilization.asuworldgen.oregen;

import java.util.Random;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.modblocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ASUWorldOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1: OreGenNether(random, chunkX * 16, chunkZ * 16, world); break;
		case 0: OreGenOverworld(random, chunkX * 16, chunkZ * 16, world); break;
		case 1: OreGenEnd(random, chunkX * 16, chunkZ * 16, world); break;
		}

	}

	private void OreGenEnd(Random random, int x, int z, World world) {
		// TODO Auto-generated method stub
		
	}

	private void OreGenOverworld(Random random, int x, int z, World world) {
		addOreSpawn(ModBlocks.quaridiumOre, world, random, x, z, 1, 6, 3, 3, 10);
		
	}

	private void OreGenNether(Random random, int x, int z, World world) {
		// TODO Auto-generated method stub
		
	}

	     /**
	     * @param block The block you want to spawn
	     * @param world The world
	     * @param random The Random
	     * @param blockXPos the blockXpos of a chunk
	     * @param blockZPos the blockZpos of a chunk
	     * @param minVeinSize min vein
	     * @param maxVeinSize max vein
	     * @param chancesToSpawn the chance to spawn. Usually around 2
	     * @param minY lowest point to spawn
	     * @param maxY highest point to spawn
	     */
	 
	    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
	    {
	        WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.stone);
	        for(int i = 0; i < chancesToSpawn; i++)
	        {
	            int posX = blockXPos + random.nextInt(16);
	            int posY = minY + random.nextInt(maxY - minY);
	            int posZ = blockZPos + random.nextInt(16);
	            minable.generate(world, random, posX, posY, posZ);
	            
	            //System.out.println("chance of ore spawned: " + "x: " + posX +  "y: " + posY +  "z: " + posZ);
	        }
	    }
	
}
