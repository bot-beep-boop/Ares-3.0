public class yc extends yg {
   private int c;
   private wn b;
   private final ya a;
   private final acy h;

   public void a(wn var1, zx var2) {
      this.c(var2);
      acz var3 = this.a.i();
      if (var3 != null) {
         zx var4 = this.a.a(0);
         zx var5 = this.a.a(1);
         if (this.a(var3, var4, var5) || this.a(var3, var5, var4)) {
            this.h.a(var3);
            var1.b(na.G);
            if (var4 != null && var4.b <= 0) {
               var4 = null;
            }

            if (var5 != null && var5.b <= 0) {
               var5 = null;
            }

            this.a.a(0, var4);
            this.a.a(1, var5);
         }
      }

   }

   private boolean a(acz var1, zx var2, zx var3) {
      zx var4 = var1.a();
      zx var5 = var1.b();
      if (var2 != null && var2.b() == var4.b()) {
         if (var5 != null && var3 != null && var5.b() == var3.b()) {
            var2.b -= var4.b;
            var3.b -= var5.b;
            return true;
         }

         if (var5 == null && var3 == null) {
            var2.b -= var4.b;
            return true;
         }
      }

      return false;
   }

   protected void a(zx var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   public yc(wn var1, acy var2, ya var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.h = var2;
      this.a = var3;
   }

   protected void c(zx var1) {
      var1.a(this.b.o, this.b, this.c);
      this.c = 0;
   }

   public zx a(int var1) {
      if (this.e()) {
         this.c += Math.min(var1, this.d().b);
      }

      return super.a(var1);
   }

   public boolean a(zx var1) {
      return false;
   }
}
