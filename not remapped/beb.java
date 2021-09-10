public class beb extends pk {
   public static double aw;
   protected bmi av;
   protected float h;
   protected float at;
   protected int g;
   protected float e;
   protected int b;
   protected float as;
   protected int f;
   public static double ay;
   protected float ar;
   protected float i;
   protected float au;
   protected float d;
   public static double ax;
   protected int c;

   public void b(dn var1) {
   }

   public void b(float var1, float var2, float var3) {
      this.ar = var1;
      this.as = var2;
      this.at = var3;
   }

   public float g() {
      return this.as;
   }

   public void a(bmi var1) {
      int var2 = this.a();
      if (var2 == 1) {
         this.av = var1;
      } else {
         throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
      }
   }

   public void i(float var1) {
      if (this.au == 1.0F && var1 < 1.0F) {
         ave.A().j.b(this);
      } else if (this.au < 1.0F && var1 == 1.0F) {
         ave.A().j.c(this);
      }

      this.au = var1;
   }

   protected boolean s_() {
      return false;
   }

   public void k(int var1) {
      if (this.a() != 0) {
         throw new RuntimeException("Invalid call to Particle.setMiscTex");
      } else {
         this.b = var1 % 16;
         this.c = var1 / 16;
      }
   }

   public boolean aD() {
      return false;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.w -= 0.04D * (double)this.i;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = (float)this.b / 16.0F;
      float var10 = var9 + 0.0624375F;
      float var11 = (float)this.c / 16.0F;
      float var12 = var11 + 0.0624375F;
      float var13 = 0.1F * this.h;
      if (this.av != null) {
         var9 = this.av.e();
         var10 = this.av.f();
         var11 = this.av.g();
         var12 = this.av.h();
      }

      float var14 = (float)(this.p + (this.s - this.p) * (double)var3 - aw);
      float var15 = (float)(this.q + (this.t - this.q) * (double)var3 - ax);
      float var16 = (float)(this.r + (this.u - this.r) * (double)var3 - ay);
      int var17 = this.b(var3);
      int var18 = var17 >> 16 & '\uffff';
      int var19 = var17 & '\uffff';
      var1.b((double)(var14 - var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 - var6 * var13 - var8 * var13)).a((double)var10, (double)var12).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
      var1.b((double)(var14 - var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 - var6 * var13 + var8 * var13)).a((double)var10, (double)var11).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
      var1.b((double)(var14 + var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 + var6 * var13 + var8 * var13)).a((double)var9, (double)var11).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
      var1.b((double)(var14 + var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 + var6 * var13 - var8 * var13)).a((double)var9, (double)var12).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
   }

   public void k() {
      ++this.b;
   }

   public int a() {
      return 0;
   }

   public String toString() {
      return this.getClass().getSimpleName() + ", Pos (" + this.s + "," + this.t + "," + this.u + "), RGBA (" + this.ar + "," + this.as + "," + this.at + "," + this.au + "), Age " + this.f;
   }

   public beb a(float var1) {
      this.v *= (double)var1;
      this.w = (this.w - 0.10000000149011612D) * (double)var1 + 0.10000000149011612D;
      this.x *= (double)var1;
      return this;
   }

   public float j() {
      return this.au;
   }

   public float i() {
      return this.at;
   }

   protected void h() {
   }

   public beb h(float var1) {
      this.a(0.2F * var1, 0.2F * var1);
      this.h *= var1;
      return this;
   }

   protected beb(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.au = 1.0F;
      this.a(0.2F, 0.2F);
      this.b(var2, var4, var6);
      this.P = this.p = var2;
      this.Q = this.q = var4;
      this.R = this.r = var6;
      this.ar = this.as = this.at = 1.0F;
      this.d = this.V.nextFloat() * 3.0F;
      this.e = this.V.nextFloat() * 3.0F;
      this.h = (this.V.nextFloat() * 0.5F + 0.5F) * 2.0F;
      this.g = (int)(4.0F / (this.V.nextFloat() * 0.9F + 0.1F));
      this.f = 0;
   }

   public beb(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6);
      this.v = var8 + (Math.random() * 2.0D - 1.0D) * 0.4000000059604645D;
      this.w = var10 + (Math.random() * 2.0D - 1.0D) * 0.4000000059604645D;
      this.x = var12 + (Math.random() * 2.0D - 1.0D) * 0.4000000059604645D;
      float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
      float var15 = ns.a(this.v * this.v + this.w * this.w + this.x * this.x);
      this.v = this.v / (double)var15 * (double)var14 * 0.4000000059604645D;
      this.w = this.w / (double)var15 * (double)var14 * 0.4000000059604645D + 0.10000000149011612D;
      this.x = this.x / (double)var15 * (double)var14 * 0.4000000059604645D;
   }

   public void a(dn var1) {
   }

   public float b() {
      return this.ar;
   }
}
