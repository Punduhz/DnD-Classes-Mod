
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
import net.mcreator.dndclassesmod.network.ClericGuiOpenMessage;
import net.mcreator.dndclassesmod.network.CKeyMessage;
import net.mcreator.dndclassesmod.network.BKeyMessage;
import net.mcreator.dndclassesmod.DndClassesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class DndClassesModModKeyMappings {
	public static final KeyMapping DIVINE_BLESSING = new KeyMapping("key.dnd_classes_mod.divine_blessing", GLFW.GLFW_KEY_0, "key.categories.cleric");
	public static final KeyMapping CLERIC_GUI_OPEN = new KeyMapping("key.dnd_classes_mod.cleric_gui_open", GLFW.GLFW_KEY_X, "key.categories.cleric") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new ClericGuiOpenMessage(0, 0));
				ClericGuiOpenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
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

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DIVINE_BLESSING);
		event.register(CLERIC_GUI_OPEN);
		event.register(C_KEY);
		event.register(V_KEY);
		event.register(B_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				CLERIC_GUI_OPEN.consumeClick();
				C_KEY.consumeClick();
				V_KEY.consumeClick();
				B_KEY.consumeClick();
			}
		}
	}
}
