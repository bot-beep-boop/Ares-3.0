import com.google.common.base.Objects;

public abstract class amj<T extends Comparable<T>> implements amo<T> {
   private final String b;
   private final Class<T> a;

   public Class<T> b() {
      return this.a;
   }

   public String a() {
      return this.b;
   }

   public int hashCode() {
      return 31 * this.a.hashCode() + this.b.hashCode();
   }

   protected amj(String var1, Class<T> var2) {
      this.a = var2;
      this.b = var1;
   }

   public String toString() {
      return Objects.toStringHelper(this).add("name", this.b).add("clazz", this.a).add("values", this.c()).toString();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         amj var2 = (amj)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      } else {
         return false;
      }
   }
}
