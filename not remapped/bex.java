import com.mojang.authlib.GameProfile;

public class bex extends bet {
   private boolean a;
   private double f;
   private double g;
   private double c;
   private double e;
   private int b;
   private double d;

   public bex(adm var1, GameProfile var2) {
      super(var1, var2);
      this.S = 0.0F;
      this.T = true;
      this.bZ = 0.25F;
      this.j = 10.0D;
   }

   public void t_() {
      this.bZ = 0.0F;
      super.t_();
      this.aA = this.aB;
      double var1 = this.s - this.p;
      double var3 = this.u - this.r;
      float var5 = ns.a(var1 * var1 + var3 * var3) * 4.0F;
      if (var5 > 1.0F) {
         var5 = 1.0F;
      }

      this.aB += (var5 - this.aB) * 0.4F;
      this.aC += this.aB;
      if (!this.a && this.ay() && this.bi.a[this.bi.c] != null) {
         zx var6 = this.bi.a[this.bi.c];
         this.a(this.bi.a[this.bi.c], var6.b().d(var6));
         this.a = true;
      } else if (this.a && !this.ay()) {
         this.bV();
         this.a = false;
      }

   }

   public void c(int var1, zx var2) {
      if (var1 == 0) {
         this.bi.a[this.bi.c] = var2;
      } else {
         this.bi.b[var1 - 1] = var2;
      }

   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.c = var1;
      this.d = var3;
      this.e = var5;
      this.f = (double)var7;
      this.g = (double)var8;
      this.b = var9;
   }

   public cj c() {
      return new cj(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D);
   }

   public boolean a(int var1, String var2) {
      return false;
   }

   public boolean a(ow var1, float var2) {
      return true;
   }

   public void a(eu var1) {
      ave.A().q.d().a(var1);
   }

   public void m() {
      if (this.b > 0) {
         double var1 = this.s + (this.c - this.s) / (double)this.b;
         double var3 = this.t + (this.d - this.t) / (double)this.b;
         double var5 = this.u + (this.e - this.u) / (double)this.b;

         double var7;
         for(var7 = this.f - (double)this.y; var7 < -180.0D; var7 += 360.0D) {
         }

         while(var7 >= 180.0D) {
            var7 -= 360.0D;
         }

         this.y = (float)((double)this.y + var7 / (double)this.b);
         this.z = (float)((double)this.z + (this.g - (double)this.z) / (double)this.b);
         --this.b;
         this.b(var1, var3, var5);
         this.b(this.y, this.z);
      }

      this.bn = this.bo;
      this.bx();
      float var9 = ns.a(this.v * this.v + this.x * this.x);
      float var2 = (float)Math.atan(-this.w * 0.20000000298023224D) * 15.0F;
      if (var9 > 0.1F) {
         var9 = 0.1F;
      }

      if (!this.C || this.bn() <= 0.0F) {
         var9 = 0.0F;
      }

      if (this.C || this.bn() <= 0.0F) {
         var2 = 0.0F;
      }

      this.bo += (var9 - this.bo) * 0.4F;
      this.aF += (var2 - this.aF) * 0.8F;
   }
}
