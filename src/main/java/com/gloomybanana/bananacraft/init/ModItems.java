package com.gloomybanana.bananacraft.init;

import com.gloomybanana.bananacraft.items.Item512StackSize;
import com.gloomybanana.bananacraft.items.ItemBase;
import com.gloomybanana.bananacraft.items.ItemFood;
import com.gloomybanana.bananacraft.items.tools.*;
import com.gloomybanana.bananacraft.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    //items
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item BANANA = new Item512StackSize("banana");
    public static final Item PEELED_BANANA = new ItemFood("peeled_banana",3,3,false,new PotionEffect[]{new PotionEffect(Potion.getPotionFromResourceLocation("speed"),400,2),new PotionEffect(Potion.getPotionFromResourceLocation("haste"),400,2)});
    public static final Item TOASTED_BANANA = new ItemBase("toasted_banana");
    public static final Item BANANA_STICK = new ItemBase("banana_stick");

    //materias
    public static final Item.ToolMaterial MATERIAL_BANANA = EnumHelper.addToolMaterial("material_banana",3,125,8.0F,3.0F,10);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_BANANA = EnumHelper.addArmorMaterial("armor_material_banana", Reference.MOD_ID+":banana",6,new int[]{2,5,3,2},10, SoundEvents.BLOCK_SLIME_STEP,0.0F);

    //tools
    public static final ItemPickaxe BANANA_PICKAXE = new ToolPickaxe("banana_pickaxe",MATERIAL_BANANA);
    public static final ItemSword BANANA_SWORD = new ToolSword("banana_sword",MATERIAL_BANANA);
    public static final ItemSpade BANANA_SPADE = new ToolSpade("banana_spade",MATERIAL_BANANA);
    public static final ItemAxe BANANA_AXE = new ToolAxe("banana_axe", MATERIAL_BANANA);
    public static final ItemHoe BANANA_HOE = new ToolHoe("banana_hoe",MATERIAL_BANANA);

    //armors
    public static final Item BANANA_BOOTS = new BananaBoots("banana_boots",ARMOR_MATERIAL_BANANA,1, EntityEquipmentSlot.FEET);
}
