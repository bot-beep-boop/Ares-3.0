import java.util.Iterator;

public abstract class ahw extends ajg {
   public static final amm<ahw.a> a = amm.a("axis", ahw.a.class);

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, ahw.a.a(var3.k()));
   }

   public void b(adm var1, cj var2, alz var3) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if (var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
         Iterator var6 = cj.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            cj var7 = (cj)var6.next();
            alz var8 = var1.p(var7);
            if (var8.c().t() == arm.j && !(Boolean)var8.b(ahs.b)) {
               var1.a((cj)var7, (alz)var8.a(ahs.b, true), 4);
            }
         }

      }
   }

   public ahw() {
      super(arm.d);
      this.a(yz.b);
      this.c(2.0F);
      this.a(f);
   }

   public static enum a implements nw {
      private static final ahw.a[] f = new ahw.a[]{a, b, c, d};
      a("x");

      private final String e;
      c("z"),
      b("y"),
      d("none");

      public String toString() {
         return this.e;
      }

      public static ahw.a a(cq.a var0) {
         switch(var0) {
         case a:
            return a;
         case b:
            return b;
         case c:
            return c;
         default:
            return d;
         }
      }

      private a(String var3) {
         this.e = var3;
      }

      public String l() {
         return this.e;
      }
   }
}
