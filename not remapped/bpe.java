public class bpe extends bpb {
   private final va l;
   private final wn k;

   public bpe(wn var1, va var2) {
      super(new jy("minecraft:minecart.inside"));
      this.k = var1;
      this.l = var2;
      this.i = bpj.a.a;
      this.g = true;
      this.h = 0;
   }

   public void c() {
      if (!this.l.I && this.k.au() && this.k.m == this.l) {
         float var1 = ns.a(this.l.v * this.l.v + this.l.x * this.l.x);
         if ((double)var1 >= 0.01D) {
            this.b = 0.0F + ns.a(var1, 0.0F, 1.0F) * 0.75F;
         } else {
            this.b = 0.0F;
         }

      } else {
         this.j = true;
      }
   }
}
