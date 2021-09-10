package net.minecraft.block.properties;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.IStringSerializable;

public class PropertyEnum<T extends Enum<T> & IStringSerializable> extends PropertyHelper<T> {
   private final ImmutableSet<T> allowedValues;
   private final Map<String, T> nameToValue = Maps.newHashMap();

   public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String var0, Class<T> var1, Predicate<T> var2) {
      return create(var0, var1, Collections2.filter(Lists.newArrayList((Enum[])var1.getEnumConstants()), var2));
   }

   public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String var0, Class<T> var1, T... var2) {
      return create(var0, var1, (Collection)Lists.newArrayList(var2));
   }

   public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String var0, Class<T> var1, Collection<T> var2) {
      return new PropertyEnum(var0, var1, var2);
   }

   public Collection<T> getAllowedValues() {
      return this.allowedValues;
   }

   protected PropertyEnum(String var1, Class<T> var2, Collection<T> var3) {
      super(var1, var2);
      this.allowedValues = ImmutableSet.copyOf(var3);
      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         Enum var4 = (Enum)var5.next();
         String var6 = ((IStringSerializable)var4).getName();
         if (this.nameToValue.containsKey(var6)) {
            throw new IllegalArgumentException("Multiple values have the same name '" + var6 + "'");
         }

         this.nameToValue.put(var6, var4);
      }

   }

   public static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> create(String var0, Class<T> var1) {
      return create(var0, var1, Predicates.alwaysTrue());
   }

   public String getName(T var1) {
      return ((IStringSerializable)var1).getName();
   }

   public String getName(Comparable var1) {
      return this.getName((Enum)var1);
   }
}
