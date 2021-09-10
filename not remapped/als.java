import java.util.List;

public class als extends afh {
   public static final amk b = amk.a("extended");
   public static final aml a = aml.a("facing");
   private final boolean N;

   public boolean a(adm var1, cj var2, alz var3, int var4, int var5) {
      cq var6 = (cq)var3.b(a);
      if (!var1.D) {
         boolean var7 = this.a(var1, var2, var6);
         if (var7 && var4 == 1) {
            var1.a((cj)var2, (alz)var3.a(b, true), 2);
            return false;
         }

         if (!var7 && var4 == 0) {
            return false;
         }
      }

      if (var4 == 0) {
         if (!this.a(var1, var2, var6, true)) {
            return false;
         }

         var1.a((cj)var2, (alz)var3.a(b, true), 2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "tile.piston.out", 0.5F, var1.s.nextFloat() * 0.25F + 0.6F);
      } else if (var4 == 1) {
         akw var13 = var1.s(var2.a(var6));
         if (var13 instanceof alu) {
            ((alu)var13).h();
         }

         var1.a((cj)var2, (alz)afi.M.Q().a(alv.a, var6).a(alv.b, this.N ? alt.a.b : alt.a.a), 3);
         var1.a(var2, alv.a(this.a(var5), var6, false, true));
         if (this.N) {
            cj var8 = var2.a(var6.g() * 2, var6.h() * 2, var6.i() * 2);
            afh var9 = var1.p(var8).c();
            boolean var10 = false;
            if (var9 == afi.M) {
               akw var11 = var1.s(var8);
               if (var11 instanceof alu) {
                  alu var12 = (alu)var11;
                  if (var12.e() == var6 && var12.d()) {
                     var12.h();
                     var10 = true;
                  }
               }
            }

            if (!var10 && var9.t() != arm.a && a(var9, var1, var8, var6.d(), false) && (var9.k() == 0 || var9 == afi.J || var9 == afi.F)) {
               this.a(var1, var2, var6, false);
            }
         } else {
            var1.g(var2.a(var6));
         }

         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "tile.piston.in", 0.5F, var1.s.nextFloat() * 0.15F + 0.6F);
      }

      return true;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, a(var1, var2, var8)).a(b, false);
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   private void e(adm var1, cj var2, alz var3) {
      cq var4 = (cq)var3.b(a);
      boolean var5 = this.a(var1, var2, var4);
      if (var5 && !(Boolean)var3.b(b)) {
         if ((new alw(var1, var2, var4, true)).a()) {
            var1.c(var2, this, 0, var4.a());
         }
      } else if (!var5 && (Boolean)var3.b(b)) {
         var1.a((cj)var2, (alz)var3.a(b, false), 2);
         var1.c(var2, this, 1, var4.a());
      }

   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   private boolean a(adm var1, cj var2, cq var3) {
      cq[] var4 = cq.values();
      int var5 = var4.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         cq var7 = var4[var6];
         if (var7 != var3 && var1.b(var2.a(var7), var7)) {
            return true;
         }
      }

      if (var1.b(var2, cq.a)) {
         return true;
      } else {
         cj var9 = var2.a();
         cq[] var10 = cq.values();
         var6 = var10.length;

         for(int var11 = 0; var11 < var6; ++var11) {
            cq var8 = var10[var11];
            if (var8 != cq.a && var1.b(var9.a(var8), var8)) {
               return true;
            }
         }

         return false;
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public als(boolean var1) {
      super(arm.H);
      this.j(this.M.b().a(a, cq.c).a(b, false));
      this.N = var1;
      this.a(i);
      this.c(0.5F);
      this.a(yz.d);
   }

   public static cq b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5 ? null : cq.a(var1);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         this.e(var1, var2, var3);
      }

   }

   private boolean a(adm var1, cj var2, cq var3, boolean var4) {
      if (!var4) {
         var1.g(var2.a(var3));
      }

      alw var5 = new alw(var1, var2, var3, var4);
      List var6 = var5.c();
      List var7 = var5.d();
      if (!var5.a()) {
         return false;
      } else {
         int var8 = var6.size() + var7.size();
         afh[] var9 = new afh[var8];
         cq var10 = var4 ? var3 : var3.d();

         int var11;
         cj var12;
         for(var11 = var7.size() - 1; var11 >= 0; --var11) {
            var12 = (cj)var7.get(var11);
            afh var13 = var1.p(var12).c();
            var13.b(var1, var12, var1.p(var12), 0);
            var1.g(var12);
            --var8;
            var9[var8] = var13;
         }

         alz var18;
         for(var11 = var6.size() - 1; var11 >= 0; --var11) {
            var12 = (cj)var6.get(var11);
            var18 = var1.p(var12);
            afh var14 = var18.c();
            var14.c(var18);
            var1.g(var12);
            var12 = var12.a(var10);
            var1.a((cj)var12, (alz)afi.M.Q().a(a, var3), 4);
            var1.a(var12, alv.a(var18, var3, var4, false));
            --var8;
            var9[var8] = var14;
         }

         cj var16 = var2.a(var3);
         if (var4) {
            alt.a var17 = this.N ? alt.a.b : alt.a.a;
            var18 = afi.K.Q().a(alt.a, var3).a(alt.b, var17);
            alz var20 = afi.M.Q().a(alv.a, var3).a(alv.b, this.N ? alt.a.b : alt.a.a);
            var1.a((cj)var16, (alz)var20, 4);
            var1.a(var16, alv.a(var18, var3, true, false));
         }

         int var19;
         for(var19 = var7.size() - 1; var19 >= 0; --var19) {
            var1.c((cj)var7.get(var19), var9[var8++]);
         }

         for(var19 = var6.size() - 1; var19 >= 0; --var19) {
            var1.c((cj)var6.get(var19), var9[var8++]);
         }

         if (var4) {
            var1.c((cj)var16, (afh)afi.K);
            var1.c((cj)var2, (afh)this);
         }

         return true;
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() == this && (Boolean)var3.b(b)) {
         float var4 = 0.25F;
         cq var5 = (cq)var3.b(a);
         if (var5 != null) {
            switch(var5) {
            case a:
               this.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case b:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case c:
               this.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case d:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case e:
               this.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case f:
               this.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
         }
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public alz b(alz var1) {
      return this.Q().a(a, cq.b);
   }

   public static cq a(adm var0, cj var1, pr var2) {
      if (ns.e((float)var2.s - (float)var1.n()) < 2.0F && ns.e((float)var2.u - (float)var1.p()) < 2.0F) {
         double var3 = var2.t + (double)var2.aS();
         if (var3 - (double)var1.o() > 2.0D) {
            return cq.b;
         }

         if ((double)var1.o() - var3 > 0.0D) {
            return cq.a;
         }
      }

      return var2.aP().d();
   }

   public void c(adm var1, cj var2, alz var3) {
      if (!var1.D && var1.s(var2) == null) {
         this.e(var1, var2, var3);
      }

   }

   public static boolean a(afh var0, adm var1, cj var2, cq var3, boolean var4) {
      if (var0 == afi.Z) {
         return false;
      } else if (!var1.af().a(var2)) {
         return false;
      } else if (var2.o() < 0 || var3 == cq.a && var2.o() == 0) {
         return false;
      } else if (var2.o() <= var1.U() - 1 && (var3 != cq.b || var2.o() != var1.U() - 1)) {
         if (var0 != afi.J && var0 != afi.F) {
            if (var0.g(var1, var2) == -1.0F) {
               return false;
            }

            if (var0.k() == 2) {
               return false;
            }

            if (var0.k() == 1) {
               if (!var4) {
                  return false;
               }

               return true;
            }
         } else if ((Boolean)var1.p(var2).b(b)) {
            return false;
         }

         return !(var0 instanceof agq);
      } else {
         return false;
      }
   }

   public alz a(int var1) {
      return this.Q().a(a, b(var1)).a(b, (var1 & 8) > 0);
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      var1.a((cj)var2, (alz)var3.a(a, a(var1, var2, var4)), 2);
      if (!var1.D) {
         this.e(var1, var2, var3);
      }

   }
}
