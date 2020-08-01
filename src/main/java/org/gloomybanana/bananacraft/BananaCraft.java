package org.gloomybanana.bananacraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("bananacraft")
public class BananaCraft
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "bananacraft";

    public BananaCraft() {
        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Registry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
