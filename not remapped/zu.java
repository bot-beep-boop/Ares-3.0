public class zu extends zw {
   private final Class<? extends un> a;

   private un a(adm var1, cj var2, cq var3) {
      if (this.a == uq.class) {
         return new uq(var1, var2, var3);
      } else {
         return this.a == uo.class ? new uo(var1, var2, var3) : null;
      }
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 == cq.a) {
         return false;
      } else if (var5 == cq.b) {
         return false;
      } else {
         cj var9 = var4.a(var5);
         if (!var2.a(var9, var5, var1)) {
            return false;
         } else {
            un var10 = this.a(var3, var9, var5);
            if (var10 != null && var10.j()) {
               if (!var3.D) {
                  var3.d((pk)var10);
               }

               --var1.b;
            }

            return true;
         }
      }
   }

   public zu(Class<? extends un> var1) {
      this.a = var1;
      this.a(yz.c);
   }
}
