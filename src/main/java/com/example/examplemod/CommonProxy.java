package com.example.examplemod;

import com.example.examplemod.item.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
	}
	public void init(FMLInitializationEvent e) {
		
	}
	public void PostInit(FMLPostInitializationEvent e) {
		
	}

}
