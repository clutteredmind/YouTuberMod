package com.clutteredmind.amberthepeng.entities.player;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public abstract class EntityPlayer extends EntityMob
{
   public EntityPlayer (World worldIn)
   {
      super (worldIn);
      this.setSize (1.0f, 1.0f);
      this.tasks.addTask (0, new EntityAIWatchClosest (this, net.minecraft.entity.player.EntityPlayer.class, 6.0f));
      this.tasks.addTask (1, new EntityAILookIdle (this));
   }
   
   // we don't want players to despawn, ever
   @Override
   protected boolean canDespawn()
   {
      return false;
   }
}
