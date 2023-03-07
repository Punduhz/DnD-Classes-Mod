package net.mcreator.dndclassesmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.dndclassesmod.world.inventory.ChakraReleaseSelectionMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChakraReleaseSelectionScreen extends AbstractContainerScreen<ChakraReleaseSelectionMenu> {
	private final static HashMap<String, Object> guistate = ChakraReleaseSelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_fire_release;
	Button button_water_release;
	Button button_wind_release;
	Button button_lightning_release;

	public ChakraReleaseSelectionScreen(ChakraReleaseSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_classes_mod:textures/screens/chakra_release_selection.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_fire_release = new Button(this.leftPos + 40, this.topPos + 7, 87, 20, Component.translatable("gui.dnd_classes_mod.chakra_release_selection.button_fire_release"), e -> {
		});
		guistate.put("button:button_fire_release", button_fire_release);
		this.addRenderableWidget(button_fire_release);
		button_water_release = new Button(this.leftPos + -37, this.topPos + 66, 93, 20, Component.translatable("gui.dnd_classes_mod.chakra_release_selection.button_water_release"), e -> {
		});
		guistate.put("button:button_water_release", button_water_release);
		this.addRenderableWidget(button_water_release);
		button_wind_release = new Button(this.leftPos + 40, this.topPos + 128, 87, 20, Component.translatable("gui.dnd_classes_mod.chakra_release_selection.button_wind_release"), e -> {
		});
		guistate.put("button:button_wind_release", button_wind_release);
		this.addRenderableWidget(button_wind_release);
		button_lightning_release = new Button(this.leftPos + 109, this.topPos + 66, 114, 20, Component.translatable("gui.dnd_classes_mod.chakra_release_selection.button_lightning_release"), e -> {
		});
		guistate.put("button:button_lightning_release", button_lightning_release);
		this.addRenderableWidget(button_lightning_release);
	}
}
