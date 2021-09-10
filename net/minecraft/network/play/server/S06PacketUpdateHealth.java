package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S06PacketUpdateHealth implements Packet<INetHandlerPlayClient> {
   private int foodLevel;
   private float health;
   private float saturationLevel;

   public S06PacketUpdateHealth(float var1, int var2, float var3) {
      this.health = var1;
      this.foodLevel = var2;
      this.saturationLevel = var3;
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }

   public float getHealth() {
      return this.health;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handleUpdateHealth(this);
   }

   public S06PacketUpdateHealth() {
   }

   public float getSaturationLevel() {
      return this.saturationLevel;
   }

   public int getFoodLevel() {
      return this.foodLevel;
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeFloat(this.health);
      var1.writeVarIntToBuffer(this.foodLevel);
      var1.writeFloat(this.saturationLevel);
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.health = var1.readFloat();
      this.foodLevel = var1.readVarIntFromBuffer();
      this.saturationLevel = var1.readFloat();
   }
}
