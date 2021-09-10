import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class bfr implements bnj, ado {
   private double D = Double.MIN_VALUE;
   private double J = Double.MIN_VALUE;
   private int R;
   private final Vector4f[] W = new Vector4f[8];
   private bmt u;
   private bmt t;
   private int w;
   private bid V;
   private final ave h;
   private blr B;
   private final Map<cj, bpj> y = Maps.newHashMap();
   private boolean ac = true;
   private bfw A;
   private final Set<akw> n = Sets.newHashSet();
   private double aa;
   private static final jy f = new jy("textures/environment/end_sky.png");
   private int T;
   private int S;
   private List<bfr.a> m = Lists.newArrayListWithCapacity(69696);
   private double M = Double.MIN_VALUE;
   private static final jy c = new jy("textures/environment/moon_phases.png");
   private double ab;
   private bga o;
   bhu a;
   private int G = Integer.MIN_VALUE;
   private int P = -1;
   private Set<bht> l = Sets.newLinkedHashSet();
   private bmt v;
   private static final jy d = new jy("textures/environment/sun.png");
   private bmu s;
   private final bqr X = new bqr();
   private int r = -1;
   private static final jy e = new jy("textures/environment/clouds.png");
   private double C = Double.MIN_VALUE;
   private bdb k;
   private static final Logger b = LogManager.getLogger();
   private boolean U = false;
   private bfh O;
   private static final jy g = new jy("textures/misc/forcefield.png");
   private final bmi[] z = new bmi[10];
   private int Q = 2;
   private double I = Double.MIN_VALUE;
   private int q = -1;
   private final Map<Integer, kw> x = Maps.newHashMap();
   private boolean Y = false;
   private final biu j;
   private int H = Integer.MIN_VALUE;
   private double Z;
   private int F = Integer.MIN_VALUE;
   private double E = Double.MIN_VALUE;
   private double K = Double.MIN_VALUE;
   private int p = -1;
   private final bho N = new bho();
   private final bmj i;
   private double L = Double.MIN_VALUE;

   public void a(long var1) {
      this.ac |= this.N.a(var1);
      if (!this.l.isEmpty()) {
         Iterator var3 = this.l.iterator();

         while(var3.hasNext()) {
            bht var4 = (bht)var3.next();
            if (!this.N.a(var4)) {
               break;
            }

            var4.a(false);
            var3.remove();
            long var5 = var1 - System.nanoTime();
            if (var5 < 0L) {
               break;
            }
         }
      }

   }

   private void s() {
      bfl.a(774, 768, 1, 0);
      bfl.l();
      bfl.c(1.0F, 1.0F, 1.0F, 0.5F);
      bfl.a(-3.0F, -3.0F);
      bfl.q();
      bfl.a(516, 0.1F);
      bfl.d();
      bfl.E();
   }

   protected Vector3f a(pk var1, double var2) {
      float var4 = (float)((double)var1.B + (double)(var1.z - var1.B) * var2);
      float var5 = (float)((double)var1.A + (double)(var1.y - var1.A) * var2);
      if (ave.A().t.aB == 2) {
         var4 += 180.0F;
      }

      float var6 = ns.b(-var5 * 0.017453292F - 3.1415927F);
      float var7 = ns.a(-var5 * 0.017453292F - 3.1415927F);
      float var8 = -ns.b(-var4 * 0.017453292F);
      float var9 = ns.a(-var4 * 0.017453292F);
      return new Vector3f(var7 * var8, var9, var6 * var8);
   }

   public void k() {
   }

   private Set<cq> c(cj var1) {
      bhw var2 = new bhw();
      cj var3 = new cj(var1.n() >> 4 << 4, var1.o() >> 4 << 4, var1.p() >> 4 << 4);
      amy var4 = this.k.f(var3);
      Iterator var5 = cj.b(var3, var3.a(15, 15, 15)).iterator();

      while(var5.hasNext()) {
         cj.a var6 = (cj.a)var5.next();
         if (var4.a((cj)var6).c()) {
            var2.a(var6);
         }
      }

      return var2.b(var1);
   }

   private void a(double var1, double var3, double var5) {
      this.V = new bib();
      ((bib)this.V).b();
      bqq var7 = new bqq(this.V.c);
      var7.transpose();
      bqq var8 = new bqq(this.V.b);
      var8.transpose();
      bqq var9 = new bqq();
      bqq.mul(var8, var7, var9);
      var9.invert();
      this.X.a = var1;
      this.X.b = var3;
      this.X.c = var5;
      this.W[0] = new Vector4f(-1.0F, -1.0F, -1.0F, 1.0F);
      this.W[1] = new Vector4f(1.0F, -1.0F, -1.0F, 1.0F);
      this.W[2] = new Vector4f(1.0F, 1.0F, -1.0F, 1.0F);
      this.W[3] = new Vector4f(-1.0F, 1.0F, -1.0F, 1.0F);
      this.W[4] = new Vector4f(-1.0F, -1.0F, 1.0F, 1.0F);
      this.W[5] = new Vector4f(1.0F, -1.0F, 1.0F, 1.0F);
      this.W[6] = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.W[7] = new Vector4f(-1.0F, 1.0F, 1.0F, 1.0F);

      for(int var10 = 0; var10 < 8; ++var10) {
         bqq.transform(var9, this.W[var10], this.W[var10]);
         Vector4f var10000 = this.W[var10];
         var10000.x /= this.W[var10].w;
         var10000 = this.W[var10];
         var10000.y /= this.W[var10].w;
         var10000 = this.W[var10];
         var10000.z /= this.W[var10].w;
         this.W[var10].w = 1.0F;
      }

   }

   public void a(Collection<akw> var1, Collection<akw> var2) {
      synchronized(this.n) {
         this.n.removeAll(var1);
         this.n.addAll(var2);
      }
   }

   public void a(String var1, double var2, double var4, double var6, float var8, float var9) {
   }

   public String g() {
      return "E: " + this.S + "/" + this.R + ", B: " + this.T + ", I: " + (this.R - this.T - this.S);
   }

   protected void e() {
      this.l.clear();
      this.N.b();
   }

   public void a(int var1, cj var2, int var3) {
      switch(var1) {
      case 1013:
      case 1018:
         if (this.h.ac() != null) {
            double var4 = (double)var2.n() - this.h.ac().s;
            double var6 = (double)var2.o() - this.h.ac().t;
            double var8 = (double)var2.p() - this.h.ac().u;
            double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
            double var12 = this.h.ac().s;
            double var14 = this.h.ac().t;
            double var16 = this.h.ac().u;
            if (var10 > 0.0D) {
               var12 += var4 / var10 * 2.0D;
               var14 += var6 / var10 * 2.0D;
               var16 += var8 / var10 * 2.0D;
            }

            if (var1 == 1013) {
               this.k.a(var12, var14, var16, "mob.wither.spawn", 1.0F, 1.0F, false);
            } else {
               this.k.a(var12, var14, var16, "mob.enderdragon.end", 5.0F, 1.0F, false);
            }
         }
      default:
      }
   }

   public bfr(ave var1) {
      this.h = var1;
      this.j = var1.af();
      this.i = var1.P();
      this.i.a(g);
      GL11.glTexParameteri(3553, 10242, 10497);
      GL11.glTexParameteri(3553, 10243, 10497);
      bfl.i(0);
      this.n();
      this.Y = bqs.f();
      if (this.Y) {
         this.O = new bfy();
         this.a = new bhv();
      } else {
         this.O = new bft();
         this.a = new bhr();
      }

      this.s = new bmu();
      this.s.a(new bmv(0, bmv.a.a, bmv.b.a, 3));
      this.q();
      this.p();
      this.o();
   }

   private void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.o.a(var1, var2, var3, var4, var5, var6);
   }

   public static void a(aug var0) {
      bfx var1 = bfx.a();
      bfd var2 = var1.c();
      var2.a(3, bms.e);
      var2.b(var0.a, var0.b, var0.c).d();
      var2.b(var0.d, var0.b, var0.c).d();
      var2.b(var0.d, var0.b, var0.f).d();
      var2.b(var0.a, var0.b, var0.f).d();
      var2.b(var0.a, var0.b, var0.c).d();
      var1.b();
      var2.a(3, bms.e);
      var2.b(var0.a, var0.e, var0.c).d();
      var2.b(var0.d, var0.e, var0.c).d();
      var2.b(var0.d, var0.e, var0.f).d();
      var2.b(var0.a, var0.e, var0.f).d();
      var2.b(var0.a, var0.e, var0.c).d();
      var1.b();
      var2.a(1, bms.e);
      var2.b(var0.a, var0.b, var0.c).d();
      var2.b(var0.a, var0.e, var0.c).d();
      var2.b(var0.d, var0.b, var0.c).d();
      var2.b(var0.d, var0.e, var0.c).d();
      var2.b(var0.d, var0.b, var0.f).d();
      var2.b(var0.d, var0.e, var0.f).d();
      var2.b(var0.a, var0.b, var0.f).d();
      var2.b(var0.a, var0.e, var0.f).d();
      var1.b();
   }

   public void a(pk var1, double var2, bia var4, int var5, boolean var6) {
      if (this.h.t.c != this.P) {
         this.a();
      }

      this.k.B.a("camera");
      double var7 = var1.s - this.C;
      double var9 = var1.t - this.D;
      double var11 = var1.u - this.E;
      if (this.F != var1.ae || this.G != var1.af || this.H != var1.ag || var7 * var7 + var9 * var9 + var11 * var11 > 16.0D) {
         this.C = var1.s;
         this.D = var1.t;
         this.E = var1.u;
         this.F = var1.ae;
         this.G = var1.af;
         this.H = var1.ag;
         this.o.a(var1.s, var1.u);
      }

      this.k.B.c("renderlistcamera");
      double var13 = var1.P + (var1.s - var1.P) * var2;
      double var15 = var1.Q + (var1.t - var1.Q) * var2;
      double var17 = var1.R + (var1.u - var1.R) * var2;
      this.O.a(var13, var15, var17);
      this.k.B.c("cull");
      if (this.V != null) {
         bic var19 = new bic(this.V);
         var19.a(this.X.a, this.X.b, this.X.c);
         var4 = var19;
      }

      this.h.A.c("culling");
      cj var35 = new cj(var13, var15 + (double)var1.aS(), var17);
      bht var20 = this.o.a(var35);
      cj var21 = new cj(ns.c(var13 / 16.0D) * 16, ns.c(var15 / 16.0D) * 16, ns.c(var17 / 16.0D) * 16);
      this.ac = this.ac || !this.l.isEmpty() || var1.s != this.I || var1.t != this.J || var1.u != this.K || (double)var1.z != this.L || (double)var1.y != this.M;
      this.I = var1.s;
      this.J = var1.t;
      this.K = var1.u;
      this.L = (double)var1.z;
      this.M = (double)var1.y;
      boolean var22 = this.V != null;
      bfr.a var39;
      bht var41;
      if (!var22 && this.ac) {
         this.ac = false;
         this.m = Lists.newArrayList();
         LinkedList var23 = Lists.newLinkedList();
         boolean var24 = this.h.G;
         if (var20 != null) {
            boolean var38 = false;
            bfr.a var40 = new bfr.a(this, var20, (cq)null, 0);
            Set var42 = this.c(var35);
            if (var42.size() == 1) {
               Vector3f var44 = this.a(var1, var2);
               cq var29 = cq.a(var44.x, var44.y, var44.z).d();
               var42.remove(var29);
            }

            if (var42.isEmpty()) {
               var38 = true;
            }

            if (var38 && !var6) {
               this.m.add(var40);
            } else {
               if (var6 && this.k.p(var35).c().c()) {
                  var24 = false;
               }

               var20.a(var5);
               var23.add(var40);
            }
         } else {
            int var25 = var35.o() > 0 ? 248 : 8;

            for(int var26 = -this.P; var26 <= this.P; ++var26) {
               for(int var27 = -this.P; var27 <= this.P; ++var27) {
                  bht var28 = this.o.a(new cj((var26 << 4) + 8, var25, (var27 << 4) + 8));
                  if (var28 != null && ((bia)var4).a(var28.c)) {
                     var28.a(var5);
                     var23.add(new bfr.a(this, var28, (cq)null, 0));
                  }
               }
            }
         }

         while(!var23.isEmpty()) {
            var39 = (bfr.a)var23.poll();
            var41 = var39.a;
            cq var43 = var39.b;
            cj var45 = var41.j();
            this.m.add(var39);
            cq[] var46 = cq.values();
            int var30 = var46.length;

            for(int var31 = 0; var31 < var30; ++var31) {
               cq var32 = var46[var31];
               bht var33 = this.a(var21, var41, var32);
               if ((!var24 || !var39.c.contains(var32.d())) && (!var24 || var43 == null || var41.g().a(var43.d(), var32)) && var33 != null && var33.a(var5) && ((bia)var4).a(var33.c)) {
                  bfr.a var34 = new bfr.a(this, var33, var32, var39.d + 1);
                  var34.c.addAll(var39.c);
                  var34.c.add(var32);
                  var23.add(var34);
               }
            }
         }
      }

      if (this.U) {
         this.a(var13, var15, var17);
         this.U = false;
      }

      this.N.e();
      Set var36 = this.l;
      this.l = Sets.newLinkedHashSet();
      Iterator var37 = this.m.iterator();

      while(true) {
         do {
            if (!var37.hasNext()) {
               this.l.addAll(var36);
               this.h.A.b();
               return;
            }

            var39 = (bfr.a)var37.next();
            var41 = var39.a;
         } while(!var41.l() && !var36.contains(var41));

         this.ac = true;
         if (this.a(var21, var39.a)) {
            this.h.A.a("build near");
            this.N.b(var41);
            var41.a(false);
            this.h.A.b();
         } else {
            this.l.add(var41);
         }
      }
   }

   public void j() {
      ++this.w;
      if (this.w % 20 == 0) {
         this.a(this.x.values().iterator());
      }

   }

   private void q() {
      bfx var1 = bfx.a();
      bfd var2 = var1.c();
      if (this.t != null) {
         this.t.c();
      }

      if (this.p >= 0) {
         avd.b(this.p);
         this.p = -1;
      }

      if (this.Y) {
         this.t = new bmt(this.s);
         this.a(var2);
         var2.e();
         var2.b();
         this.t.a(var2.f());
      } else {
         this.p = avd.a(1);
         bfl.E();
         GL11.glNewList(this.p, 4864);
         this.a(var2);
         var1.b();
         GL11.glEndList();
         bfl.F();
      }

   }

   private void a(bfd var1, float var2, boolean var3) {
      boolean var4 = true;
      boolean var5 = true;
      var1.a(7, bms.e);

      for(int var6 = -384; var6 <= 384; var6 += 64) {
         for(int var7 = -384; var7 <= 384; var7 += 64) {
            float var8 = (float)var6;
            float var9 = (float)(var6 + 64);
            if (var3) {
               var9 = (float)var6;
               var8 = (float)(var6 + 64);
            }

            var1.b((double)var8, (double)var2, (double)var7).d();
            var1.b((double)var9, (double)var2, (double)var7).d();
            var1.b((double)var9, (double)var2, (double)(var7 + 64)).d();
            var1.b((double)var8, (double)var2, (double)(var7 + 64)).d();
         }
      }

   }

   private bht a(cj var1, bht var2, cq var3) {
      cj var4 = var2.a(var3);
      if (ns.a(var1.n() - var4.n()) > this.P * 16) {
         return null;
      } else if (var4.o() >= 0 && var4.o() < 256) {
         return ns.a(var1.p() - var4.p()) > this.P * 16 ? null : this.o.a(var4);
      } else {
         return null;
      }
   }

   public void a(pk var1, float var2) {
      bfx var3 = bfx.a();
      bfd var4 = var3.c();
      ams var5 = this.k.af();
      double var6 = (double)(this.h.t.c * 16);
      if (!(var1.s < var5.d() - var6) || !(var1.s > var5.b() + var6) || !(var1.u < var5.e() - var6) || !(var1.u > var5.c() + var6)) {
         double var8 = 1.0D - var5.a(var1) / var6;
         var8 = Math.pow(var8, 4.0D);
         double var10 = var1.P + (var1.s - var1.P) * (double)var2;
         double var12 = var1.Q + (var1.t - var1.Q) * (double)var2;
         double var14 = var1.R + (var1.u - var1.R) * (double)var2;
         bfl.l();
         bfl.a(770, 1, 1, 0);
         this.i.a(g);
         bfl.a(false);
         bfl.E();
         int var16 = var5.a().a();
         float var17 = (float)(var16 >> 16 & 255) / 255.0F;
         float var18 = (float)(var16 >> 8 & 255) / 255.0F;
         float var19 = (float)(var16 & 255) / 255.0F;
         bfl.c(var17, var18, var19, (float)var8);
         bfl.a(-3.0F, -3.0F);
         bfl.q();
         bfl.a(516, 0.1F);
         bfl.d();
         bfl.p();
         float var20 = (float)(ave.J() % 3000L) / 3000.0F;
         float var21 = 0.0F;
         float var22 = 0.0F;
         float var23 = 128.0F;
         var4.a(7, bms.g);
         var4.c(-var10, -var12, -var14);
         double var24 = Math.max((double)ns.c(var14 - var6), var5.c());
         double var26 = Math.min((double)ns.f(var14 + var6), var5.e());
         float var28;
         double var29;
         double var31;
         float var33;
         if (var10 > var5.d() - var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.b(var5.d(), 256.0D, var29).a((double)(var20 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var5.d(), 256.0D, var29 + var31).a((double)(var20 + var33 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var5.d(), 0.0D, var29 + var31).a((double)(var20 + var33 + var28), (double)(var20 + 128.0F)).d();
               var4.b(var5.d(), 0.0D, var29).a((double)(var20 + var28), (double)(var20 + 128.0F)).d();
               ++var29;
            }
         }

         if (var10 < var5.b() + var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.b(var5.b(), 256.0D, var29).a((double)(var20 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var5.b(), 256.0D, var29 + var31).a((double)(var20 + var33 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var5.b(), 0.0D, var29 + var31).a((double)(var20 + var33 + var28), (double)(var20 + 128.0F)).d();
               var4.b(var5.b(), 0.0D, var29).a((double)(var20 + var28), (double)(var20 + 128.0F)).d();
               ++var29;
            }
         }

         var24 = Math.max((double)ns.c(var10 - var6), var5.b());
         var26 = Math.min((double)ns.f(var10 + var6), var5.d());
         if (var14 > var5.e() - var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.b(var29, 256.0D, var5.e()).a((double)(var20 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var29 + var31, 256.0D, var5.e()).a((double)(var20 + var33 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var29 + var31, 0.0D, var5.e()).a((double)(var20 + var33 + var28), (double)(var20 + 128.0F)).d();
               var4.b(var29, 0.0D, var5.e()).a((double)(var20 + var28), (double)(var20 + 128.0F)).d();
               ++var29;
            }
         }

         if (var14 < var5.c() + var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.b(var29, 256.0D, var5.c()).a((double)(var20 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var29 + var31, 256.0D, var5.c()).a((double)(var20 + var33 + var28), (double)(var20 + 0.0F)).d();
               var4.b(var29 + var31, 0.0D, var5.c()).a((double)(var20 + var33 + var28), (double)(var20 + 128.0F)).d();
               var4.b(var29, 0.0D, var5.c()).a((double)(var20 + var28), (double)(var20 + 128.0F)).d();
               ++var29;
            }
         }

         var3.b();
         var4.c(0.0D, 0.0D, 0.0D);
         bfl.o();
         bfl.c();
         bfl.a(0.0F, 0.0F);
         bfl.r();
         bfl.d();
         bfl.k();
         bfl.F();
         bfl.a(true);
      }
   }

   private void a(adf var1) {
      this.h.o.i();
      if (bqs.f()) {
         GL11.glEnableClientState(32884);
         bqs.l(bqs.q);
         GL11.glEnableClientState(32888);
         bqs.l(bqs.r);
         GL11.glEnableClientState(32888);
         bqs.l(bqs.q);
         GL11.glEnableClientState(32886);
      }

      this.O.a(var1);
      if (bqs.f()) {
         List var2 = bms.a.h();
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            bmv var4 = (bmv)var3.next();
            bmv.b var5 = var4.b();
            int var6 = var4.d();
            switch(var5) {
            case a:
               GL11.glDisableClientState(32884);
               break;
            case d:
               bqs.l(bqs.q + var6);
               GL11.glDisableClientState(32888);
               bqs.l(bqs.q);
               break;
            case c:
               GL11.glDisableClientState(32886);
               bfl.G();
            }
         }
      }

      this.h.o.h();
   }

   public void c() {
      if (this.d()) {
         bfl.l();
         bfl.a(770, 771, 0, 1);
         this.A.a(this.h.d, this.h.e, false);
         bfl.k();
      }

   }

   public void b(pk var1) {
   }

   public static void a(aug var0, int var1, int var2, int var3, int var4) {
      bfx var5 = bfx.a();
      bfd var6 = var5.c();
      var6.a(3, bms.f);
      var6.b(var0.a, var0.b, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.b, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.b, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.b, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.b, var0.c).b(var1, var2, var3, var4).d();
      var5.b();
      var6.a(3, bms.f);
      var6.b(var0.a, var0.e, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.e, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.e, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.e, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.e, var0.c).b(var1, var2, var3, var4).d();
      var5.b();
      var6.a(1, bms.f);
      var6.b(var0.a, var0.b, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.e, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.b, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.e, var0.c).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.b, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.d, var0.e, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.b, var0.f).b(var1, var2, var3, var4).d();
      var6.b(var0.a, var0.e, var0.f).b(var1, var2, var3, var4).d();
      var5.b();
   }

   public int a(adf var1, double var2, int var4, pk var5) {
      avc.a();
      if (var1 == adf.d) {
         this.h.A.a("translucent_sort");
         double var6 = var5.s - this.Z;
         double var8 = var5.t - this.aa;
         double var10 = var5.u - this.ab;
         if (var6 * var6 + var8 * var8 + var10 * var10 > 1.0D) {
            this.Z = var5.s;
            this.aa = var5.t;
            this.ab = var5.u;
            int var12 = 0;
            Iterator var13 = this.m.iterator();

            while(var13.hasNext()) {
               bfr.a var14 = (bfr.a)var13.next();
               if (var14.a.b.d(var1) && var12++ < 15) {
                  this.N.c(var14.a);
               }
            }
         }

         this.h.A.b();
      }

      this.h.A.a("filterempty");
      int var15 = 0;
      boolean var7 = var1 == adf.d;
      int var16 = var7 ? this.m.size() - 1 : 0;
      int var9 = var7 ? -1 : this.m.size();
      int var17 = var7 ? -1 : 1;

      for(int var11 = var16; var11 != var9; var11 += var17) {
         bht var18 = ((bfr.a)this.m.get(var11)).a;
         if (!var18.g().b(var1)) {
            ++var15;
            this.O.a(var18, var1);
         }
      }

      this.h.A.c("render_" + var1);
      this.a(var1);
      this.h.A.b();
      return var15;
   }

   public void b() {
      if (bqs.O) {
         if (blu.b() == null) {
            blu.a();
         }

         jy var1 = new jy("shaders/post/entity_outline.json");

         try {
            this.B = new blr(this.h.P(), this.h.Q(), this.h.b(), var1);
            this.B.a(this.h.d, this.h.e);
            this.A = this.B.a("final");
         } catch (IOException var3) {
            b.warn("Failed to load shader: " + var1, var3);
            this.B = null;
            this.A = null;
         } catch (JsonSyntaxException var4) {
            b.warn("Failed to load shader: " + var1, var4);
            this.B = null;
            this.A = null;
         }
      } else {
         this.B = null;
         this.A = null;
      }

   }

   public void a(pk var1, bia var2, float var3) {
      if (this.Q > 0) {
         --this.Q;
      } else {
         double var4 = var1.p + (var1.s - var1.p) * (double)var3;
         double var6 = var1.q + (var1.t - var1.q) * (double)var3;
         double var8 = var1.r + (var1.u - var1.r) * (double)var3;
         this.k.B.a("prepare");
         bhc.a.a(this.k, this.h.P(), this.h.k, this.h.ac(), var3);
         this.j.a(this.k, this.h.k, this.h.ac(), this.h.i, this.h.t, var3);
         this.R = 0;
         this.S = 0;
         this.T = 0;
         pk var10 = this.h.ac();
         double var11 = var10.P + (var10.s - var10.P) * (double)var3;
         double var13 = var10.Q + (var10.t - var10.Q) * (double)var3;
         double var15 = var10.R + (var10.u - var10.R) * (double)var3;
         bhc.b = var11;
         bhc.c = var13;
         bhc.d = var15;
         this.j.a(var11, var13, var15);
         this.h.o.i();
         this.k.B.c("global");
         List var17 = this.k.E();
         this.R = var17.size();

         int var18;
         pk var19;
         for(var18 = 0; var18 < this.k.k.size(); ++var18) {
            var19 = (pk)this.k.k.get(var18);
            ++this.S;
            if (var19.h(var4, var6, var8)) {
               this.j.a(var19, var3);
            }
         }

         if (this.d()) {
            bfl.c(519);
            bfl.n();
            this.A.f();
            this.A.a(false);
            this.k.B.c("entityOutlines");
            avc.a();
            this.j.c(true);

            for(var18 = 0; var18 < var17.size(); ++var18) {
               var19 = (pk)var17.get(var18);
               boolean var20 = this.h.ac() instanceof pr && ((pr)this.h.ac()).bJ();
               boolean var21 = var19.h(var4, var6, var8) && (var19.ah || var2.a(var19.aR()) || var19.l == this.h.h) && var19 instanceof wn;
               if ((var19 != this.h.ac() || this.h.t.aB != 0 || var20) && var21) {
                  this.j.a(var19, var3);
               }
            }

            this.j.c(false);
            avc.b();
            bfl.a(false);
            this.B.a(var3);
            bfl.e();
            bfl.a(true);
            this.h.b().a(false);
            bfl.m();
            bfl.l();
            bfl.g();
            bfl.c(515);
            bfl.j();
            bfl.d();
         }

         this.k.B.c("entities");
         Iterator var28 = this.m.iterator();

         label269:
         while(true) {
            ne var35;
            do {
               bfr.a var29;
               if (!var28.hasNext()) {
                  this.k.B.c("blockentities");
                  avc.b();
                  var28 = this.m.iterator();

                  while(true) {
                     List var32;
                     do {
                        if (!var28.hasNext()) {
                           synchronized(this.n) {
                              Iterator var31 = this.n.iterator();

                              while(true) {
                                 if (!var31.hasNext()) {
                                    break;
                                 }

                                 akw var34 = (akw)var31.next();
                                 bhc.a.a(var34, var3, -1);
                              }
                           }

                           this.s();
                           var28 = this.x.values().iterator();

                           while(true) {
                              kw var33;
                              akw var38;
                              afh var41;
                              do {
                                 do {
                                    if (!var28.hasNext()) {
                                       this.t();
                                       this.h.o.h();
                                       this.h.A.b();
                                       return;
                                    }

                                    var33 = (kw)var28.next();
                                    cj var36 = var33.b();
                                    var38 = this.k.s(var36);
                                    if (var38 instanceof aky) {
                                       aky var40 = (aky)var38;
                                       if (var40.h != null) {
                                          var36 = var36.a(cq.e);
                                          var38 = this.k.s(var36);
                                       } else if (var40.f != null) {
                                          var36 = var36.a(cq.c);
                                          var38 = this.k.s(var36);
                                       }
                                    }

                                    var41 = this.k.p(var36).c();
                                 } while(var38 == null);
                              } while(!(var41 instanceof afs) && !(var41 instanceof agp) && !(var41 instanceof ajl) && !(var41 instanceof ajm));

                              bhc.a.a(var38, var3, var33.c());
                           }
                        }

                        var29 = (bfr.a)var28.next();
                        var32 = var29.a.g().b();
                     } while(var32.isEmpty());

                     Iterator var37 = var32.iterator();

                     while(var37.hasNext()) {
                        akw var39 = (akw)var37.next();
                        bhc.a.a(var39, var3, -1);
                     }
                  }
               }

               var29 = (bfr.a)var28.next();
               amy var30 = this.k.f(var29.a.j());
               var35 = var30.s()[var29.a.j().o() / 16];
            } while(var35.isEmpty());

            Iterator var22 = var35.iterator();

            while(true) {
               pk var23;
               boolean var24;
               while(true) {
                  if (!var22.hasNext()) {
                     continue label269;
                  }

                  var23 = (pk)var22.next();
                  var24 = this.j.a(var23, var2, var4, var6, var8) || var23.l == this.h.h;
                  if (!var24) {
                     break;
                  }

                  boolean var25 = this.h.ac() instanceof pr ? ((pr)this.h.ac()).bJ() : false;
                  if ((var23 != this.h.ac() || this.h.t.aB != 0 || var25) && (!(var23.t >= 0.0D) || !(var23.t < 256.0D) || this.k.e(new cj(var23)))) {
                     ++this.S;
                     this.j.a(var23, var3);
                     break;
                  }
               }

               if (!var24 && var23 instanceof xd) {
                  this.h.af().b(var23, var3);
               }
            }
         }
      }
   }

   public void a(bdb var1) {
      if (this.k != null) {
         this.k.b((ado)this);
      }

      this.C = Double.MIN_VALUE;
      this.D = Double.MIN_VALUE;
      this.E = Double.MIN_VALUE;
      this.F = Integer.MIN_VALUE;
      this.G = Integer.MIN_VALUE;
      this.H = Integer.MIN_VALUE;
      this.j.a((adm)var1);
      this.k = var1;
      if (var1 != null) {
         var1.a((ado)this);
         this.a();
      }

   }

   private boolean a(cj var1, bht var2) {
      cj var3 = var2.j();
      if (ns.a(var1.n() - var3.n()) > 16) {
         return false;
      } else if (ns.a(var1.o() - var3.o()) > 16) {
         return false;
      } else {
         return ns.a(var1.p() - var3.p()) <= 16;
      }
   }

   private void a(Iterator<kw> var1) {
      while(var1.hasNext()) {
         kw var2 = (kw)var1.next();
         int var3 = var2.d();
         if (this.w - var3 > 400) {
            var1.remove();
         }
      }

   }

   private void p() {
      bfx var1 = bfx.a();
      bfd var2 = var1.c();
      if (this.u != null) {
         this.u.c();
      }

      if (this.q >= 0) {
         avd.b(this.q);
         this.q = -1;
      }

      if (this.Y) {
         this.u = new bmt(this.s);
         this.a(var2, 16.0F, false);
         var2.e();
         var2.b();
         this.u.a(var2.f());
      } else {
         this.q = avd.a(1);
         GL11.glNewList(this.q, 4864);
         this.a(var2, 16.0F, false);
         var1.b();
         GL11.glEndList();
      }

   }

   public void m() {
      this.ac = true;
   }

   public void a(bni var1) {
      this.n();
   }

   public void b(float var1, int var2) {
      if (this.h.f.t.d()) {
         if (this.h.t.e() == 2) {
            this.c(var1, var2);
         } else {
            bfl.p();
            float var3 = (float)(this.h.ac().Q + (this.h.ac().t - this.h.ac().Q) * (double)var1);
            boolean var4 = true;
            boolean var5 = true;
            bfx var6 = bfx.a();
            bfd var7 = var6.c();
            this.i.a(e);
            bfl.l();
            bfl.a(770, 771, 1, 0);
            aui var8 = this.k.e(var1);
            float var9 = (float)var8.a;
            float var10 = (float)var8.b;
            float var11 = (float)var8.c;
            float var12;
            if (var2 != 2) {
               var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
               float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
               float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
               var9 = var12;
               var10 = var13;
               var11 = var14;
            }

            var12 = 4.8828125E-4F;
            double var26 = (double)((float)this.w + var1);
            double var15 = this.h.ac().p + (this.h.ac().s - this.h.ac().p) * (double)var1 + var26 * 0.029999999329447746D;
            double var17 = this.h.ac().r + (this.h.ac().u - this.h.ac().r) * (double)var1;
            int var19 = ns.c(var15 / 2048.0D);
            int var20 = ns.c(var17 / 2048.0D);
            var15 -= (double)(var19 * 2048);
            var17 -= (double)(var20 * 2048);
            float var21 = this.k.t.f() - var3 + 0.33F;
            float var22 = (float)(var15 * 4.8828125E-4D);
            float var23 = (float)(var17 * 4.8828125E-4D);
            var7.a(7, bms.i);

            for(int var24 = -256; var24 < 256; var24 += 32) {
               for(int var25 = -256; var25 < 256; var25 += 32) {
                  var7.b((double)var24, (double)var21, (double)(var25 + 32)).a((double)((float)var24 * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23)).a(var9, var10, var11, 0.8F).d();
                  var7.b((double)(var24 + 32), (double)var21, (double)(var25 + 32)).a((double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23)).a(var9, var10, var11, 0.8F).d();
                  var7.b((double)(var24 + 32), (double)var21, (double)var25).a((double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)var25 * 4.8828125E-4F + var23)).a(var9, var10, var11, 0.8F).d();
                  var7.b((double)var24, (double)var21, (double)var25).a((double)((float)var24 * 4.8828125E-4F + var22), (double)((float)var25 * 4.8828125E-4F + var23)).a(var9, var10, var11, 0.8F).d();
               }
            }

            var6.b();
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            bfl.k();
            bfl.o();
         }
      }
   }

   public void b(int var1, cj var2, int var3) {
      if (var3 >= 0 && var3 < 10) {
         kw var4 = (kw)this.x.get(var1);
         if (var4 == null || var4.b().n() != var2.n() || var4.b().o() != var2.o() || var4.b().p() != var2.p()) {
            var4 = new kw(var1, var2);
            this.x.put(var1, var4);
         }

         var4.a(var3);
         var4.b(this.w);
      } else {
         this.x.remove(var1);
      }

   }

   private void a(bfd var1) {
      Random var2 = new Random(10842L);
      var1.a(7, bms.e);

      for(int var3 = 0; var3 < 1500; ++var3) {
         double var4 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var8 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var10 = (double)(0.15F + var2.nextFloat() * 0.1F);
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if (var12 < 1.0D && var12 > 0.01D) {
            var12 = 1.0D / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0D;
            double var16 = var6 * 100.0D;
            double var18 = var8 * 100.0D;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var2.nextDouble() * 3.141592653589793D * 2.0D;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for(int var38 = 0; var38 < 4; ++var38) {
               double var39 = 0.0D;
               double var41 = (double)((var38 & 2) - 1) * var10;
               double var43 = (double)((var38 + 1 & 2) - 1) * var10;
               double var45 = 0.0D;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var53 = var47 * var28 + 0.0D * var30;
               double var55 = 0.0D * var28 - var47 * var30;
               double var57 = var55 * var22 - var49 * var24;
               double var61 = var49 * var22 + var55 * var24;
               var1.b(var14 + var57, var16 + var53, var18 + var61).d();
            }
         }
      }

   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.b(var1 - 1, var2 - 1, var3 - 1, var4 + 1, var5 + 1, var6 + 1);
   }

   protected boolean d() {
      return this.A != null && this.B != null && this.h.h != null && this.h.h.v() && this.h.t.ar.d();
   }

   public void a(String var1, cj var2) {
      bpj var3 = (bpj)this.y.get(var2);
      if (var3 != null) {
         this.h.W().b(var3);
         this.y.remove(var2);
      }

      if (var1 != null) {
         aak var4 = aak.b(var1);
         if (var4 != null) {
            this.h.q.a(var4.g());
         }

         bpf var5 = bpf.a(new jy(var1), (float)var2.n(), (float)var2.o(), (float)var2.p());
         this.y.put(var2, var5);
         this.h.W().a((bpj)var5);
      }

   }

   public void a() {
      if (this.k != null) {
         this.ac = true;
         afi.t.b(this.h.t.i);
         afi.u.b(this.h.t.i);
         this.P = this.h.t.c;
         boolean var1 = this.Y;
         this.Y = bqs.f();
         if (var1 && !this.Y) {
            this.O = new bft();
            this.a = new bhr();
         } else if (!var1 && this.Y) {
            this.O = new bfy();
            this.a = new bhv();
         }

         if (var1 != this.Y) {
            this.q();
            this.p();
            this.o();
         }

         if (this.o != null) {
            this.o.a();
         }

         this.e();
         synchronized(this.n) {
            this.n.clear();
         }

         this.o = new bga(this.k, this.h.t.c, this, this.a);
         if (this.k != null) {
            pk var2 = this.h.ac();
            if (var2 != null) {
               this.o.a(var2.s, var2.u);
            }
         }

         this.Q = 2;
      }
   }

   private beb b(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      if (this.h != null && this.h.ac() != null && this.h.j != null) {
         int var16 = this.h.t.aM;
         if (var16 == 1 && this.k.s.nextInt(3) == 0) {
            var16 = 2;
         }

         double var17 = this.h.ac().s - var3;
         double var19 = this.h.ac().t - var5;
         double var21 = this.h.ac().u - var7;
         if (var2) {
            return this.h.j.a(var1, var3, var5, var7, var9, var11, var13, var15);
         } else {
            double var23 = 16.0D;
            if (var17 * var17 + var19 * var19 + var21 * var21 > 256.0D) {
               return null;
            } else {
               return var16 > 1 ? null : this.h.j.a(var1, var3, var5, var7, var9, var11, var13, var15);
            }
         }
      } else {
         return null;
      }
   }

   public void a(wn var1, int var2, cj var3, int var4) {
      Random var5 = this.k.s;
      double var7;
      double var9;
      double var11;
      int var13;
      int var18;
      double var19;
      double var21;
      double var23;
      double var32;
      switch(var2) {
      case 1000:
         this.k.a(var3, "random.click", 1.0F, 1.0F, false);
         break;
      case 1001:
         this.k.a(var3, "random.click", 1.0F, 1.2F, false);
         break;
      case 1002:
         this.k.a(var3, "random.bow", 1.0F, 1.2F, false);
         break;
      case 1003:
         this.k.a(var3, "random.door_open", 1.0F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1004:
         this.k.a(var3, "random.fizz", 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);
         break;
      case 1005:
         if (zw.b(var4) instanceof aak) {
            this.k.a(var3, "records." + ((aak)zw.b(var4)).a);
         } else {
            this.k.a(var3, (String)null);
         }
         break;
      case 1006:
         this.k.a(var3, "random.door_close", 1.0F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1007:
         this.k.a(var3, "mob.ghast.charge", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1008:
         this.k.a(var3, "mob.ghast.fireball", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1009:
         this.k.a(var3, "mob.ghast.fireball", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1010:
         this.k.a(var3, "mob.zombie.wood", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1011:
         this.k.a(var3, "mob.zombie.metal", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1012:
         this.k.a(var3, "mob.zombie.woodbreak", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1014:
         this.k.a(var3, "mob.wither.shoot", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1015:
         this.k.a(var3, "mob.bat.takeoff", 0.05F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1016:
         this.k.a(var3, "mob.zombie.infect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1017:
         this.k.a(var3, "mob.zombie.unfect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1020:
         this.k.a(var3, "random.anvil_break", 1.0F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1021:
         this.k.a(var3, "random.anvil_use", 1.0F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1022:
         this.k.a(var3, "random.anvil_land", 0.3F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2000:
         int var31 = var4 % 3 - 1;
         int var8 = var4 / 3 % 3 - 1;
         var9 = (double)var3.n() + (double)var31 * 0.6D + 0.5D;
         var11 = (double)var3.o() + 0.5D;
         var32 = (double)var3.p() + (double)var8 * 0.6D + 0.5D;

         for(int var33 = 0; var33 < 10; ++var33) {
            double var34 = var5.nextDouble() * 0.2D + 0.01D;
            double var35 = var9 + (double)var31 * 0.01D + (var5.nextDouble() - 0.5D) * (double)var8 * 0.5D;
            double var20 = var11 + (var5.nextDouble() - 0.5D) * 0.5D;
            double var22 = var32 + (double)var8 * 0.01D + (var5.nextDouble() - 0.5D) * (double)var31 * 0.5D;
            double var24 = (double)var31 * var34 + var5.nextGaussian() * 0.01D;
            double var26 = -0.03D + var5.nextGaussian() * 0.01D;
            double var28 = (double)var8 * var34 + var5.nextGaussian() * 0.01D;
            this.a(cy.l, var35, var20, var22, var24, var26, var28);
         }

         return;
      case 2001:
         afh var6 = afh.c(var4 & 4095);
         if (var6.t() != arm.a) {
            this.h.W().a((bpj)(new bpf(new jy(var6.H.a()), (var6.H.d() + 1.0F) / 2.0F, var6.H.e() * 0.8F, (float)var3.n() + 0.5F, (float)var3.o() + 0.5F, (float)var3.p() + 0.5F)));
         }

         this.h.j.a(var3, var6.a(var4 >> 12 & 255));
         break;
      case 2002:
         var7 = (double)var3.n();
         var9 = (double)var3.o();
         var11 = (double)var3.p();

         for(var13 = 0; var13 < 8; ++var13) {
            this.a(cy.K, var7, var9, var11, var5.nextGaussian() * 0.15D, var5.nextDouble() * 0.2D, var5.nextGaussian() * 0.15D, zw.b((zw)zy.bz), var4);
         }

         var13 = zy.bz.g(var4);
         float var14 = (float)(var13 >> 16 & 255) / 255.0F;
         float var15 = (float)(var13 >> 8 & 255) / 255.0F;
         float var16 = (float)(var13 >> 0 & 255) / 255.0F;
         cy var17 = cy.n;
         if (zy.bz.h(var4)) {
            var17 = cy.o;
         }

         for(var18 = 0; var18 < 100; ++var18) {
            var19 = var5.nextDouble() * 4.0D;
            var21 = var5.nextDouble() * 3.141592653589793D * 2.0D;
            var23 = Math.cos(var21) * var19;
            double var25 = 0.01D + var5.nextDouble() * 0.5D;
            double var27 = Math.sin(var21) * var19;
            beb var29 = this.b(var17.c(), var17.e(), var7 + var23 * 0.1D, var9 + 0.3D, var11 + var27 * 0.1D, var23, var25, var27);
            if (var29 != null) {
               float var30 = 0.75F + var5.nextFloat() * 0.25F;
               var29.b(var14 * var30, var15 * var30, var16 * var30);
               var29.a((float)var19);
            }
         }

         this.k.a(var3, "game.potion.smash", 1.0F, this.k.s.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2003:
         var7 = (double)var3.n() + 0.5D;
         var9 = (double)var3.o();
         var11 = (double)var3.p() + 0.5D;

         for(var13 = 0; var13 < 8; ++var13) {
            this.a(cy.K, var7, var9, var11, var5.nextGaussian() * 0.15D, var5.nextDouble() * 0.2D, var5.nextGaussian() * 0.15D, zw.b(zy.bH));
         }

         for(var32 = 0.0D; var32 < 6.283185307179586D; var32 += 0.15707963267948966D) {
            this.a(cy.y, var7 + Math.cos(var32) * 5.0D, var9 - 0.4D, var11 + Math.sin(var32) * 5.0D, Math.cos(var32) * -5.0D, 0.0D, Math.sin(var32) * -5.0D);
            this.a(cy.y, var7 + Math.cos(var32) * 5.0D, var9 - 0.4D, var11 + Math.sin(var32) * 5.0D, Math.cos(var32) * -7.0D, 0.0D, Math.sin(var32) * -7.0D);
         }

         return;
      case 2004:
         for(var18 = 0; var18 < 20; ++var18) {
            var19 = (double)var3.n() + 0.5D + ((double)this.k.s.nextFloat() - 0.5D) * 2.0D;
            var21 = (double)var3.o() + 0.5D + ((double)this.k.s.nextFloat() - 0.5D) * 2.0D;
            var23 = (double)var3.p() + 0.5D + ((double)this.k.s.nextFloat() - 0.5D) * 2.0D;
            this.k.a(cy.l, var19, var21, var23, 0.0D, 0.0D, 0.0D, new int[0]);
            this.k.a(cy.A, var19, var21, var23, 0.0D, 0.0D, 0.0D, new int[0]);
         }

         return;
      case 2005:
         ze.a(this.k, var3, var4);
      }

   }

   private void n() {
      bmh var1 = this.h.T();

      for(int var2 = 0; var2 < this.z.length; ++var2) {
         this.z[var2] = var1.a("minecraft:blocks/destroy_stage_" + var2);
      }

   }

   private void r() {
      bfl.n();
      bfl.c();
      bfl.l();
      bfl.a(770, 771, 1, 0);
      avc.a();
      bfl.a(false);
      this.i.a(f);
      bfx var1 = bfx.a();
      bfd var2 = var1.c();

      for(int var3 = 0; var3 < 6; ++var3) {
         bfl.E();
         if (var3 == 1) {
            bfl.b(90.0F, 1.0F, 0.0F, 0.0F);
         }

         if (var3 == 2) {
            bfl.b(-90.0F, 1.0F, 0.0F, 0.0F);
         }

         if (var3 == 3) {
            bfl.b(180.0F, 1.0F, 0.0F, 0.0F);
         }

         if (var3 == 4) {
            bfl.b(90.0F, 0.0F, 0.0F, 1.0F);
         }

         if (var3 == 5) {
            bfl.b(-90.0F, 0.0F, 0.0F, 1.0F);
         }

         var2.a(7, bms.i);
         var2.b(-100.0D, -100.0D, -100.0D).a(0.0D, 0.0D).b(40, 40, 40, 255).d();
         var2.b(-100.0D, -100.0D, 100.0D).a(0.0D, 16.0D).b(40, 40, 40, 255).d();
         var2.b(100.0D, -100.0D, 100.0D).a(16.0D, 16.0D).b(40, 40, 40, 255).d();
         var2.b(100.0D, -100.0D, -100.0D).a(16.0D, 0.0D).b(40, 40, 40, 255).d();
         var1.b();
         bfl.F();
      }

      bfl.a(true);
      bfl.w();
      bfl.d();
   }

   public void a(bfx var1, bfd var2, pk var3, float var4) {
      double var5 = var3.P + (var3.s - var3.P) * (double)var4;
      double var7 = var3.Q + (var3.t - var3.Q) * (double)var4;
      double var9 = var3.R + (var3.u - var3.R) * (double)var4;
      if (!this.x.isEmpty()) {
         this.i.a(bmh.g);
         this.s();
         var2.a(7, bms.a);
         var2.c(-var5, -var7, -var9);
         var2.c();
         Iterator var11 = this.x.values().iterator();

         while(var11.hasNext()) {
            kw var12 = (kw)var11.next();
            cj var13 = var12.b();
            double var14 = (double)var13.n() - var5;
            double var16 = (double)var13.o() - var7;
            double var18 = (double)var13.p() - var9;
            afh var20 = this.k.p(var13).c();
            if (!(var20 instanceof afs) && !(var20 instanceof agp) && !(var20 instanceof ajl) && !(var20 instanceof ajm)) {
               if (var14 * var14 + var16 * var16 + var18 * var18 > 1024.0D) {
                  var11.remove();
               } else {
                  alz var21 = this.k.p(var13);
                  if (var21.c().t() != arm.a) {
                     int var22 = var12.c();
                     bmi var23 = this.z[var22];
                     bgd var24 = this.h.ae();
                     var24.a(var21, var13, (bmi)var23, (adq)this.k);
                  }
               }
            }
         }

         var1.b();
         var2.c(0.0D, 0.0D, 0.0D);
         this.t();
      }

   }

   private void o() {
      bfx var1 = bfx.a();
      bfd var2 = var1.c();
      if (this.v != null) {
         this.v.c();
      }

      if (this.r >= 0) {
         avd.b(this.r);
         this.r = -1;
      }

      if (this.Y) {
         this.v = new bmt(this.s);
         this.a(var2, -16.0F, true);
         var2.e();
         var2.b();
         this.v.a(var2.f());
      } else {
         this.r = avd.a(1);
         GL11.glNewList(this.r, 4864);
         this.a(var2, -16.0F, true);
         var1.b();
         GL11.glEndList();
      }

   }

   public void a(cj var1) {
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      this.b(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   private void c(float var1, int var2) {
      bfl.p();
      float var3 = (float)(this.h.ac().Q + (this.h.ac().t - this.h.ac().Q) * (double)var1);
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      float var6 = 12.0F;
      float var7 = 4.0F;
      double var8 = (double)((float)this.w + var1);
      double var10 = (this.h.ac().p + (this.h.ac().s - this.h.ac().p) * (double)var1 + var8 * 0.029999999329447746D) / 12.0D;
      double var12 = (this.h.ac().r + (this.h.ac().u - this.h.ac().r) * (double)var1) / 12.0D + 0.33000001311302185D;
      float var14 = this.k.t.f() - var3 + 0.33F;
      int var15 = ns.c(var10 / 2048.0D);
      int var16 = ns.c(var12 / 2048.0D);
      var10 -= (double)(var15 * 2048);
      var12 -= (double)(var16 * 2048);
      this.i.a(e);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      aui var17 = this.k.e(var1);
      float var18 = (float)var17.a;
      float var19 = (float)var17.b;
      float var20 = (float)var17.c;
      float var21;
      float var22;
      float var23;
      if (var2 != 2) {
         var21 = (var18 * 30.0F + var19 * 59.0F + var20 * 11.0F) / 100.0F;
         var22 = (var18 * 30.0F + var19 * 70.0F) / 100.0F;
         var23 = (var18 * 30.0F + var20 * 70.0F) / 100.0F;
         var18 = var21;
         var19 = var22;
         var20 = var23;
      }

      var21 = var18 * 0.9F;
      var22 = var19 * 0.9F;
      var23 = var20 * 0.9F;
      float var24 = var18 * 0.7F;
      float var25 = var19 * 0.7F;
      float var26 = var20 * 0.7F;
      float var27 = var18 * 0.8F;
      float var28 = var19 * 0.8F;
      float var29 = var20 * 0.8F;
      float var30 = 0.00390625F;
      float var31 = (float)ns.c(var10) * 0.00390625F;
      float var32 = (float)ns.c(var12) * 0.00390625F;
      float var33 = (float)(var10 - (double)ns.c(var10));
      float var34 = (float)(var12 - (double)ns.c(var12));
      boolean var35 = true;
      boolean var36 = true;
      float var37 = 9.765625E-4F;
      bfl.a(12.0F, 1.0F, 12.0F);

      for(int var38 = 0; var38 < 2; ++var38) {
         if (var38 == 0) {
            bfl.a(false, false, false, false);
         } else {
            switch(var2) {
            case 0:
               bfl.a(false, true, true, true);
               break;
            case 1:
               bfl.a(true, false, false, true);
               break;
            case 2:
               bfl.a(true, true, true, true);
            }
         }

         for(int var39 = -3; var39 <= 4; ++var39) {
            for(int var40 = -3; var40 <= 4; ++var40) {
               var5.a(7, bms.l);
               float var41 = (float)(var39 * 8);
               float var42 = (float)(var40 * 8);
               float var43 = var41 - var33;
               float var44 = var42 - var34;
               if (var14 > -5.0F) {
                  var5.b((double)(var43 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + 8.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var24, var25, var26, 0.8F).c(0.0F, -1.0F, 0.0F).d();
                  var5.b((double)(var43 + 8.0F), (double)(var14 + 0.0F), (double)(var44 + 8.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var24, var25, var26, 0.8F).c(0.0F, -1.0F, 0.0F).d();
                  var5.b((double)(var43 + 8.0F), (double)(var14 + 0.0F), (double)(var44 + 0.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var24, var25, var26, 0.8F).c(0.0F, -1.0F, 0.0F).d();
                  var5.b((double)(var43 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + 0.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var24, var25, var26, 0.8F).c(0.0F, -1.0F, 0.0F).d();
               }

               if (var14 <= 5.0F) {
                  var5.b((double)(var43 + 0.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var44 + 8.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var18, var19, var20, 0.8F).c(0.0F, 1.0F, 0.0F).d();
                  var5.b((double)(var43 + 8.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var44 + 8.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var18, var19, var20, 0.8F).c(0.0F, 1.0F, 0.0F).d();
                  var5.b((double)(var43 + 8.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var44 + 0.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var18, var19, var20, 0.8F).c(0.0F, 1.0F, 0.0F).d();
                  var5.b((double)(var43 + 0.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var44 + 0.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var18, var19, var20, 0.8F).c(0.0F, 1.0F, 0.0F).d();
               }

               int var45;
               if (var39 > -1) {
                  for(var45 = 0; var45 < 8; ++var45) {
                     var5.b((double)(var43 + (float)var45 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + 8.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(-1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 0.0F), (double)(var14 + 4.0F), (double)(var44 + 8.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(-1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 0.0F), (double)(var14 + 4.0F), (double)(var44 + 0.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(-1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + 0.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(-1.0F, 0.0F, 0.0F).d();
                  }
               }

               if (var39 <= 1) {
                  for(var45 = 0; var45 < 8; ++var45) {
                     var5.b((double)(var43 + (float)var45 + 1.0F - 9.765625E-4F), (double)(var14 + 0.0F), (double)(var44 + 8.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 1.0F - 9.765625E-4F), (double)(var14 + 4.0F), (double)(var44 + 8.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 8.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 1.0F - 9.765625E-4F), (double)(var14 + 4.0F), (double)(var44 + 0.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(1.0F, 0.0F, 0.0F).d();
                     var5.b((double)(var43 + (float)var45 + 1.0F - 9.765625E-4F), (double)(var14 + 0.0F), (double)(var44 + 0.0F)).a((double)((var41 + (float)var45 + 0.5F) * 0.00390625F + var31), (double)((var42 + 0.0F) * 0.00390625F + var32)).a(var21, var22, var23, 0.8F).c(1.0F, 0.0F, 0.0F).d();
                  }
               }

               if (var40 > -1) {
                  for(var45 = 0; var45 < 8; ++var45) {
                     var5.b((double)(var43 + 0.0F), (double)(var14 + 4.0F), (double)(var44 + (float)var45 + 0.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, -1.0F).d();
                     var5.b((double)(var43 + 8.0F), (double)(var14 + 4.0F), (double)(var44 + (float)var45 + 0.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, -1.0F).d();
                     var5.b((double)(var43 + 8.0F), (double)(var14 + 0.0F), (double)(var44 + (float)var45 + 0.0F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, -1.0F).d();
                     var5.b((double)(var43 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + (float)var45 + 0.0F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, -1.0F).d();
                  }
               }

               if (var40 <= 1) {
                  for(var45 = 0; var45 < 8; ++var45) {
                     var5.b((double)(var43 + 0.0F), (double)(var14 + 4.0F), (double)(var44 + (float)var45 + 1.0F - 9.765625E-4F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, 1.0F).d();
                     var5.b((double)(var43 + 8.0F), (double)(var14 + 4.0F), (double)(var44 + (float)var45 + 1.0F - 9.765625E-4F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, 1.0F).d();
                     var5.b((double)(var43 + 8.0F), (double)(var14 + 0.0F), (double)(var44 + (float)var45 + 1.0F - 9.765625E-4F)).a((double)((var41 + 8.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, 1.0F).d();
                     var5.b((double)(var43 + 0.0F), (double)(var14 + 0.0F), (double)(var44 + (float)var45 + 1.0F - 9.765625E-4F)).a((double)((var41 + 0.0F) * 0.00390625F + var31), (double)((var42 + (float)var45 + 0.5F) * 0.00390625F + var32)).a(var27, var28, var29, 0.8F).c(0.0F, 0.0F, 1.0F).d();
                  }
               }

               var4.b();
            }
         }
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.k();
      bfl.o();
   }

   public void a(wn var1, String var2, double var3, double var5, double var7, float var9, float var10) {
   }

   public boolean a(double var1, double var3, double var5, float var7) {
      return false;
   }

   public void a(pk var1) {
   }

   public String f() {
      int var1 = this.o.f.length;
      int var2 = 0;
      Iterator var3 = this.m.iterator();

      while(var3.hasNext()) {
         bfr.a var4 = (bfr.a)var3.next();
         bhq var5 = var4.a.b;
         if (var5 != bhq.a && !var5.a()) {
            ++var2;
         }
      }

      return String.format("C: %d/%d %sD: %d, %s", var2, var1, this.h.G ? "(s) " : "", this.P, this.N.a());
   }

   private void t() {
      bfl.c();
      bfl.a(0.0F, 0.0F);
      bfl.r();
      bfl.d();
      bfl.a(true);
      bfl.F();
   }

   public void a(int var1, int var2) {
      if (bqs.O) {
         if (this.B != null) {
            this.B.a(var1, var2);
         }

      }
   }

   public void a(wn var1, auh var2, int var3, float var4) {
      if (var3 == 0 && var2.a == auh.a.b) {
         bfl.l();
         bfl.a(770, 771, 1, 0);
         bfl.c(0.0F, 0.0F, 0.0F, 0.4F);
         GL11.glLineWidth(2.0F);
         bfl.x();
         bfl.a(false);
         float var5 = 0.002F;
         cj var6 = var2.a();
         afh var7 = this.k.p(var6).c();
         if (var7.t() != arm.a && this.k.af().a(var6)) {
            var7.a((adq)this.k, (cj)var6);
            double var8 = var1.P + (var1.s - var1.P) * (double)var4;
            double var10 = var1.Q + (var1.t - var1.Q) * (double)var4;
            double var12 = var1.R + (var1.u - var1.R) * (double)var4;
            a(var7.b((adm)this.k, var6).b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).c(-var8, -var10, -var12));
         }

         bfl.a(true);
         bfl.w();
         bfl.k();
      }

   }

   public void a(float var1, int var2) {
      if (this.h.f.t.q() == 1) {
         this.r();
      } else if (this.h.f.t.d()) {
         bfl.x();
         aui var3 = this.k.a(this.h.ac(), var1);
         float var4 = (float)var3.a;
         float var5 = (float)var3.b;
         float var6 = (float)var3.c;
         if (var2 != 2) {
            float var7 = (var4 * 30.0F + var5 * 59.0F + var6 * 11.0F) / 100.0F;
            float var8 = (var4 * 30.0F + var5 * 70.0F) / 100.0F;
            float var9 = (var4 * 30.0F + var6 * 70.0F) / 100.0F;
            var4 = var7;
            var5 = var8;
            var6 = var9;
         }

         bfl.c(var4, var5, var6);
         bfx var20 = bfx.a();
         bfd var21 = var20.c();
         bfl.a(false);
         bfl.m();
         bfl.c(var4, var5, var6);
         if (this.Y) {
            this.u.a();
            GL11.glEnableClientState(32884);
            GL11.glVertexPointer(3, 5126, 12, 0L);
            this.u.a(7);
            this.u.b();
            GL11.glDisableClientState(32884);
         } else {
            bfl.o(this.q);
         }

         bfl.n();
         bfl.c();
         bfl.l();
         bfl.a(770, 771, 1, 0);
         avc.a();
         float[] var22 = this.k.t.a(this.k.c(var1), var1);
         float var10;
         float var11;
         float var12;
         float var13;
         float var14;
         float var15;
         float var16;
         float var17;
         int var27;
         if (var22 != null) {
            bfl.x();
            bfl.j(7425);
            bfl.E();
            bfl.b(90.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(ns.a(this.k.d(var1)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
            bfl.b(90.0F, 0.0F, 0.0F, 1.0F);
            var10 = var22[0];
            var11 = var22[1];
            var12 = var22[2];
            if (var2 != 2) {
               var13 = (var10 * 30.0F + var11 * 59.0F + var12 * 11.0F) / 100.0F;
               var14 = (var10 * 30.0F + var11 * 70.0F) / 100.0F;
               var15 = (var10 * 30.0F + var12 * 70.0F) / 100.0F;
               var10 = var13;
               var11 = var14;
               var12 = var15;
            }

            var21.a(6, bms.f);
            var21.b(0.0D, 100.0D, 0.0D).a(var10, var11, var12, var22[3]).d();
            boolean var25 = true;

            for(var27 = 0; var27 <= 16; ++var27) {
               var15 = (float)var27 * 3.1415927F * 2.0F / 16.0F;
               var16 = ns.a(var15);
               var17 = ns.b(var15);
               var21.b((double)(var16 * 120.0F), (double)(var17 * 120.0F), (double)(-var17 * 40.0F * var22[3])).a(var22[0], var22[1], var22[2], 0.0F).d();
            }

            var20.b();
            bfl.F();
            bfl.j(7424);
         }

         bfl.w();
         bfl.a(770, 1, 1, 0);
         bfl.E();
         var10 = 1.0F - this.k.j(var1);
         bfl.c(1.0F, 1.0F, 1.0F, var10);
         bfl.b(-90.0F, 0.0F, 1.0F, 0.0F);
         bfl.b(this.k.c(var1) * 360.0F, 1.0F, 0.0F, 0.0F);
         var11 = 30.0F;
         this.i.a(d);
         var21.a(7, bms.g);
         var21.b((double)(-var11), 100.0D, (double)(-var11)).a(0.0D, 0.0D).d();
         var21.b((double)var11, 100.0D, (double)(-var11)).a(1.0D, 0.0D).d();
         var21.b((double)var11, 100.0D, (double)var11).a(1.0D, 1.0D).d();
         var21.b((double)(-var11), 100.0D, (double)var11).a(0.0D, 1.0D).d();
         var20.b();
         var11 = 20.0F;
         this.i.a(c);
         int var24 = this.k.x();
         int var26 = var24 % 4;
         var27 = var24 / 4 % 2;
         var15 = (float)var26 / 4.0F;
         var16 = (float)var27 / 2.0F;
         var17 = (float)(var26 + 1) / 4.0F;
         float var18 = (float)(var27 + 1) / 2.0F;
         var21.a(7, bms.g);
         var21.b((double)(-var11), -100.0D, (double)var11).a((double)var17, (double)var18).d();
         var21.b((double)var11, -100.0D, (double)var11).a((double)var15, (double)var18).d();
         var21.b((double)var11, -100.0D, (double)(-var11)).a((double)var15, (double)var16).d();
         var21.b((double)(-var11), -100.0D, (double)(-var11)).a((double)var17, (double)var16).d();
         var20.b();
         bfl.x();
         float var19 = this.k.g(var1) * var10;
         if (var19 > 0.0F) {
            bfl.c(var19, var19, var19, var19);
            if (this.Y) {
               this.t.a();
               GL11.glEnableClientState(32884);
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.t.a(7);
               this.t.b();
               GL11.glDisableClientState(32884);
            } else {
               bfl.o(this.p);
            }
         }

         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.k();
         bfl.d();
         bfl.m();
         bfl.F();
         bfl.x();
         bfl.c(0.0F, 0.0F, 0.0F);
         double var23 = this.h.h.e(var1).b - this.k.X();
         if (var23 < 0.0D) {
            bfl.E();
            bfl.b(0.0F, 12.0F, 0.0F);
            if (this.Y) {
               this.v.a();
               GL11.glEnableClientState(32884);
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.v.a(7);
               this.v.b();
               GL11.glDisableClientState(32884);
            } else {
               bfl.o(this.r);
            }

            bfl.F();
            var12 = 1.0F;
            var13 = -((float)(var23 + 65.0D));
            var14 = -1.0F;
            var21.a(7, bms.f);
            var21.b(-1.0D, (double)var13, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, (double)var13, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, (double)var13, -1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, (double)var13, -1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, (double)var13, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, (double)var13, -1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, (double)var13, -1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, (double)var13, 1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var21.b(-1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, 1.0D).b(0, 0, 0, 255).d();
            var21.b(1.0D, -1.0D, -1.0D).b(0, 0, 0, 255).d();
            var20.b();
         }

         if (this.k.t.g()) {
            bfl.c(var4 * 0.2F + 0.04F, var5 * 0.2F + 0.04F, var6 * 0.6F + 0.1F);
         } else {
            bfl.c(var4, var5, var6);
         }

         bfl.E();
         bfl.b(0.0F, -((float)(var23 - 16.0D)), 0.0F);
         bfl.o(this.r);
         bfl.F();
         bfl.w();
         bfl.a(true);
      }
   }

   public void b(cj var1) {
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      this.b(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   private void a(cy var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
   }

   public void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      try {
         this.b(var1, var2, var3, var5, var7, var9, var11, var13, var15);
      } catch (Throwable var19) {
         b var17 = b.a(var19, "Exception while adding particle");
         c var18 = var17.a("Particle being added");
         var18.a((String)"ID", (Object)var1);
         if (var15 != null) {
            var18.a((String)"Parameters", (Object)var15);
         }

         var18.a("Position", new Callable<String>(this, var3, var5, var7) {
            final double a;
            final double b;
            final double c;
            final bfr d;

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.d = var1;
               this.a = var2;
               this.b = var4;
               this.c = var6;
            }

            public String a() throws Exception {
               return c.a(this.a, this.b, this.c);
            }
         });
         throw new e(var17);
      }
   }

   class a {
      final bht a;
      final cq b;
      final Set<cq> c;
      final bfr e;
      final int d;

      a(bfr var1, bht var2, cq var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      private a(bfr var1, bht var2, cq var3, int var4) {
         this.e = var1;
         this.c = EnumSet.noneOf(cq.class);
         this.a = var2;
         this.b = var3;
         this.d = var4;
      }
   }
}
