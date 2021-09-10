import org.apache.commons.lang3.Validate;

public class co<K, V> extends cx<K, V> {
   private V e;
   private final K d;

   public co(K var1) {
      this.d = var1;
   }

   public void a(int var1, K var2, V var3) {
      if (this.d.equals(var2)) {
         this.e = var3;
      }

      super.a(var1, var2, var3);
   }

   public V a(int var1) {
      Object var2 = super.a(var1);
      return var2 == null ? this.e : var2;
   }

   public void a() {
      Validate.notNull(this.d);
   }

   public V a(K var1) {
      Object var2 = super.a(var1);
      return var2 == null ? this.e : var2;
   }
}
