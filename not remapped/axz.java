public class axz extends axu {
   private final axu f;
   private String h;
   protected String a = "Options";
   private final avh g;

   public void b() {
      byte var1 = 0;
      this.a = bnq.a("options.sounds.title");
      this.h = bnq.a("options.off");
      this.n.add(new axz.a(this, bpg.a.b(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 - 12 + 24 * (var1 >> 1), bpg.a, true));
      int var6 = var1 + 2;
      bpg[] var2 = bpg.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         bpg var5 = var2[var4];
         if (var5 != bpg.a) {
            this.n.add(new axz.a(this, var5.b(), this.l / 2 - 155 + var6 % 2 * 160, this.m / 6 - 12 + 24 * (var6 >> 1), var5, false));
            ++var6;
         }
      }

      this.n.add(new avs(200, this.l / 2 - 100, this.m / 6 + 168, bnq.a("gui.done")));
   }

   public axz(axu var1, avh var2) {
      this.f = var1;
      this.g = var2;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.a, this.l / 2, 15, 16777215);
      super.a(var1, var2, var3);
   }

   static avh a(axz var0) {
      return var0.g;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.f);
         }

      }
   }

   protected String a(bpg var1) {
      float var2 = this.g.a(var1);
      return var2 == 0.0F ? this.h : (int)(var2 * 100.0F) + "%";
   }

   class a extends avs {
      final axz q;
      public boolean p;
      private final String s;
      private final bpg r;
      public float o;

      protected void b(ave var1, int var2, int var3) {
         if (this.m) {
            if (this.p) {
               this.o = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
               this.o = ns.a(this.o, 0.0F, 1.0F);
               var1.t.a(this.r, this.o);
               var1.t.b();
               this.j = this.s + ": " + this.q.a(this.r);
            }

            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            this.b(this.h + (int)(this.o * (float)(this.f - 8)), this.i, 0, 66, 4, 20);
            this.b(this.h + (int)(this.o * (float)(this.f - 8)) + 4, this.i, 196, 66, 4, 20);
         }
      }

      protected int a(boolean var1) {
         return 0;
      }

      public boolean c(ave var1, int var2, int var3) {
         if (super.c(var1, var2, var3)) {
            this.o = (float)(var2 - (this.h + 4)) / (float)(this.f - 8);
            this.o = ns.a(this.o, 0.0F, 1.0F);
            var1.t.a(this.r, this.o);
            var1.t.b();
            this.j = this.s + ": " + this.q.a(this.r);
            this.p = true;
            return true;
         } else {
            return false;
         }
      }

      public void a(bpz var1) {
      }

      public a(axz var1, int var2, int var3, int var4, bpg var5, boolean var6) {
         super(var2, var3, var4, var6 ? 310 : 150, 20, "");
         this.q = var1;
         this.o = 1.0F;
         this.r = var5;
         this.s = bnq.a("soundCategory." + var5.a());
         this.j = this.s + ": " + var1.a(var5);
         this.o = axz.a(var1).a(var5);
      }

      public void a(int var1, int var2) {
         if (this.p) {
            if (this.r == bpg.a) {
               float var10000 = 1.0F;
            } else {
               axz.a(this.q).a(this.r);
            }

            this.q.j.W().a((bpj)bpf.a(new jy("gui.button.press"), 1.0F));
         }

         this.p = false;
      }
   }
}
