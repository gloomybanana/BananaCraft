package com.gloomybanana.bananacraft.block;

import com.gloomybanana.bananacraft.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class TreeLeaf extends BlockBase {
    public TreeLeaf(String name, Material materia) {
        super(name, materia);
        setSoundType(SoundType.CLOTH);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setResistance(1.0F);
        setHarvestLevel("sword",0);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random,int fortune){
        return ModItems.BANANA;
    }

    @Override
    public int quantityDropped(Random random){
        return random.nextInt(2);
    }
}
