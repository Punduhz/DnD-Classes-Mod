
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.dndclassesmod.client.gui.ClericGuiScreen;
import net.mcreator.dndclassesmod.client.gui.ChooseClassGuiScreen;
import net.mcreator.dndclassesmod.client.gui.ChakraReleaseSelectionScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DndClassesModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DndClassesModModMenus.CHOOSE_CLASS_GUI.get(), ChooseClassGuiScreen::new);
			MenuScreens.register(DndClassesModModMenus.CLERIC_GUI.get(), ClericGuiScreen::new);
			MenuScreens.register(DndClassesModModMenus.CHAKRA_RELEASE_SELECTION.get(), ChakraReleaseSelectionScreen::new);
		});
	}
}
