
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.dndclassesmod.world.inventory.AsdMenu;
import net.mcreator.dndclassesmod.DndClassesModMod;

public class DndClassesModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DndClassesModMod.MODID);
	public static final RegistryObject<MenuType<AsdMenu>> ASD = REGISTRY.register("asd", () -> IForgeMenuType.create(AsdMenu::new));
}
