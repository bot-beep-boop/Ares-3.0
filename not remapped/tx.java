public class tx extends tz {
   private float bs;
   public float bo;
   private float br;
   private float bp;
   public float bm;
   public float c;
   public float a;
   private float bu;
   public float bl;
   public float b;
   private float bq;
   public float bk;
   private float bt;
   public float bn;

   protected zw A() {
      return null;
   }

   static boolean a(tx var0) {
      return var0.Y;
   }

   protected String bp() {
      return null;
   }

   public void g(float var1, float var2) {
      this.d(this.v, this.w, this.x);
   }

   public void a(byte var1) {
      if (var1 == 19) {
         this.bl = 0.0F;
      } else {
         super.a(var1);
      }

   }

   protected boolean s_() {
      return false;
   }

   public boolean n() {
      return this.bs != 0.0F || this.bt != 0.0F || this.bu != 0.0F;
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(10.0D);
   }

   public void m() {
      super.m();
      this.b = this.a;
      this.bk = this.c;
      this.bm = this.bl;
      this.bo = this.bn;
      this.bl += this.bq;
      if ((double)this.bl > 6.283185307179586D) {
         if (this.o.D) {
            this.bl = 6.2831855F;
         } else {
            this.bl = (float)((double)this.bl - 6.283185307179586D);
            if (this.V.nextInt(10) == 0) {
               this.bq = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
            }

            this.o.a((pk)this, (byte)19);
         }
      }

      if (this.Y) {
         float var1;
         if (this.bl < 3.1415927F) {
            var1 = this.bl / 3.1415927F;
            this.bn = ns.a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
            if ((double)var1 > 0.75D) {
               this.bp = 1.0F;
               this.br = 1.0F;
            } else {
               this.br *= 0.8F;
            }
         } else {
            this.bn = 0.0F;
            this.bp *= 0.9F;
            this.br *= 0.99F;
         }

         if (!this.o.D) {
            this.v = (double)(this.bs * this.bp);
            this.w = (double)(this.bt * this.bp);
            this.x = (double)(this.bu * this.bp);
         }

         var1 = ns.a(this.v * this.v + this.x * this.x);
         this.aI += (-((float)ns.b(this.v, this.x)) * 180.0F / 3.1415927F - this.aI) * 0.1F;
         this.y = this.aI;
         this.c = (float)((double)this.c + 3.141592653589793D * (double)this.br * 1.5D);
         this.a += (-((float)ns.b((double)var1, this.w)) * 180.0F / 3.1415927F - this.a) * 0.1F;
      } else {
         this.bn = ns.e(ns.a(this.bl)) * 3.1415927F * 0.25F;
         if (!this.o.D) {
            this.v = 0.0D;
            this.w -= 0.08D;
            this.w *= 0.9800000190734863D;
            this.x = 0.0D;
         }

         this.a = (float)((double)this.a + (double)(-90.0F - this.a) * 0.02D);
      }

   }

   protected String z() {
      return null;
   }

   protected String bo() {
      return null;
   }

   public float aS() {
      return this.K * 0.5F;
   }

   protected float bB() {
      return 0.4F;
   }

   public void b(float var1, float var2, float var3) {
      this.bs = var1;
      this.bt = var2;
      this.bu = var3;
   }

   public tx(adm var1) {
      super(var1);
      this.a(0.95F, 0.95F);
      this.V.setSeed((long)(1 + this.F()));
      this.bq = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
      this.i.a(0, new tx.a(this));
   }

   public boolean V() {
      return this.o.a((aug)this.aR().b(0.0D, -0.6000000238418579D, 0.0D), (arm)arm.h, (pk)this);
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3 + var2) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(new zx(zy.aW, 1, zd.p.b()), 0.0F);
      }

   }

   public boolean bR() {
      return this.t > 45.0D && this.t < (double)this.o.F() && super.bR();
   }

   static class a extends rd {
      private tx a;

      public void e() {
         int var1 = this.a.bh();
         if (var1 > 100) {
            this.a.b(0.0F, 0.0F, 0.0F);
         } else if (this.a.bc().nextInt(50) == 0 || !tx.a(this.a) || !this.a.n()) {
            float var2 = this.a.bc().nextFloat() * 3.1415927F * 2.0F;
            float var3 = ns.b(var2) * 0.2F;
            float var4 = -0.1F + this.a.bc().nextFloat() * 0.2F;
            float var5 = ns.a(var2) * 0.2F;
            this.a.b(var3, var4, var5);
         }

      }

      public a(tx var1) {
         this.a = var1;
      }

      public boolean a() {
         return true;
      }
   }
}
