public class abi {
   private zw[][] b;
   private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};

   public void a(abt var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         zw var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            zw var5 = this.b[var4 + 1][var2];
            var1.a(new zx(var5), this.a[var4], 'X', var3);
         }
      }

   }

   public abi() {
      this.b = new zw[][]{{zy.aF, zy.j, zy.i, zy.k}, {zy.Q, zy.Y, zy.ac, zy.ag}, {zy.R, zy.Z, zy.ad, zy.ah}, {zy.S, zy.aa, zy.ae, zy.ai}, {zy.T, zy.ab, zy.af, zy.aj}};
   }
}
