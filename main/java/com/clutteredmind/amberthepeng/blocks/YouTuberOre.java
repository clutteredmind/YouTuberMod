package com.clutteredmind.amberthepeng.blocks;

import java.util.Random;

import com.clutteredmind.amberthepeng.init.YouTuberModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;

public class YouTuberOre extends Block
{
	public YouTuberOre(Material materialIn)
	{
		super(materialIn);
		// set hardness level
		setHardness(25.0F);
		// add to creative tab
		setCreativeTab(CreativeTabs.tabBlock);
		// only diamond picks can harvest this block
		setHarvestLevel("pickaxe", 3);
	}

	// this ore should drop YouTube fragments
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return YouTuberModItems.youTubeLogoFragment;
	}
	
	// drop numbers are all copied from Redstone Ore
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }
	
	// drop numbers are all copied from Redstone Ore
	public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }
	
	// XP amounts also copied from Redstone Ore
	@Override
    public int getExpDrop(net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(world.getBlockState(pos), RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }
}
