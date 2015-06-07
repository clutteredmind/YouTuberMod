package com.clutteredmind.amberthepeng.entities.youtuber;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public abstract class EntityYouTuber extends EntityMob
{
   public EntityYouTuber (World worldIn)
   {
      super (worldIn);
   }
   
   // we don't want YouTubers to despawn, ever
   @Override
   protected boolean canDespawn()
   {
      return false;
   }
}
