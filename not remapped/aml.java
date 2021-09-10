import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;

public class aml extends amm<cq> {
   public static aml a(String var0) {
      return a(var0, Predicates.alwaysTrue());
   }

   public static aml a(String var0, Predicate<cq> var1) {
      return a(var0, Collections2.filter(Lists.newArrayList(cq.values()), var1));
   }

   protected aml(String var1, Collection<cq> var2) {
      super(var1, cq.class, var2);
   }

   public static aml a(String var0, Collection<cq> var1) {
      return new aml(var0, var1);
   }
}
