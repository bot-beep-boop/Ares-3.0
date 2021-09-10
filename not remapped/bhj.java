import java.util.List;
import org.lwjgl.opengl.GL11;

public class bhj extends bhd<aln> {
   private static final jy c = new jy("textures/entity/sign.png");
   private final bbx d = new bbx();

   public void a(aln var1, double var2, double var4, double var6, float var8, int var9) {
      afh var10 = var1.w();
      bfl.E();
      float var11 = 0.6666667F;
      float var13;
      if (var10 == afi.an) {
         bfl.b((float)var2 + 0.5F, (float)var4 + 0.75F * var11, (float)var6 + 0.5F);
         float var12 = (float)(var1.u() * 360) / 16.0F;
         bfl.b(-var12, 0.0F, 1.0F, 0.0F);
         this.d.b.j = true;
      } else {
         int var19 = var1.u();
         var13 = 0.0F;
         if (var19 == 2) {
            var13 = 180.0F;
         }

         if (var19 == 4) {
            var13 = 90.0F;
         }

         if (var19 == 5) {
            var13 = -90.0F;
         }

         bfl.b((float)var2 + 0.5F, (float)var4 + 0.75F * var11, (float)var6 + 0.5F);
         bfl.b(-var13, 0.0F, 1.0F, 0.0F);
         bfl.b(0.0F, -0.3125F, -0.4375F);
         this.d.b.j = false;
      }

      if (var9 >= 0) {
         this.a(a[var9]);
         bfl.n(5890);
         bfl.E();
         bfl.a(4.0F, 2.0F, 1.0F);
         bfl.b(0.0625F, 0.0625F, 0.0625F);
         bfl.n(5888);
      } else {
         this.a(c);
      }

      bfl.B();
      bfl.E();
      bfl.a(var11, -var11, -var11);
      this.d.a();
      bfl.F();
      avn var20 = this.c();
      var13 = 0.015625F * var11;
      bfl.b(0.0F, 0.5F * var11, 0.07F * var11);
      bfl.a(var13, -var13, var13);
      GL11.glNormal3f(0.0F, 0.0F, -1.0F * var13);
      bfl.a(false);
      byte var14 = 0;
      if (var9 < 0) {
         for(int var15 = 0; var15 < var1.a.length; ++var15) {
            if (var1.a[var15] != null) {
               eu var16 = var1.a[var15];
               List var17 = avu.a(var16, 90, var20, false, true);
               String var18 = var17 != null && var17.size() > 0 ? ((eu)var17.get(0)).d() : "";
               if (var15 == var1.f) {
                  var18 = "> " + var18 + " <";
                  var20.a(var18, -var20.a(var18) / 2, var15 * 10 - var1.a.length * 5, var14);
               } else {
                  var20.a(var18, -var20.a(var18) / 2, var15 * 10 - var1.a.length * 5, var14);
               }
            }
         }
      }

      bfl.a(true);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.F();
      if (var9 >= 0) {
         bfl.n(5890);
         bfl.F();
         bfl.n(5888);
      }

   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((aln)var1, var2, var4, var6, var8, var9);
   }
}
