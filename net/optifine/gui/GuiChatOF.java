package net.optifine.gui;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.src.Config;
import net.optifine.shaders.Shaders;

public class GuiChatOF extends GuiChat {
   private static final String CMD_RELOAD_CHUNKS = "/reloadChunks";
   private static final String CMD_RELOAD_SHADERS = "/reloadShaders";

   public void sendChatMessage(String var1) {
      if (this.checkCustomCommand(var1)) {
         this.mc.ingameGUI.getChatGUI().addToSentMessages(var1);
      } else {
         super.sendChatMessage(var1);
      }

   }

   private boolean checkCustomCommand(String var1) {
      if (var1 == null) {
         return false;
      } else {
         var1 = var1.trim();
         if (var1.equals("/reloadShaders")) {
            if (Config.isShaders()) {
               Shaders.uninit();
               Shaders.loadShaderPack();
            }

            return true;
         } else if (var1.equals("/reloadChunks")) {
            this.mc.renderGlobal.loadRenderers();
            return true;
         } else {
            return false;
         }
      }
   }

   public GuiChatOF(GuiChat var1) {
      super(GuiVideoSettings.getGuiChatText(var1));
   }
}
