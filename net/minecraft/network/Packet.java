package net.minecraft.network;

import java.io.IOException;

public interface Packet<T extends INetHandler> {
   void writePacketData(PacketBuffer var1) throws IOException;

   void readPacketData(PacketBuffer var1) throws IOException;

   void processPacket(T var1);
}
