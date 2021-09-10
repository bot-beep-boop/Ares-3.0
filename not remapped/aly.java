import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class aly implements alz {
   private static final Function<Entry<amo, Comparable>, String> b = new Function<Entry<amo, Comparable>, String>() {
      public String a(Entry<amo, Comparable> var1) {
         if (var1 == null) {
            return "<NULL>";
         } else {
            amo var2 = (amo)var1.getKey();
            return var2.a() + "=" + var2.a((Comparable)var1.getValue());
         }
      }

      public Object apply(Object var1) {
         return this.a((Entry)var1);
      }
   };
   private static final Joiner a = Joiner.on(',');

   protected static <T> T a(Collection<T> var0, T var1) {
      Iterator var2 = var0.iterator();

      do {
         if (!var2.hasNext()) {
            return var2.next();
         }
      } while(!var2.next().equals(var1));

      if (var2.hasNext()) {
         return var2.next();
      } else {
         return var0.iterator().next();
      }
   }

   public <T extends Comparable<T>> alz a(amo<T> var1) {
      return this.a(var1, (Comparable)a(var1.c(), this.b(var1)));
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(afh.c.c(this.c()));
      if (!this.b().isEmpty()) {
         var1.append("[");
         a.appendTo(var1, Iterables.transform(this.b().entrySet(), b));
         var1.append("]");
      }

      return var1.toString();
   }
}
