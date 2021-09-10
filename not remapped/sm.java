import java.util.Iterator;
import java.util.List;

public class sm extends st {
   private boolean a;
   private final Class[] c;
   private int b;

   public void c() {
      this.e.d(this.e.bd());
      this.b = this.e.be();
      if (this.a) {
         double var1 = this.f();
         List var3 = this.e.o.a(this.e.getClass(), (new aug(this.e.s, this.e.t, this.e.u, this.e.s + 1.0D, this.e.t + 1.0D, this.e.u + 1.0D)).b(var1, 10.0D, var1));
         Iterator var4 = var3.iterator();

         label64:
         while(true) {
            py var5;
            do {
               do {
                  do {
                     if (!var4.hasNext()) {
                        break label64;
                     }

                     var5 = (py)var4.next();
                  } while(this.e == var5);
               } while(var5.u() != null);
            } while(var5.c(this.e.bd()));

            boolean var6 = false;
            Class[] var7 = this.c;
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               Class var10 = var7[var9];
               if (var5.getClass() == var10) {
                  var6 = true;
                  break;
               }
            }

            if (!var6) {
               this.a(var5, this.e.bd());
            }
         }
      }

      super.c();
   }

   protected void a(py var1, pr var2) {
      var1.d(var2);
   }

   public sm(py var1, boolean var2, Class... var3) {
      super(var1, false);
      this.a = var2;
      this.c = var3;
      this.a(1);
   }

   public boolean a() {
      int var1 = this.e.be();
      return var1 != this.b && this.a(this.e.bd(), false);
   }
}
