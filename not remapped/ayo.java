import com.google.common.collect.Lists;
import com.google.gson.JsonParseException;
import io.netty.buffer.Unpooled;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class ayo extends axu {
   private avs F;
   private int x;
   private final wn g;
   private int u = 192;
   private du y;
   private boolean s;
   private int w = 1;
   private static final Logger a = LogManager.getLogger();
   private int t;
   private String z = "";
   private ayo.a C;
   private avs G;
   private avs E;
   private boolean r;
   private static final jy f = new jy("textures/gui/book.png");
   private final boolean i;
   private int B = -1;
   private List<eu> A;
   private ayo.a D;
   private final zx h;
   private avs H;
   private int v = 192;

   private void g() {
      if (this.y != null && this.y.c() < 50) {
         this.y.a((eb)(new ea("")));
         ++this.w;
         this.r = true;
      }
   }

   protected boolean a(eu var1) {
      et var2 = var1 == null ? null : var1.b().h();
      if (var2 == null) {
         return false;
      } else if (var2.a() == et.a.f) {
         String var6 = var2.b();

         try {
            int var4 = Integer.parseInt(var6) - 1;
            if (var4 >= 0 && var4 < this.w && var4 != this.x) {
               this.x = var4;
               this.f();
               return true;
            }
         } catch (Throwable var5) {
         }

         return false;
      } else {
         boolean var3 = super.a(var1);
         if (var3 && var2.a() == et.a.c) {
            this.j.a((axu)null);
         }

         return var3;
      }
   }

   private void f() {
      this.C.m = !this.s && (this.x < this.w - 1 || this.i);
      this.D.m = !this.s && this.x > 0;
      this.E.m = !this.i || !this.s;
      if (this.i) {
         this.F.m = !this.s;
         this.H.m = this.s;
         this.G.m = this.s;
         this.G.l = this.z.trim().length() > 0;
      }

   }

   public eu b(int var1, int var2) {
      if (this.A == null) {
         return null;
      } else {
         int var3 = var1 - (this.l - this.u) / 2 - 36;
         int var4 = var2 - 2 - 16 - 16;
         if (var3 >= 0 && var4 >= 0) {
            int var5 = Math.min(128 / this.q.a, this.A.size());
            if (var3 <= 116 && var4 < this.j.k.a * var5 + var5) {
               int var6 = var4 / this.j.k.a;
               if (var6 >= 0 && var6 < this.A.size()) {
                  eu var7 = (eu)this.A.get(var6);
                  int var8 = 0;
                  Iterator var9 = var7.iterator();

                  while(var9.hasNext()) {
                     eu var10 = (eu)var9.next();
                     if (var10 instanceof fa) {
                        var8 += this.j.k.a(((fa)var10).g());
                        if (var8 > var3) {
                           return var10;
                        }
                     }
                  }
               }

               return null;
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   private void c(char var1, int var2) {
      switch(var2) {
      case 14:
         if (!this.z.isEmpty()) {
            this.z = this.z.substring(0, this.z.length() - 1);
            this.f();
         }

         return;
      case 28:
      case 156:
         if (!this.z.isEmpty()) {
            this.a(true);
            this.j.a((axu)null);
         }

         return;
      default:
         if (this.z.length() < 16 && f.a(var1)) {
            this.z = this.z + Character.toString(var1);
            this.f();
            this.r = true;
         }

      }
   }

   protected void a(char var1, int var2) {
      super.a(var1, var2);
      if (this.i) {
         if (this.s) {
            this.c(var1, var2);
         } else {
            this.b(var1, var2);
         }

      }
   }

   private String h() {
      return this.y != null && this.x >= 0 && this.x < this.y.c() ? this.y.f(this.x) : "";
   }

   private void b(String var1) {
      String var2 = this.h();
      String var3 = var2 + var1;
      int var4 = this.q.b(var3 + "" + .a.a + "_", 118);
      if (var4 <= 128 && var3.length() < 256) {
         this.a(var3);
      }

   }

   private void a(String var1) {
      if (this.y != null && this.x >= 0 && this.x < this.y.c()) {
         this.y.a(this.x, new ea(var1));
         this.r = true;
      }

   }

   public void b() {
      this.n.clear();
      Keyboard.enableRepeatEvents(true);
      if (this.i) {
         this.n.add(this.F = new avs(3, this.l / 2 - 100, 4 + this.v, 98, 20, bnq.a("book.signButton")));
         this.n.add(this.E = new avs(0, this.l / 2 + 2, 4 + this.v, 98, 20, bnq.a("gui.done")));
         this.n.add(this.G = new avs(5, this.l / 2 - 100, 4 + this.v, 98, 20, bnq.a("book.finalizeButton")));
         this.n.add(this.H = new avs(4, this.l / 2 + 2, 4 + this.v, 98, 20, bnq.a("gui.cancel")));
      } else {
         this.n.add(this.E = new avs(0, this.l / 2 - 100, 4 + this.v, 200, 20, bnq.a("gui.done")));
      }

      int var1 = (this.l - this.u) / 2;
      byte var2 = 2;
      this.n.add(this.C = new ayo.a(1, var1 + 120, var2 + 154, true));
      this.n.add(this.D = new ayo.a(2, var1 + 38, var2 + 154, false));
      this.f();
   }

   protected void a(int var1, int var2, int var3) {
      if (var3 == 0) {
         eu var4 = this.b(var1, var2);
         if (this.a(var4)) {
            return;
         }
      }

      super.a(var1, var2, var3);
   }

   public ayo(wn var1, zx var2, boolean var3) {
      this.g = var1;
      this.h = var2;
      this.i = var3;
      if (var2.n()) {
         dn var4 = var2.o();
         this.y = var4.c("pages", 8);
         if (this.y != null) {
            this.y = (du)this.y.b();
            this.w = this.y.c();
            if (this.w < 1) {
               this.w = 1;
            }
         }
      }

      if (this.y == null && var3) {
         this.y = new du();
         this.y.a((eb)(new ea("")));
         this.w = 1;
      }

   }

   public void e() {
      super.e();
      ++this.t;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 0) {
            this.j.a((axu)null);
            this.a(false);
         } else if (var1.k == 3 && this.i) {
            this.s = true;
         } else if (var1.k == 1) {
            if (this.x < this.w - 1) {
               ++this.x;
            } else if (this.i) {
               this.g();
               if (this.x < this.w - 1) {
                  ++this.x;
               }
            }
         } else if (var1.k == 2) {
            if (this.x > 0) {
               --this.x;
            }
         } else if (var1.k == 5 && this.s) {
            this.a(true);
            this.j.a((axu)null);
         } else if (var1.k == 4 && this.s) {
            this.s = false;
         }

         this.f();
      }
   }

   static jy a() {
      return f;
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   private void a(boolean var1) {
      if (this.i && this.r) {
         if (this.y != null) {
            String var2;
            while(this.y.c() > 1) {
               var2 = this.y.f(this.y.c() - 1);
               if (var2.length() != 0) {
                  break;
               }

               this.y.a(this.y.c() - 1);
            }

            if (this.h.n()) {
               dn var6 = this.h.o();
               var6.a((String)"pages", (eb)this.y);
            } else {
               this.h.a((String)"pages", (eb)this.y);
            }

            var2 = "MC|BEdit";
            if (var1) {
               var2 = "MC|BSign";
               this.h.a((String)"author", (eb)(new ea(this.g.e_())));
               this.h.a((String)"title", (eb)(new ea(this.z.trim())));

               for(int var3 = 0; var3 < this.y.c(); ++var3) {
                  String var4 = this.y.f(var3);
                  fa var5 = new fa(var4);
                  var4 = eu.a.a((eu)var5);
                  this.y.a(var3, new ea(var4));
               }

               this.h.a(zy.bN);
            }

            em var7 = new em(Unpooled.buffer());
            var7.a(this.h);
            this.j.u().a((ff)(new im(var2, var7)));
         }

      }
   }

   public void a(int var1, int var2, float var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(f);
      int var4 = (this.l - this.u) / 2;
      byte var5 = 2;
      this.b(var4, var5, 0, 0, this.u, this.v);
      String var6;
      String var7;
      int var8;
      int var9;
      if (this.s) {
         var6 = this.z;
         if (this.i) {
            if (this.t / 6 % 2 == 0) {
               var6 = var6 + "" + .a.a + "_";
            } else {
               var6 = var6 + "" + .a.h + "_";
            }
         }

         var7 = bnq.a("book.editTitle");
         var8 = this.q.a(var7);
         this.q.a(var7, var4 + 36 + (116 - var8) / 2, var5 + 16 + 16, 0);
         var9 = this.q.a(var6);
         this.q.a(var6, var4 + 36 + (116 - var9) / 2, var5 + 48, 0);
         String var10 = bnq.a("book.byAuthor", this.g.e_());
         int var11 = this.q.a(var10);
         this.q.a(.a.i + var10, var4 + 36 + (116 - var11) / 2, var5 + 48 + 10, 0);
         String var12 = bnq.a("book.finalizeWarning");
         this.q.a(var12, var4 + 36, var5 + 80, 116, 0);
      } else {
         var6 = bnq.a("book.pageIndicator", this.x + 1, this.w);
         var7 = "";
         if (this.y != null && this.x >= 0 && this.x < this.y.c()) {
            var7 = this.y.f(this.x);
         }

         if (this.i) {
            if (this.q.b()) {
               var7 = var7 + "_";
            } else if (this.t / 6 % 2 == 0) {
               var7 = var7 + "" + .a.a + "_";
            } else {
               var7 = var7 + "" + .a.h + "_";
            }
         } else if (this.B != this.x) {
            if (abd.b(this.h.o())) {
               try {
                  eu var14 = eu.a.a(var7);
                  this.A = var14 != null ? avu.a(var14, 116, this.q, true, true) : null;
               } catch (JsonParseException var13) {
                  this.A = null;
               }
            } else {
               fa var15 = new fa(.a.e.toString() + "* Invalid book tag *");
               this.A = Lists.newArrayList(var15);
            }

            this.B = this.x;
         }

         var8 = this.q.a(var6);
         this.q.a(var6, var4 - var8 + this.u - 44, var5 + 16, 0);
         if (this.A == null) {
            this.q.a(var7, var4 + 36, var5 + 16 + 16, 116, 0);
         } else {
            var9 = Math.min(128 / this.q.a, this.A.size());

            for(int var16 = 0; var16 < var9; ++var16) {
               eu var18 = (eu)this.A.get(var16);
               this.q.a(var18.c(), var4 + 36, var5 + 16 + 16 + var16 * this.q.a, 0);
            }

            eu var17 = this.b(var1, var2);
            if (var17 != null) {
               this.a(var17, var1, var2);
            }
         }
      }

      super.a(var1, var2, var3);
   }

   private void b(char var1, int var2) {
      if (axu.e(var2)) {
         this.b(axu.o());
      } else {
         switch(var2) {
         case 14:
            String var3 = this.h();
            if (var3.length() > 0) {
               this.a(var3.substring(0, var3.length() - 1));
            }

            return;
         case 28:
         case 156:
            this.b("\n");
            return;
         default:
            if (f.a(var1)) {
               this.b(Character.toString(var1));
            }
         }
      }
   }

   static class a extends avs {
      private final boolean o;

      public void a(ave var1, int var2, int var3) {
         if (this.m) {
            boolean var4 = var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            var1.P().a(ayo.a());
            int var5 = 0;
            int var6 = 192;
            if (var4) {
               var5 += 23;
            }

            if (!this.o) {
               var6 += 13;
            }

            this.b(this.h, this.i, var5, var6, 23, 13);
         }
      }

      public a(int var1, int var2, int var3, boolean var4) {
         super(var1, var2, var3, 23, 13, "");
         this.o = var4;
      }
   }
}
