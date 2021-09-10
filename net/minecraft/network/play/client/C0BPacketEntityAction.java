package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0BPacketEntityAction implements Packet<INetHandlerPlayServer> {
   private int auxData;
   private int entityID;
   private C0BPacketEntityAction.Action action;

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarIntToBuffer(this.entityID);
      var1.writeEnumValue(this.action);
      var1.writeVarIntToBuffer(this.auxData);
   }

   public void processPacket(INetHandlerPlayServer var1) {
      var1.processEntityAction(this);
   }

   public C0BPacketEntityAction(Entity var1, C0BPacketEntityAction.Action var2) {
      this(var1, var2, 0);
   }

   public C0BPacketEntityAction.Action getAction() {
      return this.action;
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayServer)var1);
   }

   public C0BPacketEntityAction() {
   }

   public C0BPacketEntityAction(Entity var1, C0BPacketEntityAction.Action var2, int var3) {
      this.entityID = var1.getEntityId();
      this.action = var2;
      this.auxData = var3;
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.entityID = var1.readVarIntFromBuffer();
      this.action = (C0BPacketEntityAction.Action)var1.readEnumValue(C0BPacketEntityAction.Action.class);
      this.auxData = var1.readVarIntFromBuffer();
   }

   public int getAuxData() {
      return this.auxData;
   }

   public static enum Action {
      OPEN_INVENTORY,
      START_SNEAKING,
      STOP_SNEAKING;

      private static final C0BPacketEntityAction.Action[] ENUM$VALUES = new C0BPacketEntityAction.Action[]{START_SNEAKING, STOP_SNEAKING, STOP_SLEEPING, START_SPRINTING, STOP_SPRINTING, RIDING_JUMP, OPEN_INVENTORY};
      STOP_SLEEPING,
      STOP_SPRINTING,
      RIDING_JUMP,
      START_SPRINTING;
   }
}
