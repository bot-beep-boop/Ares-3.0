public class aao extends zw {
   private afh b;
   private afh a;

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 != cq.b) {
         return false;
      } else if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else if (var3.p(var4).c() == this.b && var3.d(var4.a())) {
         var3.a(var4.a(), this.a.Q());
         --var1.b;
         return true;
      } else {
         return false;
      }
   }

   public aao(afh var1, afh var2) {
      this.a = var1;
      this.b = var2;
      this.a(yz.l);
   }
}
