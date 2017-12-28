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
    
// �������ݽṹ�����Ӻϳɱ�...    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
// ��ʼ���¼�������
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	// some example code
    	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
// ������mod��������������mod��������
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	// some example code
    	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
