import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class aju extends afh {
   private final afh P;
   private boolean R;
   private final alz Q;
   private int S;
   public static final amm<aju.b> N;
   public static final aml a;
   public static final amm<aju.a> b;
   private static final int[][] O;

   public int g(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      cq var4 = (cq)var3.b(a);
      aju.a var5 = (aju.a)var3.b(b);
      boolean var6 = var5 == aju.a.a;
      alz var7;
      afh var8;
      cq var9;
      if (var4 == cq.f) {
         var7 = var1.p(var2.e());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.c && !a(var1, var2.c(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == cq.d && !a(var1, var2.d(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      } else if (var4 == cq.e) {
         var7 = var1.p(var2.f());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.c && !a(var1, var2.c(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == cq.d && !a(var1, var2.d(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == cq.d) {
         var7 = var1.p(var2.c());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.e && !a(var1, var2.e(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == cq.f && !a(var1, var2.f(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == cq.c) {
         var7 = var1.p(var2.d());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.e && !a(var1, var2.e(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == cq.f && !a(var1, var2.f(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      }

      return 0;
   }

   public boolean a(alz var1, boolean var2) {
      return this.P.a(var1, var2);
   }

   public boolean h(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      cq var4 = (cq)var3.b(a);
      aju.a var5 = (aju.a)var3.b(b);
      boolean var6 = var5 == aju.a.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if (var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      alz var14;
      afh var15;
      cq var16;
      if (var4 == cq.f) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.f());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.c && !a(var1, var2.d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if (var16 == cq.d && !a(var1, var2.c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == cq.e) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.e());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.c && !a(var1, var2.d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if (var16 == cq.d && !a(var1, var2.c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == cq.d) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.d());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.e && !a(var1, var2.f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if (var16 == cq.f && !a(var1, var2.e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == cq.c) {
         var14 = var1.p(var2.c());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.e && !a(var1, var2.f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if (var16 == cq.f && !a(var1, var2.e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.a(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public int c(adq var1, cj var2) {
      return this.P.c(var1, var2);
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amm.a("half", aju.a.class);
      N = amm.a("shape", aju.b.class);
      O = new int[][]{{4, 5}, {5, 7}, {6, 7}, {4, 6}, {0, 1}, {1, 3}, {2, 3}, {0, 2}};
   }

   public alz a(int var1) {
      alz var2 = this.Q().a(b, (var1 & 4) > 0 ? aju.a.a : aju.a.b);
      var2 = var2.a(a, cq.a(5 - (var1 & 3)));
      return var2;
   }

   public aug b(adm var1, cj var2) {
      return this.P.b(var1, var2);
   }

   protected aju(alz var1) {
      super(var1.c().J);
      this.j(this.M.b().a(a, cq.c).a(b, aju.a.b).a(N, aju.b.a));
      this.P = var1.c();
      this.Q = var1;
      this.c(this.P.w);
      this.b(this.P.x / 3.0F);
      this.a((afh.b)this.P.H);
      this.e(255);
      this.a((yz)yz.b);
   }

   public void c(adm var1, cj var2, alz var3) {
      this.a(var1, var2, (alz)this.Q, (afh)afi.a);
      this.P.c(var1, var2, this.Q);
   }

   public void d(adm var1, cj var2, alz var3) {
      this.P.d(var1, var2, var3);
   }

   public adf m() {
      return this.P.m();
   }

   public alz a(alz var1, adq var2, cj var3) {
      if (this.h(var2, var3)) {
         switch(this.g(var2, var3)) {
         case 0:
            var1 = var1.a(N, aju.b.a);
            break;
         case 1:
            var1 = var1.a(N, aju.b.c);
            break;
         case 2:
            var1 = var1.a(N, aju.b.b);
         }
      } else {
         switch(this.f(var2, var3)) {
         case 0:
            var1 = var1.a(N, aju.b.a);
            break;
         case 1:
            var1 = var1.a(N, aju.b.e);
            break;
         case 2:
            var1 = var1.a(N, aju.b.d);
         }
      }

      return var1;
   }

   public boolean d() {
      return false;
   }

   public void e(adq var1, cj var2) {
      if (var1.p(var2).b(b) == aju.a.a) {
         this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      return this.P.a(var1, var2, this.Q, var4, cq.a, 0.0F, 0.0F, 0.0F);
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      auh[] var5 = new auh[8];
      alz var6 = var1.p(var2);
      int var7 = ((cq)var6.b(a)).b();
      boolean var8 = var6.b(b) == aju.a.a;
      int[] var9 = O[var7 + (var8 ? 4 : 0)];
      this.R = true;

      for(int var10 = 0; var10 < 8; ++var10) {
         this.S = var10;
         if (Arrays.binarySearch(var9, var10) < 0) {
            var5[var10] = super.a(var1, var2, var3, var4);
         }
      }

      int[] var19 = var9;
      int var11 = var9.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         int var13 = var19[var12];
         var5[var13] = null;
      }

      auh var20 = null;
      double var21 = 0.0D;
      auh[] var22 = var5;
      int var14 = var5.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         auh var16 = var22[var15];
         if (var16 != null) {
            double var17 = var16.c.g(var4);
            if (var17 > var21) {
               var20 = var16;
               var21 = var17;
            }
         }
      }

      return var20;
   }

   public void a(adm var1, cj var2, pk var3) {
      this.P.a(var1, var2, var3);
   }

   public arn g(alz var1) {
      return this.P.g(this.Q);
   }

   public void a(adm var1, cj var2, adi var3) {
      this.P.a(var1, var2, var3);
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      this.P.b(var1, var2, var3, var4);
   }

   public boolean i(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      cq var4 = (cq)var3.b(a);
      aju.a var5 = (aju.a)var3.b(b);
      boolean var6 = var5 == aju.a.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if (var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      alz var14;
      afh var15;
      cq var16;
      if (var4 == cq.f) {
         var14 = var1.p(var2.e());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.c && !a(var1, var2.c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if (var16 == cq.d && !a(var1, var2.d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == cq.e) {
         var14 = var1.p(var2.f());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = (cq)var14.b(a);
            if (var16 == cq.c && !a(var1, var2.c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if (var16 == cq.d && !a(var1, var2.d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == cq.d) {
         var14 = var1.p(var2.c());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = (cq)var14.b(a);
            if (var16 == cq.e && !a(var1, var2.e(), var3)) {
               var13 = true;
            } else if (var16 == cq.f && !a(var1, var2.f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == cq.c) {
         var14 = var1.p(var2.d());
         var15 = var14.c();
         if (c(var15) && var5 == var14.b(b)) {
            var16 = (cq)var14.b(a);
            if (var16 == cq.e && !a(var1, var2.e(), var3)) {
               var13 = true;
            } else if (var16 == cq.f && !a(var1, var2.f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if (var13) {
         this.a(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      this.P.c(var1, var2, var3, var4);
   }

   public float a(pk var1) {
      return this.P.a(var1);
   }

   public void a(adq var1, cj var2) {
      if (this.R) {
         this.a(0.5F * (float)(this.S % 2), 0.5F * (float)(this.S / 4 % 2), 0.5F * (float)(this.S / 2 % 2), 0.5F + 0.5F * (float)(this.S % 2), 0.5F + 0.5F * (float)(this.S / 4 % 2), 0.5F + 0.5F * (float)(this.S / 2 % 2));
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public static boolean c(afh var0) {
      return var0 instanceof aju;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      var9 = var9.a(a, var8.aP()).a(N, aju.b.a);
      return var3 != cq.a && (var3 == cq.b || !((double)var5 > 0.5D)) ? var9.a(b, aju.a.b) : var9.a(b, aju.a.a);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N});
   }

   public boolean A() {
      return this.P.A();
   }

   public boolean c() {
      return false;
   }

   public static boolean a(adq var0, cj var1, alz var2) {
      alz var3 = var0.p(var1);
      afh var4 = var3.c();
      return c(var4) && var3.b(b) == var2.b(b) && var3.b(a) == var2.b(a);
   }

   public int f(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      cq var4 = (cq)var3.b(a);
      aju.a var5 = (aju.a)var3.b(b);
      boolean var6 = var5 == aju.a.a;
      alz var7;
      afh var8;
      cq var9;
      if (var4 == cq.f) {
         var7 = var1.p(var2.f());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.c && !a(var1, var2.d(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == cq.d && !a(var1, var2.c(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      } else if (var4 == cq.e) {
         var7 = var1.p(var2.e());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.c && !a(var1, var2.d(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == cq.d && !a(var1, var2.c(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == cq.d) {
         var7 = var1.p(var2.d());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.e && !a(var1, var2.f(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == cq.f && !a(var1, var2.e(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == cq.c) {
         var7 = var1.p(var2.c());
         var8 = var7.c();
         if (c(var8) && var5 == var7.b(b)) {
            var9 = (cq)var7.b(a);
            if (var9 == cq.e && !a(var1, var2.f(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == cq.f && !a(var1, var2.e(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      }

      return 0;
   }

   public int c(alz var1) {
      int var2 = 0;
      if (var1.b(b) == aju.a.a) {
         var2 |= 4;
      }

      var2 |= 5 - ((cq)var1.b(a)).a();
      return var2;
   }

   public boolean d(adm var1, cj var2) {
      return this.P.d(var1, var2);
   }

   public void b(adm var1, cj var2, alz var3) {
      this.P.b(var1, var2, this.Q);
   }

   public int a(adm var1) {
      return this.P.a(var1);
   }

   public aui a(adm var1, cj var2, pk var3, aui var4) {
      return this.P.a(var1, var2, var3, var4);
   }

   public void a(adm var1, cj var2, wn var3) {
      this.P.a(var1, var2, var3);
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.e(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      boolean var7 = this.h(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      if (var7 && this.i(var1, var2)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public static enum a implements nw {
      b("bottom");

      private final String c;
      a("top");

      private static final aju.a[] d = new aju.a[]{a, b};

      public String toString() {
         return this.c;
      }

      private a(String var3) {
         this.c = var3;
      }

      public String l() {
         return this.c;
      }
   }

   public static enum b implements nw {
      private final String f;
      private static final aju.b[] g = new aju.b[]{a, b, c, d, e};
      d("outer_left"),
      a("straight"),
      e("outer_right"),
      c("inner_right"),
      b("inner_left");

      private b(String var3) {
         this.f = var3;
      }

      public String toString() {
         return this.f;
      }

      public String l() {
         return this.f;
      }
   }
}
