
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.dndclassesmod.potion.GodsGiftMobEffect;
import net.mcreator.dndclassesmod.DndClassesModMod;

public class DndClassesModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DndClassesModMod.MODID);
	public static final RegistryObject<MobEffect> GODS_GIFT = REGISTRY.register("gods_gift", () -> new GodsGiftMobEffect());
}
