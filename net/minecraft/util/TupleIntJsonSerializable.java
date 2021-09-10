package net.minecraft.util;

public class TupleIntJsonSerializable {
   private int integerValue;
   private IJsonSerializable jsonSerializableValue;

   public <T extends IJsonSerializable> T getJsonSerializableValue() {
      return this.jsonSerializableValue;
   }

   public int getIntegerValue() {
      return this.integerValue;
   }

   public void setJsonSerializableValue(IJsonSerializable var1) {
      this.jsonSerializableValue = var1;
   }

   public void setIntegerValue(int var1) {
      this.integerValue = var1;
   }
}
