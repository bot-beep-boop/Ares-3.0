package net.java.games.input;

import java.io.IOException;

final class LinuxConstantFF extends LinuxForceFeedbackEffect {
   protected final int upload(int var1, float var2) throws IOException {
      int var3 = Math.round(var2 * 32767.0F);
      return this.getDevice().uploadConstantEffect(var1, 0, 0, 0, 0, 0, var3, 0, 0, 0, 0);
   }

   public LinuxConstantFF(LinuxEventDevice var1) throws IOException {
      super(var1);
   }
}
