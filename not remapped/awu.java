public class awu extends axu {
   private String h;
   private final axu f;
   private final avh g;
   private static final avh.a[] a;

   public awu(axu var1, avh var2) {
      this.f = var1;
      this.g = var2;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k < 100 && var1 instanceof awe) {
            this.g.a((avh.a)((awe)var1).c(), 1);
            var1.j = this.g.c(avh.a.a(var1.k));
         }

         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.f);
         }

      }
   }

   static {
      a = new avh.a[]{avh.a.p, avh.a.q, avh.a.r, avh.a.s, avh.a.t, avh.a.z, avh.a.B, avh.a.C, avh.a.A, avh.a.Q};
   }

   public void b() {
      int var1 = 0;
      this.h = bnq.a("options.chat.title");
      avh.a[] var2 = a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         avh.a var5 = var2[var4];
         if (var5.a()) {
            this.n.add(new awj(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5));
         } else {
            this.n.add(new awe(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5, this.g.c(var5)));
         }

         ++var1;
      }

      this.n.add(new avs(200, this.l / 2 - 100, this.m / 6 + 120, bnq.a("gui.done")));
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.h, this.l / 2, 20, 16777215);
      super.a(var1, var2, var3);
   }
}
