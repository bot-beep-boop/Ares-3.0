import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class boa implements bnw {
   private final boolean e;
   private final int b;
   private final List<bnz> a;
   private final int d;
   private final int c;

   private bnz d(int var1) {
      return (bnz)this.a.get(var1);
   }

   public Set<Integer> f() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.a.iterator();

      while(var2.hasNext()) {
         bnz var3 = (bnz)var2.next();
         var1.add(var3.c());
      }

      return var1;
   }

   public int b() {
      return this.b;
   }

   public int d() {
      return this.d;
   }

   public int c(int var1) {
      return ((bnz)this.a.get(var1)).c();
   }

   public int a(int var1) {
      bnz var2 = this.d(var1);
      return var2.a() ? this.d : var2.b();
   }

   public boa(List<bnz> var1, int var2, int var3, int var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public boolean e() {
      return this.e;
   }

   public boolean b(int var1) {
      return !((bnz)this.a.get(var1)).a();
   }

   public int a() {
      return this.c;
   }

   public int c() {
      return this.a.size();
   }
}
