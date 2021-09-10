import com.google.common.collect.Lists;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public abstract class bjl<T extends pr> extends biv<T> {
   private static final Logger a = LogManager.getLogger();
   protected boolean i = false;
   protected List<blb<T>> h = Lists.newArrayList();
   protected FloatBuffer g = avd.h(4);
   private static final blz e = new blz(16, 16);
   protected bbo f;

   protected void f() {
      bfl.g(bqs.q);
      bfl.w();
      GL11.glTexEnvi(8960, 8704, bqs.t);
      GL11.glTexEnvi(8960, bqs.y, 8448);
      GL11.glTexEnvi(8960, bqs.z, bqs.q);
      GL11.glTexEnvi(8960, bqs.A, bqs.v);
      GL11.glTexEnvi(8960, bqs.C, 768);
      GL11.glTexEnvi(8960, bqs.D, 768);
      GL11.glTexEnvi(8960, bqs.F, 8448);
      GL11.glTexEnvi(8960, bqs.G, bqs.q);
      GL11.glTexEnvi(8960, bqs.H, bqs.v);
      GL11.glTexEnvi(8960, bqs.J, 770);
      GL11.glTexEnvi(8960, bqs.K, 770);
      bfl.g(bqs.r);
      GL11.glTexEnvi(8960, 8704, bqs.t);
      GL11.glTexEnvi(8960, bqs.y, 8448);
      GL11.glTexEnvi(8960, bqs.C, 768);
      GL11.glTexEnvi(8960, bqs.D, 768);
      GL11.glTexEnvi(8960, bqs.z, 5890);
      GL11.glTexEnvi(8960, bqs.A, bqs.x);
      GL11.glTexEnvi(8960, bqs.F, 8448);
      GL11.glTexEnvi(8960, bqs.J, 770);
      GL11.glTexEnvi(8960, bqs.G, 5890);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.g(bqs.s);
      bfl.x();
      bfl.i(0);
      GL11.glTexEnvi(8960, 8704, bqs.t);
      GL11.glTexEnvi(8960, bqs.y, 8448);
      GL11.glTexEnvi(8960, bqs.C, 768);
      GL11.glTexEnvi(8960, bqs.D, 768);
      GL11.glTexEnvi(8960, bqs.z, 5890);
      GL11.glTexEnvi(8960, bqs.A, bqs.x);
      GL11.glTexEnvi(8960, bqs.F, 8448);
      GL11.glTexEnvi(8960, bqs.J, 770);
      GL11.glTexEnvi(8960, bqs.G, 5890);
      bfl.g(bqs.q);
   }

   public void C_() {
   }

   protected void a(T var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      boolean var8 = !var1.ax();
      boolean var9 = !var8 && !var1.f(ave.A().h);
      if (var8 || var9) {
         if (!this.c(var1)) {
            return;
         }

         if (var9) {
            bfl.E();
            bfl.c(1.0F, 1.0F, 1.0F, 0.15F);
            bfl.a(false);
            bfl.l();
            bfl.b(770, 771);
            bfl.a(516, 0.003921569F);
         }

         this.f.a(var1, var2, var3, var4, var5, var6, var7);
         if (var9) {
            bfl.k();
            bfl.a(516, 0.1F);
            bfl.F();
            bfl.a(true);
         }
      }

   }

   protected boolean c(T var1) {
      int var2 = 16777215;
      if (var1 instanceof wn) {
         aul var3 = (aul)var1.bO();
         if (var3 != null) {
            String var4 = avn.b(var3.e());
            if (var4.length() >= 2) {
               var2 = this.c().b(var4.charAt(1));
            }
         }
      }

      float var6 = (float)(var2 >> 16 & 255) / 255.0F;
      float var7 = (float)(var2 >> 8 & 255) / 255.0F;
      float var5 = (float)(var2 & 255) / 255.0F;
      bfl.f();
      bfl.g(bqs.q);
      bfl.c(var6, var7, var5, 1.0F);
      bfl.x();
      bfl.g(bqs.r);
      bfl.x();
      bfl.g(bqs.q);
      return true;
   }

   protected boolean a(T var1) {
      bew var2 = ave.A().h;
      if (var1 instanceof wn && var1 != var2) {
         auq var3 = var1.bO();
         auq var4 = var2.bO();
         if (var3 != null) {
            auq.a var5 = var3.i();
            switch(var5) {
            case a:
               return true;
            case b:
               return false;
            case c:
               return var4 == null || var3.a(var4);
            case d:
               return var4 == null || !var3.a(var4);
            default:
               return true;
            }
         }
      }

      return ave.v() && var1 != this.b.c && !var1.f(var2) && var1.l == null;
   }

   public void a(T var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.p();
      this.f.p = this.d(var1, var9);
      this.f.q = var1.au();
      this.f.r = var1.j_();

      try {
         float var10 = this.a(var1.aJ, var1.aI, var9);
         float var11 = this.a(var1.aL, var1.aK, var9);
         float var12 = var11 - var10;
         float var14;
         if (var1.au() && var1.m instanceof pr) {
            pr var13 = (pr)var1.m;
            var10 = this.a(var13.aJ, var13.aI, var9);
            var12 = var11 - var10;
            var14 = ns.g(var12);
            if (var14 < -85.0F) {
               var14 = -85.0F;
            }

            if (var14 >= 85.0F) {
               var14 = 85.0F;
            }

            var10 = var11 - var14;
            if (var14 * var14 > 2500.0F) {
               var10 += var14 * 0.2F;
            }
         }

         float var20 = var1.B + (var1.z - var1.B) * var9;
         this.a(var1, var2, var4, var6);
         var14 = this.b(var1, var9);
         this.a(var1, var14, var10, var9);
         bfl.B();
         bfl.a(-1.0F, -1.0F, 1.0F);
         this.a(var1, var9);
         float var15 = 0.0625F;
         bfl.b(0.0F, -1.5078125F, 0.0F);
         float var16 = var1.aA + (var1.aB - var1.aA) * var9;
         float var17 = var1.aC - var1.aB * (1.0F - var9);
         if (var1.j_()) {
            var17 *= 3.0F;
         }

         if (var16 > 1.0F) {
            var16 = 1.0F;
         }

         bfl.d();
         this.f.a(var1, var17, var16, var9);
         this.f.a(var17, var16, var14, var12, var20, 0.0625F, var1);
         boolean var18;
         if (this.i) {
            var18 = this.c(var1);
            this.a(var1, var17, var16, var14, var12, var20, 0.0625F);
            if (var18) {
               this.e();
            }
         } else {
            var18 = this.c(var1, var9);
            this.a(var1, var17, var16, var14, var12, var20, 0.0625F);
            if (var18) {
               this.f();
            }

            bfl.a(true);
            if (!(var1 instanceof wn) || !((wn)var1).v()) {
               this.a(var1, var17, var16, var9, var14, var12, var20, 0.0625F);
            }
         }

         bfl.C();
      } catch (Exception var19) {
         a.error("Couldn't render entity", var19);
      }

      bfl.g(bqs.r);
      bfl.w();
      bfl.g(bqs.q);
      bfl.o();
      bfl.F();
      if (!this.i) {
         super.a(var1, var2, var4, var6, var8, var9);
      }

   }

   protected void a(T var1, float var2) {
   }

   protected float b(T var1, float var2) {
      return (float)var1.W + var2;
   }

   protected float a(float var1, float var2, float var3) {
      float var4;
      for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return var1 + var3 * var4;
   }

   protected int a(T var1, float var2, float var3) {
      return 0;
   }

   protected void e() {
      bfl.e();
      bfl.g(bqs.q);
      bfl.w();
      bfl.g(bqs.r);
      bfl.w();
      bfl.g(bqs.q);
   }

   protected <V extends pr, U extends blb<V>> boolean b(U var1) {
      return this.h.remove(var1);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((pr)var1, var2, var4, var6, var8, var9);
   }

   public void b(T var1, double var2, double var4, double var6) {
      if (this.a(var1)) {
         double var8 = var1.h(this.b.c);
         float var10 = var1.av() ? 32.0F : 64.0F;
         if (!(var8 >= (double)(var10 * var10))) {
            String var11 = var1.f_().d();
            float var12 = 0.02666667F;
            bfl.a(516, 0.1F);
            if (var1.av()) {
               avn var13 = this.c();
               bfl.E();
               bfl.b((float)var2, (float)var4 + var1.K + 0.5F - (var1.j_() ? var1.K / 2.0F : 0.0F), (float)var6);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               bfl.b(-this.b.e, 0.0F, 1.0F, 0.0F);
               bfl.b(this.b.f, 1.0F, 0.0F, 0.0F);
               bfl.a(-0.02666667F, -0.02666667F, 0.02666667F);
               bfl.b(0.0F, 9.374999F, 0.0F);
               bfl.f();
               bfl.a(false);
               bfl.l();
               bfl.x();
               bfl.a(770, 771, 1, 0);
               int var14 = var13.a(var11) / 2;
               bfx var15 = bfx.a();
               bfd var16 = var15.c();
               var16.a(7, bms.f);
               var16.b((double)(-var14 - 1), -1.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(-var14 - 1), 8.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(var14 + 1), 8.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(var14 + 1), -1.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var15.b();
               bfl.w();
               bfl.a(true);
               var13.a(var11, -var13.a(var11) / 2, 0, 553648127);
               bfl.e();
               bfl.k();
               bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
               bfl.F();
            } else {
               this.a(var1, var2, var4 - (var1.j_() ? (double)(var1.K / 2.0F) : 0.0D), var6, var11, 0.02666667F, var8);
            }

         }
      }
   }

   public bbo b() {
      return this.f;
   }

   protected boolean b(pk var1) {
      return this.a((pr)var1);
   }

   public bjl(biu var1, bbo var2, float var3) {
      super(var1);
      this.f = var2;
      this.c = var3;
   }

   protected void a(T var1, float var2, float var3, float var4) {
      bfl.b(180.0F - var3, 0.0F, 1.0F, 0.0F);
      if (var1.ax > 0) {
         float var5 = ((float)var1.ax + var4 - 1.0F) / 20.0F * 1.6F;
         var5 = ns.c(var5);
         if (var5 > 1.0F) {
            var5 = 1.0F;
         }

         bfl.b(var5 * this.b(var1), 0.0F, 0.0F, 1.0F);
      } else {
         String var6 = a.a(var1.e_());
         if (var6 != null && (var6.equals("Dinnerbone") || var6.equals("Grumm")) && (!(var1 instanceof wn) || ((wn)var1).a(wo.a))) {
            bfl.b(0.0F, var1.K + 0.1F, 0.0F);
            bfl.b(180.0F, 0.0F, 0.0F, 1.0F);
         }
      }

   }

   protected void a(T var1, double var2, double var4, double var6) {
      bfl.b((float)var2, (float)var4, (float)var6);
   }

   protected boolean a(T var1, float var2, boolean var3) {
      float var4 = var1.c(var2);
      int var5 = this.a(var1, var4, var2);
      boolean var6 = (var5 >> 24 & 255) > 0;
      boolean var7 = var1.au > 0 || var1.ax > 0;
      if (!var6 && !var7) {
         return false;
      } else if (!var6 && !var3) {
         return false;
      } else {
         bfl.g(bqs.q);
         bfl.w();
         GL11.glTexEnvi(8960, 8704, bqs.t);
         GL11.glTexEnvi(8960, bqs.y, 8448);
         GL11.glTexEnvi(8960, bqs.z, bqs.q);
         GL11.glTexEnvi(8960, bqs.A, bqs.v);
         GL11.glTexEnvi(8960, bqs.C, 768);
         GL11.glTexEnvi(8960, bqs.D, 768);
         GL11.glTexEnvi(8960, bqs.F, 7681);
         GL11.glTexEnvi(8960, bqs.G, bqs.q);
         GL11.glTexEnvi(8960, bqs.J, 770);
         bfl.g(bqs.r);
         bfl.w();
         GL11.glTexEnvi(8960, 8704, bqs.t);
         GL11.glTexEnvi(8960, bqs.y, bqs.u);
         GL11.glTexEnvi(8960, bqs.z, bqs.w);
         GL11.glTexEnvi(8960, bqs.A, bqs.x);
         GL11.glTexEnvi(8960, bqs.B, bqs.w);
         GL11.glTexEnvi(8960, bqs.C, 768);
         GL11.glTexEnvi(8960, bqs.D, 768);
         GL11.glTexEnvi(8960, bqs.E, 770);
         GL11.glTexEnvi(8960, bqs.F, 7681);
         GL11.glTexEnvi(8960, bqs.G, bqs.x);
         GL11.glTexEnvi(8960, bqs.J, 770);
         this.g.position(0);
         if (var7) {
            this.g.put(1.0F);
            this.g.put(0.0F);
            this.g.put(0.0F);
            this.g.put(0.3F);
         } else {
            float var8 = (float)(var5 >> 24 & 255) / 255.0F;
            float var9 = (float)(var5 >> 16 & 255) / 255.0F;
            float var10 = (float)(var5 >> 8 & 255) / 255.0F;
            float var11 = (float)(var5 & 255) / 255.0F;
            this.g.put(var9);
            this.g.put(var10);
            this.g.put(var11);
            this.g.put(1.0F - var8);
         }

         this.g.flip();
         GL11.glTexEnv(8960, 8705, this.g);
         bfl.g(bqs.s);
         bfl.w();
         bfl.i(e.b());
         GL11.glTexEnvi(8960, 8704, bqs.t);
         GL11.glTexEnvi(8960, bqs.y, 8448);
         GL11.glTexEnvi(8960, bqs.z, bqs.x);
         GL11.glTexEnvi(8960, bqs.A, bqs.r);
         GL11.glTexEnvi(8960, bqs.C, 768);
         GL11.glTexEnvi(8960, bqs.D, 768);
         GL11.glTexEnvi(8960, bqs.F, 7681);
         GL11.glTexEnvi(8960, bqs.G, bqs.x);
         GL11.glTexEnvi(8960, bqs.J, 770);
         bfl.g(bqs.q);
         return true;
      }
   }

   protected void a(T var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Iterator var9 = this.h.iterator();

      while(var9.hasNext()) {
         blb var10 = (blb)var9.next();
         boolean var11 = this.a(var1, var4, var10.b());
         var10.a(var1, var2, var3, var4, var5, var6, var7, var8);
         if (var11) {
            this.f();
         }
      }

   }

   public void a(boolean var1) {
      this.i = var1;
   }

   protected float b(T var1) {
      return 90.0F;
   }

   public void a(pk var1, double var2, double var4, double var6) {
      this.b((pr)var1, var2, var4, var6);
   }

   protected <V extends pr, U extends blb<V>> boolean a(U var1) {
      return this.h.add(var1);
   }

   protected boolean c(T var1, float var2) {
      return this.a(var1, var2, true);
   }

   protected float d(T var1, float var2) {
      return var1.l(var2);
   }

   static {
      int[] var0 = e.e();

      for(int var1 = 0; var1 < 256; ++var1) {
         var0[var1] = -1;
      }

      e.d();
   }
}
