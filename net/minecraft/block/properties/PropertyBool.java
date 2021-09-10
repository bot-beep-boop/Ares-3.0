package net.minecraft.block.properties;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;

public class PropertyBool extends PropertyHelper<Boolean> {
   private final ImmutableSet<Boolean> allowedValues = ImmutableSet.of(true, false);

   public String getName(Comparable var1) {
      return this.getName((Boolean)var1);
   }

   public static PropertyBool create(String var0) {
      return new PropertyBool(var0);
   }

   public String getName(Boolean var1) {
      return var1.toString();
   }

   public Collection<Boolean> getAllowedValues() {
      return this.allowedValues;
   }

   protected PropertyBool(String var1) {
      super(var1, Boolean.class);
   }
}
