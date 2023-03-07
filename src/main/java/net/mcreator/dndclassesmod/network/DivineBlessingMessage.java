
package net.mcreator.dndclassesmod.network;

import net.mcreator.dndclassesmod.DndClassesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DivineBlessingMessage {

	int type, pressedms;

	public DivineBlessingMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public DivineBlessingMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(DivineBlessingMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(DivineBlessingMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DndClassesModMod.addNetworkMessage(DivineBlessingMessage.class, DivineBlessingMessage::buffer, DivineBlessingMessage::new, DivineBlessingMessage::handler);
	}

}
