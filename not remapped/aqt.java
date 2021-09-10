import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class aqt {
   protected aqe l;
   protected cq m;
   protected int n;

   protected aqt(int var1) {
      this.n = var1;
   }

   protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(int var9 = var4; var9 <= var7; ++var9) {
         for(int var10 = var3; var10 <= var6; ++var10) {
            for(int var11 = var5; var11 <= var8; ++var11) {
               this.a(var1, afi.a.Q(), var10, var9, var11, var2);
            }
         }
      }

   }

   public dn b() {
      dn var1 = new dn();
      var1.a("id", aqr.a(this));
      var1.a((String)"BB", (eb)this.l.g());
      var1.a("O", this.m == null ? -1 : this.m.b());
      var1.a("GD", this.n);
      this.a(var1);
      return var1;
   }

   public int d() {
      return this.n;
   }

   public void a(int var1, int var2, int var3) {
      this.l.a(var1, var2, var3);
   }

   protected void a(adm var1, aqe var2, Random var3, float var4, int var5, int var6, int var7, alz var8) {
      if (var3.nextFloat() < var4) {
         this.a(var1, var8, var5, var6, var7, var2);
      }

   }

   public abstract boolean a(adm var1, Random var2, aqe var3);

   protected void a(adm var1, aqe var2, Random var3, int var4, int var5, int var6, cq var7) {
      cj var8 = new cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if (var2.b((df)var8)) {
         zb.a(var1, var8, var7.f(), afi.ao);
      }

   }

   protected void b(adm var1, alz var2, int var3, int var4, int var5, aqe var6) {
      int var7 = this.a(var3, var5);
      int var8 = this.d(var4);
      int var9 = this.b(var3, var5);
      if (var6.b((df)(new cj(var7, var8, var9)))) {
         while((var1.d(new cj(var7, var8, var9)) || var1.p(new cj(var7, var8, var9)).c().t().d()) && var8 > 1) {
            var1.a((cj)(new cj(var7, var8, var9)), (alz)var2, 2);
            --var8;
         }

      }
   }

   public static aqt a(List<aqt> var0, aqe var1) {
      Iterator var2 = var0.iterator();

      aqt var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (aqt)var2.next();
      } while(var3.c() == null || !var3.c().a(var1));

      return var3;
   }

   protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6, int var7, int var8, alz var9, boolean var10) {
      float var11 = (float)(var6 - var3 + 1);
      float var12 = (float)(var7 - var4 + 1);
      float var13 = (float)(var8 - var5 + 1);
      float var14 = (float)var3 + var11 / 2.0F;
      float var15 = (float)var5 + var13 / 2.0F;

      for(int var16 = var4; var16 <= var7; ++var16) {
         float var17 = (float)(var16 - var4) / var12;

         for(int var18 = var3; var18 <= var6; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = var5; var20 <= var8; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if (!var10 || this.a(var1, var18, var16, var20, var2).c().t() != arm.a) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if (var22 <= 1.05F) {
                     this.a(var1, var9, var18, var16, var20, var2);
                  }
               }
            }
         }
      }

   }

   protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, aqt.a var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if (!var9 || this.a(var1, var13, var12, var14, var2).c().t() != arm.a) {
                  var11.a(var10, var13, var12, var14, var12 == var4 || var12 == var7 || var13 == var3 || var13 == var6 || var14 == var5 || var14 == var8);
                  this.a(var1, var11.a(), var13, var12, var14, var2);
               }
            }
         }
      }

   }

   protected int b(int var1, int var2) {
      if (this.m == null) {
         return var2;
      } else {
         switch(this.m) {
         case c:
            return this.l.f - var2;
         case d:
            return this.l.c + var2;
         case e:
         case f:
            return this.l.c + var1;
         default:
            return var2;
         }
      }
   }

   protected void a(adm var1, alz var2, int var3, int var4, int var5, aqe var6) {
      cj var7 = new cj(this.a(var3, var5), this.d(var4), this.b(var3, var5));
      if (var6.b((df)var7)) {
         var1.a((cj)var7, (alz)var2, 2);
      }
   }

   protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6, int var7, int var8, alz var9, alz var10, boolean var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if (!var11 || this.a(var1, var13, var12, var14, var2).c().t() != arm.a) {
                  if (var12 != var4 && var12 != var7 && var13 != var3 && var13 != var6 && var14 != var5 && var14 != var8) {
                     this.a(var1, var10, var13, var12, var14, var2);
                  } else {
                     this.a(var1, var9, var13, var12, var14, var2);
                  }
               }
            }
         }
      }

   }

   protected int a(int var1, int var2) {
      if (this.m == null) {
         return var1;
      } else {
         switch(this.m) {
         case c:
         case d:
            return this.l.a + var1;
         case e:
            return this.l.d - var2;
         case f:
            return this.l.a + var2;
         default:
            return var1;
         }
      }
   }

   public void a(adm var1, dn var2) {
      if (var2.c("BB")) {
         this.l = new aqe(var2.l("BB"));
      }

      int var3 = var2.f("O");
      this.m = var3 == -1 ? null : cq.b(var3);
      this.n = var2.f("GD");
      this.b(var2);
   }

   protected void b(adm var1, int var2, int var3, int var4, aqe var5) {
      cj var6 = new cj(this.a(var2, var4), this.d(var3), this.b(var2, var4));
      if (var5.b((df)var6)) {
         while(!var1.d(var6) && var6.o() < 255) {
            var1.a((cj)var6, (alz)afi.a.Q(), 2);
            var6 = var6.a();
         }

      }
   }

   protected int d(int var1) {
      return this.m == null ? var1 : var1 + this.l.b;
   }

   protected abstract void b(dn var1);

   public aqe c() {
      return this.l;
   }

   protected abstract void a(dn var1);

   public void a(aqt var1, List<aqt> var2, Random var3) {
   }

   public aqt() {
   }

   protected void a(adm var1, aqe var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, alz var11, alz var12, boolean var13) {
      for(int var14 = var6; var14 <= var9; ++var14) {
         for(int var15 = var5; var15 <= var8; ++var15) {
            for(int var16 = var7; var16 <= var10; ++var16) {
               if (!(var3.nextFloat() > var4) && (!var13 || this.a(var1, var15, var14, var16, var2).c().t() != arm.a)) {
                  if (var14 != var6 && var14 != var9 && var15 != var5 && var15 != var8 && var16 != var7 && var16 != var10) {
                     this.a(var1, var12, var15, var14, var16, var2);
                  } else {
                     this.a(var1, var11, var15, var14, var16, var2);
                  }
               }
            }
         }
      }

   }

   protected boolean a(adm var1, aqe var2) {
      int var3 = Math.max(this.l.a - 1, var2.a);
      int var4 = Math.max(this.l.b - 1, var2.b);
      int var5 = Math.max(this.l.c - 1, var2.c);
      int var6 = Math.min(this.l.d + 1, var2.d);
      int var7 = Math.min(this.l.e + 1, var2.e);
      int var8 = Math.min(this.l.f + 1, var2.f);
      cj.a var9 = new cj.a();

      int var10;
      int var11;
      for(var10 = var3; var10 <= var6; ++var10) {
         for(var11 = var5; var11 <= var8; ++var11) {
            if (var1.p(var9.c(var10, var4, var11)).c().t().d()) {
               return true;
            }

            if (var1.p(var9.c(var10, var7, var11)).c().t().d()) {
               return true;
            }
         }
      }

      for(var10 = var3; var10 <= var6; ++var10) {
         for(var11 = var4; var11 <= var7; ++var11) {
            if (var1.p(var9.c(var10, var11, var5)).c().t().d()) {
               return true;
            }

            if (var1.p(var9.c(var10, var11, var8)).c().t().d()) {
               return true;
            }
         }
      }

      for(var10 = var5; var10 <= var8; ++var10) {
         for(var11 = var4; var11 <= var7; ++var11) {
            if (var1.p(var9.c(var3, var11, var10)).c().t().d()) {
               return true;
            }

            if (var1.p(var9.c(var6, var11, var10)).c().t().d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected boolean a(adm var1, aqe var2, Random var3, int var4, int var5, int var6, int var7, List<ob> var8, int var9) {
      cj var10 = new cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if (var2.b((df)var10) && var1.p(var10).c() != afi.z) {
         var1.a((cj)var10, (alz)afi.z.a(this.a(afi.z, var7)), 2);
         akw var11 = var1.s(var10);
         if (var11 instanceof alc) {
            ob.a(var3, var8, (alc)var11, var9);
         }

         return true;
      } else {
         return false;
      }
   }

   protected alz a(adm var1, int var2, int var3, int var4, aqe var5) {
      int var6 = this.a(var2, var4);
      int var7 = this.d(var3);
      int var8 = this.b(var2, var4);
      cj var9 = new cj(var6, var7, var8);
      return !var5.b((df)var9) ? afi.a.Q() : var1.p(var9);
   }

   public cj a() {
      return new cj(this.l.f());
   }

   protected boolean a(adm var1, aqe var2, Random var3, int var4, int var5, int var6, List<ob> var7, int var8) {
      cj var9 = new cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if (var2.b((df)var9) && var1.p(var9).c() != afi.ae) {
         alz var10 = afi.ae.Q();
         var1.a((cj)var9, (alz)afi.ae.f(var1, var9, var10), 2);
         akw var11 = var1.s(var9);
         if (var11 instanceof aky) {
            ob.a(var3, var7, (og)((aky)var11), var8);
         }

         return true;
      } else {
         return false;
      }
   }

   protected int a(afh var1, int var2) {
      if (var1 == afi.av) {
         if (this.m == cq.e || this.m == cq.f) {
            if (var2 == 1) {
               return 0;
            }

            return 1;
         }
      } else if (var1 instanceof agh) {
         if (this.m == cq.d) {
            if (var2 == 0) {
               return 2;
            }

            if (var2 == 2) {
               return 0;
            }
         } else {
            if (this.m == cq.e) {
               return var2 + 1 & 3;
            }

            if (this.m == cq.f) {
               return var2 + 3 & 3;
            }
         }
      } else if (var1 != afi.aw && var1 != afi.ad && var1 != afi.bA && var1 != afi.bv && var1 != afi.bO) {
         if (var1 == afi.au) {
            if (this.m == cq.d) {
               if (var2 == cq.c.a()) {
                  return cq.d.a();
               }

               if (var2 == cq.d.a()) {
                  return cq.c.a();
               }
            } else if (this.m == cq.e) {
               if (var2 == cq.c.a()) {
                  return cq.e.a();
               }

               if (var2 == cq.d.a()) {
                  return cq.f.a();
               }

               if (var2 == cq.e.a()) {
                  return cq.c.a();
               }

               if (var2 == cq.f.a()) {
                  return cq.d.a();
               }
            } else if (this.m == cq.f) {
               if (var2 == cq.c.a()) {
                  return cq.f.a();
               }

               if (var2 == cq.d.a()) {
                  return cq.e.a();
               }

               if (var2 == cq.e.a()) {
                  return cq.c.a();
               }

               if (var2 == cq.f.a()) {
                  return cq.d.a();
               }
            }
         } else if (var1 == afi.aG) {
            if (this.m == cq.d) {
               if (var2 == 3) {
                  return 4;
               }

               if (var2 == 4) {
                  return 3;
               }
            } else if (this.m == cq.e) {
               if (var2 == 3) {
                  return 1;
               }

               if (var2 == 4) {
                  return 2;
               }

               if (var2 == 2) {
                  return 3;
               }

               if (var2 == 1) {
                  return 4;
               }
            } else if (this.m == cq.f) {
               if (var2 == 3) {
                  return 2;
               }

               if (var2 == 4) {
                  return 1;
               }

               if (var2 == 2) {
                  return 3;
               }

               if (var2 == 1) {
                  return 4;
               }
            }
         } else if (var1 != afi.bR && !(var1 instanceof age)) {
            if (var1 == afi.J || var1 == afi.F || var1 == afi.ay || var1 == afi.z) {
               if (this.m == cq.d) {
                  if (var2 == cq.c.a() || var2 == cq.d.a()) {
                     return cq.a(var2).d().a();
                  }
               } else if (this.m == cq.e) {
                  if (var2 == cq.c.a()) {
                     return cq.e.a();
                  }

                  if (var2 == cq.d.a()) {
                     return cq.f.a();
                  }

                  if (var2 == cq.e.a()) {
                     return cq.c.a();
                  }

                  if (var2 == cq.f.a()) {
                     return cq.d.a();
                  }
               } else if (this.m == cq.f) {
                  if (var2 == cq.c.a()) {
                     return cq.f.a();
                  }

                  if (var2 == cq.d.a()) {
                     return cq.e.a();
                  }

                  if (var2 == cq.e.a()) {
                     return cq.c.a();
                  }

                  if (var2 == cq.f.a()) {
                     return cq.d.a();
                  }
               }
            }
         } else {
            cq var3 = cq.b(var2);
            if (this.m == cq.d) {
               if (var3 == cq.d || var3 == cq.c) {
                  return var3.d().b();
               }
            } else if (this.m == cq.e) {
               if (var3 == cq.c) {
                  return cq.e.b();
               }

               if (var3 == cq.d) {
                  return cq.f.b();
               }

               if (var3 == cq.e) {
                  return cq.c.b();
               }

               if (var3 == cq.f) {
                  return cq.d.b();
               }
            } else if (this.m == cq.f) {
               if (var3 == cq.c) {
                  return cq.f.b();
               }

               if (var3 == cq.d) {
                  return cq.e.b();
               }

               if (var3 == cq.e) {
                  return cq.c.b();
               }

               if (var3 == cq.f) {
                  return cq.d.b();
               }
            }
         }
      } else if (this.m == cq.d) {
         if (var2 == 2) {
            return 3;
         }

         if (var2 == 3) {
            return 2;
         }
      } else if (this.m == cq.e) {
         if (var2 == 0) {
            return 2;
         }

         if (var2 == 1) {
            return 3;
         }

         if (var2 == 2) {
            return 0;
         }

         if (var2 == 3) {
            return 1;
         }
      } else if (this.m == cq.f) {
         if (var2 == 0) {
            return 2;
         }

         if (var2 == 1) {
            return 3;
         }

         if (var2 == 2) {
            return 1;
         }

         if (var2 == 3) {
            return 0;
         }
      }

      return var2;
   }

   public abstract static class a {
      protected alz a;

      public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

      protected a() {
         this.a = afi.a.Q();
      }

      public alz a() {
         return this.a;
      }
   }
}
