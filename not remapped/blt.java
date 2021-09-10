import com.google.common.collect.Maps;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.BufferUtils;

public class blt {
   private int d = 0;
   private final blt.a a;
   private final String b;
   private int c;

   public static blt a(bni var0, blt.a var1, String var2) throws IOException {
      blt var3 = (blt)var1.d().get(var2);
      if (var3 == null) {
         jy var4 = new jy("shaders/program/" + var2 + var1.b());
         BufferedInputStream var5 = new BufferedInputStream(var0.a(var4).b());
         byte[] var6 = a(var5);
         ByteBuffer var7 = BufferUtils.createByteBuffer(var6.length);
         var7.put(var6);
         var7.position(0);
         int var8 = bqs.b(var1.c());
         bqs.a(var8, var7);
         bqs.c(var8);
         if (bqs.c(var8, bqs.n) == 0) {
            String var9 = StringUtils.trim(bqs.d(var8, 32768));
            kc var10 = new kc("Couldn't compile " + var1.a() + " program: " + var9);
            var10.b(var4.a());
            throw var10;
         }

         var3 = new blt(var1, var8, var2);
         var1.d().put(var2, var3);
      }

      return var3;
   }

   public String a() {
      return this.b;
   }

   private blt(blt.a var1, int var2, String var3) {
      this.a = var1;
      this.c = var2;
      this.b = var3;
   }

   public void a(blq var1) {
      ++this.d;
      bqs.b(var1.h(), this.c);
   }

   public void b(blq var1) {
      --this.d;
      if (this.d <= 0) {
         bqs.a(this.c);
         this.a.d().remove(this.b);
      }

   }

   protected static byte[] a(BufferedInputStream var0) throws IOException {
      byte[] var1;
      try {
         var1 = IOUtils.toByteArray(var0);
      } finally {
         var0.close();
      }

      return var1;
   }

   public static enum a {
      b("fragment", ".fsh", bqs.p);

      private final Map<String, blt> f = Maps.newHashMap();
      a("vertex", ".vsh", bqs.o);

      private final String d;
      private final String c;
      private final int e;
      private static final blt.a[] g = new blt.a[]{a, b};

      protected Map<String, blt> d() {
         return this.f;
      }

      public String a() {
         return this.c;
      }

      private a(String var3, String var4, int var5) {
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      protected int c() {
         return this.e;
      }

      protected String b() {
         return this.d;
      }
   }
}
