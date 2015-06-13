package com.clutteredmind.amberthepeng.entities.player;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

public abstract class RenderPlayer extends RenderLiving
{
   public RenderPlayer (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }
}
