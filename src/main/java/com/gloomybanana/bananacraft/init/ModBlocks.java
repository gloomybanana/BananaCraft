package com.gloomybanana.bananacraft.init;

import com.gloomybanana.bananacraft.block.BlockBase;
import com.gloomybanana.bananacraft.block.BoxBlock;
import com.gloomybanana.bananacraft.block.TreeLeaf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block box_of_bananas = new BoxBlock("box_of_bananas", Material.CLAY);
    public static final Block banana_tree_leaf = new TreeLeaf("banana_tree_leaf",Material.GRASS);
}
