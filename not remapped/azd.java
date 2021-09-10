import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class azd extends ayl {
   private int z;
   private azd.a x;
   private eu A;
   private acy w;
   private azd.a y;
   private static final jy v = new jy("textures/gui/container/villager.png");
   private static final Logger u = LogManager.getLogger();

   public void b() {
      super.b();
      int var1 = (this.l - this.f) / 2;
      int var2 = (this.m - this.g) / 2;
      this.n.add(this.x = new azd.a(1, var1 + 120 + 27, var2 + 24 - 1, true));
      this.n.add(this.y = new azd.a(2, var1 + 36 - 19, var2 + 24 - 1, false));
      this.x.l = false;
      this.y.l = false;
   }

   public azd(wm var1, acy var2, adm var3) {
      super(new yb(var1, var2, var3));
      this.w = var2;
      this.A = var2.f_();
   }

   public acy a() {
      return this.w;
   }

   public void a(int var1, int var2, float var3) {
      super.a(var1, var2, var3);
      ada var4 = this.w.b_(this.j.h);
      if (var4 != null && !var4.isEmpty()) {
         int var5 = (this.l - this.f) / 2;
         int var6 = (this.m - this.g) / 2;
         int var7 = this.z;
         acz var8 = (acz)var4.get(var7);
         zx var9 = var8.a();
         zx var10 = var8.b();
         zx var11 = var8.d();
         bfl.E();
         avc.c();
         bfl.f();
         bfl.B();
         bfl.g();
         bfl.e();
         this.k.a = 100.0F;
         this.k.b(var9, var5 + 36, var6 + 24);
         this.k.a(this.q, var9, var5 + 36, var6 + 24);
         if (var10 != null) {
            this.k.b(var10, var5 + 62, var6 + 24);
            this.k.a(this.q, var10, var5 + 62, var6 + 24);
         }

         this.k.b(var11, var5 + 120, var6 + 24);
         this.k.a(this.q, var11, var5 + 120, var6 + 24);
         this.k.a = 0.0F;
         bfl.f();
         if (this.c(36, 24, 16, 16, var1, var2) && var9 != null) {
            this.a(var9, var1, var2);
         } else if (var10 != null && this.c(62, 24, 16, 16, var1, var2) && var10 != null) {
            this.a(var10, var1, var2);
         } else if (var11 != null && this.c(120, 24, 16, 16, var1, var2) && var11 != null) {
            this.a(var11, var1, var2);
         } else if (var8.h() && (this.c(83, 21, 28, 21, var1, var2) || this.c(83, 51, 28, 21, var1, var2))) {
            this.a(bnq.a("merchant.deprecated"), var1, var2);
         }

         bfl.F();
         bfl.e();
         bfl.j();
         avc.b();
      }

   }

   public void e() {
      super.e();
      ada var1 = this.w.b_(this.j.h);
      if (var1 != null) {
         this.x.l = this.z < var1.size() - 1;
         this.y.l = this.z > 0;
      }

   }

   protected void b(int var1, int var2) {
      String var3 = this.A.c();
      this.q.a(var3, this.f / 2 - this.q.a(var3) / 2, 6, 4210752);
      this.q.a(bnq.a("container.inventory"), 8, this.g - 96 + 2, 4210752);
   }

   static jy f() {
      return v;
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(v);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      ada var6 = this.w.b_(this.j.h);
      if (var6 != null && !var6.isEmpty()) {
         int var7 = this.z;
         if (var7 < 0 || var7 >= var6.size()) {
            return;
         }

         acz var8 = (acz)var6.get(var7);
         if (var8.h()) {
            this.j.P().a(v);
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            bfl.f();
            this.b(this.i + 83, this.r + 21, 212, 0, 28, 21);
            this.b(this.i + 83, this.r + 51, 212, 0, 28, 21);
         }
      }

   }

   protected void a(avs var1) {
      boolean var2 = false;
      if (var1 == this.x) {
         ++this.z;
         ada var3 = this.w.b_(this.j.h);
         if (var3 != null && this.z >= var3.size()) {
            this.z = var3.size() - 1;
         }

         var2 = true;
      } else if (var1 == this.y) {
         --this.z;
         if (this.z < 0) {
            this.z = 0;
         }

         var2 = true;
      }

      if (var2) {
         ((yb)this.h).d(this.z);
         em var4 = new em(Unpooled.buffer());
         var4.writeInt(this.z);
         this.j.u().a((ff)(new im("MC|TrSel", var4)));
      }

   }

   static class a extends avs {
      private final boolean o;

      public a(int var1, int var2, int var3, boolean var4) {
         super(var1, var2, var3, 12, 19, "");
         this.o = var4;
      }

      public void a(ave var1, int var2, int var3) {
         if (this.m) {
            var1.P().a(azd.f());
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var4 = var2 >= this.h && var3 >= this.i && var2 < this.h + this.f && var3 < this.i + this.g;
            int var5 = 0;
            int var6 = 176;
            if (!this.l) {
               var6 += this.f * 2;
            } else if (var4) {
               var6 += this.f;
            }

            if (!this.o) {
               var5 += this.g;
            }

            this.b(this.h, this.i, var6, var5, this.f, this.g);
         }
      }
   }
}
