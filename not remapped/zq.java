public class zq extends zw {
   public int b() {
      return 1;
   }

   public boolean w_() {
      return true;
   }

   public boolean f_(zx var1) {
      return super.f_(var1);
   }

   public boolean e() {
      return true;
   }

   public zx a(zx var1, adm var2, wn var3) {
      if (var3.bG != null) {
         int var4 = var3.bG.l();
         var1.a(var4, (pr)var3);
         var3.bw();
      } else {
         var2.a((pk)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if (!var2.D) {
            var2.d((pk)(new ur(var2, var3)));
         }

         var3.bw();
         var3.b(na.ad[zw.b((zw)this)]);
      }

      return var1;
   }

   public zq() {
      this.d(64);
      this.c(1);
      this.a(yz.i);
   }
}
