import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class bgx extends bgu {
   private final String c;
   private final amo<?> a;
   private final List<amo<?>> d;

   protected bov a(alz var1) {
      LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
      String var3;
      if (this.a == null) {
         var3 = ((jy)afh.c.c(var1.c())).toString();
      } else {
         var3 = this.a.a((Comparable)var2.remove(this.a));
      }

      if (this.c != null) {
         var3 = var3 + this.c;
      }

      Iterator var4 = this.d.iterator();

      while(var4.hasNext()) {
         amo var5 = (amo)var4.next();
         var2.remove(var5);
      }

      return new bov(var3, this.a(var2));
   }

   bgx(amo var1, String var2, List var3, Object var4) {
      this(var1, var2, var3);
   }

   private bgx(amo<?> var1, String var2, List<amo<?>> var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   public static class a {
      private String b;
      private amo<?> a;
      private final List<amo<?>> c = Lists.newArrayList();

      public bgx.a a(amo<?>... var1) {
         Collections.addAll(this.c, var1);
         return this;
      }

      public bgx a() {
         return new bgx(this.a, this.b, this.c);
      }

      public bgx.a a(amo<?> var1) {
         this.a = var1;
         return this;
      }

      public bgx.a a(String var1) {
         this.b = var1;
         return this;
      }
   }
}
