import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class baf {
   private bag h = new bae();
   private int j;
   private final List<baj> g = Lists.newArrayList();
   private static final bah d = new baf.b(1, true);
   private static final bah b = new baf.a();
   private final bai f;
   public static final bah a = new bah() {
      public void a(baf var1) {
      }

      public eu A_() {
         return new fa("");
      }

      public boolean B_() {
         return false;
      }

      public void a(float var1, int var2) {
      }
   };
   private static final bah c = new baf.b(-1, true);
   private static final bah e = new baf.b(1, false);
   private int i = -1;

   public bah a(int var1) {
      int var2 = var1 + this.j * 6;
      if (this.j > 0 && var1 == 0) {
         return c;
      } else if (var1 == 7) {
         return var2 < this.h.a().size() ? d : e;
      } else if (var1 == 8) {
         return b;
      } else {
         return var2 >= 0 && var2 < this.h.a().size() ? (bah)Objects.firstNonNull(this.h.a().get(var2), a) : a;
      }
   }

   public void d() {
      this.f.a(this);
   }

   public baf(bai var1) {
      this.f = var1;
   }

   public void b(int var1) {
      bah var2 = this.a(var1);
      if (var2 != a) {
         if (this.i == var1 && var2.B_()) {
            var2.a(this);
         } else {
            this.i = var1;
         }
      }

   }

   public void a(bag var1) {
      this.g.add(this.f());
      this.h = var1;
      this.i = -1;
      this.j = 0;
   }

   public bag c() {
      return this.h;
   }

   public bah b() {
      return this.a(this.i);
   }

   public baj f() {
      return new baj(this.h, this.a(), this.i);
   }

   public int e() {
      return this.i;
   }

   public List<bah> a() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 <= 8; ++var2) {
         var1.add(this.a(var2));
      }

      return var1;
   }

   static int a(baf var0, int var1) {
      return var0.j += var1;
   }

   static class b implements bah {
      private final boolean b;
      private final int a;

      public void a(float var1, int var2) {
         ave.A().P().a(awm.a);
         if (this.a < 0) {
            avp.a(0, 0, 144.0F, 0.0F, 16, 16, 256.0F, 256.0F);
         } else {
            avp.a(0, 0, 160.0F, 0.0F, 16, 16, 256.0F, 256.0F);
         }

      }

      public boolean B_() {
         return this.b;
      }

      public void a(baf var1) {
         baf.a(var1, this.a);
      }

      public eu A_() {
         return this.a < 0 ? new fa("Previous Page") : new fa("Next Page");
      }

      public b(int var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   static class a implements bah {
      public boolean B_() {
         return true;
      }

      public eu A_() {
         return new fa("Close menu");
      }

      a(Object var1) {
         this();
      }

      private a() {
      }

      public void a(baf var1) {
         var1.d();
      }

      public void a(float var1, int var2) {
         ave.A().P().a(awm.a);
         avp.a(0, 0, 128.0F, 0.0F, 16, 16, 256.0F, 256.0F);
      }
   }
}
