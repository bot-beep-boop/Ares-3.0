import io.netty.buffer.Unpooled;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ayn extends ayl {
   private static final Logger u = LogManager.getLogger();
   private static final jy v = new jy("textures/gui/container/beacon.png");
   private ayn.b x;
   private boolean y;
   private og w;

   protected void b(int var1, int var2) {
      avc.a();
      this.a(this.q, bnq.a("tile.beacon.primary"), 62, 10, 14737632);
      this.a(this.q, bnq.a("tile.beacon.secondary"), 169, 10, 14737632);
      Iterator var3 = this.n.iterator();

      while(var3.hasNext()) {
         avs var4 = (avs)var3.next();
         if (var4.a()) {
            var4.b(var1 - this.i, var2 - this.r);
            break;
         }
      }

      avc.c();
   }

   public ayn(wm var1, og var2) {
      super(new xl(var1, var2));
      this.w = var2;
      this.f = 230;
      this.g = 219;
   }

   static void c(ayn var0, String var1, int var2, int var3) {
      var0.a(var1, var2, var3);
   }

   public void b() {
      super.b();
      this.n.add(this.x = new ayn.b(this, -1, this.i + 164, this.r + 107));
      this.n.add(new ayn.a(this, -2, this.i + 190, this.r + 107));
      this.y = true;
      this.x.l = false;
   }

   protected void a(avs var1) {
      if (var1.k == -2) {
         this.j.a((axu)null);
      } else if (var1.k == -1) {
         String var2 = "MC|Beacon";
         em var3 = new em(Unpooled.buffer());
         var3.writeInt(this.w.a_(1));
         var3.writeInt(this.w.a_(2));
         this.j.u().a((ff)(new im(var2, var3)));
         this.j.a((axu)null);
      } else if (var1 instanceof ayn.c) {
         if (((ayn.c)var1).c()) {
            return;
         }

         int var5 = var1.k;
         int var6 = var5 & 255;
         int var4 = var5 >> 8;
         if (var4 < 3) {
            this.w.b(1, var6);
         } else {
            this.w.b(2, var6);
         }

         this.n.clear();
         this.b();
         this.e();
      }

   }

   static jy a() {
      return v;
   }

   public void e() {
      super.e();
      int var1 = this.w.a_(0);
      int var2 = this.w.a_(1);
      int var3 = this.w.a_(2);
      if (this.y && var1 >= 0) {
         this.y = false;

         int var5;
         int var6;
         int var7;
         int var8;
         ayn.c var9;
         for(int var4 = 0; var4 <= 2; ++var4) {
            var5 = akv.a[var4].length;
            var6 = var5 * 22 + (var5 - 1) * 2;

            for(var7 = 0; var7 < var5; ++var7) {
               var8 = akv.a[var4][var7].H;
               var9 = new ayn.c(this, var4 << 8 | var8, this.i + 76 + var7 * 24 - var6 / 2, this.r + 22 + var4 * 25, var8, var4);
               this.n.add(var9);
               if (var4 >= var1) {
                  var9.l = false;
               } else if (var8 == var2) {
                  var9.b(true);
               }
            }
         }

         byte var10 = 3;
         var5 = akv.a[var10].length + 1;
         var6 = var5 * 22 + (var5 - 1) * 2;

         for(var7 = 0; var7 < var5 - 1; ++var7) {
            var8 = akv.a[var10][var7].H;
            var9 = new ayn.c(this, var10 << 8 | var8, this.i + 167 + var7 * 24 - var6 / 2, this.r + 47, var8, var10);
            this.n.add(var9);
            if (var10 >= var1) {
               var9.l = false;
            } else if (var8 == var3) {
               var9.b(true);
            }
         }

         if (var2 > 0) {
            ayn.c var11 = new ayn.c(this, var10 << 8 | var2, this.i + 167 + (var5 - 1) * 24 - var6 / 2, this.r + 47, var2, var10);
            this.n.add(var11);
            if (var10 >= var1) {
               var11.l = false;
            } else if (var2 == var3) {
               var11.b(true);
            }
         }
      }

      this.x.l = this.w.a(0) != null && var2 > 0;
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(v);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      this.k.a = 100.0F;
      this.k.b(new zx(zy.bO), var4 + 42, var5 + 109);
      this.k.b(new zx(zy.i), var4 + 42 + 22, var5 + 109);
      this.k.b(new zx(zy.k), var4 + 42 + 44, var5 + 109);
      this.k.b(new zx(zy.j), var4 + 42 + 66, var5 + 109);
      this.k.a = 0.0F;
   }

   static void b(ayn var0, String var1, int var2, int var3) {
      var0.a(var1, var2, var3);
   }

   static void a(ayn var0, String var1, int var2, int var3) {
      var0.a(var1, var2, var3);
   }

   class c extends ayn.d {
      private final int q;
      final ayn o;
      private final int p;

      public void b(int var1, int var2) {
         String var3 = bnq.a(pe.a[this.p].a());
         if (this.q >= 3 && this.p != pe.l.H) {
            var3 = var3 + " II";
         }

         ayn.a(this.o, var3, var1, var2);
      }

      public c(ayn var1, int var2, int var3, int var4, int var5, int var6) {
         super(var2, var3, var4, ayl.a, 0 + pe.a[var5].f() % 8 * 18, 198 + pe.a[var5].f() / 8 * 18);
         this.o = var1;
         this.p = var5;
         this.q = var6;
      }
   }

   static class d extends avs {
      private final jy o;
      private final int p;
      private final int q;
      private boolean r;

      public void a(ave var1, int var2, int var3) {
         if (this.m) {
            var1.P().a(ayn.a());
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            this.n = var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
            short var4 = 219;
            int var5 = 0;
            if (!this.l) {
               var5 += this.f * 2;
            } else if (this.r) {
               var5 += this.f * 1;
            } else if (this.n) {
               var5 += this.f * 3;
            }

            this.b(this.h, this.i, var5, var4, this.f, this.g);
            if (!ayn.a().equals(this.o)) {
               var1.P().a(this.o);
            }

            this.b(this.h + 2, this.i + 2, this.p, this.q, 18, 18);
         }
      }

      public boolean c() {
         return this.r;
      }

      protected d(int var1, int var2, int var3, jy var4, int var5, int var6) {
         super(var1, var2, var3, 22, 22, "");
         this.o = var4;
         this.p = var5;
         this.q = var6;
      }

      public void b(boolean var1) {
         this.r = var1;
      }
   }

   class a extends ayn.d {
      final ayn o;

      public void b(int var1, int var2) {
         ayn.c(this.o, bnq.a("gui.cancel"), var1, var2);
      }

      public a(ayn var1, int var2, int var3, int var4) {
         super(var2, var3, var4, ayn.a(), 112, 220);
         this.o = var1;
      }
   }

   class b extends ayn.d {
      final ayn o;

      public b(ayn var1, int var2, int var3, int var4) {
         super(var2, var3, var4, ayn.a(), 90, 220);
         this.o = var1;
      }

      public void b(int var1, int var2) {
         ayn.b(this.o, bnq.a("gui.done"), var1, var2);
      }
   }
}
