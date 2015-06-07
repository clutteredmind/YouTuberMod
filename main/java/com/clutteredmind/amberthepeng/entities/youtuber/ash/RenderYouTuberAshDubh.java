package com.clutteredmind.amberthepeng.entities.youtuber.ash;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;
import com.clutteredmind.amberthepeng.entities.youtuber.RenderYouTuber;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderYouTuberAshDubh extends RenderYouTuber
{
   private static final ResourceLocation youTuberTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/ashdubhskin.png");

   public RenderYouTuberAshDubh (RenderManager renderManager, ModelBase model, float shadowSize)
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
