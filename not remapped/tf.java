import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public class tf {
   private cj d;
   private int l;
   private int e;
   private List<tf.a> k;
   private int h;
   private int i;
   private cj c;
   private int g;
   private int f;
   private adm a;
   private TreeMap<String, Integer> j;
   private final List<te> b = Lists.newArrayList();

   private void l() {
      Iterator var1 = this.k.iterator();

      while(true) {
         tf.a var2;
         do {
            if (!var1.hasNext()) {
               return;
            }

            var2 = (tf.a)var1.next();
         } while(var2.a.ai() && Math.abs(this.g - var2.b) <= 300);

         var1.remove();
      }
   }

   public te b(cj var1) {
      te var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         te var5 = (te)var4.next();
         int var6 = var5.a(var1);
         if (var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public int a(String var1, int var2) {
      int var3 = this.a(var1);
      int var4 = ns.a(var3 + var2, -30, 10);
      this.j.put(var1, var4);
      return var4;
   }

   public void a(te var1) {
      this.b.add(var1);
      this.c = this.c.a((df)var1.d());
      this.n();
      this.f = var1.h();
   }

   public te c(cj var1) {
      te var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         te var5 = (te)var4.next();
         int var6 = var5.a(var1);
         if (var6 > 256) {
            var6 *= 1000;
         } else {
            var6 = var5.c();
         }

         if (var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public tf() {
      this.c = cj.a;
      this.d = cj.a;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
   }

   public void a(adm var1) {
      this.a = var1;
   }

   public tf(adm var1) {
      this.c = cj.a;
      this.d = cj.a;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
      this.a = var1;
   }

   public void a(pr var1) {
      Iterator var2 = this.k.iterator();

      tf.a var3;
      do {
         if (!var2.hasNext()) {
            this.k.add(new tf.a(this, var1, this.g));
            return;
         }

         var3 = (tf.a)var2.next();
      } while(var3.a != var1);

      var3.b = this.g;
   }

   private void j() {
      List var1 = this.a.a(ty.class, new aug((double)(this.d.n() - this.e), (double)(this.d.o() - 4), (double)(this.d.p() - this.e), (double)(this.d.n() + this.e), (double)(this.d.o() + 4), (double)(this.d.p() + this.e)));
      this.l = var1.size();
   }

   private aui a(cj var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < 10; ++var5) {
         cj var6 = var1.a(this.a.s.nextInt(16) - 8, this.a.s.nextInt(6) - 3, this.a.s.nextInt(16) - 8);
         if (this.a(var6) && this.a(new cj(var2, var3, var4), var6)) {
            return new aui((double)var6.n(), (double)var6.o(), (double)var6.p());
         }
      }

      return null;
   }

   public void h() {
      this.i = this.g;
   }

   public void a(dn var1) {
      this.h = var1.f("PopSize");
      this.e = var1.f("Radius");
      this.l = var1.f("Golems");
      this.f = var1.f("Stable");
      this.g = var1.f("Tick");
      this.i = var1.f("MTick");
      this.d = new cj(var1.f("CX"), var1.f("CY"), var1.f("CZ"));
      this.c = new cj(var1.f("ACX"), var1.f("ACY"), var1.f("ACZ"));
      du var2 = var1.c("Doors", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         te var5 = new te(new cj(var4.f("X"), var4.f("Y"), var4.f("Z")), var4.f("IDX"), var4.f("IDZ"), var4.f("TS"));
         this.b.add(var5);
      }

      du var8 = var1.c("Players", 10);

      for(int var9 = 0; var9 < var8.c(); ++var9) {
         dn var10 = var8.b(var9);
         if (var10.c("UUID")) {
            lt var6 = MinecraftServer.N().aF();
            GameProfile var7 = var6.a(UUID.fromString(var10.j("UUID")));
            if (var7 != null) {
               this.j.put(var7.getName(), var10.f("S"));
            }
         } else {
            this.j.put(var10.j("Name"), var10.f("S"));
         }
      }

   }

   public boolean i() {
      return this.i == 0 || this.g - this.i >= 3600;
   }

   private boolean f(cj var1) {
      afh var2 = this.a.p(var1).c();
      if (var2 instanceof agh) {
         return var2.t() == arm.d;
      } else {
         return false;
      }
   }

   public void a(int var1) {
      this.g = var1;
      this.m();
      this.l();
      if (var1 % 20 == 0) {
         this.k();
      }

      if (var1 % 30 == 0) {
         this.j();
      }

      int var2 = this.h / 10;
      if (this.l < var2 && this.b.size() > 20 && this.a.s.nextInt(7000) == 0) {
         aui var3 = this.a(this.d, 2, 4, 2);
         if (var3 != null) {
            ty var4 = new ty(this.a);
            var4.b(var3.a, var3.b, var3.c);
            this.a.d((pk)var4);
            ++this.l;
         }
      }

   }

   public void b(dn var1) {
      var1.a("PopSize", this.h);
      var1.a("Radius", this.e);
      var1.a("Golems", this.l);
      var1.a("Stable", this.f);
      var1.a("Tick", this.g);
      var1.a("MTick", this.i);
      var1.a("CX", this.d.n());
      var1.a("CY", this.d.o());
      var1.a("CZ", this.d.p());
      var1.a("ACX", this.c.n());
      var1.a("ACY", this.c.o());
      var1.a("ACZ", this.c.p());
      du var2 = new du();
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         te var4 = (te)var3.next();
         dn var5 = new dn();
         var5.a("X", var4.d().n());
         var5.a("Y", var4.d().o());
         var5.a("Z", var4.d().p());
         var5.a("IDX", var4.f());
         var5.a("IDZ", var4.g());
         var5.a("TS", var4.h());
         var2.a((eb)var5);
      }

      var1.a((String)"Doors", (eb)var2);
      du var9 = new du();
      Iterator var10 = this.j.keySet().iterator();

      while(var10.hasNext()) {
         String var11 = (String)var10.next();
         dn var6 = new dn();
         lt var7 = MinecraftServer.N().aF();
         GameProfile var8 = var7.a(var11);
         if (var8 != null) {
            var6.a("UUID", var8.getId().toString());
            var6.a("S", (Integer)this.j.get(var11));
            var9.a((eb)var6);
         }
      }

      var1.a((String)"Players", (eb)var9);
   }

   private void k() {
      List var1 = this.a.a(wi.class, new aug((double)(this.d.n() - this.e), (double)(this.d.o() - 4), (double)(this.d.p() - this.e), (double)(this.d.n() + this.e), (double)(this.d.o() + 4), (double)(this.d.p() + this.e)));
      this.h = var1.size();
      if (this.h == 0) {
         this.j.clear();
      }

   }

   public int b() {
      return this.e;
   }

   public List<te> f() {
      return this.b;
   }

   private void m() {
      boolean var1 = false;
      boolean var2 = this.a.s.nextInt(50) == 0;
      Iterator var3 = this.b.iterator();

      while(true) {
         te var4;
         do {
            if (!var3.hasNext()) {
               if (var1) {
                  this.n();
               }

               return;
            }

            var4 = (te)var3.next();
            if (var2) {
               var4.a();
            }
         } while(this.f(var4.d()) && Math.abs(this.g - var4.h()) <= 1200);

         this.c = this.c.b(var4.d());
         var1 = true;
         var4.a(true);
         var3.remove();
      }
   }

   private boolean a(cj var1, cj var2) {
      if (!adm.a((adq)this.a, (cj)var2.b())) {
         return false;
      } else {
         int var3 = var2.n() - var1.n() / 2;
         int var4 = var2.p() - var1.p() / 2;

         for(int var5 = var3; var5 < var3 + var1.n(); ++var5) {
            for(int var6 = var2.o(); var6 < var2.o() + var1.o(); ++var6) {
               for(int var7 = var4; var7 < var4 + var1.p(); ++var7) {
                  if (this.a.p(new cj(var5, var6, var7)).c().v()) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   public cj a() {
      return this.d;
   }

   public pr b(pr var1) {
      double var2 = Double.MAX_VALUE;
      tf.a var4 = null;

      for(int var5 = 0; var5 < this.k.size(); ++var5) {
         tf.a var6 = (tf.a)this.k.get(var5);
         double var7 = var6.a.h(var1);
         if (!(var7 > var2)) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null ? var4.a : null;
   }

   public boolean g() {
      return this.b.isEmpty();
   }

   public int d() {
      return this.g - this.f;
   }

   public int e() {
      return this.h;
   }

   public void b(int var1) {
      Iterator var2 = this.j.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.a(var3, var1);
      }

   }

   private void n() {
      int var1 = this.b.size();
      if (var1 == 0) {
         this.d = new cj(0, 0, 0);
         this.e = 0;
      } else {
         this.d = new cj(this.c.n() / var1, this.c.o() / var1, this.c.p() / var1);
         int var2 = 0;

         te var4;
         for(Iterator var3 = this.b.iterator(); var3.hasNext(); var2 = Math.max(var4.a(this.d), var2)) {
            var4 = (te)var3.next();
         }

         this.e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }

   public te e(cj var1) {
      if (this.d.i(var1) > (double)(this.e * this.e)) {
         return null;
      } else {
         Iterator var2 = this.b.iterator();

         te var3;
         do {
            if (!var2.hasNext()) {
               return null;
            }

            var3 = (te)var2.next();
         } while(var3.d().n() != var1.n() || var3.d().p() != var1.p() || Math.abs(var3.d().o() - var1.o()) > 1);

         return var3;
      }
   }

   public int c() {
      return this.b.size();
   }

   public wn c(pr var1) {
      double var2 = Double.MAX_VALUE;
      wn var4 = null;
      Iterator var5 = this.j.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         if (this.d(var6)) {
            wn var7 = this.a.a(var6);
            if (var7 != null) {
               double var8 = var7.h(var1);
               if (!(var8 > var2)) {
                  var4 = var7;
                  var2 = var8;
               }
            }
         }
      }

      return var4;
   }

   public boolean d(String var1) {
      return this.a(var1) <= -15;
   }

   public boolean a(cj var1) {
      return this.d.i(var1) < (double)(this.e * this.e);
   }

   public int a(String var1) {
      Integer var2 = (Integer)this.j.get(var1);
      return var2 != null ? var2 : 0;
   }

   class a {
      public pr a;
      public int b;
      final tf c;

      a(tf var1, pr var2, int var3) {
         this.c = var1;
         this.a = var2;
         this.b = var3;
      }
   }
}
