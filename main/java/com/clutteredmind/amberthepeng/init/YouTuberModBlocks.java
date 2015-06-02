package com.clutteredmind.amberthepeng.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.clutteredmind.amberthepeng.blocks.YouTuberOre;
import com.clutteredmind.amberthepeng.housekeeping.Reference;

public class YouTuberModBlocks
{
	public static Block youTuberOreBlock;
	
	public static void init()
	{
		youTuberOreBlock = new YouTuberOre(Material.rock).setUnlocalizedName("youtuberore");
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(youTuberOreBlock, youTuberOreBlock.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		Item item = Item.getItemFromBlock(youTuberOreBlock);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
