package org.gloomybanana.bananacraft.items;


import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PeeledBanana extends Item {
    private static EffectInstance effectInstance = new EffectInstance(Effects.HASTE, 10 * 20, 1);
    private static Food food = (new Food.Builder())
            .saturation(2)
            .hunger(2)
            .effect(effectInstance, 1)
            .build();

    public PeeledBanana() {
        super(new Properties().food(food).group(ItemGroup.FOOD));
    }
}
