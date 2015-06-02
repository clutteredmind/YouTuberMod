package com.clutteredmind.amberthepeng.entities.turtle;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

import com.clutteredmind.amberthepeng.entities.turtle.EntityTurtle.TurtleMoveHelper;

public class TurtleAISwimming extends EntityAIBase
{
	private EntityTurtle entityTurtle;
	
	public TurtleAISwimming(EntityTurtle entity)
	{
		this.entityTurtle = entity;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute()
	{
		if(!this.entityTurtle.isInWater())
		{
			return false;
		}
		
		EntityTurtle.TurtleMoveHelper moveHelper = (TurtleMoveHelper)this.entityTurtle.getMoveHelper();
		
		if(!moveHelper.isUpdating())
		{
			if(this.entityTurtle.getRNG().nextInt(15) != 0)
			{
				return false;
			}
			return true;
		}
		else
		{
			double dirX = moveHelper.getPosX() - this.entityTurtle.posX;
			double dirY = moveHelper.getPosY() - this.entityTurtle.posY;
			double dirZ = moveHelper.getPosZ() - this.entityTurtle.posZ;
			
			double destDistance = MathHelper.sqrt_double(dirX * dirX + dirY * dirY + dirZ * dirZ);
			if(destDistance < 0.5D)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	@Override
	public boolean continueExecuting()
	{
		return false;
	}
	
	@Override
	public void startExecuting()
	{
		Random random = this.entityTurtle.getRNG();
		
		double randX = this.entityTurtle.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 3.0F);
		double randY = this.entityTurtle.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
		double randZ = this.entityTurtle.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 3.0F);
		
		BlockPos destBlockPos = new BlockPos(MathHelper.floor_double(randX), MathHelper.floor_double(randY), MathHelper.floor_double(randZ));
		Block destBlock = this.entityTurtle.worldObj.getBlockState(destBlockPos).getBlock();
		Block underDestBlock = this.entityTurtle.worldObj.getBlockState(destBlockPos.offset(EnumFacing.DOWN, 1)).getBlock();
		
		if(destBlock == Blocks.water || (destBlock == Blocks.air && underDestBlock != Blocks.water && underDestBlock != Blocks.air))
		{
			this.entityTurtle.getMoveHelper().setMoveTo(randX, randY, randZ, 1.0D);
		}
	}
}
