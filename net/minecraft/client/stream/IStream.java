package net.minecraft.client.stream;

import tv.twitch.ErrorCode;
import tv.twitch.broadcast.IngestServer;
import tv.twitch.chat.ChatUserInfo;

public interface IStream {
   boolean isPaused();

   void updateStreamVolume();

   boolean func_152908_z();

   void pause();

   void requestCommercial();

   void shutdownStream();

   boolean isReadyToBroadcast();

   void stopBroadcasting();

   int func_152920_A();

   void func_152930_t();

   void func_152911_a(Metadata var1, long var2);

   void unpause();

   boolean func_152929_G();

   ErrorCode func_152912_E();

   IStream.AuthFailureReason func_152918_H();

   IngestServerTester func_152932_y();

   void func_152922_k();

   void muteMicrophone(boolean var1);

   ChatUserInfo func_152926_a(String var1);

   IngestServer[] func_152925_v();

   String func_152921_C();

   boolean func_152936_l();

   void func_152935_j();

   void func_176026_a(Metadata var1, long var2, long var4);

   void func_152909_x();

   boolean isBroadcasting();

   boolean func_152927_B();

   boolean func_152913_F();

   void func_152917_b(String var1);

   boolean func_152928_D();

   public static enum AuthFailureReason {
      private static final IStream.AuthFailureReason[] ENUM$VALUES = new IStream.AuthFailureReason[]{ERROR, INVALID_TOKEN};
      INVALID_TOKEN,
      ERROR;
   }
}
