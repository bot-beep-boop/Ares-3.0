package net.minecraft.util;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Map;
import java.util.UUID;

public class Session {
   private final String token;
   private final String playerID;
   private final Session.Type sessionType;
   private final String username;

   public String getPlayerID() {
      return this.playerID;
   }

   public String getToken() {
      return this.token;
   }

   public String getAuthToken() {
      String[] var1 = this.token.split("\\.");
      return var1[0] + this.getPlayerID();
   }

   public Session(String var1, String var2, String var3, String var4) {
      this.username = var1;
      this.playerID = var2;
      this.token = var3;
      this.sessionType = Session.Type.setSessionType(var4);
   }

   public Session.Type getSessionType() {
      return this.sessionType;
   }

   public GameProfile getProfile() {
      try {
         UUID var1 = UUIDTypeAdapter.fromString(this.getPlayerID());
         return new GameProfile(var1, this.getUsername());
      } catch (IllegalArgumentException var2) {
         return new GameProfile((UUID)null, this.getUsername());
      }
   }

   public String getUsername() {
      return this.username;
   }

   public String getSessionID() {
      return "token:" + this.token + ":" + this.playerID;
   }

   public static enum Type {
      LEGACY("legacy"),
      MOJANG("mojang");

      private static final Map<String, Session.Type> SESSION_TYPES = Maps.newHashMap();
      private static final Session.Type[] ENUM$VALUES = new Session.Type[]{LEGACY, MOJANG};
      private final String sessionType;

      private Type(String var3) {
         this.sessionType = var3;
      }

      public static Session.Type setSessionType(String var0) {
         return (Session.Type)SESSION_TYPES.get(var0.toLowerCase());
      }

      static {
         Session.Type[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            Session.Type var0 = var3[var1];
            SESSION_TYPES.put(var0.sessionType, var0);
         }

      }
   }
}
