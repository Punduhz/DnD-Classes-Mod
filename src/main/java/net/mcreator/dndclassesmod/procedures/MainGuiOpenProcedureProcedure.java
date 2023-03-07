package net.mcreator.dndclassesmod.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.dndclassesmod.world.inventory.WarriorGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.ShamanGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.NinjaGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.NecromancerGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.HelleonGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.GuardianGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.DruidGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.ClericGuiMenu;
import net.mcreator.dndclassesmod.world.inventory.AssassinGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.ArcherGuiMainMenu;
import net.mcreator.dndclassesmod.network.DndClassesModModVariables;

import io.netty.buffer.Unpooled;

public class MainGuiOpenProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 1) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ClericGui");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ClericGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 2) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ShamanGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ShamanGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 3) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("NinjaGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new NinjaGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 4) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("WarriorGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WarriorGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 5) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("HelleonGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new HelleonGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 6) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("AssassinGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new AssassinGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 7) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("GuardianGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new GuardianGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 8) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ArcherGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ArcherGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 9) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("NecromancerGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new NecromancerGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 10) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("DruidGuiMain");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new DruidGuiMainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
