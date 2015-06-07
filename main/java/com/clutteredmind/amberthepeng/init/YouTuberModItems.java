package com.clutteredmind.amberthepeng.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.clutteredmind.amberthepeng.foods.TurtleStew;
import com.clutteredmind.amberthepeng.housekeeping.Reference;

public class YouTuberModItems
{
   public static Item youTubeLogoFragment;
   public static Item rawTurtleMeat;
   public static Item cookedTurtleMeat;
   public static Item turtleStew;

   public static void init ()
   {
      // YouTube Logo Fragment
      youTubeLogoFragment = new Item ().setUnlocalizedName ("youtubelogofragment");
      youTubeLogoFragment.setCreativeTab (CreativeTabs.tabMaterials);

      // Raw Turtle Meat
      rawTurtleMeat = new Item ().setUnlocalizedName ("rawturtlemeat");
      rawTurtleMeat.setCreativeTab (CreativeTabs.tabFood);

      // Cooked Turtle Meat
      cookedTurtleMeat = new Item ().setUnlocalizedName ("cookedturtlemeat");
      cookedTurtleMeat.setCreativeTab (CreativeTabs.tabFood);

      // Turtle Stew
      turtleStew = new TurtleStew ("turtlestew");
   }

   public static void register ()
   {
      GameRegistry.registerItem (youTubeLogoFragment, youTubeLogoFragment.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (rawTurtleMeat, rawTurtleMeat.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (cookedTurtleMeat, cookedTurtleMeat.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (turtleStew, turtleStew.getUnlocalizedName ().substring (5));
   }

   public static void registerRenders ()
   {
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  youTubeLogoFragment,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":"
                        + youTubeLogoFragment.getUnlocalizedName ().substring (5), "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  rawTurtleMeat,
                  0,
                  new ModelResourceLocation (
                        Reference.MOD_ID + ":" + rawTurtleMeat.getUnlocalizedName ().substring (5), "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  cookedTurtleMeat,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":"
                        + cookedTurtleMeat.getUnlocalizedName ().substring (5), "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  turtleStew,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":" + turtleStew.getUnlocalizedName ().substring (5),
                        "inventory"));
   }
}
