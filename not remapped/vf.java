import java.util.List;

public class vf extends vd implements ali {
   private int b = -1;
   private boolean a = true;
   private cj c;

   public int w() {
      return 1;
   }

   public void t_() {
      super.t_();
      if (!this.o.D && this.ai() && this.y()) {
         cj var1 = new cj(this);
         if (var1.equals(this.c)) {
            --this.b;
         } else {
            this.m(0);
         }

         if (!this.E()) {
            this.m(0);
            if (this.D()) {
               this.m(4);
               this.p_();
            }
         }
      }

   }

   public adm z() {
      return this.o;
   }

   public alz u() {
      return afi.cp.Q();
   }

   public void i(boolean var1) {
      this.a = var1;
   }

   protected void b(dn var1) {
      super.b(var1);
      var1.a("TransferCooldown", this.b);
   }

   protected void a(dn var1) {
      super.a(var1);
      this.b = var1.f("TransferCooldown");
   }

   public int o_() {
      return 5;
   }

   public double C() {
      return this.u;
   }

   public void a(ow var1) {
      super.a(var1);
      if (this.o.Q().b("doEntityDrops")) {
         this.a(zw.a((afh)afi.cp), 1, 0.0F);
      }

   }

   public boolean e(wn var1) {
      if (!this.o.D) {
         var1.a((og)this);
      }

      return true;
   }

   public double B() {
      return this.t + 0.5D;
   }

   public va.a s() {
      return va.a.f;
   }

   public double A() {
      return this.s;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      boolean var5 = !var4;
      if (var5 != this.y()) {
         this.i(var5);
      }

   }

   public void m(int var1) {
      this.b = var1;
   }

   public vf(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
      this.c = cj.a;
   }

   public boolean E() {
      return this.b > 0;
   }

   public String k() {
      return "minecraft:hopper";
   }

   public boolean y() {
      return this.a;
   }

   public boolean D() {
      if (alj.a((ali)this)) {
         return true;
      } else {
         List var1 = this.o.a(uz.class, this.aR().b(0.25D, 0.0D, 0.25D), po.a);
         if (var1.size() > 0) {
            alj.a((og)this, (uz)((uz)var1.get(0)));
         }

         return false;
      }
   }

   public xi a(wm var1, wn var2) {
      return new xw(var1, this, var2);
   }

   public vf(adm var1) {
      super(var1);
      this.c = cj.a;
   }
}
