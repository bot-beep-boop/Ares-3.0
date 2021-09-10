import java.util.Random;

public class ajc extends afh {
   private final boolean a;

   public void c(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         if (this.a && !var1.z(var2)) {
            var1.a((cj)var2, (alz)afi.bJ.Q(), 2);
         } else if (!this.a && var1.z(var2)) {
            var1.a((cj)var2, (alz)afi.bK.Q(), 2);
         }

      }
   }

   protected zx i(alz var1) {
      return new zx(afi.bJ);
   }

   public zw c(adm var1, cj var2) {
      return zw.a(afi.bJ);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         if (this.a && !var1.z(var2)) {
            var1.a((cj)var2, (afh)this, 4);
         } else if (!this.a && var1.z(var2)) {
            var1.a((cj)var2, (alz)afi.bK.Q(), 2);
         }

      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if (this.a && !var1.z(var2)) {
            var1.a((cj)var2, (alz)afi.bJ.Q(), 2);
         }

      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(afi.bJ);
   }

   public ajc(boolean var1) {
      super(arm.t);
      this.a = var1;
      if (var1) {
         this.a(1.0F);
      }

   }
}
