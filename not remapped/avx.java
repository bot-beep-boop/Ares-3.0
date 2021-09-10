public class avx extends avs {
   public boolean o;
   private final float s;
   private avx.a u;
   private final awg.b t;
   private float p = 1.0F;
   private String q;
   private final float r;

   protected int a(boolean var1) {
      return 0;
   }

   public avx(awg.b var1, int var2, int var3, int var4, String var5, float var6, float var7, float var8, avx.a var9) {
      super(var2, var3, var4, 150, 20, "");
      this.q = var5;
      this.r = var6;
      this.s = var7;
      this.p = (var8 - var6) / (var7 - var6);
      this.u = var9;
      this.t = var1;
      this.j = this.e();
   }

   protected void b(ave var1, int var2, int var3) {
      if (this.m) {
         if (this.o) {
            this.p = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
            if (this.p < 0.0F) {
               this.p = 0.0F;
            }

            if (this.p > 1.0F) {
               this.p = 1.0F;
            }

            this.j = this.e();
            this.t.a(this.k, this.c());
         }

         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.b(this.h + (int)(this.p * (float)(this.f - 8)), this.i, 0, 66, 4, 20);
         this.b(this.h + (int)(this.p * (float)(this.f - 8)) + 4, this.i, 196, 66, 4, 20);
      }
   }

   private String e() {
      return this.u == null ? bnq.a(this.q) + ": " + this.c() : this.u.a(this.k, bnq.a(this.q), this.c());
   }

   public void a(float var1) {
      this.p = var1;
      this.j = this.e();
      this.t.a(this.k, this.c());
   }

   public void a(int var1, int var2) {
      this.o = false;
   }

   public boolean c(ave var1, int var2, int var3) {
      if (super.c(var1, var2, var3)) {
         this.p = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
         if (this.p < 0.0F) {
            this.p = 0.0F;
         }

         if (this.p > 1.0F) {
            this.p = 1.0F;
         }

         this.j = this.e();
         this.t.a(this.k, this.c());
         this.o = true;
         return true;
      } else {
         return false;
      }
   }

   public float c() {
      return this.r + (this.s - this.r) * this.p;
   }

   public void a(float var1, boolean var2) {
      this.p = (var1 - this.r) / (this.s - this.r);
      this.j = this.e();
      if (var2) {
         this.t.a(this.k, this.c());
      }

   }

   public float d() {
      return this.p;
   }

   public interface a {
      String a(int var1, String var2, float var3);
   }
}
