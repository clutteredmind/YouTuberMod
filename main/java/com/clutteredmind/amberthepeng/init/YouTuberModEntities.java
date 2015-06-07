package com.clutteredmind.amberthepeng.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;
import com.clutteredmind.amberthepeng.entities.turtle.ModelTurtle;
import com.clutteredmind.amberthepeng.entities.turtle.RenderTurtle;
import com.clutteredmind.amberthepeng.entities.youtuber.amylee33.EntityYouTuberAmyLee33;
import com.clutteredmind.amberthepeng.entities.youtuber.amylee33.RenderYouTuberAmyLee33;
import com.clutteredmind.amberthepeng.entities.youtuber.ash.EntityYouTuberAshDubh;
import com.clutteredmind.amberthepeng.entities.youtuber.ash.RenderYouTuberAshDubh;
import com.clutteredmind.amberthepeng.entities.youtuber.dantdm.EntityYouTuberDanTdm;
import com.clutteredmind.amberthepeng.entities.youtuber.dantdm.RenderYouTuberDanTdm;
import com.clutteredmind.amberthepeng.entities.youtuber.furiousdestroyer.EntityYouTuberFuriousDestroyer;
import com.clutteredmind.amberthepeng.entities.youtuber.furiousdestroyer.RenderYouTuberFuriousDestroyer;
import com.clutteredmind.amberthepeng.entities.youtuber.squid.EntityYouTuberSquid;
import com.clutteredmind.amberthepeng.entities.youtuber.squid.RenderYouTuberSquid;
import com.clutteredmind.amberthepeng.entities.youtuber.stampy.EntityYouTuberStampy;
import com.clutteredmind.amberthepeng.entities.youtuber.stampy.RenderYouTuberStampy;
import com.clutteredmind.amberthepeng.entities.youtuber.stripe.EntityYouTuberStripe;
import com.clutteredmind.amberthepeng.entities.youtuber.stripe.RenderYouTuberStripe;
import com.clutteredmind.amberthepeng.entities.youtuber.supergirlygamer.EntityYouTuberSuperGirlyGamer;
import com.clutteredmind.amberthepeng.entities.youtuber.supergirlygamer.RenderYouTuberSuperGirlyGamer;
import com.clutteredmind.amberthepeng.housekeeping.Reference;

public class YouTuberModEntities
{
   public static void register ()
   {
      int entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityTurtle.class, "turtle", entityId, 0x33660, 0x00ff00);
      EntityRegistry.addSpawn (EntityTurtle.class, 40, 1, 5, EnumCreatureType.CREATURE, BiomeGenBase.beach);

      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberAshDubh.class, "ash", entityId, 0xf2d622, 0xe9f507);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberDanTdm.class, "dantdm", entityId, 0x404ad6,
            Reference.Colors.Black);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberFuriousDestroyer.class, "furiousdestroyer", entityId,
            0x666770, Reference.Colors.Black);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberSquid.class, "squid", entityId, 0x527cde, 0x0c3aa6);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberStampy.class, "stampy", entityId, 0xff8800,
            Reference.Colors.White);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberStripe.class, "stripe", entityId, Reference.Colors.Blue,
            Reference.Colors.White);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberSuperGirlyGamer.class, "supergirlygamer", entityId,
            0xff9cfc, 0xff00a6);
      entityId = EntityRegistry.findGlobalUniqueEntityId ();
      EntityRegistry.registerGlobalEntityID (EntityYouTuberAmyLee33.class, "amylee33", entityId, 0xff9cfc, 0x9c2271);
   }

   public static void registerRenders ()
   {
      RenderingRegistry.registerEntityRenderingHandler (EntityTurtle.class, new RenderTurtle (Minecraft.getMinecraft ()
            .getRenderManager (), new ModelTurtle (), 0.5F));
      // NOTE: the "false" passed to the ModelPlayer constructor forces the game
      // to use the Steve model as opposed to the Alex model
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberAshDubh.class, new RenderYouTuberAshDubh (
            Minecraft.getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberDanTdm.class, new RenderYouTuberDanTdm (Minecraft
            .getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberFuriousDestroyer.class,
            new RenderYouTuberFuriousDestroyer (Minecraft.getMinecraft ().getRenderManager (), new ModelPlayer (0.0f,
                  false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberSquid.class, new RenderYouTuberSquid (Minecraft
            .getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberStampy.class, new RenderYouTuberStampy (Minecraft
            .getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberStripe.class, new RenderYouTuberStripe (Minecraft
            .getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberSuperGirlyGamer.class,
            new RenderYouTuberSuperGirlyGamer (Minecraft.getMinecraft ().getRenderManager (), new ModelPlayer (0.0f,
                  false), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler (EntityYouTuberAmyLee33.class, new RenderYouTuberAmyLee33 (
            Minecraft.getMinecraft ().getRenderManager (), new ModelPlayer (0.0f, false), 0.5F));

   }
}
