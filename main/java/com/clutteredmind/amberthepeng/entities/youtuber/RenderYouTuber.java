package com.clutteredmind.amberthepeng.entities.youtuber;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderYouTuber extends RenderLiving
{
   public RenderYouTuber (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return null;
   }
}
