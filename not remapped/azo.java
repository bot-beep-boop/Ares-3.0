import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;

public class azo extends axu {
   private static final Logger a = LogManager.getLogger();
   private List<azp> h;
   private azv r;
   private final axu f;
   private List<azp> g;
   private boolean s = false;
   private azt i;

   public boolean a(azp var1) {
      return this.h.contains(var1);
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 2) {
            File var2 = this.j.R().d();
            String var3 = var2.getAbsolutePath();
            if (g.a() == g.a.d) {
               try {
                  a.info(var3);
                  Runtime.getRuntime().exec(new String[]{"/usr/bin/open", var3});
                  return;
               } catch (IOException var9) {
                  a.error("Couldn't open file", var9);
               }
            } else if (g.a() == g.a.c) {
               String var4 = String.format("cmd.exe /C start \"Open file\" \"%s\"", var3);

               try {
                  Runtime.getRuntime().exec(var4);
                  return;
               } catch (IOException var8) {
                  a.error("Couldn't open file", var8);
               }
            }

            boolean var12 = false;

            try {
               Class var5 = Class.forName("java.awt.Desktop");
               Object var6 = var5.getMethod("getDesktop").invoke((Object)null);
               var5.getMethod("browse", URI.class).invoke(var6, var2.toURI());
            } catch (Throwable var7) {
               a.error("Couldn't open link", var7);
               var12 = true;
            }

            if (var12) {
               a.info("Opening via system class!");
               Sys.openURL("file://" + var3);
            }
         } else if (var1.k == 1) {
            if (this.s) {
               ArrayList var10 = Lists.newArrayList();
               Iterator var11 = this.h.iterator();

               while(var11.hasNext()) {
                  azp var13 = (azp)var11.next();
                  if (var13 instanceof azr) {
                     var10.add(((azr)var13).j());
                  }
               }

               Collections.reverse(var10);
               this.j.R().a((List)var10);
               this.j.t.k.clear();
               this.j.t.l.clear();
               var11 = var10.iterator();

               while(var11.hasNext()) {
                  bnm.a var14 = (bnm.a)var11.next();
                  this.j.t.k.add(var14.d());
                  if (var14.f() != 1) {
                     this.j.t.l.add(var14.d());
                  }
               }

               this.j.t.b();
               this.j.e();
            }

            this.j.a(this.f);
         }

      }
   }

   public void k() {
      super.k();
      this.r.p();
      this.i.p();
   }

   public List<azp> f() {
      return this.h;
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.i.b(var1, var2, var3);
      this.r.b(var1, var2, var3);
   }

   public List<azp> a() {
      return this.g;
   }

   protected void b(int var1, int var2, int var3) {
      super.b(var1, var2, var3);
   }

   public void a(int var1, int var2, float var3) {
      this.c(0);
      this.i.a(var1, var2, var3);
      this.r.a(var1, var2, var3);
      this.a(this.q, bnq.a("resourcePack.title"), this.l / 2, 16, 16777215);
      this.a(this.q, bnq.a("resourcePack.folderInfo"), this.l / 2 - 77, this.m - 26, 8421504);
      super.a(var1, var2, var3);
   }

   public void b() {
      this.n.add(new awe(2, this.l / 2 - 154, this.m - 48, bnq.a("resourcePack.openFolder")));
      this.n.add(new awe(1, this.l / 2 + 4, this.m - 48, bnq.a("gui.done")));
      if (!this.s) {
         this.g = Lists.newArrayList();
         this.h = Lists.newArrayList();
         bnm var1 = this.j.R();
         var1.a();
         ArrayList var2 = Lists.newArrayList(var1.b());
         var2.removeAll(var1.c());
         Iterator var3 = var2.iterator();

         bnm.a var4;
         while(var3.hasNext()) {
            var4 = (bnm.a)var3.next();
            this.g.add(new azr(this, var4));
         }

         var3 = Lists.reverse(var1.c()).iterator();

         while(var3.hasNext()) {
            var4 = (bnm.a)var3.next();
            this.h.add(new azr(this, var4));
         }

         this.h.add(new azq(this));
      }

      this.i = new azt(this.j, 200, this.m, this.g);
      this.i.i(this.l / 2 - 4 - 200);
      this.i.d(7, 8);
      this.r = new azv(this.j, 200, this.m, this.h);
      this.r.i(this.l / 2 + 4);
      this.r.d(7, 8);
   }

   public void g() {
      this.s = true;
   }

   public azo(axu var1) {
      this.f = var1;
   }

   public List<azp> b(azp var1) {
      return this.a(var1) ? this.h : this.g;
   }
}
