import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ov {
   private int c;
   private String h;
   private int e;
   private boolean f;
   private int d;
   private final List<ou> a = Lists.newArrayList();
   private final pr b;
   private boolean g;

   public void a(ow var1, float var2, float var3) {
      this.g();
      this.a();
      ou var4 = new ou(var1, this.b.W, var2, var3, this.h, this.b.O);
      this.a.add(var4);
      this.c = this.b.W;
      this.g = true;
      if (var4.f() && !this.f && this.b.ai()) {
         this.f = true;
         this.d = this.b.W;
         this.e = this.d;
         this.b.h_();
      }

   }

   public ov(pr var1) {
      this.b = var1;
   }

   public eu b() {
      if (this.a.size() == 0) {
         return new fb("death.attack.generic", new Object[]{this.b.f_()});
      } else {
         ou var1 = this.i();
         ou var2 = (ou)this.a.get(this.a.size() - 1);
         eu var4 = var2.h();
         pk var5 = var2.a().j();
         Object var3;
         if (var1 != null && var2.a() == ow.i) {
            eu var6 = var1.h();
            if (var1.a() != ow.i && var1.a() != ow.j) {
               if (var6 == null || var4 != null && var6.equals(var4)) {
                  if (var4 != null) {
                     zx var9 = var5 instanceof pr ? ((pr)var5).bA() : null;
                     if (var9 != null && var9.s()) {
                        var3 = new fb("death.fell.finish.item", new Object[]{this.b.f_(), var4, var9.C()});
                     } else {
                        var3 = new fb("death.fell.finish", new Object[]{this.b.f_(), var4});
                     }
                  } else {
                     var3 = new fb("death.fell.killer", new Object[]{this.b.f_()});
                  }
               } else {
                  pk var7 = var1.a().j();
                  zx var8 = var7 instanceof pr ? ((pr)var7).bA() : null;
                  if (var8 != null && var8.s()) {
                     var3 = new fb("death.fell.assist.item", new Object[]{this.b.f_(), var6, var8.C()});
                  } else {
                     var3 = new fb("death.fell.assist", new Object[]{this.b.f_(), var6});
                  }
               }
            } else {
               var3 = new fb("death.fell.accident." + this.a(var1), new Object[]{this.b.f_()});
            }
         } else {
            var3 = var2.a().b(this.b);
         }

         return (eu)var3;
      }
   }

   public pr c() {
      pr var1 = null;
      wn var2 = null;
      float var3 = 0.0F;
      float var4 = 0.0F;
      Iterator var5 = this.a.iterator();

      while(true) {
         ou var6;
         do {
            do {
               if (!var5.hasNext()) {
                  if (var2 != null && var4 >= var3 / 3.0F) {
                     return var2;
                  }

                  return var1;
               }

               var6 = (ou)var5.next();
               if (var6.a().j() instanceof wn && (var2 == null || var6.c() > var4)) {
                  var4 = var6.c();
                  var2 = (wn)var6.a().j();
               }
            } while(!(var6.a().j() instanceof pr));
         } while(var1 != null && !(var6.c() > var3));

         var3 = var6.c();
         var1 = (pr)var6.a().j();
      }
   }

   private String a(ou var1) {
      return var1.g() == null ? "generic" : var1.g();
   }

   private ou i() {
      ou var1 = null;
      ou var2 = null;
      byte var3 = 0;
      float var4 = 0.0F;

      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         ou var6 = (ou)this.a.get(var5);
         ou var7 = var5 > 0 ? (ou)this.a.get(var5 - 1) : null;
         if ((var6.a() == ow.i || var6.a() == ow.j) && var6.i() > 0.0F && (var1 == null || var6.i() > var4)) {
            if (var5 > 0) {
               var1 = var7;
            } else {
               var1 = var6;
            }

            var4 = var6.i();
         }

         if (var6.g() != null && (var2 == null || var6.c() > (float)var3)) {
            var2 = var6;
         }
      }

      if (var4 > 5.0F && var1 != null) {
         return var1;
      } else if (var3 > 5 && var2 != null) {
         return var2;
      } else {
         return null;
      }
   }

   private void j() {
      this.h = null;
   }

   public pr h() {
      return this.b;
   }

   public void a() {
      this.j();
      if (this.b.k_()) {
         afh var1 = this.b.o.p(new cj(this.b.s, this.b.aR().b, this.b.u)).c();
         if (var1 == afi.au) {
            this.h = "ladder";
         } else if (var1 == afi.bn) {
            this.h = "vines";
         }
      } else if (this.b.V()) {
         this.h = "water";
      }

   }

   public int f() {
      return this.f ? this.b.W - this.d : this.e - this.d;
   }

   public void g() {
      int var1 = this.f ? 300 : 100;
      if (this.g && (!this.b.ai() || this.b.W - this.c > var1)) {
         boolean var2 = this.f;
         this.g = false;
         this.f = false;
         this.e = this.b.W;
         if (var2) {
            this.b.j();
         }

         this.a.clear();
      }

   }
}
