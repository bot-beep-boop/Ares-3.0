import java.util.List;
import java.util.Random;

public class alt extends afh {
   public static final aml a = aml.a("facing");
   public static final amk N = amk.a("short");
   public static final amm<alt.a> b = amm.a("type", alt.a.class);

   protected ama e() {
      return new ama(this, new amo[]{a, b, N});
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      cq var5 = (cq)var3.b(a);
      cj var6 = var2.a(var5.d());
      alz var7 = var1.p(var6);
      if (var7.c() != afi.J && var7.c() != afi.F) {
         var1.g(var2);
      } else {
         var7.c().a(var1, var6, var7, var4);
      }

   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public void a(adq var1, cj var2) {
      this.d(var1.p(var2));
   }

   public alz a(int var1) {
      return this.Q().a(a, b(var1)).a(b, (var1 & 8) > 0 ? alt.a.b : alt.a.a);
   }

   public zw c(adm var1, cj var2) {
      return var1.p(var2).b(b) == alt.a.b ? zw.a((afh)afi.F) : zw.a((afh)afi.J);
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      cq var4 = ((cq)var3.b(a)).d();
      var2 = var2.a(var4);
      alz var5 = var1.p(var2);
      if ((var5.c() == afi.J || var5.c() == afi.F) && (Boolean)var5.b(als.b)) {
         var5.c().b(var1, var2, var5, 0);
         var1.g(var2);
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public alt() {
      super(arm.H);
      this.j(this.M.b().a(a, cq.c).a(b, alt.a.a).a(N, false));
      this.a(i);
      this.c(0.5F);
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.d(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.e(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean d(adm var1, cj var2) {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      if (var4.bA.d) {
         cq var5 = (cq)var3.b(a);
         if (var5 != null) {
            cj var6 = var2.a(var5.d());
            afh var7 = var1.p(var6).c();
            if (var7 == afi.J || var7 == afi.F) {
               var1.g(var6);
            }
         }
      }

      super.a(var1, var2, var3, var4);
   }

   public void d(alz var1) {
      float var2 = 0.25F;
      cq var3 = (cq)var1.b(a);
      if (var3 != null) {
         switch(var3) {
         case a:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
         case b:
            this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case c:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
         case d:
            this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
         case e:
            this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
         case f:
            this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   public boolean b(adm var1, cj var2, cq var3) {
      return false;
   }

   public boolean d() {
      return false;
   }

   public static cq b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5 ? null : cq.a(var1);
   }

   public boolean c() {
      return false;
   }

   private void e(alz var1) {
      float var2 = 0.25F;
      float var3 = 0.375F;
      float var4 = 0.625F;
      float var5 = 0.25F;
      float var6 = 0.75F;
      switch((cq)var1.b(a)) {
      case a:
         this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         break;
      case b:
         this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         break;
      case c:
         this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         break;
      case d:
         this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         break;
      case e:
         this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         break;
      case f:
         this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
      }

   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if (var1.b(b) == alt.a.b) {
         var3 |= 8;
      }

      return var3;
   }

   public static enum a implements nw {
      private static final alt.a[] d = new alt.a[]{a, b};
      private final String c;
      a("normal"),
      b("sticky");

      private a(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String l() {
         return this.c;
      }
   }
}
