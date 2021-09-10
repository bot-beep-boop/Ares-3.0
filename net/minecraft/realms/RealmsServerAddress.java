package net.minecraft.realms;

import net.minecraft.client.multiplayer.ServerAddress;

public class RealmsServerAddress {
   private final String host;
   private final int port;

   public int getPort() {
      return this.port;
   }

   protected RealmsServerAddress(String var1, int var2) {
      this.host = var1;
      this.port = var2;
   }

   public String getHost() {
      return this.host;
   }

   public static RealmsServerAddress parseString(String var0) {
      ServerAddress var1 = ServerAddress.fromString(var0);
      return new RealmsServerAddress(var1.getIP(), var1.getPort());
   }
}
