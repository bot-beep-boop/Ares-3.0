import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class aqi extends aqq {
   private List<ady.c> d = Lists.newArrayList();

   protected aqu b(int var1, int var2) {
      return new aqi.a(this.c, this.b, var1, var2);
   }

   public List<ady.c> b() {
      return this.d;
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1 >> 4;
      int var4 = var2 >> 4;
      this.b.setSeed((long)(var3 ^ var4 << 4) ^ this.c.J());
      this.b.nextInt();
      if (this.b.nextInt(3) != 0) {
         return false;
      } else if (var1 != (var3 << 4) + 4 + this.b.nextInt(8)) {
         return false;
      } else {
         return var2 == (var4 << 4) + 4 + this.b.nextInt(8);
      }
   }

   public aqi() {
      this.d.add(new ady.c(vl.class, 10, 2, 3));
      this.d.add(new ady.c(vw.class, 5, 4, 4));
      this.d.add(new ady.c(wa.class, 10, 4, 4));
      this.d.add(new ady.c(vu.class, 3, 4, 4));
   }

   public String a() {
      return "Fortress";
   }

   public static class a extends aqu {
      public a(adm var1, Random var2, int var3, int var4) {
         super(var3, var4);
         aqj.q var5 = new aqj.q(var2, (var3 << 4) + 2, (var4 << 4) + 2);
         this.a.add(var5);
         var5.a(var5, this.a, var2);
         List var6 = var5.e;

         while(!var6.isEmpty()) {
            int var7 = var2.nextInt(var6.size());
            aqt var8 = (aqt)var6.remove(var7);
            var8.a((aqt)var5, (List)this.a, (Random)var2);
         }

         this.c();
         this.a(var1, var2, 48, 70);
      }

      public a() {
      }
   }
}
