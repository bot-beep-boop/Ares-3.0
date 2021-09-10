import java.util.Comparator;
import java.util.List;

public class aum {
   private boolean g;
   private int e;
   public static final Comparator<aum> a = new Comparator<aum>() {
      public int compare(Object var1, Object var2) {
         return this.a((aum)var1, (aum)var2);
      }

      public int a(aum var1, aum var2) {
         if (var1.c() > var2.c()) {
            return 1;
         } else {
            return var1.c() < var2.c() ? -1 : var2.e().compareToIgnoreCase(var1.e());
         }
      }
   };
   private final String d;
   private boolean f;
   private final auo b;
   private final auk c;

   public boolean g() {
      return this.f;
   }

   public auk d() {
      return this.c;
   }

   public int c() {
      return this.e;
   }

   public void b(int var1) {
      if (this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.c(this.c() - var1);
      }
   }

   public void a(int var1) {
      if (this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.c(this.c() + var1);
      }
   }

   public String e() {
      return this.d;
   }

   public void a(List<wn> var1) {
      this.c(this.c.c().a(var1));
   }

   public void a() {
      if (this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.a(1);
      }
   }

   public void c(int var1) {
      int var2 = this.e;
      this.e = var1;
      if (var2 != var1 || this.g) {
         this.g = false;
         this.f().a(this);
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public aum(auo var1, auk var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.g = true;
   }

   public auo f() {
      return this.b;
   }
}
