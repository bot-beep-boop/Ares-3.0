import java.util.Iterator;
import java.util.List;

public class up extends un {
   public boolean e(wn var1) {
      zx var2 = var1.bA();
      boolean var3 = false;
      double var4;
      List var6;
      Iterator var7;
      ps var8;
      if (var2 != null && var2.b() == zy.cn && !this.o.D) {
         var4 = 7.0D;
         var6 = this.o.a(ps.class, new aug(this.s - var4, this.t - var4, this.u - var4, this.s + var4, this.t + var4, this.u + var4));
         var7 = var6.iterator();

         while(var7.hasNext()) {
            var8 = (ps)var7.next();
            if (var8.cc() && var8.cd() == var1) {
               var8.a(this, true);
               var3 = true;
            }
         }
      }

      if (!this.o.D && !var3) {
         this.J();
         if (var1.bA.d) {
            var4 = 7.0D;
            var6 = this.o.a(ps.class, new aug(this.s - var4, this.t - var4, this.u - var4, this.s + var4, this.t + var4, this.u + var4));
            var7 = var6.iterator();

            while(var7.hasNext()) {
               var8 = (ps)var7.next();
               if (var8.cc() && var8.cd() == this) {
                  var8.a(true, false);
               }
            }
         }
      }

      return true;
   }

   public void b(pk var1) {
   }

   public boolean a(double var1) {
      return var1 < 1024.0D;
   }

   public void b(dn var1) {
   }

   public boolean d(dn var1) {
      return false;
   }

   public up(adm var1) {
      super(var1);
   }

   protected void h() {
      super.h();
   }

   public void a(dn var1) {
   }

   public static up a(adm var0, cj var1) {
      up var2 = new up(var0, var1);
      var2.n = true;
      var0.d((pk)var2);
      return var2;
   }

   public up(adm var1, cj var2) {
      super(var1, var2);
      this.b((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D);
      float var3 = 0.125F;
      float var4 = 0.1875F;
      float var5 = 0.25F;
      this.a((aug)(new aug(this.s - 0.1875D, this.t - 0.25D + 0.125D, this.u - 0.1875D, this.s + 0.1875D, this.t + 0.25D + 0.125D, this.u + 0.1875D)));
   }

   public int l() {
      return 9;
   }

   public void a(cq var1) {
   }

   public float aS() {
      return -0.0625F;
   }

   public int m() {
      return 9;
   }

   public static up b(adm var0, cj var1) {
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      List var5 = var0.a(up.class, new aug((double)var2 - 1.0D, (double)var3 - 1.0D, (double)var4 - 1.0D, (double)var2 + 1.0D, (double)var3 + 1.0D, (double)var4 + 1.0D));
      Iterator var6 = var5.iterator();

      up var7;
      do {
         if (!var6.hasNext()) {
            return null;
         }

         var7 = (up)var6.next();
      } while(!var7.n().equals(var1));

      return var7;
   }

   public boolean j() {
      return this.o.p(this.a).c() instanceof agt;
   }
}
