import com.google.common.collect.ImmutableSet;
import java.util.Collection;

public class amk extends amj<Boolean> {
   private final ImmutableSet<Boolean> a = ImmutableSet.of(true, false);

   public String a(Comparable var1) {
      return this.a((Boolean)var1);
   }

   public String a(Boolean var1) {
      return var1.toString();
   }

   public Collection<Boolean> c() {
      return this.a;
   }

   public static amk a(String var0) {
      return new amk(var0);
   }

   protected amk(String var1) {
      super(var1, Boolean.class);
   }
}
