import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;

public class amn extends amj<Integer> {
   private final ImmutableSet<Integer> a;

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         if (!super.equals(var1)) {
            return false;
         } else {
            amn var2 = (amn)var1;
            return this.a.equals(var2.a);
         }
      } else {
         return false;
      }
   }

   public String a(Comparable var1) {
      return this.a((Integer)var1);
   }

   public String a(Integer var1) {
      return var1.toString();
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 31 * var1 + this.a.hashCode();
      return var1;
   }

   public static amn a(String var0, int var1, int var2) {
      return new amn(var0, var1, var2);
   }

   public Collection<Integer> c() {
      return this.a;
   }

   protected amn(String var1, int var2, int var3) {
      super(var1, Integer.class);
      if (var2 < 0) {
         throw new IllegalArgumentException("Min value of " + var1 + " must be 0 or greater");
      } else if (var3 <= var2) {
         throw new IllegalArgumentException("Max value of " + var1 + " must be greater than min (" + var2 + ")");
      } else {
         HashSet var4 = Sets.newHashSet();

         for(int var5 = var2; var5 <= var3; ++var5) {
            var4.add(var5);
         }

         this.a = ImmutableSet.copyOf(var4);
      }
   }
}
