import com.google.common.collect.Lists;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import tv.twitch.ErrorCode;

public class baa extends axu {
   private final axu g;
   private final baa.a h;
   private final List<String> r;
   private static final Logger a = LogManager.getLogger();
   private final List<fb> i;
   private final eu f;

   public baa(axu var1, baa.a var2) {
      this(var1, var2, (List)null);
   }

   public void b() {
      if (this.r.isEmpty()) {
         this.r.addAll(this.q.c(this.h.a().d(), (int)((float)this.l * 0.75F)));
         if (this.i != null) {
            this.r.add("");
            Iterator var1 = this.i.iterator();

            while(var1.hasNext()) {
               fb var2 = (fb)var1.next();
               this.r.add(var2.e());
            }
         }
      }

      if (this.h.b() != null) {
         this.n.add(new avs(0, this.l / 2 - 155, this.m - 50, 150, 20, bnq.a("gui.cancel")));
         this.n.add(new avs(1, this.l / 2 - 155 + 160, this.m - 50, 150, 20, bnq.a(this.h.b().d())));
      } else {
         this.n.add(new avs(0, this.l / 2 - 75, this.m - 50, 150, 20, bnq.a("gui.cancel")));
      }

   }

   private void a(String var1) {
      try {
         Class var2 = Class.forName("java.awt.Desktop");
         Object var3 = var2.getMethod("getDesktop").invoke((Object)null);
         var2.getMethod("browse", URI.class).invoke(var3, new URI(var1));
      } catch (Throwable var4) {
         a.error("Couldn't open link", var4);
      }

   }

   public void a(int var1, int var2, float var3) {
      this.c();
      int var4 = Math.max((int)((double)this.m * 0.85D / 2.0D - (double)((float)(this.r.size() * this.q.a) / 2.0F)), 50);
      this.a(this.q, this.f.d(), this.l / 2, var4 - this.q.a * 2, 16777215);

      for(Iterator var5 = this.r.iterator(); var5.hasNext(); var4 += this.q.a) {
         String var6 = (String)var5.next();
         this.a(this.q, var6, this.l / 2, var4, 10526880);
      }

      super.a(var1, var2, var3);
   }

   public baa(axu var1, baa.a var2, List<fb> var3) {
      this.f = new fb("stream.unavailable.title", new Object[0]);
      this.r = Lists.newArrayList();
      this.g = var1;
      this.h = var2;
      this.i = var3;
   }

   public static void a(axu var0) {
      ave var1 = ave.A();
      bqm var2 = var1.Y();
      if (!bqs.l) {
         ArrayList var3 = Lists.newArrayList();
         var3.add(new fb("stream.unavailable.no_fbo.version", new Object[]{GL11.glGetString(7938)}));
         var3.add(new fb("stream.unavailable.no_fbo.blend", new Object[]{GLContext.getCapabilities().GL_EXT_blend_func_separate}));
         var3.add(new fb("stream.unavailable.no_fbo.arb", new Object[]{GLContext.getCapabilities().GL_ARB_framebuffer_object}));
         var3.add(new fb("stream.unavailable.no_fbo.ext", new Object[]{GLContext.getCapabilities().GL_EXT_framebuffer_object}));
         var1.a((axu)(new baa(var0, baa.a.a, var3)));
      } else if (var2 instanceof bqo) {
         if (((bqo)var2).a().getMessage().contains("Can't load AMD 64-bit .dll on a IA 32-bit platform")) {
            var1.a((axu)(new baa(var0, baa.a.b)));
         } else {
            var1.a((axu)(new baa(var0, baa.a.c)));
         }
      } else if (!var2.A() && var2.B() == ErrorCode.TTV_EC_OS_TOO_OLD) {
         switch(g.a()) {
         case c:
            var1.a((axu)(new baa(var0, baa.a.d)));
            break;
         case d:
            var1.a((axu)(new baa(var0, baa.a.e)));
            break;
         default:
            var1.a((axu)(new baa(var0, baa.a.f)));
         }
      } else if (!var1.M().containsKey("twitch_access_token")) {
         if (var1.L().f() == avm.a.a) {
            var1.a((axu)(new baa(var0, baa.a.g)));
         } else {
            var1.a((axu)(new baa(var0, baa.a.h)));
         }
      } else if (!var2.C()) {
         switch(var2.E()) {
         case b:
            var1.a((axu)(new baa(var0, baa.a.i)));
            break;
         case a:
         default:
            var1.a((axu)(new baa(var0, baa.a.j)));
         }
      } else if (var2.B() != null) {
         List var4 = Arrays.asList(new fb("stream.unavailable.initialization_failure.extra", new Object[]{ErrorCode.getString(var2.B())}));
         var1.a((axu)(new baa(var0, baa.a.k, var4)));
      } else {
         var1.a((axu)(new baa(var0, baa.a.l)));
      }

   }

   public void m() {
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            switch(this.h) {
            case h:
            case i:
               this.a("https://account.mojang.com/me/settings");
               break;
            case g:
               this.a("https://account.mojang.com/migrate");
               break;
            case e:
               this.a("http://www.apple.com/osx/");
               break;
            case l:
            case c:
            case k:
               this.a("http://bugs.mojang.com/browse/MC");
            }
         }

         this.j.a(this.g);
      }
   }

   public static enum a {
      e(new fb("stream.unavailable.not_supported.mac", new Object[0]), new fb("stream.unavailable.not_supported.mac.okay", new Object[0]));

      private final eu n;
      h(new fb("stream.unavailable.account_not_bound", new Object[0]), new fb("stream.unavailable.account_not_bound.okay", new Object[0])),
      a(new fb("stream.unavailable.no_fbo", new Object[0]));

      private static final baa.a[] o = new baa.a[]{a, b, c, d, e, f, g, h, i, j, k, l};
      private final eu m;
      k(new fb("stream.unavailable.initialization_failure", new Object[0]), new fb("stream.unavailable.report_to_mojang", new Object[0])),
      d(new fb("stream.unavailable.not_supported.windows", new Object[0])),
      f(new fb("stream.unavailable.not_supported.other", new Object[0])),
      g(new fb("stream.unavailable.account_not_migrated", new Object[0]), new fb("stream.unavailable.account_not_migrated.okay", new Object[0])),
      c(new fb("stream.unavailable.library_failure", new Object[0]), new fb("stream.unavailable.report_to_mojang", new Object[0])),
      b(new fb("stream.unavailable.library_arch_mismatch", new Object[0])),
      l(new fb("stream.unavailable.unknown", new Object[0]), new fb("stream.unavailable.report_to_mojang", new Object[0])),
      j(new fb("stream.unavailable.failed_auth_error", new Object[0])),
      i(new fb("stream.unavailable.failed_auth", new Object[0]), new fb("stream.unavailable.failed_auth.okay", new Object[0]));

      private a(eu var3) {
         this(var3, (eu)null);
      }

      public eu b() {
         return this.n;
      }

      public eu a() {
         return this.m;
      }

      private a(eu var3, eu var4) {
         this.m = var3;
         this.n = var4;
      }
   }
}
