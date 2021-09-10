import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.lang3.ObjectUtils;

public class pz {
   private final pk a;
   private boolean b = true;
   private ReadWriteLock f = new ReentrantReadWriteLock();
   private static final Map<Class<?>, Integer> c = Maps.newHashMap();
   private boolean e;
   private final Map<Integer, pz.a> d = Maps.newHashMap();

   public dc h(int var1) {
      return (dc)this.j(var1).b();
   }

   public void a(em var1) throws IOException {
      this.f.readLock().lock();
      Iterator var2 = this.d.values().iterator();

      while(var2.hasNext()) {
         pz.a var3 = (pz.a)var2.next();
         a(var1, var3);
      }

      this.f.readLock().unlock();
      var1.writeByte(127);
   }

   public boolean d() {
      return this.b;
   }

   public boolean a() {
      return this.e;
   }

   public List<pz.a> b() {
      ArrayList var1 = null;
      if (this.e) {
         this.f.readLock().lock();
         Iterator var2 = this.d.values().iterator();

         while(var2.hasNext()) {
            pz.a var3 = (pz.a)var2.next();
            if (var3.d()) {
               var3.a(false);
               if (var1 == null) {
                  var1 = Lists.newArrayList();
               }

               var1.add(var3);
            }
         }

         this.f.readLock().unlock();
      }

      this.e = false;
      return var1;
   }

   public <T> void a(int var1, T var2) {
      Integer var3 = (Integer)c.get(var2.getClass());
      if (var3 == null) {
         throw new IllegalArgumentException("Unknown data type: " + var2.getClass());
      } else if (var1 > 31) {
         throw new IllegalArgumentException("Data value id is too big with " + var1 + "! (Max is " + 31 + ")");
      } else if (this.d.containsKey(var1)) {
         throw new IllegalArgumentException("Duplicate id value for " + var1 + "!");
      } else {
         pz.a var4 = new pz.a(var3, var1, var2);
         this.f.writeLock().lock();
         this.d.put(var1, var4);
         this.f.writeLock().unlock();
         this.b = false;
      }
   }

   public List<pz.a> c() {
      ArrayList var1 = null;
      this.f.readLock().lock();

      pz.a var3;
      for(Iterator var2 = this.d.values().iterator(); var2.hasNext(); var1.add(var3)) {
         var3 = (pz.a)var2.next();
         if (var1 == null) {
            var1 = Lists.newArrayList();
         }
      }

      this.f.readLock().unlock();
      return var1;
   }

   private pz.a j(int var1) {
      this.f.readLock().lock();

      pz.a var2;
      try {
         var2 = (pz.a)this.d.get(var1);
      } catch (Throwable var6) {
         b var4 = b.a(var6, "Getting synched entity data");
         c var5 = var4.a("Synched entity data");
         var5.a((String)"Data ID", (Object)var1);
         throw new e(var4);
      }

      this.f.readLock().unlock();
      return var2;
   }

   public void a(List<pz.a> var1) {
      this.f.writeLock().lock();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         pz.a var3 = (pz.a)var2.next();
         pz.a var4 = (pz.a)this.d.get(var3.a());
         if (var4 != null) {
            var4.a(var3.b());
            this.a.i(var3.a());
         }
      }

      this.f.writeLock().unlock();
      this.e = true;
   }

   public static List<pz.a> b(em var0) throws IOException {
      ArrayList var1 = null;

      for(byte var2 = var0.readByte(); var2 != 127; var2 = var0.readByte()) {
         if (var1 == null) {
            var1 = Lists.newArrayList();
         }

         int var3 = (var2 & 224) >> 5;
         int var4 = var2 & 31;
         pz.a var5 = null;
         switch(var3) {
         case 0:
            var5 = new pz.a(var3, var4, var0.readByte());
            break;
         case 1:
            var5 = new pz.a(var3, var4, var0.readShort());
            break;
         case 2:
            var5 = new pz.a(var3, var4, var0.readInt());
            break;
         case 3:
            var5 = new pz.a(var3, var4, var0.readFloat());
            break;
         case 4:
            var5 = new pz.a(var3, var4, var0.c(32767));
            break;
         case 5:
            var5 = new pz.a(var3, var4, var0.i());
            break;
         case 6:
            int var6 = var0.readInt();
            int var7 = var0.readInt();
            int var8 = var0.readInt();
            var5 = new pz.a(var3, var4, new cj(var6, var7, var8));
            break;
         case 7:
            float var9 = var0.readFloat();
            float var10 = var0.readFloat();
            float var11 = var0.readFloat();
            var5 = new pz.a(var3, var4, new dc(var9, var10, var11));
         }

         var1.add(var5);
      }

      return var1;
   }

   public byte a(int var1) {
      return (Byte)this.j(var1).b();
   }

   public zx f(int var1) {
      return (zx)this.j(var1).b();
   }

   public int c(int var1) {
      return (Integer)this.j(var1).b();
   }

   public float d(int var1) {
      return (Float)this.j(var1).b();
   }

   public short b(int var1) {
      return (Short)this.j(var1).b();
   }

   public <T> void b(int var1, T var2) {
      pz.a var3 = this.j(var1);
      if (ObjectUtils.notEqual(var2, var3.b())) {
         var3.a(var2);
         this.a.i(var1);
         var3.a(true);
         this.e = true;
      }

   }

   static {
      c.put(Byte.class, 0);
      c.put(Short.class, 1);
      c.put(Integer.class, 2);
      c.put(Float.class, 3);
      c.put(String.class, 4);
      c.put(zx.class, 5);
      c.put(cj.class, 6);
      c.put(dc.class, 7);
   }

   public String e(int var1) {
      return (String)this.j(var1).b();
   }

   public void e() {
      this.e = false;
   }

   public static void a(List<pz.a> var0, em var1) throws IOException {
      if (var0 != null) {
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            pz.a var3 = (pz.a)var2.next();
            a(var1, var3);
         }
      }

      var1.writeByte(127);
   }

   public pz(pk var1) {
      this.a = var1;
   }

   private static void a(em var0, pz.a var1) throws IOException {
      int var2 = (var1.c() << 5 | var1.a() & 31) & 255;
      var0.writeByte(var2);
      switch(var1.c()) {
      case 0:
         var0.writeByte((Byte)var1.b());
         break;
      case 1:
         var0.writeShort((Short)var1.b());
         break;
      case 2:
         var0.writeInt((Integer)var1.b());
         break;
      case 3:
         var0.writeFloat((Float)var1.b());
         break;
      case 4:
         var0.a((String)var1.b());
         break;
      case 5:
         zx var3 = (zx)var1.b();
         var0.a(var3);
         break;
      case 6:
         cj var4 = (cj)var1.b();
         var0.writeInt(var4.n());
         var0.writeInt(var4.o());
         var0.writeInt(var4.p());
         break;
      case 7:
         dc var5 = (dc)var1.b();
         var0.writeFloat(var5.b());
         var0.writeFloat(var5.c());
         var0.writeFloat(var5.d());
      }

   }

   public void a(int var1, int var2) {
      pz.a var3 = new pz.a(var2, var1, (Object)null);
      this.f.writeLock().lock();
      this.d.put(var1, var3);
      this.f.writeLock().unlock();
      this.b = false;
   }

   public void i(int var1) {
      pz.a.a(this.j(var1), true);
      this.e = true;
   }

   public static class a {
      private final int a;
      private boolean d;
      private final int b;
      private Object c;

      public boolean d() {
         return this.d;
      }

      public void a(boolean var1) {
         this.d = var1;
      }

      public a(int var1, int var2, Object var3) {
         this.b = var2;
         this.c = var3;
         this.a = var1;
         this.d = true;
      }

      static boolean a(pz.a var0, boolean var1) {
         return var0.d = var1;
      }

      public void a(Object var1) {
         this.c = var1;
      }

      public int a() {
         return this.b;
      }

      public int c() {
         return this.a;
      }

      public Object b() {
         return this.c;
      }
   }
}
