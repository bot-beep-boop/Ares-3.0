import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;

public class bfw {
   public float[] i;
   public int g;
   public int j;
   public int b;
   public int d;
   public int h;
   public int f;
   public boolean e;
   public int a;
   public int c;

   public void a(int var1) {
      if (bqs.i()) {
         this.j = var1;
         bfl.i(this.g);
         GL11.glTexParameterf(3553, 10241, (float)var1);
         GL11.glTexParameterf(3553, 10240, (float)var1);
         GL11.glTexParameterf(3553, 10242, 10496.0F);
         GL11.glTexParameterf(3553, 10243, 10496.0F);
         bfl.i(0);
      }

   }

   public void b(int var1, int var2) {
      this.c = var1;
      this.d = var2;
      this.a = var1;
      this.b = var2;
      if (!bqs.i()) {
         this.f();
      } else {
         this.f = bqs.g();
         this.g = bml.a();
         if (this.e) {
            this.h = bqs.h();
         }

         this.a(9728);
         bfl.i(this.g);
         GL11.glTexImage2D(3553, 0, 32856, this.a, this.b, 0, 6408, 5121, (ByteBuffer)null);
         bqs.h(bqs.c, this.f);
         bqs.a(bqs.c, bqs.e, 3553, this.g, 0);
         if (this.e) {
            bqs.i(bqs.d, this.h);
            bqs.a(bqs.d, 33190, this.a, this.b);
            bqs.b(bqs.c, bqs.f, bqs.d, this.h);
         }

         this.f();
         this.d();
      }
   }

   public void a(float var1, float var2, float var3, float var4) {
      this.i[0] = var1;
      this.i[1] = var2;
      this.i[2] = var3;
      this.i[3] = var4;
   }

   public bfw(int var1, int var2, boolean var3) {
      this.e = var3;
      this.f = -1;
      this.g = -1;
      this.h = -1;
      this.i = new float[4];
      this.i[0] = 1.0F;
      this.i[1] = 1.0F;
      this.i[2] = 1.0F;
      this.i[3] = 0.0F;
      this.a(var1, var2);
   }

   public void a() {
      if (bqs.i()) {
         this.d();
         this.e();
         if (this.h > -1) {
            bqs.h(this.h);
            this.h = -1;
         }

         if (this.g > -1) {
            bml.a(this.g);
            this.g = -1;
         }

         if (this.f > -1) {
            bqs.h(bqs.c, 0);
            bqs.i(this.f);
            this.f = -1;
         }

      }
   }

   public void a(int var1, int var2) {
      if (!bqs.i()) {
         this.c = var1;
         this.d = var2;
      } else {
         bfl.j();
         if (this.f >= 0) {
            this.a();
         }

         this.b(var1, var2);
         this.b();
         bqs.h(bqs.c, 0);
      }
   }

   public void a(boolean var1) {
      if (bqs.i()) {
         bqs.h(bqs.c, this.f);
         if (var1) {
            bfl.b(0, 0, this.c, this.d);
         }
      }

   }

   public void d() {
      if (bqs.i()) {
         bfl.i(0);
      }

   }

   public void b() {
      int var1 = bqs.j(bqs.c);
      if (var1 != bqs.g) {
         if (var1 == bqs.h) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
         } else if (var1 == bqs.i) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
         } else if (var1 == bqs.j) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
         } else if (var1 == bqs.k) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
         } else {
            throw new RuntimeException("glCheckFramebufferStatus returned unknown status:" + var1);
         }
      }
   }

   public void e() {
      if (bqs.i()) {
         bqs.h(bqs.c, 0);
      }

   }

   public void c(int var1, int var2) {
      this.a(var1, var2, true);
   }

   public void f() {
      this.a(true);
      bfl.a(this.i[0], this.i[1], this.i[2], this.i[3]);
      int var1 = 16384;
      if (this.e) {
         bfl.a(1.0D);
         var1 |= 256;
      }

      bfl.m(var1);
      this.e();
   }

   public void c() {
      if (bqs.i()) {
         bfl.i(this.g);
      }

   }

   public void a(int var1, int var2, boolean var3) {
      if (bqs.i()) {
         bfl.a(true, true, true, false);
         bfl.i();
         bfl.a(false);
         bfl.n(5889);
         bfl.D();
         bfl.a(0.0D, (double)var1, (double)var2, 0.0D, 1000.0D, 3000.0D);
         bfl.n(5888);
         bfl.D();
         bfl.b(0.0F, 0.0F, -2000.0F);
         bfl.b(0, 0, var1, var2);
         bfl.w();
         bfl.f();
         bfl.c();
         if (var3) {
            bfl.k();
            bfl.g();
         }

         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.c();
         float var4 = (float)var1;
         float var5 = (float)var2;
         float var6 = (float)this.c / (float)this.a;
         float var7 = (float)this.d / (float)this.b;
         bfx var8 = bfx.a();
         bfd var9 = var8.c();
         var9.a(7, bms.i);
         var9.b(0.0D, (double)var5, 0.0D).a(0.0D, 0.0D).b(255, 255, 255, 255).d();
         var9.b((double)var4, (double)var5, 0.0D).a((double)var6, 0.0D).b(255, 255, 255, 255).d();
         var9.b((double)var4, 0.0D, 0.0D).a((double)var6, (double)var7).b(255, 255, 255, 255).d();
         var9.b(0.0D, 0.0D, 0.0D).a(0.0D, (double)var7).b(255, 255, 255, 255).d();
         var8.b();
         this.d();
         bfl.a(true);
         bfl.a(true, true, true, true);
      }
   }
}
