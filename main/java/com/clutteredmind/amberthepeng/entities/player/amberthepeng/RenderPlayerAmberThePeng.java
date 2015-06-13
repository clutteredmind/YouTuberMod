package com.clutteredmind.amberthepeng.entities.player.amberthepeng;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.clutteredmind.amberthepeng.entities.player.RenderPlayer;

public class RenderPlayerAmberThePeng extends RenderPlayer
{
   private static final ResourceLocation youTuberTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/amberthepengskin.png");

   public RenderPlayerAmberThePeng (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return youTuberTexture;
   }
}
