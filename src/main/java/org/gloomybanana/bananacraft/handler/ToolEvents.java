package org.gloomybanana.bananacraft.handler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.ItemHandlerHelper;
import org.gloomybanana.bananacraft.network.HarvestPacket;
import org.gloomybanana.bananacraft.network.Networking;
import org.gloomybanana.bananacraft.tools.BananaAxe;
import org.gloomybanana.bananacraft.tools.BananaPickaxe;
import org.gloomybanana.bananacraft.tools.BananaShovel;
import org.gloomybanana.bananacraft.tools.BananaSword;

import java.util.List;
import java.util.stream.Collectors;

@EventBusSubscriber
public class ToolEvents {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void changeBlockDrops(BlockEvent.BreakEvent event) {
		if (event.isCanceled())
			return;
		PlayerEntity player = event.getPlayer();
		ItemStack held = player.getHeldItemMainhand();
		if (player.isCreative())
			return;
		if (!isBananaTool(held.getItem()))
			return;
		BlockState state = event.getState();

		IWorld world = event.getWorld();
		BlockPos pos = event.getPos();
		boolean onServer = !world.isRemote();

		if (!onServer) {
			return;
		}

		World actualWorld = world.getWorld();
		if (!(actualWorld instanceof ServerWorld))
			return;

		List<ItemStack> drops = state.getDrops(new Builder((ServerWorld) actualWorld)
				.withRandom(actualWorld.getRandom()).withParameter(LootParameters.POSITION, pos)
				.withParameter(LootParameters.TOOL, held).withParameter(LootParameters.THIS_ENTITY, player)
				.withNullableParameter(LootParameters.BLOCK_ENTITY, world.getTileEntity(pos)));

		drops.clear();
		world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		drops.add(new ItemStack(Registry.banana.get()));
		for (ItemStack dropped : drops)
			Block.spawnAsEntity(actualWorld, pos, dropped);


		try {
			Networking.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> player),
					new HarvestPacket(state, held, pos, false));
			Networking.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
					new HarvestPacket(state, held, pos, true));
			event.setResult(Result.DENY);
		} catch (Exception ignored) {
		}
	}

	@SubscribeEvent
	public static void changeMobDrops(LivingDropsEvent event) {
		if (!(event.getSource() instanceof EntityDamageSource))
			return;

		EntityDamageSource source = (EntityDamageSource) event.getSource();
		Entity target = event.getEntity();
		Entity trueSource = source.getTrueSource();
		World world = target.getEntityWorld();

		if (trueSource != null && trueSource instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) trueSource;
			ItemStack heldItemMainhand = player.getHeldItemMainhand();
			Item item = heldItemMainhand.getItem();
			if (!isBananaTool(item))
				return;
			List<ItemStack> drops = event.getDrops().stream().map(entity -> {
				ItemStack stack = entity.getItem();
				entity.remove();
				return stack;
			}).collect(Collectors.toList());
			drops.clear();
			drops.add(new ItemStack(Registry.banana.get()));

			event.getDrops().clear();
			drops.stream().map(stack -> {
				ItemEntity entity = new ItemEntity(world, target.getPosX(), target.getPosY(), target.getPosZ(), stack);
				world.addEntity(entity);
				return entity;
			}).forEach(event.getDrops()::add);


		}
	}
	@SubscribeEvent
	public static void onUsingBanana(PlayerInteractEvent.RightClickItem event){
		PlayerEntity player = event.getPlayer();
		ItemStack item = player.getHeldItemMainhand();
		if (!(item.getItem().equals(Registry.banana.get())))
			return;
		item.setCount(item.getCount()-1);
		ItemHandlerHelper.giveItemToPlayer(player,new ItemStack(Registry.peeredBanana.get()));
	}

	public static boolean isBananaTool(Item item){
		if ((item instanceof BananaAxe)||(item instanceof BananaShovel)||(item instanceof BananaPickaxe)||(item instanceof BananaSword)){
			return true;
		}else return false;
	}
}
