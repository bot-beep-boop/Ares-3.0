import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bcz implements amv {
   private static final Logger a = LogManager.getLogger();
   private amy b;
   private nq<amy> c = new nq();
   private adm e;
   private List<amy> d = Lists.newArrayList();

   public void a(amv var1, int var2, int var3) {
   }

   public cj a(adm var1, String var2, cj var3) {
      return null;
   }

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public boolean e() {
      return false;
   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public String f() {
      return "MultiplayerChunkCache: " + this.c.a() + ", " + this.d.size();
   }

   public List<ady.c> a(pt var1, cj var2) {
      return null;
   }

   public void b(int var1, int var2) {
      amy var3 = this.d(var1, var2);
      if (!var3.f()) {
         var3.d();
      }

      this.c.d(adg.a(var1, var2));
      this.d.remove(var3);
   }

   public amy d(int var1, int var2) {
      amy var3 = (amy)this.c.a(adg.a(var1, var2));
      return var3 == null ? this.b : var3;
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      return false;
   }

   public int g() {
      return this.d.size();
   }

   public amy c(int var1, int var2) {
      amy var3 = new amy(this.e, var1, var2);
      this.c.a(adg.a(var1, var2), var3);
      this.d.add(var3);
      var3.c(true);
      return var3;
   }

   public void a(amy var1, int var2, int var3) {
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public boolean d() {
      long var1 = System.currentTimeMillis();
      Iterator var3 = this.d.iterator();

      while(var3.hasNext()) {
         amy var4 = (amy)var3.next();
         var4.b(System.currentTimeMillis() - var1 > 5L);
      }

      if (System.currentTimeMillis() - var1 > 100L) {
         a.info("Warning: Clientside chunk ticking took {} ms", new Object[]{System.currentTimeMillis() - var1});
      }

      return false;
   }

   public bcz(adm var1) {
      this.b = new amx(var1, 0, 0);
      this.e = var1;
   }

   public void c() {
   }
}
