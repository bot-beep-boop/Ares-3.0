import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

public class aul extends auq {
   private String f = "";
   private final Set<String> c = Sets.newHashSet();
   private String e = "";
   private String d;
   private final String b;
   private final auo a;
   private auq.a i;
   private auq.a j;
   private boolean h = true;
   private boolean g = true;
   private .a k;

   public void c(String var1) {
      this.f = var1;
      this.a.b(this);
   }

   public void a(.a var1) {
      this.k = var1;
   }

   public static String a(auq var0, String var1) {
      return var0 == null ? var1 : var0.d(var1);
   }

   public String b() {
      return this.b;
   }

   public Collection<String> d() {
      return this.c;
   }

   public void a(boolean var1) {
      this.g = var1;
      this.a.b(this);
   }

   public String c() {
      return this.d;
   }

   public boolean h() {
      return this.h;
   }

   public .a l() {
      return this.k;
   }

   public aul(auo var1, String var2) {
      this.i = auq.a.a;
      this.j = auq.a.a;
      this.k = .a.v;
      this.a = var1;
      this.b = var2;
      this.d = var2;
   }

   public void a(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Name cannot be null");
      } else {
         this.d = var1;
         this.a.b(this);
      }
   }

   public String f() {
      return this.f;
   }

   public void a(int var1) {
      this.a((var1 & 1) > 0);
      this.b((var1 & 2) > 0);
   }

   public auq.a j() {
      return this.j;
   }

   public void b(boolean var1) {
      this.h = var1;
      this.a.b(this);
   }

   public String d(String var1) {
      return this.e() + var1 + this.f();
   }

   public void a(auq.a var1) {
      this.i = var1;
      this.a.b(this);
   }

   public void b(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Prefix cannot be null");
      } else {
         this.e = var1;
         this.a.b(this);
      }
   }

   public boolean g() {
      return this.g;
   }

   public auq.a i() {
      return this.i;
   }

   public int k() {
      int var1 = 0;
      if (this.g()) {
         var1 |= 1;
      }

      if (this.h()) {
         var1 |= 2;
      }

      return var1;
   }

   public String e() {
      return this.e;
   }

   public void b(auq.a var1) {
      this.j = var1;
      this.a.b(this);
   }
}
