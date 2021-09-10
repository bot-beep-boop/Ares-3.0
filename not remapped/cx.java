import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;

public class cx<K, V> extends dd<K, V> implements cs<V> {
   protected final ct<V> a = new ct();
   protected final Map<V, K> b;

   public V a(K var1) {
      return super.a(var1);
   }

   public K c(V var1) {
      return this.b.get(var1);
   }

   protected Map<K, V> b() {
      return HashBiMap.create();
   }

   public cx() {
      this.b = ((BiMap)this.c).inverse();
   }

   public Iterator<V> iterator() {
      return this.a.iterator();
   }

   public boolean d(K var1) {
      return super.d(var1);
   }

   public int b(V var1) {
      return this.a.b(var1);
   }

   public V a(int var1) {
      return this.a.a(var1);
   }

   public void a(int var1, K var2, V var3) {
      this.a.a(var3, var1);
      this.a(var2, var3);
   }
}
