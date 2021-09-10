public class bev extends beu {
   private final avh e;

   public bev(avh var1) {
      this.e = var1;
   }

   public void a() {
      this.a = 0.0F;
      this.b = 0.0F;
      if (this.e.Y.d()) {
         ++this.b;
      }

      if (this.e.aa.d()) {
         --this.b;
      }

      if (this.e.Z.d()) {
         ++this.a;
      }

      if (this.e.ab.d()) {
         --this.a;
      }

      this.c = this.e.ac.d();
      this.d = this.e.ad.d();
      if (this.d) {
         this.a = (float)((double)this.a * 0.3D);
         this.b = (float)((double)this.b * 0.3D);
      }

   }
}
