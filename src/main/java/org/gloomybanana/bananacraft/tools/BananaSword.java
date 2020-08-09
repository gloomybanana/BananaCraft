package org.gloomybanana.bananacraft.tools;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;


public class BananaSword extends SwordItem {
    private static final IItemTier itemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 256;
        }

        @Override
        public float getEfficiency() {
            return 10.0F;
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

    public BananaSword() {
        super(itemTier,3,-2.0F,new Item.Properties().group(ItemGroup.COMBAT));
    }
}
