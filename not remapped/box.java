import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class box implements boq {
   private final boq c;
   private final int a;
   private final List<box.b> b;

   public bmi e() {
      return this.c.e();
   }

   public List<bgg> a() {
      return this.c.a();
   }

   public bgr f() {
      return this.c.f();
   }

   public boolean c() {
      return this.c.c();
   }

   public boq a(long var1) {
      return ((box.b)oa.a(this.b, Math.abs((int)var1 >> 16) % this.a)).b;
   }

   public boolean d() {
      return this.c.d();
   }

   public box(List<box.b> var1) {
      this.b = var1;
      this.a = oa.a(var1);
      this.c = ((box.b)var1.get(0)).b;
   }

   public List<bgg> a(cq var1) {
      return this.c.a(var1);
   }

   public boolean b() {
      return this.c.b();
   }

   public static class a {
      private List<box.b> a = Lists.newArrayList();

      public boq b() {
         return ((box.b)this.a.get(0)).b;
      }

      public box a() {
         Collections.sort(this.a);
         return new box(this.a);
      }

      public box.a a(boq var1, int var2) {
         this.a.add(new box.b(var1, var2));
         return this;
      }
   }

   static class b extends oa.a implements Comparable<box.b> {
      protected final boq b;

      public b(boq var1, int var2) {
         super(var2);
         this.b = var1;
      }

      public int compareTo(Object var1) {
         return this.a((box.b)var1);
      }

      public int a(box.b var1) {
         return ComparisonChain.start().compare(var1.a, this.a).compare(this.a(), var1.a()).result();
      }

      protected int a() {
         int var1 = this.b.a().size();
         cq[] var2 = cq.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            cq var5 = var2[var4];
            var1 += this.b.a(var5).size();
         }

         return var1;
      }

      public String toString() {
         return "MyWeighedRandomItem{weight=" + this.a + ", model=" + this.b + '}';
      }
   }
}
