import java.util.Calendar;

public class bhe extends bhd<aky> {
   private static final jy c = new jy("textures/entity/chest/trapped_double.png");
   private baz j = new bbk();
   private boolean k;
   private baz i = new baz();
   private static final jy d = new jy("textures/entity/chest/christmas_double.png");
   private static final jy g = new jy("textures/entity/chest/christmas.png");
   private static final jy h = new jy("textures/entity/chest/normal.png");
   private static final jy e = new jy("textures/entity/chest/normal_double.png");
   private static final jy f = new jy("textures/entity/chest/trapped.png");

   public bhe() {
      Calendar var1 = Calendar.getInstance();
      if (var1.get(2) + 1 == 12 && var1.get(5) >= 24 && var1.get(5) <= 26) {
         this.k = true;
      }

   }

   public void a(aky var1, double var2, double var4, double var6, float var8, int var9) {
      bfl.j();
      bfl.c(515);
      bfl.a(true);
      int var10;
      if (!var1.t()) {
         var10 = 0;
      } else {
         afh var11 = var1.w();
         var10 = var1.u();
         if (var11 instanceof afs && var10 == 0) {
            ((afs)var11).e(var1.z(), var1.v(), var1.z().p(var1.v()));
            var10 = var1.u();
         }

         var1.m();
      }

      if (var1.f == null && var1.h == null) {
         baz var15;
         if (var1.g == null && var1.i == null) {
            var15 = this.i;
            if (var9 >= 0) {
               this.a(a[var9]);
               bfl.n(5890);
               bfl.E();
               bfl.a(4.0F, 4.0F, 1.0F);
               bfl.b(0.0625F, 0.0625F, 0.0625F);
               bfl.n(5888);
            } else if (this.k) {
               this.a(g);
            } else if (var1.n() == 1) {
               this.a(f);
            } else {
               this.a(h);
            }
         } else {
            var15 = this.j;
            if (var9 >= 0) {
               this.a(a[var9]);
               bfl.n(5890);
               bfl.E();
               bfl.a(8.0F, 4.0F, 1.0F);
               bfl.b(0.0625F, 0.0625F, 0.0625F);
               bfl.n(5888);
            } else if (this.k) {
               this.a(d);
            } else if (var1.n() == 1) {
               this.a(c);
            } else {
               this.a(e);
            }
         }

         bfl.E();
         bfl.B();
         if (var9 < 0) {
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         }

         bfl.b((float)var2, (float)var4 + 1.0F, (float)var6 + 1.0F);
         bfl.a(1.0F, -1.0F, -1.0F);
         bfl.b(0.5F, 0.5F, 0.5F);
         short var12 = 0;
         if (var10 == 2) {
            var12 = 180;
         }

         if (var10 == 3) {
            var12 = 0;
         }

         if (var10 == 4) {
            var12 = 90;
         }

         if (var10 == 5) {
            var12 = -90;
         }

         if (var10 == 2 && var1.g != null) {
            bfl.b(1.0F, 0.0F, 0.0F);
         }

         if (var10 == 5 && var1.i != null) {
            bfl.b(0.0F, 0.0F, -1.0F);
         }

         bfl.b((float)var12, 0.0F, 1.0F, 0.0F);
         bfl.b(-0.5F, -0.5F, -0.5F);
         float var13 = var1.k + (var1.j - var1.k) * var8;
         float var14;
         if (var1.f != null) {
            var14 = var1.f.k + (var1.f.j - var1.f.k) * var8;
            if (var14 > var13) {
               var13 = var14;
            }
         }

         if (var1.h != null) {
            var14 = var1.h.k + (var1.h.j - var1.h.k) * var8;
            if (var14 > var13) {
               var13 = var14;
            }
         }

         var13 = 1.0F - var13;
         var13 = 1.0F - var13 * var13 * var13;
         var15.a.f = -(var13 * 3.1415927F / 2.0F);
         var15.a();
         bfl.C();
         bfl.F();
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         if (var9 >= 0) {
            bfl.n(5890);
            bfl.F();
            bfl.n(5888);
         }

      }
   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((aky)var1, var2, var4, var6, var8, var9);
   }
}
