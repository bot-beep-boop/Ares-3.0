import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class bbo {
   public int u = 32;
   private Map<String, bcu> a = Maps.newHashMap();
   public boolean q;
   public float p;
   public List<bct> s = Lists.newArrayList();
   public int t = 64;
   public boolean r = true;

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
   }

   public bcu a(String var1) {
      return (bcu)this.a.get(var1);
   }

   public void a(bbo var1) {
      this.p = var1.p;
      this.q = var1.q;
      this.r = var1.r;
   }

   public void a(pr var1, float var2, float var3, float var4) {
   }

   protected void a(String var1, int var2, int var3) {
      this.a.put(var1, new bcu(var2, var3));
   }

   public static void a(bct var0, bct var1) {
      var1.f = var0.f;
      var1.g = var0.g;
      var1.h = var0.h;
      var1.c = var0.c;
      var1.d = var0.d;
      var1.e = var0.e;
   }

   public bct a(Random var1) {
      return (bct)this.s.get(var1.nextInt(this.s.size()));
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
   }
}
