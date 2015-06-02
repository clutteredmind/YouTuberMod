package com.clutteredmind.amberthepeng.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.clutteredmind.amberthepeng.worldgenerator.WorldGenerator;

public class YouTuberModGenerator
{
	public static void register()
	{
		GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
	}
}
