package net.mcreator.dndclassesmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerManaSetProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Identifier == 0) {
			if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Class_Checker == 0) {
				{
					double _setval = 200;
					entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Player_Max_Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 200;
					entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Player_Available_Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
