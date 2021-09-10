package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.potion.PotionEffect;

public class S1EPacketRemoveEntityEffect implements Packet<INetHandlerPlayClient> {
   private int entityId;
   private int effectId;

   public int getEntityId() {
      return this.entityId;
   }

   public S1EPacketRemoveEntityEffect() {
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarIntToBuffer(this.entityId);
      var1.writeByte(this.effectId);
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }

   public int getEffectId() {
      return this.effectId;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleRemoveEntityEffect(this);
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.entityId = var1.readVarIntFromBuffer();
      this.effectId = var1.readUnsignedByte();
   }

   public S1EPacketRemoveEntityEffect(int var1, PotionEffect var2) {
      this.entityId = var1;
      this.effectId = var2.getPotionID();
   }
}
