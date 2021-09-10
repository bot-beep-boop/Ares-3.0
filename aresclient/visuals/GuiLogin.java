package com.aresclient.visuals;

import com.aresclient.utils.GuiImages;
import com.aresclient.utils.SessionChanger;
import com.aresclient.visuals.utils.PasswordField;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiLogin extends GuiScreen {
   private PasswordField password;
   int rotate = 0;
   private final GuiScreen previousScreen;
   private GuiTextField username;
   int s = 2;

   protected void actionPerformed(GuiButton var1) {
      switch(var1.id) {
      case 0:
         SessionChanger.getInstance().setUser(this.username.getText(), this.password.getText());
         break;
      case 1:
         this.mc.displayGuiScreen(this.previousScreen);
      case 2:
      case 3:
      case 4:
      }

   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      GuiImages.drawBackgroundPicture(width, height, "Ares/Wallpaper/bg" + GuiMainMenu.wallpaper + ".png");
      this.username.drawTextBox();
      this.password.drawTextBox();
      this.drawCenteredString(this.mc.fontRendererObj, "Logged in as " + this.mc.getSession().getUsername(), width / 2, 20, -1);
      if (this.username.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
      }

      if (this.password.getText().isEmpty()) {
         this.drawString(this.mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void initGui() {
      int var1 = height / 4 + 24;
      this.buttonList.add(new GuiButton(0, width / 2 - 100, var1 + 72 + 12, "Login"));
      this.buttonList.add(new GuiButton(1, width / 2 - 100, var1 + 72 + 12 + 24, "Back"));
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username = new GuiTextField(var1, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.username.setFocused(true);
      this.password = new PasswordField(this.mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
      Keyboard.enableRepeatEvents(true);
   }

   protected void keyTyped(char var1, int var2) {
      try {
         super.keyTyped(var1, var2);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      if (var1 == '\t') {
         if (!this.username.isFocused() && !this.password.isFocused()) {
            this.username.setFocused(true);
         } else {
            this.username.setFocused(this.password.isFocused());
            this.password.setFocused(!this.username.isFocused());
         }
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      this.username.textboxKeyTyped(var1, var2);
      this.password.textboxKeyTyped(var1, var2);
   }

   public void updateScreen() {
      this.username.updateCursorCounter();
      this.password.updateCursorCounter();
   }

   public GuiLogin(GuiScreen var1) {
      this.previousScreen = var1;
   }

   protected void mouseClicked(int var1, int var2, int var3) {
      try {
         super.mouseClicked(var1, var2, var3);
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      this.username.mouseClicked(var1, var2, var3);
      this.password.mouseClicked(var1, var2, var3);
   }
}
