package com.example.examplemod.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static BasicItem Banana;
	
	public static void createItems() {
		GameRegistry.registerItem(Banana = new BasicItem("banana"),"banana");
	}

}
