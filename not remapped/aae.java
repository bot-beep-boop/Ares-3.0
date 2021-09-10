import com.google.common.base.Function;

public class aae extends yo {
   protected final Function<zx, String> c;
   protected final afh b;

   public aae(afh var1, afh var2, String[] var3) {
      this(var1, var2, new Function<zx, String>(var3) {
         final String[] a;

         {
            this.a = var1;
         }

         public String a(zx var1) {
            int var2 = var1.i();
            if (var2 < 0 || var2 >= this.a.length) {
               var2 = 0;
            }

            return this.a[var2];
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      });
   }

   public aae(afh var1, afh var2, Function<zx, String> var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(zx var1) {
      return super.a() + "." + (String)this.c.apply(var1);
   }
}
