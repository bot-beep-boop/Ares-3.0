import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.mojang.authlib.GameProfile;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class awh extends avp {
   private eu i;
   private static final Ordering<bdc> a = Ordering.from(new awh.a());
   private long j;
   private final avo g;
   private eu h;
   private final ave f;
   private boolean k;

   public void a() {
      this.i = null;
      this.h = null;
   }

   public void a(int var1, auo var2, auk var3) {
      bcy var4 = this.f.h.a;
      List var5 = a.sortedCopy(var4.d());
      int var6 = 0;
      int var7 = 0;
      Iterator var8 = var5.iterator();

      int var10;
      while(var8.hasNext()) {
         bdc var9 = (bdc)var8.next();
         var10 = this.f.k.a(this.a(var9));
         var6 = Math.max(var6, var10);
         if (var3 != null && var3.e() != auu.a.b) {
            var10 = this.f.k.a(" " + var2.c(var9.a().getName(), var3).c());
            var7 = Math.max(var7, var10);
         }
      }

      var5 = var5.subList(0, Math.min(var5.size(), 80));
      int var33 = var5.size();
      int var34 = var33;

      for(var10 = 1; var34 > 20; var34 = (var33 + var10 - 1) / var10) {
         ++var10;
      }

      boolean var11 = this.f.E() || this.f.u().a().f();
      int var12;
      if (var3 != null) {
         if (var3.e() == auu.a.b) {
            var12 = 90;
         } else {
            var12 = var7;
         }
      } else {
         var12 = 0;
      }

      int var13 = Math.min(var10 * ((var11 ? 9 : 0) + var6 + var12 + 13), var1 - 50) / var10;
      int var14 = var1 / 2 - (var13 * var10 + (var10 - 1) * 5) / 2;
      int var15 = 10;
      int var16 = var13 * var10 + (var10 - 1) * 5;
      List var17 = null;
      List var18 = null;
      Iterator var19;
      String var20;
      if (this.i != null) {
         var17 = this.f.k.c(this.i.d(), var1 - 50);

         for(var19 = var17.iterator(); var19.hasNext(); var16 = Math.max(var16, this.f.k.a(var20))) {
            var20 = (String)var19.next();
         }
      }

      if (this.h != null) {
         var18 = this.f.k.c(this.h.d(), var1 - 50);

         for(var19 = var18.iterator(); var19.hasNext(); var16 = Math.max(var16, this.f.k.a(var20))) {
            var20 = (String)var19.next();
         }
      }

      int var21;
      if (var17 != null) {
         a(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var17.size() * this.f.k.a, Integer.MIN_VALUE);

         for(var19 = var17.iterator(); var19.hasNext(); var15 += this.f.k.a) {
            var20 = (String)var19.next();
            var21 = this.f.k.a(var20);
            this.f.k.a(var20, (float)(var1 / 2 - var21 / 2), (float)var15, -1);
         }

         ++var15;
      }

      a(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var34 * 9, Integer.MIN_VALUE);

      for(int var35 = 0; var35 < var33; ++var35) {
         int var36 = var35 / var34;
         var21 = var35 % var34;
         int var22 = var14 + var36 * var13 + var36 * 5;
         int var23 = var15 + var21 * 9;
         a(var22, var23, var22 + var13, var23 + 8, 553648127);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.d();
         bfl.l();
         bfl.a(770, 771, 1, 0);
         if (var35 < var5.size()) {
            bdc var24 = (bdc)var5.get(var35);
            String var25 = this.a(var24);
            GameProfile var26 = var24.a();
            if (var11) {
               wn var27 = this.f.f.b((UUID)var26.getId());
               boolean var28 = var27 != null && var27.a(wo.a) && (var26.getName().equals("Dinnerbone") || var26.getName().equals("Grumm"));
               this.f.P().a(var24.g());
               int var29 = 8 + (var28 ? 8 : 0);
               int var30 = 8 * (var28 ? -1 : 1);
               avp.a(var22, var23, 8.0F, (float)var29, 8, var30, 8, 8, 64.0F, 64.0F);
               if (var27 != null && var27.a(wo.g)) {
                  int var31 = 8 + (var28 ? 8 : 0);
                  int var32 = 8 * (var28 ? -1 : 1);
                  avp.a(var22, var23, 40.0F, (float)var31, 8, var32, 8, 8, 64.0F, 64.0F);
               }

               var22 += 9;
            }

            if (var24.b() == adp.a.e) {
               var25 = .a.u + var25;
               this.f.k.a(var25, (float)var22, (float)var23, -1862270977);
            } else {
               this.f.k.a(var25, (float)var22, (float)var23, -1);
            }

            if (var3 != null && var24.b() != adp.a.e) {
               int var37 = var22 + var6 + 1;
               int var38 = var37 + var12;
               if (var38 - var37 > 5) {
                  this.a(var3, var23, var26.getName(), var37, var38, var24);
               }
            }

            this.a(var13, var22 - (var11 ? 9 : 0), var23, var24);
         }
      }

      if (var18 != null) {
         var15 += var34 * 9 + 1;
         a(var1 / 2 - var16 / 2 - 1, var15 - 1, var1 / 2 + var16 / 2 + 1, var15 + var18.size() * this.f.k.a, Integer.MIN_VALUE);

         for(var19 = var18.iterator(); var19.hasNext(); var15 += this.f.k.a) {
            var20 = (String)var19.next();
            var21 = this.f.k.a(var20);
            this.f.k.a(var20, (float)(var1 / 2 - var21 / 2), (float)var15, -1);
         }
      }

   }

   public void b(eu var1) {
      this.i = var1;
   }

   public void a(boolean var1) {
      if (var1 && !this.k) {
         this.j = ave.J();
      }

      this.k = var1;
   }

   public void a(eu var1) {
      this.h = var1;
   }

   private void a(auk var1, int var2, String var3, int var4, int var5, bdc var6) {
      int var7 = var1.a().c(var3, var1).c();
      if (var1.e() == auu.a.b) {
         this.f.P().a(d);
         if (this.j == var6.p()) {
            if (var7 < var6.l()) {
               var6.a(ave.J());
               var6.b((long)(this.g.e() + 20));
            } else if (var7 > var6.l()) {
               var6.a(ave.J());
               var6.b((long)(this.g.e() + 10));
            }
         }

         if (ave.J() - var6.n() > 1000L || this.j != var6.p()) {
            var6.b(var7);
            var6.c(var7);
            var6.a(ave.J());
         }

         var6.c(this.j);
         var6.b(var7);
         int var8 = ns.f((float)Math.max(var7, var6.m()) / 2.0F);
         int var9 = Math.max(ns.f((float)(var7 / 2)), Math.max(ns.f((float)(var6.m() / 2)), 10));
         boolean var10 = var6.o() > (long)this.g.e() && (var6.o() - (long)this.g.e()) / 3L % 2L == 1L;
         if (var8 > 0) {
            float var11 = Math.min((float)(var5 - var4 - 4) / (float)var9, 9.0F);
            if (var11 > 3.0F) {
               int var12;
               for(var12 = var8; var12 < var9; ++var12) {
                  this.a((float)var4 + (float)var12 * var11, (float)var2, var10 ? 25 : 16, 0, 9, 9);
               }

               for(var12 = 0; var12 < var8; ++var12) {
                  this.a((float)var4 + (float)var12 * var11, (float)var2, var10 ? 25 : 16, 0, 9, 9);
                  if (var10) {
                     if (var12 * 2 + 1 < var6.m()) {
                        this.a((float)var4 + (float)var12 * var11, (float)var2, 70, 0, 9, 9);
                     }

                     if (var12 * 2 + 1 == var6.m()) {
                        this.a((float)var4 + (float)var12 * var11, (float)var2, 79, 0, 9, 9);
                     }
                  }

                  if (var12 * 2 + 1 < var7) {
                     this.a((float)var4 + (float)var12 * var11, (float)var2, var12 >= 10 ? 160 : 52, 0, 9, 9);
                  }

                  if (var12 * 2 + 1 == var7) {
                     this.a((float)var4 + (float)var12 * var11, (float)var2, var12 >= 10 ? 169 : 61, 0, 9, 9);
                  }
               }
            } else {
               float var16 = ns.a((float)var7 / 20.0F, 0.0F, 1.0F);
               int var13 = (int)((1.0F - var16) * 255.0F) << 16 | (int)(var16 * 255.0F) << 8;
               String var14 = "" + (float)var7 / 2.0F;
               if (var5 - this.f.k.a(var14 + "hp") >= var4) {
                  var14 = var14 + "hp";
               }

               this.f.k.a(var14, (float)((var5 + var4) / 2 - this.f.k.a(var14) / 2), (float)var2, var13);
            }
         }
      } else {
         String var15 = .a.o + "" + var7;
         this.f.k.a(var15, (float)(var5 - this.f.k.a(var15)), (float)var2, 16777215);
      }

   }

   public awh(ave var1, avo var2) {
      this.f = var1;
      this.g = var2;
   }

   public String a(bdc var1) {
      return var1.k() != null ? var1.k().d() : aul.a(var1.i(), var1.a().getName());
   }

   protected void a(int var1, int var2, int var3, bdc var4) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.f.P().a(d);
      byte var5 = 0;
      boolean var6 = false;
      byte var7;
      if (var4.c() < 0) {
         var7 = 5;
      } else if (var4.c() < 150) {
         var7 = 0;
      } else if (var4.c() < 300) {
         var7 = 1;
      } else if (var4.c() < 600) {
         var7 = 2;
      } else if (var4.c() < 1000) {
         var7 = 3;
      } else {
         var7 = 4;
      }

      this.e += 100.0F;
      this.b(var2 + var1 - 11, var3, 0 + var5 * 10, 176 + var7 * 8, 10, 8);
      this.e -= 100.0F;
   }

   static class a implements Comparator<bdc> {
      public int a(bdc var1, bdc var2) {
         aul var3 = var1.i();
         aul var4 = var2.i();
         return ComparisonChain.start().compareTrueFirst(var1.b() != adp.a.e, var2.b() != adp.a.e).compare(var3 != null ? var3.b() : "", var4 != null ? var4.b() : "").compare(var1.a().getName(), var2.a().getName()).result();
      }

      public int compare(Object var1, Object var2) {
         return this.a((bdc)var1, (bdc)var2);
      }

      private a() {
      }

      a(Object var1) {
         this();
      }
   }
}
