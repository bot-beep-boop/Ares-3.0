import com.google.common.collect.Lists;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmu {
   private final List<bmv> b;
   private List<Integer> f;
   private final List<Integer> c;
   private int e;
   private int g;
   private static final Logger a = LogManager.getLogger();
   private int d;

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d;
      return var1;
   }

   public String toString() {
      String var1 = "format: " + this.b.size() + " elements: ";

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         var1 = var1 + ((bmv)this.b.get(var2)).toString();
         if (var2 != this.b.size() - 1) {
            var1 = var1 + " ";
         }
      }

      return var1;
   }

   public int d(int var1) {
      return (Integer)this.c.get(var1);
   }

   public bmv c(int var1) {
      return (bmv)this.b.get(var1);
   }

   public int e() {
      return this.e;
   }

   public List<bmv> h() {
      return this.b;
   }

   public boolean d() {
      return this.e >= 0;
   }

   public boolean a(int var1) {
      return this.f.size() - 1 >= var1;
   }

   public int i() {
      return this.b.size();
   }

   public bmu(bmu var1) {
      this();

      for(int var2 = 0; var2 < var1.i(); ++var2) {
         this.a(var1.c(var2));
      }

      this.d = var1.g();
   }

   public bmu a(bmv var1) {
      if (var1.f() && this.j()) {
         a.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
         return this;
      } else {
         this.b.add(var1);
         this.c.add(this.d);
         switch(var1.b()) {
         case b:
            this.g = this.d;
            break;
         case c:
            this.e = this.d;
            break;
         case d:
            this.f.add(var1.d(), this.d);
         }

         this.d += var1.e();
         return this;
      }
   }

   public boolean b() {
      return this.g >= 0;
   }

   public void a() {
      this.b.clear();
      this.c.clear();
      this.e = -1;
      this.f.clear();
      this.g = -1;
      this.d = 0;
   }

   private boolean j() {
      int var1 = 0;

      for(int var2 = this.b.size(); var1 < var2; ++var1) {
         bmv var3 = (bmv)this.b.get(var1);
         if (var3.f()) {
            return true;
         }
      }

      return false;
   }

   public int b(int var1) {
      return (Integer)this.f.get(var1);
   }

   public int f() {
      return this.g() / 4;
   }

   public bmu() {
      this.b = Lists.newArrayList();
      this.c = Lists.newArrayList();
      this.d = 0;
      this.e = -1;
      this.f = Lists.newArrayList();
      this.g = -1;
   }

   public int c() {
      return this.g;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         bmu var2 = (bmu)var1;
         if (this.d != var2.d) {
            return false;
         } else if (!this.b.equals(var2.b)) {
            return false;
         } else {
            return this.c.equals(var2.c);
         }
      } else {
         return false;
      }
   }

   public int g() {
      return this.d;
   }
}
