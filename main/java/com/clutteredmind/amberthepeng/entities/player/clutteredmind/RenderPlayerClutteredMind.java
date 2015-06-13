package com.clutteredmind.amberthepeng.entities.player.clutteredmind;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.clutteredmind.amberthepeng.entities.player.RenderPlayer;

public class RenderPlayerClutteredMind extends RenderPlayer
{
   private static final ResourceLocation youTuberTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/clutteredmindskin.png");

   public RenderPlayerClutteredMind (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return youTuberTexture;
   }
}
