import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

public class bdb extends adm {
   private final Set<adg> J = Sets.newHashSet();
   private final Set<pk> c = Sets.newHashSet();
   private final Set<pk> d = Sets.newHashSet();
   private final ave I = ave.A();
   private bcz b;
   private bcy a;

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public void b(long var1) {
      if (var1 < 0L) {
         var1 = -var1;
         this.Q().a("doDaylightCycle", "false");
      } else {
         this.Q().a("doDaylightCycle", "true");
      }

      super.b(var1);
   }

   public void b(int var1, int var2, int var3) {
      byte var4 = 16;
      Random var5 = new Random();
      zx var6 = this.I.h.bA();
      boolean var7 = this.I.c.l() == adp.a.c && var6 != null && afh.a(var6.b()) == afi.cv;
      cj.a var8 = new cj.a();

      for(int var9 = 0; var9 < 1000; ++var9) {
         int var10 = var1 + this.s.nextInt(var4) - this.s.nextInt(var4);
         int var11 = var2 + this.s.nextInt(var4) - this.s.nextInt(var4);
         int var12 = var3 + this.s.nextInt(var4) - this.s.nextInt(var4);
         var8.c(var10, var11, var12);
         alz var13 = this.p(var8);
         var13.c().c(this, var8, var13, var5);
         if (var7 && var13.c() == afi.cv) {
            this.a(cy.J, (double)((float)var10 + 0.5F), (double)((float)var11 + 0.5F), (double)((float)var12 + 0.5F), 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   public void a(int var1, pk var2) {
      pk var3 = this.a(var1);
      if (var3 != null) {
         this.e(var3);
      }

      this.c.add(var2);
      var2.d(var1);
      if (!this.d(var2)) {
         this.d.add(var2);
      }

      this.l.a(var1, var2);
   }

   public pk e(int var1) {
      pk var2 = (pk)this.l.d(var1);
      if (var2 != null) {
         this.c.remove(var2);
         this.e(var2);
      }

      return var2;
   }

   public void a(auo var1) {
      this.C = var1;
   }

   protected void b(pk var1) {
      super.b(var1);
      boolean var2 = false;
      if (this.c.contains(var1)) {
         if (var1.ai()) {
            this.d.add(var1);
            var2 = true;
         } else {
            this.c.remove(var1);
         }
      }

   }

   static Set b(bdb var0) {
      return var0.d;
   }

   public void c() {
      super.c();
      this.a(this.K() + 1L);
      if (this.Q().b("doDaylightCycle")) {
         this.b(this.L() + 1L);
      }

      this.B.a("reEntryProcessing");

      for(int var1 = 0; var1 < 10 && !this.d.isEmpty(); ++var1) {
         pk var2 = (pk)this.d.iterator().next();
         this.d.remove(var2);
         if (!this.f.contains(var2)) {
            this.d(var2);
         }
      }

      this.B.c("chunkCache");
      this.b.d();
      this.B.c("blocks");
      this.h();
      this.B.b();
   }

   protected int q() {
      return this.I.t.c;
   }

   public c a(b var1) {
      c var2 = super.a(var1);
      var2.a("Forced entities", new Callable<String>(this) {
         final bdb a;

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }

         public String a() {
            return bdb.a(this.a).size() + " total; " + bdb.a(this.a).toString();
         }
      });
      var2.a("Retry entities", new Callable<String>(this) {
         final bdb a;

         public String a() {
            return bdb.b(this.a).size() + " total; " + bdb.b(this.a).toString();
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var2.a("Server brand", new Callable<String>(this) {
         final bdb a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return bdb.c(this.a).h.w();
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var2.a("Server type", new Callable<String>(this) {
         final bdb a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return bdb.c(this.a).G() == null ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
         }
      });
      return var2;
   }

   protected amv k() {
      this.b = new bcz(this);
      return this.b;
   }

   public void a() {
      this.f.removeAll(this.g);

      int var1;
      pk var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.g.size(); ++var1) {
         var2 = (pk)this.g.get(var1);
         var3 = var2.ae;
         var4 = var2.ag;
         if (var2.ad && this.a(var3, var4, true)) {
            this.a(var3, var4).b(var2);
         }
      }

      for(var1 = 0; var1 < this.g.size(); ++var1) {
         this.b((pk)this.g.get(var1));
      }

      this.g.clear();

      for(var1 = 0; var1 < this.f.size(); ++var1) {
         var2 = (pk)this.f.get(var1);
         if (var2.m != null) {
            if (!var2.m.I && var2.m.l == var2) {
               continue;
            }

            var2.m.l = null;
            var2.m = null;
         }

         if (var2.I) {
            var3 = var2.ae;
            var4 = var2.ag;
            if (var2.ad && this.a(var3, var4, true)) {
               this.a(var3, var4).b(var2);
            }

            this.f.remove(var1--);
            this.b(var2);
         }
      }

   }

   static ave c(bdb var0) {
      return var0.I;
   }

   static Set a(bdb var0) {
      return var0.c;
   }

   public void a(cj var1, String var2, float var3, float var4, boolean var5) {
      this.a((double)var1.n() + 0.5D, (double)var1.o() + 0.5D, (double)var1.p() + 0.5D, var2, var3, var4, var5);
   }

   protected void a(pk var1) {
      super.a(var1);
      if (this.d.contains(var1)) {
         this.d.remove(var1);
      }

   }

   public boolean b(cj var1, alz var2) {
      int var3 = var1.n();
      int var4 = var1.o();
      int var5 = var1.p();
      this.a(var3, var4, var5, var3, var4, var5);
      return super.a((cj)var1, (alz)var2, 3);
   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
      double var11 = this.I.ac().e(var1, var3, var5);
      bpf var13 = new bpf(new jy(var7), var8, var9, (float)var1, (float)var3, (float)var5);
      if (var10 && var11 > 100.0D) {
         double var14 = Math.sqrt(var11) / 40.0D;
         this.I.W().a(var13, (int)(var14 * 20.0D));
      } else {
         this.I.W().a((bpj)var13);
      }

   }

   protected void p() {
   }

   public void a(double var1, double var3, double var5, double var7, double var9, double var11, dn var13) {
      this.I.j.a((beb)(new bdq.c(this, var1, var3, var5, var7, var9, var11, this.I.j, var13)));
   }

   public void e(pk var1) {
      super.e(var1);
      this.c.remove(var1);
   }

   public void b(int var1, int var2, boolean var3) {
      if (var3) {
         this.b.c(var1, var2);
      } else {
         this.b.b(var1, var2);
      }

      if (!var3) {
         this.b(var1 * 16, 0, var2 * 16, var1 * 16 + 15, 256, var2 * 16 + 15);
      }

   }

   protected void h() {
      super.h();
      this.J.retainAll(this.E);
      if (this.J.size() == this.E.size()) {
         this.J.clear();
      }

      int var1 = 0;
      Iterator var2 = this.E.iterator();

      while(var2.hasNext()) {
         adg var3 = (adg)var2.next();
         if (!this.J.contains(var3)) {
            int var4 = var3.a * 16;
            int var5 = var3.b * 16;
            this.B.a("getChunk");
            amy var6 = this.a(var3.a, var3.b);
            this.a(var4, var5, var6);
            this.B.b();
            this.J.add(var3);
            ++var1;
            if (var1 >= 10) {
               return;
            }
         }
      }

   }

   public boolean d(pk var1) {
      boolean var2 = super.d(var1);
      this.c.add(var1);
      if (!var2) {
         this.d.add(var1);
      } else if (var1 instanceof va) {
         this.I.W().a((bpj)(new bpd((va)var1)));
      }

      return var2;
   }

   public bdb(bcy var1, adp var2, int var3, oj var4, nt var5) {
      super(new atx(), new ato(var2, "MpServer"), anm.a(var3), var5, true);
      this.a = var1;
      this.P().a(var4);
      this.B(new cj(8, 64, 8));
      this.t.a(this);
      this.v = this.k();
      this.z = new atz();
      this.B();
      this.C();
   }

   public pk a(int var1) {
      return (pk)(var1 == this.I.h.F() ? this.I.h : super.a(var1));
   }

   public void H() {
      this.a.a().a((eu)(new fa("Quitting")));
   }
}
