public class abz {
   private Object[][] b;
   private String[][] a = new String[][]{{"X", "X", "#"}};

   public abz() {
      this.b = new Object[][]{{afi.f, afi.e, zy.j, zy.i, zy.k}, {zy.m, zy.q, zy.l, zy.u, zy.B}};
   }

   public void a(abt var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            zw var5 = (zw)this.b[var4 + 1][var2];
            var1.a(new zx(var5), this.a[var4], '#', zy.y, 'X', var3);
         }
      }

      var1.a(new zx(zy.f, 1), " #X", "# X", " #X", 'X', zy.F, '#', zy.y);
      var1.a(new zx(zy.g, 4), "X", "#", "Y", 'Y', zy.G, 'X', zy.ak, '#', zy.y);
   }
}
