package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S2EPacketCloseWindow implements Packet<INetHandlerPlayClient> {
   private int windowId;

   public S2EPacketCloseWindow(int var1) {
      this.windowId = var1;
   }

   public S2EPacketCloseWindow() {
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.windowId = var1.readUnsignedByte();
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleCloseWindow(this);
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeByte(this.windowId);
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }
}
