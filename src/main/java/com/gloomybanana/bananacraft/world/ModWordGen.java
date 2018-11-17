package com.gloomybanana.bananacraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWordGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

    }

    private void generateOverworld(Random random,int chunkX,int chunkZ,World world,IChunkGenerator iChunkGenerator,IChunkProvider iChunkProvider){

    }

    private void generateTree(IBlockState block,World world,Random random,int x,int z,int minY,int maxY,int Size,int chance){
        int deltaY = maxY - minY;
        
    }
}
