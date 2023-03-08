package net.mcreator.dndclassesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class TotemKillProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("LifeTime", 100);
		entity.getPersistentData().putDouble("LifeTime", ((new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "tagName")) - 2));
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "tagName") == 0) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
