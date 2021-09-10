import com.google.common.collect.Lists;
import java.util.List;

public abstract class bfh {
   protected boolean b;
   protected List<bht> a = Lists.newArrayListWithCapacity(17424);
   private double d;
   private double e;
   private double c;

   public void a(double var1, double var3, double var5) {
      this.b = true;
      this.a.clear();
      this.c = var1;
      this.d = var3;
      this.e = var5;
   }

   public abstract void a(adf var1);

   public void a(bht var1, adf var2) {
      this.a.add(var1);
   }

   public void a(bht var1) {
      cj var2 = var1.j();
      bfl.b((float)((double)var2.n() - this.c), (float)((double)var2.o() - this.d), (float)((double)var2.p() - this.e));
   }
}
