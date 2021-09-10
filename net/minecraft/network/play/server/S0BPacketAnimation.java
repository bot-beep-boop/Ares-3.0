package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S0BPacketAnimation implements Packet<INetHandlerPlayClient> {
   private int entityId;
   private int type;

   public S0BPacketAnimation() {
   }

   public S0BPacketAnimation(Entity var1, int var2) {
      this.entityId = var1.getEntityId();
      this.type = var2;
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.entityId = var1.readVarIntFromBuffer();
      this.type = var1.readUnsignedByte();
   }

   public int getEntityID() {
      return this.entityId;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleAnimation(this);
   }

   public int getAnimationType() {
      return this.type;
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarIntToBuffer(this.entityId);
      var1.writeByte(this.type);
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }
}
