public class arw extends ase {
   private ady[] d;
   private final ant g;
   private ady[] e;
   private ady[] f;
   private ady[] c;

   public arw(long var1, ase var3, adr var4, String var5) {
      super(var1);
      this.c = new ady[]{ady.r, ady.r, ady.r, ady.Y, ady.Y, ady.q};
      this.d = new ady[]{ady.t, ady.S, ady.s, ady.q, ady.Q, ady.v};
      this.e = new ady[]{ady.t, ady.s, ady.u, ady.q};
      this.f = new ady[]{ady.B, ady.B, ady.B, ady.T};
      this.a = var3;
      if (var4 == adr.h) {
         this.c = new ady[]{ady.r, ady.t, ady.s, ady.v, ady.q, ady.u};
         this.g = null;
      } else if (var4 == adr.f) {
         this.g = ant.a.a(var5).b();
      } else {
         this.g = null;
      }

   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1, var2, var3, var4);
      int[] var6 = asc.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + var7 * var3];
            int var10 = (var9 & 3840) >> 8;
            var9 &= -3841;
            if (this.g != null && this.g.F >= 0) {
               var6[var8 + var7 * var3] = this.g.F;
            } else if (b(var9)) {
               var6[var8 + var7 * var3] = var9;
            } else if (var9 == ady.D.az) {
               var6[var8 + var7 * var3] = var9;
            } else if (var9 == 1) {
               if (var10 > 0) {
                  if (this.a(3) == 0) {
                     var6[var8 + var7 * var3] = ady.ac.az;
                  } else {
                     var6[var8 + var7 * var3] = ady.ab.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = this.c[this.a(this.c.length)].az;
               }
            } else if (var9 == 2) {
               if (var10 > 0) {
                  var6[var8 + var7 * var3] = ady.K.az;
               } else {
                  var6[var8 + var7 * var3] = this.d[this.a(this.d.length)].az;
               }
            } else if (var9 == 3) {
               if (var10 > 0) {
                  var6[var8 + var7 * var3] = ady.V.az;
               } else {
                  var6[var8 + var7 * var3] = this.e[this.a(this.e.length)].az;
               }
            } else if (var9 == 4) {
               var6[var8 + var7 * var3] = this.f[this.a(this.f.length)].az;
            } else {
               var6[var8 + var7 * var3] = ady.D.az;
            }
         }
      }

      return var6;
   }
}
