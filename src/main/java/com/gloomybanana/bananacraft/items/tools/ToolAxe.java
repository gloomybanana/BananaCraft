package com.gloomybanana.bananacraft.items.tools;

import com.gloomybanana.bananacraft.Main;
import com.gloomybanana.bananacraft.init.ModItems;
import com.gloomybanana.bananacraft.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ToolAxe extends ItemAxe implements IHasModel {
    public ToolAxe(String name,ToolMaterial material) {
        super(material,6.0F,3.2F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxDamage(150);
        ModItems.ITEMS.add(this);

    }
//    @SubscribeEvent
//    public void onDestroyCurrentItem(PlayerDestroyItemEvent event) {
//        if (event.getOriginal().isEmpty() || event.getOriginal().getItem() != this) {
//            return;
//        }
//
//        EntityPlayer player = event.getEntityPlayer();
//        World world = player.world;
//
//        if (!world.isRemote && !remnants.isEmpty()) {
//            ItemStackUtil.dropItemStackAsEntity(remnants.copy(), world, player.posX, player.posY, player.posZ);
//        }
//    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
