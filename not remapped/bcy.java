import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.realms.DisconnectedRealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bcy implements fj {
   private final axu e;
   private boolean j = false;
   private ave f;
   private boolean h;
   private final Random k = new Random();
   private static final Logger b = LogManager.getLogger();
   private final ek c;
   public int a = 20;
   private final GameProfile d;
   private bdb g;
   private final Map<UUID, bdc> i = Maps.newHashMap();

   public void a(gz var1) {
      fh.a(var1, this, this.f);
      Iterator var2 = var1.a().iterator();

      while(var2.hasNext()) {
         gz.b var3 = (gz.b)var2.next();
         if (var1.b() == gz.a.e) {
            this.i.remove(var3.a().getId());
         } else {
            bdc var4 = (bdc)this.i.get(var3.a().getId());
            if (var1.b() == gz.a.a) {
               var4 = new bdc(var3);
               this.i.put(var4.a().getId(), var4);
            }

            if (var4 != null) {
               switch(var1.b()) {
               case a:
                  var4.a(var3.c());
                  var4.a(var3.b());
                  break;
               case b:
                  var4.a(var3.c());
                  break;
               case c:
                  var4.a(var3.b());
                  break;
               case d:
                  var4.a(var3.d());
               }
            }
         }
      }

   }

   public void a(hw var1) {
      fh.a(var1, this, this.f);
      boolean var2 = false;
      if (this.f.f.e(var1.a())) {
         akw var3 = this.f.f.s(var1.a());
         if (var3 instanceof aln) {
            aln var4 = (aln)var3;
            if (var4.b()) {
               System.arraycopy(var1.b(), 0, var4.a, 0, 4);
               var4.p_();
            }

            var2 = true;
         }
      }

      if (!var2 && this.f.h != null) {
         this.f.h.a((eu)(new fa("Unable to locate sign at " + var1.a().n() + ", " + var1.a().o() + ", " + var1.a().p())));
      }

   }

   static ek a(bcy var0) {
      return var0.c;
   }

   public void a(hc var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      if (var2 instanceof pr) {
         ((pr)var2).l(var1.b());
      }

   }

   public void a(hd var1) {
      String var2 = var1.a();
      String var3 = var1.b();
      if (var2.startsWith("level://")) {
         String var4 = var2.substring("level://".length());
         File var5 = new File(this.f.v, "saves");
         File var6 = new File(var5, var4);
         if (var6.isFile()) {
            this.c.a((ff)(new iu(var3, iu.a.d)));
            Futures.addCallback(this.f.R().a(var6), new FutureCallback<Object>(this, var3) {
               final bcy b;
               final String a;

               public void onSuccess(Object var1) {
                  bcy.a(this.b).a((ff)(new iu(this.a, iu.a.a)));
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void onFailure(Throwable var1) {
                  bcy.a(this.b).a((ff)(new iu(this.a, iu.a.c)));
               }
            });
         } else {
            this.c.a((ff)(new iu(var3, iu.a.c)));
         }

      } else {
         if (this.f.D() != null && this.f.D().b() == bde.a.a) {
            this.c.a((ff)(new iu(var3, iu.a.d)));
            Futures.addCallback(this.f.R().a(var2, var3), new FutureCallback<Object>(this, var3) {
               final String a;
               final bcy b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void onFailure(Throwable var1) {
                  bcy.a(this.b).a((ff)(new iu(this.a, iu.a.c)));
               }

               public void onSuccess(Object var1) {
                  bcy.a(this.b).a((ff)(new iu(this.a, iu.a.a)));
               }
            });
         } else if (this.f.D() != null && this.f.D().b() != bde.a.c) {
            this.c.a((ff)(new iu(var3, iu.a.b)));
         } else {
            this.f.a(new Runnable(this, var3, var2) {
               final bcy c;
               final String a;
               final String b;

               {
                  this.c = var1;
                  this.a = var2;
                  this.b = var3;
               }

               public void run() {
                  bcy.b(this.c).a((axu)(new awy(new awx(this) {
                     final <undefinedtype> a;

                     public void a(boolean var1, int var2) {
                        bcy.a(this.a.c, ave.A());
                        if (var1) {
                           if (bcy.b(this.a.c).D() != null) {
                              bcy.b(this.a.c).D().a(bde.a.a);
                           }

                           bcy.a(this.a.c).a((ff)(new iu(this.a.a, iu.a.d)));
                           Futures.addCallback(bcy.b(this.a.c).R().a(this.a.b, this.a.a), new FutureCallback<Object>(this) {
                              final <undefinedtype> a;

                              public void onSuccess(Object var1) {
                                 bcy.a(this.a.a.c).a((ff)(new iu(this.a.a.a, iu.a.a)));
                              }

                              {
                                 this.a = var1;
                              }

                              public void onFailure(Throwable var1) {
                                 bcy.a(this.a.a.c).a((ff)(new iu(this.a.a.a, iu.a.c)));
                              }
                           });
                        } else {
                           if (bcy.b(this.a.c).D() != null) {
                              bcy.b(this.a.c).D().a(bde.a.b);
                           }

                           bcy.a(this.a.c).a((ff)(new iu(this.a.a, iu.a.b)));
                        }

                        bdf.b(bcy.b(this.a.c).D());
                        bcy.b(this.a.c).a((axu)null);
                     }

                     {
                        this.a = var1;
                     }
                  }, bnq.a("multiplayer.texturePrompt.line1"), bnq.a("multiplayer.texturePrompt.line2"), 0)));
               }
            });
         }

      }
   }

   public void a(gy var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.c);
      pr var3 = var2 instanceof pr ? (pr)var2 : null;
      if (var1.a == gy.a.b) {
         long var4 = (long)(1000 * var1.d / 20);
         bqf var6 = new bqf(this.f.h, var3);
         this.f.Y().a(var6, 0L - var4, 0L);
      } else if (var1.a == gy.a.c) {
         pk var7 = this.g.a(var1.b);
         if (var7 instanceof wn) {
            bqg var5 = new bqg((wn)var7, var3);
            var5.a(var1.e);
            this.f.Y().a(var5, 0L);
         }
      }

   }

   public void a(ff var1) {
      this.c.a(var1);
   }

   public void a(gl var1) {
      if (!this.c.c()) {
         this.c.a(var1.a());
      }

   }

   public void a(hq var1) {
      fh.a(var1, this, this.f);
      auo var2 = this.g.Z();
      auk var3;
      if (var1.c() == 0) {
         var3 = var2.a(var1.a(), auu.b);
         var3.a(var1.b());
         var3.a(var1.d());
      } else {
         var3 = var2.b(var1.a());
         if (var1.c() == 1) {
            var2.k(var3);
         } else if (var1.c() == 2) {
            var3.a(var1.b());
            var3.a(var1.d());
         }
      }

   }

   public void a(fr var1) {
      fh.a(var1, this, this.f);
      boolean var2 = false;

      mw var5;
      int var6;
      for(Iterator var3 = var1.a().entrySet().iterator(); var3.hasNext(); this.f.h.x().a(this.f.h, var5, var6)) {
         Entry var4 = (Entry)var3.next();
         var5 = (mw)var4.getKey();
         var6 = (Integer)var4.getValue();
         if (var5.d() && var6 > 0) {
            if (this.j && this.f.h.x().a(var5) == 0) {
               mq var7 = (mq)var5;
               this.f.p.a(var7);
               this.f.Y().a(new bqe(var7), 0L);
               if (var5 == mr.f) {
                  this.f.t.I = false;
                  this.f.t.b();
               }
            }

            var2 = true;
         }
      }

      if (!this.j && !var2 && this.f.t.I) {
         this.f.p.b(mr.f);
      }

      this.j = true;
      if (this.f.m instanceof ayg) {
         ((ayg)this.f.m).a();
      }

   }

   public void a(gd var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      if (var1.a() == 0) {
         var2.bj.a(var1.b());
      } else if (var1.a() == var2.bk.d) {
         var2.bk.a(var1.b());
      }

   }

   public void a(hk var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.b());
      if (var2 != null && var1.a() != null) {
         var2.H().a(var1.a());
      }

   }

   public void a(ga var1) {
      fh.a(var1, this, this.f);
      xi var2 = null;
      bew var3 = this.f.h;
      if (var1.a() == 0) {
         var2 = var3.bj;
      } else if (var1.a() == var3.bk.d) {
         var2 = var3.bk;
      }

      if (var2 != null && !var1.c()) {
         this.a((ff)(new ii(var1.a(), var1.b(), true)));
      }

   }

   public void a(gw var1) {
      fh.a(var1, this, this.f);
      Object var2 = this.g.s(var1.a());
      if (!(var2 instanceof aln)) {
         var2 = new aln();
         ((akw)var2).a((adm)this.g);
         ((akw)var2).a(var1.a());
      }

      this.f.h.a((aln)var2);
   }

   public void a(fv var1) {
      fh.a(var1, this, this.f);
      this.g.b(var1.b(), var1.a());
   }

   static ave a(bcy var0, ave var1) {
      return var0.f = var1;
   }

   public void a(fq var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      if (var2 != null) {
         if (var1.b() == 0) {
            pr var3 = (pr)var2;
            var3.bw();
         } else if (var1.b() == 1) {
            var2.ar();
         } else if (var1.b() == 2) {
            wn var4 = (wn)var2;
            var4.a(false, false, false);
         } else if (var1.b() == 4) {
            this.f.j.a(var2, cy.j);
         } else if (var1.b() == 5) {
            this.f.j.a(var2, cy.k);
         }

      }
   }

   public void a(ha var1) {
      fh.a(var1, this, this.f);
      var1.a((adm)this.g).a(var1.a());
   }

   public void a(gv var1) {
      fh.a(var1, this, this.f);
      pk var2 = var1.a((adm)this.g);
      if (var2 != null) {
         var2.bW += var1.a();
         var2.bX += var1.b();
         var2.bY += var1.c();
         double var3 = (double)var2.bW / 32.0D;
         double var5 = (double)var2.bX / 32.0D;
         double var7 = (double)var2.bY / 32.0D;
         float var9 = var1.f() ? (float)(var1.d() * 360) / 256.0F : var2.y;
         float var10 = var1.f() ? (float)(var1.e() * 360) / 256.0F : var2.z;
         var2.a(var3, var5, var7, var9, var10, 3, false);
         var2.C = var1.g();
      }
   }

   public void a(gt var1) {
      fh.a(var1, this, this.f);
      this.f.c = new bda(this.f, this);
      this.g = new bdb(this, new adp(0L, var1.c(), false, var1.b(), var1.g()), var1.d(), var1.e(), this.f.A);
      this.f.t.az = var1.e();
      this.f.a(this.g);
      this.f.h.am = var1.d();
      this.f.a((axu)(new axs(this)));
      this.f.h.d(var1.a());
      this.a = var1.f();
      this.f.h.k(var1.h());
      this.f.c.a(var1.c());
      this.f.t.c();
      this.c.a((ff)(new im("MC|Brand", (new em(Unpooled.buffer())).a(ClientBrandRetriever.getClientModName()))));
   }

   public void a(gp var1) {
      fh.a(var1, this, this.f);

      for(int var2 = 0; var2 < var1.a(); ++var2) {
         int var3 = var1.a(var2);
         int var4 = var1.b(var2);
         this.g.b(var3, var4, true);
         this.g.a(var3 << 4, 0, var4 << 4, (var3 << 4) + 15, 256, (var4 << 4) + 15);
         amy var5 = this.g.a(var3, var4);
         var5.a(var1.c(var2), var1.d(var2), true);
         this.g.b(var3 << 4, 0, var4 << 4, (var3 << 4) + 15, 256, (var4 << 4) + 15);
         if (!(this.g.t instanceof ano)) {
            var5.l();
         }
      }

   }

   public void a(gf var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      if (var1.a() == -1) {
         var2.bi.b(var1.c());
      } else {
         boolean var3 = false;
         if (this.f.m instanceof ayu) {
            ayu var4 = (ayu)this.f.m;
            var3 = var4.f() != yz.m.a();
         }

         if (var1.a() == 0 && var1.b() >= 36 && var1.b() < 45) {
            zx var5 = var2.bj.a(var1.b()).d();
            if (var1.c() != null && (var5 == null || var5.b < var1.c().b)) {
               var1.c().c = 5;
            }

            var2.bj.a(var1.b(), var1.c());
         } else if (var1.a() == var2.bk.d && (var1.a() != 0 || !var3)) {
            var2.bk.a(var1.b(), var1.c());
         }
      }

   }

   public void a(he var1) {
      fh.a(var1, this, this.f);
      if (var1.a() != this.f.h.am) {
         this.h = false;
         auo var2 = this.g.Z();
         this.g = new bdb(this, new adp(0L, var1.c(), false, this.f.f.P().t(), var1.d()), var1.a(), var1.b(), this.f.A);
         this.g.a(var2);
         this.f.a(this.g);
         this.f.h.am = var1.a();
         this.f.a((axu)(new axs(this)));
      }

      this.f.a(var1.a());
      this.f.c.a(var1.c());
   }

   public void a(gb var1) {
      fh.a(var1, this, this.f);
      this.f.h.q();
   }

   public void a(fn var1) {
      fh.a(var1, this, this.f);
      double var2 = (double)var1.d() / 32.0D;
      double var4 = (double)var1.e() / 32.0D;
      double var6 = (double)var1.f() / 32.0D;
      float var8 = (float)(var1.j() * 360) / 256.0F;
      float var9 = (float)(var1.k() * 360) / 256.0F;
      pr var10 = (pr)pm.a(var1.c(), this.f.f);
      var10.bW = var1.d();
      var10.bX = var1.e();
      var10.bY = var1.f();
      var10.aI = var10.aK = (float)(var1.l() * 360) / 256.0F;
      pk[] var11 = var10.aB();
      if (var11 != null) {
         int var12 = var1.b() - var10.F();

         for(int var13 = 0; var13 < var11.length; ++var13) {
            var11[var13].d(var11[var13].F() + var12);
         }
      }

      var10.d(var1.b());
      var10.a(var2, var4, var6, var8, var9);
      var10.v = (double)((float)var1.g() / 8000.0F);
      var10.w = (double)((float)var1.h() / 8000.0F);
      var10.x = (double)((float)var1.i() / 8000.0F);
      this.g.a(var1.b(), var10);
      List var14 = var1.a();
      if (var14 != null) {
         var10.H().a(var14);
      }

   }

   public void a(hx var1) {
      this.f.q.h().b(var1.a().d().length() == 0 ? null : var1.a());
      this.f.q.h().a(var1.b().d().length() == 0 ? null : var1.b());
   }

   static ave b(bcy var0) {
      return var0.f;
   }

   public void a(hj var1) {
      fh.a(var1, this, this.f);
      auo var2 = this.g.Z();
      if (var1.b().length() == 0) {
         var2.a(var1.a(), (auk)null);
      } else {
         auk var3 = var2.b(var1.b());
         var2.a(var1.a(), var3);
      }

   }

   public void a(hy var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      Object var3 = (pr)this.g.a(var1.b());
      if (var3 == null) {
         var3 = this.f.h;
      }

      if (var2 != null) {
         if (var2 instanceof pp) {
            this.g.a(var2, "random.orb", 0.2F, ((this.k.nextFloat() - this.k.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         } else {
            this.g.a(var2, "random.pop", 0.2F, ((this.k.nextFloat() - this.k.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         }

         this.f.j.a((beb)(new bdw(this.g, var2, (pk)var3, 0.5F)));
         this.g.e(var1.a());
      }

   }

   public void a(fl var1) {
      fh.a(var1, this, this.f);
      pp var2 = new pp(this.g, (double)var1.b() / 32.0D, (double)var1.c() / 32.0D, (double)var1.d() / 32.0D, var1.e());
      var2.bW = var1.b();
      var2.bX = var1.c();
      var2.bY = var1.d();
      var2.y = 0.0F;
      var2.z = 0.0F;
      var2.d(var1.a());
      this.g.a(var1.a(), var2);
   }

   public void a(hh var1) {
      fh.a(var1, this, this.f);
      pk var2 = var1.a((adm)this.g);
      if (var2 != null) {
         this.f.a(var2);
      }

   }

   public void a(hs var1) {
      fh.a(var1, this, this.f);
      auo var2 = this.g.Z();
      auk var3 = var2.b(var1.b());
      if (var1.d() == hs.a.a) {
         aum var4 = var2.c(var1.a(), var3);
         var4.c(var1.c());
      } else if (var1.d() == hs.a.b) {
         if (nx.b(var1.b())) {
            var2.d(var1.a(), (auk)null);
         } else if (var3 != null) {
            var2.d(var1.a(), var3);
         }
      }

   }

   public void a(ft var1) {
      fh.a(var1, this, this.f);
      if (this.f.f.e(var1.a())) {
         akw var2 = this.f.f.s(var1.a());
         int var3 = var1.b();
         if (var3 == 1 && var2 instanceof all || var3 == 2 && var2 instanceof akz || var3 == 3 && var2 instanceof akv || var3 == 4 && var2 instanceof alo || var3 == 5 && var2 instanceof alg || var3 == 6 && var2 instanceof aku) {
            var2.a(var1.c());
         }
      }

   }

   public void a(gq var1) {
      fh.a(var1, this, this.f);
      if (var1.a()) {
         this.f.f.a(var1.b(), var1.d(), var1.c());
      } else {
         this.f.f.b(var1.b(), var1.d(), var1.c());
      }

   }

   public bdc a(UUID var1) {
      return (bdc)this.i.get(var1);
   }

   public void a(gc var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      if ("minecraft:container".equals(var1.b())) {
         var2.a((og)(new oq(var1.c(), var1.d())));
         var2.bk.d = var1.a();
      } else if ("minecraft:villager".equals(var1.b())) {
         var2.a((acy)(new wg(var2, var1.c())));
         var2.bk.d = var1.a();
      } else if ("EntityHorse".equals(var1.b())) {
         pk var3 = this.g.a(var1.e());
         if (var3 instanceof tp) {
            var2.a((tp)var3, new xj(var1.c(), var1.d()));
            var2.bk.d = var1.a();
         }
      } else if (!var1.f()) {
         var2.a((ol)(new bey(var1.b(), var1.c())));
         var2.bk.d = var1.a();
      } else {
         bez var4 = new bez(var1.b(), var1.c(), var1.d());
         var2.a((og)var4);
         var2.bk.d = var1.a();
      }

   }

   public void a(gg var1) {
      fh.a(var1, this, this.f);
      if ("MC|TrList".equals(var1.a())) {
         em var2 = var1.b();

         try {
            int var3 = var2.readInt();
            axu var4 = this.f.m;
            if (var4 != null && var4 instanceof azd && var3 == this.f.h.bk.d) {
               acy var5 = ((azd)var4).a();
               ada var6 = ada.b(var2);
               var5.a(var6);
            }
         } catch (IOException var10) {
            b.error("Couldn't load trade info", var10);
         } finally {
            var2.release();
         }
      } else if ("MC|Brand".equals(var1.a())) {
         this.f.h.f(var1.b().c(32767));
      } else if ("MC|BOpen".equals(var1.a())) {
         zx var12 = this.f.h.bZ();
         if (var12 != null && var12.b() == zy.bN) {
            this.f.a((axu)(new ayo(this.f.h, var12, false)));
         }
      }

   }

   public void a(fw var1) {
      fh.a(var1, this, this.f);
      this.f.f.P().a(var1.b());
      this.f.f.P().e(var1.a());
   }

   public void a(hz var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      if (var2 != null) {
         var2.bW = var1.b();
         var2.bX = var1.c();
         var2.bY = var1.d();
         double var3 = (double)var2.bW / 32.0D;
         double var5 = (double)var2.bX / 32.0D;
         double var7 = (double)var2.bY / 32.0D;
         float var9 = (float)(var1.e() * 360) / 256.0F;
         float var10 = (float)(var1.f() * 360) / 256.0F;
         if (!(Math.abs(var2.s - var3) >= 0.03125D) && !(Math.abs(var2.t - var5) >= 0.015625D) && !(Math.abs(var2.u - var7) >= 0.03125D)) {
            var2.a(var2.s, var2.t, var2.u, var9, var10, 3, true);
         } else {
            var2.a(var3, var5, var7, var9, var10, 3, true);
         }

         var2.C = var1.g();
      }
   }

   public void a(ge var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      if (var2.bk != null && var2.bk.d == var1.a()) {
         var2.bk.b(var1.b(), var1.c());
      }

   }

   public void a(hp var1) {
      fh.a(var1, this, this.f);
      this.f.h.n(var1.a());
      this.f.h.cl().a(var1.b());
      this.f.h.cl().b(var1.c());
   }

   public bdc a(String var1) {
      Iterator var2 = this.i.values().iterator();

      bdc var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (bdc)var2.next();
      } while(!var3.a().getName().equals(var1));

      return var3;
   }

   public void a(gn var1) {
      this.a((ff)(new io(var1.a())));
   }

   public void a(gj var1) {
      fh.a(var1, this, this.f);
      pk var2 = var1.a((adm)this.g);
      if (var2 != null) {
         var2.g(var1.a());
      }

   }

   public void a(gx var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      var2.bA.b = var1.b();
      var2.bA.d = var1.d();
      var2.bA.a = var1.a();
      var2.bA.c = var1.c();
      var2.bA.a(var1.e());
      var2.bA.b(var1.f());
   }

   public void a(hv var1) {
      fh.a(var1, this, this.f);
      hv.a var2 = var1.a();
      String var3 = null;
      String var4 = null;
      String var5 = var1.b() != null ? var1.b().d() : "";
      switch(var2) {
      case a:
         var3 = var5;
         break;
      case b:
         var4 = var5;
         break;
      case e:
         this.f.q.a("", "", -1, -1, -1);
         this.f.q.a();
         return;
      }

      this.f.q.a(var3, var4, var1.c(), var1.d(), var1.e());
   }

   public void a(fk var1) {
      fh.a(var1, this, this.f);
      double var2 = (double)var1.b() / 32.0D;
      double var4 = (double)var1.c() / 32.0D;
      double var6 = (double)var1.d() / 32.0D;
      Object var8 = null;
      if (var1.j() == 10) {
         var8 = va.a(this.g, var2, var4, var6, va.a.a(var1.k()));
      } else if (var1.j() == 90) {
         pk var9 = this.g.a(var1.k());
         if (var9 instanceof wn) {
            var8 = new ur(this.g, var2, var4, var6, (wn)var9);
         }

         var1.g(0);
      } else if (var1.j() == 60) {
         var8 = new wq(this.g, var2, var4, var6);
      } else if (var1.j() == 61) {
         var8 = new wx(this.g, var2, var4, var6);
      } else if (var1.j() == 71) {
         var8 = new uo(this.g, new cj(ns.c(var2), ns.c(var4), ns.c(var6)), cq.b(var1.k()));
         var1.g(0);
      } else if (var1.j() == 77) {
         var8 = new up(this.g, new cj(ns.c(var2), ns.c(var4), ns.c(var6)));
         var1.g(0);
      } else if (var1.j() == 65) {
         var8 = new xa(this.g, var2, var4, var6);
      } else if (var1.j() == 72) {
         var8 = new wr(this.g, var2, var4, var6);
      } else if (var1.j() == 76) {
         var8 = new wt(this.g, var2, var4, var6, (zx)null);
      } else if (var1.j() == 63) {
         var8 = new wu(this.g, var2, var4, var6, (double)var1.e() / 8000.0D, (double)var1.f() / 8000.0D, (double)var1.g() / 8000.0D);
         var1.g(0);
      } else if (var1.j() == 64) {
         var8 = new ww(this.g, var2, var4, var6, (double)var1.e() / 8000.0D, (double)var1.f() / 8000.0D, (double)var1.g() / 8000.0D);
         var1.g(0);
      } else if (var1.j() == 66) {
         var8 = new xd(this.g, var2, var4, var6, (double)var1.e() / 8000.0D, (double)var1.f() / 8000.0D, (double)var1.g() / 8000.0D);
         var1.g(0);
      } else if (var1.j() == 62) {
         var8 = new wz(this.g, var2, var4, var6);
      } else if (var1.j() == 73) {
         var8 = new xc(this.g, var2, var4, var6, var1.k());
         var1.g(0);
      } else if (var1.j() == 75) {
         var8 = new xb(this.g, var2, var4, var6);
         var1.g(0);
      } else if (var1.j() == 1) {
         var8 = new ux(this.g, var2, var4, var6);
      } else if (var1.j() == 50) {
         var8 = new vj(this.g, var2, var4, var6, (pr)null);
      } else if (var1.j() == 78) {
         var8 = new um(this.g, var2, var4, var6);
      } else if (var1.j() == 51) {
         var8 = new uf(this.g, var2, var4, var6);
      } else if (var1.j() == 2) {
         var8 = new uz(this.g, var2, var4, var6);
      } else if (var1.j() == 70) {
         var8 = new uy(this.g, var2, var4, var6, afh.d(var1.k() & '\uffff'));
         var1.g(0);
      }

      if (var8 != null) {
         ((pk)var8).bW = var1.b();
         ((pk)var8).bX = var1.c();
         ((pk)var8).bY = var1.d();
         ((pk)var8).z = (float)(var1.h() * 360) / 256.0F;
         ((pk)var8).y = (float)(var1.i() * 360) / 256.0F;
         pk[] var12 = ((pk)var8).aB();
         if (var12 != null) {
            int var10 = var1.a() - ((pk)var8).F();

            for(int var11 = 0; var11 < var12.length; ++var11) {
               var12[var11].d(var12[var11].F() + var10);
            }
         }

         ((pk)var8).d(var1.a());
         this.g.a(var1.a(), (pk)var8);
         if (var1.k() > 0) {
            if (var1.j() == 60) {
               pk var13 = this.g.a(var1.k());
               if (var13 instanceof pr && var8 instanceof wq) {
                  ((wq)var8).c = var13;
               }
            }

            ((pk)var8).i((double)var1.e() / 8000.0D, (double)var1.f() / 8000.0D, (double)var1.g() / 8000.0D);
         }
      }

   }

   public void a(ia var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      if (var2 != null) {
         if (!(var2 instanceof pr)) {
            throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + var2 + ")");
         } else {
            qf var3 = ((pr)var2).by();
            Iterator var4 = var1.b().iterator();

            while(var4.hasNext()) {
               ia.a var5 = (ia.a)var4.next();
               qc var6 = var3.a(var5.a());
               if (var6 == null) {
                  var6 = var3.b((qb)(new qj((qb)null, var5.a(), 0.0D, 2.2250738585072014E-308D, Double.MAX_VALUE)));
               }

               var6.a(var5.b());
               var6.d();
               Iterator var7 = var5.c().iterator();

               while(var7.hasNext()) {
                  qd var8 = (qd)var7.next();
                  var6.b(var8);
               }
            }

         }
      }
   }

   public void a(hf var1) {
      fh.a(var1, this, this.f);
      pk var2 = var1.a((adm)this.g);
      if (var2 != null) {
         float var3 = (float)(var1.a() * 360) / 256.0F;
         var2.f(var3);
      }
   }

   public void a(gk var1) {
      fh.a(var1, this, this.f);
      adi var2 = new adi(this.f.f, (pk)null, var1.d(), var1.e(), var1.f(), var1.g(), var1.h());
      var2.a(true);
      bew var10000 = this.f.h;
      var10000.v += (double)var1.a();
      var10000 = this.f.h;
      var10000.w += (double)var1.b();
      var10000 = this.f.h;
      var10000.x += (double)var1.c();
   }

   public GameProfile e() {
      return this.d;
   }

   public void a(gi var1) {
      fh.a(var1, this, this.f);
      pk var2 = var1.a((adm)this.g);
      if (var2 != null) {
         if (var1.a() == 21) {
            this.f.W().a((bpj)(new bpc((vt)var2)));
         } else {
            var2.a(var1.a());
         }
      }

   }

   public void a(fm var1) {
      fh.a(var1, this, this.f);
      double var2 = (double)var1.b() / 32.0D;
      double var4 = (double)var1.c() / 32.0D;
      double var6 = (double)var1.d() / 32.0D;
      uv var8 = null;
      if (var1.e() == 1) {
         var8 = new uv(this.g, var2, var4, var6);
      }

      if (var8 != null) {
         var8.bW = var1.b();
         var8.bX = var1.c();
         var8.bY = var1.d();
         var8.y = 0.0F;
         var8.z = 0.0F;
         var8.d(var1.a());
         this.g.c(var8);
      }

   }

   public void a(gh var1) {
      this.c.a(var1.a());
   }

   public void a(fi var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      double var3 = var1.a();
      double var5 = var1.b();
      double var7 = var1.c();
      float var9 = var1.d();
      float var10 = var1.e();
      if (var1.f().contains(fi.a.a)) {
         var3 += var2.s;
      } else {
         var2.v = 0.0D;
      }

      if (var1.f().contains(fi.a.b)) {
         var5 += var2.t;
      } else {
         var2.w = 0.0D;
      }

      if (var1.f().contains(fi.a.c)) {
         var7 += var2.u;
      } else {
         var2.x = 0.0D;
      }

      if (var1.f().contains(fi.a.e)) {
         var10 += var2.z;
      }

      if (var1.f().contains(fi.a.d)) {
         var9 += var2.y;
      }

      var2.a(var3, var5, var7, var9, var10);
      this.c.a((ff)(new ip.b(var2.s, var2.aR().b, var2.u, var2.y, var2.z, false)));
      if (!this.h) {
         this.f.h.p = this.f.h.s;
         this.f.h.q = this.f.h.t;
         this.f.h.r = this.f.h.u;
         this.h = true;
         this.f.a((axu)null);
      }

   }

   public void a(ho var1) {
      fh.a(var1, this, this.f);
      this.f.h.a(var1.a(), var1.b(), var1.c());
   }

   public void a(hl var1) {
      fh.a(var1, this, this.f);
      Object var2 = this.g.a(var1.b());
      pk var3 = this.g.a(var1.c());
      if (var1.a() == 0) {
         boolean var4 = false;
         if (var1.b() == this.f.h.F()) {
            var2 = this.f.h;
            if (var3 instanceof ux) {
               ((ux)var3).a(false);
            }

            var4 = ((pk)var2).m == null && var3 != null;
         } else if (var3 instanceof ux) {
            ((ux)var3).a(true);
         }

         if (var2 == null) {
            return;
         }

         ((pk)var2).a(var3);
         if (var4) {
            avh var5 = this.f.t;
            this.f.q.a(bnq.a("mount.onboard", avh.c(var5.ad.i())), false);
         }
      } else if (var1.a() == 1 && var2 instanceof ps) {
         if (var3 != null) {
            ((ps)var2).a(var3, false);
         } else {
            ((ps)var2).a(false, false);
         }
      }

   }

   public void a(go var1) {
      fh.a(var1, this, this.f);
      if (var1.e()) {
         if (var1.d() == 0) {
            this.g.b(var1.b(), var1.c(), false);
            return;
         }

         this.g.b(var1.b(), var1.c(), true);
      }

      this.g.a(var1.b() << 4, 0, var1.c() << 4, (var1.b() << 4) + 15, 256, (var1.c() << 4) + 15);
      amy var2 = this.g.a(var1.b(), var1.c());
      var2.a(var1.a(), var1.d(), var1.e());
      this.g.b(var1.b() << 4, 0, var1.c() << 4, (var1.b() << 4) + 15, 256, (var1.c() << 4) + 15);
      if (!var1.e() || !(this.g.t instanceof ano)) {
         var2.l();
      }

   }

   public void a(hg var1) {
      fh.a(var1, this, this.f);
      var1.a(this.g.af());
   }

   public void a(eu var1) {
      this.f.a((bdb)null);
      if (this.e != null) {
         if (this.e instanceof awr) {
            this.f.a((axu)(new DisconnectedRealmsScreen(((awr)this.e).a(), "disconnect.lost", var1)).getProxy());
         } else {
            this.f.a((axu)(new axh(this.e, "disconnect.lost", var1)));
         }
      } else {
         this.f.a((axu)(new axh(new azh(new aya()), "disconnect.lost", var1)));
      }

   }

   public void a(fs var1) {
      fh.a(var1, this, this.f);
      this.f.f.c(var1.a(), var1.b(), var1.c());
   }

   public void a(hu var1) {
      fh.a(var1, this, this.f);
      this.f.f.a(var1.a());
      this.f.f.b(var1.b());
   }

   public void a(ib var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.b());
      if (var2 instanceof pr) {
         pf var3 = new pf(var1.c(), var1.e(), var1.d(), false, var1.f());
         var3.b(var1.a());
         ((pr)var2).c(var3);
      }
   }

   public void a(gs var1) {
      fh.a(var1, this, this.f);
      this.f.f.a(var1.b(), var1.c(), var1.d(), var1.a(), var1.e(), var1.f(), false);
   }

   public void a(fz var1) {
      fh.a(var1, this, this.f);
      fz.a[] var2 = var1.a();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         fz.a var5 = var2[var4];
         this.g.b(var5.a(), var5.c());
      }

   }

   public void a(gm var1) {
      fh.a(var1, this, this.f);
      bew var2 = this.f.h;
      int var3 = var1.a();
      float var4 = var1.b();
      int var5 = ns.d(var4 + 0.5F);
      if (var3 >= 0 && var3 < gm.a.length && gm.a[var3] != null) {
         var2.b((eu)(new fb(gm.a[var3], new Object[0])));
      }

      if (var3 == 1) {
         this.g.P().b(true);
         this.g.k(0.0F);
      } else if (var3 == 2) {
         this.g.P().b(false);
         this.g.k(1.0F);
      } else if (var3 == 3) {
         this.f.c.a(adp.a.a(var5));
      } else if (var3 == 4) {
         this.f.a((axu)(new ayc()));
      } else if (var3 == 5) {
         avh var6 = this.f.t;
         if (var4 == 0.0F) {
            this.f.a((axu)(new axf()));
         } else if (var4 == 101.0F) {
            this.f.q.d().a((eu)(new fb("demo.help.movement", new Object[]{avh.c(var6.Y.i()), avh.c(var6.Z.i()), avh.c(var6.aa.i()), avh.c(var6.ab.i())})));
         } else if (var4 == 102.0F) {
            this.f.q.d().a((eu)(new fb("demo.help.jump", new Object[]{avh.c(var6.ac.i())})));
         } else if (var4 == 103.0F) {
            this.f.q.d().a((eu)(new fb("demo.help.inventory", new Object[]{avh.c(var6.af.i())})));
         }
      } else if (var3 == 6) {
         this.g.a(var2.s, var2.t + (double)var2.aS(), var2.u, "random.successful_hit", 0.18F, 0.45F, false);
      } else if (var3 == 7) {
         this.g.k(var4);
      } else if (var3 == 8) {
         this.g.i(var4);
      } else if (var3 == 10) {
         this.g.a(cy.P, var2.s, var2.t, var2.u, 0.0D, 0.0D, 0.0D, new int[0]);
         this.g.a(var2.s, var2.t, var2.u, "mob.guardian.curse", 1.0F, 1.0F, false);
      }

   }

   public void a(hb var1) {
      fh.a(var1, this, this.f);

      for(int var2 = 0; var2 < var1.a().length; ++var2) {
         this.g.e(var1.a()[var2]);
      }

   }

   public void a(fu var1) {
      fh.a(var1, this, this.f);
      this.f.f.c(var1.a(), var1.d(), var1.b(), var1.c());
   }

   public void a(fo var1) {
      fh.a(var1, this, this.f);
      uq var2 = new uq(this.g, var1.b(), var1.c(), var1.d());
      this.g.a(var1.a(), var2);
   }

   public void b() {
      this.g = null;
   }

   public void a(ht var1) {
      fh.a(var1, this, this.f);
      this.f.h.a(var1.a(), true);
      this.f.f.P().a(var1.a());
   }

   public void a(fx var1) {
      fh.a(var1, this, this.f);
      String[] var2 = var1.a();
      if (this.f.m instanceof awv) {
         awv var3 = (awv)this.f.m;
         var3.a(var2);
      }

   }

   public void a(hi var1) {
      fh.a(var1, this, this.f);
      if (var1.a() >= 0 && var1.a() < wm.i()) {
         this.f.h.bi.c = var1.a();
      }

   }

   public void a(hr var1) {
      fh.a(var1, this, this.f);
      auo var2 = this.g.Z();
      aul var3;
      if (var1.f() == 0) {
         var3 = var2.e(var1.a());
      } else {
         var3 = var2.d(var1.a());
      }

      if (var1.f() == 0 || var1.f() == 2) {
         var3.a(var1.b());
         var3.b(var1.c());
         var3.c(var1.d());
         var3.a(a.a(var1.h()));
         var3.a(var1.g());
         auq.a var4 = auq.a.a(var1.i());
         if (var4 != null) {
            var3.a(var4);
         }
      }

      String var5;
      Iterator var6;
      if (var1.f() == 0 || var1.f() == 3) {
         var6 = var1.e().iterator();

         while(var6.hasNext()) {
            var5 = (String)var6.next();
            var2.a(var5, var1.a());
         }
      }

      if (var1.f() == 4) {
         var6 = var1.e().iterator();

         while(var6.hasNext()) {
            var5 = (String)var6.next();
            var2.a(var5, var3);
         }
      }

      if (var1.f() == 1) {
         var2.d(var3);
      }

   }

   public bcy(ave var1, axu var2, ek var3, GameProfile var4) {
      this.f = var1;
      this.e = var2;
      this.c = var3;
      this.d = var4;
   }

   public void a(hm var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.a());
      if (var2 != null) {
         var2.i((double)var1.b() / 8000.0D, (double)var1.c() / 8000.0D, (double)var1.d() / 8000.0D);
      }
   }

   public void a(fp var1) {
      fh.a(var1, this, this.f);
      double var2 = (double)var1.d() / 32.0D;
      double var4 = (double)var1.e() / 32.0D;
      double var6 = (double)var1.f() / 32.0D;
      float var8 = (float)(var1.g() * 360) / 256.0F;
      float var9 = (float)(var1.h() * 360) / 256.0F;
      bex var10 = new bex(this.f.f, this.a(var1.c()).a());
      var10.p = var10.P = (double)(var10.bW = var1.d());
      var10.q = var10.Q = (double)(var10.bX = var1.e());
      var10.r = var10.R = (double)(var10.bY = var1.f());
      int var11 = var1.i();
      if (var11 == 0) {
         var10.bi.a[var10.bi.c] = null;
      } else {
         var10.bi.a[var10.bi.c] = new zx(zw.b(var11), 1, 0);
      }

      var10.a(var2, var4, var6, var8, var9);
      this.g.a(var1.b(), var10);
      List var12 = var1.a();
      if (var12 != null) {
         var10.H().a(var12);
      }

   }

   public void a(hn var1) {
      fh.a(var1, this, this.f);
      pk var2 = this.g.a(var1.b());
      if (var2 != null) {
         var2.c(var1.c(), var1.a());
      }

   }

   public void a(gr var1) {
      fh.a(var1, this, this.f);
      if (var1.j() == 0) {
         double var2 = (double)(var1.i() * var1.f());
         double var4 = (double)(var1.i() * var1.g());
         double var6 = (double)(var1.i() * var1.h());

         try {
            this.g.a(var1.a(), var1.b(), var1.c(), var1.d(), var1.e(), var2, var4, var6, var1.k());
         } catch (Throwable var17) {
            b.warn("Could not spawn particle effect " + var1.a());
         }
      } else {
         for(int var18 = 0; var18 < var1.j(); ++var18) {
            double var3 = this.k.nextGaussian() * (double)var1.f();
            double var5 = this.k.nextGaussian() * (double)var1.g();
            double var7 = this.k.nextGaussian() * (double)var1.h();
            double var9 = this.k.nextGaussian() * (double)var1.i();
            double var11 = this.k.nextGaussian() * (double)var1.i();
            double var13 = this.k.nextGaussian() * (double)var1.i();

            try {
               this.g.a(var1.a(), var1.b(), var1.c() + var3, var1.d() + var5, var1.e() + var7, var9, var11, var13, var1.k());
            } catch (Throwable var16) {
               b.warn("Could not spawn particle effect " + var1.a());
               return;
            }
         }
      }

   }

   public ek a() {
      return this.c;
   }

   public void a(gu var1) {
      fh.a(var1, this, this.f);
      atg var2 = aab.a(var1.a(), this.f.f);
      var1.a(var2);
      this.f.o.k().a(var2);
   }

   public Collection<bdc> d() {
      return this.i.values();
   }

   public void a(fy var1) {
      fh.a(var1, this, this.f);
      if (var1.c() == 2) {
         this.f.q.a(var1.a(), false);
      } else {
         this.f.q.d().a(var1.a());
      }

   }
}
