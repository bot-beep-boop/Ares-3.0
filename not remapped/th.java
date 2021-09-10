import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class th extends ate {
   private adm b;
   private int f;
   private final List<tf> e = Lists.newArrayList();
   private final List<te> d = Lists.newArrayList();
   private final List<cj> c = Lists.newArrayList();

   public void a(adm var1) {
      this.b = var1;
      Iterator var2 = this.e.iterator();

      while(var2.hasNext()) {
         tf var3 = (tf)var2.next();
         var3.a(var1);
      }

   }

   private int a(cj var1, cq var2, int var3) {
      int var4 = 0;

      for(int var5 = 1; var5 <= 5; ++var5) {
         if (this.b.i(var1.a(var2, var5))) {
            ++var4;
            if (var4 >= var3) {
               return var4;
            }
         }
      }

      return var4;
   }

   public th(adm var1) {
      super(a(var1.t));
      this.b = var1;
      this.c();
   }

   private void d(cj var1) {
      cq var2 = agh.h(this.b, var1);
      cq var3 = var2.d();
      int var4 = this.a(var1, var2, 5);
      int var5 = this.a(var1, var3, var4 + 1);
      if (var4 != var5) {
         this.d.add(new te(var1, var4 < var5 ? var2 : var3, this.f));
      }

   }

   public void a(cj var1) {
      if (this.c.size() <= 64) {
         if (!this.e(var1)) {
            this.c.add(var1);
         }

      }
   }

   private void b(cj var1) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = -var2; var5 < var2; ++var5) {
         for(int var6 = -var3; var6 < var3; ++var6) {
            for(int var7 = -var4; var7 < var4; ++var7) {
               cj var8 = var1.a(var5, var6, var7);
               if (this.f(var8)) {
                  te var9 = this.c(var8);
                  if (var9 == null) {
                     this.d(var8);
                  } else {
                     var9.a(this.f);
                  }
               }
            }
         }
      }

   }

   public void b(dn var1) {
      var1.a("Tick", this.f);
      du var2 = new du();
      Iterator var3 = this.e.iterator();

      while(var3.hasNext()) {
         tf var4 = (tf)var3.next();
         dn var5 = new dn();
         var4.b(var5);
         var2.a((eb)var5);
      }

      var1.a((String)"Villages", (eb)var2);
   }

   public List<tf> b() {
      return this.e;
   }

   private boolean e(cj var1) {
      Iterator var2 = this.c.iterator();

      cj var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (cj)var2.next();
      } while(!var3.equals(var1));

      return true;
   }

   private void e() {
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         tf var2 = (tf)var1.next();
         if (var2.g()) {
            var1.remove();
            this.c();
         }
      }

   }

   private void f() {
      if (!this.c.isEmpty()) {
         this.b((cj)this.c.remove(0));
      }
   }

   private void g() {
      for(int var1 = 0; var1 < this.d.size(); ++var1) {
         te var2 = (te)this.d.get(var1);
         tf var3 = this.a(var2.d(), 32);
         if (var3 == null) {
            var3 = new tf(this.b);
            this.e.add(var3);
            this.c();
         }

         var3.a(var2);
      }

      this.d.clear();
   }

   public tf a(cj var1, int var2) {
      tf var3 = null;
      double var4 = 3.4028234663852886E38D;
      Iterator var6 = this.e.iterator();

      while(var6.hasNext()) {
         tf var7 = (tf)var6.next();
         double var8 = var7.a().i(var1);
         if (!(var8 >= var4)) {
            float var10 = (float)(var2 + var7.b());
            if (!(var8 > (double)(var10 * var10))) {
               var3 = var7;
               var4 = var8;
            }
         }
      }

      return var3;
   }

   public th(String var1) {
      super(var1);
   }

   public void a() {
      ++this.f;
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         tf var2 = (tf)var1.next();
         var2.a(this.f);
      }

      this.e();
      this.f();
      this.g();
      if (this.f % 400 == 0) {
         this.c();
      }

   }

   private te c(cj var1) {
      Iterator var2 = this.d.iterator();

      te var3;
      do {
         if (!var2.hasNext()) {
            var2 = this.e.iterator();

            te var4;
            do {
               if (!var2.hasNext()) {
                  return null;
               }

               tf var5 = (tf)var2.next();
               var4 = var5.e(var1);
            } while(var4 == null);

            return var4;
         }

         var3 = (te)var2.next();
      } while(var3.d().n() != var1.n() || var3.d().p() != var1.p() || Math.abs(var3.d().o() - var1.o()) > 1);

      return var3;
   }

   private boolean f(cj var1) {
      afh var2 = this.b.p(var1).c();
      if (var2 instanceof agh) {
         return var2.t() == arm.d;
      } else {
         return false;
      }
   }

   public static String a(anm var0) {
      return "villages" + var0.l();
   }

   public void a(dn var1) {
      this.f = var1.f("Tick");
      du var2 = var1.c("Villages", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         tf var5 = new tf();
         var5.a(var4);
         this.e.add(var5);
      }

   }
}
