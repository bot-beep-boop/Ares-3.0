import com.google.common.collect.Maps;
import java.util.Map;

public class bez extends oq implements oo {
   private String a;
   private Map<Integer, Integer> b = Maps.newHashMap();

   public bez(String var1, eu var2, int var3) {
      super(var2, var3);
      this.a = var1;
   }

   public boolean r_() {
      return false;
   }

   public on i() {
      return on.a;
   }

   public int a_(int var1) {
      return this.b.containsKey(var1) ? (Integer)this.b.get(var1) : 0;
   }

   public void b(int var1, int var2) {
      this.b.put(var1, var2);
   }

   public void a(on var1) {
   }

   public String k() {
      return this.a;
   }

   public int g() {
      return this.b.size();
   }

   public xi a(wm var1, wn var2) {
      throw new UnsupportedOperationException();
   }
}
