import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class asg extends ase {
   private ase d;
   private static final Logger c = LogManager.getLogger();

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = this.d.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var7 = asc.a(var3 * var4);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var3; ++var9) {
            this.a((long)(var9 + var1), (long)(var8 + var2));
            int var10 = var5[var9 + 1 + (var8 + 1) * (var3 + 2)];
            int var11 = var6[var9 + 1 + (var8 + 1) * (var3 + 2)];
            boolean var12 = (var11 - 2) % 29 == 0;
            if (var10 > 255) {
               c.debug("old! " + var10);
            }

            if (var10 != 0 && var11 >= 2 && (var11 - 2) % 29 == 1 && var10 < 128) {
               if (ady.e(var10 + 128) != null) {
                  var7[var9 + var8 * var3] = var10 + 128;
               } else {
                  var7[var9 + var8 * var3] = var10;
               }
            } else if (this.a(3) != 0 && !var12) {
               var7[var9 + var8 * var3] = var10;
            } else {
               int var13 = var10;
               int var14;
               if (var10 == ady.r.az) {
                  var13 = ady.G.az;
               } else if (var10 == ady.t.az) {
                  var13 = ady.H.az;
               } else if (var10 == ady.Q.az) {
                  var13 = ady.R.az;
               } else if (var10 == ady.S.az) {
                  var13 = ady.q.az;
               } else if (var10 == ady.u.az) {
                  var13 = ady.I.az;
               } else if (var10 == ady.V.az) {
                  var13 = ady.W.az;
               } else if (var10 == ady.T.az) {
                  var13 = ady.U.az;
               } else if (var10 == ady.q.az) {
                  if (this.a(3) == 0) {
                     var13 = ady.H.az;
                  } else {
                     var13 = ady.t.az;
                  }
               } else if (var10 == ady.B.az) {
                  var13 = ady.C.az;
               } else if (var10 == ady.K.az) {
                  var13 = ady.L.az;
               } else if (var10 == ady.p.az) {
                  var13 = ady.N.az;
               } else if (var10 == ady.s.az) {
                  var13 = ady.X.az;
               } else if (var10 == ady.Y.az) {
                  var13 = ady.Z.az;
               } else if (a(var10, ady.ab.az)) {
                  var13 = ady.aa.az;
               } else if (var10 == ady.N.az && this.a(3) == 0) {
                  var14 = this.a(2);
                  if (var14 == 0) {
                     var13 = ady.q.az;
                  } else {
                     var13 = ady.t.az;
                  }
               }

               if (var12 && var13 != var10) {
                  if (ady.e(var13 + 128) != null) {
                     var13 += 128;
                  } else {
                     var13 = var10;
                  }
               }

               if (var13 == var10) {
                  var7[var9 + var8 * var3] = var10;
               } else {
                  var14 = var5[var9 + 1 + (var8 + 1 - 1) * (var3 + 2)];
                  int var15 = var5[var9 + 1 + 1 + (var8 + 1) * (var3 + 2)];
                  int var16 = var5[var9 + 1 - 1 + (var8 + 1) * (var3 + 2)];
                  int var17 = var5[var9 + 1 + (var8 + 1 + 1) * (var3 + 2)];
                  int var18 = 0;
                  if (a(var14, var10)) {
                     ++var18;
                  }

                  if (a(var15, var10)) {
                     ++var18;
                  }

                  if (a(var16, var10)) {
                     ++var18;
                  }

                  if (a(var17, var10)) {
                     ++var18;
                  }

                  if (var18 >= 3) {
                     var7[var9 + var8 * var3] = var13;
                  } else {
                     var7[var9 + var8 * var3] = var10;
                  }
               }
            }
         }
      }

      return var7;
   }

   public asg(long var1, ase var3, ase var4) {
      super(var1);
      this.a = var3;
      this.d = var4;
   }
}
