public abstract class ro extends rd {
   private boolean g;
   private int f;
   protected int a;
   private int e;
   protected cj b;
   private final py c;
   private int h;
   private final double d;

   public void c() {
      this.c.s().a((double)((float)this.b.n()) + 0.5D, (double)(this.b.o() + 1), (double)((float)this.b.p()) + 0.5D, this.d);
      this.e = 0;
      this.f = this.c.bc().nextInt(this.c.bc().nextInt(1200) + 1200) + 1200;
   }

   protected boolean f() {
      return this.g;
   }

   public void e() {
      if (this.c.c(this.b.a()) > 1.0D) {
         this.g = false;
         ++this.e;
         if (this.e % 40 == 0) {
            this.c.s().a((double)((float)this.b.n()) + 0.5D, (double)(this.b.o() + 1), (double)((float)this.b.p()) + 0.5D, this.d);
         }
      } else {
         this.g = true;
         --this.e;
      }

   }

   public ro(py var1, double var2, int var4) {
      this.b = cj.a;
      this.c = var1;
      this.d = var2;
      this.h = var4;
      this.a(5);
   }

   public boolean a() {
      if (this.a > 0) {
         --this.a;
         return false;
      } else {
         this.a = 200 + this.c.bc().nextInt(200);
         return this.g();
      }
   }

   private boolean g() {
      int var1 = this.h;
      boolean var2 = true;
      cj var3 = new cj(this.c);

      for(int var4 = 0; var4 <= 1; var4 = var4 > 0 ? -var4 : 1 - var4) {
         for(int var5 = 0; var5 < var1; ++var5) {
            for(int var6 = 0; var6 <= var5; var6 = var6 > 0 ? -var6 : 1 - var6) {
               for(int var7 = var6 < var5 && var6 > -var5 ? var5 : 0; var7 <= var5; var7 = var7 > 0 ? -var7 : 1 - var7) {
                  cj var8 = var3.a(var6, var4 - 1, var7);
                  if (this.c.e(var8) && this.a(this.c.o, var8)) {
                     this.b = var8;
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean b() {
      return this.e >= -this.f && this.e <= 1200 && this.a(this.c.o, this.b);
   }

   public void d() {
   }

   protected abstract boolean a(adm var1, cj var2);
}
