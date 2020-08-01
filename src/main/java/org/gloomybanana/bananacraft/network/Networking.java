package org.gloomybanana.bananacraft.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.gloomybanana.bananacraft.BananaCraft;

public class Networking {
    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(BananaCraft.MOD_ID + ":first_networking"),
                () -> {
                    return "1.0";
                },
                (s) -> {
                    return true;
                },
                (s) -> {
                    return true;
                });
        INSTANCE.registerMessage(
                nextID(),
                HarvestPacket.class,
                HarvestPacket::write,
                HarvestPacket::new,
                HarvestPacket::handle
        );
    }
}