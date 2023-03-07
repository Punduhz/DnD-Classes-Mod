
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.dndclassesmod.client.gui.WarriorGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.ShamanGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.NinjaGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.NecromancerGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.HelleonGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.GuardianGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.DruidGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.ClericGuiScreen;
import net.mcreator.dndclassesmod.client.gui.ChooseClassGuiScreen;
import net.mcreator.dndclassesmod.client.gui.ChakraReleaseSelectionScreen;
import net.mcreator.dndclassesmod.client.gui.AssassinGuiMainScreen;
import net.mcreator.dndclassesmod.client.gui.ArcherGuiMainScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndClassesModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DndClassesModModMenus.CHOOSE_CLASS_GUI.get(), ChooseClassGuiScreen::new);
			MenuScreens.register(DndClassesModModMenus.CLERIC_GUI.get(), ClericGuiScreen::new);
			MenuScreens.register(DndClassesModModMenus.CHAKRA_RELEASE_SELECTION.get(), ChakraReleaseSelectionScreen::new);
			MenuScreens.register(DndClassesModModMenus.SHAMAN_GUI_MAIN.get(), ShamanGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.HELLEON_GUI_MAIN.get(), HelleonGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.GUARDIAN_GUI_MAIN.get(), GuardianGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.WARRIOR_GUI_MAIN.get(), WarriorGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.NECROMANCER_GUI_MAIN.get(), NecromancerGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.DRUID_GUI_MAIN.get(), DruidGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.NINJA_GUI_MAIN.get(), NinjaGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.ARCHER_GUI_MAIN.get(), ArcherGuiMainScreen::new);
			MenuScreens.register(DndClassesModModMenus.ASSASSIN_GUI_MAIN.get(), AssassinGuiMainScreen::new);
		});
	}
}
