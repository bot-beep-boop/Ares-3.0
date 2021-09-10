public class avi implements nu {
   private String a = "";
   private String c = "";
   private bfw g;
   private long d = ave.J();
   private ave b;
   private avr f;
   private boolean e;

   public void c(String var1) {
      if (!this.b.B) {
         if (!this.e) {
            throw new avk();
         }
      } else {
         this.d = 0L;
         this.a = var1;
         this.a(-1);
         this.d = 0L;
      }
   }

   private void d(String var1) {
      this.c = var1;
      if (!this.b.B) {
         if (!this.e) {
            throw new avk();
         }
      } else {
         bfl.m(256);
         bfl.n(5889);
         bfl.D();
         if (bqs.i()) {
            int var2 = this.f.e();
            bfl.a(0.0D, (double)(this.f.a() * var2), (double)(this.f.b() * var2), 0.0D, 100.0D, 300.0D);
         } else {
            avr var3 = new avr(this.b);
            bfl.a(0.0D, var3.c(), var3.d(), 0.0D, 100.0D, 300.0D);
         }

         bfl.n(5888);
         bfl.D();
         bfl.b(0.0F, 0.0F, -200.0F);
      }
   }

   public avi(ave var1) {
      this.b = var1;
      this.f = new avr(var1);
      this.g = new bfw(var1.d, var1.e, false);
      this.g.a(9728);
   }

   public void a(int var1) {
      if (!this.b.B) {
         if (!this.e) {
            throw new avk();
         }
      } else {
         long var2 = ave.J();
         if (var2 - this.d >= 100L) {
            this.d = var2;
            avr var4 = new avr(this.b);
            int var5 = var4.e();
            int var6 = var4.a();
            int var7 = var4.b();
            if (bqs.i()) {
               this.g.f();
            } else {
               bfl.m(256);
            }

            this.g.a(false);
            bfl.n(5889);
            bfl.D();
            bfl.a(0.0D, var4.c(), var4.d(), 0.0D, 100.0D, 300.0D);
            bfl.n(5888);
            bfl.D();
            bfl.b(0.0F, 0.0F, -200.0F);
            if (!bqs.i()) {
               bfl.m(16640);
            }

            bfx var8 = bfx.a();
            bfd var9 = var8.c();
            this.b.P().a(avp.b);
            float var10 = 32.0F;
            var9.a(7, bms.i);
            var9.b(0.0D, (double)var7, 0.0D).a(0.0D, (double)((float)var7 / var10)).b(64, 64, 64, 255).d();
            var9.b((double)var6, (double)var7, 0.0D).a((double)((float)var6 / var10), (double)((float)var7 / var10)).b(64, 64, 64, 255).d();
            var9.b((double)var6, 0.0D, 0.0D).a((double)((float)var6 / var10), 0.0D).b(64, 64, 64, 255).d();
            var9.b(0.0D, 0.0D, 0.0D).a(0.0D, 0.0D).b(64, 64, 64, 255).d();
            var8.b();
            if (var1 >= 0) {
               byte var11 = 100;
               byte var12 = 2;
               int var13 = var6 / 2 - var11 / 2;
               int var14 = var7 / 2 + 16;
               bfl.x();
               var9.a(7, bms.f);
               var9.b((double)var13, (double)var14, 0.0D).b(128, 128, 128, 255).d();
               var9.b((double)var13, (double)(var14 + var12), 0.0D).b(128, 128, 128, 255).d();
               var9.b((double)(var13 + var11), (double)(var14 + var12), 0.0D).b(128, 128, 128, 255).d();
               var9.b((double)(var13 + var11), (double)var14, 0.0D).b(128, 128, 128, 255).d();
               var9.b((double)var13, (double)var14, 0.0D).b(128, 255, 128, 255).d();
               var9.b((double)var13, (double)(var14 + var12), 0.0D).b(128, 255, 128, 255).d();
               var9.b((double)(var13 + var1), (double)(var14 + var12), 0.0D).b(128, 255, 128, 255).d();
               var9.b((double)(var13 + var1), (double)var14, 0.0D).b(128, 255, 128, 255).d();
               var8.b();
               bfl.w();
            }

            bfl.l();
            bfl.a(770, 771, 1, 0);
            this.b.k.a(this.c, (float)((var6 - this.b.k.a(this.c)) / 2), (float)(var7 / 2 - 4 - 16), 16777215);
            this.b.k.a(this.a, (float)((var6 - this.b.k.a(this.a)) / 2), (float)(var7 / 2 - 4 + 8), 16777215);
            this.g.e();
            if (bqs.i()) {
               this.g.c(var6 * var5, var7 * var5);
            }

            this.b.h();

            try {
               Thread.yield();
            } catch (Exception var15) {
            }

         }
      }
   }

   public void a() {
   }

   public void b(String var1) {
      this.e = false;
      this.d(var1);
   }

   public void a(String var1) {
      this.e = true;
      this.d(var1);
   }
}
