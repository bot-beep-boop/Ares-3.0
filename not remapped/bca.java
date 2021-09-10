public class bca extends bcn {
   public bca(float var1, boolean var2) {
      super(var1, 0.0F, 64, 32);
      if (!var2) {
         this.h = new bct(this, 40, 16);
         this.h.a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
         this.h.a(-5.0F, 2.0F, 0.0F);
         this.i = new bct(this, 40, 16);
         this.i.i = true;
         this.i.a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
         this.i.a(5.0F, 2.0F, 0.0F);
         this.j = new bct(this, 0, 16);
         this.j.a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
         this.j.a(-2.0F, 12.0F, 0.0F);
         this.k = new bct(this, 0, 16);
         this.k.i = true;
         this.k.a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
         this.k.a(2.0F, 12.0F, 0.0F);
      }

   }

   public bca() {
      this(0.0F, false);
   }

   public void a(pr var1, float var2, float var3, float var4) {
      this.o = ((wa)var1).cm() == 1;
      super.a(var1, var2, var3, var4);
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
   }
}
