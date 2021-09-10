public class ask extends ase {
   private ase d;
   private ase c;

   public void a(long var1) {
      this.c.a(var1);
      this.d.a(var1);
      super.a(var1);
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.c.a(var1, var2, var3, var4);
      int[] var6 = this.d.a(var1, var2, var3, var4);
      int[] var7 = asc.a(var3 * var4);

      for(int var8 = 0; var8 < var3 * var4; ++var8) {
         if (var5[var8] != ady.p.az && var5[var8] != ady.N.az) {
            if (var6[var8] == ady.w.az) {
               if (var5[var8] == ady.B.az) {
                  var7[var8] = ady.A.az;
               } else if (var5[var8] != ady.D.az && var5[var8] != ady.E.az) {
                  var7[var8] = var6[var8] & 255;
               } else {
                  var7[var8] = ady.E.az;
               }
            } else {
               var7[var8] = var5[var8];
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }

   public ask(long var1, ase var3, ase var4) {
      super(var1);
      this.c = var3;
      this.d = var4;
   }
}
