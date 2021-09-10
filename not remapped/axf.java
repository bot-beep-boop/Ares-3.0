import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class axf extends axu {
   private static final jy f = new jy("textures/gui/demo_background.png");
   private static final Logger a = LogManager.getLogger();

   public void e() {
      super.e();
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      int var4 = (this.l - 248) / 2 + 10;
      int var5 = (this.m - 166) / 2 + 8;
      this.q.a(bnq.a("demo.help.title"), var4, var5, 2039583);
      var5 += 12;
      avh var6 = this.j.t;
      this.q.a(bnq.a("demo.help.movementShort", avh.c(var6.Y.i()), avh.c(var6.Z.i()), avh.c(var6.aa.i()), avh.c(var6.ab.i())), var4, var5, 5197647);
      this.q.a(bnq.a("demo.help.movementMouse"), var4, var5 + 12, 5197647);
      this.q.a(bnq.a("demo.help.jump", avh.c(var6.ac.i())), var4, var5 + 24, 5197647);
      this.q.a(bnq.a("demo.help.inventory", avh.c(var6.af.i())), var4, var5 + 36, 5197647);
      this.q.a(bnq.a("demo.help.fullWrapped"), var4, var5 + 68, 218, 2039583);
      super.a(var1, var2, var3);
   }

   protected void a(avs var1) {
      switch(var1.k) {
      case 1:
         var1.l = false;

         try {
            Class var2 = Class.forName("java.awt.Desktop");
            Object var3 = var2.getMethod("getDesktop").invoke((Object)null);
            var2.getMethod("browse", URI.class).invoke(var3, new URI("http://www.minecraft.net/store?source=demo"));
         } catch (Throwable var4) {
            a.error("Couldn't open link", var4);
         }
         break;
      case 2:
         this.j.a((axu)null);
         this.j.n();
      }

   }

   public void b() {
      this.n.clear();
      byte var1 = -16;
      this.n.add(new avs(1, this.l / 2 - 116, this.m / 2 + 62 + var1, 114, 20, bnq.a("demo.help.buy")));
      this.n.add(new avs(2, this.l / 2 + 2, this.m / 2 + 62 + var1, 114, 20, bnq.a("demo.help.later")));
   }

   public void c() {
      super.c();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(f);
      int var1 = (this.l - 248) / 2;
      int var2 = (this.m - 166) / 2;
      this.b(var1, var2, 0, 0, 248, 166);
   }
}
