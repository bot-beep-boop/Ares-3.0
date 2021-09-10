import org.lwjgl.input.Keyboard;

public class axg extends axu {
   private final bde f;
   private final axu a;
   private avw g;

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("selectServer.direct"), this.l / 2, 20, 16777215);
      this.c(this.q, bnq.a("addServer.enterIp"), this.l / 2 - 100, 100, 10526880);
      this.g.g();
      super.a(var1, var2, var3);
   }

   public void e() {
      this.g.a();
   }

   public axg(axu var1, bde var2) {
      this.a = var1;
      this.f = var2;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            this.a.a(false, 0);
         } else if (var1.k == 0) {
            this.f.b = this.g.b();
            this.a.a(true, 0);
         }

      }
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.g.a(var1, var2, var3);
   }

   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      this.n.add(new avs(0, this.l / 2 - 100, this.m / 4 + 96 + 12, bnq.a("selectServer.select")));
      this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 120 + 12, bnq.a("gui.cancel")));
      this.g = new avw(2, this.q, this.l / 2 - 100, 116, 200, 20);
      this.g.f(128);
      this.g.b(true);
      this.g.a(this.j.t.aF);
      ((avs)this.n.get(0)).l = this.g.b().length() > 0 && this.g.b().split(":").length > 0;
   }

   protected void a(char var1, int var2) {
      if (this.g.a(var1, var2)) {
         ((avs)this.n.get(0)).l = this.g.b().length() > 0 && this.g.b().split(":").length > 0;
      } else if (var2 == 28 || var2 == 156) {
         this.a((avs)this.n.get(0));
      }

   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
      this.j.t.aF = this.g.b();
      this.j.t.b();
   }
}
