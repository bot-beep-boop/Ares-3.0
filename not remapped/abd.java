import java.util.List;

public class abd extends zw {
   public static int h(zx var0) {
      return var0.o().f("generation");
   }

   private void a(zx var1, wn var2) {
      if (var1 != null && var1.o() != null) {
         dn var3 = var1.o();
         if (!var3.n("resolved")) {
            var3.a("resolved", true);
            if (b(var3)) {
               du var4 = var3.c("pages", 8);

               for(int var5 = 0; var5 < var4.c(); ++var5) {
                  String var6 = var4.f(var5);

                  Object var7;
                  try {
                     eu var11 = eu.a.a(var6);
                     var7 = ev.a(var2, var11, var2);
                  } catch (Exception var9) {
                     var7 = new fa(var6);
                  }

                  var4.a(var5, new ea(eu.a.a((eu)var7)));
               }

               var3.a((String)"pages", (eb)var4);
               if (var2 instanceof lf && var2.bZ() == var1) {
                  yg var10 = var2.bk.a((og)var2.bi, var2.bi.c);
                  ((lf)var2).a.a((ff)(new gf(0, var10.e, var1)));
               }

            }
         }
      }
   }

   public boolean f(zx var1) {
      return true;
   }

   public zx a(zx var1, adm var2, wn var3) {
      if (!var2.D) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(na.ad[zw.b((zw)this)]);
      return var1;
   }

   public String a(zx var1) {
      if (var1.n()) {
         dn var2 = var1.o();
         String var3 = var2.j("title");
         if (!nx.b(var3)) {
            return var3;
         }
      }

      return super.a(var1);
   }

   public abd() {
      this.c(1);
   }

   public static boolean b(dn var0) {
      if (!abc.b(var0)) {
         return false;
      } else if (!var0.b("title", 8)) {
         return false;
      } else {
         String var1 = var0.j("title");
         if (var1 != null && var1.length() <= 32) {
            return var0.b("author", 8);
         } else {
            return false;
         }
      }
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      if (var1.n()) {
         dn var5 = var1.o();
         String var6 = var5.j("author");
         if (!nx.b(var6)) {
            var3.add(.a.h + di.a("book.byAuthor", var6));
         }

         var3.add(.a.h + di.a("book.generation." + var5.f("generation")));
      }

   }
}
