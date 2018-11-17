package com.gloomybanana.bananacraft.items;

import com.gloomybanana.bananacraft.Main;
import com.gloomybanana.bananacraft.init.ModItems;
import com.gloomybanana.bananacraft.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Item512StackSize extends Item implements IHasModel {
    public Item512StackSize(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(512);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
