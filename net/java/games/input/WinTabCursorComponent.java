package net.java.games.input;

public class WinTabCursorComponent extends WinTabComponent {
   private int index;

   public Event processPacket(WinTabPacket var1) {
      Event var2 = null;
      if (var1.PK_CURSOR == this.index && this.lastKnownValue == 0.0F) {
         this.lastKnownValue = 1.0F;
         var2 = new Event();
         var2.set(this, this.lastKnownValue, var1.PK_TIME * 1000L);
      } else if (var1.PK_CURSOR != this.index && this.lastKnownValue == 1.0F) {
         this.lastKnownValue = 0.0F;
         var2 = new Event();
         var2.set(this, this.lastKnownValue, var1.PK_TIME * 1000L);
      }

      return var2;
   }

   protected WinTabCursorComponent(WinTabContext var1, int var2, String var3, Component.Identifier var4, int var5) {
      super(var1, var2, var3, var4);
      this.index = var5;
   }
}
