import com.google.common.base.Predicate;
import java.util.Iterator;

public class ahr extends afh {
   public static final aml a;

   public int c(alz var1) {
      return ((cq)var1.b(a)).a();
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
   }

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

   protected ahr() {
      super(arm.q);
      this.j(this.M.b().a(a, cq.c));
      this.a(yz.c);
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() == this) {
         float var4 = 0.125F;
         switch((cq)var3.b(a)) {
         case c:
            this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
            break;
         case d:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
            break;
         case e:
            this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case f:
         default:
            this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
         }

      }
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      if (var3.k().c() && this.a(var1, var2, var3)) {
         return this.Q().a(a, var3);
      } else {
         Iterator var9 = cq.c.a.iterator();

         cq var10;
         do {
            if (!var9.hasNext()) {
               return this.Q();
            }

            var10 = (cq)var9.next();
         } while(!this.a(var1, var2, var10));

         return this.Q().a(a, var10);
      }
   }

   public boolean c() {
      return false;
   }

   protected boolean a(adm var1, cj var2, cq var3) {
      return var1.p(var2.a(var3.d())).c().v();
   }

   public adf m() {
      return adf.c;
   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   public boolean d() {
      return false;
   }

   public boolean d(adm var1, cj var2) {
      if (var1.p(var2.e()).c().v()) {
         return true;
      } else if (var1.p(var2.f()).c().v()) {
         return true;
      } else if (var1.p(var2.c()).c().v()) {
         return true;
      } else {
         return var1.p(var2.d()).c().v();
      }
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      cq var5 = (cq)var3.b(a);
      if (!this.a(var1, var2, var5)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }
}
