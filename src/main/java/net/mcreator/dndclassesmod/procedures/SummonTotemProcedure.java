package net.mcreator.dndclassesmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.dndclassesmod.network.DndClassesModModVariables;
import net.mcreator.dndclassesmod.init.DndClassesModModEntities;
import net.mcreator.dndclassesmod.entity.TotemEntity;

public class SummonTotemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(DndClassesModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DndClassesModModVariables.PlayerVariables())).Shaman_Can_Use_Totem) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TotemEntity(DndClassesModModEntities.TOTEM.get(), _level);
				entityToSpawn.moveTo(x, y, z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Poof"), (false));
		}
	}
}
