import java.util.Random;

public class afw extends afc {
   public static final amk a = amk.a("triggered");

   public void b(adm var1, cj var2, alz var3, Random var4) {
      akw var5 = var1.s(var2);
      if (var5 instanceof akz) {
         ((akz)var5).b().a(var1);
         var1.e(var2, this);
      }

   }

   public int a(adm var1) {
      return 1;
   }

   public akw a(adm var1, int var2) {
      return new akz();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int a(Random var1) {
      return 0;
   }

   public afw() {
      super(arm.f, arn.q);
      this.j(this.M.b().a(a, false));
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      akw var6 = var1.s(var2);
      if (var6 instanceof akz) {
         adc var7 = ((akz)var6).b();
         if (var5.s()) {
            var7.b(var5.q());
         }

         if (!var1.D) {
            var7.a(var1.Q().b("sendCommandFeedback"));
         }

      }
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 1) > 0);
   }

   public boolean O() {
      return true;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, false);
   }

   public int b() {
      return 3;
   }

   public int l(adm var1, cj var2) {
      akw var3 = var1.s(var2);
      return var3 instanceof akz ? ((akz)var3).b().j() : 0;
   }

   public int c(alz var1) {
      int var2 = 0;
      if ((Boolean)var1.b(a)) {
         var2 |= 1;
      }

      return var2;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      akw var9 = var1.s(var2);
      return var9 instanceof akz ? ((akz)var9).b().a(var4) : false;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         boolean var5 = var1.z(var2);
         boolean var6 = (Boolean)var3.b(a);
         if (var5 && !var6) {
            var1.a((cj)var2, (alz)var3.a(a, true), 4);
            var1.a((cj)var2, (afh)this, this.a(var1));
         } else if (!var5 && var6) {
            var1.a((cj)var2, (alz)var3.a(a, false), 4);
         }
      }

   }
}
