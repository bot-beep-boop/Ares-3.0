import com.google.common.base.Predicate;
import java.util.Random;

public class afa extends afc {
   public static final aml a;
   public static final amn b;

   public boolean c() {
      return false;
   }

   public boolean d(adm var1, cj var2) {
      return !this.e(var1, var2) && super.d(var1, var2);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.cE;
   }

   public boolean d() {
      return false;
   }

   protected afa() {
      super(arm.d);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public String f() {
      return di.a("item.banner.white.name");
   }

   public boolean g() {
      return true;
   }

   public akw a(adm var1, int var2) {
      return new aku();
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amn.a("rotation", 0, 15);
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      akw var6 = var1.s(var2);
      if (var6 instanceof aku) {
         zx var7 = new zx(zy.cE, 1, ((aku)var6).b());
         dn var8 = new dn();
         var6.b(var8);
         var8.o("x");
         var8.o("y");
         var8.o("z");
         var8.o("id");
         var7.a((String)"BlockEntityTag", (eb)var8);
         a(var1, var2, var7);
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public zw c(adm var1, cj var2) {
      return zy.cE;
   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   public boolean b(adq var1, cj var2) {
      return true;
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (var5 instanceof aku) {
         aku var6 = (aku)var5;
         zx var7 = new zx(zy.cE, 1, ((aku)var5).b());
         dn var8 = new dn();
         aku.a(var8, var6.b(), var6.d());
         var7.a((String)"BlockEntityTag", (eb)var8);
         a(var1, var3, var7);
      } else {
         super.a(var1, var2, var3, var4, (akw)null);
      }

   }

   public static class b extends afa {
      protected ama e() {
         return new ama(this, new amo[]{a});
      }

      public alz a(int var1) {
         cq var2 = cq.a(var1);
         if (var2.k() == cq.a.b) {
            var2 = cq.c;
         }

         return this.Q().a(a, var2);
      }

      public void a(adq var1, cj var2) {
         cq var3 = (cq)var1.p(var2).b(a);
         float var4 = 0.0F;
         float var5 = 0.78125F;
         float var6 = 0.0F;
         float var7 = 1.0F;
         float var8 = 0.125F;
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         switch(var3) {
         case c:
         default:
            this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
            break;
         case d:
            this.a(var6, var4, 0.0F, var7, var5, var8);
            break;
         case e:
            this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
            break;
         case f:
            this.a(0.0F, var4, var6, var8, var5, var7);
         }

      }

      public int c(alz var1) {
         return ((cq)var1.b(a)).a();
      }

      public b() {
         this.j(this.M.b().a(a, cq.c));
      }

      public void a(adm var1, cj var2, alz var3, afh var4) {
         cq var5 = (cq)var3.b(a);
         if (!var1.p(var2.a(var5.d())).c().t().a()) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         super.a(var1, var2, var3, var4);
      }
   }

   public static class a extends afa {
      public alz a(int var1) {
         return this.Q().a(b, var1);
      }

      public void a(adm var1, cj var2, alz var3, afh var4) {
         if (!var1.p(var2.b()).c().t().a()) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         super.a(var1, var2, var3, var4);
      }

      public a() {
         this.j(this.M.b().a(b, 0));
      }

      protected ama e() {
         return new ama(this, new amo[]{b});
      }

      public int c(alz var1) {
         return (Integer)var1.b(b);
      }
   }
}
