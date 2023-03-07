package net.mcreator.dndclassesmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;

public class VSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "v";
			entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Ninja_HandSign_1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
