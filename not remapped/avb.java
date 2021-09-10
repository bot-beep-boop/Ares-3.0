import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class avb implements Comparable<avb> {
   private static final nm<avb> b = new nm();
   private static final Set<String> c = Sets.newHashSet();
   private final String f;
   private static final List<avb> a = Lists.newArrayList();
   private int g;
   private final String d;
   private int i;
   private boolean h;
   private final int e;

   public static void a(int var0) {
      if (var0 != 0) {
         avb var1 = (avb)b.a(var0);
         if (var1 != null) {
            ++var1.i;
         }

      }
   }

   public int i() {
      return this.g;
   }

   public String g() {
      return this.d;
   }

   public void b(int var1) {
      this.g = var1;
   }

   public static void a() {
      Iterator var0 = a.iterator();

      while(var0.hasNext()) {
         avb var1 = (avb)var0.next();
         var1.j();
      }

   }

   public int compareTo(Object var1) {
      return this.a((avb)var1);
   }

   public int h() {
      return this.e;
   }

   public static Set<String> c() {
      return c;
   }

   public static void b() {
      b.c();
      Iterator var0 = a.iterator();

      while(var0.hasNext()) {
         avb var1 = (avb)var0.next();
         b.a(var1.g, var1);
      }

   }

   public boolean d() {
      return this.h;
   }

   public avb(String var1, int var2, String var3) {
      this.d = var1;
      this.g = var2;
      this.e = var2;
      this.f = var3;
      a.add(this);
      b.a(var2, this);
      c.add(var3);
   }

   public boolean f() {
      if (this.i == 0) {
         return false;
      } else {
         --this.i;
         return true;
      }
   }

   public String e() {
      return this.f;
   }

   private void j() {
      this.i = 0;
      this.h = false;
   }

   public static void a(int var0, boolean var1) {
      if (var0 != 0) {
         avb var2 = (avb)b.a(var0);
         if (var2 != null) {
            var2.h = var1;
         }

      }
   }

   public int a(avb var1) {
      int var2 = bnq.a(this.f).compareTo(bnq.a(var1.f));
      if (var2 == 0) {
         var2 = bnq.a(this.d).compareTo(bnq.a(var1.d));
      }

      return var2;
   }
}
