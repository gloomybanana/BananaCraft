package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
	@SidedProxy(clientSide="com.example.examplemod.ClientProxy",serverSide="com.example.examplemod.ServerProxy")
	public static CommonProxy proxy;
	
    public static final String MODID = "bananacraft";
    public static final String VERSION = "1.0";
    
// 建立数据结构；增加合成表...    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
// 初始化事件处理器
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	// some example code
    	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
// 与其他mod交互，基于其他mod调整设置
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	// some example code
    	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
