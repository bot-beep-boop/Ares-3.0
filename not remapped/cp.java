public class cp<K, V> extends dd<K, V> {
   private final V a;

   public cp(V var1) {
      this.a = var1;
   }

   public V a(K var1) {
      Object var2 = super.a(var1);
      return var2 == null ? this.a : var2;
   }
}
