import java.util.concurrent.Callable;

public abstract class ase {
   protected ase a;
   private long d;
   protected long b;
   private long c;

   public ase(long var1) {
      this.b = var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
      this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
      this.b += var1;
   }

   protected static boolean b(int var0) {
      return var0 == ady.p.az || var0 == ady.N.az || var0 == ady.z.az;
   }

   public abstract int[] a(int var1, int var2, int var3, int var4);

   public static ase[] a(long var0, adr var2, String var3) {
      asd var4 = new asd(1L);
      asa var13 = new asa(2000L, var4);
      ars var14 = new ars(1L, var13);
      asr var15 = new asr(2001L, var14);
      var14 = new ars(2L, var15);
      var14 = new ars(50L, var14);
      var14 = new ars(70L, var14);
      ash var16 = new ash(2L, var14);
      aru var17 = new aru(2L, var16);
      var14 = new ars(3L, var17);
      arr var18 = new arr(2L, var14, arr.a.a);
      var18 = new arr(2L, var18, arr.a.b);
      var18 = new arr(3L, var18, arr.a.c);
      var15 = new asr(2002L, var18);
      var15 = new asr(2003L, var15);
      var14 = new ars(4L, var15);
      art var20 = new art(5L, var14);
      arq var23 = new arq(4L, var20);
      ase var26 = asr.b(1000L, var23, 0);
      ant var5 = null;
      int var6 = 4;
      int var7 = var6;
      if (var2 == adr.f && var3.length() > 0) {
         var5 = ant.a.a(var3).b();
         var6 = var5.G;
         var7 = var5.H;
      }

      if (var2 == adr.d) {
         var6 = 6;
      }

      ase var8 = asr.b(1000L, var26, 0);
      asi var19 = new asi(100L, var8);
      arw var9 = new arw(200L, var26, var2, var3);
      ase var21 = asr.b(1000L, var9, 2);
      arv var24 = new arv(1000L, var21);
      ase var10 = asr.b(1000L, var19, 2);
      asg var27 = new asg(1000L, var24, var10);
      var8 = asr.b(1000L, var19, 2);
      var8 = asr.b(1000L, var8, var7);
      asj var22 = new asj(1L, var8);
      asm var25 = new asm(1000L, var22);
      Object var28 = new asf(1001L, var27);

      for(int var11 = 0; var11 < var6; ++var11) {
         var28 = new asr((long)(1000 + var11), (ase)var28);
         if (var11 == 0) {
            var28 = new ars(3L, (ase)var28);
         }

         if (var11 == 1 || var6 == 1) {
            var28 = new asl(1000L, (ase)var28);
         }
      }

      asm var29 = new asm(1000L, (ase)var28);
      ask var30 = new ask(100L, var29, var25);
      asq var12 = new asq(10L, var30);
      var30.a(var0);
      var12.a(var0);
      return new ase[]{var30, var12, var30};
   }

   public void a(long var1, long var3) {
      this.d = this.c;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var1;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var3;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var1;
      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += var3;
   }

   protected static boolean a(int var0, int var1) {
      if (var0 == var1) {
         return true;
      } else if (var0 != ady.ab.az && var0 != ady.ac.az) {
         ady var2 = ady.e(var0);
         ady var3 = ady.e(var1);

         try {
            return var2 != null && var3 != null ? var2.a(var3) : false;
         } catch (Throwable var7) {
            b var5 = b.a(var7, "Comparing biomes");
            c var6 = var5.a("Biomes being compared");
            var6.a((String)"Biome A ID", (Object)var0);
            var6.a((String)"Biome B ID", (Object)var1);
            var6.a("Biome A", new Callable<String>(var2) {
               final ady a;

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return String.valueOf(this.a);
               }

               {
                  this.a = var1;
               }
            });
            var6.a("Biome B", new Callable<String>(var3) {
               final ady a;

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return String.valueOf(this.a);
               }

               {
                  this.a = var1;
               }
            });
            throw new e(var5);
         }
      } else {
         return var1 == ady.ab.az || var1 == ady.ac.az;
      }
   }

   protected int b(int var1, int var2, int var3, int var4) {
      if (var2 == var3 && var3 == var4) {
         return var2;
      } else if (var1 == var2 && var1 == var3) {
         return var1;
      } else if (var1 == var2 && var1 == var4) {
         return var1;
      } else if (var1 == var3 && var1 == var4) {
         return var1;
      } else if (var1 == var2 && var3 != var4) {
         return var1;
      } else if (var1 == var3 && var2 != var4) {
         return var1;
      } else if (var1 == var4 && var2 != var3) {
         return var1;
      } else if (var2 == var3 && var1 != var4) {
         return var2;
      } else if (var2 == var4 && var1 != var3) {
         return var2;
      } else {
         return var3 == var4 && var1 != var2 ? var3 : this.a(var1, var2, var3, var4);
      }
   }

   protected int a(int var1) {
      int var2 = (int)((this.d >> 24) % (long)var1);
      if (var2 < 0) {
         var2 += var1;
      }

      this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
      this.d += this.c;
      return var2;
   }

   protected int a(int... var1) {
      return var1[this.a(var1.length)];
   }

   public void a(long var1) {
      this.c = var1;
      if (this.a != null) {
         this.a.a(var1);
      }

      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
      this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
      this.c += this.b;
   }
}
