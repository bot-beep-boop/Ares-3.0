import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class qh implements qc {
   private double f;
   private final Map<UUID, qd> e = Maps.newHashMap();
   private final qb b;
   private double h;
   private final qf a;
   private final Map<Integer, Set<qd>> c = Maps.newHashMap();
   private final Map<String, Set<qd>> d = Maps.newHashMap();
   private boolean g = true;

   public double e() {
      if (this.g) {
         this.h = this.g();
         this.g = false;
      }

      return this.h;
   }

   public qh(qf var1, qb var2) {
      this.a = var1;
      this.b = var2;
      this.f = var2.b();

      for(int var3 = 0; var3 < 3; ++var3) {
         this.c.put(var3, Sets.newHashSet());
      }

   }

   public double b() {
      return this.f;
   }

   public qb a() {
      return this.b;
   }

   private double g() {
      double var1 = this.b();

      qd var4;
      for(Iterator var3 = this.b(0).iterator(); var3.hasNext(); var1 += var4.d()) {
         var4 = (qd)var3.next();
      }

      double var7 = var1;

      Iterator var5;
      qd var6;
      for(var5 = this.b(1).iterator(); var5.hasNext(); var7 += var1 * var6.d()) {
         var6 = (qd)var5.next();
      }

      for(var5 = this.b(2).iterator(); var5.hasNext(); var7 *= 1.0D + var6.d()) {
         var6 = (qd)var5.next();
      }

      return this.b.a(var7);
   }

   public Collection<qd> c() {
      HashSet var1 = Sets.newHashSet();

      for(int var2 = 0; var2 < 3; ++var2) {
         var1.addAll(this.a(var2));
      }

      return var1;
   }

   protected void f() {
      this.g = true;
      this.a.a((qc)this);
   }

   public void a(double var1) {
      if (var1 != this.b()) {
         this.f = var1;
         this.f();
      }
   }

   private Collection<qd> b(int var1) {
      HashSet var2 = Sets.newHashSet(this.a(var1));

      for(qb var3 = this.b.d(); var3 != null; var3 = var3.d()) {
         qc var4 = this.a.a(var3);
         if (var4 != null) {
            var2.addAll(var4.a(var1));
         }
      }

      return var2;
   }

   public boolean a(qd var1) {
      return this.e.get(var1.a()) != null;
   }

   public void b(qd var1) {
      if (this.a(var1.a()) != null) {
         throw new IllegalArgumentException("Modifier is already applied on this attribute!");
      } else {
         Object var2 = (Set)this.d.get(var1.b());
         if (var2 == null) {
            var2 = Sets.newHashSet();
            this.d.put(var1.b(), var2);
         }

         ((Set)this.c.get(var1.c())).add(var1);
         ((Set)var2).add(var1);
         this.e.put(var1.a(), var1);
         this.f();
      }
   }

   public void d() {
      Collection var1 = this.c();
      if (var1 != null) {
         ArrayList var4 = Lists.newArrayList(var1);
         Iterator var2 = var4.iterator();

         while(var2.hasNext()) {
            qd var3 = (qd)var2.next();
            this.c(var3);
         }

      }
   }

   public Collection<qd> a(int var1) {
      return (Collection)this.c.get(var1);
   }

   public qd a(UUID var1) {
      return (qd)this.e.get(var1);
   }

   public void c(qd var1) {
      for(int var2 = 0; var2 < 3; ++var2) {
         Set var3 = (Set)this.c.get(var2);
         var3.remove(var1);
      }

      Set var4 = (Set)this.d.get(var1.b());
      if (var4 != null) {
         var4.remove(var1);
         if (var4.isEmpty()) {
            this.d.remove(var1.b());
         }
      }

      this.e.remove(var1.a());
      this.f();
   }
}
