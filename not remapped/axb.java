import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

public class axb extends axu {
   private boolean u;
   private axu f;
   private avs F;
   private boolean v;
   private String H;
   private avw g;
   private avs A;
   private String s;
   private String K;
   private boolean y;
   private boolean z;
   private avs C;
   public String a = "";
   private avw h;
   private String r = "survival";
   private boolean t = true;
   private String i;
   private avs B;
   private String J;
   private avs D;
   private boolean x;
   private avs G;
   private boolean w;
   private avs E;
   private static final String[] M = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
   private int L;
   private String I;

   public axb(axu var1) {
      this.f = var1;
      this.J = "";
      this.K = bnq.a("selectWorld.newWorld");
   }

   private void f() {
      this.A.j = bnq.a("selectWorld.gameMode") + ": " + bnq.a("selectWorld.gameMode." + this.r);
      this.H = bnq.a("selectWorld.gameMode." + this.r + ".line1");
      this.I = bnq.a("selectWorld.gameMode." + this.r + ".line2");
      this.C.j = bnq.a("selectWorld.mapFeatures") + " ";
      StringBuilder var10000;
      avs var10002;
      if (this.t) {
         var10000 = new StringBuilder();
         var10002 = this.C;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.on")).toString();
      } else {
         var10000 = new StringBuilder();
         var10002 = this.C;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.off")).toString();
      }

      this.D.j = bnq.a("selectWorld.bonusItems") + " ";
      if (this.w && !this.x) {
         var10000 = new StringBuilder();
         var10002 = this.D;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.on")).toString();
      } else {
         var10000 = new StringBuilder();
         var10002 = this.D;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.off")).toString();
      }

      this.E.j = bnq.a("selectWorld.mapType") + " " + bnq.a(adr.a[this.L].b());
      this.F.j = bnq.a("selectWorld.allowCommands") + " ";
      if (this.u && !this.x) {
         var10000 = new StringBuilder();
         var10002 = this.F;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.on")).toString();
      } else {
         var10000 = new StringBuilder();
         var10002 = this.F;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.off")).toString();
      }

   }

   protected void a(char var1, int var2) {
      if (this.g.m() && !this.z) {
         this.g.a(var1, var2);
         this.K = this.g.b();
      } else if (this.h.m() && this.z) {
         this.h.a(var1, var2);
         this.J = this.h.b();
      }

      if (var2 == 28 || var2 == 156) {
         this.a((avs)this.n.get(0));
      }

      ((avs)this.n.get(0)).l = this.g.b().length() > 0;
      this.a();
   }

   private boolean g() {
      adr var1 = adr.a[this.L];
      if (var1 != null && var1.e()) {
         return var1 == adr.g ? r() : true;
      } else {
         return false;
      }
   }

   public void a(ato var1) {
      this.K = bnq.a("selectWorld.newWorld.copyOf", var1.k());
      this.J = var1.b() + "";
      this.L = var1.u().g();
      this.a = var1.B();
      this.t = var1.s();
      this.u = var1.v();
      if (var1.t()) {
         this.r = "hardcore";
      } else if (var1.r().e()) {
         this.r = "survival";
      } else if (var1.r().d()) {
         this.r = "creative";
      }

   }

   private void h() {
      this.a(!this.z);
   }

   private void a(boolean var1) {
      this.z = var1;
      if (adr.a[this.L] == adr.g) {
         this.A.m = !this.z;
         this.A.l = false;
         if (this.s == null) {
            this.s = this.r;
         }

         this.r = "spectator";
         this.C.m = false;
         this.D.m = false;
         this.E.m = this.z;
         this.F.m = false;
         this.G.m = false;
      } else {
         this.A.m = !this.z;
         this.A.l = true;
         if (this.s != null) {
            this.r = this.s;
            this.s = null;
         }

         this.C.m = this.z && adr.a[this.L] != adr.f;
         this.D.m = this.z;
         this.E.m = this.z;
         this.F.m = this.z;
         this.G.m = this.z && (adr.a[this.L] == adr.c || adr.a[this.L] == adr.f);
      }

      this.f();
      if (this.z) {
         this.B.j = bnq.a("gui.done");
      } else {
         this.B.j = bnq.a("selectWorld.moreWorldOptions");
      }

   }

   public void e() {
      this.g.a();
      this.h.a();
   }

   private void a() {
      this.i = this.g.b().trim();
      char[] var1 = f.a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         this.i = this.i.replace(var4, '_');
      }

      if (StringUtils.isEmpty(this.i)) {
         this.i = "World";
      }

      this.i = a(this.j.f(), this.i);
   }

   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      this.n.add(new avs(0, this.l / 2 - 155, this.m - 28, 150, 20, bnq.a("selectWorld.create")));
      this.n.add(new avs(1, this.l / 2 + 5, this.m - 28, 150, 20, bnq.a("gui.cancel")));
      this.n.add(this.A = new avs(2, this.l / 2 - 75, 115, 150, 20, bnq.a("selectWorld.gameMode")));
      this.n.add(this.B = new avs(3, this.l / 2 - 75, 187, 150, 20, bnq.a("selectWorld.moreWorldOptions")));
      this.n.add(this.C = new avs(4, this.l / 2 - 155, 100, 150, 20, bnq.a("selectWorld.mapFeatures")));
      this.C.m = false;
      this.n.add(this.D = new avs(7, this.l / 2 + 5, 151, 150, 20, bnq.a("selectWorld.bonusItems")));
      this.D.m = false;
      this.n.add(this.E = new avs(5, this.l / 2 + 5, 100, 150, 20, bnq.a("selectWorld.mapType")));
      this.E.m = false;
      this.n.add(this.F = new avs(6, this.l / 2 - 155, 151, 150, 20, bnq.a("selectWorld.allowCommands")));
      this.F.m = false;
      this.n.add(this.G = new avs(8, this.l / 2 + 5, 120, 150, 20, bnq.a("selectWorld.customizeType")));
      this.G.m = false;
      this.g = new avw(9, this.q, this.l / 2 - 100, 60, 200, 20);
      this.g.b(true);
      this.g.a(this.K);
      this.h = new avw(10, this.q, this.l / 2 - 100, 60, 200, 20);
      this.h.a(this.J);
      this.a(this.z);
      this.a();
      this.f();
   }

   public static String a(atr var0, String var1) {
      var1 = var1.replaceAll("[\\./\"]", "_");
      String[] var2 = M;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if (var1.equalsIgnoreCase(var5)) {
            var1 = "_" + var1 + "_";
         }
      }

      while(var0.c(var1) != null) {
         var1 = var1 + "-";
      }

      return var1;
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("selectWorld.create"), this.l / 2, 20, -1);
      if (this.z) {
         this.c(this.q, bnq.a("selectWorld.enterSeed"), this.l / 2 - 100, 47, -6250336);
         this.c(this.q, bnq.a("selectWorld.seedInfo"), this.l / 2 - 100, 85, -6250336);
         if (this.C.m) {
            this.c(this.q, bnq.a("selectWorld.mapFeatures.info"), this.l / 2 - 150, 122, -6250336);
         }

         if (this.F.m) {
            this.c(this.q, bnq.a("selectWorld.allowCommands.info"), this.l / 2 - 150, 172, -6250336);
         }

         this.h.g();
         if (adr.a[this.L].h()) {
            this.q.a(bnq.a(adr.a[this.L].c()), this.E.h + 2, this.E.i + 22, this.E.b(), 10526880);
         }
      } else {
         this.c(this.q, bnq.a("selectWorld.enterName"), this.l / 2 - 100, 47, -6250336);
         this.c(this.q, bnq.a("selectWorld.resultFolder") + " " + this.i, this.l / 2 - 100, 85, -6250336);
         this.g.g();
         this.c(this.q, this.H, this.l / 2 - 100, 137, -6250336);
         this.c(this.q, this.I, this.l / 2 - 100, 149, -6250336);
      }

      super.a(var1, var2, var3);
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.z) {
         this.h.a(var1, var2, var3);
      } else {
         this.g.a(var1, var2, var3);
      }

   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            this.j.a(this.f);
         } else if (var1.k == 0) {
            this.j.a((axu)null);
            if (this.y) {
               return;
            }

            this.y = true;
            long var2 = (new Random()).nextLong();
            String var4 = this.h.b();
            if (!StringUtils.isEmpty(var4)) {
               try {
                  long var5 = Long.parseLong(var4);
                  if (var5 != 0L) {
                     var2 = var5;
                  }
               } catch (NumberFormatException var7) {
                  var2 = (long)var4.hashCode();
               }
            }

            adp.a var8 = adp.a.a(this.r);
            adp var6 = new adp(var2, var8, this.t, this.x, adr.a[this.L]);
            var6.a(this.a);
            if (this.w && !this.x) {
               var6.a();
            }

            if (this.u && !this.x) {
               var6.b();
            }

            this.j.a(this.i, this.g.b().trim(), var6);
         } else if (var1.k == 3) {
            this.h();
         } else if (var1.k == 2) {
            if (this.r.equals("survival")) {
               if (!this.v) {
                  this.u = false;
               }

               this.x = false;
               this.r = "hardcore";
               this.x = true;
               this.F.l = false;
               this.D.l = false;
               this.f();
            } else if (this.r.equals("hardcore")) {
               if (!this.v) {
                  this.u = true;
               }

               this.x = false;
               this.r = "creative";
               this.f();
               this.x = false;
               this.F.l = true;
               this.D.l = true;
            } else {
               if (!this.v) {
                  this.u = false;
               }

               this.r = "survival";
               this.f();
               this.F.l = true;
               this.D.l = true;
               this.x = false;
            }

            this.f();
         } else if (var1.k == 4) {
            this.t = !this.t;
            this.f();
         } else if (var1.k == 7) {
            this.w = !this.w;
            this.f();
         } else if (var1.k == 5) {
            ++this.L;
            if (this.L >= adr.a.length) {
               this.L = 0;
            }

            while(!this.g()) {
               ++this.L;
               if (this.L >= adr.a.length) {
                  this.L = 0;
               }
            }

            this.a = "";
            this.f();
            this.a(this.z);
         } else if (var1.k == 6) {
            this.v = true;
            this.u = !this.u;
            this.f();
         } else if (var1.k == 8) {
            if (adr.a[this.L] == adr.c) {
               this.j.a((axu)(new axa(this, this.a)));
            } else {
               this.j.a((axu)(new axd(this, this.a)));
            }
         }

      }
   }
}
