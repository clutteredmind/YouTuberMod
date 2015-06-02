package com.clutteredmind.amberthepeng.entities.turtle;

import com.clutteredmind.amberthepeng.init.YouTuberModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTurtle extends EntityAnimal
{
    public EntityTurtle(World worldIn)
    {
        super(worldIn);
        this.setSize(1.0f, 1.0f);
        this.tasks.addTask(0, new TurtleAISwimming(this));
        this.tasks.addTask(1, new TurtleAIWander(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0d));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25d, Items.fish, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        
        ((PathNavigateGround)this.getNavigator()).func_179693_d(true);
        this.moveHelper = new EntityTurtle.TurtleMoveHelper();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0d);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1d);
    }
    
    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
    	return itemStack == null ? false : itemStack.getItem() == Items.fish;
    }
    
    public boolean canBreathUnderwater()
    {
    	return true;
    }
    
    public boolean isPushedByWater()
    {
    	return false;
    }
    
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	
    	if(this.isInWater())
    	{
    		this.setAir(300);
    		this.limbSwingAmount = 0;
    		this.limbSwing = 0;
    		this.prevLimbSwingAmount = this.limbSwingAmount;
    	}
    }

    // the sound this mob makes while it's alive.
    @Override
    protected String getLivingSound()
    {
        return "mob.rabbit.idle";
    }

    // the sound this mob makes when it is hurt.
    @Override
    protected String getHurtSound()
    {
        return "mob.rabbit.hurt";
    }

    // the sound this mob makes on death.
    @Override
    protected String getDeathSound()
    {
        return "mob.rabbit.death";
    }

    // the sound this mob makes when it walks
    protected void playStepSound(BlockPos p_180429_1_, Block p_180429_2_)
    {
    	// TODO: should a turtle really sound like a cow? 
        this.playSound("mob.cow.step", 0.15f, 1.0f);
    }

    // the volume for the sounds this mob makes.
    @Override
    protected float getSoundVolume()
    {
        return 0.4f;
    }

    // this is what the turtle drops when it is killed :(
    protected Item getDropItem()
    {
        return YouTuberModItems.rawTurtleMeat;
    }

    // Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
    @Override
    public boolean interact(EntityPlayer player)
    {
        return super.interact(player);
    }

    public EntityTurtle createChild(EntityAgeable ageable)
    {
        return new EntityTurtle(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.height;
    }
    
    @Override
    public boolean getCanSpawnHere()
    {
    	return super.getCanSpawnHere();
    }
    
    @Override
    public void moveEntityWithHeading(float x, float z)
    {
    	if(this.isInWater())
    	{
    		this.moveFlying(x, z, 0.1f);
    		this.moveEntity(this.motionX, this.motionY, this.motionZ);
    		this.motionX *= 0.8d;
    		this.motionY *= 0.8d;
    		this.motionZ *= 0.8d;
    	}
    	else
    	{
    		super.moveEntityWithHeading(x, z);
    	}
    }
    
    public class TurtleMoveHelper extends EntityMoveHelper
    {
    	private EntityTurtle entity = EntityTurtle.this;
    	private int randCounter;

    	public TurtleMoveHelper()
    	{
			super(EntityTurtle.this);
		}
    	
    	public void onUpdateMoveHelper()
    	{
    		if(entity.isInWater())
    		{
    			if(this.update)
    			{
    				if(this.randCounter-- <= 0)
    				{
    					this.randCounter += this.entity.getRNG().nextInt(5) + 10;
    					
    					double dirX = this.posX - this.entity.posX;
    					double dirY = this.posY - this.entity.posY;
    					double dirZ = this.posZ - this.entity.posZ;
    					
    					double destDistance = dirX * dirX + dirY * dirY + dirZ * dirZ;
    					
    					destDistance = (double)MathHelper.sqrt_double(destDistance);
    					
    					if(!this.checkCollision(this.posX, this.posY, this.posZ, destDistance))
    					{
    						this.entity.motionX += dirX / destDistance * 0.1d;
    						this.entity.motionY += dirY / destDistance * 0.1d;
    						this.entity.motionZ += dirZ / destDistance * 0.1d;
    					}
    					else
    					{
    						this.update = false;
    						double aboveBlockLocY = MathHelper.floor_double(this.posY) + 1;
    						Block blockAboveSelf = worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.entity.posX), MathHelper.floor_double(aboveBlockLocY), MathHelper.floor_double(this.entity.posZ))).getBlock();
    						Block destBlock = this.entity.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.entity.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))).getBlock();
    						
    						double yDiff = MathHelper.floor_double(this.posY) - MathHelper.floor_double(this.entity.posY);
    						
    						if(yDiff == 1.0F & blockAboveSelf == Blocks.air && destBlock != Blocks.water && destDistance <= 3)
    						{
    							this.entity.motionX = dirX / destDistance * 0.3d;
    							this.entity.motionY = 0.4d;
    							this.entity.motionZ = dirZ / destDistance * 0.3d;
    							this.entity.getJumpHelper().setJumping();
    						}
    					}
    					this.UpdateYaw(motionX, motionZ);
    				}
    			}
    		}
    		else
    		{
    			super.onUpdateMoveHelper();
    		}
    	}
    	
    	public void UpdateYaw(double dirX, double dirZ)
    	{
    		renderYawOffset = rotationYaw = -((float)Math.atan2(dirX, dirZ)) * 180 / (float)Math.PI;
    	}
    	
    	private boolean checkCollision(double posX, double posY, double posZ, double distance)
    	{
    		double dirX = (posX = this.entity.posX) / distance;
    		double dirY = (posY = this.entity.posY) / distance;
    		double dirZ = (posZ = this.entity.posZ) / distance;
    		AxisAlignedBB collisionBox = this.entity.getEntityBoundingBox();
    		
    		for(int i = 1; (double)i < distance; ++i)
    		{
    			collisionBox = collisionBox.offset(dirX, dirY, dirZ);
    			
    			if(!this.entity.worldObj.getCollidingBoundingBoxes(this.entity, collisionBox).isEmpty())
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	public double getPosX()
    	{
    		return this.posX;
    	}
    	
    	public double getPosY()
    	{
    		return this.posY;
    	}
    	
    	public double getPosZ()
    	{
    		return this.posZ;
    	}
    }
}
