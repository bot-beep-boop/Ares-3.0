import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;

public class qs<T extends pk> extends rd {
   protected T b;
   private float f;
   private final Predicate<pk> c;
   private double d;
   private Predicate<? super T> j;
   private Class<T> i;
   private asx g;
   private double e;
   private sw h;
   protected py a;

   public void e() {
      if (this.a.h(this.b) < 49.0D) {
         this.a.s().a(this.e);
      } else {
         this.a.s().a(this.d);
      }

   }

   public qs(py var1, Class<T> var2, float var3, double var4, double var6) {
      this(var1, var2, Predicates.alwaysTrue(), var3, var4, var6);
   }

   public boolean b() {
      return !this.h.m();
   }

   public boolean a() {
      List var1 = this.a.o.a(this.i, this.a.aR().b((double)this.f, 3.0D, (double)this.f), Predicates.and(new Predicate[]{po.d, this.c, this.j}));
      if (var1.isEmpty()) {
         return false;
      } else {
         this.b = (pk)var1.get(0);
         aui var2 = tc.b(this.a, 16, 7, new aui(this.b.s, this.b.t, this.b.u));
         if (var2 == null) {
            return false;
         } else if (this.b.e(var2.a, var2.b, var2.c) < this.b.h(this.a)) {
            return false;
         } else {
            this.g = this.h.a(var2.a, var2.b, var2.c);
            if (this.g == null) {
               return false;
            } else {
               return this.g.b(var2);
            }
         }
      }
   }

   public void d() {
      this.b = null;
   }

   public qs(py var1, Class<T> var2, Predicate<? super T> var3, float var4, double var5, double var7) {
      this.c = new Predicate<pk>(this) {
         final qs a;

         public boolean a(pk var1) {
            return var1.ai() && this.a.a.t().a(var1);
         }

         {
            this.a = var1;
         }

         public boolean apply(Object var1) {
            return this.a((pk)var1);
         }
      };
      this.a = var1;
      this.i = var2;
      this.j = var3;
      this.f = var4;
      this.d = var5;
      this.e = var7;
      this.h = var1.s();
      this.a(1);
   }

   public void c() {
      this.h.a(this.g, this.d);
   }
}
