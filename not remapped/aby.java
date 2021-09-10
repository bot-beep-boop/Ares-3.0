public class aby {
   private Object[][] b;
   private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};

   public void a(abt var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            zw var5 = (zw)this.b[var4 + 1][var2];
            var1.a(new zx(var5), this.a[var4], '#', zy.y, 'X', var3);
         }
      }

      var1.a(new zx(zy.be), " #", "# ", '#', zy.j);
   }

   public aby() {
      this.b = new Object[][]{{afi.f, afi.e, zy.j, zy.i, zy.k}, {zy.o, zy.s, zy.b, zy.w, zy.D}, {zy.n, zy.r, zy.a, zy.v, zy.C}, {zy.p, zy.t, zy.c, zy.x, zy.E}, {zy.I, zy.J, zy.K, zy.L, zy.M}};
   }
}
