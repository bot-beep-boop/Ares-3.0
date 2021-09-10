package net.minecraft.client.multiplayer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class ServerData {
   public long pingToServer;
   private String serverIcon;
   public String serverName;
   public String serverMOTD;
   public String gameVersion = "1.8.9";
   private ServerData.ServerResourceMode resourceMode;
   public int version = 47;
   private boolean lanServer;
   public boolean field_78841_f;
   public String populationInfo;
   public String playerList;
   public String serverIP;

   public static ServerData getServerDataFromNBTCompound(NBTTagCompound var0) {
      ServerData var1 = new ServerData(var0.getString("name"), var0.getString("ip"), false);
      if (var0.hasKey("icon", 8)) {
         var1.setBase64EncodedIconData(var0.getString("icon"));
      }

      if (var0.hasKey("acceptTextures", 1)) {
         if (var0.getBoolean("acceptTextures")) {
            var1.setResourceMode(ServerData.ServerResourceMode.ENABLED);
         } else {
            var1.setResourceMode(ServerData.ServerResourceMode.DISABLED);
         }
      } else {
         var1.setResourceMode(ServerData.ServerResourceMode.PROMPT);
      }

      return var1;
   }

   public NBTTagCompound getNBTCompound() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.setString("name", this.serverName);
      var1.setString("ip", this.serverIP);
      if (this.serverIcon != null) {
         var1.setString("icon", this.serverIcon);
      }

      if (this.resourceMode == ServerData.ServerResourceMode.ENABLED) {
         var1.setBoolean("acceptTextures", true);
      } else if (this.resourceMode == ServerData.ServerResourceMode.DISABLED) {
         var1.setBoolean("acceptTextures", false);
      }

      return var1;
   }

   public ServerData.ServerResourceMode getResourceMode() {
      return this.resourceMode;
   }

   public ServerData(String var1, String var2, boolean var3) {
      this.resourceMode = ServerData.ServerResourceMode.PROMPT;
      this.serverName = var1;
      this.serverIP = var2;
      this.lanServer = var3;
   }

   public void setBase64EncodedIconData(String var1) {
      this.serverIcon = var1;
   }

   public void setResourceMode(ServerData.ServerResourceMode var1) {
      this.resourceMode = var1;
   }

   public void copyFrom(ServerData var1) {
      this.serverIP = var1.serverIP;
      this.serverName = var1.serverName;
      this.setResourceMode(var1.getResourceMode());
      this.serverIcon = var1.serverIcon;
      this.lanServer = var1.lanServer;
   }

   public String getBase64EncodedIconData() {
      return this.serverIcon;
   }

   public boolean isOnLAN() {
      return this.lanServer;
   }

   public static enum ServerResourceMode {
      DISABLED("disabled");

      private final IChatComponent motd;
      private static final ServerData.ServerResourceMode[] ENUM$VALUES = new ServerData.ServerResourceMode[]{ENABLED, DISABLED, PROMPT};
      PROMPT("prompt"),
      ENABLED("enabled");

      public IChatComponent getMotd() {
         return this.motd;
      }

      private ServerResourceMode(String var3) {
         this.motd = new ChatComponentTranslation("addServer.resourcePack." + var3, new Object[0]);
      }
   }
}
