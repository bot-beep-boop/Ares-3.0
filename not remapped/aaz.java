public class aaz extends yo {
   private final afh b;
   private String[] c;

   public String e_(zx var1) {
      if (this.c == null) {
         return super.e_(var1);
      } else {
         int var2 = var1.i();
         return var2 >= 0 && var2 < this.c.length ? super.e_(var1) + "." + this.c[var2] : super.e_(var1);
      }
   }

   public int a(int var1) {
      return var1;
   }

   public aaz a(String[] var1) {
      this.c = var1;
      return this;
   }

   public int a(zx var1, int var2) {
      return this.b.h(this.b.a(var1.i()));
   }

   public aaz(afh var1, boolean var2) {
      super(var1);
      this.b = var1;
      if (var2) {
         this.d(0);
         this.a(true);
      }

   }
}
