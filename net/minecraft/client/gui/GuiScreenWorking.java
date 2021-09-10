package net.minecraft.client.gui;

import net.minecraft.util.IProgressUpdate;
import net.optifine.CustomLoadingScreen;
import net.optifine.CustomLoadingScreens;

public class GuiScreenWorking extends GuiScreen implements IProgressUpdate {
   private boolean doneWorking;
   private String field_146589_f = "";
   private int progress;
   private String field_146591_a = "";
   private CustomLoadingScreen customLoadingScreen = CustomLoadingScreens.getCustomLoadingScreen();

   public void displaySavingString(String var1) {
      this.resetProgressAndMessage(var1);
   }

   public void displayLoadingString(String var1) {
      this.field_146589_f = var1;
      this.setLoadingProgress(0);
   }

   public void setLoadingProgress(int var1) {
      this.progress = var1;
   }

   public void drawScreen(int var1, int var2, float var3) {
      if (this.doneWorking) {
         if (!this.mc.isConnectedToRealms()) {
            this.mc.displayGuiScreen((GuiScreen)null);
         }
      } else {
         if (this.customLoadingScreen != null && this.mc.theWorld == null) {
            this.customLoadingScreen.drawBackground(width, height);
         } else {
            this.drawDefaultBackground();
         }

         if (this.progress > 0) {
            this.drawCenteredString(this.fontRendererObj, this.field_146591_a, width / 2, 70, 16777215);
            this.drawCenteredString(this.fontRendererObj, this.field_146589_f + " " + this.progress + "%", width / 2, 90, 16777215);
         }

         super.drawScreen(var1, var2, var3);
      }

   }

   public void setDoneWorking() {
      this.doneWorking = true;
   }

   public void resetProgressAndMessage(String var1) {
      this.field_146591_a = var1;
      this.displayLoadingString("Working...");
   }
}
