public class bix extends biv<uy> {
   public bix(biu var1) {
      super(var1);
      this.c = 0.5F;
   }

   protected jy a(uy var1) {
      return bmh.g;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uy)var1, var2, var4, var6, var8, var9);
   }

   public void a(uy var1, double var2, double var4, double var6, float var8, float var9) {
      if (var1.l() != null) {
         this.a((jy)bmh.g);
         alz var10 = var1.l();
         afh var11 = var10.c();
         cj var12 = new cj(var1);
         adm var13 = var1.j();
         if (var10 != var13.p(var12) && var11.b() != -1) {
            if (var11.b() == 3) {
               bfl.E();
               bfl.b((float)var2, (float)var4, (float)var6);
               bfl.f();
               bfx var14 = bfx.a();
               bfd var15 = var14.c();
               var15.a(7, bms.a);
               int var16 = var12.n();
               int var17 = var12.o();
               int var18 = var12.p();
               var15.c((double)((float)(-var16) - 0.5F), (double)(-var17), (double)((float)(-var18) - 0.5F));
               bgd var19 = ave.A().ae();
               boq var20 = var19.a(var10, var13, (cj)null);
               var19.b().a(var13, var20, (alz)var10, var12, var15, false);
               var15.c(0.0D, 0.0D, 0.0D);
               var14.b();
               bfl.e();
               bfl.F();
               super.a(var1, var2, var4, var6, var8, var9);
            }
         }
      }
   }

   protected jy a(pk var1) {
      return this.a((uy)var1);
   }
}
