import java.util.Random;

public class aim extends afh {
   public int a(int var1, Random var2) {
      if (var1 > 0 && zw.a((afh)this) != this.a((alz)this.P().a().iterator().next(), var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if (var3 < 0) {
            var3 = 0;
         }

         return this.a(var2) * (var3 + 1);
      } else {
         return this.a(var2);
      }
   }

   public int a(Random var1) {
      return this == afi.x ? 4 + var1.nextInt(5) : 1;
   }

   public int j(adm var1, cj var2) {
      return 0;
   }

   public int a(alz var1) {
      return this == afi.x ? zd.l.b() : 0;
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if (this.a(var3, var1.s, var5) != zw.a((afh)this)) {
         int var6 = 0;
         if (this == afi.q) {
            var6 = ns.a((Random)var1.s, 0, 2);
         } else if (this == afi.ag) {
            var6 = ns.a((Random)var1.s, 3, 7);
         } else if (this == afi.bP) {
            var6 = ns.a((Random)var1.s, 3, 7);
         } else if (this == afi.x) {
            var6 = ns.a((Random)var1.s, 2, 5);
         } else if (this == afi.co) {
            var6 = ns.a((Random)var1.s, 2, 5);
         }

         this.b(var1, var2, var6);
      }

   }

   public aim() {
      this(arm.e.r());
   }

   public aim(arn var1) {
      super(arm.e, var1);
      this.a((yz)yz.b);
   }

   public zw a(alz var1, Random var2, int var3) {
      if (this == afi.q) {
         return zy.h;
      } else if (this == afi.ag) {
         return zy.i;
      } else if (this == afi.x) {
         return zy.aW;
      } else if (this == afi.bP) {
         return zy.bO;
      } else {
         return this == afi.co ? zy.cg : zw.a((afh)this);
      }
   }
}
