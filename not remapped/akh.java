import com.google.common.base.Predicate;

public class akh extends afh {
   public static final amk b;
   public static final aml a;
   public static final amm<akh.a> N;

   protected akh(arm var1) {
      super(var1);
      this.j(this.M.b().a(a, cq.c).a(b, false).a(N, akh.a.b));
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.a(yz.d);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         cj var5 = var2.a(((cq)var3.b(a)).d());
         if (!c(var1.p(var5).c())) {
            var1.g(var2);
            this.b(var1, var2, var3, 0);
         } else {
            boolean var6 = var1.z(var2);
            if (var6 || var4.i()) {
               boolean var7 = (Boolean)var3.b(b);
               if (var7 != var6) {
                  var1.a((cj)var2, (alz)var3.a(b, var6), 2);
                  var1.a((wn)null, var6 ? 1003 : 1006, var2, 0);
               }
            }

         }
      }
   }

   public boolean b(adq var1, cj var2) {
      return !(Boolean)var1.p(var2).b(b);
   }

   public void d(alz var1) {
      if (var1.c() == this) {
         boolean var2 = var1.b(N) == akh.a.a;
         Boolean var3 = (Boolean)var1.b(b);
         cq var4 = (cq)var1.b(a);
         float var5 = 0.1875F;
         if (var2) {
            this.a(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
         }

         if (var3) {
            if (var4 == cq.c) {
               this.a(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
            }

            if (var4 == cq.d) {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
            }

            if (var4 == cq.e) {
               this.a(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if (var4 == cq.f) {
               this.a(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
            }
         }

      }
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amk.a("open");
      N = amm.a("half", akh.a.class);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = this.Q();
      if (var3.k().c()) {
         var9 = var9.a(a, var3).a(b, false);
         var9 = var9.a(N, var5 > 0.5F ? akh.a.a : akh.a.b);
      }

      return var9;
   }

   public adf m() {
      return adf.c;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (this.J == arm.f) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.a((cj)var2, (alz)var3, 2);
         var1.a(var4, (Boolean)var3.b(b) ? 1003 : 1006, var2, 0);
         return true;
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N});
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   private static boolean c(afh var0) {
      return var0.J.k() && var0.d() || var0 == afi.aX || var0 instanceof ahh || var0 instanceof aju;
   }

   protected static int a(cq var0) {
      switch(var0) {
      case c:
         return 0;
      case d:
         return 1;
      case e:
         return 2;
      case f:
      default:
         return 3;
      }
   }

   public boolean c() {
      return false;
   }

   protected static cq b(int var0) {
      switch(var0 & 3) {
      case 0:
         return cq.c;
      case 1:
         return cq.d;
      case 2:
         return cq.e;
      case 3:
      default:
         return cq.f;
      }
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public alz a(int var1) {
      return this.Q().a(a, b(var1)).a(b, (var1 & 4) != 0).a(N, (var1 & 8) == 0 ? akh.a.b : akh.a.a);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | a((cq)var1.b(a));
      if ((Boolean)var1.b(b)) {
         var3 |= 4;
      }

      if (var1.b(N) == akh.a.a) {
         var3 |= 8;
      }

      return var3;
   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   public void a(adq var1, cj var2) {
      this.d(var1.p(var2));
   }

   public void j() {
      float var1 = 0.1875F;
      this.a(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
   }

   public boolean b(adm var1, cj var2, cq var3) {
      return !var3.k().b() && c(var1.p(var2.a(var3.d())).c());
   }

   public boolean d() {
      return false;
   }

   public static enum a implements nw {
      b("bottom");

      private final String c;
      a("top");

      private static final akh.a[] d = new akh.a[]{a, b};

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
}
