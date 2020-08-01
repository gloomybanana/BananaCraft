package org.gloomybanana.bananacraft.network;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;
import org.gloomybanana.bananacraft.tools.BananaAxe;
import org.gloomybanana.bananacraft.tools.BananaPickaxe;
import org.gloomybanana.bananacraft.tools.BananaShovel;
import org.gloomybanana.bananacraft.tools.BananaSword;

import java.util.function.Supplier;

public class HarvestPacket {
    private BlockState state;
    private ItemStack stack;
    private BlockPos pos;
    private boolean self;

    public HarvestPacket(BlockState state, ItemStack stack, BlockPos pos, boolean self) {
        this.state = state;
        this.stack = stack;
        this.pos = pos;
        this.self = self;
    }

    public HarvestPacket(PacketBuffer buffer) {
        state = NBTUtil.readBlockState(buffer.readCompoundTag());
        stack = buffer.readItemStack();
        pos = buffer.readBlockPos();
        self = buffer.readBoolean();
    }

    public void write(PacketBuffer buffer) {
        buffer.writeCompoundTag(NBTUtil.writeBlockState(state));
        buffer.writeItemStack(stack);
        buffer.writeBlockPos(pos);
        buffer.writeBoolean(self);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> this.spawnParticles(self)));
        context.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    void spawnParticles(boolean self) {
        if (!(stack.getItem() instanceof BananaAxe)&&!(stack.getItem() instanceof BananaSword)&&!(stack.getItem() instanceof BananaPickaxe)&&!(stack.getItem() instanceof BananaShovel))
            return;
        ClientWorld world = Minecraft.getInstance().world;
        if (!self)
            world.playEvent(2001, pos, Block.getStateId(state));
//        ((AbstractToolItem) stack.getItem()).spawnParticles(world, pos, stack, state);
    }
}
