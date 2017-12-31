package com.example.examplemod;

import com.example.examplemod.client.render.items.ItemRenderRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public class CommonProxy {
		
		public void preInit(FMLPreInitializationEvent e) {
			
		}
		public void init(FMLInitializationEvent e) {
			
			ItemRenderRegister.registerItemRenderer();
		}
		public void PostInit(FMLPostInitializationEvent e) {
			
		}
	}
}
