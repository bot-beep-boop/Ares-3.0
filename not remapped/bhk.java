import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.util.Map;
import java.util.UUID;

public class bhk extends bhd<alo> {
   private final bbz h = new bbz(0, 0, 64, 32);
   private final bbz i = new bbi();
   public static bhk c;
   private static final jy f = new jy("textures/entity/zombie/zombie.png");
   private static final jy e = new jy("textures/entity/skeleton/wither_skeleton.png");
   private static final jy g = new jy("textures/entity/creeper/creeper.png");
   private static final jy d = new jy("textures/entity/skeleton/skeleton.png");

   public void a(alo var1, double var2, double var4, double var6, float var8, int var9) {
      cq var10 = cq.a(var1.u() & 7);
      this.a((float)var2, (float)var4, (float)var6, var10, (float)(var1.d() * 360) / 16.0F, var1.c(), var1.b(), var9);
   }

   public void a(bhc var1) {
      super.a(var1);
      c = this;
   }

   public void a(float var1, float var2, float var3, cq var4, float var5, int var6, GameProfile var7, int var8) {
      bbz var9 = this.h;
      if (var8 >= 0) {
         this.a(a[var8]);
         bfl.n(5890);
         bfl.E();
         bfl.a(4.0F, 2.0F, 1.0F);
         bfl.b(0.0625F, 0.0625F, 0.0625F);
         bfl.n(5888);
      } else {
         switch(var6) {
         case 0:
         default:
            this.a(d);
            break;
         case 1:
            this.a(e);
            break;
         case 2:
            this.a(f);
            var9 = this.i;
            break;
         case 3:
            var9 = this.i;
            jy var10 = bmz.a();
            if (var7 != null) {
               ave var11 = ave.A();
               Map var12 = var11.ab().a(var7);
               if (var12.containsKey(Type.SKIN)) {
                  var10 = var11.ab().a((MinecraftProfileTexture)var12.get(Type.SKIN), Type.SKIN);
               } else {
                  UUID var13 = wn.a(var7);
                  var10 = bmz.a(var13);
               }
            }

            this.a(var10);
            break;
         case 4:
            this.a(g);
         }
      }

      bfl.E();
      bfl.p();
      if (var4 != cq.b) {
         switch(var4) {
         case c:
            bfl.b(var1 + 0.5F, var2 + 0.25F, var3 + 0.74F);
            break;
         case d:
            bfl.b(var1 + 0.5F, var2 + 0.25F, var3 + 0.26F);
            var5 = 180.0F;
            break;
         case e:
            bfl.b(var1 + 0.74F, var2 + 0.25F, var3 + 0.5F);
            var5 = 270.0F;
            break;
         case f:
         default:
            bfl.b(var1 + 0.26F, var2 + 0.25F, var3 + 0.5F);
            var5 = 90.0F;
         }
      } else {
         bfl.b(var1 + 0.5F, var2, var3 + 0.5F);
      }

      float var14 = 0.0625F;
      bfl.B();
      bfl.a(-1.0F, -1.0F, 1.0F);
      bfl.d();
      var9.a((pk)null, 0.0F, 0.0F, 0.0F, var5, 0.0F, var14);
      bfl.F();
      if (var8 >= 0) {
         bfl.n(5890);
         bfl.F();
         bfl.n(5888);
      }

   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((alo)var1, var2, var4, var6, var8, var9);
   }
}
