
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.dndclassesmod.DndClassesModMod;

public class DndClassesModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DndClassesModMod.MODID);
	public static final RegistryObject<Item> TOTEM_SPAWN_EGG = REGISTRY.register("totem_spawn_egg", () -> new ForgeSpawnEggItem(DndClassesModModEntities.TOTEM, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
