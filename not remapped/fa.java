import java.util.Iterator;

public class fa extends es {
   private final String b;

   public fa(String var1) {
      this.b = var1;
   }

   public String g() {
      return this.b;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof fa)) {
         return false;
      } else {
         fa var2 = (fa)var1;
         return this.b.equals(var2.g()) && super.equals(var1);
      }
   }

   public String toString() {
      return "TextComponent{text='" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   public fa h() {
      fa var1 = new fa(this.b);
      var1.a(this.b().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.a(var3.f());
      }

      return var1;
   }

   public String e() {
      return this.b;
   }

   public eu f() {
      return this.h();
   }
}
