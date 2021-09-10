import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class go implements ff<fj> {
   private int a;
   private go.a c;
   private int b;
   private boolean d;

   public void b(em var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeInt(this.b);
      var1.writeBoolean(this.d);
      var1.writeShort((short)(this.c.b & '\uffff'));
      var1.a(this.c.a);
   }

   public int c() {
      return this.b;
   }

   private static int a(byte[] var0, byte[] var1, int var2) {
      System.arraycopy(var0, 0, var1, var2, var0.length);
      return var2 + var0.length;
   }

   public byte[] a() {
      return this.c.a;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public int d() {
      return this.c.b;
   }

   public static go.a a(amy var0, boolean var1, boolean var2, int var3) {
      amz[] var4 = var0.h();
      go.a var5 = new go.a();
      ArrayList var6 = Lists.newArrayList();

      int var7;
      for(var7 = 0; var7 < var4.length; ++var7) {
         amz var8 = var4[var7];
         if (var8 != null && (!var1 || !var8.a()) && (var3 & 1 << var7) != 0) {
            var5.b |= 1 << var7;
            var6.add(var8);
         }
      }

      var5.a = new byte[a(Integer.bitCount(var5.b), var2, var1)];
      var7 = 0;
      Iterator var15 = var6.iterator();

      amz var9;
      while(var15.hasNext()) {
         var9 = (amz)var15.next();
         char[] var10 = var9.g();
         char[] var11 = var10;
         int var12 = var10.length;

         for(int var13 = 0; var13 < var12; ++var13) {
            char var14 = var11[var13];
            var5.a[var7++] = (byte)(var14 & 255);
            var5.a[var7++] = (byte)(var14 >> 8 & 255);
         }
      }

      for(var15 = var6.iterator(); var15.hasNext(); var7 = a(var9.h().a(), var5.a, var7)) {
         var9 = (amz)var15.next();
      }

      if (var2) {
         for(var15 = var6.iterator(); var15.hasNext(); var7 = a(var9.i().a(), var5.a, var7)) {
            var9 = (amz)var15.next();
         }
      }

      if (var1) {
         a(var0.k(), var5.a, var7);
      }

      return var5;
   }

   public go() {
   }

   public void a(em var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.readInt();
      this.d = var1.readBoolean();
      this.c = new go.a();
      this.c.b = var1.readShort();
      this.c.a = var1.a();
   }

   protected static int a(int var0, boolean var1, boolean var2) {
      int var3 = var0 * 2 * 16 * 16 * 16;
      int var4 = var0 * 16 * 16 * 16 / 2;
      int var5 = var1 ? var0 * 16 * 16 * 16 / 2 : 0;
      int var6 = var2 ? 256 : 0;
      return var3 + var4 + var5 + var6;
   }

   public go(amy var1, boolean var2, int var3) {
      this.a = var1.a;
      this.b = var1.b;
      this.d = var2;
      this.c = a(var1, var2, !var1.p().t.o(), var3);
   }

   public int b() {
      return this.a;
   }

   public boolean e() {
      return this.d;
   }

   public static class a {
      public byte[] a;
      public int b;
   }
}
