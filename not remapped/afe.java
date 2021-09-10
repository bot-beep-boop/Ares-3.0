import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class afe extends afh {
   protected final boolean a;

   public void c(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         var3 = this.a(var1, var2, var3, true);
         if (this.a) {
            this.a(var1, var2, (alz)var3, (afh)this);
         }
      }

   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public int k() {
      return 0;
   }

   public static boolean e(adm var0, cj var1) {
      return d(var0.p(var1));
   }

   protected void b(adm var1, cj var2, alz var3, afh var4) {
   }

   public static boolean d(alz var0) {
      afh var1 = var0.c();
      return var1 == afi.av || var1 == afi.D || var1 == afi.E || var1 == afi.cs;
   }

   public boolean d(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2.b());
   }

   public abstract amo<afe.b> n();

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         afe.b var5 = (afe.b)var3.b(this.n());
         boolean var6 = false;
         if (!adm.a((adq)var1, (cj)var2.b())) {
            var6 = true;
         }

         if (var5 == afe.b.c && !adm.a((adq)var1, (cj)var2.f())) {
            var6 = true;
         } else if (var5 == afe.b.d && !adm.a((adq)var1, (cj)var2.e())) {
            var6 = true;
         } else if (var5 == afe.b.e && !adm.a((adq)var1, (cj)var2.c())) {
            var6 = true;
         } else if (var5 == afe.b.f && !adm.a((adq)var1, (cj)var2.d())) {
            var6 = true;
         }

         if (var6) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         } else {
            this.b(var1, var2, var3, var4);
         }

      }
   }

   protected alz a(adm var1, cj var2, alz var3, boolean var4) {
      return var1.D ? var3 : (new afe.a(this, var1, var2, var3)).a(var1.z(var2), var4).b();
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      if (((afe.b)var3.b(this.n())).c()) {
         var1.c((cj)var2.a(), (afh)this);
      }

      if (this.a) {
         var1.c((cj)var2, (afh)this);
         var1.c((cj)var2.b(), (afh)this);
      }

   }

   public boolean c() {
      return false;
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      afe.b var4 = var3.c() == this ? (afe.b)var3.b(this.n()) : null;
      if (var4 != null && var4.c()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   protected afe(boolean var1) {
      super(arm.q);
      this.a = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(yz.e);
   }

   public adf m() {
      return adf.c;
   }

   public static enum b implements nw {
      i(8, "north_west"),
      j(9, "north_east"),
      d(3, "ascending_west"),
      a(0, "north_south"),
      b(1, "east_west");

      private static final afe.b[] n = new afe.b[]{a, b, c, d, e, f, g, h, i, j};
      e(4, "ascending_north"),
      c(2, "ascending_east"),
      g(6, "south_east");

      private final String m;
      private final int l;
      h(7, "south_west"),
      f(5, "ascending_south");

      private static final afe.b[] k = new afe.b[values().length];

      public String l() {
         return this.m;
      }

      public int a() {
         return this.l;
      }

      public static afe.b a(int var0) {
         if (var0 < 0 || var0 >= k.length) {
            var0 = 0;
         }

         return k[var0];
      }

      public boolean c() {
         return this == e || this == c || this == f || this == d;
      }

      private b(int var3, String var4) {
         this.l = var3;
         this.m = var4;
      }

      public String toString() {
         return this.m;
      }

      static {
         afe.b[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            afe.b var3 = var0[var2];
            k[var3.a()] = var3;
         }

      }
   }

   public class a {
      private alz e;
      private final afe d;
      private final adm b;
      final afe a;
      private final List<cj> g;
      private final boolean f;
      private final cj c;

      private afe.a b(cj var1) {
         alz var3 = this.b.p(var1);
         if (afe.d(var3)) {
            return this.a.new a(this.a, this.b, var1, var3);
         } else {
            cj var2 = var1.a();
            var3 = this.b.p(var2);
            if (afe.d(var3)) {
               return this.a.new a(this.a, this.b, var2, var3);
            } else {
               var2 = var1.b();
               var3 = this.b.p(var2);
               return afe.d(var3) ? this.a.new a(this.a, this.b, var2, var3) : null;
            }
         }
      }

      private boolean d(cj var1) {
         afe.a var2 = this.b(var1);
         if (var2 == null) {
            return false;
         } else {
            var2.c();
            return var2.b(this);
         }
      }

      private boolean a(cj var1) {
         return afe.e(this.b, var1) || afe.e(this.b, var1.a()) || afe.e(this.b, var1.b());
      }

      private void c() {
         for(int var1 = 0; var1 < this.g.size(); ++var1) {
            afe.a var2 = this.b((cj)this.g.get(var1));
            if (var2 != null && var2.a(this)) {
               this.g.set(var1, var2.c);
            } else {
               this.g.remove(var1--);
            }
         }

      }

      private boolean a(afe.a var1) {
         return this.c(var1.c);
      }

      private void c(afe.a var1) {
         this.g.add(var1.c);
         cj var2 = this.c.c();
         cj var3 = this.c.d();
         cj var4 = this.c.e();
         cj var5 = this.c.f();
         boolean var6 = this.c(var2);
         boolean var7 = this.c(var3);
         boolean var8 = this.c(var4);
         boolean var9 = this.c(var5);
         afe.b var10 = null;
         if (var6 || var7) {
            var10 = afe.b.a;
         }

         if (var8 || var9) {
            var10 = afe.b.b;
         }

         if (!this.f) {
            if (var7 && var9 && !var6 && !var8) {
               var10 = afe.b.g;
            }

            if (var7 && var8 && !var6 && !var9) {
               var10 = afe.b.h;
            }

            if (var6 && var8 && !var7 && !var9) {
               var10 = afe.b.i;
            }

            if (var6 && var9 && !var7 && !var8) {
               var10 = afe.b.j;
            }
         }

         if (var10 == afe.b.a) {
            if (afe.e(this.b, var2.a())) {
               var10 = afe.b.e;
            }

            if (afe.e(this.b, var3.a())) {
               var10 = afe.b.f;
            }
         }

         if (var10 == afe.b.b) {
            if (afe.e(this.b, var5.a())) {
               var10 = afe.b.c;
            }

            if (afe.e(this.b, var4.a())) {
               var10 = afe.b.d;
            }
         }

         if (var10 == null) {
            var10 = afe.b.a;
         }

         this.e = this.e.a(this.d.n(), var10);
         this.b.a((cj)this.c, (alz)this.e, 3);
      }

      private boolean b(afe.a var1) {
         return this.a(var1) || this.g.size() != 2;
      }

      protected int a() {
         int var1 = 0;
         Iterator var2 = cq.c.a.iterator();

         while(var2.hasNext()) {
            cq var3 = (cq)var2.next();
            if (this.a(this.c.a(var3))) {
               ++var1;
            }
         }

         return var1;
      }

      private void a(afe.b var1) {
         this.g.clear();
         switch(var1) {
         case a:
            this.g.add(this.c.c());
            this.g.add(this.c.d());
            break;
         case b:
            this.g.add(this.c.e());
            this.g.add(this.c.f());
            break;
         case c:
            this.g.add(this.c.e());
            this.g.add(this.c.f().a());
            break;
         case d:
            this.g.add(this.c.e().a());
            this.g.add(this.c.f());
            break;
         case e:
            this.g.add(this.c.c().a());
            this.g.add(this.c.d());
            break;
         case f:
            this.g.add(this.c.c());
            this.g.add(this.c.d().a());
            break;
         case g:
            this.g.add(this.c.f());
            this.g.add(this.c.d());
            break;
         case h:
            this.g.add(this.c.e());
            this.g.add(this.c.d());
            break;
         case i:
            this.g.add(this.c.e());
            this.g.add(this.c.c());
            break;
         case j:
            this.g.add(this.c.f());
            this.g.add(this.c.c());
         }

      }

      public afe.a a(boolean var1, boolean var2) {
         cj var3 = this.c.c();
         cj var4 = this.c.d();
         cj var5 = this.c.e();
         cj var6 = this.c.f();
         boolean var7 = this.d(var3);
         boolean var8 = this.d(var4);
         boolean var9 = this.d(var5);
         boolean var10 = this.d(var6);
         afe.b var11 = null;
         if ((var7 || var8) && !var9 && !var10) {
            var11 = afe.b.a;
         }

         if ((var9 || var10) && !var7 && !var8) {
            var11 = afe.b.b;
         }

         if (!this.f) {
            if (var8 && var10 && !var7 && !var9) {
               var11 = afe.b.g;
            }

            if (var8 && var9 && !var7 && !var10) {
               var11 = afe.b.h;
            }

            if (var7 && var9 && !var8 && !var10) {
               var11 = afe.b.i;
            }

            if (var7 && var10 && !var8 && !var9) {
               var11 = afe.b.j;
            }
         }

         if (var11 == null) {
            if (var7 || var8) {
               var11 = afe.b.a;
            }

            if (var9 || var10) {
               var11 = afe.b.b;
            }

            if (!this.f) {
               if (var1) {
                  if (var8 && var10) {
                     var11 = afe.b.g;
                  }

                  if (var9 && var8) {
                     var11 = afe.b.h;
                  }

                  if (var10 && var7) {
                     var11 = afe.b.j;
                  }

                  if (var7 && var9) {
                     var11 = afe.b.i;
                  }
               } else {
                  if (var7 && var9) {
                     var11 = afe.b.i;
                  }

                  if (var10 && var7) {
                     var11 = afe.b.j;
                  }

                  if (var9 && var8) {
                     var11 = afe.b.h;
                  }

                  if (var8 && var10) {
                     var11 = afe.b.g;
                  }
               }
            }
         }

         if (var11 == afe.b.a) {
            if (afe.e(this.b, var3.a())) {
               var11 = afe.b.e;
            }

            if (afe.e(this.b, var4.a())) {
               var11 = afe.b.f;
            }
         }

         if (var11 == afe.b.b) {
            if (afe.e(this.b, var6.a())) {
               var11 = afe.b.c;
            }

            if (afe.e(this.b, var5.a())) {
               var11 = afe.b.d;
            }
         }

         if (var11 == null) {
            var11 = afe.b.a;
         }

         this.a(var11);
         this.e = this.e.a(this.d.n(), var11);
         if (var2 || this.b.p(this.c) != this.e) {
            this.b.a((cj)this.c, (alz)this.e, 3);

            for(int var12 = 0; var12 < this.g.size(); ++var12) {
               afe.a var13 = this.b((cj)this.g.get(var12));
               if (var13 != null) {
                  var13.c();
                  if (var13.b(this)) {
                     var13.c(this);
                  }
               }
            }
         }

         return this;
      }

      public a(afe var1, adm var2, cj var3, alz var4) {
         this.a = var1;
         this.g = Lists.newArrayList();
         this.b = var2;
         this.c = var3;
         this.e = var4;
         this.d = (afe)var4.c();
         afe.b var5 = (afe.b)var4.b(var1.n());
         this.f = this.d.a;
         this.a(var5);
      }

      public alz b() {
         return this.e;
      }

      private boolean c(cj var1) {
         for(int var2 = 0; var2 < this.g.size(); ++var2) {
            cj var3 = (cj)this.g.get(var2);
            if (var3.n() == var1.n() && var3.p() == var1.p()) {
               return true;
            }
         }

         return false;
      }
   }
}
