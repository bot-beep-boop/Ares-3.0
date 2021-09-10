import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class es implements eu {
   protected List<eu> a = Lists.newArrayList();
   private ez b;

   public int hashCode() {
      return 31 * this.b.hashCode() + this.a.hashCode();
   }

   public eu a(eu var1) {
      var1.b().a(this.b());
      this.a.add(var1);
      return this;
   }

   public eu a(String var1) {
      return this.a((eu)(new fa(var1)));
   }

   public Iterator<eu> iterator() {
      return Iterators.concat(Iterators.forArray(new es[]{this}), a((Iterable)this.a));
   }

   public final String d() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.append(var3.b().k());
         var1.append(var3.e());
         var1.append(.a.v);
      }

      return var1.toString();
   }

   public ez b() {
      if (this.b == null) {
         this.b = new ez();
         Iterator var1 = this.a.iterator();

         while(var1.hasNext()) {
            eu var2 = (eu)var1.next();
            var2.b().a(this.b);
         }
      }

      return this.b;
   }

   public static Iterator<eu> a(Iterable<eu> var0) {
      Iterator var1 = Iterators.concat(Iterators.transform(var0.iterator(), new Function<eu, Iterator<eu>>() {
         public Object apply(Object var1) {
            return this.a((eu)var1);
         }

         public Iterator<eu> a(eu var1) {
            return var1.iterator();
         }
      }));
      var1 = Iterators.transform(var1, new Function<eu, eu>() {
         public Object apply(Object var1) {
            return this.a((eu)var1);
         }

         public eu a(eu var1) {
            eu var2 = var1.f();
            var2.a(var2.b().n());
            return var2;
         }
      });
      return var1;
   }

   public eu a(ez var1) {
      this.b = var1;
      Iterator var2 = this.a.iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var3.b().a(this.b());
      }

      return this;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof es)) {
         return false;
      } else {
         es var2 = (es)var1;
         return this.a.equals(var2.a) && this.b().equals(var2.b());
      }
   }

   public final String c() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.append(var3.e());
      }

      return var1.toString();
   }

   public String toString() {
      return "BaseComponent{style=" + this.b + ", siblings=" + this.a + '}';
   }

   public List<eu> a() {
      return this.a;
   }
}
