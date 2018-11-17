package com.gloomybanana.bananacraft.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BoxBlock extends BlockBase {
    public BoxBlock(String name, Material materia) {

        super(name, materia);

        setSoundType(SoundType.WOOD);
        setHardness(1.0F);
        setResistance(2.5F);
        setHarvestLevel("spade",0);

    }
}
