public class aqa {
   private alz b;
   private int c;
   private final int a;
   private int d;

   public String toString() {
      String var1;
      if (this.a >= 3) {
         jy var2 = (jy)afh.c.c(this.e());
         var1 = var2 == null ? "null" : var2.toString();
         if (this.c > 1) {
            var1 = this.c + "*" + var1;
         }
      } else {
         var1 = Integer.toString(afh.a(this.e()));
         if (this.c > 1) {
            var1 = this.c + "x" + var1;
         }
      }

      int var3 = this.f();
      if (var3 > 0) {
         var1 = var1 + ":" + var3;
      }

      return var1;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public aqa(int var1, afh var2) {
      this(3, var1, var2);
   }

   private afh e() {
      return this.b.c();
   }

   public int b() {
      return this.c;
   }

   public alz c() {
      return this.b;
   }

   public aqa(int var1, int var2, afh var3) {
      this.c = 1;
      this.a = var1;
      this.c = var2;
      this.b = var3.Q();
   }

   public int d() {
      return this.d;
   }

   private int f() {
      return this.b.c().c(this.b);
   }

   public aqa(int var1, int var2, afh var3, int var4) {
      this(var1, var2, var3);
      this.b = var3.a(var4);
   }
}
