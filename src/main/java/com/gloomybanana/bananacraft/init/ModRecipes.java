package com.gloomybanana.bananacraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(ModItems.BANANA,new ItemStack(ModItems.TOASTED_BANANA,1),1.5f);
    }
}
