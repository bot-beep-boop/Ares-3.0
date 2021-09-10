import java.util.Iterator;

public class axe extends axu implements awx {
   private int a;
   private boolean f = false;

   protected void a(avs var1) {
      switch(var1.k) {
      case 0:
         this.j.h.cb();
         this.j.a((axu)null);
         break;
      case 1:
         if (this.j.f.P().t()) {
            this.j.a((axu)(new aya()));
         } else {
            awy var2 = new awy(this, bnq.a("deathScreen.quit.confirm"), "", bnq.a("deathScreen.titleScreen"), bnq.a("deathScreen.respawn"), 0);
            this.j.a((axu)var2);
            var2.b(20);
         }
      }

   }

   protected void a(char var1, int var2) {
   }

   public void a(int var1, int var2, float var3) {
      this.a(0, 0, this.l, this.m, 1615855616, -1602211792);
      bfl.E();
      bfl.a(2.0F, 2.0F, 2.0F);
      boolean var4 = this.j.f.P().t();
      String var5 = var4 ? bnq.a("deathScreen.title.hardcore") : bnq.a("deathScreen.title");
      this.a(this.q, var5, this.l / 2 / 2, 30, 16777215);
      bfl.F();
      if (var4) {
         this.a(this.q, bnq.a("deathScreen.hardcoreInfo"), this.l / 2, 144, 16777215);
      }

      this.a(this.q, bnq.a("deathScreen.score") + ": " + a.o + this.j.h.bX(), this.l / 2, 100, 16777215);
      super.a(var1, var2, var3);
   }

   public void e() {
      super.e();
      ++this.a;
      avs var2;
      if (this.a == 20) {
         for(Iterator var1 = this.n.iterator(); var1.hasNext(); var2.l = true) {
            var2 = (avs)var1.next();
         }
      }

   }

   public void a(boolean var1, int var2) {
      if (var1) {
         this.j.f.H();
         this.j.a((bdb)null);
         this.j.a((axu)(new aya()));
      } else {
         this.j.h.cb();
         this.j.a((axu)null);
      }

   }

   public boolean d() {
      return false;
   }

   public void b() {
      this.n.clear();
      if (this.j.f.P().t()) {
         if (this.j.E()) {
            this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 96, bnq.a("deathScreen.deleteWorld")));
         } else {
            this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 96, bnq.a("deathScreen.leaveServer")));
         }
      } else {
         this.n.add(new avs(0, this.l / 2 - 100, this.m / 4 + 72, bnq.a("deathScreen.respawn")));
         this.n.add(new avs(1, this.l / 2 - 100, this.m / 4 + 96, bnq.a("deathScreen.titleScreen")));
         if (this.j.L() == null) {
            ((avs)this.n.get(1)).l = false;
         }
      }

      avs var2;
      for(Iterator var1 = this.n.iterator(); var1.hasNext(); var2.l = false) {
         var2 = (avs)var1.next();
      }

   }
}
