public class awj extends avs {
   private final float s;
   private avh.a q;
   public boolean o;
   private float p;
   private final float r;

   public awj(int var1, int var2, int var3, avh.a var4, float var5, float var6) {
      super(var1, var2, var3, 150, 20, "");
      this.p = 1.0F;
      this.q = var4;
      this.r = var5;
      this.s = var6;
      ave var7 = ave.A();
      this.p = var4.c(var7.t.a(var4));
      this.j = var7.t.c(var4);
   }

   public boolean c(ave var1, int var2, int var3) {
      if (super.c(var1, var2, var3)) {
         this.p = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
         this.p = ns.a(this.p, 0.0F, 1.0F);
         var1.t.a(this.q, this.q.d(this.p));
         this.j = var1.t.c(this.q);
         this.o = true;
         return true;
      } else {
         return false;
      }
   }

   protected int a(boolean var1) {
      return 0;
   }

   public void a(int var1, int var2) {
      this.o = false;
   }

   protected void b(ave var1, int var2, int var3) {
      if (this.m) {
         if (this.o) {
            this.p = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
            this.p = ns.a(this.p, 0.0F, 1.0F);
            float var4 = this.q.d(this.p);
            var1.t.a(this.q, var4);
            this.p = this.q.c(var4);
            this.j = var1.t.c(this.q);
         }

         var1.P().a(a);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.b(this.h + (int)(this.p * (float)(this.f - 8)), this.i, 0, 66, 4, 20);
         this.b(this.h + (int)(this.p * (float)(this.f - 8)) + 4, this.i, 196, 66, 4, 20);
      }
   }

   public awj(int var1, int var2, int var3, avh.a var4) {
      this(var1, var2, var3, var4, 0.0F, 1.0F);
   }
}
