package net.mcreator.dndclassesmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.dndclassesmod.world.inventory.ClericGuiMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ClericGuiScreen extends AbstractContainerScreen<ClericGuiMenu> {
	private final static HashMap<String, Object> guistate = ClericGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_resized_divine_cleansing;

	public ClericGuiScreen(ClericGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 348;
		this.imageHeight = 214;
	}

	private static final ResourceLocation texture = new ResourceLocation("dnd_classes_mod:textures/screens/cleric_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("dnd_classes_mod:textures/screens/cleric_tech_tree_layout.png"));
		this.blit(ms, this.leftPos + 7, this.topPos + 7, 0, 0, 334, 200, 334, 200);

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
		imagebutton_resized_divine_cleansing = new ImageButton(this.leftPos + 56, this.topPos + 131, 28, 28, 0, 0, 28, new ResourceLocation("dnd_classes_mod:textures/screens/atlas/imagebutton_resized_divine_cleansing.png"), 28, 56, e -> {
		});
		guistate.put("button:imagebutton_resized_divine_cleansing", imagebutton_resized_divine_cleansing);
		this.addRenderableWidget(imagebutton_resized_divine_cleansing);
	}
}
