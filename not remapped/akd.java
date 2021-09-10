import java.util.List;
import java.util.Random;

public class akd extends afh {
   public static final amk N = amk.a("east");
   public static final amk b = amk.a("north");
   private final boolean a;
   public static final amk O = amk.a("south");
   public static final amk P = amk.a("west");

   protected boolean I() {
      return true;
   }

   public zw a(alz var1, Random var2, int var3) {
      return !this.a ? null : super.a(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{b, N, P, O});
   }

   public adf m() {
      return adf.b;
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      boolean var7 = this.c(var1.p(var2.c()).c());
      boolean var8 = this.c(var1.p(var2.d()).c());
      boolean var9 = this.c(var1.p(var2.e()).c());
      boolean var10 = this.c(var1.p(var2.f()).c());
      if (var9 && var10 || !var9 && !var10 && !var7 && !var8) {
         this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if (var9) {
         this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      } else if (var10) {
         this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if ((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if (var7) {
            this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.a(var1, var2, var3, var4, var5, var6);
         } else if (var8) {
            this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.a(var1, var2, var3, var4, var5, var6);
         }
      } else {
         this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return var1.p(var2).c() == this ? false : super.a(var1, var2, var3);
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(b, this.c(var2.p(var3.c()).c())).a(O, this.c(var2.p(var3.d()).c())).a(P, this.c(var2.p(var3.e()).c())).a(N, this.c(var2.p(var3.f()).c()));
   }

   public int c(alz var1) {
      return 0;
   }

   public void a(adq var1, cj var2) {
      float var3 = 0.4375F;
      float var4 = 0.5625F;
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      boolean var7 = this.c(var1.p(var2.c()).c());
      boolean var8 = this.c(var1.p(var2.d()).c());
      boolean var9 = this.c(var1.p(var2.e()).c());
      boolean var10 = this.c(var1.p(var2.f()).c());
      if (var9 && var10 || !var9 && !var10 && !var7 && !var8) {
         var3 = 0.0F;
         var4 = 1.0F;
      } else if (var9) {
         var3 = 0.0F;
      } else if (var10) {
         var4 = 1.0F;
      }

      if ((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if (var7) {
            var5 = 0.0F;
         } else if (var8) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      this.a(var3, 0.0F, var5, var4, 1.0F, var6);
   }

   public boolean d() {
      return false;
   }

   protected akd(arm var1, boolean var2) {
      super(var1);
      this.j(this.M.b().a(b, false).a(N, false).a(O, false).a(P, false));
      this.a = var2;
      this.a(yz.c);
   }

   public final boolean c(afh var1) {
      return var1.o() || var1 == this || var1 == afi.w || var1 == afi.cG || var1 == afi.cH || var1 instanceof akd;
   }

   public boolean c() {
      return false;
   }
}
