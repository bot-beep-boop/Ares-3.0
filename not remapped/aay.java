import com.google.common.collect.Multimap;

public class aay extends zw {
   private float a;
   private final zw.a b;

   public boolean a(zx var1, zx var2) {
      return this.b.f() == var2.b() ? true : super.a(var1, var2);
   }

   public float a(zx var1, afh var2) {
      if (var2 == afi.G) {
         return 15.0F;
      } else {
         arm var3 = var2.t();
         return var3 != arm.k && var3 != arm.l && var3 != arm.v && var3 != arm.j && var3 != arm.C ? 1.0F : 1.5F;
      }
   }

   public aba e(zx var1) {
      return aba.d;
   }

   public int b() {
      return this.b.e();
   }

   public int d(zx var1) {
      return 72000;
   }

   public boolean b(afh var1) {
      return var1 == afi.G;
   }

   public boolean a(zx var1, adm var2, afh var3, cj var4, pr var5) {
      if ((double)var3.g(var2, var4) != 0.0D) {
         var1.a(2, (pr)var5);
      }

      return true;
   }

   public Multimap<String, qd> i() {
      Multimap var1 = super.i();
      var1.put(vy.e.a(), new qd(f, "Weapon modifier", (double)this.a, 0));
      return var1;
   }

   public float g() {
      return this.b.c();
   }

   public zx a(zx var1, adm var2, wn var3) {
      var3.a(var1, this.d(var1));
      return var1;
   }

   public aay(zw.a var1) {
      this.b = var1;
      this.h = 1;
      this.d(var1.a());
      this.a(yz.j);
      this.a = 4.0F + var1.c();
   }

   public boolean w_() {
      return true;
   }

   public String h() {
      return this.b.toString();
   }

   public boolean a(zx var1, pr var2, pr var3) {
      var1.a(1, (pr)var3);
      return true;
   }
}
