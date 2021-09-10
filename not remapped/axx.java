public class axx extends axu {
   private String f;
   private final axu a;

   public axx(axu var1) {
      this.a = var1;
   }

   private String a(wo var1) {
      String var2;
      if (this.j.t.d().contains(var1)) {
         var2 = bnq.a("options.on");
      } else {
         var2 = bnq.a("options.off");
      }

      return var1.d().d() + ": " + var2;
   }

   static String a(axx var0, wo var1) {
      return var0.a(var1);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.f, this.l / 2, 20, 16777215);
      super.a(var1, var2, var3);
   }

   public void b() {
      int var1 = 0;
      this.f = bnq.a("options.skinCustomisation.title");
      wo[] var2 = wo.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         wo var5 = var2[var4];
         this.n.add(new axx.a(this, var5.b(), this.l / 2 - 155 + var1 % 2 * 160, this.m / 6 + 24 * (var1 >> 1), 150, 20, var5));
         ++var1;
      }

      if (var1 % 2 == 1) {
         ++var1;
      }

      this.n.add(new avs(200, this.l / 2 - 100, this.m / 6 + 24 * (var1 >> 1), bnq.a("gui.done")));
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 200) {
            this.j.t.b();
            this.j.a(this.a);
         } else if (var1 instanceof axx.a) {
            wo var2 = axx.a.a((axx.a)var1);
            this.j.t.a(var2);
            var1.j = this.a(var2);
         }

      }
   }

   class a extends avs {
      private final wo p;
      final axx o;

      a(axx var1, int var2, int var3, int var4, int var5, int var6, wo var7, Object var8) {
         this(var1, var2, var3, var4, var5, var6, var7);
      }

      static wo a(axx.a var0) {
         return var0.p;
      }

      private a(axx var1, int var2, int var3, int var4, int var5, int var6, wo var7) {
         super(var2, var3, var4, var5, var6, axx.a(var1, var7));
         this.o = var1;
         this.p = var7;
      }
   }
}
