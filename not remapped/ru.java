public class ru extends qx {
   boolean g;
   int h;

   public void d() {
      if (this.g) {
         this.c.a(this.a.o, this.b, false);
      }

   }

   public void e() {
      --this.h;
      super.e();
   }

   public ru(ps var1, boolean var2) {
      super(var1);
      this.a = var1;
      this.g = var2;
   }

   public boolean b() {
      return this.g && this.h > 0 && super.b();
   }

   public void c() {
      this.h = 20;
      this.c.a(this.a.o, this.b, true);
   }
}
