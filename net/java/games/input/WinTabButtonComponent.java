package net.java.games.input;

public class WinTabButtonComponent extends WinTabComponent {
   private int index;

   protected WinTabButtonComponent(WinTabContext var1, int var2, String var3, Component.Identifier var4, int var5) {
      super(var1, var2, var3, var4);
      this.index = var5;
   }

   public Event processPacket(WinTabPacket var1) {
      Event var2 = null;
      float var3 = (var1.PK_BUTTONS & (int)Math.pow(2.0D, (double)this.index)) > 0 ? 1.0F : 0.0F;
      if (var3 != this.getPollData()) {
         this.lastKnownValue = var3;
         var2 = new Event();
         var2.set(this, var3, var1.PK_TIME * 1000L);
         return var2;
      } else {
         return var2;
      }
   }
}
