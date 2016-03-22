package org.bitbucket.alltra101ify.advancedsatelliteutilization.asuworldgen;

import org.bitbucket.alltra101ify.advancedsatelliteutilization.asuworldgen.oregen.ASUWorldOreGen;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {
	
	public static void preInitGen() {
		GameRegistry.registerWorldGenerator(new ASUWorldOreGen(), 1);
	}
	
}
