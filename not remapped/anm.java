public abstract class anm {
   protected int g;
   private final float[] j = new float[4];
   protected final float[] f = new float[16];
   private String i;
   protected adm b;
   protected aec c;
   private adr h;
   protected boolean d;
   public static final float[] a = new float[]{1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
   protected boolean e;

   protected void b() {
      adr var1 = this.b.P().u();
      if (var1 == adr.c) {
         apz var2 = apz.a(this.b.P().B());
         this.c = new aef(ady.a(var2.a(), ady.ad), 0.5F);
      } else if (var1 == adr.g) {
         this.c = new aef(ady.q, 0.0F);
      } else {
         this.c = new aec(this.b);
      }

   }

   public final void a(adm var1) {
      this.b = var1;
      this.h = var1.P().u();
      this.i = var1.P().B();
      this.b();
      this.a();
   }

   public aui b(float var1, float var2) {
      float var3 = ns.b(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var3 = ns.a(var3, 0.0F, 1.0F);
      float var4 = 0.7529412F;
      float var5 = 0.84705883F;
      float var6 = 1.0F;
      var4 *= var3 * 0.94F + 0.06F;
      var5 *= var3 * 0.94F + 0.06F;
      var6 *= var3 * 0.91F + 0.09F;
      return new aui((double)var4, (double)var5, (double)var6);
   }

   public abstract String k();

   public cj h() {
      return null;
   }

   public boolean g() {
      return true;
   }

   public aec m() {
      return this.c;
   }

   public boolean b(int var1, int var2) {
      return false;
   }

   public static anm a(int var0) {
      if (var0 == -1) {
         return new ann();
      } else if (var0 == 0) {
         return new ano();
      } else {
         return var0 == 1 ? new anp() : null;
      }
   }

   public float[] p() {
      return this.f;
   }

   public float[] a(float var1, float var2) {
      float var3 = 0.4F;
      float var4 = ns.b(var1 * 3.1415927F * 2.0F) - 0.0F;
      float var5 = -0.0F;
      if (var4 >= var5 - var3 && var4 <= var5 + var3) {
         float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
         float var7 = 1.0F - (1.0F - ns.a(var6 * 3.1415927F)) * 0.99F;
         var7 *= var7;
         this.j[0] = var6 * 0.3F + 0.7F;
         this.j[1] = var6 * var6 * 0.7F + 0.2F;
         this.j[2] = var6 * var6 * 0.0F + 0.2F;
         this.j[3] = var7;
         return this.j;
      } else {
         return null;
      }
   }

   protected void a() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public boolean e() {
      return true;
   }

   public boolean o() {
      return this.e;
   }

   public amv c() {
      if (this.h == adr.c) {
         return new anv(this.b, this.b.J(), this.b.P().s(), this.i);
      } else if (this.h == adr.g) {
         return new anu(this.b);
      } else {
         return this.h == adr.f ? new aoa(this.b, this.b.J(), this.b.P().s(), this.i) : new aoa(this.b, this.b.J(), this.b.P().s(), this.i);
      }
   }

   public int q() {
      return this.g;
   }

   public ams r() {
      return new ams();
   }

   public float f() {
      return 128.0F;
   }

   public boolean n() {
      return this.d;
   }

   public double j() {
      return this.h == adr.c ? 1.0D : 0.03125D;
   }

   public int i() {
      return this.h == adr.c ? 4 : this.b.F() + 1;
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new cj(var1, 0, var2)) == afi.c;
   }

   public boolean d() {
      return true;
   }

   public abstract String l();

   public int a(long var1) {
      return (int)(var1 / 24000L % 8L + 8L) % 8;
   }

   public float a(long var1, float var3) {
      int var4 = (int)(var1 % 24000L);
      float var5 = ((float)var4 + var3) / 24000.0F - 0.25F;
      if (var5 < 0.0F) {
         ++var5;
      }

      if (var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }
}
