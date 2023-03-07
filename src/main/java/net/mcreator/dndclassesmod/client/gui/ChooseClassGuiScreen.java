package net.mcreator.dndclassesmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
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
	Button button_druid;
	Button button_necromancer;
	Button button_archer;
	Button button_guardian;
	Button button_assassin;
	Button button_helleon;
	Button button_warrior;
	Button button_ninja;
	Button button_shaman;
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
		this.blit(ms, this.leftPos + -171, this.topPos + -112, 0, 0, 348, 218, 348, 218);

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
		button_druid = new Button(this.leftPos + -80, this.topPos + -85, 51, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_druid"), e -> {
		});
		guistate.put("button:button_druid", button_druid);
		this.addRenderableWidget(button_druid);
		button_necromancer = new Button(this.leftPos + -125, this.topPos + -39, 82, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_necromancer"), e -> {
		});
		guistate.put("button:button_necromancer", button_necromancer);
		this.addRenderableWidget(button_necromancer);
		button_archer = new Button(this.leftPos + -116, this.topPos + 13, 56, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_archer"), e -> {
		});
		guistate.put("button:button_archer", button_archer);
		this.addRenderableWidget(button_archer);
		button_guardian = new Button(this.leftPos + -88, this.topPos + 57, 67, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_guardian"), e -> {
		});
		guistate.put("button:button_guardian", button_guardian);
		this.addRenderableWidget(button_guardian);
		button_assassin = new Button(this.leftPos + -37, this.topPos + 76, 67, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_assassin"), e -> {
		});
		guistate.put("button:button_assassin", button_assassin);
		this.addRenderableWidget(button_assassin);
		button_helleon = new Button(this.leftPos + 19, this.topPos + 56, 61, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_helleon"), e -> {
		});
		guistate.put("button:button_helleon", button_helleon);
		this.addRenderableWidget(button_helleon);
		button_warrior = new Button(this.leftPos + 52, this.topPos + 13, 61, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_warrior"), e -> {
		});
		guistate.put("button:button_warrior", button_warrior);
		this.addRenderableWidget(button_warrior);
		button_ninja = new Button(this.leftPos + 56, this.topPos + -42, 51, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_ninja"), e -> {
		});
		guistate.put("button:button_ninja", button_ninja);
		this.addRenderableWidget(button_ninja);
		button_shaman = new Button(this.leftPos + 20, this.topPos + -85, 56, 20, Component.translatable("gui.dnd_classes_mod.choose_class_gui.button_shaman"), e -> {
		});
		guistate.put("button:button_shaman", button_shaman);
		this.addRenderableWidget(button_shaman);
		imagebutton_cleric_emblem = new ImageButton(this.leftPos + -21, this.topPos + -112, 37, 43, 0, 0, 43, new ResourceLocation("dnd_classes_mod:textures/screens/atlas/imagebutton_cleric_emblem.png"), 37, 86, e -> {
			if (true) {
				DndClassesModMod.PACKET_HANDLER.sendToServer(new ChooseClassGuiButtonMessage(9, x, y, z));
				ChooseClassGuiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cleric_emblem", imagebutton_cleric_emblem);
		this.addRenderableWidget(imagebutton_cleric_emblem);
	}
}
