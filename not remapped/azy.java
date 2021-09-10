import tv.twitch.broadcast.IngestServer;

public class azy extends axu {
   private String f;
   private azy.a g;
   private final axu a;

   static avn c(azy var0) {
      return var0.q;
   }

   public void b() {
      this.f = bnq.a("options.stream.ingest.title");
      this.g = new azy.a(this, this.j);
      if (!this.j.Y().w()) {
         this.j.Y().u();
      }

      this.n.add(new avs(1, this.l / 2 - 155, this.m - 24 - 6, 150, 20, bnq.a("gui.done")));
      this.n.add(new avs(2, this.l / 2 + 5, this.m - 24 - 6, 150, 20, bnq.a("options.stream.ingest.reset")));
   }

   static avn h(azy var0) {
      return var0.q;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.g.a(var1, var2, var3);
      this.a(this.q, this.f, this.l / 2, 20, 16777215);
      super.a(var1, var2, var3);
   }

   public azy(axu var1) {
      this.a = var1;
   }

   static avn d(azy var0) {
      return var0.q;
   }

   public void k() {
      super.k();
      this.g.p();
   }

   static avn a(azy var0) {
      return var0.q;
   }

   static avn f(azy var0) {
      return var0.q;
   }

   public void m() {
      if (this.j.Y().w()) {
         this.j.Y().v().m();
      }

   }

   static avn b(azy var0) {
      return var0.q;
   }

   static avn g(azy var0) {
      return var0.q;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            this.j.a(this.a);
         } else {
            this.j.t.R = "";
            this.j.t.b();
         }

      }
   }

   static avn e(azy var0) {
      return var0.q;
   }

   class a extends awi {
      final azy u;

      public a(azy var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 35, (int)((double)var2.k.a * 3.5D));
         this.u = var1;
         this.b(false);
      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         IngestServer var7 = this.a.Y().s()[var1];
         String var8 = var7.serverUrl.replaceAll("\\{stream_key\\}", "");
         String var9 = (int)var7.bitrateKbps + " kbps";
         String var10 = null;
         bql var11 = this.a.Y().v();
         if (var11 != null) {
            if (var7 == var11.c()) {
               var8 = .a.k + var8;
               var9 = (int)(var11.i() * 100.0F) + "%";
            } else if (var1 < var11.d()) {
               if (var7.bitrateKbps == 0.0F) {
                  var9 = .a.m + "Down!";
               }
            } else {
               var9 = .a.q + "1234" + .a.v + " kbps";
            }
         } else if (var7.bitrateKbps == 0.0F) {
            var9 = .a.m + "Down!";
         }

         var2 -= 15;
         if (this.a(var1)) {
            var10 = .a.j + "(Preferred)";
         } else if (var7.defaultServer) {
            var10 = .a.k + "(Default)";
         }

         this.u.c(azy.a(this.u), var7.serverName, var2 + 2, var3 + 5, 16777215);
         this.u.c(azy.b(this.u), var8, var2 + 2, var3 + azy.c(this.u).a + 5 + 3, 3158064);
         this.u.c(azy.d(this.u), var9, this.d() - 5 - azy.e(this.u).a(var9), var3 + 5, 8421504);
         if (var10 != null) {
            this.u.c(azy.f(this.u), var10, this.d() - 5 - azy.g(this.u).a(var10), var3 + 5 + 3 + azy.h(this.u).a, 8421504);
         }

      }

      protected int b() {
         return this.a.Y().s().length;
      }

      protected boolean a(int var1) {
         return this.a.Y().s()[var1].serverUrl.equals(this.a.t.R);
      }

      protected int d() {
         return super.d() + 15;
      }

      protected void a() {
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         this.a.t.R = this.a.Y().s()[var1].serverUrl;
         this.a.t.b();
      }
   }
}
