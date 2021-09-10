import java.util.List;
import java.util.Random;

public class aqh extends aqu {
   public aqh(adm var1, Random var2, int var3, int var4) {
      super(var3, var4);
      aqg.c var5 = new aqg.c(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
      this.a.add(var5);
      var5.a((aqt)var5, (List)this.a, (Random)var2);
      this.c();
      this.a(var1, var2, 10);
   }

   public aqh() {
   }
}
