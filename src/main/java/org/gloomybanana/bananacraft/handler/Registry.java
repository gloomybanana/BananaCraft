package org.gloomybanana.bananacraft.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.gloomybanana.bananacraft.BananaCraft;
import org.gloomybanana.bananacraft.entities.MinionsEntity;
import org.gloomybanana.bananacraft.items.PeeledBanana;
import org.gloomybanana.bananacraft.tools.BananaAxe;
import org.gloomybanana.bananacraft.tools.BananaPickaxe;
import org.gloomybanana.bananacraft.tools.BananaShovel;
import org.gloomybanana.bananacraft.tools.BananaSword;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, BananaCraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS,BananaCraft.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, BananaCraft.MOD_ID);

    public static RegistryObject<Item> bananaSword = ITEMS.register("banana_sword", BananaSword::new);
    public static RegistryObject<Item> bananaAxe = ITEMS.register("banana_axe", BananaAxe::new);
    public static RegistryObject<Item> bananaPickaxe = ITEMS.register("banana_pickaxe", BananaPickaxe::new);
    public static RegistryObject<Item> bananaShovel = ITEMS.register("banana_shovel", BananaShovel::new);

    public static RegistryObject<Item> banana = ITEMS.register("banana",() -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static RegistryObject<Item> banana_stick = ITEMS.register("banana_stick",() -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static RegistryObject<Item> peeredBanana = ITEMS.register("peeled_banana", PeeledBanana::new);

    public static RegistryObject<Block> bananaBlock = BLOCKS.register("banana_block", () -> {
        return new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5));
    });
    public static RegistryObject<Item> bananaBlockItem = ITEMS.register("banana_block", () -> {
        return new BlockItem(Registry.bananaBlock.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    });

    public static RegistryObject<EntityType<MinionsEntity>> minions = ENTITY_TYPES.register("minions", () -> {
        return EntityType.Builder.create(MinionsEntity::new, EntityClassification.MISC).size(1, 2F).build("minions");
    });
}
