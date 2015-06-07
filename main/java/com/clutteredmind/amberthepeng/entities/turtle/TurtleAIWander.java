package com.clutteredmind.amberthepeng.entities.turtle;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;

public class TurtleAIWander extends EntityAIBase
{
   private EntityTurtle entityTurtle;
   private double xPosition;
   private double yPosition;
   private double zPosition;
   private boolean proceed;

   public TurtleAIWander (EntityTurtle entity)
   {
      this.entityTurtle = entity;
      this.setMutexBits (1);
   }

   @Override
   public boolean shouldExecute ()
   {
      if (!this.entityTurtle.onGround || this.entityTurtle.isInWater ())
      {
         return false;
      }

      if (!this.proceed)
      {
         if (this.entityTurtle.getRNG ().nextInt (15) != 0)
         {
            return false;
         }
      }

      Random random = this.entityTurtle.getRNG ();

      double randX = this.entityTurtle.posX + (double) ( (random.nextFloat () * 2.0F - 1.0F) * 8.0F);
      double randY = this.entityTurtle.posY + (double) ( (random.nextFloat () * 2.0F - 1.0F) * 5.0F);
      double randZ = this.entityTurtle.posZ + (double) ( (random.nextFloat () * 2.0F - 1.0F) * 8.0F);

      this.xPosition = randX;
      this.yPosition = randY;
      this.zPosition = randZ;
      this.proceed = false;
      return true;
   }

   @Override
   public boolean continueExecuting ()
   {
      return false;
   }

   @Override
   public void startExecuting ()
   {
      this.entityTurtle.getNavigator ().tryMoveToXYZ (this.xPosition, this.yPosition, this.zPosition, 1.0D);
   }

   public void func_179480_f ()
   {
      this.proceed = true;
   }
}
