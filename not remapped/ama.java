import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ama {
   private final ImmutableList<alz> e;
   private final ImmutableList<amo> d;
   private static final Joiner a = Joiner.on(", ");
   private final afh c;
   private static final Function<amo, String> b = new Function<amo, String>() {
      public String a(amo var1) {
         return var1 == null ? "<NULL>" : var1.a();
      }

      public Object apply(Object var1) {
         return this.a((amo)var1);
      }
   };

   public ImmutableList<alz> a() {
      return this.e;
   }

   public String toString() {
      return Objects.toStringHelper(this).add("block", afh.c.c(this.c)).add("properties", Iterables.transform(this.d, b)).toString();
   }

   public ama(afh var1, amo... var2) {
      this.c = var1;
      Arrays.sort(var2, new Comparator<amo>(this) {
         final ama a;

         {
            this.a = var1;
         }

         public int a(amo var1, amo var2) {
            return var1.a().compareTo(var2.a());
         }

         public int compare(Object var1, Object var2) {
            return this.a((amo)var1, (amo)var2);
         }
      });
      this.d = ImmutableList.copyOf(var2);
      LinkedHashMap var3 = Maps.newLinkedHashMap();
      ArrayList var4 = Lists.newArrayList();
      Iterable var5 = cm.a(this.e());
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         List var7 = (List)var6.next();
         Map var8 = cw.b(this.d, var7);
         ama.a var9 = new ama.a(var1, ImmutableMap.copyOf(var8));
         var3.put(var8, var9);
         var4.add(var9);
      }

      var6 = var4.iterator();

      while(var6.hasNext()) {
         ama.a var10 = (ama.a)var6.next();
         var10.a(var3);
      }

      this.e = ImmutableList.copyOf(var4);
   }

   private List<Iterable<Comparable>> e() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.d.size(); ++var2) {
         var1.add(((amo)this.d.get(var2)).c());
      }

      return var1;
   }

   public Collection<amo> d() {
      return this.d;
   }

   public afh c() {
      return this.c;
   }

   public alz b() {
      return (alz)this.e.get(0);
   }

   static class a extends aly {
      private final afh a;
      private final ImmutableMap<amo, Comparable> b;
      private ImmutableTable<amo, Comparable, alz> c;

      public <T extends Comparable<T>, V extends T> alz a(amo<T> var1, V var2) {
         if (!this.b.containsKey(var1)) {
            throw new IllegalArgumentException("Cannot set property " + var1 + " as it does not exist in " + this.a.P());
         } else if (!var1.c().contains(var2)) {
            throw new IllegalArgumentException("Cannot set property " + var1 + " to " + var2 + " on block " + afh.c.c(this.a) + ", it is not an allowed value");
         } else {
            return (alz)(this.b.get(var1) == var2 ? this : (alz)this.c.get(var1, var2));
         }
      }

      public afh c() {
         return this.a;
      }

      a(afh var1, ImmutableMap var2, Object var3) {
         this(var1, var2);
      }

      public ImmutableMap<amo, Comparable> b() {
         return this.b;
      }

      public boolean equals(Object var1) {
         return this == var1;
      }

      private Map<amo, Comparable> b(amo var1, Comparable var2) {
         HashMap var3 = Maps.newHashMap(this.b);
         var3.put(var1, var2);
         return var3;
      }

      public Collection<amo> a() {
         return Collections.unmodifiableCollection(this.b.keySet());
      }

      private a(afh var1, ImmutableMap<amo, Comparable> var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(Map<Map<amo, Comparable>, ama.a> var1) {
         if (this.c != null) {
            throw new IllegalStateException();
         } else {
            HashBasedTable var2 = HashBasedTable.create();
            Iterator var3 = this.b.keySet().iterator();

            while(var3.hasNext()) {
               amo var4 = (amo)var3.next();
               Iterator var5 = var4.c().iterator();

               while(var5.hasNext()) {
                  Comparable var6 = (Comparable)var5.next();
                  if (var6 != this.b.get(var4)) {
                     var2.put(var4, var6, var1.get(this.b(var4, var6)));
                  }
               }
            }

            this.c = ImmutableTable.copyOf(var2);
         }
      }

      public int hashCode() {
         return this.b.hashCode();
      }

      public <T extends Comparable<T>> T b(amo<T> var1) {
         if (!this.b.containsKey(var1)) {
            throw new IllegalArgumentException("Cannot get property " + var1 + " as it does not exist in " + this.a.P());
         } else {
            return (Comparable)var1.b().cast(this.b.get(var1));
         }
      }
   }
}
