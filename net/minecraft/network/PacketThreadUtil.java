package net.minecraft.network;

import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.src.Config;
import net.minecraft.util.IThreadListener;

public class PacketThreadUtil {
   public static int lastDimensionId = Integer.MIN_VALUE;

   protected static void clientPreProcessPacket(Packet var0) {
      if (var0 instanceof S08PacketPlayerPosLook) {
         Config.getRenderGlobal().onPlayerPositionSet();
      }

      if (var0 instanceof S07PacketRespawn) {
         S07PacketRespawn var1 = (S07PacketRespawn)var0;
         lastDimensionId = var1.getDimensionID();
      } else if (var0 instanceof S01PacketJoinGame) {
         S01PacketJoinGame var2 = (S01PacketJoinGame)var0;
         lastDimensionId = var2.getDimension();
      } else {
         lastDimensionId = Integer.MIN_VALUE;
      }

   }

   public static <T extends INetHandler> void checkThreadAndEnqueue(Packet<T> var0, T var1, IThreadListener var2) throws ThreadQuickExitException {
      if (!var2.isCallingFromMinecraftThread()) {
         var2.addScheduledTask(new Runnable(var0, var1) {
            private final Packet val$p_180031_0_;
            private final INetHandler val$p_180031_1_;

            public void run() {
               PacketThreadUtil.clientPreProcessPacket(this.val$p_180031_0_);

               try {
                  this.val$p_180031_0_.processPacket(this.val$p_180031_1_);
               } catch (NullPointerException var2) {
                  var2.printStackTrace();
               }

            }

            {
               this.val$p_180031_0_ = var1;
               this.val$p_180031_1_ = var2;
            }
         });
         throw ThreadQuickExitException.INSTANCE;
      } else {
         clientPreProcessPacket(var0);
      }
   }
}
