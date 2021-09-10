import com.google.common.collect.Multimap;
import java.util.Set;

public class za extends zw {
   protected zw.a b;
   private float d;
   private Set<afh> c;
   protected float a = 4.0F;

   public boolean a(zx var1, zx var2) {
      return this.b.f() == var2.b() ? true : super.a(var1, var2);
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(zx var1, adm var2, afh var3, cj var4, pr var5) {
      if ((double)var3.g(var2, var4) != 0.0D) {
         var1.a(1, (pr)var5);
      }

      return true;
   }

   public boolean w_() {
      return true;
   }

   public zw.a g() {
      return this.b;
   }

   protected za(float var1, zw.a var2, Set<afh> var3) {
      this.b = var2;
      this.c = var3;
      this.h = 1;
      this.d(var2.a());
      this.a = var2.b();
      this.d = var1 + var2.c();
      this.a(yz.i);
   }

   public int b() {
      return this.b.e();
   }

   public Multimap<String, qd> i() {
      Multimap var1 = super.i();
      var1.put(vy.e.a(), new qd(f, "Tool modifier", (double)this.d, 0));
      return var1;
   }

   public boolean a(zx var1, pr var2, pr var3) {
      var1.a(2, (pr)var3);
      return true;
   }

   public float a(zx var1, afh var2) {
      return this.c.contains(var2) ? this.a : 1.0F;
   }
}
