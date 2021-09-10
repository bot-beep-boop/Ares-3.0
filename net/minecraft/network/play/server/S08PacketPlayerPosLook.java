package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S08PacketPlayerPosLook implements Packet<INetHandlerPlayClient> {
   private double x;
   private double y;
   private float pitch;
   private float yaw;
   private Set<S08PacketPlayerPosLook.EnumFlags> field_179835_f;
   private double z;

   public double getY() {
      return this.y;
   }

   public S08PacketPlayerPosLook(double var1, double var3, double var5, float var7, float var8, Set<S08PacketPlayerPosLook.EnumFlags> var9) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
      this.yaw = var7;
      this.pitch = var8;
      this.field_179835_f = var9;
   }

   public void processPacket(INetHandlerPlayClient var1) {
      var1.handlePlayerPosLook(this);
   }

   public double getX() {
      return this.x;
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayClient)var1);
   }

   public double getZ() {
      return this.z;
   }

   public S08PacketPlayerPosLook() {
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public Set<S08PacketPlayerPosLook.EnumFlags> func_179834_f() {
      return this.field_179835_f;
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeDouble(this.x);
      var1.writeDouble(this.y);
      var1.writeDouble(this.z);
      var1.writeFloat(this.yaw);
      var1.writeFloat(this.pitch);
      var1.writeByte(S08PacketPlayerPosLook.EnumFlags.func_180056_a(this.field_179835_f));
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.x = var1.readDouble();
      this.y = var1.readDouble();
      this.z = var1.readDouble();
      this.yaw = var1.readFloat();
      this.pitch = var1.readFloat();
      this.field_179835_f = S08PacketPlayerPosLook.EnumFlags.func_180053_a(var1.readUnsignedByte());
   }

   public static enum EnumFlags {
      X(0);

      private static final S08PacketPlayerPosLook.EnumFlags[] ENUM$VALUES = new S08PacketPlayerPosLook.EnumFlags[]{X, Y, Z, Y_ROT, X_ROT};
      private int field_180058_f;
      Y_ROT(3),
      Z(2),
      X_ROT(4),
      Y(1);

      private EnumFlags(int var3) {
         this.field_180058_f = var3;
      }

      private int func_180055_a() {
         return 1 << this.field_180058_f;
      }

      public static Set<S08PacketPlayerPosLook.EnumFlags> func_180053_a(int var0) {
         EnumSet var1 = EnumSet.noneOf(S08PacketPlayerPosLook.EnumFlags.class);
         S08PacketPlayerPosLook.EnumFlags[] var5;
         int var4 = (var5 = values()).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            S08PacketPlayerPosLook.EnumFlags var2 = var5[var3];
            if (var2.func_180054_b(var0)) {
               var1.add(var2);
            }
         }

         return var1;
      }

      private boolean func_180054_b(int var1) {
         return (var1 & this.func_180055_a()) == this.func_180055_a();
      }

      public static int func_180056_a(Set<S08PacketPlayerPosLook.EnumFlags> var0) {
         int var1 = 0;

         S08PacketPlayerPosLook.EnumFlags var2;
         for(Iterator var3 = var0.iterator(); var3.hasNext(); var1 |= var2.func_180055_a()) {
            var2 = (S08PacketPlayerPosLook.EnumFlags)var3.next();
         }

         return var1;
      }
   }
}
