package net.minecraft.client.gui;

import net.minecraft.util.IChatComponent;

public class ChatLine {
   private final int updateCounterCreated;
   private final int chatLineID;
   private final IChatComponent lineString;

   public int getChatLineID() {
      return this.chatLineID;
   }

   public int getUpdatedCounter() {
      return this.updateCounterCreated;
   }

   public IChatComponent getChatComponent() {
      return this.lineString;
   }

   public ChatLine(int var1, IChatComponent var2, int var3) {
      this.lineString = var2;
      this.updateCounterCreated = var1;
      this.chatLineID = var3;
   }
}
