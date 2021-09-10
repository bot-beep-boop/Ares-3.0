import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class adz {
   private nq<adz.a> c = new nq();
   private final aec a;
   private long b;
   private List<adz.a> d = Lists.newArrayList();

   public adz(aec var1) {
      this.a = var1;
   }

   static aec a(adz var0) {
      return var0.a;
   }

   public adz.a a(int var1, int var2) {
      var1 >>= 4;
      var2 >>= 4;
      long var3 = (long)var1 & 4294967295L | ((long)var2 & 4294967295L) << 32;
      adz.a var5 = (adz.a)this.c.a(var3);
      if (var5 == null) {
         var5 = new adz.a(this, var1, var2);
         this.c.a(var3, var5);
         this.d.add(var5);
      }

      var5.e = MinecraftServer.az();
      return var5;
   }

   public ady a(int var1, int var2, ady var3) {
      ady var4 = this.a(var1, var2).a(var1, var2);
      return var4 == null ? var3 : var4;
   }

   public ady[] c(int var1, int var2) {
      return this.a(var1, var2).b;
   }

   public void a() {
      long var1 = MinecraftServer.az();
      long var3 = var1 - this.b;
      if (var3 > 7500L || var3 < 0L) {
         this.b = var1;

         for(int var5 = 0; var5 < this.d.size(); ++var5) {
            adz.a var6 = (adz.a)this.d.get(var5);
            long var7 = var1 - var6.e;
            if (var7 > 30000L || var7 < 0L) {
               this.d.remove(var5--);
               long var9 = (long)var6.c & 4294967295L | ((long)var6.d & 4294967295L) << 32;
               this.c.d(var9);
            }
         }
      }

   }

   public class a {
      final adz f;
      public long e;
      public int d;
      public ady[] b;
      public int c;
      public float[] a;

      public a(adz var1, int var2, int var3) {
         this.f = var1;
         this.a = new float[256];
         this.b = new ady[256];
         this.c = var2;
         this.d = var3;
         adz.a(var1).a((float[])this.a, var2 << 4, var3 << 4, 16, 16);
         adz.a(var1).a(this.b, var2 << 4, var3 << 4, 16, 16, false);
      }

      public ady a(int var1, int var2) {
         return this.b[var1 & 15 | (var2 & 15) << 4];
      }
   }
}
