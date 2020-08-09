package org.gloomybanana.bananacraft.entities;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.gloomybanana.bananacraft.handler.Registry;

public class MinionsGoal extends RandomWalkingGoal {
    private MinionsEntity minionsEntity;

    public MinionsGoal(MinionsEntity minionsEntity) {
        super(minionsEntity,0.25);
        this.minionsEntity = minionsEntity;
    }

    @Override
    public boolean shouldExecute() {
        World world = this.minionsEntity.getEntityWorld();
        if (!world.isRemote) {
            BlockPos blockPos = this.minionsEntity.getPosition();
            PlayerEntity player = world.getClosestPlayer(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3, false);
            if (player != null) {
                ItemHandlerHelper.giveItemToPlayer(player,new ItemStack(Registry.banana.get()));
            }
        }
        return true;
    }
}
