package com.clutteredmind.amberthepeng.entities.player;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public abstract class EntityPlayer extends EntityMob
{
   public EntityPlayer (World worldIn)
   {
      super (worldIn);
   }
   
   // we don't want players to despawn, ever
   @Override
   protected boolean canDespawn()
   {
      return false;
   }
}
