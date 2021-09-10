import com.google.common.collect.Maps;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

public class dn extends eb {
   private Map<String, eb> b = Maps.newHashMap();

   public dn m(String var1) {
      try {
         return !this.b(var1, 10) ? new dn() : (dn)this.b.get(var1);
      } catch (ClassCastException var3) {
         throw new e(this.a((String)var1, 10, (ClassCastException)var3));
      }
   }

   public float h(String var1) {
      try {
         return !this.b(var1, 99) ? 0.0F : ((eb.a)this.b.get(var1)).h();
      } catch (ClassCastException var3) {
         return 0.0F;
      }
   }

   public boolean c_() {
      return this.b.isEmpty();
   }

   public void a(dn var1) {
      Iterator var2 = var1.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         eb var4 = (eb)var1.b.get(var3);
         if (var4.a() == 10) {
            if (this.b(var3, 10)) {
               dn var5 = this.m(var3);
               var5.a((dn)var4);
            } else {
               this.a(var3, var4.b());
            }
         } else {
            this.a(var3, var4.b());
         }
      }

   }

   public void a(String var1, eb var2) {
      this.b.put(var1, var2);
   }

   public void a(String var1, float var2) {
      this.b.put(var1, new dr(var2));
   }

   void a(DataOutput var1) throws IOException {
      Iterator var2 = this.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         eb var4 = (eb)this.b.get(var3);
         a(var3, var4, var1);
      }

      var1.writeByte(0);
   }

   public void a(String var1, boolean var2) {
      this.a(var1, (byte)(var2 ? 1 : 0));
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(384L);
      if (var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         this.b.clear();

         byte var4;
         while((var4 = a(var1, var3)) != 0) {
            String var5 = b(var1, var3);
            var3.a((long)(224 + 16 * var5.length()));
            eb var6 = a(var4, var5, var1, var2 + 1, var3);
            if (this.b.put(var5, var6) != null) {
               var3.a(288L);
            }
         }

      }
   }

   private static String b(DataInput var0, dw var1) throws IOException {
      return var0.readUTF();
   }

   public eb b() {
      dn var1 = new dn();
      Iterator var2 = this.b.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.a(var3, ((eb)this.b.get(var3)).b());
      }

      return var1;
   }

   public double i(String var1) {
      try {
         return !this.b(var1, 99) ? 0.0D : ((eb.a)this.b.get(var1)).g();
      } catch (ClassCastException var3) {
         return 0.0D;
      }
   }

   public short e(String var1) {
      try {
         return !this.b(var1, 99) ? 0 : ((eb.a)this.b.get(var1)).e();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public du c(String var1, int var2) {
      try {
         if (this.b(var1) != 9) {
            return new du();
         } else {
            du var3 = (du)this.b.get(var1);
            return var3.c() > 0 && var3.f() != var2 ? new du() : var3;
         }
      } catch (ClassCastException var4) {
         throw new e(this.a((String)var1, 9, (ClassCastException)var4));
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("{");

      Entry var3;
      for(Iterator var2 = this.b.entrySet().iterator(); var2.hasNext(); var1.append((String)var3.getKey()).append(':').append(var3.getValue())) {
         var3 = (Entry)var2.next();
         if (var1.length() != 1) {
            var1.append(',');
         }
      }

      return var1.append('}').toString();
   }

   public void o(String var1) {
      this.b.remove(var1);
   }

   public byte b(String var1) {
      eb var2 = (eb)this.b.get(var1);
      return var2 != null ? var2.a() : 0;
   }

   public void a(String var1, byte[] var2) {
      this.b.put(var1, new dl(var2));
   }

   public int[] l(String var1) {
      try {
         return !this.b(var1, 11) ? new int[0] : ((ds)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         throw new e(this.a((String)var1, 11, (ClassCastException)var3));
      }
   }

   public boolean b(String var1, int var2) {
      byte var3 = this.b(var1);
      if (var3 == var2) {
         return true;
      } else if (var2 != 99) {
         if (var3 > 0) {
         }

         return false;
      } else {
         return var3 == 1 || var3 == 2 || var3 == 3 || var3 == 4 || var3 == 5 || var3 == 6;
      }
   }

   public byte a() {
      return 10;
   }

   public void a(String var1, byte var2) {
      this.b.put(var1, new dm(var2));
   }

   public boolean c(String var1) {
      return this.b.containsKey(var1);
   }

   public void a(String var1, int[] var2) {
      this.b.put(var1, new ds(var2));
   }

   private static byte a(DataInput var0, dw var1) throws IOException {
      return var0.readByte();
   }

   public byte d(String var1) {
      try {
         return !this.b(var1, 99) ? 0 : ((eb.a)this.b.get(var1)).f();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public byte[] k(String var1) {
      try {
         return !this.b(var1, 7) ? new byte[0] : ((dl)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         throw new e(this.a((String)var1, 7, (ClassCastException)var3));
      }
   }

   private static void a(String var0, eb var1, DataOutput var2) throws IOException {
      var2.writeByte(var1.a());
      if (var1.a() != 0) {
         var2.writeUTF(var0);
         var1.a(var2);
      }
   }

   public void a(String var1, int var2) {
      this.b.put(var1, new dt(var2));
   }

   public long g(String var1) {
      try {
         return !this.b(var1, 99) ? 0L : ((eb.a)this.b.get(var1)).c();
      } catch (ClassCastException var3) {
         return 0L;
      }
   }

   public String j(String var1) {
      try {
         return !this.b(var1, 8) ? "" : ((eb)this.b.get(var1)).a_();
      } catch (ClassCastException var3) {
         return "";
      }
   }

   public void a(String var1, double var2) {
      this.b.put(var1, new dp(var2));
   }

   public int f(String var1) {
      try {
         return !this.b(var1, 99) ? 0 : ((eb.a)this.b.get(var1)).d();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b.hashCode();
   }

   public eb a(String var1) {
      return (eb)this.b.get(var1);
   }

   public Set<String> c() {
      return this.b.keySet();
   }

   static eb a(byte var0, String var1, DataInput var2, int var3, dw var4) throws IOException {
      eb var5 = eb.a(var0);

      try {
         var5.a(var2, var3, var4);
         return var5;
      } catch (IOException var9) {
         b var7 = b.a(var9, "Loading NBT data");
         c var8 = var7.a("NBT Tag");
         var8.a((String)"Tag name", (Object)var1);
         var8.a((String)"Tag type", (Object)var0);
         throw new e(var7);
      }
   }

   public void a(String var1, short var2) {
      this.b.put(var1, new dz(var2));
   }

   static Map b(dn var0) {
      return var0.b;
   }

   private b a(String var1, int var2, ClassCastException var3) {
      b var4 = b.a(var3, "Reading NBT data");
      c var5 = var4.a("Corrupt NBT tag", 1);
      var5.a("Tag type found", new Callable<String>(this, var1) {
         final dn b;
         final String a;

         {
            this.b = var1;
            this.a = var2;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return eb.a[((eb)dn.b(this.b).get(this.a)).a()];
         }
      });
      var5.a("Tag type expected", new Callable<String>(this, var2) {
         final int a;
         final dn b;

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.b = var1;
            this.a = var2;
         }

         public String a() throws Exception {
            return eb.a[this.a];
         }
      });
      var5.a((String)"Tag name", (Object)var1);
      return var4;
   }

   public void a(String var1, String var2) {
      this.b.put(var1, new ea(var2));
   }

   public boolean n(String var1) {
      return this.d(var1) != 0;
   }

   public void a(String var1, long var2) {
      this.b.put(var1, new dv(var2));
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dn var2 = (dn)var1;
         return this.b.entrySet().equals(var2.b.entrySet());
      } else {
         return false;
      }
   }
}
