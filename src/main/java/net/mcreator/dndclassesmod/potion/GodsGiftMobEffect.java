
package net.mcreator.dndclassesmod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class GodsGiftMobEffect extends MobEffect {
	public GodsGiftMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3098532);
	}

	@Override
	public String getDescriptionId() {
		return "effect.dnd_classes_mod.gods_gift";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
