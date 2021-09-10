package net.minecraft.util;

import com.google.gson.JsonElement;

public interface IJsonSerializable {
   JsonElement getSerializableElement();

   void fromJson(JsonElement var1);
}
