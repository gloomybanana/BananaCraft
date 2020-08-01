package org.gloomybanana.bananacraft.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.Ingredient;

public class BananaShovel extends ShovelItem {
    private static final IItemTier itemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 256;
        }

        @Override
        public float getEfficiency() {
            return 20.0F;
        }

        @Override
        public float getAttackDamage() {
            return 5.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }
    };


    public BananaShovel() {
        super(itemTier,1,2,new Item.Properties().group(ItemGroup.TOOLS));
    }
}
