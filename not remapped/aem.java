import com.google.common.collect.Lists;
import java.util.Random;

public class aem extends ady {
   protected ady aE;

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      this.aE.a(var1, var2, var3, var4, var5, var6);
   }

   public float g() {
      return this.aE.g();
   }

   public int c(cj var1) {
      return this.aE.c(var1);
   }

   public aoh a(Random var1) {
      return this.aE.a(var1);
   }

   public aem(int var1, ady var2) {
      super(var1);
      this.aE = var2;
      this.a(var2.ai, true);
      this.ah = var2.ah + " M";
      this.ak = var2.ak;
      this.al = var2.al;
      this.am = var2.am;
      this.an = var2.an;
      this.ao = var2.ao;
      this.ap = var2.ap;
      this.aq = var2.aq;
      this.ar = var2.ar;
      this.ax = var2.ax;
      this.ay = var2.ay;
      this.au = Lists.newArrayList(var2.au);
      this.at = Lists.newArrayList(var2.at);
      this.aw = Lists.newArrayList(var2.aw);
      this.av = Lists.newArrayList(var2.av);
      this.ap = var2.ap;
      this.aq = var2.aq;
      this.an = var2.an + 0.1F;
      this.ao = var2.ao + 0.2F;
   }

   public void a(adm var1, Random var2, cj var3) {
      this.aE.as.a(var1, var2, this, var3);
   }

   public ady.b m() {
      return this.aE.m();
   }

   public int b(cj var1) {
      return this.aE.b(var1);
   }

   public boolean a(ady var1) {
      return this.aE.a(var1);
   }

   public Class<? extends ady> l() {
      return this.aE.l();
   }
}
