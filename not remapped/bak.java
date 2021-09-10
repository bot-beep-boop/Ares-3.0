import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class bak implements bah, bag {
   private static final Ordering<bdc> a = Ordering.from(new Comparator<bdc>() {
      public int compare(Object var1, Object var2) {
         return this.a((bdc)var1, (bdc)var2);
      }

      public int a(bdc var1, bdc var2) {
         return ComparisonChain.start().compare(var1.a().getId(), var2.a().getId()).result();
      }
   });
   private final List<bah> b;

   public void a(float var1, int var2) {
      ave.A().P().a(awm.a);
      avp.a(0, 0, 0.0F, 0.0F, 16, 16, 256.0F, 256.0F);
   }

   public bak() {
      this(a.sortedCopy(ave.A().u().d()));
   }

   public eu A_() {
      return new fa("Teleport to player");
   }

   public void a(baf var1) {
      var1.a(this);
   }

   public bak(Collection<bdc> var1) {
      this.b = Lists.newArrayList();
      Iterator var2 = a.sortedCopy(var1).iterator();

      while(var2.hasNext()) {
         bdc var3 = (bdc)var2.next();
         if (var3.b() != adp.a.e) {
            this.b.add(new bad(var3.a()));
         }
      }

   }

   public eu b() {
      return new fa("Select a player to teleport to");
   }

   public List<bah> a() {
      return this.b;
   }

   public boolean B_() {
      return !this.b.isEmpty();
   }
}
