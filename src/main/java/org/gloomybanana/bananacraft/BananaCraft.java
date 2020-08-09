package org.gloomybanana.bananacraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gloomybanana.bananacraft.handler.Registry;

@Mod("bananacraft")
public class BananaCraft
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "bananacraft";

    public BananaCraft() {
        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
