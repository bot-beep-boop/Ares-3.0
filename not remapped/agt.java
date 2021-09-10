import java.util.List;

public class agt extends afh {
   public static final amk O = amk.a("west");
   public static final amk b = amk.a("east");
   public static final amk N = amk.a("south");
   public static final amk a = amk.a("north");

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      return var1.D ? true : zz.a(var4, var1, var2);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public boolean b(adq var1, cj var2) {
      return false;
   }

   public boolean d() {
      return false;
   }

   public agt(arm var1) {
      this(var1, var1.r());
   }

   public agt(arm var1, arn var2) {
      super(var1, var2);
      this.j(this.M.b().a(a, false).a(b, false).a(N, false).a(O, false));
      this.a(yz.c);
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      boolean var7 = this.e(var1, var2.c());
      boolean var8 = this.e(var1, var2.d());
      boolean var9 = this.e(var1, var2.e());
      boolean var10 = this.e(var1, var2.f());
      float var11 = 0.375F;
      float var12 = 0.625F;
      float var13 = 0.375F;
      float var14 = 0.625F;
      if (var7) {
         var13 = 0.0F;
      }

      if (var8) {
         var14 = 1.0F;
      }

      if (var7 || var8) {
         this.a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      var13 = 0.375F;
      var14 = 0.625F;
      if (var9) {
         var11 = 0.0F;
      }

      if (var10) {
         var12 = 1.0F;
      }

      if (var9 || var10 || !var7 && !var8) {
         this.a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if (var7) {
         var13 = 0.0F;
      }

      if (var8) {
         var14 = 1.0F;
      }

      this.a(var11, 0.0F, var13, var12, 1.0F, var14);
   }

   public boolean c() {
      return false;
   }

   public void a(adq var1, cj var2) {
      boolean var3 = this.e(var1, var2.c());
      boolean var4 = this.e(var1, var2.d());
      boolean var5 = this.e(var1, var2.e());
      boolean var6 = this.e(var1, var2.f());
      float var7 = 0.375F;
      float var8 = 0.625F;
      float var9 = 0.375F;
      float var10 = 0.625F;
      if (var3) {
         var9 = 0.0F;
      }

      if (var4) {
         var10 = 1.0F;
      }

      if (var5) {
         var7 = 0.0F;
      }

      if (var6) {
         var8 = 1.0F;
      }

      this.a(var7, 0.0F, var9, var8, 1.0F, var10);
   }

   public int c(alz var1) {
      return 0;
   }

   public boolean e(adq var1, cj var2) {
      afh var3 = var1.p(var2).c();
      if (var3 == afi.cv) {
         return false;
      } else if ((!(var3 instanceof agt) || var3.J != this.J) && !(var3 instanceof agu)) {
         if (var3.J.k() && var3.d()) {
            return var3.J != arm.C;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(a, this.e(var2, var3.c())).a(b, this.e(var2, var3.f())).a(N, this.e(var2, var3.d())).a(O, this.e(var2, var3.e()));
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, O, N});
   }
}
