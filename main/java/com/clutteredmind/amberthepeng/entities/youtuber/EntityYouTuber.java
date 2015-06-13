package com.clutteredmind.amberthepeng.entities.youtuber;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntityYouTuber extends EntityMob
{
   public EntityYouTuber (World worldIn)
   {
      super (worldIn);
      this.setSize (1.0f, 1.0f);
      this.tasks.addTask (0, new EntityAIWatchClosest (this, EntityPlayer.class, 6.0f));
      this.tasks.addTask (1, new EntityAILookIdle (this));
   }
   
   // we don't want YouTubers to despawn, ever
   @Override
   protected boolean canDespawn()
   {
      return false;
   }
}
