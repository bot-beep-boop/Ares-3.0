import com.google.common.primitives.Floats;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import org.apache.logging.log4j.LogManager;

public class bfd {
   private ShortBuffer c;
   private boolean n;
   private boolean h;
   private bmv f;
   private double j;
   private int i;
   private double k;
   private int e;
   private bmu m;
   private ByteBuffer a;
   private double l;
   private FloatBuffer d;
   private IntBuffer b;
   private int g;

   public bmu g() {
      return this.m;
   }

   public bfd(int var1) {
      this.a = avd.c(var1 * 4);
      this.b = this.a.asIntBuffer();
      this.c = this.a.asShortBuffer();
      this.d = this.a.asFloatBuffer();
   }

   public void a(bfd.a var1) {
      this.b.clear();
      this.b(var1.a().length);
      this.b.put(var1.a());
      this.e = var1.b();
      this.m = new bmu(var1.c());
   }

   public bfd.a a() {
      this.b.rewind();
      int var1 = this.j();
      this.b.limit(var1);
      int[] var2 = new int[var1];
      this.b.get(var2);
      this.b.limit(this.b.capacity());
      this.b.position(var1);
      return new bfd.a(this, var2, new bmu(this.m));
   }

   public bfd b(double var1, double var3, double var5) {
      int var7 = this.e * this.m.g() + this.m.d(this.g);
      switch(this.f.a()) {
      case a:
         this.a.putFloat(var7, (float)(var1 + this.j));
         this.a.putFloat(var7 + 4, (float)(var3 + this.k));
         this.a.putFloat(var7 + 8, (float)(var5 + this.l));
         break;
      case f:
      case g:
         this.a.putInt(var7, Float.floatToRawIntBits((float)(var1 + this.j)));
         this.a.putInt(var7 + 4, Float.floatToRawIntBits((float)(var3 + this.k)));
         this.a.putInt(var7 + 8, Float.floatToRawIntBits((float)(var5 + this.l)));
         break;
      case d:
      case e:
         this.a.putShort(var7, (short)((int)(var1 + this.j)));
         this.a.putShort(var7 + 2, (short)((int)(var3 + this.k)));
         this.a.putShort(var7 + 4, (short)((int)(var5 + this.l)));
         break;
      case b:
      case c:
         this.a.put(var7, (byte)((int)(var1 + this.j)));
         this.a.put(var7 + 1, (byte)((int)(var3 + this.k)));
         this.a.put(var7 + 2, (byte)((int)(var5 + this.l)));
      }

      this.k();
      return this;
   }

   public void a(int var1) {
      for(int var2 = 0; var2 < 4; ++var2) {
         this.b(var1, var2 + 1);
      }

   }

   public bfd a(double var1, double var3) {
      int var5 = this.e * this.m.g() + this.m.d(this.g);
      switch(this.f.a()) {
      case a:
         this.a.putFloat(var5, (float)var1);
         this.a.putFloat(var5 + 4, (float)var3);
         break;
      case f:
      case g:
         this.a.putInt(var5, (int)var1);
         this.a.putInt(var5 + 4, (int)var3);
         break;
      case d:
      case e:
         this.a.putShort(var5, (short)((int)var3));
         this.a.putShort(var5 + 2, (short)((int)var1));
         break;
      case b:
      case c:
         this.a.put(var5, (byte)((int)var3));
         this.a.put(var5 + 1, (byte)((int)var1));
      }

      this.k();
      return this;
   }

   public void b() {
      this.e = 0;
      this.f = null;
      this.g = 0;
   }

   public void a(float var1, float var2, float var3) {
      int var4 = this.e / 4;
      float[] var5 = new float[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         var5[var6] = a(this.d, (float)((double)var1 + this.j), (float)((double)var2 + this.k), (float)((double)var3 + this.l), this.m.f(), var6 * this.m.g());
      }

      Integer[] var15 = new Integer[var4];

      for(int var7 = 0; var7 < var15.length; ++var7) {
         var15[var7] = var7;
      }

      Arrays.sort(var15, new Comparator<Integer>(this, var5) {
         final float[] a;
         final bfd b;

         {
            this.b = var1;
            this.a = var2;
         }

         public int a(Integer var1, Integer var2) {
            return Floats.compare(this.a[var2], this.a[var1]);
         }

         public int compare(Object var1, Object var2) {
            return this.a((Integer)var1, (Integer)var2);
         }
      });
      BitSet var16 = new BitSet();
      int var8 = this.m.g();
      int[] var9 = new int[var8];

      for(int var10 = 0; (var10 = var16.nextClearBit(var10)) < var15.length; ++var10) {
         int var11 = var15[var10];
         if (var11 != var10) {
            this.b.limit(var11 * var8 + var8);
            this.b.position(var11 * var8);
            this.b.get(var9);
            int var12 = var11;

            for(int var13 = var15[var11]; var12 != var10; var13 = var15[var13]) {
               this.b.limit(var13 * var8 + var8);
               this.b.position(var13 * var8);
               IntBuffer var14 = this.b.slice();
               this.b.limit(var12 * var8 + var8);
               this.b.position(var12 * var8);
               this.b.put(var14);
               var16.set(var12);
               var12 = var13;
            }

            this.b.limit(var10 * var8 + var8);
            this.b.position(var10 * var8);
            this.b.put(var9);
         }

         var16.set(var10);
      }

   }

   public void b(float var1, float var2, float var3) {
      int var4 = (byte)((int)(var1 * 127.0F)) & 255;
      int var5 = (byte)((int)(var2 * 127.0F)) & 255;
      int var6 = (byte)((int)(var3 * 127.0F)) & 255;
      int var7 = var4 | var5 << 8 | var6 << 16;
      int var8 = this.m.g() >> 2;
      int var9 = (this.e - 4) * var8 + this.m.c() / 4;
      this.b.put(var9, var7);
      this.b.put(var9 + var8, var7);
      this.b.put(var9 + var8 * 2, var7);
      this.b.put(var9 + var8 * 3, var7);
   }

   public bfd b(int var1, int var2, int var3, int var4) {
      if (this.h) {
         return this;
      } else {
         int var5 = this.e * this.m.g() + this.m.d(this.g);
         switch(this.f.a()) {
         case a:
            this.a.putFloat(var5, (float)var1 / 255.0F);
            this.a.putFloat(var5 + 4, (float)var2 / 255.0F);
            this.a.putFloat(var5 + 8, (float)var3 / 255.0F);
            this.a.putFloat(var5 + 12, (float)var4 / 255.0F);
            break;
         case f:
         case g:
            this.a.putFloat(var5, (float)var1);
            this.a.putFloat(var5 + 4, (float)var2);
            this.a.putFloat(var5 + 8, (float)var3);
            this.a.putFloat(var5 + 12, (float)var4);
            break;
         case d:
         case e:
            this.a.putShort(var5, (short)var1);
            this.a.putShort(var5 + 2, (short)var2);
            this.a.putShort(var5 + 4, (short)var3);
            this.a.putShort(var5 + 6, (short)var4);
            break;
         case b:
         case c:
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
               this.a.put(var5, (byte)var1);
               this.a.put(var5 + 1, (byte)var2);
               this.a.put(var5 + 2, (byte)var3);
               this.a.put(var5 + 3, (byte)var4);
            } else {
               this.a.put(var5, (byte)var4);
               this.a.put(var5 + 1, (byte)var3);
               this.a.put(var5 + 2, (byte)var2);
               this.a.put(var5 + 3, (byte)var1);
            }
         }

         this.k();
         return this;
      }
   }

   public int h() {
      return this.e;
   }

   public void c(double var1, double var3, double var5) {
      this.j = var1;
      this.k = var3;
      this.l = var5;
   }

   public void d(float var1, float var2, float var3) {
      for(int var4 = 0; var4 < 4; ++var4) {
         this.b(var1, var2, var3, var4 + 1);
      }

   }

   private void b(int var1, int var2) {
      int var3 = this.c(var2);
      int var4 = var1 >> 16 & 255;
      int var5 = var1 >> 8 & 255;
      int var6 = var1 & 255;
      int var7 = var1 >> 24 & 255;
      this.a(var3, var4, var5, var6, var7);
   }

   public void d() {
      ++this.e;
      this.b(this.m.f());
   }

   public ByteBuffer f() {
      return this.a;
   }

   public void a(double var1, double var3, double var5) {
      int var7 = this.m.f();
      int var8 = (this.e - 4) * var7;

      for(int var9 = 0; var9 < 4; ++var9) {
         int var10 = var8 + var9 * var7;
         int var11 = var10 + 1;
         int var12 = var11 + 1;
         this.b.put(var10, Float.floatToRawIntBits((float)(var1 + this.j) + Float.intBitsToFloat(this.b.get(var10))));
         this.b.put(var11, Float.floatToRawIntBits((float)(var3 + this.k) + Float.intBitsToFloat(this.b.get(var11))));
         this.b.put(var12, Float.floatToRawIntBits((float)(var5 + this.l) + Float.intBitsToFloat(this.b.get(var12))));
      }

   }

   private int c(int var1) {
      return ((this.e - var1) * this.m.g() + this.m.e()) / 4;
   }

   public void e() {
      if (!this.n) {
         throw new IllegalStateException("Not building!");
      } else {
         this.n = false;
         this.a.position(0);
         this.a.limit(this.j() * 4);
      }
   }

   public void a(float var1, float var2, float var3, int var4) {
      int var5 = this.c(var4);
      int var6 = -1;
      if (!this.h) {
         var6 = this.b.get(var5);
         int var7;
         int var8;
         int var9;
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            var7 = (int)((float)(var6 & 255) * var1);
            var8 = (int)((float)(var6 >> 8 & 255) * var2);
            var9 = (int)((float)(var6 >> 16 & 255) * var3);
            var6 &= -16777216;
            var6 |= var9 << 16 | var8 << 8 | var7;
         } else {
            var7 = (int)((float)(var6 >> 24 & 255) * var1);
            var8 = (int)((float)(var6 >> 16 & 255) * var2);
            var9 = (int)((float)(var6 >> 8 & 255) * var3);
            var6 &= 255;
            var6 |= var7 << 24 | var8 << 16 | var9 << 8;
         }
      }

      this.b.put(var5, var6);
   }

   private void k() {
      ++this.g;
      this.g %= this.m.i();
      this.f = this.m.c(this.g);
      if (this.f.b() == bmv.b.g) {
         this.k();
      }

   }

   public int i() {
      return this.i;
   }

   public void b(float var1, float var2, float var3, int var4) {
      int var5 = this.c(var4);
      int var6 = ns.a((int)(var1 * 255.0F), 0, 255);
      int var7 = ns.a((int)(var2 * 255.0F), 0, 255);
      int var8 = ns.a((int)(var3 * 255.0F), 0, 255);
      this.a(var5, var6, var7, var8, 255);
   }

   public bfd a(float var1, float var2, float var3, float var4) {
      return this.b((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F), (int)(var4 * 255.0F));
   }

   public void a(int var1, int var2, int var3, int var4) {
      int var5 = (this.e - 4) * this.m.f() + this.m.b(1) / 4;
      int var6 = this.m.g() >> 2;
      this.b.put(var5, var1);
      this.b.put(var5 + var6, var2);
      this.b.put(var5 + var6 * 2, var3);
      this.b.put(var5 + var6 * 3, var4);
   }

   public bfd a(int var1, int var2) {
      int var3 = this.e * this.m.g() + this.m.d(this.g);
      switch(this.f.a()) {
      case a:
         this.a.putFloat(var3, (float)var1);
         this.a.putFloat(var3 + 4, (float)var2);
         break;
      case f:
      case g:
         this.a.putInt(var3, var1);
         this.a.putInt(var3 + 4, var2);
         break;
      case d:
      case e:
         this.a.putShort(var3, (short)var2);
         this.a.putShort(var3 + 2, (short)var1);
         break;
      case b:
      case c:
         this.a.put(var3, (byte)var2);
         this.a.put(var3 + 1, (byte)var1);
      }

      this.k();
      return this;
   }

   public void a(int[] var1) {
      this.b(var1.length);
      this.b.position(this.j());
      this.b.put(var1);
      this.e += var1.length / this.m.f();
   }

   private int j() {
      return this.e * this.m.f();
   }

   private void b(int var1) {
      if (var1 > this.b.remaining()) {
         int var2 = this.a.capacity();
         int var3 = var2 % 2097152;
         int var4 = var3 + (((this.b.position() + var1) * 4 - var3) / 2097152 + 1) * 2097152;
         LogManager.getLogger().warn("Needed to grow BufferBuilder buffer: Old size " + var2 + " bytes, new size " + var4 + " bytes.");
         int var5 = this.b.position();
         ByteBuffer var6 = avd.c(var4);
         this.a.position(0);
         var6.put(this.a);
         var6.rewind();
         this.a = var6;
         this.d = this.a.asFloatBuffer().asReadOnlyBuffer();
         this.b = this.a.asIntBuffer();
         this.b.position(var5);
         this.c = this.a.asShortBuffer();
         this.c.position(var5 << 1);
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
         this.b.put(var1, var5 << 24 | var4 << 16 | var3 << 8 | var2);
      } else {
         this.b.put(var1, var2 << 24 | var3 << 16 | var4 << 8 | var5);
      }

   }

   private static float a(FloatBuffer var0, float var1, float var2, float var3, int var4, int var5) {
      float var6 = var0.get(var5 + var4 * 0);
      float var7 = var0.get(var5 + var4 * 0 + 1);
      float var8 = var0.get(var5 + var4 * 0 + 2);
      float var9 = var0.get(var5 + var4 * 1);
      float var10 = var0.get(var5 + var4 * 1 + 1);
      float var11 = var0.get(var5 + var4 * 1 + 2);
      float var12 = var0.get(var5 + var4 * 2);
      float var13 = var0.get(var5 + var4 * 2 + 1);
      float var14 = var0.get(var5 + var4 * 2 + 2);
      float var15 = var0.get(var5 + var4 * 3);
      float var16 = var0.get(var5 + var4 * 3 + 1);
      float var17 = var0.get(var5 + var4 * 3 + 2);
      float var18 = (var6 + var9 + var12 + var15) * 0.25F - var1;
      float var19 = (var7 + var10 + var13 + var16) * 0.25F - var2;
      float var20 = (var8 + var11 + var14 + var17) * 0.25F - var3;
      return var18 * var18 + var19 * var19 + var20 * var20;
   }

   public void c() {
      this.h = true;
   }

   public void a(int var1, bmu var2) {
      if (this.n) {
         throw new IllegalStateException("Already building!");
      } else {
         this.n = true;
         this.b();
         this.i = var1;
         this.m = var2;
         this.f = var2.c(this.g);
         this.h = false;
         this.a.limit(this.a.capacity());
      }
   }

   public bfd c(float var1, float var2, float var3) {
      int var4 = this.e * this.m.g() + this.m.d(this.g);
      switch(this.f.a()) {
      case a:
         this.a.putFloat(var4, var1);
         this.a.putFloat(var4 + 4, var2);
         this.a.putFloat(var4 + 8, var3);
         break;
      case f:
      case g:
         this.a.putInt(var4, (int)var1);
         this.a.putInt(var4 + 4, (int)var2);
         this.a.putInt(var4 + 8, (int)var3);
         break;
      case d:
      case e:
         this.a.putShort(var4, (short)((int)var1 * 32767 & '\uffff'));
         this.a.putShort(var4 + 2, (short)((int)var2 * 32767 & '\uffff'));
         this.a.putShort(var4 + 4, (short)((int)var3 * 32767 & '\uffff'));
         break;
      case b:
      case c:
         this.a.put(var4, (byte)((int)var1 * 127 & 255));
         this.a.put(var4 + 1, (byte)((int)var2 * 127 & 255));
         this.a.put(var4 + 2, (byte)((int)var3 * 127 & 255));
      }

      this.k();
      return this;
   }

   public class a {
      final bfd a;
      private final bmu c;
      private final int[] b;

      public int[] a() {
         return this.b;
      }

      public bmu c() {
         return this.c;
      }

      public int b() {
         return this.b.length / this.c.f();
      }

      public a(bfd var1, int[] var2, bmu var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
