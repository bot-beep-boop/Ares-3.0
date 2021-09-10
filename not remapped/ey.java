import java.util.Iterator;

public class ey extends es {
   private final String b;

   public String g() {
      return this.b;
   }

   public ey(String var1) {
      this.b = var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ey)) {
         return false;
      } else {
         ey var2 = (ey)var1;
         return this.b.equals(var2.b) && super.equals(var1);
      }
   }

   public String e() {
      return this.b;
   }

   public eu f() {
      return this.h();
   }

   public String toString() {
      return "SelectorComponent{pattern='" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   public ey h() {
      ey var1 = new ey(this.b);
      var1.a(this.b().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.a(var3.f());
      }

      return var1;
   }
}
