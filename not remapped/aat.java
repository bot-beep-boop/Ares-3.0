import com.mojang.authlib.GameProfile;
import java.util.List;
import java.util.UUID;

public class aat extends zw {
   private static final String[] a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};

   public String e_(zx var1) {
      int var2 = var1.i();
      if (var2 < 0 || var2 >= a.length) {
         var2 = 0;
      }

      return super.a() + "." + a[var2];
   }

   public boolean a(dn var1) {
      super.a(var1);
      if (var1.b("SkullOwner", 8) && var1.j("SkullOwner").length() > 0) {
         GameProfile var2 = new GameProfile((UUID)null, var1.j("SkullOwner"));
         var2 = alo.b(var2);
         var1.a((String)"SkullOwner", (eb)dy.a(new dn(), var2));
         return true;
      } else {
         return false;
      }
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      for(int var4 = 0; var4 < a.length; ++var4) {
         var3.add(new zx(var1, 1, var4));
      }

   }

   public int a(int var1) {
      return var1;
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 == cq.a) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         afh var10 = var9.c();
         boolean var11 = var10.a(var3, var4);
         if (!var11) {
            if (!var3.p(var4).c().t().a()) {
               return false;
            }

            var4 = var4.a(var5);
         }

         if (!var2.a(var4, var5, var1)) {
            return false;
         } else if (!afi.ce.d(var3, var4)) {
            return false;
         } else {
            if (!var3.D) {
               var3.a((cj)var4, (alz)afi.ce.Q().a(ajm.a, var5), 3);
               int var12 = 0;
               if (var5 == cq.b) {
                  var12 = ns.c((double)(var2.y * 16.0F / 360.0F) + 0.5D) & 15;
               }

               akw var13 = var3.s(var4);
               if (var13 instanceof alo) {
                  alo var14 = (alo)var13;
                  if (var1.i() == 3) {
                     GameProfile var15 = null;
                     if (var1.n()) {
                        dn var16 = var1.o();
                        if (var16.b("SkullOwner", 10)) {
                           var15 = dy.a(var16.m("SkullOwner"));
                        } else if (var16.b("SkullOwner", 8) && var16.j("SkullOwner").length() > 0) {
                           var15 = new GameProfile((UUID)null, var16.j("SkullOwner"));
                        }
                     }

                     var14.a(var15);
                  } else {
                     var14.a(var1.i());
                  }

                  var14.b(var12);
                  afi.ce.a(var3, var4, var14);
               }

               --var1.b;
            }

            return true;
         }
      }
   }

   public aat() {
      this.a((yz)yz.c);
      this.d(0);
      this.a(true);
   }

   public String a(zx var1) {
      if (var1.i() == 3 && var1.n()) {
         if (var1.o().b("SkullOwner", 8)) {
            return di.a("item.skull.player.name", var1.o().j("SkullOwner"));
         }

         if (var1.o().b("SkullOwner", 10)) {
            dn var2 = var1.o().m("SkullOwner");
            if (var2.b("Name", 8)) {
               return di.a("item.skull.player.name", var2.j("Name"));
            }
         }
      }

      return super.a(var1);
   }
}
