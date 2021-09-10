import com.google.common.base.Objects;
import java.util.List;

public class baj {
   private final bag a;
   private final int c;
   private final List<bah> b;

   public baj(bag var1, List<bah> var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public bah a(int var1) {
      return var1 >= 0 && var1 < this.b.size() ? (bah)Objects.firstNonNull(this.b.get(var1), baf.a) : baf.a;
   }

   public int b() {
      return this.c;
   }
}
