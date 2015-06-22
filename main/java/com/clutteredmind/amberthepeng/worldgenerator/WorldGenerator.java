package com.clutteredmind.amberthepeng.worldgenerator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.clutteredmind.amberthepeng.init.YouTuberModBlocks;

public class WorldGenerator implements IWorldGenerator
{
   @Override
   public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
         IChunkProvider chunkProvider)
   {
      switch (world.provider.getDimensionId ())
      {
         case -1:
            GenerateNether (world, chunkX * 16, chunkZ * 16, random);
            break;
         case 0:
            GenerateOverworld (world, chunkX * 16, chunkZ * 16, random);
            break;
         case 1:
            GenerateEnd (world, chunkX * 16, chunkZ * 16, random);
            break;
      }
   }

   private void GenerateEnd (World world, int i, int j, Random random)
   {
   }

   private void GenerateOverworld (World world, int blockX, int blockZ, Random random)
   {
      // add in YouTuber ore
      addOre (YouTuberModBlocks.youTuberOreBlock, Blocks.stone, random, world, blockX, blockZ, 5, 12, 2, 4, 3);

      // add YouTuber structure
      addYouTuberStructure (random, world, blockX, blockZ);
   }

   private void GenerateNether (World world, int i, int j, Random random)
   {
   }

   // calculates whether or not ore should be added to the chunk
   private void addOre (Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY,
         int maxY, int minVeinSize, int maxVeinSize, int spawnChance)
   {
      for (int i = 0; i < spawnChance; i++)
      {
         int defaultChunkSize = 16;
         int xPos = posX + random.nextInt (defaultChunkSize);
         int yPos = minY + random.nextInt (maxY - minY);
         int zPos = posZ + random.nextInt (defaultChunkSize);

         IBlockState state = block.getDefaultState ();
         BlockPos blockPos = new BlockPos (xPos, yPos, zPos);

         new WorldGenMinable (state, maxVeinSize).generate (world, random, blockPos);
      }
   }
   
   // calculates whether or not a new YouTuber structure should be generated
   private void addYouTuberStructure (Random random, World world, int blockX, int blockZ)
   {
      // get the current biome
      BiomeGenBase biome = world.getBiomeGenForCoords (new BlockPos (blockX, 0, blockZ));
      // add the structure if the biome is right and the random check passes
      // TODO: the structure is spawning too often, that needs to be fixed
      if (random.nextInt (192) == 0 && (biome.biomeName == "Plains" || biome.biomeName == "Savanna" || biome.biomeName == "Desert"
            || biome.biomeName == "Plains"))
      {
         // TODO: figure out how to make this into a structure that is actually useful
         int blockY = world.getTopSolidOrLiquidBlock (new BlockPos (blockX, 0, blockZ)).getY () - 1;
         world.setBlockState (new BlockPos (blockX, blockY, blockZ), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 1, blockY, blockZ), Blocks.wool.getDefaultState ().withProperty (BlockColored.COLOR, EnumDyeColor.BLACK));
         world.setBlockState (new BlockPos (blockX - 2, blockY, blockZ), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 1, blockY, blockZ), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 2, blockY, blockZ), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX, blockY, blockZ - 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX, blockY, blockZ - 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX, blockY, blockZ + 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX, blockY, blockZ + 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 1, blockY, blockZ - 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 1, blockY, blockZ - 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 1, blockY, blockZ + 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 1, blockY, blockZ + 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 2, blockY, blockZ - 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 2, blockY, blockZ - 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 2, blockY, blockZ + 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX - 2, blockY, blockZ + 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 1, blockY, blockZ - 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 1, blockY, blockZ - 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 1, blockY, blockZ + 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 1, blockY, blockZ + 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 2, blockY, blockZ - 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 2, blockY, blockZ - 2), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 2, blockY, blockZ + 1), Blocks.wool.getDefaultState ());
         world.setBlockState (new BlockPos (blockX + 2, blockY, blockZ + 2), Blocks.wool.getDefaultState ());
      }
   }
}
