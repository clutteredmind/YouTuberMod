package com.clutteredmind.amberthepeng;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.clutteredmind.amberthepeng.housekeeping.Reference;
import com.clutteredmind.amberthepeng.init.YouTuberModBlocks;
import com.clutteredmind.amberthepeng.init.YouTuberModCraftingRecipes;
import com.clutteredmind.amberthepeng.init.YouTuberModEntities;
import com.clutteredmind.amberthepeng.init.YouTuberModGenerator;
import com.clutteredmind.amberthepeng.init.YouTuberModItems;
import com.clutteredmind.amberthepeng.proxy.ClientProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class YouTuberMod
{
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS)
	public static ClientProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// world generator
		YouTuberModGenerator.register();
		
		// entities
		YouTuberModEntities.register();

		// blocks
		YouTuberModBlocks.init();
		YouTuberModBlocks.register();

		// items
		YouTuberModItems.init();
		YouTuberModItems.register();
		
		// crafting recipes
		YouTuberModCraftingRecipes.registerCraftingRecipes();
		YouTuberModCraftingRecipes.registerSmeltingRecipes();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
