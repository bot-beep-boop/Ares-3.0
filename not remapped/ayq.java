import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class ayq extends axu {
   private avw g;
   private avs s;
   private avs r;
   private avw f;
   private final adc h;
   private static final Logger a = LogManager.getLogger();
   private boolean t;
   private avs i;

   private void a() {
      if (this.h.m()) {
         this.s.j = "O";
         if (this.h.k() != null) {
            this.g.a(this.h.k().c());
         }
      } else {
         this.s.j = "X";
         this.g.a("-");
      }

   }

   public ayq(adc var1) {
      this.h = var1;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            this.h.a(this.t);
            this.j.a((axu)null);
         } else if (var1.k == 0) {
            em var2 = new em(Unpooled.buffer());
            var2.writeByte(this.h.i());
            this.h.a((ByteBuf)var2);
            var2.a(this.f.b());
            var2.writeBoolean(this.h.m());
            this.j.u().a((ff)(new im("MC|AdvCdm", var2)));
            if (!this.h.m()) {
               this.h.b((eu)null);
            }

            this.j.a((axu)null);
         } else if (var1.k == 4) {
            this.h.a(!this.h.m());
            this.a();
         }

      }
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      this.n.add(this.i = new avs(0, this.l / 2 - 4 - 150, this.m / 4 + 120 + 12, 150, 20, bnq.a("gui.done")));
      this.n.add(this.r = new avs(1, this.l / 2 + 4, this.m / 4 + 120 + 12, 150, 20, bnq.a("gui.cancel")));
      this.n.add(this.s = new avs(4, this.l / 2 + 150 - 20, 150, 20, 20, "O"));
      this.f = new avw(2, this.q, this.l / 2 - 150, 50, 300, 20);
      this.f.f(32767);
      this.f.b(true);
      this.f.a(this.h.l());
      this.g = new avw(3, this.q, this.l / 2 - 150, 150, 276, 20);
      this.g.f(32767);
      this.g.c(false);
      this.g.a("-");
      this.t = this.h.m();
      this.a();
      this.i.l = this.f.b().trim().length() > 0;
   }

   public void e() {
      this.f.a();
   }

   protected void a(char var1, int var2) {
      this.f.a(var1, var2);
      this.g.a(var1, var2);
      this.i.l = this.f.b().trim().length() > 0;
      if (var2 != 28 && var2 != 156) {
         if (var2 == 1) {
            this.a(this.r);
         }
      } else {
         this.a(this.i);
      }

   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.f.a(var1, var2, var3);
      this.g.a(var1, var2, var3);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("advMode.setCommand"), this.l / 2, 20, 16777215);
      this.c(this.q, bnq.a("advMode.command"), this.l / 2 - 150, 37, 10526880);
      this.f.g();
      byte var4 = 75;
      byte var5 = 0;
      avn var10001 = this.q;
      String var10002 = bnq.a("advMode.nearestPlayer");
      int var10003 = this.l / 2 - 150;
      int var7 = var5 + 1;
      this.c(var10001, var10002, var10003, var4 + var5 * this.q.a, 10526880);
      this.c(this.q, bnq.a("advMode.randomPlayer"), this.l / 2 - 150, var4 + var7++ * this.q.a, 10526880);
      this.c(this.q, bnq.a("advMode.allPlayers"), this.l / 2 - 150, var4 + var7++ * this.q.a, 10526880);
      this.c(this.q, bnq.a("advMode.allEntities"), this.l / 2 - 150, var4 + var7++ * this.q.a, 10526880);
      this.c(this.q, "", this.l / 2 - 150, var4 + var7++ * this.q.a, 10526880);
      if (this.g.b().length() > 0) {
         int var6 = var4 + var7 * this.q.a + 16;
         this.c(this.q, bnq.a("advMode.previousOutput"), this.l / 2 - 150, var6, 10526880);
         this.g.g();
      }

      super.a(var1, var2, var3);
   }
}
