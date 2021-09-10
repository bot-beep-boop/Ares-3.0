import org.lwjgl.input.Keyboard;

public class axt extends axu {
   private final String g;
   private avw f;
   private axu a;

   protected void a(char var1, int var2) {
      this.f.a(var1, var2);
      ((avs)this.n.get(0)).l = this.f.b().trim().length() > 0;
      if (var2 == 28 || var2 == 156) {
         this.a((avs)this.n.get(0));
      }

   }

   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      this.n.add(new avs(0, this.l / 2 - 100, this.m / 4 + 96 + 12, bnq.a("selectWorld.renameButton")));
      this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 120 + 12, bnq.a("gui.cancel")));
      atr var1 = this.j.f();
      ato var2 = var1.c(this.g);
      String var3 = var2.k();
      this.f = new avw(2, this.q, this.l / 2 - 100, 60, 200, 20);
      this.f.b(true);
      this.f.a(var3);
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 1) {
            this.j.a(this.a);
         } else if (var1.k == 0) {
            atr var2 = this.j.f();
            var2.a(this.g, this.f.b().trim());
            this.j.a(this.a);
         }

      }
   }

   public void e() {
      this.f.a();
   }

   public axt(axu var1, String var2) {
      this.a = var1;
      this.g = var2;
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("selectWorld.renameTitle"), this.l / 2, 20, 16777215);
      this.c(this.q, bnq.a("selectWorld.enterName"), this.l / 2 - 100, 47, 10526880);
      this.f.g();
      super.a(var1, var2, var3);
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.f.a(var1, var2, var3);
   }
}
