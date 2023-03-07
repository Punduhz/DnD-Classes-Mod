
package net.mcreator.dndclassesmod.network;

import net.mcreator.dndclassesmod.DndClassesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainGuiOpenMessage {

	int type, pressedms;

	public MainGuiOpenMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public MainGuiOpenMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(MainGuiOpenMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(MainGuiOpenMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			MainGuiOpenProcedureProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DndClassesModMod.addNetworkMessage(MainGuiOpenMessage.class, MainGuiOpenMessage::buffer, MainGuiOpenMessage::new, MainGuiOpenMessage::handler);
	}

}
