package com.clutteredmind.amberthepeng.entities.youtuber;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

public abstract class RenderYouTuber extends RenderLiving
{
   public RenderYouTuber (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }
}
