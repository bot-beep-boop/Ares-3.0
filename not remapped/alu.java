import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class alu extends akw implements km {
   private List<pk> k = Lists.newArrayList();
   private float j;
   private boolean g;
   private boolean h;
   private cq f;
   private alz a;
   private float i;

   public alu(alz var1, cq var2, boolean var3, boolean var4) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
   }

   public float b(float var1) {
      return this.g ? (this.a(var1) - 1.0F) * (float)this.f.g() : (1.0F - this.a(var1)) * (float)this.f.g();
   }

   public alu() {
   }

   public float a(float var1) {
      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      return this.j + (this.i - this.j) * var1;
   }

   public boolean d() {
      return this.g;
   }

   public cq e() {
      return this.f;
   }

   public float d(float var1) {
      return this.g ? (this.a(var1) - 1.0F) * (float)this.f.i() : (1.0F - this.a(var1)) * (float)this.f.i();
   }

   public void h() {
      if (this.j < 1.0F && this.b != null) {
         this.j = this.i = 1.0F;
         this.b.t(this.c);
         this.y();
         if (this.b.p(this.c).c() == afi.M) {
            this.b.a((cj)this.c, (alz)this.a, 3);
            this.b.d(this.c, this.a.c());
         }
      }

   }

   public boolean g() {
      return this.h;
   }

   private void a(float var1, float var2) {
      if (this.g) {
         var1 = 1.0F - var1;
      } else {
         --var1;
      }

      aug var3 = afi.M.a(this.b, this.c, this.a, var1, this.f);
      if (var3 != null) {
         List var4 = this.b.b((pk)null, (aug)var3);
         if (!var4.isEmpty()) {
            this.k.addAll(var4);
            Iterator var5 = this.k.iterator();

            while(true) {
               while(var5.hasNext()) {
                  pk var6 = (pk)var5.next();
                  if (this.a.c() == afi.cE && this.g) {
                     switch(this.f.k()) {
                     case a:
                        var6.v = (double)this.f.g();
                        break;
                     case b:
                        var6.w = (double)this.f.h();
                        break;
                     case c:
                        var6.x = (double)this.f.i();
                     }
                  } else {
                     var6.d((double)(var2 * (float)this.f.g()), (double)(var2 * (float)this.f.h()), (double)(var2 * (float)this.f.i()));
                  }
               }

               this.k.clear();
               break;
            }
         }
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("blockId", afh.a(this.a.c()));
      var1.a("blockData", this.a.c().c(this.a));
      var1.a("facing", this.f.a());
      var1.a("progress", this.j);
      var1.a("extending", this.g);
   }

   public void a(dn var1) {
      super.a(var1);
      this.a = afh.c(var1.f("blockId")).a(var1.f("blockData"));
      this.f = cq.a(var1.f("facing"));
      this.j = this.i = var1.h("progress");
      this.g = var1.n("extending");
   }

   public alz b() {
      return this.a;
   }

   public int u() {
      return 0;
   }

   public void c() {
      this.j = this.i;
      if (this.j >= 1.0F) {
         this.a(1.0F, 0.25F);
         this.b.t(this.c);
         this.y();
         if (this.b.p(this.c).c() == afi.M) {
            this.b.a((cj)this.c, (alz)this.a, 3);
            this.b.d(this.c, this.a.c());
         }

      } else {
         this.i += 0.5F;
         if (this.i >= 1.0F) {
            this.i = 1.0F;
         }

         if (this.g) {
            this.a(this.i, this.i - this.j + 0.0625F);
         }

      }
   }

   public float c(float var1) {
      return this.g ? (this.a(var1) - 1.0F) * (float)this.f.h() : (1.0F - this.a(var1)) * (float)this.f.h();
   }
}
