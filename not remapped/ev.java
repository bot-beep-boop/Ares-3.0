import java.util.Iterator;
import java.util.List;

public class ev {
   public static eu a(m var0, eu var1, pk var2) throws bz {
      Object var3 = null;
      if (var1 instanceof ex) {
         ex var4 = (ex)var1;
         String var5 = var4.g();
         if (o.b(var5)) {
            List var6 = o.b(var0, var5, pk.class);
            if (var6.size() != 1) {
               throw new ca();
            }

            var5 = ((pk)var6.get(0)).e_();
         }

         var3 = var2 != null && var5.equals("*") ? new ex(var2.e_(), var4.h()) : new ex(var5, var4.h());
         ((ex)var3).b(var4.e());
      } else if (var1 instanceof ey) {
         String var7 = ((ey)var1).g();
         var3 = o.b(var0, var7);
         if (var3 == null) {
            var3 = new fa("");
         }
      } else if (var1 instanceof fa) {
         var3 = new fa(((fa)var1).g());
      } else {
         if (!(var1 instanceof fb)) {
            return var1;
         }

         Object[] var8 = ((fb)var1).j();

         for(int var10 = 0; var10 < var8.length; ++var10) {
            Object var11 = var8[var10];
            if (var11 instanceof eu) {
               var8[var10] = a(var0, (eu)var11, var2);
            }
         }

         var3 = new fb(((fb)var1).i(), var8);
      }

      ez var9 = var1.b();
      if (var9 != null) {
         ((eu)var3).a(var9.m());
      }

      Iterator var13 = var1.a().iterator();

      while(var13.hasNext()) {
         eu var12 = (eu)var13.next();
         ((eu)var3).a(a(var0, var12, var2));
      }

      return (eu)var3;
   }
}
