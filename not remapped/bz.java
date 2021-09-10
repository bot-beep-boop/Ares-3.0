public class bz extends Exception {
   private final Object[] a;

   public Object[] a() {
      return this.a;
   }

   public bz(String var1, Object... var2) {
      super(var1);
      this.a = var2;
   }
}
