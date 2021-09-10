package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.World;

public class S19PacketEntityStatus implements Packet<INetHandlerPlayClient> {
   private byte logicOpcode;
   private int entityId;

   public S19PacketEntityStatus(Entity var1, byte var2) {
      this.entityId = var1.getEntityId();
      this.logicOpcode = var2;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleEntityStatus(this);
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeInt(this.entityId);
      var1.writeByte(this.logicOpcode);
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.entityId = var1.readInt();
      this.logicOpcode = var1.readByte();
   }

   public S19PacketEntityStatus() {
   }

   public Entity getEntity(World var1) {
      return var1.getEntityByID(this.entityId);
   }

   public byte getOpCode() {
      return this.logicOpcode;
   }
}
