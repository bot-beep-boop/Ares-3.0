public class ats implements Comparable<ats> {
   private final boolean e;
   private final long c;
   private final long d;
   private final boolean g;
   private final adp.a f;
   private final boolean h;
   private final String b;
   private final String a;

   public long e() {
      return this.c;
   }

   public long c() {
      return this.d;
   }

   public int compareTo(Object var1) {
      return this.a((ats)var1);
   }

   public ats(String var1, String var2, long var3, long var5, adp.a var7, boolean var8, boolean var9, boolean var10) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
      this.f = var7;
      this.e = var8;
      this.g = var9;
      this.h = var10;
   }

   public String a() {
      return this.a;
   }

   public boolean g() {
      return this.g;
   }

   public boolean d() {
      return this.e;
   }

   public boolean h() {
      return this.h;
   }

   public String b() {
      return this.b;
   }

   public adp.a f() {
      return this.f;
   }

   public int a(ats var1) {
      if (this.c < var1.c) {
         return 1;
      } else {
         return this.c > var1.c ? -1 : this.a.compareTo(var1.a);
      }
   }
}
