public class azz extends axu {
   private String i;
   private int s;
   private static final avh.a[] a;
   private String r;
   private final axu g;
   private boolean t = false;
   private final avh h;
   private static final avh.a[] f;

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k < 100 && var1 instanceof awe) {
            avh.a var2 = ((awe)var1).c();
            this.h.a((avh.a)var2, 1);
            var1.j = this.h.c(avh.a.a(var1.k));
            if (this.j.Y().k() && var2 != avh.a.M && var2 != avh.a.N) {
               this.t = true;
            }
         } else if (var1 instanceof awj) {
            if (var1.k == avh.a.G.c()) {
               this.j.Y().p();
            } else if (var1.k == avh.a.H.c()) {
               this.j.Y().p();
            } else if (this.j.Y().k()) {
               this.t = true;
            }
         }

         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.g);
         } else if (var1.k == 201) {
            this.j.t.b();
            this.j.a((axu)(new azy(this)));
         }

      }
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.i, this.l / 2, 20, 16777215);
      this.a(this.q, this.r, this.l / 2, this.s, 16777215);
      if (this.t) {
         this.a(this.q, a.m + bnq.a("options.stream.changes"), this.l / 2, 20 + this.q.a, 16777215);
      }

      super.a(var1, var2, var3);
   }

   public azz(axu var1, avh var2) {
      this.g = var1;
      this.h = var2;
   }

   public void b() {
      int var1 = 0;
      this.i = bnq.a("options.stream.title");
      this.r = bnq.a("options.stream.chat.title");
      avh.a[] var2 = a;
      int var3 = var2.length;

      int var4;
      avh.a var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var5.a()) {
            this.n.add(new awj(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5));
         } else {
            this.n.add(new awe(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5, this.h.c(var5)));
         }

         ++var1;
      }

      if (var1 % 2 == 1) {
         ++var1;
      }

      this.s = this.m / 6 + 24 * (var1 >> 1) + 6;
      var1 += 2;
      var2 = f;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var5.a()) {
            this.n.add(new awj(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5));
         } else {
            this.n.add(new awe(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), var5, this.h.c(var5)));
         }

         ++var1;
      }

      this.n.add(new avs(200, this.l / 2 - 155, this.m / 6 + 168, 150, 20, bnq.a("gui.done")));
      avs var6 = new avs(201, this.l / 2 + 5, this.m / 6 + 168, 150, 20, bnq.a("options.stream.ingestSelection"));
      var6.l = this.j.Y().j() && this.j.Y().s().length > 0 || this.j.Y().w();
      this.n.add(var6);
   }

   static {
      a = new avh.a[]{avh.a.F, avh.a.J, avh.a.I, avh.a.L, avh.a.G, avh.a.H, avh.a.O, avh.a.K};
      f = new avh.a[]{avh.a.M, avh.a.N};
   }
}
