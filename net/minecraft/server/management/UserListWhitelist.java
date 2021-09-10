package net.minecraft.server.management;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.Iterator;

public class UserListWhitelist extends UserList<GameProfile, UserListWhitelistEntry> {
   protected UserListEntry<GameProfile> createEntry(JsonObject var1) {
      return new UserListWhitelistEntry(var1);
   }

   protected String getObjectKey(GameProfile var1) {
      return var1.getId().toString();
   }

   public UserListWhitelist(File var1) {
      super(var1);
   }

   protected String getObjectKey(Object var1) {
      return this.getObjectKey((GameProfile)var1);
   }

   public GameProfile getBannedProfile(String var1) {
      Iterator var3 = this.getValues().values().iterator();

      while(var3.hasNext()) {
         UserListWhitelistEntry var2 = (UserListWhitelistEntry)var3.next();
         if (var1.equalsIgnoreCase(((GameProfile)var2.getValue()).getName())) {
            return (GameProfile)var2.getValue();
         }
      }

      return null;
   }

   public String[] getKeys() {
      String[] var1 = new String[this.getValues().size()];
      int var2 = 0;

      UserListWhitelistEntry var3;
      for(Iterator var4 = this.getValues().values().iterator(); var4.hasNext(); var1[var2++] = ((GameProfile)var3.getValue()).getName()) {
         var3 = (UserListWhitelistEntry)var4.next();
      }

      return var1;
   }
}
