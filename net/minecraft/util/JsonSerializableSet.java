package net.minecraft.util;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class JsonSerializableSet extends ForwardingSet<String> implements IJsonSerializable {
   private final Set<String> underlyingSet = Sets.newHashSet();

   protected Collection delegate() {
      return this.delegate();
   }

   protected Object delegate() {
      return this.delegate();
   }

   public JsonElement getSerializableElement() {
      JsonArray var1 = new JsonArray();
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         var1.add(new JsonPrimitive(var2));
      }

      return var1;
   }

   public void fromJson(JsonElement var1) {
      if (var1.isJsonArray()) {
         Iterator var3 = var1.getAsJsonArray().iterator();

         while(var3.hasNext()) {
            JsonElement var2 = (JsonElement)var3.next();
            this.add(var2.getAsString());
         }
      }

   }

   protected Set<String> delegate() {
      return this.underlyingSet;
   }
}
