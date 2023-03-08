
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.dndclassesmod.world.inventory.WarriorGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.TotemGuiMenu;
import net.mcreator.dndclassesmod.world.inventory.ShamanGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.NinjaGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.NecromancerGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.HelleonGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.GuardianGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.DruidGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.ClericGuiMenu;
import net.mcreator.dndclassesmod.world.inventory.ChooseClassGuiMenu;
import net.mcreator.dndclassesmod.world.inventory.ChakraReleaseSelectionMenu;
import net.mcreator.dndclassesmod.world.inventory.AssassinGuiMainMenu;
import net.mcreator.dndclassesmod.world.inventory.ArcherGuiMainMenu;
import net.mcreator.dndclassesmod.DndClassesModMod;

public class DndClassesModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DndClassesModMod.MODID);
	public static final RegistryObject<MenuType<ChooseClassGuiMenu>> CHOOSE_CLASS_GUI = REGISTRY.register("choose_class_gui", () -> IForgeMenuType.create(ChooseClassGuiMenu::new));
	public static final RegistryObject<MenuType<ClericGuiMenu>> CLERIC_GUI = REGISTRY.register("cleric_gui", () -> IForgeMenuType.create(ClericGuiMenu::new));
	public static final RegistryObject<MenuType<ChakraReleaseSelectionMenu>> CHAKRA_RELEASE_SELECTION = REGISTRY.register("chakra_release_selection", () -> IForgeMenuType.create(ChakraReleaseSelectionMenu::new));
	public static final RegistryObject<MenuType<ShamanGuiMainMenu>> SHAMAN_GUI_MAIN = REGISTRY.register("shaman_gui_main", () -> IForgeMenuType.create(ShamanGuiMainMenu::new));
	public static final RegistryObject<MenuType<HelleonGuiMainMenu>> HELLEON_GUI_MAIN = REGISTRY.register("helleon_gui_main", () -> IForgeMenuType.create(HelleonGuiMainMenu::new));
	public static final RegistryObject<MenuType<GuardianGuiMainMenu>> GUARDIAN_GUI_MAIN = REGISTRY.register("guardian_gui_main", () -> IForgeMenuType.create(GuardianGuiMainMenu::new));
	public static final RegistryObject<MenuType<WarriorGuiMainMenu>> WARRIOR_GUI_MAIN = REGISTRY.register("warrior_gui_main", () -> IForgeMenuType.create(WarriorGuiMainMenu::new));
	public static final RegistryObject<MenuType<NecromancerGuiMainMenu>> NECROMANCER_GUI_MAIN = REGISTRY.register("necromancer_gui_main", () -> IForgeMenuType.create(NecromancerGuiMainMenu::new));
	public static final RegistryObject<MenuType<DruidGuiMainMenu>> DRUID_GUI_MAIN = REGISTRY.register("druid_gui_main", () -> IForgeMenuType.create(DruidGuiMainMenu::new));
	public static final RegistryObject<MenuType<NinjaGuiMainMenu>> NINJA_GUI_MAIN = REGISTRY.register("ninja_gui_main", () -> IForgeMenuType.create(NinjaGuiMainMenu::new));
	public static final RegistryObject<MenuType<ArcherGuiMainMenu>> ARCHER_GUI_MAIN = REGISTRY.register("archer_gui_main", () -> IForgeMenuType.create(ArcherGuiMainMenu::new));
	public static final RegistryObject<MenuType<AssassinGuiMainMenu>> ASSASSIN_GUI_MAIN = REGISTRY.register("assassin_gui_main", () -> IForgeMenuType.create(AssassinGuiMainMenu::new));
	public static final RegistryObject<MenuType<TotemGuiMenu>> TOTEM_GUI = REGISTRY.register("totem_gui", () -> IForgeMenuType.create(TotemGuiMenu::new));
}
