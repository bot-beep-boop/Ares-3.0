import io.netty.buffer.Unpooled;
import java.util.List;
import org.lwjgl.input.Keyboard;

public class aym extends ayl implements xn {
   private avw w;
   private static final jy u = new jy("textures/gui/container/anvil.png");
   private xk v;
   private wm x;

   public void b() {
      super.b();
      Keyboard.enableRepeatEvents(true);
      int var1 = (this.l - this.f) / 2;
      int var2 = (this.m - this.g) / 2;
      this.w = new avw(0, this.q, var1 + 62, var2 + 24, 103, 12);
      this.w.g(-1);
      this.w.h(-1);
      this.w.a(false);
      this.w.f(30);
      this.h.b((xn)this);
      this.h.a((xn)this);
   }

   public void a(xi var1, int var2, zx var3) {
      if (var2 == 0) {
         this.w.a(var3 == null ? "" : var3.q());
         this.w.c(var3 != null);
         if (var3 != null) {
            this.a();
         }
      }

   }

   public void a(xi var1, og var2) {
   }

   private void a() {
      String var1 = this.w.b();
      yg var2 = this.v.a(0);
      if (var2 != null && var2.e() && !var2.d().s() && var1.equals(var2.d().q())) {
         var1 = "";
      }

      this.v.a(var1);
      this.j.h.a.a((ff)(new im("MC|ItemName", (new em(Unpooled.buffer())).a(var1))));
   }

   public aym(wm var1, adm var2) {
      super(new xk(var1, var2, ave.A().h));
      this.x = var1;
      this.v = (xk)this.h;
   }

   protected void a(char var1, int var2) {
      if (this.w.a(var1, var2)) {
         this.a();
      } else {
         super.a(var1, var2);
      }

   }

   public void a(xi var1, int var2, int var3) {
   }

   public void a(int var1, int var2, float var3) {
      super.a(var1, var2, var3);
      bfl.f();
      bfl.k();
      this.w.g();
   }

   public void m() {
      super.m();
      Keyboard.enableRepeatEvents(false);
      this.h.b((xn)this);
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.w.a(var1, var2, var3);
   }

   public void a(xi var1, List<zx> var2) {
      this.a(var1, 0, var1.a(0).d());
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      this.b(var4 + 59, var5 + 20, 0, this.g + (this.v.a(0).e() ? 0 : 16), 110, 16);
      if ((this.v.a(0).e() || this.v.a(1).e()) && !this.v.a(2).e()) {
         this.b(var4 + 99, var5 + 45, this.f, 0, 28, 21);
      }

   }

   protected void b(int var1, int var2) {
      bfl.f();
      bfl.k();
      this.q.a(bnq.a("container.repair"), 60, 6, 4210752);
      if (this.v.a > 0) {
         int var3 = 8453920;
         boolean var4 = true;
         String var5 = bnq.a("container.repair.cost", this.v.a);
         if (this.v.a >= 40 && !this.j.h.bA.d) {
            var5 = bnq.a("container.repair.expensive");
            var3 = 16736352;
         } else if (!this.v.a(2).e()) {
            var4 = false;
         } else if (!this.v.a(2).a(this.x.d)) {
            var3 = 16736352;
         }

         if (var4) {
            int var6 = -16777216 | (var3 & 16579836) >> 2 | var3 & -16777216;
            int var7 = this.f - 8 - this.q.a(var5);
            byte var8 = 67;
            if (this.q.a()) {
               a(var7 - 3, var8 - 2, this.f - 7, var8 + 10, -16777216);
               a(var7 - 2, var8 - 1, this.f - 8, var8 + 9, -12895429);
            } else {
               this.q.a(var5, var7, var8 + 1, var6);
               this.q.a(var5, var7 + 1, var8, var6);
               this.q.a(var5, var7 + 1, var8 + 1, var6);
            }

            this.q.a(var5, var7, var8, var3);
         }
      }

      bfl.e();
   }
}
