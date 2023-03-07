package net.mcreator.dndclassesmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.dndclassesmod.world.inventory.ChooseClassGuiMenu;
import net.mcreator.dndclassesmod.network.ChooseClassGuiButtonMessage;
import net.mcreator.dndclassesmod.DndClassesModMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChooseClassGuiScreen extends AbstractContainerScreen<ChooseClassGuiMenu> {
	private final static HashMap<String, Object> guistate = ChooseClassGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cleric_emblem;

	public ChooseClassGuiScreen(ChooseClassGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_classes_mod:textures/screens/choose_class_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("dnd_classes_mod:textures/screens/class_selection.png"));
		this.blit(ms, this.leftPos + -169, this.topPos + -112, 0, 0, 348, 218, 348, 218);

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
		imagebutton_cleric_emblem = new ImageButton(this.leftPos + -21, this.topPos + -112, 37, 43, 0, 0, 43, new ResourceLocation("dnd_classes_mod:textures/screens/atlas/imagebutton_cleric_emblem.png"), 37, 86, e -> {
			if (true) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new ChooseClassGuiButtonMessage(0, x, y, z));
				ChooseClassGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cleric_emblem", imagebutton_cleric_emblem);
		this.addRenderableWidget(imagebutton_cleric_emblem);
	}
}
