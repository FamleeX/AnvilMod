package net.anvilmod.mod.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.anvilmod.mod.AnvilMod;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class AnvilModWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			//Generate our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1:
			//Generate our surface world
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1:
			//Generate our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);
		}
		
	}
	
	public void generateSurface(World world, Random random, int x, int z) {
		//this.addOreSpawn(AnvilMod.oreWhatever, world, random, i=blockXPos, j=blockZPos, maxX, maxZ, maxVeinSize, chanceToSpawn, minY, maxY);
		this.addOreSpawn(AnvilMod.oreCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(AnvilMod.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
	}

	public void generateNether(World world, Random random, int x, int z) {
		
	}

	public void generateEnd(World world, Random random, int x, int z) {
		
	}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	
}
