import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class azl extends awd {
   private final azh u;
   private final List<azk> v = Lists.newArrayList();
   private int y = -1;
   private final List<azj> w = Lists.newArrayList();
   private final awd.a x = new azi();

   public void a(List<bpq.a> var1) {
      this.w.clear();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bpq.a var3 = (bpq.a)var2.next();
         this.w.add(new azj(this.u, var3));
      }

   }

   public int c() {
      return super.c() + 85;
   }

   public void a(bdf var1) {
      this.v.clear();

      for(int var2 = 0; var2 < var1.c(); ++var2) {
         this.v.add(new azk(this.u, var1.a(var2)));
      }

   }

   public void c(int var1) {
      this.y = var1;
   }

   protected boolean a(int var1) {
      return var1 == this.y;
   }

   protected int b() {
      return this.v.size() + 1 + this.w.size();
   }

   public azl(azh var1, ave var2, int var3, int var4, int var5, int var6, int var7) {
      super(var2, var3, var4, var5, var6, var7);
      this.u = var1;
   }

   public awd.a b(int var1) {
      if (var1 < this.v.size()) {
         return (awd.a)this.v.get(var1);
      } else {
         var1 -= this.v.size();
         if (var1 == 0) {
            return this.x;
         } else {
            --var1;
            return (awd.a)this.w.get(var1);
         }
      }
   }

   public int e() {
      return this.y;
   }

   protected int d() {
      return super.d() + 30;
   }
}
