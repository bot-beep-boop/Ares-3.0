public class yf extends yg {
   private final wn b;
   private int c;
   private final xp a;

   protected void a(zx var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   protected void c(zx var1) {
      if (this.c > 0) {
         var1.a(this.b.o, this.b, this.c);
      }

      this.c = 0;
      if (var1.b() == zw.a(afi.ai)) {
         this.b.b((mw)mr.h);
      }

      if (var1.b() instanceof aag) {
         this.b.b((mw)mr.i);
      }

      if (var1.b() == zw.a(afi.al)) {
         this.b.b((mw)mr.j);
      }

      if (var1.b() instanceof zv) {
         this.b.b((mw)mr.l);
      }

      if (var1.b() == zy.P) {
         this.b.b((mw)mr.m);
      }

      if (var1.b() == zy.aZ) {
         this.b.b((mw)mr.n);
      }

      if (var1.b() instanceof aag && ((aag)var1.b()).g() != zw.a.a) {
         this.b.b((mw)mr.o);
      }

      if (var1.b() instanceof aay) {
         this.b.b((mw)mr.r);
      }

      if (var1.b() == zw.a(afi.bC)) {
         this.b.b((mw)mr.E);
      }

      if (var1.b() == zw.a(afi.X)) {
         this.b.b((mw)mr.G);
      }

      if (var1.b() == zy.ao && var1.i() == 1) {
         this.b.b((mw)mr.M);
      }

   }

   public yf(wn var1, xp var2, og var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.a = var2;
   }

   public zx a(int var1) {
      if (this.e()) {
         this.c += Math.min(var1, this.d().b);
      }

      return super.a(var1);
   }

   public void a(wn var1, zx var2) {
      this.c(var2);
      zx[] var3 = abt.a().b(this.a, var1.o);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         zx var5 = this.a.a(var4);
         zx var6 = var3[var4];
         if (var5 != null) {
            this.a.a(var4, 1);
         }

         if (var6 != null) {
            if (this.a.a(var4) == null) {
               this.a.a(var4, var6);
            } else if (!this.b.bi.a(var6)) {
               this.b.a(var6, false);
            }
         }
      }

   }

   public boolean a(zx var1) {
      return false;
   }
}
