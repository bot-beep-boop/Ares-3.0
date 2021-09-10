import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bnn implements bng {
   private final Set<String> e = Sets.newLinkedHashSet();
   private final List<bnj> d = Lists.newArrayList();
   private static final Joiner b = Joiner.on(", ");
   private final bny f;
   private final Map<String, bnb> c = Maps.newHashMap();
   private static final Logger a = LogManager.getLogger();

   public List<bnh> b(jy var1) throws IOException {
      bni var2 = (bni)this.c.get(var1.b());
      if (var2 != null) {
         return var2.b(var1);
      } else {
         throw new FileNotFoundException(var1.toString());
      }
   }

   public Set<String> a() {
      return this.e;
   }

   public void a(List<bnk> var1) {
      this.b();
      a.info("Reloading ResourceManager: " + b.join(Iterables.transform(var1, new Function<bnk, String>(this) {
         final bnn a;

         public Object apply(Object var1) {
            return this.a((bnk)var1);
         }

         public String a(bnk var1) {
            return var1.b();
         }

         {
            this.a = var1;
         }
      })));
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bnk var3 = (bnk)var2.next();
         this.a(var3);
      }

      this.c();
   }

   public void a(bnk var1) {
      bnb var4;
      for(Iterator var2 = var1.c().iterator(); var2.hasNext(); var4.a(var1)) {
         String var3 = (String)var2.next();
         this.e.add(var3);
         var4 = (bnb)this.c.get(var3);
         if (var4 == null) {
            var4 = new bnb(this.f);
            this.c.put(var3, var4);
         }
      }

   }

   public void a(bnj var1) {
      this.d.add(var1);
      var1.a(this);
   }

   public bnh a(jy var1) throws IOException {
      bni var2 = (bni)this.c.get(var1.b());
      if (var2 != null) {
         return var2.a(var1);
      } else {
         throw new FileNotFoundException(var1.toString());
      }
   }

   private void c() {
      Iterator var1 = this.d.iterator();

      while(var1.hasNext()) {
         bnj var2 = (bnj)var1.next();
         var2.a(this);
      }

   }

   public bnn(bny var1) {
      this.f = var1;
   }

   private void b() {
      this.c.clear();
      this.e.clear();
   }
}
