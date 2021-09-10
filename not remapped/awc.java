public class awc extends avs {
   private boolean o = false;

   public void b(boolean var1) {
      this.o = var1;
   }

   public awc(int var1, int var2, int var3) {
      super(var1, var2, var3, 20, 20, "");
   }

   public void a(ave var1, int var2, int var3) {
      if (this.m) {
         var1.P().a(avs.a);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var4 = var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
         awc.a var5;
         if (this.o) {
            if (!this.l) {
               var5 = awc.a.c;
            } else if (var4) {
               var5 = awc.a.b;
            } else {
               var5 = awc.a.a;
            }
         } else if (!this.l) {
            var5 = awc.a.f;
         } else if (var4) {
            var5 = awc.a.e;
         } else {
            var5 = awc.a.d;
         }

         this.b(this.h, this.i, var5.a(), var5.b(), this.f, this.g);
      }
   }

   public boolean c() {
      return this.o;
   }

   static enum a {
      private final int g;
      a(0, 146);

      private static final awc.a[] i = new awc.a[]{a, b, c, d, e, f};
      e(20, 166);

      private final int h;
      d(20, 146),
      b(0, 166),
      c(0, 186),
      f(20, 186);

      public int a() {
         return this.g;
      }

      private a(int var3, int var4) {
         this.g = var3;
         this.h = var4;
      }

      public int b() {
         return this.h;
      }
   }
}
