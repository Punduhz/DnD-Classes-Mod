package net.mcreator.dndclassesmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;

public class TotemUnlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Shaman_Can_Use_Totem = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
