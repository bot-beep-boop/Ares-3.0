public class axn extends axu implements awx {
   private final axu g;
   protected String a = "Options";
   private final avh h;
   private awc r;
   private static final avh.a[] f;
   private avs i;

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k < 100 && var1 instanceof awe) {
            avh.a var2 = ((awe)var1).c();
            this.h.a((avh.a)var2, 1);
            var1.j = this.h.c(avh.a.a(var1.k));
         }

         if (var1.k == 108) {
            this.j.f.P().a(oj.a(this.j.f.aa().a() + 1));
            this.i.j = this.a(this.j.f.aa());
         }

         if (var1.k == 109) {
            this.j.a((axu)(new awy(this, (new fb("difficulty.lock.title", new Object[0])).d(), (new fb("difficulty.lock.question", new Object[]{new fb(this.j.f.P().y().b(), new Object[0])})).d(), 109)));
         }

         if (var1.k == 110) {
            this.j.t.b();
            this.j.a((axu)(new axx(this)));
         }

         if (var1.k == 8675309) {
            this.j.o.d();
         }

         if (var1.k == 101) {
            this.j.t.b();
            this.j.a((axu)(new ayb(this, this.h)));
         }

         if (var1.k == 100) {
            this.j.t.b();
            this.j.a((axu)(new ayj(this, this.h)));
         }

         if (var1.k == 102) {
            this.j.t.b();
            this.j.a((axu)(new axl(this, this.h, this.j.S())));
         }

         if (var1.k == 103) {
            this.j.t.b();
            this.j.a((axu)(new awu(this, this.h)));
         }

         if (var1.k == 104) {
            this.j.t.b();
            this.j.a((axu)(new axy(this, this.h)));
         }

         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.g);
         }

         if (var1.k == 105) {
            this.j.t.b();
            this.j.a((axu)(new azo(this)));
         }

         if (var1.k == 106) {
            this.j.t.b();
            this.j.a((axu)(new axz(this, this.h)));
         }

         if (var1.k == 107) {
            this.j.t.b();
            bqm var3 = this.j.Y();
            if (var3.i() && var3.A()) {
               this.j.a((axu)(new azz(this, this.h)));
            } else {
               baa.a((axu)this);
            }
         }

      }
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.a, this.l / 2, 15, 16777215);
      super.a(var1, var2, var3);
   }

   static {
      f = new avh.a[]{avh.a.c};
   }

   public String a(oj var1) {
      fa var2 = new fa("");
      var2.a((eu)(new fb("options.difficulty", new Object[0])));
      var2.a(": ");
      var2.a((eu)(new fb(var1.b(), new Object[0])));
      return var2.d();
   }

   public void b() {
      int var1 = 0;
      this.a = bnq.a("options.title");
      avh.a[] var2 = f;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         avh.a var5 = var2[var4];
         if (var5.a()) {
            this.n.add(new awj(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 - 12 + 24 * (var1 >> 1), var5));
         } else {
            awe var6 = new awe(var5.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 - 12 + 24 * (var1 >> 1), var5, this.h.c(var5));
            this.n.add(var6);
         }

         ++var1;
      }

      if (this.j.f != null) {
         oj var7 = this.j.f.aa();
         this.i = new avs(108, this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 - 12 + 24 * (var1 >> 1), 150, 20, this.a(var7));
         this.n.add(this.i);
         if (this.j.F() && !this.j.f.P().t()) {
            this.i.a(this.i.b() - 20);
            this.r = new awc(109, this.i.h + this.i.b(), this.i.i);
            this.n.add(this.r);
            this.r.b(this.j.f.P().z());
            this.r.l = !this.r.c();
            this.i.l = !this.r.c();
         } else {
            this.i.l = false;
         }
      } else {
         awe var8 = new awe(avh.a.S.c(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 - 12 + 24 * (var1 >> 1), avh.a.S, this.h.c(avh.a.S));
         this.n.add(var8);
      }

      this.n.add(new avs(110, this.l / 2 - 155, this.m / 6 + 48 - 6, 150, 20, bnq.a("options.skinCustomisation")));
      this.n.add(new avs(this, 8675309, this.l / 2 + 5, this.m / 6 + 48 - 6, 150, 20, "Super Secret Settings...") {
         final axn o;

         {
            this.o = var1;
         }

         public void a(bpz var1) {
            bpy var2 = var1.a(bpg.g, bpg.e, bpg.f, bpg.h, bpg.d);
            if (var2 != null) {
               var1.a((bpj)bpf.a(var2.c(), 0.5F));
            }

         }
      });
      this.n.add(new avs(106, this.l / 2 - 155, this.m / 6 + 72 - 6, 150, 20, bnq.a("options.sounds")));
      this.n.add(new avs(107, this.l / 2 + 5, this.m / 6 + 72 - 6, 150, 20, bnq.a("options.stream")));
      this.n.add(new avs(101, this.l / 2 - 155, this.m / 6 + 96 - 6, 150, 20, bnq.a("options.video")));
      this.n.add(new avs(100, this.l / 2 + 5, this.m / 6 + 96 - 6, 150, 20, bnq.a("options.controls")));
      this.n.add(new avs(102, this.l / 2 - 155, this.m / 6 + 120 - 6, 150, 20, bnq.a("options.language")));
      this.n.add(new avs(103, this.l / 2 + 5, this.m / 6 + 120 - 6, 150, 20, bnq.a("options.chat.title")));
      this.n.add(new avs(105, this.l / 2 - 155, this.m / 6 + 144 - 6, 150, 20, bnq.a("options.resourcepack")));
      this.n.add(new avs(104, this.l / 2 + 5, this.m / 6 + 144 - 6, 150, 20, bnq.a("options.snooper.view")));
      this.n.add(new avs(200, this.l / 2 - 100, this.m / 6 + 168, bnq.a("gui.done")));
   }

   public axn(axu var1, avh var2) {
      this.g = var1;
      this.h = var2;
   }

   public void a(boolean var1, int var2) {
      this.j.a((axu)this);
      if (var2 == 109 && var1 && this.j.f != null) {
         this.j.f.P().e(true);
         this.r.b(true);
         this.r.l = false;
         this.i.l = false;
      }

   }
}
