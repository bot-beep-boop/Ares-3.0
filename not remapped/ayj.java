public class ayj extends axu {
   public avb f = null;
   private axu i;
   protected String a = "Controls";
   public long g;
   private avh r;
   private avs t;
   private ayi s;
   private static final avh.a[] h;

   public void k() {
      super.k();
      this.s.p();
   }

   protected void b(int var1, int var2, int var3) {
      if (var3 != 0 || !this.s.c(var1, var2, var3)) {
         super.b(var1, var2, var3);
      }

   }

   protected void a(avs var1) {
      if (var1.k == 200) {
         this.j.a(this.i);
      } else if (var1.k == 201) {
         avb[] var2 = this.j.t.ax;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            avb var5 = var2[var4];
            var5.b(var5.h());
         }

         avb.b();
      } else if (var1.k < 100 && var1 instanceof awe) {
         this.r.a((avh.a)((awe)var1).c(), 1);
         var1.j = this.r.c(avh.a.a(var1.k));
      }

   }

   static {
      h = new avh.a[]{avh.a.a, avh.a.b, avh.a.y};
   }

   public void b() {
      this.s = new ayi(this, this.j);
      this.n.add(new avs(200, this.l / 2 - 155, this.m - 29, 150, 20, bnq.a("gui.done")));
      this.n.add(this.t = new avs(201, this.l / 2 - 155 + 160, this.m - 29, 150, 20, bnq.a("controls.resetAll")));
      this.a = bnq.a("controls.title");
      int var1 = 0;
      avh.a[] var2 = h;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         avh.a var5 = var2[var4];
         if (var5.a()) {
            this.n.add(new awj(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, 18 + 24 * (var1 >> 1), var5));
         } else {
            this.n.add(new awe(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, 18 + 24 * (var1 >> 1), var5, this.r.c(var5)));
         }

         ++var1;
      }

   }

   public ayj(axu var1, avh var2) {
      this.i = var1;
      this.r = var2;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.s.a(var1, var2, var3);
      this.a(this.q, this.a, this.l / 2, 8, 16777215);
      boolean var4 = true;
      avb[] var5 = this.r.ax;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         avb var8 = var5[var7];
         if (var8.i() != var8.h()) {
            var4 = false;
            break;
         }
      }

      this.t.l = !var4;
      super.a(var1, var2, var3);
   }

   protected void a(int var1, int var2, int var3) {
      if (this.f != null) {
         this.r.a(this.f, -100 + var3);
         this.f = null;
         avb.b();
      } else if (var3 != 0 || !this.s.b(var1, var2, var3)) {
         super.a(var1, var2, var3);
      }

   }

   protected void a(char var1, int var2) {
      if (this.f != null) {
         if (var2 == 1) {
            this.r.a((avb)this.f, 0);
         } else if (var2 != 0) {
            this.r.a(this.f, var2);
         } else if (var1 > 0) {
            this.r.a(this.f, var1 + 256);
         }

         this.f = null;
         this.g = ave.J();
         avb.b();
      } else {
         super.a(var1, var2);
      }

   }
}
