public class rt extends rd {
   private wi b;
   private int c;
   private ty a;

   public void e() {
      this.a.p().a(this.b, 30.0F, 30.0F);
      --this.c;
   }

   public boolean a() {
      if (!this.a.o.w()) {
         return false;
      } else if (this.a.bc().nextInt(8000) != 0) {
         return false;
      } else {
         this.b = (wi)this.a.o.a((Class)wi.class, (aug)this.a.aR().b(6.0D, 2.0D, 6.0D), (pk)this.a);
         return this.b != null;
      }
   }

   public boolean b() {
      return this.c > 0;
   }

   public void c() {
      this.c = 400;
      this.a.a(true);
   }

   public rt(ty var1) {
      this.a = var1;
      this.a(3);
   }

   public void d() {
      this.a.a(false);
      this.b = null;
   }
}
