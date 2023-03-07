package net.mcreator.dndclassesmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;

public class CSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "c";
			entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Ninja_HandSign_2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
