public class axw extends axu {
   private avs f;
   private final axu a;
   private String h = "survival";
   private avs g;
   private boolean i;

   public axw(axu var1) {
      this.a = var1;
   }

   private void a() {
      this.g.j = bnq.a("selectWorld.gameMode") + " " + bnq.a("selectWorld.gameMode." + this.h);
      this.f.j = bnq.a("selectWorld.allowCommands") + " ";
      StringBuilder var10000;
      avs var10002;
      if (this.i) {
         var10000 = new StringBuilder();
         var10002 = this.f;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.on")).toString();
      } else {
         var10000 = new StringBuilder();
         var10002 = this.f;
         var10002.j = var10000.append(var10002.j).append(bnq.a("options.off")).toString();
      }

   }

   protected void a(avs var1) {
      if (var1.k == 102) {
         this.j.a(this.a);
      } else if (var1.k == 104) {
         if (this.h.equals("spectator")) {
            this.h = "creative";
         } else if (this.h.equals("creative")) {
            this.h = "adventure";
         } else if (this.h.equals("adventure")) {
            this.h = "survival";
         } else {
            this.h = "spectator";
         }

         this.a();
      } else if (var1.k == 103) {
         this.i = !this.i;
         this.a();
      } else if (var1.k == 101) {
         this.j.a((axu)null);
         String var2 = this.j.G().a(adp.a.a(this.h), this.i);
         Object var3;
         if (var2 != null) {
            var3 = new fb("commands.publish.started", new Object[]{var2});
         } else {
            var3 = new fa("commands.publish.failed");
         }

         this.j.q.d().a((eu)var3);
      }

   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("lanServer.title"), this.l / 2, 50, 16777215);
      this.a(this.q, bnq.a("lanServer.otherPlayers"), this.l / 2, 82, 16777215);
      super.a(var1, var2, var3);
   }

   public void b() {
      this.n.clear();
      this.n.add(new avs(101, this.l / 2 - 155, this.m - 28, 150, 20, bnq.a("lanServer.start")));
      this.n.add(new avs(102, this.l / 2 + 5, this.m - 28, 150, 20, bnq.a("gui.cancel")));
      this.n.add(this.g = new avs(104, this.l / 2 - 155, 100, 150, 20, bnq.a("selectWorld.gameMode")));
      this.n.add(this.f = new avs(103, this.l / 2 + 5, 100, 150, 20, bnq.a("selectWorld.allowCommands")));
      this.a();
   }
}
