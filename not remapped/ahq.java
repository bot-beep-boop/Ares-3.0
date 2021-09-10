public class ahq extends afc {
   public static final amk a = amk.a("has_record");

   public int b() {
      return 3;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if ((Boolean)var3.b(a)) {
         this.e(var1, var2, var3);
         var3 = var3.a(a, false);
         var1.a((cj)var2, (alz)var3, 2);
         return true;
      } else {
         return false;
      }
   }

   public int c(alz var1) {
      return (Boolean)var1.b(a) ? 1 : 0;
   }

   public boolean O() {
      return true;
   }

   public void a(adm var1, cj var2, alz var3, zx var4) {
      if (!var1.D) {
         akw var5 = var1.s(var2);
         if (var5 instanceof ahq.a) {
            ((ahq.a)var5).a(new zx(var4.b(), 1, var4.i()));
            var1.a((cj)var2, (alz)var3.a(a, true), 2);
         }
      }
   }

   public akw a(adm var1, int var2) {
      return new ahq.a();
   }

   public int l(adm var1, cj var2) {
      akw var3 = var1.s(var2);
      if (var3 instanceof ahq.a) {
         zx var4 = ((ahq.a)var3).a();
         if (var4 != null) {
            return zw.b(var4.b()) + 1 - zw.b(zy.cq);
         }
      }

      return 0;
   }

   public alz a(int var1) {
      return this.Q().a(a, var1 > 0);
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D) {
         super.a(var1, var2, var3, var4, 0);
      }
   }

   private void e(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         akw var4 = var1.s(var2);
         if (var4 instanceof ahq.a) {
            ahq.a var5 = (ahq.a)var4;
            zx var6 = var5.a();
            if (var6 != null) {
               var1.b(1005, var2, 0);
               var1.a((cj)var2, (String)null);
               var5.a((zx)null);
               float var7 = 0.7F;
               double var8 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               double var10 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
               double var12 = (double)(var1.s.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               zx var14 = var6.k();
               uz var15 = new uz(var1, (double)var2.n() + var8, (double)var2.o() + var10, (double)var2.p() + var12, var14);
               var15.p();
               var1.d((pk)var15);
            }
         }
      }
   }

   protected ahq() {
      super(arm.d, arn.l);
      this.j(this.M.b().a(a, false));
      this.a(yz.c);
   }

   public void b(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
      super.b(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public static class a extends akw {
      private zx a;

      public zx a() {
         return this.a;
      }

      public void a(dn var1) {
         super.a(var1);
         if (var1.b("RecordItem", 10)) {
            this.a(zx.a(var1.m("RecordItem")));
         } else if (var1.f("Record") > 0) {
            this.a(new zx(zw.b(var1.f("Record")), 1, 0));
         }

      }

      public void a(zx var1) {
         this.a = var1;
         this.p_();
      }

      public void b(dn var1) {
         super.b(var1);
         if (this.a() != null) {
            var1.a((String)"RecordItem", (eb)this.a().b(new dn()));
         }

      }
   }
}
