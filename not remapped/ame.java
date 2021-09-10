import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class ame {
   private int e;
   private int d;
   private static final Joiner a = Joiner.on(",");
   private final List<String[]> b = Lists.newArrayList();
   private final Map<Character, Predicate<amc>> c = Maps.newHashMap();

   public static ame a() {
      return new ame();
   }

   public ame a(char var1, Predicate<amc> var2) {
      this.c.put(var1, var2);
      return this;
   }

   public ame a(String... var1) {
      if (!ArrayUtils.isEmpty(var1) && !StringUtils.isEmpty(var1[0])) {
         if (this.b.isEmpty()) {
            this.d = var1.length;
            this.e = var1[0].length();
         }

         if (var1.length != this.d) {
            throw new IllegalArgumentException("Expected aisle with height of " + this.d + ", but was given one with a height of " + var1.length + ")");
         } else {
            String[] var2 = var1;
            int var3 = var1.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               String var5 = var2[var4];
               if (var5.length() != this.e) {
                  throw new IllegalArgumentException("Not all rows in the given aisle are the correct width (expected " + this.e + ", found one with " + var5.length() + ")");
               }

               char[] var6 = var5.toCharArray();
               int var7 = var6.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  char var9 = var6[var8];
                  if (!this.c.containsKey(var9)) {
                     this.c.put(var9, (Object)null);
                  }
               }
            }

            this.b.add(var1);
            return this;
         }
      } else {
         throw new IllegalArgumentException("Empty pattern for aisle");
      }
   }

   public amd b() {
      return new amd(this.c());
   }

   private Predicate<amc>[][][] c() {
      this.d();
      Predicate[][][] var1 = (Predicate[][][])((Predicate[][][])Array.newInstance(Predicate.class, new int[]{this.b.size(), this.d, this.e}));

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         for(int var3 = 0; var3 < this.d; ++var3) {
            for(int var4 = 0; var4 < this.e; ++var4) {
               var1[var2][var3][var4] = (Predicate)this.c.get(((String[])this.b.get(var2))[var3].charAt(var4));
            }
         }
      }

      return var1;
   }

   private void d() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.c.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (var3.getValue() == null) {
            var1.add(var3.getKey());
         }
      }

      if (!var1.isEmpty()) {
         throw new IllegalStateException("Predicates for character(s) " + a.join(var1) + " are missing");
      }
   }

   private ame() {
      this.c.put(' ', Predicates.alwaysTrue());
   }
}
