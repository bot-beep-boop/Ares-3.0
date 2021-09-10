package net.minecraft.server.management;

import com.google.gson.JsonObject;

public class UserListEntry<T> {
   private final T value;

   protected UserListEntry(T var1, JsonObject var2) {
      this.value = var1;
   }

   protected void onSerialization(JsonObject var1) {
   }

   T getValue() {
      return this.value;
   }

   public UserListEntry(T var1) {
      this.value = var1;
   }

   boolean hasBanExpired() {
      return false;
   }
}
