public class aap extends zw {
   public boolean b(afh var1) {
      return var1 == afi.G || var1 == afi.af || var1 == afi.bS;
   }

   public boolean a(zx var1, adm var2, afh var3, cj var4, pr var5) {
      if (var3.t() != arm.j && var3 != afi.G && var3 != afi.H && var3 != afi.bn && var3 != afi.bS && var3 != afi.L) {
         return super.a(var1, var2, var3, var4, var5);
      } else {
         var1.a(1, (pr)var5);
         return true;
      }
   }

   public float a(zx var1, afh var2) {
      if (var2 != afi.G && var2.t() != arm.j) {
         return var2 == afi.L ? 5.0F : super.a(var1, var2);
      } else {
         return 15.0F;
      }
   }

   public aap() {
      this.c(1);
      this.d(238);
      this.a(yz.i);
   }
}
