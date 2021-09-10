import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bpy implements bqb<bpw> {
   private final Random b = new Random();
   private double f;
   private double e;
   private final bpg d;
   private final List<bqb<bpw>> a = Lists.newArrayList();
   private final jy c;

   public void a(bqb<bpw> var1) {
      this.a.add(var1);
   }

   public bpg d() {
      return this.d;
   }

   public bpw b() {
      int var1 = this.a();
      if (!this.a.isEmpty() && var1 != 0) {
         int var2 = this.b.nextInt(var1);
         Iterator var3 = this.a.iterator();

         bqb var4;
         do {
            if (!var3.hasNext()) {
               return bpz.a;
            }

            var4 = (bqb)var3.next();
            var2 -= var4.a();
         } while(var2 >= 0);

         bpw var5 = (bpw)var4.g();
         var5.a(var5.b() * this.e);
         var5.b(var5.c() * this.f);
         return var5;
      } else {
         return bpz.a;
      }
   }

   public jy c() {
      return this.c;
   }

   public int a() {
      int var1 = 0;

      bqb var3;
      for(Iterator var2 = this.a.iterator(); var2.hasNext(); var1 += var3.a()) {
         var3 = (bqb)var2.next();
      }

      return var1;
   }

   public bpy(jy var1, double var2, double var4, bpg var6) {
      this.c = var1;
      this.f = var4;
      this.e = var2;
      this.d = var6;
   }

   public Object g() {
      return this.b();
   }
}
