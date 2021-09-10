import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.realms.RealmsBridge;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class aya extends axu implements awx {
   private static final AtomicInteger f = new AtomicInteger(0);
   private static final Random h = new Random();
   private jy J;
   private int F;
   private axu M;
   private String y;
   private int H;
   private blz u;
   private boolean L;
   private avs K;
   private boolean v = true;
   private int t;
   private final Object w = new Object();
   public static final String a;
   private int E;
   private avs s;
   private static final jy A = new jy("texts/splashes.txt");
   private int D;
   private String x;
   private String r;
   private float i;
   private int G;
   private String z;
   private static final jy[] C = new jy[]{new jy("textures/gui/title/background/panorama_0.png"), new jy("textures/gui/title/background/panorama_1.png"), new jy("textures/gui/title/background/panorama_2.png"), new jy("textures/gui/title/background/panorama_3.png"), new jy("textures/gui/title/background/panorama_4.png"), new jy("textures/gui/title/background/panorama_5.png")};
   private int I;
   private static final Logger g = LogManager.getLogger();
   private static final jy B = new jy("textures/gui/title/minecraft.png");

   private void b(int var1, int var2) {
      this.n.add(new avs(1, this.l / 2 - 100, var1, bnq.a("menu.singleplayer")));
      this.n.add(new avs(2, this.l / 2 - 100, var1 + var2 * 1, bnq.a("menu.multiplayer")));
      this.n.add(this.K = new avs(14, this.l / 2 - 100, var1 + var2 * 2, bnq.a("menu.online")));
   }

   protected void a(char var1, int var2) {
   }

   private void a(float var1) {
      this.j.P().a(this.J);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.a(true, true, true, false);
      bfx var2 = bfx.a();
      bfd var3 = var2.c();
      var3.a(7, bms.i);
      bfl.c();
      byte var4 = 3;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = 1.0F / (float)(var5 + 1);
         int var7 = this.l;
         int var8 = this.m;
         float var9 = (float)(var5 - var4 / 2) / 256.0F;
         var3.b((double)var7, (double)var8, (double)this.e).a((double)(0.0F + var9), 1.0D).a(1.0F, 1.0F, 1.0F, var6).d();
         var3.b((double)var7, 0.0D, (double)this.e).a((double)(1.0F + var9), 1.0D).a(1.0F, 1.0F, 1.0F, var6).d();
         var3.b(0.0D, 0.0D, (double)this.e).a((double)(1.0F + var9), 0.0D).a(1.0F, 1.0F, 1.0F, var6).d();
         var3.b(0.0D, (double)var8, (double)this.e).a((double)(0.0F + var9), 0.0D).a(1.0F, 1.0F, 1.0F, var6).d();
      }

      var2.b();
      bfl.d();
      bfl.a(true, true, true, true);
   }

   private void f() {
      RealmsBridge var1 = new RealmsBridge();
      var1.switchToRealms(this);
   }

   public void e() {
      ++this.t;
      if (this.a()) {
         this.M.e();
      }

   }

   public void m() {
      if (this.M != null) {
         this.M.m();
      }

   }

   public boolean d() {
      return false;
   }

   private void c(int var1, int var2) {
      this.n.add(new avs(11, this.l / 2 - 100, var1, bnq.a("menu.playdemo")));
      this.n.add(this.s = new avs(12, this.l / 2 - 100, var1 + var2 * 1, bnq.a("menu.resetdemo")));
      atr var3 = this.j.f();
      ato var4 = var3.c("Demo_World");
      if (var4 == null) {
         this.s.l = false;
      }

   }

   private void c(int var1, int var2, float var3) {
      this.j.b().e();
      bfl.b(0, 0, 256, 256);
      this.b(var1, var2, var3);
      this.a(var3);
      this.a(var3);
      this.a(var3);
      this.a(var3);
      this.a(var3);
      this.a(var3);
      this.a(var3);
      this.j.b().a(true);
      bfl.b(0, 0, this.j.d, this.j.e);
      float var4 = this.l > this.m ? 120.0F / (float)this.l : 120.0F / (float)this.m;
      float var5 = (float)this.m * var4 / 256.0F;
      float var6 = (float)this.l * var4 / 256.0F;
      int var7 = this.l;
      int var8 = this.m;
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      var10.a(7, bms.i);
      var10.b(0.0D, (double)var8, (double)this.e).a((double)(0.5F - var5), (double)(0.5F + var6)).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var10.b((double)var7, (double)var8, (double)this.e).a((double)(0.5F - var5), (double)(0.5F - var6)).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var10.b((double)var7, 0.0D, (double)this.e).a((double)(0.5F + var5), (double)(0.5F - var6)).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var10.b(0.0D, 0.0D, (double)this.e).a((double)(0.5F + var5), (double)(0.5F + var6)).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var9.b();
   }

   public aya() {
      this.y = a;
      this.L = false;
      this.r = "missingno";
      BufferedReader var1 = null;

      try {
         ArrayList var2 = Lists.newArrayList();
         var1 = new BufferedReader(new InputStreamReader(ave.A().Q().a(A).b(), Charsets.UTF_8));

         String var3;
         while((var3 = var1.readLine()) != null) {
            var3 = var3.trim();
            if (!var3.isEmpty()) {
               var2.add(var3);
            }
         }

         if (!var2.isEmpty()) {
            do {
               this.r = (String)var2.get(h.nextInt(var2.size()));
            } while(this.r.hashCode() == 125780783);
         }
      } catch (IOException var12) {
      } finally {
         if (var1 != null) {
            try {
               var1.close();
            } catch (IOException var11) {
            }
         }

      }

      this.i = h.nextFloat();
      this.x = "";
      if (!GLContext.getCapabilities().OpenGL20 && !bqs.b()) {
         this.x = bnq.a("title.oldgl1");
         this.y = bnq.a("title.oldgl2");
         this.z = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
      }

   }

   public void b() {
      this.u = new blz(256, 256);
      this.J = this.j.P().a("background", this.u);
      Calendar var1 = Calendar.getInstance();
      var1.setTime(new Date());
      if (var1.get(2) + 1 == 12 && var1.get(5) == 24) {
         this.r = "Merry X-mas!";
      } else if (var1.get(2) + 1 == 1 && var1.get(5) == 1) {
         this.r = "Happy new year!";
      } else if (var1.get(2) + 1 == 10 && var1.get(5) == 31) {
         this.r = "OOoooOOOoooo! Spooky!";
      }

      boolean var2 = true;
      int var3 = this.m / 4 + 48;
      if (this.j.t()) {
         this.c(var3, 24);
      } else {
         this.b(var3, 24);
      }

      this.n.add(new avs(0, this.l / 2 - 100, var3 + 72 + 12, 98, 20, bnq.a("menu.options")));
      this.n.add(new avs(4, this.l / 2 + 2, var3 + 72 + 12, 98, 20, bnq.a("menu.quit")));
      this.n.add(new avz(5, this.l / 2 - 124, var3 + 72 + 12));
      synchronized(this.w) {
         this.E = this.q.a(this.x);
         this.D = this.q.a(this.y);
         int var5 = Math.max(this.E, this.D);
         this.F = (this.l - var5) / 2;
         this.G = ((avs)this.n.get(0)).i - 24;
         this.H = this.F + var5;
         this.I = this.G + 24;
      }

      this.j.a(false);
      if (ave.A().t.b(avh.a.S) && !this.L) {
         RealmsBridge var4 = new RealmsBridge();
         this.M = var4.getNotificationScreen(this);
         this.L = true;
      }

      if (this.a()) {
         this.M.a(this.l, this.m);
         this.M.b();
      }

   }

   public void a(int var1, int var2, float var3) {
      bfl.c();
      this.c(var1, var2, var3);
      bfl.d();
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      short var6 = 274;
      int var7 = this.l / 2 - var6 / 2;
      byte var8 = 30;
      this.a(0, 0, this.l, this.m, -2130706433, 16777215);
      this.a(0, 0, this.l, this.m, 0, Integer.MIN_VALUE);
      this.j.P().a(B);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      if ((double)this.i < 1.0E-4D) {
         this.b(var7, var8, 0, 0, 99, 44);
         this.b(var7 + 99, var8, 129, 0, 27, 44);
         this.b(var7 + 99 + 26, var8, 126, 0, 3, 44);
         this.b(var7 + 99 + 26 + 3, var8, 99, 0, 26, 44);
         this.b(var7 + 155, var8, 0, 45, 155, 44);
      } else {
         this.b(var7, var8, 0, 0, 155, 44);
         this.b(var7 + 155, var8, 0, 45, 155, 44);
      }

      bfl.E();
      bfl.b((float)(this.l / 2 + 90), 70.0F, 0.0F);
      bfl.b(-20.0F, 0.0F, 0.0F, 1.0F);
      float var9 = 1.8F - ns.e(ns.a((float)(ave.J() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
      var9 = var9 * 100.0F / (float)(this.q.a(this.r) + 32);
      bfl.a(var9, var9, var9);
      this.a(this.q, this.r, 0, -8, -256);
      bfl.F();
      String var10 = "Minecraft 1.8.9";
      if (this.j.t()) {
         var10 = var10 + " Demo";
      }

      this.c(this.q, var10, 2, this.m - 10, -1);
      String var11 = "Copyright Mojang AB. Do not distribute!";
      this.c(this.q, var11, this.l - this.q.a(var11) - 2, this.m - 10, -1);
      if (this.x != null && this.x.length() > 0) {
         a(this.F - 2, this.G - 2, this.H + 2, this.I - 1, 1428160512);
         this.c(this.q, this.x, this.F, this.G, -1);
         this.c(this.q, this.y, (this.l - this.D) / 2, ((avs)this.n.get(0)).i - 12, -1);
      }

      super.a(var1, var2, var3);
      if (this.a()) {
         this.M.a(var1, var2, var3);
      }

   }

   static {
      a = "Please click " + a.t + "here" + a.v + " for more information.";
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      synchronized(this.w) {
         if (this.x.length() > 0 && var1 >= this.F && var1 <= this.H && var2 >= this.G && var2 <= this.I) {
            aww var5 = new aww(this, this.z, 13, true);
            var5.f();
            this.j.a((axu)var5);
         }
      }

      if (this.a()) {
         this.M.a(var1, var2, var3);
      }

   }

   public void a(boolean var1, int var2) {
      if (var1 && var2 == 12) {
         atr var6 = this.j.f();
         var6.d();
         var6.e("Demo_World");
         this.j.a((axu)this);
      } else if (var2 == 13) {
         if (var1) {
            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop").invoke((Object)null);
               var3.getMethod("browse", URI.class).invoke(var4, new URI(this.z));
            } catch (Throwable var5) {
               g.error("Couldn't open link", var5);
            }
         }

         this.j.a((axu)this);
      }

   }

   protected void a(avs var1) {
      if (var1.k == 0) {
         this.j.a((axu)(new axn(this, this.j.t)));
      }

      if (var1.k == 5) {
         this.j.a((axu)(new axl(this, this.j.t, this.j.S())));
      }

      if (var1.k == 1) {
         this.j.a((axu)(new axv(this)));
      }

      if (var1.k == 2) {
         this.j.a((axu)(new azh(this)));
      }

      if (var1.k == 14 && this.K.m) {
         this.f();
      }

      if (var1.k == 4) {
         this.j.m();
      }

      if (var1.k == 11) {
         this.j.a("Demo_World", "Demo_World", kx.a);
      }

      if (var1.k == 12) {
         atr var2 = this.j.f();
         ato var3 = var2.c("Demo_World");
         if (var3 != null) {
            awy var4 = axv.a(this, var3.k(), 12);
            this.j.a((axu)var4);
         }
      }

   }

   private void b(int var1, int var2, float var3) {
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      bfl.n(5889);
      bfl.E();
      bfl.D();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      bfl.n(5888);
      bfl.E();
      bfl.D();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.b(180.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(90.0F, 0.0F, 0.0F, 1.0F);
      bfl.l();
      bfl.c();
      bfl.p();
      bfl.a(false);
      bfl.a(770, 771, 1, 0);
      byte var6 = 8;

      for(int var7 = 0; var7 < var6 * var6; ++var7) {
         bfl.E();
         float var8 = ((float)(var7 % var6) / (float)var6 - 0.5F) / 64.0F;
         float var9 = ((float)(var7 / var6) / (float)var6 - 0.5F) / 64.0F;
         float var10 = 0.0F;
         bfl.b(var8, var9, var10);
         bfl.b(ns.a(((float)this.t + var3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         bfl.b(-((float)this.t + var3) * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int var11 = 0; var11 < 6; ++var11) {
            bfl.E();
            if (var11 == 1) {
               bfl.b(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11 == 2) {
               bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11 == 3) {
               bfl.b(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11 == 4) {
               bfl.b(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var11 == 5) {
               bfl.b(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            this.j.P().a(C[var11]);
            var5.a(7, bms.i);
            int var12 = 255 / (var7 + 1);
            float var13 = 0.0F;
            var5.b(-1.0D, -1.0D, 1.0D).a(0.0D, 0.0D).b(255, 255, 255, var12).d();
            var5.b(1.0D, -1.0D, 1.0D).a(1.0D, 0.0D).b(255, 255, 255, var12).d();
            var5.b(1.0D, 1.0D, 1.0D).a(1.0D, 1.0D).b(255, 255, 255, var12).d();
            var5.b(-1.0D, 1.0D, 1.0D).a(0.0D, 1.0D).b(255, 255, 255, var12).d();
            var4.b();
            bfl.F();
         }

         bfl.F();
         bfl.a(true, true, true, false);
      }

      var5.c(0.0D, 0.0D, 0.0D);
      bfl.a(true, true, true, true);
      bfl.n(5889);
      bfl.F();
      bfl.n(5888);
      bfl.F();
      bfl.a(true);
      bfl.o();
      bfl.j();
   }

   private boolean a() {
      return ave.A().t.b(avh.a.S) && this.M != null;
   }
}
