public class bbg extends bbo {
   private bct[] d;
   private bct[] c;
   private bct b;
   private bct a;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      vt var8 = (vt)var7;
      float var9 = var3 - (float)var8.W;
      this.a.g = var4 / 57.295776F;
      this.a.f = var5 / 57.295776F;
      float[] var10 = new float[]{1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
      float[] var11 = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};
      float[] var12 = new float[]{0.0F, 0.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 1.25F};
      float[] var13 = new float[]{0.0F, 0.0F, 8.0F, -8.0F, -8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 8.0F, -8.0F};
      float[] var14 = new float[]{-8.0F, -8.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, 8.0F};
      float[] var15 = new float[]{8.0F, -8.0F, 0.0F, 0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F};
      float var16 = (1.0F - var8.p(var9)) * 0.55F;

      for(int var17 = 0; var17 < 12; ++var17) {
         this.c[var17].f = 3.1415927F * var10[var17];
         this.c[var17].g = 3.1415927F * var11[var17];
         this.c[var17].h = 3.1415927F * var12[var17];
         this.c[var17].c = var13[var17] * (1.0F + ns.b(var3 * 1.5F + (float)var17) * 0.01F - var16);
         this.c[var17].d = 16.0F + var14[var17] * (1.0F + ns.b(var3 * 1.5F + (float)var17) * 0.01F - var16);
         this.c[var17].e = var15[var17] * (1.0F + ns.b(var3 * 1.5F + (float)var17) * 0.01F - var16);
      }

      this.b.e = -8.25F;
      Object var26 = ave.A().ac();
      if (var8.cp()) {
         var26 = var8.cq();
      }

      if (var26 != null) {
         aui var18 = ((pk)var26).e(0.0F);
         aui var19 = var7.e(0.0F);
         double var20 = var18.b - var19.b;
         if (var20 > 0.0D) {
            this.b.d = 0.0F;
         } else {
            this.b.d = 1.0F;
         }

         aui var22 = var7.d(0.0F);
         var22 = new aui(var22.a, 0.0D, var22.c);
         aui var23 = (new aui(var19.a - var18.a, 0.0D, var19.c - var18.c)).a().b(1.5707964F);
         double var24 = var22.b(var23);
         this.b.c = ns.c((float)Math.abs(var24)) * 2.0F * (float)Math.signum(var24);
      }

      this.b.j = true;
      float var27 = var8.a(var9);
      this.d[0].g = ns.a(var27) * 3.1415927F * 0.05F;
      this.d[1].g = ns.a(var27) * 3.1415927F * 0.1F;
      this.d[1].c = -1.5F;
      this.d[1].d = 0.5F;
      this.d[1].e = 14.0F;
      this.d[2].g = ns.a(var27) * 3.1415927F * 0.15F;
      this.d[2].c = 0.5F;
      this.d[2].d = 0.5F;
      this.d[2].e = 6.0F;
   }

   public int a() {
      return 54;
   }

   public bbg() {
      this.t = 64;
      this.u = 64;
      this.c = new bct[12];
      this.a = new bct(this);
      this.a.a(0, 0).a(-6.0F, 10.0F, -8.0F, 12, 12, 16);
      this.a.a(0, 28).a(-8.0F, 10.0F, -6.0F, 2, 12, 12);
      this.a.a(0, 28).a(6.0F, 10.0F, -6.0F, 2, 12, 12, true);
      this.a.a(16, 40).a(-6.0F, 8.0F, -6.0F, 12, 2, 12);
      this.a.a(16, 40).a(-6.0F, 22.0F, -6.0F, 12, 2, 12);

      for(int var1 = 0; var1 < this.c.length; ++var1) {
         this.c[var1] = new bct(this, 0, 0);
         this.c[var1].a(-1.0F, -4.5F, -1.0F, 2, 9, 2);
         this.a.a(this.c[var1]);
      }

      this.b = new bct(this, 8, 0);
      this.b.a(-1.0F, 15.0F, 0.0F, 2, 2, 1);
      this.a.a(this.b);
      this.d = new bct[3];
      this.d[0] = new bct(this, 40, 0);
      this.d[0].a(-2.0F, 14.0F, 7.0F, 4, 4, 8);
      this.d[1] = new bct(this, 0, 54);
      this.d[1].a(0.0F, 14.0F, 0.0F, 3, 3, 7);
      this.d[2] = new bct(this);
      this.d[2].a(41, 32).a(0.0F, 14.0F, 0.0F, 2, 2, 6);
      this.d[2].a(25, 19).a(1.0F, 10.5F, 3.0F, 1, 9, 9);
      this.a.a(this.d[0]);
      this.d[0].a(this.d[1]);
      this.d[1].a(this.d[2]);
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
   }
}
