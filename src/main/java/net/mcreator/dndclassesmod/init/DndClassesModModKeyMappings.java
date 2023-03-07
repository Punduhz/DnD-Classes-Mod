
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

import net.mcreator.dndclassesmod.network.VKeyMessage;
import net.mcreator.dndclassesmod.network.MainGuiOpenMessage;
import net.mcreator.dndclassesmod.network.DivineBlessingMessage;
import net.mcreator.dndclassesmod.network.CKeyMessage;
import net.mcreator.dndclassesmod.network.BKeyMessage;
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
	public static final KeyMapping C_KEY = new KeyMapping("key.dnd_classes_mod.c_key", GLFW.GLFW_KEY_C, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new CKeyMessage(0, 0));
				CKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping V_KEY = new KeyMapping("key.dnd_classes_mod.v_key", GLFW.GLFW_KEY_V, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new VKeyMessage(0, 0));
				VKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping B_KEY = new KeyMapping("key.dnd_classes_mod.b_key", GLFW.GLFW_KEY_B, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new BKeyMessage(0, 0));
				BKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping NINJAABILITY_1 = new KeyMapping("key.dnd_classes_mod.ninjaability_1", GLFW.GLFW_KEY_0, "key.categories.ninja");
	public static final KeyMapping DRUID_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.druid_ability_1", GLFW.GLFW_KEY_0, "key.categories.druid");
	public static final KeyMapping SHAMAN_ABILITY_1 = new KeyMapping("key.dnd_classes_mod.shaman_ability_1", GLFW.GLFW_KEY_0, "key.categories.shaman");
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
		event.register(C_KEY);
		event.register(V_KEY);
		event.register(B_KEY);
		event.register(NINJAABILITY_1);
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
				C_KEY.consumeClick();
				V_KEY.consumeClick();
				B_KEY.consumeClick();
				MAIN_GUI_OPEN.consumeClick();
			}
		}
	}
}
