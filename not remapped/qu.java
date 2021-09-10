public class qu extends qx {
   private int h = -1;
   private int g;

   public boolean b() {
      double var1 = this.a.b((cj)this.b);
      boolean var3;
      if (this.g <= 240) {
         agh var10000 = this.c;
         if (!agh.f(this.a.o, this.b) && var1 < 4.0D) {
            var3 = true;
            return var3;
         }
      }

      var3 = false;
      return var3;
   }

   public void e() {
      super.e();
      if (this.a.bc().nextInt(20) == 0) {
         this.a.o.b(1010, this.b, 0);
      }

      ++this.g;
      int var1 = (int)((float)this.g / 240.0F * 10.0F);
      if (var1 != this.h) {
         this.a.o.c(this.a.F(), this.b, var1);
         this.h = var1;
      }

      if (this.g == 240 && this.a.o.aa() == oj.d) {
         this.a.o.g(this.b);
         this.a.o.b(1012, this.b, 0);
         this.a.o.b(2001, this.b, afh.a((afh)this.c));
      }

   }

   public qu(ps var1) {
      super(var1);
   }

   public boolean a() {
      if (!super.a()) {
         return false;
      } else if (!this.a.o.Q().b("mobGriefing")) {
         return false;
      } else {
         agh var10000 = this.c;
         return !agh.f(this.a.o, this.b);
      }
   }

   public void d() {
      super.d();
      this.a.o.c(this.a.F(), this.b, -1);
   }

   public void c() {
      super.c();
      this.g = 0;
   }
}
