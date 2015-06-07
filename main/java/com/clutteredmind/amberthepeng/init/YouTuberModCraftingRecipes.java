package com.clutteredmind.amberthepeng.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YouTuberModCraftingRecipes
{
   public static void registerCraftingRecipes ()
   {
      GameRegistry.addRecipe (new ItemStack (YouTuberModItems.turtleStew), " T ", "CPM", " W ", 'T',
            YouTuberModItems.cookedTurtleMeat, 'C', Items.carrot, 'P', Items.potato, 'M', Blocks.brown_mushroom, 'W',
            Items.water_bucket);
   }

   public static void registerSmeltingRecipes ()
   {
      GameRegistry
            .addSmelting (YouTuberModItems.rawTurtleMeat, new ItemStack (YouTuberModItems.cookedTurtleMeat), 0.1f);
   }
}
