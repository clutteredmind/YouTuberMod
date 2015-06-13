package com.clutteredmind.amberthepeng.entities.player.iluvpiggys04;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.clutteredmind.amberthepeng.entities.player.RenderPlayer;

public class RenderPlayerILuvPiggys04 extends RenderPlayer
{
   private static final ResourceLocation youTuberTexture = new ResourceLocation (
         "mod_youtubermod:textures/entity/iluvpiggys04skin.png");

   public RenderPlayerILuvPiggys04 (RenderManager renderManager, ModelBase model, float shadowSize)
   {
      super (renderManager, model, shadowSize);
   }

   @Override
   protected ResourceLocation getEntityTexture (Entity entity)
   {
      return youTuberTexture;
   }
}
