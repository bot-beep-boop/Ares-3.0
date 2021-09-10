import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class bks implements blb<pr> {
   private final bct a;

   public boolean b() {
      return true;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      zx var9 = var1.q(3);
      if (var9 != null && var9.b() != null) {
         zw var10 = var9.b();
         ave var11 = ave.A();
         bfl.E();
         if (var1.av()) {
            bfl.b(0.0F, 0.2F, 0.0F);
         }

         boolean var12 = var1 instanceof wi || var1 instanceof we && ((we)var1).co();
         float var13;
         if (!var12 && var1.j_()) {
            var13 = 2.0F;
            float var14 = 1.4F;
            bfl.a(var14 / var13, var14 / var13, var14 / var13);
            bfl.b(0.0F, 16.0F * var8, 0.0F);
         }

         this.a.c(0.0625F);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         if (var10 instanceof yo) {
            var13 = 0.625F;
            bfl.b(0.0F, -0.25F, 0.0F);
            bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            bfl.a(var13, -var13, -var13);
            if (var12) {
               bfl.b(0.0F, 0.1875F, 0.0F);
            }

            var11.ah().a(var1, var9, bgr.b.d);
         } else if (var10 == zy.bX) {
            var13 = 1.1875F;
            bfl.a(var13, -var13, -var13);
            if (var12) {
               bfl.b(0.0F, 0.0625F, 0.0F);
            }

            GameProfile var17 = null;
            if (var9.n()) {
               dn var15 = var9.o();
               if (var15.b("SkullOwner", 10)) {
                  var17 = dy.a(var15.m("SkullOwner"));
               } else if (var15.b("SkullOwner", 8)) {
                  String var16 = var15.j("SkullOwner");
                  if (!nx.b(var16)) {
                     var17 = alo.b(new GameProfile((UUID)null, var16));
                     var15.a((String)"SkullOwner", (eb)dy.a(new dn(), var17));
                  }
               }
            }

            bhk.c.a(-0.5F, 0.0F, -0.5F, cq.b, 180.0F, var9.i(), var17, -1);
         }

         bfl.F();
      }
   }

   public bks(bct var1) {
      this.a = var1;
   }
}
