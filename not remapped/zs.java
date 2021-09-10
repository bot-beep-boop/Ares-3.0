public class zs extends zw {
   private float o;
   private int m;
   private int n;
   private int l;
   private final float c;
   private final int b;
   private final boolean d;
   public final int a;
   private boolean k;

   public boolean g() {
      return this.d;
   }

   public aba e(zx var1) {
      return aba.b;
   }

   protected void c(zx var1, adm var2, wn var3) {
      if (!var2.D && this.l > 0 && var2.s.nextFloat() < this.o) {
         var3.c(new pf(this.l, this.m * 20, this.n));
      }

   }

   public float i(zx var1) {
      return this.c;
   }

   public zx a(zx var1, adm var2, wn var3) {
      if (var3.j(this.k)) {
         var3.a(var1, this.d(var1));
      }

      return var1;
   }

   public zs(int var1, boolean var2) {
      this(var1, 0.6F, var2);
   }

   public zs a(int var1, int var2, int var3, float var4) {
      this.l = var1;
      this.m = var2;
      this.n = var3;
      this.o = var4;
      return this;
   }

   public int h(zx var1) {
      return this.b;
   }

   public zs h() {
      this.k = true;
      return this;
   }

   public zx b(zx var1, adm var2, wn var3) {
      --var1.b;
      var3.cl().a(this, var1);
      var2.a((pk)var3, "random.burp", 0.5F, var2.s.nextFloat() * 0.1F + 0.9F);
      this.c(var1, var2, var3);
      var3.b(na.ad[zw.b((zw)this)]);
      return var1;
   }

   public int d(zx var1) {
      return 32;
   }

   public zs(int var1, float var2, boolean var3) {
      this.a = 32;
      this.b = var1;
      this.d = var3;
      this.c = var2;
      this.a(yz.h);
   }
}
