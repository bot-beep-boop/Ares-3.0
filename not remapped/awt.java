import net.minecraft.realms.RealmsSimpleScrolledSelectionList;

public class awt extends awi {
   private final RealmsSimpleScrolledSelectionList u;

   protected void a() {
      this.u.renderBackground();
   }

   public int f() {
      return super.j;
   }

   public void p() {
      super.p();
   }

   public int g() {
      return super.i;
   }

   protected int b() {
      return this.u.getItemCount();
   }

   public void a(int var1, int var2, float var3) {
      if (this.q) {
         this.i = var1;
         this.j = var2;
         this.a();
         int var4 = this.d();
         int var5 = var4 + 6;
         this.l();
         bfl.f();
         bfl.n();
         bfx var6 = bfx.a();
         bfd var7 = var6.c();
         int var8 = this.g + this.b / 2 - this.c() / 2 + 2;
         int var9 = this.d + 4 - (int)this.n;
         if (this.s) {
            this.a(var8, var9, var6);
         }

         this.b(var8, var9, var1, var2);
         bfl.i();
         boolean var10 = true;
         this.c(0, this.d, 255, 255);
         this.c(this.e, this.c, 255, 255);
         bfl.l();
         bfl.a(770, 771, 0, 1);
         bfl.c();
         bfl.j(7425);
         bfl.x();
         int var11 = this.m();
         if (var11 > 0) {
            int var12 = (this.e - this.d) * (this.e - this.d) / this.k();
            var12 = ns.a(var12, 32, this.e - this.d - 8);
            int var13 = (int)this.n * (this.e - this.d - var12) / var11 + this.d;
            if (var13 < this.d) {
               var13 = this.d;
            }

            var7.a(7, bms.i);
            var7.b((double)var4, (double)this.e, 0.0D).a(0.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)var5, (double)this.e, 0.0D).a(1.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)var5, (double)this.d, 0.0D).a(1.0D, 0.0D).b(0, 0, 0, 255).d();
            var7.b((double)var4, (double)this.d, 0.0D).a(0.0D, 0.0D).b(0, 0, 0, 255).d();
            var6.b();
            var7.a(7, bms.i);
            var7.b((double)var4, (double)(var13 + var12), 0.0D).a(0.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var5, (double)(var13 + var12), 0.0D).a(1.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var5, (double)var13, 0.0D).a(1.0D, 0.0D).b(128, 128, 128, 255).d();
            var7.b((double)var4, (double)var13, 0.0D).a(0.0D, 0.0D).b(128, 128, 128, 255).d();
            var6.b();
            var7.a(7, bms.i);
            var7.b((double)var4, (double)(var13 + var12 - 1), 0.0D).a(0.0D, 1.0D).b(192, 192, 192, 255).d();
            var7.b((double)(var5 - 1), (double)(var13 + var12 - 1), 0.0D).a(1.0D, 1.0D).b(192, 192, 192, 255).d();
            var7.b((double)(var5 - 1), (double)var13, 0.0D).a(1.0D, 0.0D).b(192, 192, 192, 255).d();
            var7.b((double)var4, (double)var13, 0.0D).a(0.0D, 0.0D).b(192, 192, 192, 255).d();
            var6.b();
         }

         this.b(var1, var2);
         bfl.w();
         bfl.j(7424);
         bfl.d();
         bfl.k();
      }
   }

   protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.u.renderItem(var1, var2, var3, var4, var5, var6);
   }

   protected void a(int var1, boolean var2, int var3, int var4) {
      this.u.selectItem(var1, var2, var3, var4);
   }

   protected int d() {
      return this.u.getScrollbarPosition();
   }

   public awt(RealmsSimpleScrolledSelectionList var1, int var2, int var3, int var4, int var5, int var6) {
      super(ave.A(), var2, var3, var4, var5, var6);
      this.u = var1;
   }

   public int e() {
      return super.b;
   }

   protected boolean a(int var1) {
      return this.u.isSelectedItem(var1);
   }

   protected int k() {
      return this.u.getMaxPosition();
   }
}
