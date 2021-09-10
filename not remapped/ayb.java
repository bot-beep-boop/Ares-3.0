public class ayb extends axu {
   private static final avh.a[] i;
   protected String a = "Video Settings";
   private avh g;
   private axu f;
   private awd h;

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.f);
         }

      }
   }

   public ayb(axu var1, avh var2) {
      this.f = var1;
      this.g = var2;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.h.a(var1, var2, var3);
      this.a(this.q, this.a, this.l / 2, 5, 16777215);
      super.a(var1, var2, var3);
   }

   protected void a(int var1, int var2, int var3) {
      int var4 = this.g.aL;
      super.a(var1, var2, var3);
      this.h.b(var1, var2, var3);
      if (this.g.aL != var4) {
         avr var5 = new avr(this.j);
         int var6 = var5.a();
         int var7 = var5.b();
         this.a(this.j, var6, var7);
      }

   }

   public void b() {
      this.a = bnq.a("options.videoTitle");
      this.n.clear();
      this.n.add(new avs(200, this.l / 2 - 100, this.m - 27, bnq.a("gui.done")));
      if (!bqs.P) {
         avh.a[] var1 = new avh.a[i.length - 1];
         int var2 = 0;
         avh.a[] var3 = i;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            avh.a var6 = var3[var5];
            if (var6 == avh.a.x) {
               break;
            }

            var1[var2] = var6;
            ++var2;
         }

         this.h = new awf(this.j, this.l, this.m, 32, this.m - 32, 25, var1);
      } else {
         this.h = new awf(this.j, this.l, this.m, 32, this.m - 32, 25, i);
      }

   }

   public void k() {
      super.k();
      this.h.p();
   }

   protected void b(int var1, int var2, int var3) {
      int var4 = this.g.aL;
      super.b(var1, var2, var3);
      this.h.c(var1, var2, var3);
      if (this.g.aL != var4) {
         avr var5 = new avr(this.j);
         int var6 = var5.a();
         int var7 = var5.b();
         this.a(this.j, var6, var7);
      }

   }

   static {
      i = new avh.a[]{avh.a.l, avh.a.f, avh.a.m, avh.a.i, avh.a.h, avh.a.g, avh.a.n, avh.a.d, avh.a.k, avh.a.o, avh.a.v, avh.a.w, avh.a.D, avh.a.P, avh.a.x, avh.a.R};
   }
}
