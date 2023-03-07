package net.mcreator.dndclassesmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;
import net.mcreator.dndclassesmod.DndClassesModMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerManaRegenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Player_Available_Mana < (entity
				.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Player_Max_Mana) {
			DndClassesModMod.queueServerWork(40, () -> {
				{
					double _setval = (entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Player_Available_Mana + 2;
					entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Player_Available_Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
