public class avs extends avp {
   public boolean m;
   protected int g;
   protected int f;
   public boolean l;
   public int k;
   protected static final jy a = new jy("textures/gui/widgets.png");
   public int i;
   public String j;
   public int h;
   protected boolean n;

   public int b() {
      return this.f;
   }

   public void a(ave var1, int var2, int var3) {
      if (this.m) {
         avn var4 = var1.k;
         var1.P().a(a);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.n = var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
         int var5 = this.a(this.n);
         bfl.l();
         bfl.a(770, 771, 1, 0);
         bfl.b(770, 771);
         this.b(this.h, this.i, 0, 46 + var5 * 20, this.f / 2, this.g);
         this.b(this.h + this.f / 2, this.i, 200 - this.f / 2, 46 + var5 * 20, this.f / 2, this.g);
         this.b(var1, var2, var3);
         int var6 = 14737632;
         if (!this.l) {
            var6 = 10526880;
         } else if (this.n) {
            var6 = 16777120;
         }

         this.a(var4, this.j, this.h + this.f / 2, this.i + (this.g - 8) / 2, var6);
      }
   }

   public void a(int var1) {
      this.f = var1;
   }

   public void a(bpz var1) {
      var1.a((bpj)bpf.a(new jy("gui.button.press"), 1.0F));
   }

   public boolean c(ave var1, int var2, int var3) {
      return this.l && this.m && var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
   }

   public avs(int var1, int var2, int var3, String var4) {
      this(var1, var2, var3, 200, 20, var4);
   }

   public void b(int var1, int var2) {
   }

   public avs(int var1, int var2, int var3, int var4, int var5, String var6) {
      this.f = 200;
      this.g = 20;
      this.l = true;
      this.m = true;
      this.k = var1;
      this.h = var2;
      this.i = var3;
      this.f = var4;
      this.g = var5;
      this.j = var6;
   }

   public void a(int var1, int var2) {
   }

   protected void b(ave var1, int var2, int var3) {
   }

   public boolean a() {
      return this.n;
   }

   protected int a(boolean var1) {
      byte var2 = 1;
      if (!this.l) {
         var2 = 0;
      } else if (var1) {
         var2 = 2;
      }

      return var2;
   }
}
