public class sj extends rg {
   private wi f;
   private int e;

   public sj(wi var1) {
      super(var1, wi.class, 3.0F, 0.02F);
      this.f = var1;
   }

   public void c() {
      super.c();
      if (this.f.cs() && this.b instanceof wi && ((wi)this.b).ct()) {
         this.e = 10;
      } else {
         this.e = 0;
      }

   }

   public void e() {
      super.e();
      if (this.e > 0) {
         --this.e;
         if (this.e == 0) {
            oq var1 = this.f.cq();

            for(int var2 = 0; var2 < var1.o_(); ++var2) {
               zx var3 = var1.a(var2);
               zx var4 = null;
               if (var3 != null) {
                  zw var5 = var3.b();
                  int var6;
                  if ((var5 == zy.P || var5 == zy.bS || var5 == zy.bR) && var3.b > 3) {
                     var6 = var3.b / 2;
                     var3.b -= var6;
                     var4 = new zx(var5, var6, var3.i());
                  } else if (var5 == zy.O && var3.b > 5) {
                     var6 = var3.b / 2 / 3 * 3;
                     int var7 = var6 / 3;
                     var3.b -= var6;
                     var4 = new zx(zy.P, var7, 0);
                  }

                  if (var3.b <= 0) {
                     var1.a(var2, (zx)null);
                  }
               }

               if (var4 != null) {
                  double var11 = this.f.t - 0.30000001192092896D + (double)this.f.aS();
                  uz var12 = new uz(this.f.o, this.f.s, var11, this.f.u, var4);
                  float var8 = 0.3F;
                  float var9 = this.f.aK;
                  float var10 = this.f.z;
                  var12.v = (double)(-ns.a(var9 / 180.0F * 3.1415927F) * ns.b(var10 / 180.0F * 3.1415927F) * var8);
                  var12.x = (double)(ns.b(var9 / 180.0F * 3.1415927F) * ns.b(var10 / 180.0F * 3.1415927F) * var8);
                  var12.w = (double)(-ns.a(var10 / 180.0F * 3.1415927F) * var8 + 0.1F);
                  var12.p();
                  this.f.o.d((pk)var12);
                  break;
               }
            }
         }
      }

   }
}
