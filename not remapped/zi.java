import java.util.List;
import java.util.Random;

public class zi extends zw {
   public void a(zx var1, acl var2) {
      du var3 = this.h(var1);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.c(); ++var5) {
         dn var6 = var3.b(var5);
         if (var6.e("id") == var2.b.B) {
            if (var6.e("lvl") < var2.c) {
               var6.a("lvl", (short)var2.c);
            }

            var4 = false;
            break;
         }
      }

      if (var4) {
         dn var7 = new dn();
         var7.a("id", (short)var2.b.B);
         var7.a("lvl", (short)var2.c);
         var3.a((eb)var7);
      }

      if (!var1.n()) {
         var1.d(new dn());
      }

      var1.o().a((String)"StoredEnchantments", (eb)var3);
   }

   public du h(zx var1) {
      dn var2 = var1.o();
      return var2 != null && var2.b("StoredEnchantments", 9) ? (du)var2.a("StoredEnchantments") : new du();
   }

   public boolean f_(zx var1) {
      return false;
   }

   public void a(aci var1, List<zx> var2) {
      for(int var3 = var1.e(); var3 <= var1.b(); ++var3) {
         var2.add(this.a(new acl(var1, var3)));
      }

   }

   public ob a(Random var1, int var2, int var3, int var4) {
      zx var5 = new zx(zy.aL, 1, 0);
      ack.a(var1, var5, 30);
      return new ob(var5, var2, var3, var4);
   }

   public zx a(acl var1) {
      zx var2 = new zx(this);
      this.a(var2, var1);
      return var2;
   }

   public ob b(Random var1) {
      return this.a(var1, 1, 1, 1);
   }

   public aaj g(zx var1) {
      return this.h(var1).c() > 0 ? aaj.b : super.g(var1);
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      super.a(var1, var2, var3, var4);
      du var5 = this.h(var1);
      if (var5 != null) {
         for(int var6 = 0; var6 < var5.c(); ++var6) {
            short var7 = var5.b(var6).e("id");
            short var8 = var5.b(var6).e("lvl");
            if (aci.c(var7) != null) {
               var3.add(aci.c(var7).d(var8));
            }
         }
      }

   }

   public boolean f(zx var1) {
      return true;
   }
}
