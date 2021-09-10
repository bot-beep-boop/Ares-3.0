import java.util.Random;

public class alc extends alk implements og {
   private zx[] g = new zx[9];
   private static final Random f = new Random();
   protected String a;

   public void a(int var1, zx var2) {
      this.g[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      this.p_();
   }

   public void a(String var1) {
      this.a = var1;
   }

   public zx a(int var1, int var2) {
      if (this.g[var1] != null) {
         zx var3;
         if (this.g[var1].b <= var2) {
            var3 = this.g[var1];
            this.g[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.g[var1].a(var2);
            if (this.g[var1].b == 0) {
               this.g[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public void b(dn var1) {
      super.b(var1);
      du var2 = new du();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if (this.g[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.g[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
      if (this.l_()) {
         var1.a("CustomName", this.a);
      }

   }

   public zx a(int var1) {
      return this.g[var1];
   }

   public boolean l_() {
      return this.a != null;
   }

   public void b(int var1, int var2) {
   }

   public int m() {
      int var1 = -1;
      int var2 = 1;

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if (this.g[var3] != null && f.nextInt(var2++) == 0) {
            var1 = var3;
         }
      }

      return var1;
   }

   public void b(wn var1) {
   }

   public int a_(int var1) {
      return 0;
   }

   public boolean a(wn var1) {
      if (this.b.s(this.c) != this) {
         return false;
      } else {
         return !(var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) > 64.0D);
      }
   }

   public zx b(int var1) {
      if (this.g[var1] != null) {
         zx var2 = this.g[var1];
         this.g[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public xi a(wm var1, wn var2) {
      return new xr(var1, this);
   }

   public int a(zx var1) {
      for(int var2 = 0; var2 < this.g.length; ++var2) {
         if (this.g[var2] == null || this.g[var2].b() == null) {
            this.a(var2, var1);
            return var2;
         }
      }

      return -1;
   }

   public void l() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         this.g[var1] = null;
      }

   }

   public int q_() {
      return 64;
   }

   public int o_() {
      return 9;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public void c(wn var1) {
   }

   public void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.g = new zx[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         int var5 = var4.d("Slot") & 255;
         if (var5 >= 0 && var5 < this.g.length) {
            this.g[var5] = zx.a(var4);
         }
      }

      if (var1.b("CustomName", 8)) {
         this.a = var1.j("CustomName");
      }

   }

   public int g() {
      return 0;
   }

   public String k() {
      return "minecraft:dispenser";
   }

   public String e_() {
      return this.l_() ? this.a : "container.dispenser";
   }
}
