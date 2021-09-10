import com.google.common.collect.Maps;
import java.util.Map;

public abstract class bkn<T extends bbo> implements blb<pr> {
   private float e = 1.0F;
   private float f = 1.0F;
   private float h = 1.0F;
   protected T d;
   private final bjl<?> a;
   private static final Map<String, jy> j = Maps.newHashMap();
   protected static final jy b = new jy("textures/misc/enchanted_item_glint.png");
   protected T c;
   private boolean i;
   private float g = 1.0F;

   protected abstract void a();

   private boolean b(int var1) {
      return var1 == 2;
   }

   public T a(int var1) {
      return this.b(var1) ? this.c : this.d;
   }

   protected abstract void a(T var1, int var2);

   private void a(pr var1, T var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float var10 = (float)var1.W + var5;
      this.a.a((jy)b);
      bfl.l();
      bfl.c(514);
      bfl.a(false);
      float var11 = 0.5F;
      bfl.c(var11, var11, var11, 1.0F);

      for(int var12 = 0; var12 < 2; ++var12) {
         bfl.f();
         bfl.b(768, 1);
         float var13 = 0.76F;
         bfl.c(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
         bfl.n(5890);
         bfl.D();
         float var14 = 0.33333334F;
         bfl.a(var14, var14, var14);
         bfl.b(30.0F - (float)var12 * 60.0F, 0.0F, 0.0F, 1.0F);
         bfl.b(0.0F, var10 * (0.001F + (float)var12 * 0.003F) * 20.0F, 0.0F);
         bfl.n(5888);
         var2.a(var1, var3, var4, var6, var7, var8, var9);
      }

      bfl.n(5890);
      bfl.D();
      bfl.n(5888);
      bfl.e();
      bfl.a(true);
      bfl.c(515);
      bfl.k();
   }

   private jy a(yj var1, boolean var2, String var3) {
      String var4 = String.format("textures/models/armor/%s_layer_%d%s.png", var1.x_().c(), var2 ? 2 : 1, var3 == null ? "" : String.format("_%s", var3));
      jy var5 = (jy)j.get(var4);
      if (var5 == null) {
         var5 = new jy(var4);
         j.put(var4, var5);
      }

      return var5;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a(var1, var2, var3, var4, var5, var6, var7, var8, 4);
      this.a(var1, var2, var3, var4, var5, var6, var7, var8, 3);
      this.a(var1, var2, var3, var4, var5, var6, var7, var8, 2);
      this.a(var1, var2, var3, var4, var5, var6, var7, var8, 1);
   }

   private jy a(yj var1, boolean var2) {
      return this.a(var1, var2, (String)null);
   }

   private void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      zx var10 = this.a(var1, var9);
      if (var10 != null && var10.b() instanceof yj) {
         yj var11 = (yj)var10.b();
         bbo var12 = this.a(var9);
         var12.a(this.a.b());
         var12.a(var1, var2, var3, var4);
         this.a(var12, var9);
         boolean var13 = this.b(var9);
         this.a.a((jy)this.a(var11, var13));
         switch(var11.x_()) {
         case a:
            int var14 = var11.b(var10);
            float var15 = (float)(var14 >> 16 & 255) / 255.0F;
            float var16 = (float)(var14 >> 8 & 255) / 255.0F;
            float var17 = (float)(var14 & 255) / 255.0F;
            bfl.c(this.f * var15, this.g * var16, this.h * var17, this.e);
            var12.a(var1, var2, var3, var5, var6, var7, var8);
            this.a.a((jy)this.a(var11, var13, "overlay"));
         case b:
         case c:
         case d:
         case e:
            bfl.c(this.f, this.g, this.h, this.e);
            var12.a(var1, var2, var3, var5, var6, var7, var8);
         default:
            if (!this.i && var10.w()) {
               this.a(var1, var12, var2, var3, var4, var5, var6, var7, var8);
            }

         }
      }
   }

   public boolean b() {
      return false;
   }

   public zx a(pr var1, int var2) {
      return var1.q(var2 - 1);
   }

   public bkn(bjl<?> var1) {
      this.a = var1;
      this.a();
   }
}
