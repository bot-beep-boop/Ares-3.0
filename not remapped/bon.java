import java.util.Collections;
import java.util.List;

public class bon implements bnw {
   private final List<Integer> c;
   private final boolean a;
   private final boolean b;

   public List<Integer> c() {
      return Collections.unmodifiableList(this.c);
   }

   public boolean a() {
      return this.a;
   }

   public bon(boolean var1, boolean var2, List<Integer> var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public boolean b() {
      return this.b;
   }
}
