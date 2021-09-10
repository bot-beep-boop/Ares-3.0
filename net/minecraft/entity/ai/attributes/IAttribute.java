package net.minecraft.entity.ai.attributes;

public interface IAttribute {
   boolean getShouldWatch();

   double getDefaultValue();

   String getAttributeUnlocalizedName();

   IAttribute func_180372_d();

   double clampValue(double var1);
}
