package net.minecraft.entity.ai.attributes;

import java.util.Collection;
import java.util.UUID;

public interface IAttributeInstance {
   boolean hasModifier(AttributeModifier var1);

   void setBaseValue(double var1);

   void applyModifier(AttributeModifier var1);

   IAttribute getAttribute();

   Collection<AttributeModifier> func_111122_c();

   double getAttributeValue();

   void removeModifier(AttributeModifier var1);

   Collection<AttributeModifier> getModifiersByOperation(int var1);

   AttributeModifier getModifier(UUID var1);

   void removeAllModifiers();

   double getBaseValue();
}
