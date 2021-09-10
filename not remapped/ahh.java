import java.util.List;
import java.util.Random;

public abstract class ahh extends afh {
   public static final amm<ahh.a> a = amm.a("half", ahh.a.class);

   public boolean d() {
      return this.l();
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public ahh(arm var1) {
      super(var1);
      if (this.l()) {
         this.r = true;
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.e(255);
   }

   public abstract amo<?> n();

   public abstract String b(int var1);

   public void a(adq var1, cj var2) {
      if (this.l()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         alz var3 = var1.p(var2);
         if (var3.c() == this) {
            if (var3.b(a) == ahh.a.a) {
               this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
         }

      }
   }

   public boolean a(adq var1, cj var2, cq var3) {
      if (this.l()) {
         return super.a(var1, var2, var3);
      } else if (var3 != cq.b && var3 != cq.a && !super.a(var1, var2, var3)) {
         return false;
      } else {
         cj var4 = var2.a(var3.d());
         alz var5 = var1.p(var2);
         alz var6 = var1.p(var4);
         boolean var7 = c(var5.c()) && var5.b(a) == ahh.a.a;
         boolean var8 = c(var6.c()) && var6.b(a) == ahh.a.a;
         if (var8) {
            if (var3 == cq.a) {
               return true;
            } else if (var3 == cq.b && super.a(var1, var2, var3)) {
               return true;
            } else {
               return !c(var5.c()) || !var7;
            }
         } else if (var3 == cq.b) {
            return true;
         } else if (var3 == cq.a && super.a(var1, var2, var3)) {
            return true;
         } else {
            return !c(var5.c()) || var7;
         }
      }
   }

   public void j() {
      if (this.l()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   protected static boolean c(afh var0) {
      return var0 == afi.U || var0 == afi.bM || var0 == afi.cP;
   }

   public int j(adm var1, cj var2) {
      return super.j(var1, var2) & 7;
   }

   public int a(Random var1) {
      return this.l() ? 2 : 1;
   }

   protected boolean I() {
      return false;
   }

   public abstract Object a(zx var1);

   public abstract boolean l();

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, ahh.a.b);
      if (this.l()) {
         return var9;
      } else {
         return var3 != cq.a && (var3 == cq.b || !((double)var5 > 0.5D)) ? var9 : var9.a(a, ahh.a.a);
      }
   }

   public boolean c() {
      return this.l();
   }

   public static enum a implements nw {
      private final String c;
      b("bottom");

      private static final ahh.a[] d = new ahh.a[]{a, b};
      a("top");

      public String l() {
         return this.c;
      }

      public String toString() {
         return this.c;
      }

      private a(String var3) {
         this.c = var3;
      }
   }
}
