import java.util.Random;

public class ale extends akw implements ol, km {
   public float j;
   public float k;
   public float f;
   public int a;
   public float n;
   public float g;
   private static Random o = new Random();
   public float m;
   public float h;
   public float i;
   private String p;
   public float l;

   public String e_() {
      return this.l_() ? this.p : "container.enchant";
   }

   public void b(dn var1) {
      super.b(var1);
      if (this.l_()) {
         var1.a("CustomName", this.p);
      }

   }

   public boolean l_() {
      return this.p != null && this.p.length() > 0;
   }

   public void a(String var1) {
      this.p = var1;
   }

   public String k() {
      return "minecraft:enchanting_table";
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public xi a(wm var1, wn var2) {
      return new xs(var1, this.b, this.c);
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("CustomName", 8)) {
         this.p = var1.j("CustomName");
      }

   }

   public void c() {
      this.k = this.j;
      this.m = this.l;
      wn var1 = this.b.a((double)((float)this.c.n() + 0.5F), (double)((float)this.c.o() + 0.5F), (double)((float)this.c.p() + 0.5F), 3.0D);
      if (var1 != null) {
         double var2 = var1.s - (double)((float)this.c.n() + 0.5F);
         double var4 = var1.u - (double)((float)this.c.p() + 0.5F);
         this.n = (float)ns.b(var4, var2);
         this.j += 0.1F;
         if (this.j < 0.5F || o.nextInt(40) == 0) {
            float var6 = this.h;

            do {
               this.h += (float)(o.nextInt(4) - o.nextInt(4));
            } while(var6 == this.h);
         }
      } else {
         this.n += 0.02F;
         this.j -= 0.1F;
      }

      while(this.l >= 3.1415927F) {
         this.l -= 6.2831855F;
      }

      while(this.l < -3.1415927F) {
         this.l += 6.2831855F;
      }

      while(this.n >= 3.1415927F) {
         this.n -= 6.2831855F;
      }

      while(this.n < -3.1415927F) {
         this.n += 6.2831855F;
      }

      float var7;
      for(var7 = this.n - this.l; var7 >= 3.1415927F; var7 -= 6.2831855F) {
      }

      while(var7 < -3.1415927F) {
         var7 += 6.2831855F;
      }

      this.l += var7 * 0.4F;
      this.j = ns.a(this.j, 0.0F, 1.0F);
      ++this.a;
      this.g = this.f;
      float var3 = (this.h - this.f) * 0.4F;
      float var8 = 0.2F;
      var3 = ns.a(var3, -var8, var8);
      this.i += (var3 - this.i) * 0.9F;
      this.f += this.i;
   }
}
