package net.java.games.input;

import java.io.IOException;

final class LinuxRumbleFF extends LinuxForceFeedbackEffect {
   public LinuxRumbleFF(LinuxEventDevice var1) throws IOException {
      super(var1);
   }

   protected final int upload(int var1, float var2) throws IOException {
      int var3;
      int var4;
      if (var2 > 0.666666F) {
         var4 = (int)(32768.0F * var2);
         var3 = (int)(49152.0F * var2);
      } else if (var2 > 0.3333333F) {
         var4 = (int)(32768.0F * var2);
         var3 = 0;
      } else {
         var4 = 0;
         var3 = (int)(49152.0F * var2);
      }

      return this.getDevice().uploadRumbleEffect(var1, 0, 0, 0, -1, 0, var4, var3);
   }
}
