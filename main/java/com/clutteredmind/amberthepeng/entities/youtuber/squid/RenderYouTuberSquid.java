package com.clutteredmind.amberthepeng.entities.youtuber.squid;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;
import com.clutteredmind.amberthepeng.entities.youtuber.RenderYouTuber;

public class RenderYouTuberSquid extends RenderYouTuber
{
   private static final ResourceLocation youTuberTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/iballisticsquidskin.png");

   public RenderYouTuberSquid (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   protected ResourceLocation func_180572_a (EntityTurtle entity)
   {
      return youTuberTexture;
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return youTuberTexture;
   }
}
