import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class bow implements boq {
   protected final bgr f;
   protected final List<bgg> a;
   protected final boolean c;
   protected final bmi e;
   protected final boolean d;
   protected final List<List<bgg>> b;

   public boolean d() {
      return false;
   }

   public boolean b() {
      return this.c;
   }

   public bow(List<bgg> var1, List<List<bgg>> var2, boolean var3, boolean var4, bmi var5, bgr var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public List<bgg> a() {
      return this.a;
   }

   public boolean c() {
      return this.d;
   }

   public bgr f() {
      return this.f;
   }

   public bmi e() {
      return this.e;
   }

   public List<bgg> a(cq var1) {
      return (List)this.b.get(var1.ordinal());
   }

   public static class a {
      private boolean e;
      private bgr f;
      private final boolean c;
      private bmi d;
      private final List<bgg> a;
      private final List<List<bgg>> b;

      public a(boq var1, bmi var2) {
         this(var1.b(), var1.c(), var1.f());
         this.d = var1.e();
         cq[] var3 = cq.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            cq var6 = var3[var5];
            this.a(var1, var2, var6);
         }

         this.a(var1, var2);
      }

      private void a(boq var1, bmi var2) {
         Iterator var3 = var1.a().iterator();

         while(var3.hasNext()) {
            bgg var4 = (bgg)var3.next();
            this.a((bgg)(new bgn(var4, var2)));
         }

      }

      public bow.a a(cq var1, bgg var2) {
         ((List)this.b.get(var1.ordinal())).add(var2);
         return this;
      }

      private a(boolean var1, boolean var2, bgr var3) {
         this.a = Lists.newArrayList();
         this.b = Lists.newArrayListWithCapacity(6);
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var10000 = var4[var6];
            this.b.add(Lists.newArrayList());
         }

         this.c = var1;
         this.e = var2;
         this.f = var3;
      }

      public a(bgl var1) {
         this(var1.b(), var1.c(), var1.g());
      }

      public bow.a a(bmi var1) {
         this.d = var1;
         return this;
      }

      public boq b() {
         if (this.d == null) {
            throw new RuntimeException("Missing particle!");
         } else {
            return new bow(this.a, this.b, this.c, this.e, this.d, this.f);
         }
      }

      public bow.a a(bgg var1) {
         this.a.add(var1);
         return this;
      }

      private void a(boq var1, bmi var2, cq var3) {
         Iterator var4 = var1.a(var3).iterator();

         while(var4.hasNext()) {
            bgg var5 = (bgg)var4.next();
            this.a((cq)var3, (bgg)(new bgn(var5, var2)));
         }

      }
   }
}
