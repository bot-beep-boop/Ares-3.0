public class aww extends awy {
   private final String r;
   private final String t;
   private boolean u = true;
   private final String s;

   protected void a(avs var1) {
      if (var1.k == 2) {
         this.a();
      }

      this.a.a(var1.k == 0, this.i);
   }

   public void a(int var1, int var2, float var3) {
      super.a(var1, var2, var3);
      if (this.u) {
         this.a(this.q, this.r, this.l / 2, 110, 16764108);
      }

   }

   public void f() {
      this.u = false;
   }

   public aww(awx var1, String var2, int var3, boolean var4) {
      super(var1, bnq.a(var4 ? "chat.link.confirmTrusted" : "chat.link.confirm"), var2, var3);
      this.g = bnq.a(var4 ? "chat.link.open" : "gui.yes");
      this.h = bnq.a(var4 ? "gui.cancel" : "gui.no");
      this.s = bnq.a("chat.copy");
      this.r = bnq.a("chat.link.warning");
      this.t = var2;
   }

   public void b() {
      super.b();
      this.n.clear();
      this.n.add(new avs(0, this.l / 2 - 50 - 105, this.m / 6 + 96, 100, 20, this.g));
      this.n.add(new avs(2, this.l / 2 - 50, this.m / 6 + 96, 100, 20, this.s));
      this.n.add(new avs(1, this.l / 2 - 50 + 105, this.m / 6 + 96, 100, 20, this.h));
   }

   public void a() {
      e(this.t);
   }
}
