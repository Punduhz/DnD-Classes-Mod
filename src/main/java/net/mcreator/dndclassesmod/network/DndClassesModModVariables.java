package net.mcreator.dndclassesmod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.dndclassesmod.DndClassesModMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DndClassesModModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DndClassesModMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Class_Checker = original.Class_Checker;
			clone.Class_Identifier = original.Class_Identifier;
			clone.Player_Max_Mana = original.Player_Max_Mana;
			clone.Player_Available_Mana = original.Player_Available_Mana;
			clone.Player_XP = original.Player_XP;
			clone.Player_Level = original.Player_Level;
			clone.IsManaUser = original.IsManaUser;
			clone.IsStaminaUser = original.IsStaminaUser;
			clone.Ninja_HandSign_1 = original.Ninja_HandSign_1;
			clone.Ninja_HandSign_2 = original.Ninja_HandSign_2;
			clone.Ninja_HandSign_3 = original.Ninja_HandSign_3;
			clone.Shaman_Can_Use_Totem = original.Shaman_Can_Use_Totem;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("dnd_classes_mod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Class_Checker = 0;
		public double Class_Identifier = 0;
		public double Player_Max_Mana = 0;
		public double Player_Available_Mana = 0;
		public double Player_XP = 0;
		public double Player_Level = 1.0;
		public boolean IsManaUser = true;
		public boolean IsStaminaUser = true;
		public String Ninja_HandSign_1 = "";
		public String Ninja_HandSign_2 = "";
		public String Ninja_HandSign_3 = "";
		public boolean Shaman_Can_Use_Totem = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DndClassesModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Class_Checker", Class_Checker);
			nbt.putDouble("Class_Identifier", Class_Identifier);
			nbt.putDouble("Player_Max_Mana", Player_Max_Mana);
			nbt.putDouble("Player_Available_Mana", Player_Available_Mana);
			nbt.putDouble("Player_XP", Player_XP);
			nbt.putDouble("Player_Level", Player_Level);
			nbt.putBoolean("IsManaUser", IsManaUser);
			nbt.putBoolean("IsStaminaUser", IsStaminaUser);
			nbt.putString("Ninja_HandSign_1", Ninja_HandSign_1);
			nbt.putString("Ninja_HandSign_2", Ninja_HandSign_2);
			nbt.putString("Ninja_HandSign_3", Ninja_HandSign_3);
			nbt.putBoolean("Shaman_Can_Use_Totem", Shaman_Can_Use_Totem);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Class_Checker = nbt.getDouble("Class_Checker");
			Class_Identifier = nbt.getDouble("Class_Identifier");
			Player_Max_Mana = nbt.getDouble("Player_Max_Mana");
			Player_Available_Mana = nbt.getDouble("Player_Available_Mana");
			Player_XP = nbt.getDouble("Player_XP");
			Player_Level = nbt.getDouble("Player_Level");
			IsManaUser = nbt.getBoolean("IsManaUser");
			IsStaminaUser = nbt.getBoolean("IsStaminaUser");
			Ninja_HandSign_1 = nbt.getString("Ninja_HandSign_1");
			Ninja_HandSign_2 = nbt.getString("Ninja_HandSign_2");
			Ninja_HandSign_3 = nbt.getString("Ninja_HandSign_3");
			Shaman_Can_Use_Totem = nbt.getBoolean("Shaman_Can_Use_Totem");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Class_Checker = message.data.Class_Checker;
					variables.Class_Identifier = message.data.Class_Identifier;
					variables.Player_Max_Mana = message.data.Player_Max_Mana;
					variables.Player_Available_Mana = message.data.Player_Available_Mana;
					variables.Player_XP = message.data.Player_XP;
					variables.Player_Level = message.data.Player_Level;
					variables.IsManaUser = message.data.IsManaUser;
					variables.IsStaminaUser = message.data.IsStaminaUser;
					variables.Ninja_HandSign_1 = message.data.Ninja_HandSign_1;
					variables.Ninja_HandSign_2 = message.data.Ninja_HandSign_2;
					variables.Ninja_HandSign_3 = message.data.Ninja_HandSign_3;
					variables.Shaman_Can_Use_Totem = message.data.Shaman_Can_Use_Totem;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
