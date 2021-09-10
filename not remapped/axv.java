import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class axv extends axu implements awx {
   protected axu a;
   private String u;
   private final DateFormat h = new SimpleDateFormat();
   private String v;
   private axv.a t;
   private static final Logger g = LogManager.getLogger();
   private boolean x;
   private avs z;
   private avs A;
   private String[] w = new String[4];
   protected String f = "Select world";
   private avs y;
   private List<ats> s;
   private boolean i;
   private avs B;
   private int r;

   public void b() {
      this.f = bnq.a("selectWorld.title");

      try {
         this.f();
      } catch (atq var2) {
         g.error("Couldn't load level list", var2);
         this.j.a((axu)(new axj("Unable to load worlds", var2.getMessage())));
         return;
      }

      this.u = bnq.a("selectWorld.world");
      this.v = bnq.a("selectWorld.conversion");
      this.w[adp.a.b.a()] = bnq.a("gameMode.survival");
      this.w[adp.a.c.a()] = bnq.a("gameMode.creative");
      this.w[adp.a.d.a()] = bnq.a("gameMode.adventure");
      this.w[adp.a.e.a()] = bnq.a("gameMode.spectator");
      this.t = new axv.a(this, this.j);
      this.t.d(4, 5);
      this.a();
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 2) {
            String var2 = this.h(this.r);
            if (var2 != null) {
               this.x = true;
               awy var3 = a(this, var2, this.r);
               this.j.a((axu)var3);
            }
         } else if (var1.k == 1) {
            this.i(this.r);
         } else if (var1.k == 3) {
            this.j.a((axu)(new axb(this)));
         } else if (var1.k == 6) {
            this.j.a((axu)(new axt(this, this.b(this.r))));
         } else if (var1.k == 0) {
            this.j.a(this.a);
         } else if (var1.k == 7) {
            axb var5 = new axb(this);
            atp var6 = this.j.f().a(this.b(this.r), false);
            ato var4 = var6.d();
            var6.a();
            var5.a(var4);
            this.j.a((axu)var5);
         } else {
            this.t.a(var1);
         }

      }
   }

   private void f() throws atq {
      atr var1 = this.j.f();
      this.s = var1.b();
      Collections.sort(this.s);
      this.r = -1;
   }

   static avs f(axv var0) {
      return var0.B;
   }

   public void a(int var1, int var2, float var3) {
      this.t.a(var1, var2, var3);
      this.a(this.q, this.f, this.l / 2, 20, 16777215);
      super.a(var1, var2, var3);
   }

   static List a(axv var0) {
      return var0.s;
   }

   static avs d(axv var0) {
      return var0.y;
   }

   protected String h(int var1) {
      String var2 = ((ats)this.s.get(var1)).b();
      if (StringUtils.isEmpty(var2)) {
         var2 = bnq.a("selectWorld.world") + " " + (var1 + 1);
      }

      return var2;
   }

   static DateFormat h(axv var0) {
      return var0.h;
   }

   static String g(axv var0) {
      return var0.u;
   }

   public axv(axu var1) {
      this.a = var1;
   }

   public void a() {
      this.n.add(this.z = new avs(1, this.l / 2 - 154, this.m - 52, 150, 20, bnq.a("selectWorld.select")));
      this.n.add(new avs(3, this.l / 2 + 4, this.m - 52, 150, 20, bnq.a("selectWorld.create")));
      this.n.add(this.A = new avs(6, this.l / 2 - 154, this.m - 28, 72, 20, bnq.a("selectWorld.rename")));
      this.n.add(this.y = new avs(2, this.l / 2 - 76, this.m - 28, 72, 20, bnq.a("selectWorld.delete")));
      this.n.add(this.B = new avs(7, this.l / 2 + 4, this.m - 28, 72, 20, bnq.a("selectWorld.recreate")));
      this.n.add(new avs(0, this.l / 2 + 82, this.m - 28, 72, 20, bnq.a("gui.cancel")));
      this.z.l = false;
      this.y.l = false;
      this.A.l = false;
      this.B.l = false;
   }

   public static awy a(awx var0, String var1, int var2) {
      String var3 = bnq.a("selectWorld.deleteQuestion");
      String var4 = "'" + var1 + "' " + bnq.a("selectWorld.deleteWarning");
      String var5 = bnq.a("selectWorld.deleteButton");
      String var6 = bnq.a("gui.cancel");
      awy var7 = new awy(var0, var3, var4, var5, var6, var2);
      return var7;
   }

   static String[] j(axv var0) {
      return var0.w;
   }

   static avs c(axv var0) {
      return var0.z;
   }

   protected String b(int var1) {
      return ((ats)this.s.get(var1)).a();
   }

   public void k() {
      super.k();
      this.t.p();
   }

   static int b(axv var0) {
      return var0.r;
   }

   static int a(axv var0, int var1) {
      return var0.r = var1;
   }

   static avs e(axv var0) {
      return var0.A;
   }

   static String i(axv var0) {
      return var0.v;
   }

   public void a(boolean var1, int var2) {
      if (this.x) {
         this.x = false;
         if (var1) {
            atr var3 = this.j.f();
            var3.d();
            var3.e(this.b(var2));

            try {
               this.f();
            } catch (atq var5) {
               g.error("Couldn't load level list", var5);
            }
         }

         this.j.a((axu)this);
      }

   }

   public void i(int var1) {
      this.j.a((axu)null);
      if (!this.i) {
         this.i = true;
         String var2 = this.b(var1);
         if (var2 == null) {
            var2 = "World" + var1;
         }

         String var3 = this.h(var1);
         if (var3 == null) {
            var3 = "World" + var1;
         }

         if (this.j.f().f(var2)) {
            this.j.a(var2, var3, (adp)null);
         }

      }
   }

   class a extends awi {
      final axv u;

      protected int k() {
         return axv.a(this.u).size() * 36;
      }

      protected boolean a(int var1) {
         return var1 == axv.b(this.u);
      }

      public a(axv var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 64, 36);
         this.u = var1;
      }

      protected void a() {
         this.u.c();
      }

      protected int b() {
         return axv.a(this.u).size();
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         axv.a(this.u, var1);
         boolean var5 = axv.b(this.u) >= 0 && axv.b(this.u) < this.b();
         axv.c(this.u).l = var5;
         axv.d(this.u).l = var5;
         axv.e(this.u).l = var5;
         axv.f(this.u).l = var5;
         if (var2 && var5) {
            this.u.i(var1);
         }

      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         ats var7 = (ats)axv.a(this.u).get(var1);
         String var8 = var7.b();
         if (StringUtils.isEmpty(var8)) {
            var8 = axv.g(this.u) + " " + (var1 + 1);
         }

         String var9 = var7.a();
         var9 = var9 + " (" + axv.h(this.u).format(new Date(var7.e()));
         var9 = var9 + ")";
         String var10 = "";
         if (var7.d()) {
            var10 = axv.i(this.u) + " " + var10;
         } else {
            var10 = axv.j(this.u)[var7.f().a()];
            if (var7.g()) {
               var10 = .a.e + bnq.a("gameMode.hardcore") + .a.v;
            }

            if (var7.h()) {
               var10 = var10 + ", " + bnq.a("selectWorld.cheats");
            }
         }

         this.u.c(this.u.q, var8, var2 + 2, var3 + 1, 16777215);
         this.u.c(this.u.q, var9, var2 + 2, var3 + 12, 8421504);
         this.u.c(this.u.q, var10, var2 + 2, var3 + 12 + 10, 8421504);
      }
   }
}
