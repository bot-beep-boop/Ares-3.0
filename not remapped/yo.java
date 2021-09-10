import java.util.List;
import net.minecraft.server.MinecraftServer;

public class yo extends zw {
   protected final afh a;

   public yo(afh var1) {
      this.a = var1;
   }

   public yo b(String var1) {
      super.c(var1);
      return this;
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      alz var9 = var3.p(var4);
      afh var10 = var9.c();
      if (!var10.a(var3, var4)) {
         var4 = var4.a(var5);
      }

      if (var1.b == 0) {
         return false;
      } else if (!var2.a(var4, var5, var1)) {
         return false;
      } else if (var3.a(this.a, var4, false, var5, (pk)null, var1)) {
         int var11 = this.a(var1.i());
         alz var12 = this.a.a(var3, var4, var5, var6, var7, var8, var11, var2);
         if (var3.a((cj)var4, (alz)var12, 3)) {
            var12 = var3.p(var4);
            if (var12.c() == this.a) {
               a(var3, var2, var4, var1);
               this.a.a(var3, (cj)var4, (alz)var12, (pr)var2, (zx)var1);
            }

            var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public yz c() {
      return this.a.L();
   }

   public static boolean a(adm var0, wn var1, cj var2, zx var3) {
      MinecraftServer var4 = MinecraftServer.N();
      if (var4 == null) {
         return false;
      } else {
         if (var3.n() && var3.o().b("BlockEntityTag", 10)) {
            akw var5 = var0.s(var2);
            if (var5 != null) {
               if (!var0.D && var5.F() && !var4.ap().h(var1.cd())) {
                  return false;
               }

               dn var6 = new dn();
               dn var7 = (dn)var6.b();
               var5.b(var6);
               dn var8 = (dn)var3.o().a("BlockEntityTag");
               var6.a(var8);
               var6.a("x", var2.n());
               var6.a("y", var2.o());
               var6.a("z", var2.p());
               if (!var6.equals(var7)) {
                  var5.a(var6);
                  var5.p_();
                  return true;
               }
            }
         }

         return false;
      }
   }

   public String e_(zx var1) {
      return this.a.a();
   }

   public zw c(String var1) {
      return this.b(var1);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      this.a.a(var1, var2, var3);
   }

   public afh d() {
      return this.a;
   }

   public boolean a(adm var1, cj var2, cq var3, wn var4, zx var5) {
      afh var6 = var1.p(var2).c();
      if (var6 == afi.aH) {
         var3 = cq.b;
      } else if (!var6.a(var1, var2)) {
         var2 = var2.a(var3);
      }

      return var1.a(this.a, var2, false, var3, (pk)null, var5);
   }

   public String a() {
      return this.a.a();
   }
}
