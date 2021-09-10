public class bpc extends bpb {
   private final vt k;

   public void c() {
      if (!this.k.I && this.k.cp()) {
         this.d = (float)this.k.s;
         this.e = (float)this.k.t;
         this.f = (float)this.k.u;
         float var1 = this.k.q(0.0F);
         this.b = 0.0F + 1.0F * var1 * var1;
         this.c = 0.7F + 0.5F * var1;
      } else {
         this.j = true;
      }
   }

   public bpc(vt var1) {
      super(new jy("minecraft:mob.guardian.attack"));
      this.k = var1;
      this.i = bpj.a.a;
      this.g = true;
      this.h = 0;
   }
}
