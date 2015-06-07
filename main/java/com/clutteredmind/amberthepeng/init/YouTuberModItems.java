package com.clutteredmind.amberthepeng.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.clutteredmind.amberthepeng.foods.TurtleStew;
import com.clutteredmind.amberthepeng.housekeeping.Reference;
import com.clutteredmind.amberthepeng.tools.ItemFrostmourne;
import com.clutteredmind.amberthepeng.tools.ItemHoleDigger;

public class YouTuberModItems
{
   public static Item youTubeLogoFragment;
   public static Item rawTurtleMeat;
   public static Item cookedTurtleMeat;
   public static Item lovelyJubblyLoveLovePetal;
   public static Item turtleStew;
   public static Item holeDigger;
   public static Item frostmourne;

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

      // AmyLee33's Lovely Jubbly Love-Love Petal
      lovelyJubblyLoveLovePetal = new Item ().setUnlocalizedName ("lovelyjubblylovelovepetal");
      lovelyJubblyLoveLovePetal.setCreativeTab (CreativeTabs.tabMaterials);

      // Turtle Stew
      turtleStew = new TurtleStew ("turtlestew");

      // SuperGirlyGamer's Hole Digger
      holeDigger = new ItemHoleDigger ().setUnlocalizedName ("holedigger");

      // Furious Destroyer's frostmourne
      frostmourne = new ItemFrostmourne ().setUnlocalizedName ("frostmourne");
   }

   public static void register ()
   {
      GameRegistry.registerItem (youTubeLogoFragment, youTubeLogoFragment.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (rawTurtleMeat, rawTurtleMeat.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (cookedTurtleMeat, cookedTurtleMeat.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (lovelyJubblyLoveLovePetal,
            lovelyJubblyLoveLovePetal.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (turtleStew, turtleStew.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (holeDigger, holeDigger.getUnlocalizedName ().substring (5));
      GameRegistry.registerItem (frostmourne, frostmourne.getUnlocalizedName ().substring (5));
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
                  lovelyJubblyLoveLovePetal,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":"
                        + lovelyJubblyLoveLovePetal.getUnlocalizedName ().substring (5), "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  turtleStew,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":" + turtleStew.getUnlocalizedName ().substring (5),
                        "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  holeDigger,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":" + holeDigger.getUnlocalizedName ().substring (5),
                        "inventory"));
      Minecraft
            .getMinecraft ()
            .getRenderItem ()
            .getItemModelMesher ()
            .register (
                  frostmourne,
                  0,
                  new ModelResourceLocation (Reference.MOD_ID + ":" + frostmourne.getUnlocalizedName ().substring (5),
                        "inventory"));
   }
}
