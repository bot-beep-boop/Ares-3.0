public class bkc<T extends pk> extends biv<T> {
   protected final zw a;
   private final bjh e;

   protected jy a(pk var1) {
      return bmh.g;
   }

   public void a(T var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      bfl.B();
      bfl.a(0.5F, 0.5F, 0.5F);
      bfl.b(-this.b.e, 0.0F, 1.0F, 0.0F);
      bfl.b(this.b.f, 1.0F, 0.0F, 0.0F);
      this.a(bmh.g);
      this.e.a(this.d(var1), bgr.b.f);
      bfl.C();
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   public bkc(biu var1, zw var2, bjh var3) {
      super(var1);
      this.a = var2;
      this.e = var3;
   }

   public zx d(T var1) {
      return new zx(this.a, 1, 0);
   }
}
