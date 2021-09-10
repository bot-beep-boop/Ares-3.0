import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class qi extends qf {
   private final Set<qc> e = Sets.newHashSet();
   protected final Map<String, qc> d = new nk();

   public void a(qc var1) {
      if (var1.a().c()) {
         this.e.add(var1);
      }

      Iterator var2 = this.c.get(var1.a()).iterator();

      while(var2.hasNext()) {
         qb var3 = (qb)var2.next();
         qh var4 = this.e(var3);
         if (var4 != null) {
            var4.f();
         }
      }

   }

   public qc a(String var1) {
      return this.b(var1);
   }

   public Collection<qc> c() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         qc var3 = (qc)var2.next();
         if (var3.a().c()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public qh e(qb var1) {
      return (qh)super.a(var1);
   }

   public qc b(qb var1) {
      qc var2 = super.b(var1);
      if (var1 instanceof qj && ((qj)var1).g() != null) {
         this.d.put(((qj)var1).g(), var2);
      }

      return var2;
   }

   public Set<qc> b() {
      return this.e;
   }

   protected qc c(qb var1) {
      return new qh(this, var1);
   }

   public qh b(String var1) {
      qc var2 = super.a(var1);
      if (var2 == null) {
         var2 = (qc)this.d.get(var1);
      }

      return (qh)var2;
   }

   public qc a(qb var1) {
      return this.e(var1);
   }
}
