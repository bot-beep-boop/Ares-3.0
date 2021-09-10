import net.minecraft.realms.RealmsBridge;

public class axp extends axu {
   private int f;
   private int a;

   public void e() {
      super.e();
      ++this.f;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("menu.game"), this.l / 2, 40, 16777215);
      super.a(var1, var2, var3);
   }

   protected void a(avs var1) {
      switch(var1.k) {
      case 0:
         this.j.a((axu)(new axn(this, this.j.t)));
         break;
      case 1:
         boolean var2 = this.j.E();
         boolean var3 = this.j.al();
         var1.l = false;
         this.j.f.H();
         this.j.a((bdb)null);
         if (var2) {
            this.j.a((axu)(new aya()));
         } else if (var3) {
            RealmsBridge var4 = new RealmsBridge();
            var4.switchToRealms(new aya());
         } else {
            this.j.a((axu)(new azh(new aya())));
         }
      case 2:
      case 3:
      default:
         break;
      case 4:
         this.j.a((axu)null);
         this.j.n();
         break;
      case 5:
         this.j.a((axu)(new aye(this, this.j.h.x())));
         break;
      case 6:
         this.j.a((axu)(new ayf(this, this.j.h.x())));
         break;
      case 7:
         this.j.a((axu)(new axw(this)));
      }

   }

   public void b() {
      this.a = 0;
      this.n.clear();
      byte var1 = -16;
      boolean var2 = true;
      this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 120 + var1, bnq.a("menu.returnToMenu")));
      if (!this.j.E()) {
         ((avs)this.n.get(0)).j = bnq.a("menu.disconnect");
      }

      this.n.add(new avs(4, this.l / 2 - 100, this.m / 4 + 24 + var1, bnq.a("menu.returnToGame")));
      this.n.add(new avs(0, this.l / 2 - 100, this.m / 4 + 96 + var1, 98, 20, bnq.a("menu.options")));
      avs var3;
      this.n.add(var3 = new avs(7, this.l / 2 + 2, this.m / 4 + 96 + var1, 98, 20, bnq.a("menu.shareToLan")));
      this.n.add(new avs(5, this.l / 2 - 100, this.m / 4 + 48 + var1, 98, 20, bnq.a("gui.achievements")));
      this.n.add(new avs(6, this.l / 2 + 2, this.m / 4 + 48 + var1, 98, 20, bnq.a("gui.stats")));
      var3.l = this.j.F() && !this.j.G().b();
   }
}
