package com.clutteredmind.amberthepeng.worldgenerator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.clutteredmind.amberthepeng.init.YouTuberModBlocks;

public class WorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimensionId())
		{
			case -1:
				GenerateNether(world, chunkX * 16, chunkZ * 16, random);
				break;
			case 0:
				GenerateOverworld(world, chunkX * 16, chunkZ * 16, random);
				break;
			case 1:
				GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
				break;
		}
	}
	
	private void GenerateEnd(World world, int i, int j, Random random) {}

	private void GenerateOverworld(World world, int i, int j, Random random)
	{
		addOre(YouTuberModBlocks.youTuberOreBlock, Blocks.stone, random, world, i, j, 5, 12, 4, 8, 40);
	}

	private void GenerateNether(World world, int i, int j, Random random) {}
	
	// calculates whether or not ore should be added to the chunk
	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int spawnChance)
	{
		for(int i = 0; i < spawnChance; i++)
		{
			int defaultChunkSize = 16;
			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);
			
			IBlockState state = block.getDefaultState();
			BlockPos blockPos = new BlockPos(xPos, yPos, zPos);
			
			new WorldGenMinable(state, maxVeinSize).generate(world, random, blockPos);
		}
	}
}
