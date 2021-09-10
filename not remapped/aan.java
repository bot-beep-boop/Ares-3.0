public class aan extends zs {
   private afh b;
   private afh c;

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 != cq.b) {
         return false;
      } else if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else if (var3.p(var4).c() == this.c && var3.d(var4.a())) {
         var3.a(var4.a(), this.b.Q());
         --var1.b;
         return true;
      } else {
         return false;
      }
   }

   public aan(int var1, float var2, afh var3, afh var4) {
      super(var1, var2, false);
      this.b = var3;
      this.c = var4;
   }
}
