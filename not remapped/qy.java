import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class qy extends rd {
   private static final Predicate<alz> b;
   int a;
   private adm d;
   private ps c;

   static {
      b = amh.a((afh)afi.H).a(akc.a, Predicates.equalTo(akc.a.b));
   }

   public int f() {
      return this.a;
   }

   public qy(ps var1) {
      this.c = var1;
      this.d = var1.o;
      this.a(7);
   }

   public boolean a() {
      if (this.c.bc().nextInt(this.c.j_() ? 50 : 1000) != 0) {
         return false;
      } else {
         cj var1 = new cj(this.c.s, this.c.t, this.c.u);
         if (b.apply(this.d.p(var1))) {
            return true;
         } else {
            return this.d.p(var1.b()).c() == afi.c;
         }
      }
   }

   public boolean b() {
      return this.a > 0;
   }

   public void d() {
      this.a = 0;
   }

   public void e() {
      this.a = Math.max(0, this.a - 1);
      if (this.a == 4) {
         cj var1 = new cj(this.c.s, this.c.t, this.c.u);
         if (b.apply(this.d.p(var1))) {
            if (this.d.Q().b("mobGriefing")) {
               this.d.b(var1, false);
            }

            this.c.v();
         } else {
            cj var2 = var1.b();
            if (this.d.p(var2).c() == afi.c) {
               if (this.d.Q().b("mobGriefing")) {
                  this.d.b(2001, var2, afh.a((afh)afi.c));
                  this.d.a((cj)var2, (alz)afi.d.Q(), 2);
               }

               this.c.v();
            }
         }

      }
   }

   public void c() {
      this.a = 40;
      this.d.a((pk)this.c, (byte)10);
      this.c.s().n();
   }
}
