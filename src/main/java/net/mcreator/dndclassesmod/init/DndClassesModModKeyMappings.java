
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.dndclassesmod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.dndclassesmod.network.ShamanAbility1Message;
import net.mcreator.dndclassesmod.network.MainGuiOpenMessage;
import net.mcreator.dndclassesmod.network.DivineBlessingMessage;
import net.mcreator.dndclassesmod.DndClassesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DndClassesModModKeyMappings {
	public static final KeyMapping DIVINE_BLESSING = new KeyMapping("key.dnd_classes_mod.divine_blessing", GLFW.GLFW_KEY_0, "key.categories.cleric") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new DivineBlessingMessage(0, 0));
				DivineBlessingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLERIC_GUI_OPEN = new KeyMapping("key.dnd_classes_mod.cleric_gui_open", GLFW.GLFW_KEY_X, "key.categories.cleric");
	public static final KeyMapping DRUID_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.druid_ability_1", GLFW.GLFW_KEY_0, "key.categories.druid");
	public static final KeyMapping SHAMAN_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.shaman_ability_1", GLFW.GLFW_KEY_C, "key.categories.shaman") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new ShamanAbility1Message(0, 0));
				ShamanAbility1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HELLEON_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.helleon_ability_1", GLFW.GLFW_KEY_0, "key.categories.helleon");
	public static final KeyMapping GUARDIAN_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.guardian_ability_1", GLFW.GLFW_KEY_0, "key.categories.guardian");
	public static final KeyMapping WARRIOR_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.warrior_ability_1", GLFW.GLFW_KEY_0, "key.categories.warrior");
	public static final KeyMapping NECROMANCERABILITY_1 = new KeyMapping("key.dnd_classes_mod.necromancerability_1", GLFW.GLFW_KEY_0, "key.categories.necro");
	public static final KeyMapping ARCHER_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.archer_ability_1", GLFW.GLFW_KEY_0, "key.categories.archer");
	public static final KeyMapping ASSASSINABILITY_1 = new KeyMapping("key.dnd_classes_mod.assassinability_1", GLFW.GLFW_KEY_0, "key.categories.assassin");
	public static final KeyMapping MAIN_GUI_OPEN = new KeyMapping("key.dnd_classes_mod.main_gui_open", GLFW.GLFW_KEY_X, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new MainGuiOpenMessage(0, 0));
				MainGuiOpenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DIVINE_BLESSING);
		event.register(CLERIC_GUI_OPEN);
		event.register(DRUID_ABILITY_1);
		event.register(SHAMAN_ABILITY_1);
		event.register(HELLEON_ABILITY_1);
		event.register(GUARDIAN_ABILITY_1);
		event.register(WARRIOR_ABILITY_1);
		event.register(NECROMANCERABILITY_1);
		event.register(ARCHER_ABILITY_1);
		event.register(ASSASSINABILITY_1);
		event.register(MAIN_GUI_OPEN);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DIVINE_BLESSING.consumeClick();
				SHAMAN_ABILITY_1.consumeClick();
				MAIN_GUI_OPEN.consumeClick();
			}
		}
	}
}
