import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.util.concurrent.Futures;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lm implements km, ic {
   private boolean h;
   private int i;
   private int e;
   private int g;
   public final ek a;
   private double p;
   private int l;
   private static final Logger c = LogManager.getLogger();
   private nm<Short> n = new nm();
   public lf b;
   private long j;
   private double q;
   private double o;
   private boolean r = true;
   private int m;
   private int f;
   private long k;
   private final MinecraftServer d;

   public void a(ir var1) {
      fh.a(var1, this, this.b.u());
      le var2 = this.d.a(this.b.am);
      cj var3 = var1.a();
      this.b.z();
      switch(var1.c()) {
      case e:
         if (!this.b.v()) {
            this.b.a(false);
         }

         return;
      case d:
         if (!this.b.v()) {
            this.b.a(true);
         }

         return;
      case f:
         this.b.bU();
         return;
      case a:
      case b:
      case c:
         double var4 = this.b.s - ((double)var3.n() + 0.5D);
         double var6 = this.b.t - ((double)var3.o() + 0.5D) + 1.5D;
         double var8 = this.b.u - ((double)var3.p() + 0.5D);
         double var10 = var4 * var4 + var6 * var6 + var8 * var8;
         if (var10 > 36.0D) {
            return;
         } else if (var3.o() >= this.d.an()) {
            return;
         } else {
            if (var1.c() == ir.a.a) {
               if (!this.d.a(var2, var3, this.b) && var2.af().a(var3)) {
                  this.b.c.a(var3, var1.b());
               } else {
                  this.b.a.a((ff)(new fv(var2, var3)));
               }
            } else {
               if (var1.c() == ir.a.c) {
                  this.b.c.a(var3);
               } else if (var1.c() == ir.a.b) {
                  this.b.c.e();
               }

               if (var2.p(var3).c().t() != arm.a) {
                  this.b.a.a((ff)(new fv(var2, var3)));
               }
            }

            return;
         }
      default:
         throw new IllegalArgumentException("Invalid player action");
      }
   }

   public void a(ih var1) {
      fh.a(var1, this, this.b.u());
      this.b.a(var1);
   }

   public void a(ff var1) {
      if (var1 instanceof fy) {
         fy var2 = (fy)var1;
         wn.b var3 = this.b.y();
         if (var3 == wn.b.c) {
            return;
         }

         if (var3 == wn.b.b && !var2.b()) {
            return;
         }
      }

      try {
         this.a.a(var1);
      } catch (Throwable var5) {
         b var6 = b.a(var5, "Sending packet");
         c var4 = var6.a("Packet being sent");
         var4.a("Packet class", new Callable<String>(this, var1) {
            final ff a;
            final lm b;

            public Object call() throws Exception {
               return this.a();
            }

            public String a() throws Exception {
               return this.a.getClass().getCanonicalName();
            }

            {
               this.b = var1;
               this.a = var2;
            }
         });
         throw new e(var6);
      }
   }

   public void a(it var1) {
      fh.a(var1, this, this.b.u());
      this.b.a(var1.a(), var1.b(), var1.c(), var1.d());
   }

   public void a(im var1) {
      fh.a(var1, this, this.b.u());
      em var40;
      zx var45;
      zx var48;
      if ("MC|BEdit".equals(var1.a())) {
         var40 = new em(Unpooled.wrappedBuffer(var1.b()));

         try {
            var45 = var40.i();
            if (var45 == null) {
               return;
            }

            if (!abc.b(var45.o())) {
               throw new IOException("Invalid book tag!");
            }

            var48 = this.b.bi.h();
            if (var48 != null) {
               if (var45.b() == zy.bM && var45.b() == var48.b()) {
                  var48.a((String)"pages", (eb)var45.o().c("pages", 8));
               }

               return;
            }
         } catch (Exception var36) {
            c.error("Couldn't handle book info", var36);
            return;
         } finally {
            var40.release();
         }

         return;
      } else if ("MC|BSign".equals(var1.a())) {
         var40 = new em(Unpooled.wrappedBuffer(var1.b()));

         try {
            var45 = var40.i();
            if (var45 == null) {
               return;
            }

            if (!abd.b(var45.o())) {
               throw new IOException("Invalid book tag!");
            }

            var48 = this.b.bi.h();
            if (var48 != null) {
               if (var45.b() == zy.bN && var48.b() == zy.bM) {
                  var48.a((String)"author", (eb)(new ea(this.b.e_())));
                  var48.a((String)"title", (eb)(new ea(var45.o().j("title"))));
                  var48.a((String)"pages", (eb)var45.o().c("pages", 8));
                  var48.a(zy.bN);
               }

               return;
            }
         } catch (Exception var38) {
            c.error("Couldn't sign book", var38);
            return;
         } finally {
            var40.release();
         }

         return;
      } else if ("MC|TrSel".equals(var1.a())) {
         try {
            int var2 = var1.b().readInt();
            xi var3 = this.b.bk;
            if (var3 instanceof yb) {
               ((yb)var3).d(var2);
            }
         } catch (Exception var35) {
            c.error("Couldn't select trade", var35);
         }
      } else if ("MC|AdvCdm".equals(var1.a())) {
         if (!this.d.al()) {
            this.b.a((eu)(new fb("advMode.notEnabled", new Object[0])));
         } else if (this.b.a(2, "") && this.b.bA.d) {
            var40 = var1.b();

            try {
               byte var42 = var40.readByte();
               adc var4 = null;
               if (var42 == 0) {
                  akw var5 = this.b.o.s(new cj(var40.readInt(), var40.readInt(), var40.readInt()));
                  if (var5 instanceof akz) {
                     var4 = ((akz)var5).b();
                  }
               } else if (var42 == 1) {
                  pk var47 = this.b.o.a(var40.readInt());
                  if (var47 instanceof vc) {
                     var4 = ((vc)var47).j();
                  }
               }

               String var49 = var40.c(var40.readableBytes());
               boolean var6 = var40.readBoolean();
               if (var4 != null) {
                  var4.a(var49);
                  var4.a(var6);
                  if (!var6) {
                     var4.b((eu)null);
                  }

                  var4.h();
                  this.b.a((eu)(new fb("advMode.setCommand.success", new Object[]{var49})));
               }
            } catch (Exception var33) {
               c.error("Couldn't set command block", var33);
            } finally {
               var40.release();
            }
         } else {
            this.b.a((eu)(new fb("advMode.notAllowed", new Object[0])));
         }
      } else if ("MC|Beacon".equals(var1.a())) {
         if (this.b.bk instanceof xl) {
            try {
               var40 = var1.b();
               int var43 = var40.readInt();
               int var46 = var40.readInt();
               xl var50 = (xl)this.b.bk;
               yg var51 = var50.a(0);
               if (var51.e()) {
                  var51.a(1);
                  og var7 = var50.e();
                  var7.b(1, var43);
                  var7.b(2, var46);
                  var7.p_();
               }
            } catch (Exception var32) {
               c.error("Couldn't set beacon", var32);
            }
         }
      } else if ("MC|ItemName".equals(var1.a()) && this.b.bk instanceof xk) {
         xk var41 = (xk)this.b.bk;
         if (var1.b() != null && var1.b().readableBytes() >= 1) {
            String var44 = f.a(var1.b().c(32767));
            if (var44.length() <= 30) {
               var41.a(var44);
            }
         } else {
            var41.a("");
         }
      }

   }

   public void c(String var1) {
      fa var2 = new fa(var1);
      this.a.a(new gh(var2), new GenericFutureListener<Future<? super Void>>(this, var2) {
         final fa a;
         final lm b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void operationComplete(Future<? super Void> var1) throws Exception {
            this.b.a.a((eu)this.a);
         }
      });
      this.a.k();
      Futures.getUnchecked(this.d.a(new Runnable(this) {
         final lm a;

         {
            this.a = var1;
         }

         public void run() {
            this.a.a.l();
         }
      }));
   }

   public void a(iu var1) {
   }

   public void a(iv var1) {
      fh.a(var1, this, this.b.u());
      if (var1.a() >= 0 && var1.a() < wm.i()) {
         this.b.bi.c = var1.a();
         this.b.z();
      } else {
         c.warn(this.b.e_() + " tried to set an invalid carried item");
      }
   }

   public void a(ix var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      le var2 = this.d.a(this.b.am);
      cj var3 = var1.a();
      if (var2.e(var3)) {
         akw var4 = var2.s(var3);
         if (!(var4 instanceof aln)) {
            return;
         }

         aln var5 = (aln)var4;
         if (!var5.b() || var5.c() != this.b) {
            this.d.f("Player " + this.b.e_() + " just tried to change non-editable sign");
            return;
         }

         eu[] var6 = var1.b();

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var5.a[var7] = new fa(a.a(var6[var7].c()));
         }

         var5.p_();
         var2.h(var3);
      }

   }

   public void a(double var1, double var3, double var5, float var7, float var8, Set<fi.a> var9) {
      this.r = false;
      this.o = var1;
      this.p = var3;
      this.q = var5;
      if (var9.contains(fi.a.a)) {
         this.o += this.b.s;
      }

      if (var9.contains(fi.a.b)) {
         this.p += this.b.t;
      }

      if (var9.contains(fi.a.c)) {
         this.q += this.b.u;
      }

      float var10 = var7;
      float var11 = var8;
      if (var9.contains(fi.a.d)) {
         var10 = var7 + this.b.y;
      }

      if (var9.contains(fi.a.e)) {
         var11 = var8 + this.b.z;
      }

      this.b.a(this.o, this.p, this.q, var10, var11);
      this.b.a.a((ff)(new fi(var1, var3, var5, var7, var8, var9)));
   }

   public void a(il var1) {
      fh.a(var1, this, this.b.u());
      this.b.p();
   }

   public void a(ja var1) {
      fh.a(var1, this, this.b.u());
      le var2 = this.d.a(this.b.am);
      zx var3 = this.b.bi.h();
      boolean var4 = false;
      cj var5 = var1.a();
      cq var6 = cq.a(var1.b());
      this.b.z();
      if (var1.b() == 255) {
         if (var3 == null) {
            return;
         }

         this.b.c.a(this.b, var2, var3);
      } else if (var5.o() < this.d.an() - 1 || var6 != cq.b && var5.o() < this.d.an()) {
         if (this.r && this.b.e((double)var5.n() + 0.5D, (double)var5.o() + 0.5D, (double)var5.p() + 0.5D) < 64.0D && !this.d.a(var2, var5, this.b) && var2.af().a(var5)) {
            this.b.c.a(this.b, var2, var3, var5, var6, var1.d(), var1.e(), var1.f());
         }

         var4 = true;
      } else {
         fb var7 = new fb("build.tooHigh", new Object[]{this.d.an()});
         var7.b().a(a.m);
         this.b.a.a((ff)(new fy(var7)));
         var4 = true;
      }

      if (var4) {
         this.b.a.a((ff)(new fv(var2, var5)));
         this.b.a.a((ff)(new fv(var2, var5.a(var6))));
      }

      var3 = this.b.bi.h();
      if (var3 != null && var3.b == 0) {
         this.b.bi.a[this.b.bi.c] = null;
         var3 = null;
      }

      if (var3 == null || var3.l() == 0) {
         this.b.g = true;
         this.b.bi.a[this.b.bi.c] = zx.b(this.b.bi.a[this.b.bi.c]);
         yg var8 = this.b.bk.a((og)this.b.bi, this.b.bi.c);
         this.b.bk.b();
         this.b.g = false;
         if (!zx.b(this.b.bi.h(), var1.c())) {
            this.a((ff)(new gf(this.b.bk.d, var8.e, this.b.bi.h())));
         }
      }

   }

   public lm(MinecraftServer var1, ek var2, lf var3) {
      this.d = var1;
      this.a = var2;
      var2.a((ep)this);
      this.b = var3;
      var3.a = this;
   }

   private long d() {
      return System.nanoTime() / 1000000L;
   }

   public void a(ik var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      if (this.b.bk.d == var1.a() && this.b.bk.c(this.b)) {
         if (this.b.v()) {
            ArrayList var2 = Lists.newArrayList();

            for(int var3 = 0; var3 < this.b.bk.c.size(); ++var3) {
               var2.add(((yg)this.b.bk.c.get(var3)).d());
            }

            this.b.a((xi)this.b.bk, (List)var2);
         } else {
            zx var5 = this.b.bk.a(var1.b(), var1.c(), var1.f(), this.b);
            if (zx.b(var1.e(), var5)) {
               this.b.a.a((ff)(new ga(var1.a(), var1.d(), true)));
               this.b.g = true;
               this.b.bk.b();
               this.b.o();
               this.b.g = false;
            } else {
               this.n.a(this.b.bk.d, var1.d());
               this.b.a.a((ff)(new ga(var1.a(), var1.d(), false)));
               this.b.bk.a(this.b, false);
               ArrayList var6 = Lists.newArrayList();

               for(int var4 = 0; var4 < this.b.bk.c.size(); ++var4) {
                  var6.add(((yg)this.b.bk.c.get(var4)).d());
               }

               this.b.a((xi)this.b.bk, (List)var6);
            }
         }
      }

   }

   public void a(iz var1) {
      fh.a(var1, this, this.b.u());
      if (this.b.v()) {
         pk var2 = null;
         le[] var3 = this.d.d;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            le var6 = var3[var5];
            if (var6 != null) {
               var2 = var1.a(var6);
               if (var2 != null) {
                  break;
               }
            }
         }

         if (var2 != null) {
            this.b.e(this.b);
            this.b.a((pk)null);
            if (var2.o != this.b.o) {
               le var7 = this.b.u();
               le var8 = (le)var2.o;
               this.b.am = var2.am;
               this.a((ff)(new he(this.b.am, var7.aa(), var7.P().u(), this.b.c.b())));
               var7.f(this.b);
               this.b.I = false;
               this.b.b(var2.s, var2.t, var2.u, var2.y, var2.z);
               if (this.b.ai()) {
                  var7.a((pk)this.b, false);
                  var8.d(this.b);
                  var8.a((pk)this.b, false);
               }

               this.b.a((adm)var8);
               this.d.ap().a(this.b, var7);
               this.b.a(var2.s, var2.t, var2.u);
               this.b.c.a(var8);
               this.d.ap().b(this.b, var8);
               this.d.ap().f(this.b);
            } else {
               this.b.a(var2.s, var2.t, var2.u);
            }
         }
      }

   }

   public void a(in var1) {
      fh.a(var1, this, this.b.u());
      le var2 = this.d.a(this.b.am);
      pk var3 = var1.a((adm)var2);
      this.b.z();
      if (var3 != null) {
         boolean var4 = this.b.t(var3);
         double var5 = 36.0D;
         if (!var4) {
            var5 = 9.0D;
         }

         if (this.b.h(var3) < var5) {
            if (var1.a() == in.a.a) {
               this.b.u(var3);
            } else if (var1.a() == in.a.c) {
               var3.a((wn)this.b, (aui)var1.b());
            } else if (var1.a() == in.a.b) {
               if (var3 instanceof uz || var3 instanceof pp || var3 instanceof wq || var3 == this.b) {
                  this.c("Attempting to attack an invalid entity");
                  this.d.f("Player " + this.b.e_() + " tried to attack an invalid entity");
                  return;
               }

               this.b.f(var3);
            }
         }
      }

   }

   private boolean b(ip var1) {
      return !Doubles.isFinite(var1.a()) || !Doubles.isFinite(var1.b()) || !Doubles.isFinite(var1.c()) || !Floats.isFinite(var1.e()) || !Floats.isFinite(var1.d());
   }

   public void a(id var1) {
      fh.a(var1, this, this.b.u());
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.d.a(this.b, var1.a(), var1.b()).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      this.b.a.a((ff)(new fx((String[])var2.toArray(new String[var2.size()]))));
   }

   public void a(iq var1) {
      fh.a(var1, this, this.b.u());
      this.b.bA.b = var1.b() && this.b.bA.c;
   }

   public void a(ig var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      ig.a var2 = var1.a();
      switch(var2) {
      case a:
         if (this.b.i) {
            this.b = this.d.ap().a(this.b, 0, true);
         } else if (this.b.u().P().t()) {
            if (this.d.T() && this.b.e_().equals(this.d.S())) {
               this.b.a.c("You have died. Game over, man, it's game over!");
               this.d.aa();
            } else {
               md var3 = new md(this.b.cd(), (Date)null, "(You just lost the game)", (Date)null, "Death in Hardcore");
               this.d.ap().h().a((ma)var3);
               this.b.a.c("You have died. Game over, man, it's game over!");
            }
         } else {
            if (this.b.bn() > 0.0F) {
               return;
            }

            this.b = this.d.ap().a(this.b, 0, false);
         }
         break;
      case b:
         this.b.A().a(this.b);
         break;
      case c:
         this.b.b((mw)mr.f);
      }

   }

   public ek a() {
      return this.a;
   }

   public void a(ii var1) {
      fh.a(var1, this, this.b.u());
      Short var2 = (Short)this.n.a(this.b.bk.d);
      if (var2 != null && var1.b() == var2 && this.b.bk.d == var1.a() && !this.b.bk.c(this.b) && !this.b.v()) {
         this.b.bk.a(this.b, true);
      }

   }

   public void a(ij var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      if (this.b.bk.d == var1.a() && this.b.bk.c(this.b) && !this.b.v()) {
         this.b.bk.a((wn)this.b, var1.b());
         this.b.bk.b();
      }

   }

   public void a(eu var1) {
      c.info(this.b.e_() + " lost connection: " + var1);
      this.d.aH();
      fb var2 = new fb("multiplayer.player.left", new Object[]{this.b.f_()});
      var2.b().a(a.o);
      this.d.ap().a((eu)var2);
      this.b.q();
      this.d.ap().e(this.b);
      if (this.d.T() && this.b.e_().equals(this.d.S())) {
         c.info("Stopping singleplayer server as player logged out");
         this.d.w();
      }

   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.a(var1, var3, var5, var7, var8, Collections.emptySet());
   }

   public void a(iw var1) {
      fh.a(var1, this, this.b.u());
      if (this.b.c.d()) {
         boolean var2 = var1.a() < 0;
         zx var3 = var1.b();
         if (var3 != null && var3.n() && var3.o().b("BlockEntityTag", 10)) {
            dn var4 = var3.o().m("BlockEntityTag");
            if (var4.c("x") && var4.c("y") && var4.c("z")) {
               cj var5 = new cj(var4.f("x"), var4.f("y"), var4.f("z"));
               akw var6 = this.b.o.s(var5);
               if (var6 != null) {
                  dn var7 = new dn();
                  var6.b(var7);
                  var7.o("x");
                  var7.o("y");
                  var7.o("z");
                  var3.a((String)"BlockEntityTag", (eb)var7);
               }
            }
         }

         boolean var8 = var1.a() >= 1 && var1.a() < 36 + wm.i();
         boolean var9 = var3 == null || var3.b() != null;
         boolean var10 = var3 == null || var3.i() >= 0 && var3.b <= 64 && var3.b > 0;
         if (var8 && var9 && var10) {
            if (var3 == null) {
               this.b.bj.a(var1.a(), (zx)null);
            } else {
               this.b.bj.a(var1.a(), var3);
            }

            this.b.bj.a(this.b, true);
         } else if (var2 && var9 && var10 && this.m < 200) {
            this.m += 20;
            uz var11 = this.b.a((zx)var3, true);
            if (var11 != null) {
               var11.j();
            }
         }
      }

   }

   public void a(is var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      switch(var1.b()) {
      case a:
         this.b.c(true);
         break;
      case b:
         this.b.c(false);
         break;
      case d:
         this.b.d(true);
         break;
      case e:
         this.b.d(false);
         break;
      case c:
         this.b.a(false, true, true);
         this.r = false;
         break;
      case f:
         if (this.b.m instanceof tp) {
            ((tp)this.b.m).v(var1.c());
         }
         break;
      case g:
         if (this.b.m instanceof tp) {
            ((tp)this.b.m).g(this.b);
         }
         break;
      default:
         throw new IllegalArgumentException("Invalid client command!");
      }

   }

   public void c() {
      this.h = false;
      ++this.e;
      this.d.c.a("keepAlive");
      if ((long)this.e - this.k > 40L) {
         this.k = (long)this.e;
         this.j = this.d();
         this.i = (int)this.j;
         this.a((ff)(new gn(this.i)));
      }

      this.d.c.b();
      if (this.l > 0) {
         --this.l;
      }

      if (this.m > 0) {
         --this.m;
      }

      if (this.b.D() > 0L && this.d.aA() > 0 && MinecraftServer.az() - this.b.D() > (long)(this.d.aA() * 1000 * 60)) {
         this.c("You have been idle for too long!");
      }

   }

   private void d(String var1) {
      this.d.P().a(this.b, var1);
   }

   public void a(iy var1) {
      fh.a(var1, this, this.b.u());
      this.b.z();
      this.b.bw();
   }

   public void a(ip var1) {
      fh.a(var1, this, this.b.u());
      if (this.b(var1)) {
         this.c("Invalid move packet received");
      } else {
         le var2 = this.d.a(this.b.am);
         this.h = true;
         if (!this.b.i) {
            double var3 = this.b.s;
            double var5 = this.b.t;
            double var7 = this.b.u;
            double var9 = 0.0D;
            double var11 = var1.a() - this.o;
            double var13 = var1.b() - this.p;
            double var15 = var1.c() - this.q;
            if (var1.g()) {
               var9 = var11 * var11 + var13 * var13 + var15 * var15;
               if (!this.r && var9 < 0.25D) {
                  this.r = true;
               }
            }

            if (this.r) {
               this.f = this.e;
               double var19;
               double var21;
               double var23;
               if (this.b.m != null) {
                  float var44 = this.b.y;
                  float var18 = this.b.z;
                  this.b.m.al();
                  var19 = this.b.s;
                  var21 = this.b.t;
                  var23 = this.b.u;
                  if (var1.h()) {
                     var44 = var1.d();
                     var18 = var1.e();
                  }

                  this.b.C = var1.f();
                  this.b.l();
                  this.b.a(var19, var21, var23, var44, var18);
                  if (this.b.m != null) {
                     this.b.m.al();
                  }

                  this.d.ap().d(this.b);
                  if (this.b.m != null) {
                     if (var9 > 4.0D) {
                        pk var45 = this.b.m;
                        this.b.a.a((ff)(new hz(var45)));
                        this.a(this.b.s, this.b.t, this.b.u, this.b.y, this.b.z);
                     }

                     this.b.m.ai = true;
                  }

                  if (this.r) {
                     this.o = this.b.s;
                     this.p = this.b.t;
                     this.q = this.b.u;
                  }

                  var2.g(this.b);
                  return;
               }

               if (this.b.bJ()) {
                  this.b.l();
                  this.b.a(this.o, this.p, this.q, this.b.y, this.b.z);
                  var2.g(this.b);
                  return;
               }

               double var17 = this.b.t;
               this.o = this.b.s;
               this.p = this.b.t;
               this.q = this.b.u;
               var19 = this.b.s;
               var21 = this.b.t;
               var23 = this.b.u;
               float var25 = this.b.y;
               float var26 = this.b.z;
               if (var1.g() && var1.b() == -999.0D) {
                  var1.a(false);
               }

               if (var1.g()) {
                  var19 = var1.a();
                  var21 = var1.b();
                  var23 = var1.c();
                  if (Math.abs(var1.a()) > 3.0E7D || Math.abs(var1.c()) > 3.0E7D) {
                     this.c("Illegal position");
                     return;
                  }
               }

               if (var1.h()) {
                  var25 = var1.d();
                  var26 = var1.e();
               }

               this.b.l();
               this.b.a(this.o, this.p, this.q, var25, var26);
               if (!this.r) {
                  return;
               }

               double var27 = var19 - this.b.s;
               double var29 = var21 - this.b.t;
               double var31 = var23 - this.b.u;
               double var33 = this.b.v * this.b.v + this.b.w * this.b.w + this.b.x * this.b.x;
               double var35 = var27 * var27 + var29 * var29 + var31 * var31;
               if (var35 - var33 > 100.0D && (!this.d.T() || !this.d.S().equals(this.b.e_()))) {
                  c.warn(this.b.e_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var27 + ", " + var29 + ", " + var31 + ")");
                  this.a(this.o, this.p, this.q, this.b.y, this.b.z);
                  return;
               }

               float var37 = 0.0625F;
               boolean var38 = var2.a((pk)this.b, (aug)this.b.aR().d((double)var37, (double)var37, (double)var37)).isEmpty();
               if (this.b.C && !var1.f() && var29 > 0.0D) {
                  this.b.bF();
               }

               this.b.d(var27, var29, var31);
               this.b.C = var1.f();
               double var39 = var29;
               var27 = var19 - this.b.s;
               var29 = var21 - this.b.t;
               if (var29 > -0.5D || var29 < 0.5D) {
                  var29 = 0.0D;
               }

               var31 = var23 - this.b.u;
               var35 = var27 * var27 + var29 * var29 + var31 * var31;
               boolean var41 = false;
               if (var35 > 0.0625D && !this.b.bJ() && !this.b.c.d()) {
                  var41 = true;
                  c.warn(this.b.e_() + " moved wrongly!");
               }

               this.b.a(var19, var21, var23, var25, var26);
               this.b.k(this.b.s - var3, this.b.t - var5, this.b.u - var7);
               if (!this.b.T) {
                  boolean var42 = var2.a((pk)this.b, (aug)this.b.aR().d((double)var37, (double)var37, (double)var37)).isEmpty();
                  if (var38 && (var41 || !var42) && !this.b.bJ()) {
                     this.a(this.o, this.p, this.q, var25, var26);
                     return;
                  }
               }

               aug var43 = this.b.aR().b((double)var37, (double)var37, (double)var37).a(0.0D, -0.55D, 0.0D);
               if (!this.d.ak() && !this.b.bA.c && !var2.c(var43)) {
                  if (var39 >= -0.03125D) {
                     ++this.g;
                     if (this.g > 80) {
                        c.warn(this.b.e_() + " was kicked for floating too long!");
                        this.c("Flying is not enabled on this server");
                        return;
                     }
                  }
               } else {
                  this.g = 0;
               }

               this.b.C = var1.f();
               this.d.ap().d(this.b);
               this.b.a(this.b.t - var17, var1.f());
            } else if (this.e - this.f > 20) {
               this.a(this.o, this.p, this.q, this.b.y, this.b.z);
            }

         }
      }
   }

   public void a(io var1) {
      if (var1.a() == this.i) {
         int var2 = (int)(this.d() - this.j);
         this.b.h = (this.b.h * 3 + var2) / 4;
      }

   }

   public void a(ie var1) {
      fh.a(var1, this, this.b.u());
      if (this.b.y() == wn.b.c) {
         fb var4 = new fb("chat.cannotSend", new Object[0]);
         var4.b().a(a.m);
         this.a((ff)(new fy(var4)));
      } else {
         this.b.z();
         String var2 = var1.a();
         var2 = StringUtils.normalizeSpace(var2);

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            if (!f.a(var2.charAt(var3))) {
               this.c("Illegal characters in chat");
               return;
            }
         }

         if (var2.startsWith("/")) {
            this.d(var2);
         } else {
            fb var5 = new fb("chat.type.text", new Object[]{this.b.f_(), var2});
            this.d.ap().a(var5, false);
         }

         this.l += 20;
         if (this.l > 200 && !this.d.ap().h(this.b.cd())) {
            this.c("disconnect.spam");
         }

      }
   }
}
