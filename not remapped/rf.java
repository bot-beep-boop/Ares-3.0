public class rf extends ro {
   private int f;
   private boolean e;
   private final wi c;
   private boolean d;

   protected boolean a(adm var1, cj var2) {
      afh var3 = var1.p(var2).c();
      if (var3 == afi.ak) {
         var2 = var2.a();
         alz var4 = var1.p(var2);
         var3 = var4.c();
         if (var3 instanceof afz && (Integer)var4.b(afz.a) == 7 && this.e && (this.f == 0 || this.f < 0)) {
            this.f = 0;
            return true;
         }

         if (var3 == afi.a && this.d && (this.f == 1 || this.f < 0)) {
            this.f = 1;
            return true;
         }
      }

      return false;
   }

   public void d() {
      super.d();
   }

   public boolean a() {
      if (this.a <= 0) {
         if (!this.c.o.Q().b("mobGriefing")) {
            return false;
         }

         this.f = -1;
         this.d = this.c.cu();
         this.e = this.c.ct();
      }

      return super.a();
   }

   public rf(wi var1, double var2) {
      super(var1, var2, 16);
      this.c = var1;
   }

   public void e() {
      super.e();
      this.c.p().a((double)this.b.n() + 0.5D, (double)(this.b.o() + 1), (double)this.b.p() + 0.5D, 10.0F, (float)this.c.bQ());
      if (this.f()) {
         adm var1 = this.c.o;
         cj var2 = this.b.a();
         alz var3 = var1.p(var2);
         afh var4 = var3.c();
         if (this.f == 0 && var4 instanceof afz && (Integer)var3.b(afz.a) == 7) {
            var1.b(var2, true);
         } else if (this.f == 1 && var4 == afi.a) {
            oq var5 = this.c.cq();

            for(int var6 = 0; var6 < var5.o_(); ++var6) {
               zx var7 = var5.a(var6);
               boolean var8 = false;
               if (var7 != null) {
                  if (var7.b() == zy.N) {
                     var1.a((cj)var2, (alz)afi.aj.Q(), 3);
                     var8 = true;
                  } else if (var7.b() == zy.bS) {
                     var1.a((cj)var2, (alz)afi.cc.Q(), 3);
                     var8 = true;
                  } else if (var7.b() == zy.bR) {
                     var1.a((cj)var2, (alz)afi.cb.Q(), 3);
                     var8 = true;
                  }
               }

               if (var8) {
                  --var7.b;
                  if (var7.b <= 0) {
                     var5.a(var6, (zx)null);
                  }
                  break;
               }
            }
         }

         this.f = -1;
         this.a = 10;
      }

   }

   public boolean b() {
      return this.f >= 0 && super.b();
   }

   public void c() {
      super.c();
   }
}
