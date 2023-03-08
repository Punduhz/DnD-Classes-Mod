
package net.mcreator.dndclassesmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.dndclassesmod.entity.TotemEntity;
import net.mcreator.dndclassesmod.client.model.ModelBasic_Model;

public class TotemRenderer extends MobRenderer<TotemEntity, ModelBasic_Model<TotemEntity>> {
	public TotemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBasic_Model(context.bakeLayer(ModelBasic_Model.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<TotemEntity, ModelBasic_Model<TotemEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("dnd_classes_mod:textures/entities/shaman_totem_template.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(TotemEntity entity) {
		return new ResourceLocation("dnd_classes_mod:textures/entities/shaman_totem_template.png");
	}
}
