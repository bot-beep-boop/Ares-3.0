public class wl {
   public boolean e = true;
   private float g = 0.1F;
   private float f = 0.05F;
   public boolean a;
   public boolean b;
   public boolean d;
   public boolean c;

   public void a(dn var1) {
      dn var2 = new dn();
      var2.a("invulnerable", this.a);
      var2.a("flying", this.b);
      var2.a("mayfly", this.c);
      var2.a("instabuild", this.d);
      var2.a("mayBuild", this.e);
      var2.a("flySpeed", this.f);
      var2.a("walkSpeed", this.g);
      var1.a((String)"abilities", (eb)var2);
   }

   public float a() {
      return this.f;
   }

   public void a(float var1) {
      this.f = var1;
   }

   public void b(float var1) {
      this.g = var1;
   }

   public float b() {
      return this.g;
   }

   public void b(dn var1) {
      if (var1.b("abilities", 10)) {
         dn var2 = var1.m("abilities");
         this.a = var2.n("invulnerable");
         this.b = var2.n("flying");
         this.c = var2.n("mayfly");
         this.d = var2.n("instabuild");
         if (var2.b("flySpeed", 99)) {
            this.f = var2.h("flySpeed");
            this.g = var2.h("walkSpeed");
         }

         if (var2.b("mayBuild", 1)) {
            this.e = var2.n("mayBuild");
         }
      }

   }
}
