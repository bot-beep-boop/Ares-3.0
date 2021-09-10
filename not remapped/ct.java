import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public class ct<T> implements cs<T> {
   private final IdentityHashMap<T, Integer> a = new IdentityHashMap(512);
   private final List<T> b = Lists.newArrayList();

   public Iterator<T> iterator() {
      return Iterators.filter(this.b.iterator(), Predicates.notNull());
   }

   public void a(T var1, int var2) {
      this.a.put(var1, var2);

      while(this.b.size() <= var2) {
         this.b.add((Object)null);
      }

      this.b.set(var2, var1);
   }

   public final T a(int var1) {
      return var1 >= 0 && var1 < this.b.size() ? this.b.get(var1) : null;
   }

   public int b(T var1) {
      Integer var2 = (Integer)this.a.get(var1);
      return var2 == null ? -1 : var2;
   }
}
