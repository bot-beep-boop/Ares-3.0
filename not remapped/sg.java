import java.util.Iterator;
import java.util.List;

public class sg extends rd {
   private boolean d;
   private ty b;
   private int c;
   private wi a;

   public void e() {
      this.a.p().a(this.b, 30.0F, 30.0F);
      if (this.b.cm() == this.c) {
         this.a.s().a((pk)this.b, 0.5D);
         this.d = true;
      }

      if (this.d && this.a.h(this.b) < 4.0D) {
         this.b.a(false);
         this.a.s().n();
      }

   }

   public sg(wi var1) {
      this.a = var1;
      this.a(3);
   }

   public void d() {
      this.b = null;
      this.a.s().n();
   }

   public boolean a() {
      if (this.a.l() >= 0) {
         return false;
      } else if (!this.a.o.w()) {
         return false;
      } else {
         List var1 = this.a.o.a(ty.class, this.a.aR().b(6.0D, 2.0D, 6.0D));
         if (var1.isEmpty()) {
            return false;
         } else {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               ty var3 = (ty)var2.next();
               if (var3.cm() > 0) {
                  this.b = var3;
                  break;
               }
            }

            return this.b != null;
         }
      }
   }

   public void c() {
      this.c = this.a.bc().nextInt(320);
      this.d = false;
      this.b.s().n();
   }

   public boolean b() {
      return this.b.cm() > 0;
   }
}
