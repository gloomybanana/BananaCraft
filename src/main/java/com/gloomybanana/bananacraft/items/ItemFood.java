package com.gloomybanana.bananacraft.items;

import com.gloomybanana.bananacraft.Main;
import com.gloomybanana.bananacraft.init.ModItems;
import com.gloomybanana.bananacraft.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;

public class ItemFood extends net.minecraft.item.ItemFood implements IHasModel {

    private PotionEffect[] potionEffects;
    public ItemFood(String name,int amount, float saturation, boolean isWolfFood,PotionEffect[] potionEffects) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);
        this.potionEffects = potionEffects;

        ModItems.ITEMS.add(this);
    }
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        super.onFoodEaten(stack,worldIn,player);
        if(!worldIn.isRemote){
            for (PotionEffect effect:potionEffects
                 ) {
                player.addPotionEffect(effect);
            }
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
