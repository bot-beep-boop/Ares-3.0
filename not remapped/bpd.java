public class bpd extends bpb {
   private float l = 0.0F;
   private final va k;

   public void c() {
      if (this.k.I) {
         this.j = true;
      } else {
         this.d = (float)this.k.s;
         this.e = (float)this.k.t;
         this.f = (float)this.k.u;
         float var1 = ns.a(this.k.v * this.k.v + this.k.x * this.k.x);
         if ((double)var1 >= 0.01D) {
            this.l = ns.a(this.l + 0.0025F, 0.0F, 1.0F);
            this.b = 0.0F + ns.a(var1, 0.0F, 0.5F) * 0.7F;
         } else {
            this.l = 0.0F;
            this.b = 0.0F;
         }

      }
   }

   public bpd(va var1) {
      super(new jy("minecraft:minecart.base"));
      this.k = var1;
      this.g = true;
      this.h = 0;
   }
}
