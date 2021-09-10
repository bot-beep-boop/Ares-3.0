import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import tv.twitch.chat.ChatUserInfo;

public abstract class axu extends avp implements awx {
   private static final Logger a = LogManager.getLogger();
   private int i;
   private URI t;
   protected List<avy> o = Lists.newArrayList();
   public boolean p;
   protected List<avs> n = Lists.newArrayList();
   private int s;
   private avs h;
   public int l;
   private static final Splitter g = Splitter.on('\n');
   private long r;
   public int m;
   protected avn q;
   private static final Set<String> f = Sets.newHashSet(new String[]{"http", "https"});
   protected bjh k;
   protected ave j;

   protected void a(String var1, int var2, int var3) {
      this.a(Arrays.asList(var1), var2, var3);
   }

   public void a(ave var1, int var2, int var3) {
      this.j = var1;
      this.k = var1.ag();
      this.q = var1.k;
      this.l = var2;
      this.m = var3;
      this.n.clear();
      this.b();
   }

   public void a(int var1, int var2, float var3) {
      int var4;
      for(var4 = 0; var4 < this.n.size(); ++var4) {
         ((avs)this.n.get(var4)).a(this.j, var1, var2);
      }

      for(var4 = 0; var4 < this.o.size(); ++var4) {
         ((avy)this.o.get(var4)).a(this.j, var1, var2);
      }

   }

   public void k() {
      int var1 = Mouse.getEventX() * this.l / this.j.d;
      int var2 = this.m - Mouse.getEventY() * this.m / this.j.e - 1;
      int var3 = Mouse.getEventButton();
      if (Mouse.getEventButtonState()) {
         if (this.j.t.A && this.s++ > 0) {
            return;
         }

         this.i = var3;
         this.r = ave.J();
         this.a(var1, var2, this.i);
      } else if (var3 != -1) {
         if (this.j.t.A && --this.s > 0) {
            return;
         }

         this.i = -1;
         this.b(var1, var2, var3);
      } else if (this.i != -1 && this.r > 0L) {
         long var4 = ave.J() - this.r;
         this.a(var1, var2, this.i, var4);
      }

   }

   protected void a(int var1, int var2, int var3) {
      if (var3 == 0) {
         for(int var4 = 0; var4 < this.n.size(); ++var4) {
            avs var5 = (avs)this.n.get(var4);
            if (var5.c(this.j, var1, var2)) {
               this.h = var5;
               var5.a(this.j.W());
               this.a(var5);
            }
         }
      }

   }

   public void p() {
      if (Mouse.isCreated()) {
         while(Mouse.next()) {
            this.k();
         }
      }

      if (Keyboard.isCreated()) {
         while(Keyboard.next()) {
            this.l();
         }
      }

   }

   protected void a(char var1, int var2) {
      if (var2 == 1) {
         this.j.a((axu)null);
         if (this.j.m == null) {
            this.j.n();
         }
      }

   }

   public static boolean f(int var0) {
      return var0 == 46 && q() && !r() && !s();
   }

   public static boolean e(int var0) {
      return var0 == 47 && q() && !r() && !s();
   }

   public void c(int var1) {
      bfl.f();
      bfl.n();
      bfx var2 = bfx.a();
      bfd var3 = var2.c();
      this.j.P().a(b);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      float var4 = 32.0F;
      var3.a(7, bms.i);
      var3.b(0.0D, (double)this.m, 0.0D).a(0.0D, (double)((float)this.m / 32.0F + (float)var1)).b(64, 64, 64, 255).d();
      var3.b((double)this.l, (double)this.m, 0.0D).a((double)((float)this.l / 32.0F), (double)((float)this.m / 32.0F + (float)var1)).b(64, 64, 64, 255).d();
      var3.b((double)this.l, 0.0D, 0.0D).a((double)((float)this.l / 32.0F), (double)var1).b(64, 64, 64, 255).d();
      var3.b(0.0D, 0.0D, 0.0D).a(0.0D, (double)var1).b(64, 64, 64, 255).d();
      var2.b();
   }

   protected void b(int var1, int var2, int var3) {
      if (this.h != null && var3 == 0) {
         this.h.a(var1, var2);
         this.h = null;
      }

   }

   public static boolean g(int var0) {
      return var0 == 30 && q() && !r() && !s();
   }

   public static boolean s() {
      return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
   }

   public void b_(int var1) {
      if (this.j.f != null) {
         this.a(0, 0, this.l, this.m, -1072689136, -804253680);
      } else {
         this.c(var1);
      }

   }

   protected void a(String var1, boolean var2) {
   }

   public void l() {
      if (Keyboard.getEventKeyState()) {
         this.a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
      }

      this.j.Z();
   }

   public void b(ave var1, int var2, int var3) {
      this.a(var1, var2, var3);
   }

   protected void a(avs var1) {
   }

   protected void a(eu var1, int var2, int var3) {
      if (var1 != null && var1.b().i() != null) {
         ew var4 = var1.b().i();
         if (var4.a() == ew.a.c) {
            zx var5 = null;

            try {
               dn var6 = ed.a(var4.b().c());
               if (var6 instanceof dn) {
                  var5 = zx.a((dn)var6);
               }
            } catch (ec var11) {
            }

            if (var5 != null) {
               this.a(var5, var2, var3);
            } else {
               this.a(a.m + "Invalid Item!", var2, var3);
            }
         } else {
            String var8;
            if (var4.a() == ew.a.d) {
               if (this.j.t.y) {
                  try {
                     dn var12 = ed.a(var4.b().c());
                     if (var12 instanceof dn) {
                        ArrayList var14 = Lists.newArrayList();
                        dn var7 = (dn)var12;
                        var14.add(var7.j("name"));
                        if (var7.b("type", 8)) {
                           var8 = var7.j("type");
                           var14.add("Type: " + var8 + " (" + pm.a(var8) + ")");
                        }

                        var14.add(var7.j("id"));
                        this.a((List)var14, var2, var3);
                     } else {
                        this.a(a.m + "Invalid Entity!", var2, var3);
                     }
                  } catch (ec var10) {
                     this.a(a.m + "Invalid Entity!", var2, var3);
                  }
               }
            } else if (var4.a() == ew.a.a) {
               this.a(g.splitToList(var4.b().d()), var2, var3);
            } else if (var4.a() == ew.a.b) {
               mw var13 = na.a(var4.b().c());
               if (var13 != null) {
                  eu var15 = var13.e();
                  fb var16 = new fb("stats.tooltip.type." + (var13.d() ? "achievement" : "statistic"), new Object[0]);
                  var16.b().b(true);
                  var8 = var13 instanceof mq ? ((mq)var13).f() : null;
                  ArrayList var9 = Lists.newArrayList(new String[]{var15.d(), var16.d()});
                  if (var8 != null) {
                     var9.addAll(this.q.c(var8, 150));
                  }

                  this.a((List)var9, var2, var3);
               } else {
                  this.a(a.m + "Invalid statistic/achievement!", var2, var3);
               }
            }
         }

         bfl.f();
      }
   }

   public void m() {
   }

   public static String o() {
      try {
         Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
         if (var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String)var0.getTransferData(DataFlavor.stringFlavor);
         }
      } catch (Exception var1) {
      }

      return "";
   }

   public static boolean d(int var0) {
      return var0 == 45 && q() && !r() && !s();
   }

   protected boolean a(eu var1) {
      if (var1 == null) {
         return false;
      } else {
         et var2 = var1.b().h();
         if (r()) {
            if (var1.b().j() != null) {
               this.a(var1.b().j(), false);
            }
         } else if (var2 != null) {
            URI var3;
            if (var2.a() == et.a.a) {
               if (!this.j.t.o) {
                  return false;
               }

               try {
                  var3 = new URI(var2.b());
                  String var4 = var3.getScheme();
                  if (var4 == null) {
                     throw new URISyntaxException(var2.b(), "Missing protocol");
                  }

                  if (!f.contains(var4.toLowerCase())) {
                     throw new URISyntaxException(var2.b(), "Unsupported protocol: " + var4.toLowerCase());
                  }

                  if (this.j.t.p) {
                     this.t = var3;
                     this.j.a((axu)(new aww(this, var2.b(), 31102009, false)));
                  } else {
                     this.a(var3);
                  }
               } catch (URISyntaxException var5) {
                  a.error("Can't open url for " + var2, var5);
               }
            } else if (var2.a() == et.a.b) {
               var3 = (new File(var2.b())).toURI();
               this.a(var3);
            } else if (var2.a() == et.a.e) {
               this.a(var2.b(), true);
            } else if (var2.a() == et.a.c) {
               this.b(var2.b(), false);
            } else if (var2.a() == et.a.d) {
               ChatUserInfo var6 = this.j.Y().e(var2.b());
               if (var6 != null) {
                  this.j.a((axu)(new bab(this.j.Y(), var6)));
               } else {
                  a.error("Tried to handle twitch user but couldn't find them!");
               }
            } else {
               a.error("Don't know how to handle " + var2);
            }

            return true;
         }

         return false;
      }
   }

   protected void a(List<String> var1, int var2, int var3) {
      if (!var1.isEmpty()) {
         bfl.C();
         avc.a();
         bfl.f();
         bfl.i();
         int var4 = 0;
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            int var7 = this.q.a(var6);
            if (var7 > var4) {
               var4 = var7;
            }
         }

         int var14 = var2 + 12;
         int var15 = var3 - 12;
         int var8 = 8;
         if (var1.size() > 1) {
            var8 += 2 + (var1.size() - 1) * 10;
         }

         if (var14 + var4 > this.l) {
            var14 -= 28 + var4;
         }

         if (var15 + var8 + 6 > this.m) {
            var15 = this.m - var8 - 6;
         }

         this.e = 300.0F;
         this.k.a = 300.0F;
         int var9 = -267386864;
         this.a(var14 - 3, var15 - 4, var14 + var4 + 3, var15 - 3, var9, var9);
         this.a(var14 - 3, var15 + var8 + 3, var14 + var4 + 3, var15 + var8 + 4, var9, var9);
         this.a(var14 - 3, var15 - 3, var14 + var4 + 3, var15 + var8 + 3, var9, var9);
         this.a(var14 - 4, var15 - 3, var14 - 3, var15 + var8 + 3, var9, var9);
         this.a(var14 + var4 + 3, var15 - 3, var14 + var4 + 4, var15 + var8 + 3, var9, var9);
         int var10 = 1347420415;
         int var11 = (var10 & 16711422) >> 1 | var10 & -16777216;
         this.a(var14 - 3, var15 - 3 + 1, var14 - 3 + 1, var15 + var8 + 3 - 1, var10, var11);
         this.a(var14 + var4 + 2, var15 - 3 + 1, var14 + var4 + 3, var15 + var8 + 3 - 1, var10, var11);
         this.a(var14 - 3, var15 - 3, var14 + var4 + 3, var15 - 3 + 1, var10, var10);
         this.a(var14 - 3, var15 + var8 + 2, var14 + var4 + 3, var15 + var8 + 3, var11, var11);

         for(int var12 = 0; var12 < var1.size(); ++var12) {
            String var13 = (String)var1.get(var12);
            this.q.a(var13, (float)var14, (float)var15, -1);
            if (var12 == 0) {
               var15 += 2;
            }

            var15 += 10;
         }

         this.e = 0.0F;
         this.k.a = 0.0F;
         bfl.e();
         bfl.j();
         avc.b();
         bfl.B();
      }
   }

   private void a(URI var1) {
      try {
         Class var2 = Class.forName("java.awt.Desktop");
         Object var3 = var2.getMethod("getDesktop").invoke((Object)null);
         var2.getMethod("browse", URI.class).invoke(var3, var1);
      } catch (Throwable var4) {
         a.error("Couldn't open link", var4);
      }

   }

   public void c() {
      this.b_(0);
   }

   public static void e(String var0) {
      if (!StringUtils.isEmpty(var0)) {
         try {
            StringSelection var1 = new StringSelection(var0);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var1, (ClipboardOwner)null);
         } catch (Exception var2) {
         }

      }
   }

   public void f(String var1) {
      this.b(var1, true);
   }

   public void a(int var1, int var2) {
      this.l = var1;
      this.m = var2;
   }

   public void b(String var1, boolean var2) {
      if (var2) {
         this.j.q.d().a(var1);
      }

      this.j.h.e(var1);
   }

   protected void a(int var1, int var2, int var3, long var4) {
   }

   public static boolean q() {
      if (ave.a) {
         return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
      } else {
         return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
      }
   }

   protected void a(zx var1, int var2, int var3) {
      List var4 = var1.a((wn)this.j.h, this.j.t.y);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         if (var5 == 0) {
            var4.set(var5, var1.u().e + (String)var4.get(var5));
         } else {
            var4.set(var5, a.h + (String)var4.get(var5));
         }
      }

      this.a(var4, var2, var3);
   }

   public void e() {
   }

   public boolean d() {
      return true;
   }

   public void b() {
   }

   public void a(boolean var1, int var2) {
      if (var2 == 31102009) {
         if (var1) {
            this.a(this.t);
         }

         this.t = null;
         this.j.a(this);
      }

   }

   public static boolean r() {
      return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
   }
}
