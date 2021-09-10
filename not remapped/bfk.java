import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class bfk implements bnj {
   private boolean B;
   private float u;
   private float w;
   private float[] O = new float[1024];
   private long E = ave.J();
   private Random j = new Random();
   private float K;
   private ave h;
   private float t;
   private FloatBuffer P = avd.h(16);
   private final jy I;
   private static final jy g = new jy("textures/environment/snow.png");
   private nv p = new nv();
   private double X = 1.0D;
   private boolean D = true;
   private float q = 4.0F;
   private float T;
   private blr aa;
   private float y;
   public static final int d;
   private float v;
   private static final jy[] ab = new jy[]{new jy("shaders/post/notch.json"), new jy("shaders/post/fxaa.json"), new jy("shaders/post/art.json"), new jy("shaders/post/bumpy.json"), new jy("shaders/post/blobs2.json"), new jy("shaders/post/pencil.json"), new jy("shaders/post/color_convolve.json"), new jy("shaders/post/deconverge.json"), new jy("shaders/post/flip.json"), new jy("shaders/post/invert.json"), new jy("shaders/post/ntsc.json"), new jy("shaders/post/outline.json"), new jy("shaders/post/phosphor.json"), new jy("shaders/post/scan_pincushion.json"), new jy("shaders/post/sobel.json"), new jy("shaders/post/bits.json"), new jy("shaders/post/desaturate.json"), new jy("shaders/post/green.json"), new jy("shaders/post/blur.json"), new jy("shaders/post/wobble.json"), new jy("shaders/post/blobs.json"), new jy("shaders/post/antialias.json"), new jy("shaders/post/creeper.json"), new jy("shaders/post/spider.json")};
   private float Q;
   private float x;
   private boolean ad;
   private static final Logger e = LogManager.getLogger();
   private int m;
   private float[] N = new float[1024];
   private final int[] H;
   private float r = 4.0F;
   private int M;
   private int ac;
   private nv o = new nv();
   private float S;
   private float z;
   private double Z;
   private float A;
   private pk n;
   private boolean J;
   private float k;
   private int ae;
   public final bfn c;
   private float U;
   private boolean C = true;
   private long F;
   private int V = 0;
   private static final jy f = new jy("textures/environment/rain.png");
   private final blz G;
   private float s;
   private final bni i;
   private boolean W = false;
   public static int b;
   private final avq l;
   private float L;
   public static boolean a;
   private float R;
   private double Y;

   public void h() {
      bfl.g(bqs.r);
      bfl.x();
      bfl.g(bqs.q);
   }

   public void a(bni var1) {
      if (this.aa != null) {
         this.aa.a();
      }

      this.aa = null;
      if (this.ac != d) {
         this.a(ab[this.ac]);
      } else {
         this.a(this.h.ac());
      }

   }

   private void a(int var1, float var2) {
      pk var3 = this.h.ac();
      boolean var4 = false;
      if (var3 instanceof wn) {
         var4 = ((wn)var3).bA.d;
      }

      GL11.glFog(2918, this.a(this.Q, this.R, this.S, 1.0F));
      GL11.glNormal3f(0.0F, -1.0F, 0.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      afh var5 = auz.a(this.h.f, var3, var2);
      float var6;
      if (var3 instanceof pr && ((pr)var3).a(pe.q)) {
         var6 = 5.0F;
         int var7 = ((pr)var3).b(pe.q).b();
         if (var7 < 20) {
            var6 = 5.0F + (this.k - 5.0F) * (1.0F - (float)var7 / 20.0F);
         }

         bfl.d(9729);
         if (var1 == -1) {
            bfl.b(0.0F);
            bfl.c(var6 * 0.8F);
         } else {
            bfl.b(var6 * 0.25F);
            bfl.c(var6);
         }

         if (GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi(34138, 34139);
         }
      } else if (this.B) {
         bfl.d(2048);
         bfl.a(0.1F);
      } else if (var5.t() == arm.h) {
         bfl.d(2048);
         if (var3 instanceof pr && ((pr)var3).a(pe.o)) {
            bfl.a(0.01F);
         } else {
            bfl.a(0.1F - (float)ack.a(var3) * 0.03F);
         }
      } else if (var5.t() == arm.i) {
         bfl.d(2048);
         bfl.a(2.0F);
      } else {
         var6 = this.k;
         bfl.d(9729);
         if (var1 == -1) {
            bfl.b(0.0F);
            bfl.c(var6);
         } else {
            bfl.b(var6 * 0.75F);
            bfl.c(var6);
         }

         if (GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi(34138, 34139);
         }

         if (this.h.f.t.b((int)var3.s, (int)var3.u)) {
            bfl.b(var6 * 0.05F);
            bfl.c(Math.min(var6, 192.0F) * 0.5F);
         }
      }

      bfl.g();
      bfl.m();
      bfl.a(1028, 4608);
   }

   public void a(int var1, int var2) {
      if (bqs.O) {
         if (this.aa != null) {
            this.aa.a(var1, var2);
         }

         this.h.g.a(var1, var2);
      }
   }

   private float a(float var1, boolean var2) {
      if (this.W) {
         return 90.0F;
      } else {
         pk var3 = this.h.ac();
         float var4 = 70.0F;
         if (var2) {
            var4 = this.h.t.aI;
            var4 *= this.y + (this.x - this.y) * var1;
         }

         if (var3 instanceof pr && ((pr)var3).bn() <= 0.0F) {
            float var5 = (float)((pr)var3).ax + var1;
            var4 /= (1.0F - 500.0F / (var5 + 500.0F)) * 2.0F + 1.0F;
         }

         afh var6 = auz.a(this.h.f, var3, var1);
         if (var6.t() == arm.h) {
            var4 = var4 * 60.0F / 70.0F;
         }

         return var4;
      }
   }

   private void m() {
      this.L = (float)((double)this.L + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.L = (float)((double)this.L * 0.9D);
      this.K += (this.L - this.K) * 1.0F;
      this.J = true;
   }

   private void a(jy var1) {
      try {
         this.aa = new blr(this.h.P(), this.i, this.h.b(), var1);
         this.aa.a(this.h.d, this.h.e);
         this.ad = true;
      } catch (IOException var3) {
         e.warn("Failed to load shader: " + var1, var3);
         this.ac = d;
         this.ad = false;
      } catch (JsonSyntaxException var4) {
         e.warn("Failed to load shader: " + var1, var4);
         this.ac = d;
         this.ad = false;
      }

   }

   public void j() {
      avr var1 = new avr(this.h);
      bfl.m(256);
      bfl.n(5889);
      bfl.D();
      bfl.a(0.0D, var1.c(), var1.d(), 0.0D, 1000.0D, 3000.0D);
      bfl.n(5888);
      bfl.D();
      bfl.b(0.0F, 0.0F, -2000.0F);
   }

   private void l() {
      float var1 = 1.0F;
      if (this.h.ac() instanceof bet) {
         bet var2 = (bet)this.h.ac();
         var1 = var2.o();
      }

      this.y = this.x;
      this.x += (var1 - this.x) * 0.5F;
      if (this.x > 1.5F) {
         this.x = 1.5F;
      }

      if (this.x < 0.1F) {
         this.x = 0.1F;
      }

   }

   private void b(float var1, int var2) {
      if (!this.W) {
         bfl.n(5889);
         bfl.D();
         float var3 = 0.07F;
         if (this.h.t.e) {
            bfl.b((float)(-(var2 * 2 - 1)) * var3, 0.0F, 0.0F);
         }

         Project.gluPerspective(this.a(var1, false), (float)this.h.d / (float)this.h.e, 0.05F, this.k * 2.0F);
         bfl.n(5888);
         bfl.D();
         if (this.h.t.e) {
            bfl.b((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
         }

         bfl.E();
         this.d(var1);
         if (this.h.t.d) {
            this.e(var1);
         }

         boolean var4 = this.h.ac() instanceof pr && ((pr)this.h.ac()).bJ();
         if (this.h.t.aB == 0 && !var4 && !this.h.t.aA && !this.h.c.a()) {
            this.i();
            this.c.a(var1);
            this.h();
         }

         bfl.F();
         if (this.h.t.aB == 0 && !var4) {
            this.c.b(var1);
            this.d(var1);
         }

         if (this.h.t.d) {
            this.e(var1);
         }

      }
   }

   private FloatBuffer a(float var1, float var2, float var3, float var4) {
      this.P.clear();
      this.P.put(var1).put(var2).put(var3).put(var4);
      this.P.flip();
      return this.P;
   }

   private void a(float var1, int var2) {
      this.k = (float)(this.h.t.c * 16);
      bfl.n(5889);
      bfl.D();
      float var3 = 0.07F;
      if (this.h.t.e) {
         bfl.b((float)(-(var2 * 2 - 1)) * var3, 0.0F, 0.0F);
      }

      if (this.X != 1.0D) {
         bfl.b((float)this.Y, (float)(-this.Z), 0.0F);
         bfl.a(this.X, this.X, 1.0D);
      }

      Project.gluPerspective(this.a(var1, true), (float)this.h.d / (float)this.h.e, 0.05F, this.k * ns.a);
      bfl.n(5888);
      bfl.D();
      if (this.h.t.e) {
         bfl.b((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
      }

      this.d(var1);
      if (this.h.t.d) {
         this.e(var1);
      }

      float var4 = this.h.h.bI + (this.h.h.bH - this.h.h.bI) * var1;
      if (var4 > 0.0F) {
         byte var5 = 20;
         if (this.h.h.a((pe)pe.k)) {
            var5 = 7;
         }

         float var6 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F;
         var6 *= var6;
         bfl.b(((float)this.m + var1) * (float)var5, 0.0F, 1.0F, 1.0F);
         bfl.a(1.0F / var6, 1.0F, 1.0F);
         bfl.b(-((float)this.m + var1) * (float)var5, 0.0F, 1.0F, 1.0F);
      }

      this.f(var1);
      if (this.W) {
         switch(this.V) {
         case 0:
            bfl.b(90.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 1:
            bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 2:
            bfl.b(-90.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 3:
            bfl.b(90.0F, 1.0F, 0.0F, 0.0F);
            break;
         case 4:
            bfl.b(-90.0F, 1.0F, 0.0F, 0.0F);
         }
      }

   }

   public void a(float var1) {
      pk var2 = this.h.ac();
      if (var2 != null) {
         if (this.h.f != null) {
            this.h.A.a("pick");
            this.h.i = null;
            double var3 = (double)this.h.c.d();
            this.h.s = var2.a(var3, var1);
            double var5 = var3;
            aui var7 = var2.e(var1);
            boolean var8 = false;
            boolean var9 = true;
            if (this.h.c.i()) {
               var3 = 6.0D;
               var5 = 6.0D;
            } else {
               if (var3 > 3.0D) {
                  var8 = true;
               }

               var3 = var3;
            }

            if (this.h.s != null) {
               var5 = this.h.s.c.f(var7);
            }

            aui var10 = var2.d(var1);
            aui var11 = var7.b(var10.a * var3, var10.b * var3, var10.c * var3);
            this.n = null;
            aui var12 = null;
            float var13 = 1.0F;
            List var14 = this.h.f.a(var2, var2.aR().a(var10.a * var3, var10.b * var3, var10.c * var3).b((double)var13, (double)var13, (double)var13), Predicates.and(po.d, new Predicate<pk>(this) {
               final bfk a;

               public boolean apply(Object var1) {
                  return this.a((pk)var1);
               }

               public boolean a(pk var1) {
                  return var1.ad();
               }

               {
                  this.a = var1;
               }
            }));
            double var15 = var5;

            for(int var17 = 0; var17 < var14.size(); ++var17) {
               pk var18 = (pk)var14.get(var17);
               float var19 = var18.ao();
               aug var20 = var18.aR().b((double)var19, (double)var19, (double)var19);
               auh var21 = var20.a(var7, var11);
               if (var20.a(var7)) {
                  if (var15 >= 0.0D) {
                     this.n = var18;
                     var12 = var21 == null ? var7 : var21.c;
                     var15 = 0.0D;
                  }
               } else if (var21 != null) {
                  double var22 = var7.f(var21.c);
                  if (var22 < var15 || var15 == 0.0D) {
                     if (var18 == var2.m) {
                        if (var15 == 0.0D) {
                           this.n = var18;
                           var12 = var21.c;
                        }
                     } else {
                        this.n = var18;
                        var12 = var21.c;
                        var15 = var22;
                     }
                  }
               }
            }

            if (this.n != null && var8 && var7.f(var12) > 3.0D) {
               this.n = null;
               this.h.s = new auh(auh.a.a, var12, (cq)null, new cj(var12));
            }

            if (this.n != null && (var15 < var5 || this.h.s == null)) {
               this.h.s = new auh(this.n, var12);
               if (this.n instanceof pr || this.n instanceof uo) {
                  this.h.i = this.n;
               }
            }

            this.h.A.b();
         }
      }
   }

   public void b() {
      if (this.aa != null) {
         this.aa.a();
      }

      this.aa = null;
      this.ac = d;
   }

   public void e() {
      if (bqs.O && blu.b() == null) {
         blu.a();
      }

      this.l();
      this.m();
      this.T = this.U;
      this.r = this.q;
      float var1;
      float var2;
      if (this.h.t.aG) {
         var1 = this.h.t.a * 0.6F + 0.2F;
         var2 = var1 * var1 * var1 * 8.0F;
         this.u = this.o.a(this.s, 0.05F * var2);
         this.v = this.p.a(this.t, 0.05F * var2);
         this.w = 0.0F;
         this.s = 0.0F;
         this.t = 0.0F;
      } else {
         this.u = 0.0F;
         this.v = 0.0F;
         this.o.a();
         this.p.a();
      }

      if (this.h.ac() == null) {
         this.h.a((pk)this.h.h);
      }

      var1 = this.h.f.o(new cj(this.h.ac()));
      var2 = (float)this.h.t.c / 32.0F;
      float var3 = var1 * (1.0F - var2) + var2;
      this.U += (var3 - this.U) * 0.1F;
      ++this.m;
      this.c.a();
      this.o();
      this.A = this.z;
      if (bfc.d) {
         this.z += 0.05F;
         if (this.z > 1.0F) {
            this.z = 1.0F;
         }

         bfc.d = false;
      } else if (this.z > 0.0F) {
         this.z -= 0.0125F;
      }

   }

   protected void c(float var1) {
      float var2 = this.h.f.j(var1);
      if (!(var2 <= 0.0F)) {
         this.i();
         pk var3 = this.h.ac();
         bdb var4 = this.h.f;
         int var5 = ns.c(var3.s);
         int var6 = ns.c(var3.t);
         int var7 = ns.c(var3.u);
         bfx var8 = bfx.a();
         bfd var9 = var8.c();
         bfl.p();
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         bfl.l();
         bfl.a(770, 771, 1, 0);
         bfl.a(516, 0.1F);
         double var10 = var3.P + (var3.s - var3.P) * (double)var1;
         double var12 = var3.Q + (var3.t - var3.Q) * (double)var1;
         double var14 = var3.R + (var3.u - var3.R) * (double)var1;
         int var16 = ns.c(var12);
         byte var17 = 5;
         if (this.h.t.i) {
            var17 = 10;
         }

         byte var18 = -1;
         float var19 = (float)this.m + var1;
         var9.c(-var10, -var12, -var14);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         cj.a var20 = new cj.a();

         for(int var21 = var7 - var17; var21 <= var7 + var17; ++var21) {
            for(int var22 = var5 - var17; var22 <= var5 + var17; ++var22) {
               int var23 = (var21 - var7 + 16) * 32 + var22 - var5 + 16;
               double var24 = (double)this.N[var23] * 0.5D;
               double var26 = (double)this.O[var23] * 0.5D;
               var20.c(var22, 0, var21);
               ady var28 = var4.b((cj)var20);
               if (var28.e() || var28.d()) {
                  int var29 = var4.q(var20).o();
                  int var30 = var6 - var17;
                  int var31 = var6 + var17;
                  if (var30 < var29) {
                     var30 = var29;
                  }

                  if (var31 < var29) {
                     var31 = var29;
                  }

                  int var32 = var29;
                  if (var29 < var16) {
                     var32 = var16;
                  }

                  if (var30 != var31) {
                     this.j.setSeed((long)(var22 * var22 * 3121 + var22 * 45238971 ^ var21 * var21 * 418711 + var21 * 13761));
                     var20.c(var22, var30, var21);
                     float var33 = var28.a((cj)var20);
                     double var34;
                     double var36;
                     double var38;
                     if (var4.v().a(var33, var29) >= 0.15F) {
                        if (var18 != 0) {
                           if (var18 >= 0) {
                              var8.b();
                           }

                           var18 = 0;
                           this.h.P().a(f);
                           var9.a(7, bms.d);
                        }

                        var34 = ((double)(this.m + var22 * var22 * 3121 + var22 * 45238971 + var21 * var21 * 418711 + var21 * 13761 & 31) + (double)var1) / 32.0D * (3.0D + this.j.nextDouble());
                        var36 = (double)((float)var22 + 0.5F) - var3.s;
                        var38 = (double)((float)var21 + 0.5F) - var3.u;
                        float var40 = ns.a(var36 * var36 + var38 * var38) / (float)var17;
                        float var41 = ((1.0F - var40 * var40) * 0.5F + 0.5F) * var2;
                        var20.c(var22, var32, var21);
                        int var42 = var4.b(var20, 0);
                        int var43 = var42 >> 16 & '\uffff';
                        int var44 = var42 & '\uffff';
                        var9.b((double)var22 - var24 + 0.5D, (double)var30, (double)var21 - var26 + 0.5D).a(0.0D, (double)var30 * 0.25D + var34).a(1.0F, 1.0F, 1.0F, var41).a(var43, var44).d();
                        var9.b((double)var22 + var24 + 0.5D, (double)var30, (double)var21 + var26 + 0.5D).a(1.0D, (double)var30 * 0.25D + var34).a(1.0F, 1.0F, 1.0F, var41).a(var43, var44).d();
                        var9.b((double)var22 + var24 + 0.5D, (double)var31, (double)var21 + var26 + 0.5D).a(1.0D, (double)var31 * 0.25D + var34).a(1.0F, 1.0F, 1.0F, var41).a(var43, var44).d();
                        var9.b((double)var22 - var24 + 0.5D, (double)var31, (double)var21 - var26 + 0.5D).a(0.0D, (double)var31 * 0.25D + var34).a(1.0F, 1.0F, 1.0F, var41).a(var43, var44).d();
                     } else {
                        if (var18 != 1) {
                           if (var18 >= 0) {
                              var8.b();
                           }

                           var18 = 1;
                           this.h.P().a(g);
                           var9.a(7, bms.d);
                        }

                        var34 = (double)(((float)(this.m & 511) + var1) / 512.0F);
                        var36 = this.j.nextDouble() + (double)var19 * 0.01D * (double)((float)this.j.nextGaussian());
                        var38 = this.j.nextDouble() + (double)(var19 * (float)this.j.nextGaussian()) * 0.001D;
                        double var49 = (double)((float)var22 + 0.5F) - var3.s;
                        double var50 = (double)((float)var21 + 0.5F) - var3.u;
                        float var51 = ns.a(var49 * var49 + var50 * var50) / (float)var17;
                        float var45 = ((1.0F - var51 * var51) * 0.3F + 0.5F) * var2;
                        var20.c(var22, var32, var21);
                        int var46 = (var4.b(var20, 0) * 3 + 15728880) / 4;
                        int var47 = var46 >> 16 & '\uffff';
                        int var48 = var46 & '\uffff';
                        var9.b((double)var22 - var24 + 0.5D, (double)var30, (double)var21 - var26 + 0.5D).a(0.0D + var36, (double)var30 * 0.25D + var34 + var38).a(1.0F, 1.0F, 1.0F, var45).a(var47, var48).d();
                        var9.b((double)var22 + var24 + 0.5D, (double)var30, (double)var21 + var26 + 0.5D).a(1.0D + var36, (double)var30 * 0.25D + var34 + var38).a(1.0F, 1.0F, 1.0F, var45).a(var47, var48).d();
                        var9.b((double)var22 + var24 + 0.5D, (double)var31, (double)var21 + var26 + 0.5D).a(1.0D + var36, (double)var31 * 0.25D + var34 + var38).a(1.0F, 1.0F, 1.0F, var45).a(var47, var48).d();
                        var9.b((double)var22 - var24 + 0.5D, (double)var31, (double)var21 - var26 + 0.5D).a(0.0D + var36, (double)var31 * 0.25D + var34 + var38).a(1.0F, 1.0F, 1.0F, var45).a(var47, var48).d();
                     }
                  }
               }
            }
         }

         if (var18 >= 0) {
            var8.b();
         }

         var9.c(0.0D, 0.0D, 0.0D);
         bfl.o();
         bfl.k();
         bfl.a(516, 0.1F);
         this.h();
      }
   }

   private void f(float var1) {
      pk var2 = this.h.ac();
      float var3 = var2.aS();
      double var4 = var2.p + (var2.s - var2.p) * (double)var1;
      double var6 = var2.q + (var2.t - var2.q) * (double)var1 + (double)var3;
      double var8 = var2.r + (var2.u - var2.r) * (double)var1;
      if (var2 instanceof pr && ((pr)var2).bJ()) {
         var3 = (float)((double)var3 + 1.0D);
         bfl.b(0.0F, 0.3F, 0.0F);
         if (!this.h.t.aH) {
            cj var27 = new cj(var2);
            alz var11 = this.h.f.p(var27);
            afh var29 = var11.c();
            if (var29 == afi.C) {
               int var30 = ((cq)var11.b(afg.O)).b();
               bfl.b((float)(var30 * 90), 0.0F, 1.0F, 0.0F);
            }

            bfl.b(var2.A + (var2.y - var2.A) * var1 + 180.0F, 0.0F, -1.0F, 0.0F);
            bfl.b(var2.B + (var2.z - var2.B) * var1, -1.0F, 0.0F, 0.0F);
         }
      } else if (this.h.t.aB > 0) {
         double var10 = (double)(this.r + (this.q - this.r) * var1);
         if (this.h.t.aH) {
            bfl.b(0.0F, 0.0F, (float)(-var10));
         } else {
            float var12 = var2.y;
            float var13 = var2.z;
            if (this.h.t.aB == 2) {
               var13 += 180.0F;
            }

            double var14 = (double)(-ns.a(var12 / 180.0F * 3.1415927F) * ns.b(var13 / 180.0F * 3.1415927F)) * var10;
            double var16 = (double)(ns.b(var12 / 180.0F * 3.1415927F) * ns.b(var13 / 180.0F * 3.1415927F)) * var10;
            double var18 = (double)(-ns.a(var13 / 180.0F * 3.1415927F)) * var10;

            for(int var20 = 0; var20 < 8; ++var20) {
               float var21 = (float)((var20 & 1) * 2 - 1);
               float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
               float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
               var21 *= 0.1F;
               var22 *= 0.1F;
               var23 *= 0.1F;
               auh var24 = this.h.f.a(new aui(var4 + (double)var21, var6 + (double)var22, var8 + (double)var23), new aui(var4 - var14 + (double)var21 + (double)var23, var6 - var18 + (double)var22, var8 - var16 + (double)var23));
               if (var24 != null) {
                  double var25 = var24.c.f(new aui(var4, var6, var8));
                  if (var25 < var10) {
                     var10 = var25;
                  }
               }
            }

            if (this.h.t.aB == 2) {
               bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            bfl.b(var2.z - var13, 1.0F, 0.0F, 0.0F);
            bfl.b(var2.y - var12, 0.0F, 1.0F, 0.0F);
            bfl.b(0.0F, 0.0F, (float)(-var10));
            bfl.b(var12 - var2.y, 0.0F, 1.0F, 0.0F);
            bfl.b(var13 - var2.z, 1.0F, 0.0F, 0.0F);
         }
      } else {
         bfl.b(0.0F, 0.0F, -0.1F);
      }

      if (!this.h.t.aH) {
         bfl.b(var2.B + (var2.z - var2.B) * var1, 1.0F, 0.0F, 0.0F);
         if (var2 instanceof tm) {
            tm var28 = (tm)var2;
            bfl.b(var28.aL + (var28.aK - var28.aL) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            bfl.b(var2.A + (var2.y - var2.A) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
         }
      }

      bfl.b(0.0F, -var3, 0.0F);
      var4 = var2.p + (var2.s - var2.p) * (double)var1;
      var6 = var2.q + (var2.t - var2.q) * (double)var1 + (double)var3;
      var8 = var2.r + (var2.u - var2.r) * (double)var1;
      this.B = this.h.g.a(var4, var6, var8, var1);
   }

   public bfk(ave var1, bni var2) {
      this.ac = d;
      this.ad = false;
      this.ae = 0;
      this.h = var1;
      this.i = var2;
      this.c = var1.ah();
      this.l = new avq(var1.P());
      this.G = new blz(16, 16);
      this.I = var1.P().a("lightMap", this.G);
      this.H = this.G.e();
      this.aa = null;

      for(int var3 = 0; var3 < 32; ++var3) {
         for(int var4 = 0; var4 < 32; ++var4) {
            float var5 = (float)(var4 - 16);
            float var6 = (float)(var3 - 16);
            float var7 = ns.c(var5 * var5 + var6 * var6);
            this.N[var3 << 5 | var4] = -var6 / var7;
            this.O[var3 << 5 | var4] = var5 / var7;
         }
      }

   }

   private void a(bfr var1, float var2, int var3) {
      if (this.h.t.e() != 0) {
         this.h.A.c("clouds");
         bfl.n(5889);
         bfl.D();
         Project.gluPerspective(this.a(var2, true), (float)this.h.d / (float)this.h.e, 0.05F, this.k * 4.0F);
         bfl.n(5888);
         bfl.E();
         this.a(0, var2);
         var1.b(var2, var3);
         bfl.n();
         bfl.F();
         bfl.n(5889);
         bfl.D();
         Project.gluPerspective(this.a(var2, true), (float)this.h.d / (float)this.h.e, 0.05F, this.k * ns.a);
         bfl.n(5888);
      }

   }

   public avq k() {
      return this.l;
   }

   static {
      d = ab.length;
   }

   public boolean a() {
      return bqs.O && this.aa != null;
   }

   private void h(float var1) {
      if (this.h.t.aC && !this.h.t.aA && !this.h.h.cq() && !this.h.t.w) {
         pk var2 = this.h.ac();
         bfl.l();
         bfl.a(770, 771, 1, 0);
         GL11.glLineWidth(1.0F);
         bfl.x();
         bfl.a(false);
         bfl.E();
         bfl.n(5888);
         bfl.D();
         this.f(var1);
         bfl.b(0.0F, var2.aS(), 0.0F);
         bfr.a(new aug(0.0D, 0.0D, 0.0D, 0.005D, 1.0E-4D, 1.0E-4D), 255, 0, 0, 255);
         bfr.a(new aug(0.0D, 0.0D, 0.0D, 1.0E-4D, 1.0E-4D, 0.005D), 0, 0, 255, 255);
         bfr.a(new aug(0.0D, 0.0D, 0.0D, 1.0E-4D, 0.0033D, 1.0E-4D), 0, 255, 0, 255);
         bfl.F();
         bfl.a(true);
         bfl.w();
         bfl.k();
      }

   }

   private void e(float var1) {
      if (this.h.ac() instanceof wn) {
         wn var2 = (wn)this.h.ac();
         float var3 = var2.M - var2.L;
         float var4 = -(var2.M + var3 * var1);
         float var5 = var2.bn + (var2.bo - var2.bn) * var1;
         float var6 = var2.aE + (var2.aF - var2.aE) * var1;
         bfl.b(ns.a(var4 * 3.1415927F) * var5 * 0.5F, -Math.abs(ns.b(var4 * 3.1415927F) * var5), 0.0F);
         bfl.b(ns.a(var4 * 3.1415927F) * var5 * 3.0F, 0.0F, 0.0F, 1.0F);
         bfl.b(Math.abs(ns.b(var4 * 3.1415927F - 0.2F) * var5) * 5.0F, 1.0F, 0.0F, 0.0F);
         bfl.b(var6, 1.0F, 0.0F, 0.0F);
      }
   }

   public blr f() {
      return this.aa;
   }

   private boolean n() {
      if (!this.D) {
         return false;
      } else {
         pk var1 = this.h.ac();
         boolean var2 = var1 instanceof wn && !this.h.t.aA;
         if (var2 && !((wn)var1).bA.e) {
            zx var3 = ((wn)var1).bZ();
            if (this.h.s != null && this.h.s.a == auh.a.b) {
               cj var4 = this.h.s.a();
               afh var5 = this.h.f.p(var4).c();
               if (this.h.c.l() == adp.a.e) {
                  var2 = var5.z() && this.h.f.s(var4) instanceof og;
               } else {
                  var2 = var3 != null && (var3.c(var5) || var3.d(var5));
               }
            }
         }

         return var2;
      }
   }

   static ave a(bfk var0) {
      return var0.h;
   }

   private void g(float var1) {
      if (this.J) {
         this.h.A.a("lightTex");
         bdb var2 = this.h.f;
         if (var2 != null) {
            float var3 = var2.b(1.0F);
            float var4 = var3 * 0.95F + 0.05F;

            for(int var5 = 0; var5 < 256; ++var5) {
               float var6 = var2.t.p()[var5 / 16] * var4;
               float var7 = var2.t.p()[var5 % 16] * (this.K * 0.1F + 1.5F);
               if (var2.ac() > 0) {
                  var6 = var2.t.p()[var5 / 16];
               }

               float var8 = var6 * (var3 * 0.65F + 0.35F);
               float var9 = var6 * (var3 * 0.65F + 0.35F);
               float var12 = var7 * ((var7 * 0.6F + 0.4F) * 0.6F + 0.4F);
               float var13 = var7 * (var7 * var7 * 0.6F + 0.4F);
               float var14 = var8 + var7;
               float var15 = var9 + var12;
               float var16 = var6 + var13;
               var14 = var14 * 0.96F + 0.03F;
               var15 = var15 * 0.96F + 0.03F;
               var16 = var16 * 0.96F + 0.03F;
               float var17;
               if (this.z > 0.0F) {
                  var17 = this.A + (this.z - this.A) * var1;
                  var14 = var14 * (1.0F - var17) + var14 * 0.7F * var17;
                  var15 = var15 * (1.0F - var17) + var15 * 0.6F * var17;
                  var16 = var16 * (1.0F - var17) + var16 * 0.6F * var17;
               }

               if (var2.t.q() == 1) {
                  var14 = 0.22F + var7 * 0.75F;
                  var15 = 0.28F + var12 * 0.75F;
                  var16 = 0.25F + var13 * 0.75F;
               }

               float var18;
               if (this.h.h.a((pe)pe.r)) {
                  var17 = this.a(this.h.h, var1);
                  var18 = 1.0F / var14;
                  if (var18 > 1.0F / var15) {
                     var18 = 1.0F / var15;
                  }

                  if (var18 > 1.0F / var16) {
                     var18 = 1.0F / var16;
                  }

                  var14 = var14 * (1.0F - var17) + var14 * var18 * var17;
                  var15 = var15 * (1.0F - var17) + var15 * var18 * var17;
                  var16 = var16 * (1.0F - var17) + var16 * var18 * var17;
               }

               if (var14 > 1.0F) {
                  var14 = 1.0F;
               }

               if (var15 > 1.0F) {
                  var15 = 1.0F;
               }

               if (var16 > 1.0F) {
                  var16 = 1.0F;
               }

               var17 = this.h.t.aJ;
               var18 = 1.0F - var14;
               float var19 = 1.0F - var15;
               float var20 = 1.0F - var16;
               var18 = 1.0F - var18 * var18 * var18 * var18;
               var19 = 1.0F - var19 * var19 * var19 * var19;
               var20 = 1.0F - var20 * var20 * var20 * var20;
               var14 = var14 * (1.0F - var17) + var18 * var17;
               var15 = var15 * (1.0F - var17) + var19 * var17;
               var16 = var16 * (1.0F - var17) + var20 * var17;
               var14 = var14 * 0.96F + 0.03F;
               var15 = var15 * 0.96F + 0.03F;
               var16 = var16 * 0.96F + 0.03F;
               if (var14 > 1.0F) {
                  var14 = 1.0F;
               }

               if (var15 > 1.0F) {
                  var15 = 1.0F;
               }

               if (var16 > 1.0F) {
                  var16 = 1.0F;
               }

               if (var14 < 0.0F) {
                  var14 = 0.0F;
               }

               if (var15 < 0.0F) {
                  var15 = 0.0F;
               }

               if (var16 < 0.0F) {
                  var16 = 0.0F;
               }

               short var21 = 255;
               int var22 = (int)(var14 * 255.0F);
               int var23 = (int)(var15 * 255.0F);
               int var24 = (int)(var16 * 255.0F);
               this.H[var5] = var21 << 24 | var22 << 16 | var23 << 8 | var24;
            }

            this.G.d();
            this.J = false;
            this.h.A.b();
         }
      }
   }

   public void i() {
      bfl.g(bqs.r);
      bfl.n(5890);
      bfl.D();
      float var1 = 0.00390625F;
      bfl.a(var1, var1, var1);
      bfl.b(8.0F, 8.0F, 8.0F);
      bfl.n(5888);
      this.h.P().a(this.I);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 10496);
      GL11.glTexParameteri(3553, 10243, 10496);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.w();
      bfl.g(bqs.q);
   }

   public void b(float var1) {
      this.j();
      this.h.q.c(new avr(this.h));
   }

   public void b(float var1, long var2) {
      this.g(var1);
      if (this.h.ac() == null) {
         this.h.a((pk)this.h.h);
      }

      this.a(var1);
      bfl.j();
      bfl.d();
      bfl.a(516, 0.5F);
      this.h.A.a("center");
      if (this.h.t.e) {
         b = 0;
         bfl.a(false, true, true, false);
         this.a(0, var1, var2);
         b = 1;
         bfl.a(true, false, false, false);
         this.a(1, var1, var2);
         bfl.a(true, true, true, false);
      } else {
         this.a(2, var1, var2);
      }

      this.h.A.b();
   }

   public void d() {
      if (bqs.O) {
         if (this.h.ac() instanceof wn) {
            if (this.aa != null) {
               this.aa.a();
            }

            this.ac = (this.ac + 1) % (ab.length + 1);
            if (this.ac != d) {
               this.a(ab[this.ac]);
            } else {
               this.aa = null;
            }

         }
      }
   }

   public void a(pk var1) {
      if (bqs.O) {
         if (this.aa != null) {
            this.aa.a();
         }

         this.aa = null;
         if (var1 instanceof vn) {
            this.a(new jy("shaders/post/creeper.json"));
         } else if (var1 instanceof wc) {
            this.a(new jy("shaders/post/spider.json"));
         } else if (var1 instanceof vo) {
            this.a(new jy("shaders/post/invert.json"));
         }

      }
   }

   private void i(float var1) {
      bdb var2 = this.h.f;
      pk var3 = this.h.ac();
      float var4 = 0.25F + 0.75F * (float)this.h.t.c / 32.0F;
      var4 = 1.0F - (float)Math.pow((double)var4, 0.25D);
      aui var5 = var2.a(this.h.ac(), var1);
      float var6 = (float)var5.a;
      float var7 = (float)var5.b;
      float var8 = (float)var5.c;
      aui var9 = var2.f(var1);
      this.Q = (float)var9.a;
      this.R = (float)var9.b;
      this.S = (float)var9.c;
      float var13;
      if (this.h.t.c >= 4) {
         double var10 = -1.0D;
         aui var12 = ns.a(var2.d(var1)) > 0.0F ? new aui(var10, 0.0D, 0.0D) : new aui(1.0D, 0.0D, 0.0D);
         var13 = (float)var3.d(var1).b(var12);
         if (var13 < 0.0F) {
            var13 = 0.0F;
         }

         if (var13 > 0.0F) {
            float[] var14 = var2.t.a(var2.c(var1), var1);
            if (var14 != null) {
               var13 *= var14[3];
               this.Q = this.Q * (1.0F - var13) + var14[0] * var13;
               this.R = this.R * (1.0F - var13) + var14[1] * var13;
               this.S = this.S * (1.0F - var13) + var14[2] * var13;
            }
         }
      }

      this.Q += (var6 - this.Q) * var4;
      this.R += (var7 - this.R) * var4;
      this.S += (var8 - this.S) * var4;
      float var19 = var2.j(var1);
      float var11;
      float var20;
      if (var19 > 0.0F) {
         var11 = 1.0F - var19 * 0.5F;
         var20 = 1.0F - var19 * 0.4F;
         this.Q *= var11;
         this.R *= var11;
         this.S *= var20;
      }

      var11 = var2.h(var1);
      if (var11 > 0.0F) {
         var20 = 1.0F - var11 * 0.5F;
         this.Q *= var20;
         this.R *= var20;
         this.S *= var20;
      }

      afh var21 = auz.a(this.h.f, var3, var1);
      if (this.B) {
         aui var22 = var2.e(var1);
         this.Q = (float)var22.a;
         this.R = (float)var22.b;
         this.S = (float)var22.c;
      } else if (var21.t() == arm.h) {
         var13 = (float)ack.a(var3) * 0.2F;
         if (var3 instanceof pr && ((pr)var3).a(pe.o)) {
            var13 = var13 * 0.3F + 0.6F;
         }

         this.Q = 0.02F + var13;
         this.R = 0.02F + var13;
         this.S = 0.2F + var13;
      } else if (var21.t() == arm.i) {
         this.Q = 0.6F;
         this.R = 0.1F;
         this.S = 0.0F;
      }

      var13 = this.T + (this.U - this.T) * var1;
      this.Q *= var13;
      this.R *= var13;
      this.S *= var13;
      double var23 = (var3.Q + (var3.t - var3.Q) * (double)var1) * var2.t.j();
      if (var3 instanceof pr && ((pr)var3).a(pe.q)) {
         int var16 = ((pr)var3).b(pe.q).b();
         if (var16 < 20) {
            var23 *= (double)(1.0F - (float)var16 / 20.0F);
         } else {
            var23 = 0.0D;
         }
      }

      if (var23 < 1.0D) {
         if (var23 < 0.0D) {
            var23 = 0.0D;
         }

         var23 *= var23;
         this.Q = (float)((double)this.Q * var23);
         this.R = (float)((double)this.R * var23);
         this.S = (float)((double)this.S * var23);
      }

      float var24;
      if (this.z > 0.0F) {
         var24 = this.A + (this.z - this.A) * var1;
         this.Q = this.Q * (1.0F - var24) + this.Q * 0.7F * var24;
         this.R = this.R * (1.0F - var24) + this.R * 0.6F * var24;
         this.S = this.S * (1.0F - var24) + this.S * 0.6F * var24;
      }

      float var17;
      if (var3 instanceof pr && ((pr)var3).a(pe.r)) {
         var24 = this.a((pr)var3, var1);
         var17 = 1.0F / this.Q;
         if (var17 > 1.0F / this.R) {
            var17 = 1.0F / this.R;
         }

         if (var17 > 1.0F / this.S) {
            var17 = 1.0F / this.S;
         }

         this.Q = this.Q * (1.0F - var24) + this.Q * var17 * var24;
         this.R = this.R * (1.0F - var24) + this.R * var17 * var24;
         this.S = this.S * (1.0F - var24) + this.S * var17 * var24;
      }

      if (this.h.t.e) {
         var24 = (this.Q * 30.0F + this.R * 59.0F + this.S * 11.0F) / 100.0F;
         var17 = (this.Q * 30.0F + this.R * 70.0F) / 100.0F;
         float var18 = (this.Q * 30.0F + this.S * 70.0F) / 100.0F;
         this.Q = var24;
         this.R = var17;
         this.S = var18;
      }

      bfl.a(this.Q, this.R, this.S, 0.0F);
   }

   private void o() {
      float var1 = this.h.f.j(1.0F);
      if (!this.h.t.i) {
         var1 /= 2.0F;
      }

      if (var1 != 0.0F) {
         this.j.setSeed((long)this.m * 312987231L);
         pk var2 = this.h.ac();
         bdb var3 = this.h.f;
         cj var4 = new cj(var2);
         byte var5 = 10;
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         int var12 = 0;
         int var13 = (int)(100.0F * var1 * var1);
         if (this.h.t.aM == 1) {
            var13 >>= 1;
         } else if (this.h.t.aM == 2) {
            var13 = 0;
         }

         for(int var14 = 0; var14 < var13; ++var14) {
            cj var15 = var3.q(var4.a(this.j.nextInt(var5) - this.j.nextInt(var5), 0, this.j.nextInt(var5) - this.j.nextInt(var5)));
            ady var16 = var3.b(var15);
            cj var17 = var15.b();
            afh var18 = var3.p(var17).c();
            if (var15.o() <= var4.o() + var5 && var15.o() >= var4.o() - var5 && var16.e() && var16.a(var15) >= 0.15F) {
               double var19 = this.j.nextDouble();
               double var21 = this.j.nextDouble();
               if (var18.t() == arm.i) {
                  this.h.f.a(cy.l, (double)var15.n() + var19, (double)((float)var15.o() + 0.1F) - var18.D(), (double)var15.p() + var21, 0.0D, 0.0D, 0.0D, new int[0]);
               } else if (var18.t() != arm.a) {
                  var18.a((adq)var3, (cj)var17);
                  ++var12;
                  if (this.j.nextInt(var12) == 0) {
                     var6 = (double)var17.n() + var19;
                     var8 = (double)((float)var17.o() + 0.1F) + var18.E() - 1.0D;
                     var10 = (double)var17.p() + var21;
                  }

                  this.h.f.a(cy.N, (double)var17.n() + var19, (double)((float)var17.o() + 0.1F) + var18.E(), (double)var17.p() + var21, 0.0D, 0.0D, 0.0D, new int[0]);
               }
            }
         }

         if (var12 > 0 && this.j.nextInt(3) < this.M++) {
            this.M = 0;
            if (var8 > (double)(var4.o() + 1) && var3.q(var4).o() > ns.d((float)var4.o())) {
               this.h.f.a(var6, var8, var10, "ambient.weather.rain", 0.1F, 0.5F, false);
            } else {
               this.h.f.a(var6, var8, var10, "ambient.weather.rain", 0.2F, 1.0F, false);
            }
         }

      }
   }

   private float a(pr var1, float var2) {
      int var3 = var1.b(pe.r).b();
      return var3 > 200 ? 1.0F : 0.7F + ns.a(((float)var3 - var2) * 3.1415927F * 0.2F) * 0.3F;
   }

   private void a(int var1, float var2, long var3) {
      bfr var5 = this.h.g;
      bec var6 = this.h.j;
      boolean var7 = this.n();
      bfl.o();
      this.h.A.c("clear");
      bfl.b(0, 0, this.h.d, this.h.e);
      this.i(var2);
      bfl.m(16640);
      this.h.A.c("camera");
      this.a(var2, var1);
      auz.a(this.h.h, this.h.t.aB == 2);
      this.h.A.c("frustum");
      bib.a();
      this.h.A.c("culling");
      bic var8 = new bic();
      pk var9 = this.h.ac();
      double var10 = var9.P + (var9.s - var9.P) * (double)var2;
      double var12 = var9.Q + (var9.t - var9.Q) * (double)var2;
      double var14 = var9.R + (var9.u - var9.R) * (double)var2;
      var8.a(var10, var12, var14);
      if (this.h.t.c >= 4) {
         this.a(-1, var2);
         this.h.A.c("sky");
         bfl.n(5889);
         bfl.D();
         Project.gluPerspective(this.a(var2, true), (float)this.h.d / (float)this.h.e, 0.05F, this.k * 2.0F);
         bfl.n(5888);
         var5.a(var2, var1);
         bfl.n(5889);
         bfl.D();
         Project.gluPerspective(this.a(var2, true), (float)this.h.d / (float)this.h.e, 0.05F, this.k * ns.a);
         bfl.n(5888);
      }

      this.a(0, var2);
      bfl.j(7425);
      if (var9.t + (double)var9.aS() < 128.0D) {
         this.a(var5, var2, var1);
      }

      this.h.A.c("prepareterrain");
      this.a(0, var2);
      this.h.P().a(bmh.g);
      avc.a();
      this.h.A.c("terrain_setup");
      var5.a(var9, (double)var2, var8, this.ae++, this.h.h.v());
      if (var1 == 0 || var1 == 2) {
         this.h.A.c("updatechunks");
         this.h.g.a(var3);
      }

      this.h.A.c("terrain");
      bfl.n(5888);
      bfl.E();
      bfl.c();
      var5.a(adf.a, (double)var2, var1, var9);
      bfl.d();
      var5.a(adf.b, (double)var2, var1, var9);
      this.h.P().b(bmh.g).b(false, false);
      var5.a(adf.c, (double)var2, var1, var9);
      this.h.P().b(bmh.g).a();
      bfl.j(7424);
      bfl.a(516, 0.1F);
      wn var16;
      if (!this.W) {
         bfl.n(5888);
         bfl.F();
         bfl.E();
         avc.b();
         this.h.A.c("entities");
         var5.a(var9, var8, var2);
         avc.a();
         this.h();
         bfl.n(5888);
         bfl.F();
         bfl.E();
         if (this.h.s != null && var9.a(arm.h) && var7) {
            var16 = (wn)var9;
            bfl.c();
            this.h.A.c("outline");
            var5.a(var16, this.h.s, 0, var2);
            bfl.d();
         }
      }

      bfl.n(5888);
      bfl.F();
      if (var7 && this.h.s != null && !var9.a(arm.h)) {
         var16 = (wn)var9;
         bfl.c();
         this.h.A.c("outline");
         var5.a(var16, this.h.s, 0, var2);
         bfl.d();
      }

      this.h.A.c("destroyProgress");
      bfl.l();
      bfl.a(770, 1, 1, 0);
      this.h.P().b(bmh.g).b(false, false);
      var5.a(bfx.a(), bfx.a().c(), var9, var2);
      this.h.P().b(bmh.g).a();
      bfl.k();
      if (!this.W) {
         this.i();
         this.h.A.c("litParticles");
         var6.b(var9, var2);
         avc.a();
         this.a(0, var2);
         this.h.A.c("particles");
         var6.a(var9, var2);
         this.h();
      }

      bfl.a(false);
      bfl.o();
      this.h.A.c("weather");
      this.c(var2);
      bfl.a(true);
      var5.a(var9, var2);
      bfl.k();
      bfl.o();
      bfl.a(770, 771, 1, 0);
      bfl.a(516, 0.1F);
      this.a(0, var2);
      bfl.l();
      bfl.a(false);
      this.h.P().a(bmh.g);
      bfl.j(7425);
      this.h.A.c("translucent");
      var5.a(adf.d, (double)var2, var1, var9);
      bfl.j(7424);
      bfl.a(true);
      bfl.o();
      bfl.k();
      bfl.n();
      if (var9.t + (double)var9.aS() >= 128.0D) {
         this.h.A.c("aboveClouds");
         this.a(var5, var2, var1);
      }

      this.h.A.c("hand");
      if (this.C) {
         bfl.m(256);
         this.b(var2, var1);
         this.h(var2);
      }

   }

   private void d(float var1) {
      if (this.h.ac() instanceof pr) {
         pr var2 = (pr)this.h.ac();
         float var3 = (float)var2.au - var1;
         float var4;
         if (var2.bn() <= 0.0F) {
            var4 = (float)var2.ax + var1;
            bfl.b(40.0F - 8000.0F / (var4 + 200.0F), 0.0F, 0.0F, 1.0F);
         }

         if (var3 < 0.0F) {
            return;
         }

         var3 /= (float)var2.av;
         var3 = ns.a(var3 * var3 * var3 * var3 * 3.1415927F);
         var4 = var2.aw;
         bfl.b(-var4, 0.0F, 1.0F, 0.0F);
         bfl.b(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
         bfl.b(var4, 0.0F, 1.0F, 0.0F);
      }

   }

   public void a(float var1, long var2) {
      boolean var4 = Display.isActive();
      if (var4 || !this.h.t.z || this.h.t.A && Mouse.isButtonDown(1)) {
         this.E = ave.J();
      } else if (ave.J() - this.E > 500L) {
         this.h.p();
      }

      this.h.A.a("mouse");
      if (var4 && ave.a && this.h.w && !Mouse.isInsideWindow()) {
         Mouse.setGrabbed(false);
         Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
         Mouse.setGrabbed(true);
      }

      if (this.h.w && var4) {
         this.h.u.c();
         float var5 = this.h.t.a * 0.6F + 0.2F;
         float var6 = var5 * var5 * var5 * 8.0F;
         float var7 = (float)this.h.u.a * var6;
         float var8 = (float)this.h.u.b * var6;
         byte var9 = 1;
         if (this.h.t.b) {
            var9 = -1;
         }

         if (this.h.t.aG) {
            this.s += var7;
            this.t += var8;
            float var10 = var1 - this.w;
            this.w = var1;
            var7 = this.u * var10;
            var8 = this.v * var10;
            this.h.h.c(var7, var8 * (float)var9);
         } else {
            this.s = 0.0F;
            this.t = 0.0F;
            this.h.h.c(var7, var8 * (float)var9);
         }
      }

      this.h.A.b();
      if (!this.h.r) {
         a = this.h.t.e;
         avr var17 = new avr(this.h);
         int var18 = var17.a();
         int var19 = var17.b();
         int var20 = Mouse.getX() * var18 / this.h.d;
         int var21 = var19 - Mouse.getY() * var19 / this.h.e - 1;
         int var22 = this.h.t.g;
         if (this.h.f != null) {
            this.h.A.a("level");
            int var11 = Math.min(ave.ai(), var22);
            var11 = Math.max(var11, 60);
            long var12 = System.nanoTime() - var2;
            long var14 = Math.max((long)(1000000000 / var11 / 4) - var12, 0L);
            this.b(var1, System.nanoTime() + var14);
            if (bqs.O) {
               this.h.g.c();
               if (this.aa != null && this.ad) {
                  bfl.n(5890);
                  bfl.E();
                  bfl.D();
                  this.aa.a(var1);
                  bfl.F();
               }

               this.h.b().a(true);
            }

            this.F = System.nanoTime();
            this.h.A.c("gui");
            if (!this.h.t.aA || this.h.m != null) {
               bfl.a(516, 0.1F);
               this.h.q.a(var1);
            }

            this.h.A.b();
         } else {
            bfl.b(0, 0, this.h.d, this.h.e);
            bfl.n(5889);
            bfl.D();
            bfl.n(5888);
            bfl.D();
            this.j();
            this.F = System.nanoTime();
         }

         if (this.h.m != null) {
            bfl.m(256);

            try {
               this.h.m.a(var20, var21, var1);
            } catch (Throwable var16) {
               b var23 = b.a(var16, "Rendering screen");
               c var13 = var23.a("Screen render details");
               var13.a("Screen name", new Callable<String>(this) {
                  final bfk a;

                  public String a() throws Exception {
                     return bfk.a(this.a).m.getClass().getCanonicalName();
                  }

                  {
                     this.a = var1;
                  }

                  public Object call() throws Exception {
                     return this.a();
                  }
               });
               var13.a("Mouse location", new Callable<String>(this, var20, var21) {
                  final int a;
                  final bfk c;
                  final int b;

                  public String a() throws Exception {
                     return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", this.a, this.b, Mouse.getX(), Mouse.getY());
                  }

                  {
                     this.c = var1;
                     this.a = var2;
                     this.b = var3;
                  }

                  public Object call() throws Exception {
                     return this.a();
                  }
               });
               var13.a("Screen size", new Callable<String>(this, var17) {
                  final avr a;
                  final bfk b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public Object call() throws Exception {
                     return this.a();
                  }

                  public String a() throws Exception {
                     return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", this.a.a(), this.a.b(), bfk.a(this.b).d, bfk.a(this.b).e, this.a.e());
                  }
               });
               throw new e(var23);
            }
         }

      }
   }

   public void c() {
      this.ad = !this.ad;
   }
}
