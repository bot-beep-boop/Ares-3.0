import com.google.common.collect.Lists;
import java.util.List;

public class aii extends afc {
   private static final List<String> a = Lists.newArrayList(new String[]{"harp", "bd", "snare", "hat", "bassattack"});

   public int b() {
      return 3;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      boolean var5 = var1.z(var2);
      akw var6 = var1.s(var2);
      if (var6 instanceof alm) {
         alm var7 = (alm)var6;
         if (var7.f != var5) {
            if (var5) {
               var7.a(var1, var2);
            }

            var7.f = var5;
         }
      }

   }

   private String b(int var1) {
      if (var1 < 0 || var1 >= a.size()) {
         var1 = 0;
      }

      return (String)a.get(var1);
   }

   public void a(adm var1, cj var2, wn var3) {
      if (!var1.D) {
         akw var4 = var1.s(var2);
         if (var4 instanceof alm) {
            ((alm)var4).a(var1, var2);
            var3.b(na.R);
         }

      }
   }

   public boolean a(adm var1, cj var2, alz var3, int var4, int var5) {
      float var6 = (float)Math.pow(2.0D, (double)(var5 - 12) / 12.0D);
      var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "note." + this.b(var4), 3.0F, var6);
      var1.a(cy.x, (double)var2.n() + 0.5D, (double)var2.o() + 1.2D, (double)var2.p() + 0.5D, (double)var5 / 24.0D, 0.0D, 0.0D);
      return true;
   }

   public aii() {
      super(arm.d);
      this.a(yz.d);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof alm) {
            alm var10 = (alm)var9;
            var10.b();
            var10.a(var1, var2);
            var4.b(na.S);
         }

         return true;
      }
   }

   public akw a(adm var1, int var2) {
      return new alm();
   }
}
