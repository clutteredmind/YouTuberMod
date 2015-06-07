package com.clutteredmind.amberthepeng.entities.turtle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTurtle extends RenderLiving
{
   private static final ResourceLocation turtleTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/turtle.png");

   public RenderTurtle (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return turtleTexture;
   }
}
