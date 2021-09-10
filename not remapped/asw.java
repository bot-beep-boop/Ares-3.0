public abstract class asw {
   protected adq a;
   protected int e;
   protected int d;
   protected int c;
   protected nm<asv> b = new nm();

   public abstract int a(asv[] var1, pk var2, asv var3, asv var4, float var5);

   protected asv a(int var1, int var2, int var3) {
      int var4 = asv.a(var1, var2, var3);
      asv var5 = (asv)this.b.a(var4);
      if (var5 == null) {
         var5 = new asv(var1, var2, var3);
         this.b.a(var4, var5);
      }

      return var5;
   }

   public abstract asv a(pk var1);

   public abstract asv a(pk var1, double var2, double var4, double var6);

   public void a(adq var1, pk var2) {
      this.a = var1;
      this.b.c();
      this.c = ns.d(var2.J + 1.0F);
      this.d = ns.d(var2.K + 1.0F);
      this.e = ns.d(var2.J + 1.0F);
   }

   public void a() {
   }
}
