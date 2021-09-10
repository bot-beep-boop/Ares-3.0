public class fh {
   public static <T extends ep> void a(ff<T> var0, T var1, od var2) throws ki {
      if (!var2.aJ()) {
         var2.a(new Runnable(var0, var1) {
            final ep b;
            final ff a;

            {
               this.a = var1;
               this.b = var2;
            }

            public void run() {
               this.a.a(this.b);
            }
         });
         throw ki.a;
      }
   }
}
