package org.gloomybanana.bananacraft.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.*;

public class MinionsEntity extends AnimalEntity {
    public MinionsEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.goalSelector.addGoal(0, new MinionsGoal(this));
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

}
