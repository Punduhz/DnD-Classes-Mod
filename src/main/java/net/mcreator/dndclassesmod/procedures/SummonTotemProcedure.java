package net.mcreator.dndclassesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SummonTotemProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if () {if (world instanceof ServerLevel _level) {
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
_player.displayClientMessage(Component.literal("Poof"), (false));}
}
}
