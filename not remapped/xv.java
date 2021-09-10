public class xv extends yg {
   private wn a;
   private int b;

   protected void a(zx var1, int var2) {
      this.b += var2;
      this.c(var1);
   }

   public void a(wn var1, zx var2) {
      this.c(var2);
      super.a(var1, var2);
   }

   public zx a(int var1) {
      if (this.e()) {
         this.b += Math.min(var1, this.d().b);
      }

      return super.a(var1);
   }

   protected void c(zx var1) {
      var1.a(this.a.o, this.a, this.b);
      if (!this.a.o.D) {
         int var2 = this.b;
         float var3 = abo.a().b(var1);
         int var4;
         if (var3 == 0.0F) {
            var2 = 0;
         } else if (var3 < 1.0F) {
            var4 = ns.d((float)var2 * var3);
            if (var4 < ns.f((float)var2 * var3) && Math.random() < (double)((float)var2 * var3 - (float)var4)) {
               ++var4;
            }

            var2 = var4;
         }

         while(var2 > 0) {
            var4 = pp.a(var2);
            var2 -= var4;
            this.a.o.d((pk)(new pp(this.a.o, this.a.s, this.a.t + 0.5D, this.a.u + 0.5D, var4)));
         }
      }

      this.b = 0;
      if (var1.b() == zy.j) {
         this.a.b((mw)mr.k);
      }

      if (var1.b() == zy.aV) {
         this.a.b((mw)mr.p);
      }

   }

   public xv(wn var1, og var2, int var3, int var4, int var5) {
      super(var2, var3, var4, var5);
      this.a = var1;
   }

   public boolean a(zx var1) {
      return false;
   }
}
