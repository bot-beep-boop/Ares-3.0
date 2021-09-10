public class bkx extends bkn<bbj> {
   public bkx(bjl<?> var1) {
      super(var1);
   }

   protected void a(bbo var1, int var2) {
      this.a((bbj)var1, var2);
   }

   protected void a(bbj var1, int var2) {
      this.a(var1);
      switch(var2) {
      case 1:
         var1.j.j = true;
         var1.k.j = true;
         break;
      case 2:
         var1.g.j = true;
         var1.j.j = true;
         var1.k.j = true;
         break;
      case 3:
         var1.g.j = true;
         var1.h.j = true;
         var1.i.j = true;
         break;
      case 4:
         var1.e.j = true;
         var1.f.j = true;
      }

   }

   protected void a(bbj var1) {
      var1.a(false);
   }

   protected void a() {
      this.c = new bbj(0.5F);
      this.d = new bbj(1.0F);
   }
}
