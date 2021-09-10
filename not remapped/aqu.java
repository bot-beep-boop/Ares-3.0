import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class aqu {
   private int d;
   protected aqe b;
   protected LinkedList<aqt> a = new LinkedList();
   private int c;

   protected void a(adm var1, Random var2, int var3) {
      int var4 = var1.F() - var3;
      int var5 = this.b.d() + 1;
      if (var5 < var4) {
         var5 += var2.nextInt(var4 - var5);
      }

      int var6 = var5 - this.b.e;
      this.b.a(0, var6, 0);
      Iterator var7 = this.a.iterator();

      while(var7.hasNext()) {
         aqt var8 = (aqt)var7.next();
         var8.a(0, var6, 0);
      }

   }

   public void a(adm var1, Random var2, aqe var3) {
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         aqt var5 = (aqt)var4.next();
         if (var5.c().a(var3) && !var5.a(var1, var2, var3)) {
            var4.remove();
         }
      }

   }

   public void a(adm var1, dn var2) {
      this.c = var2.f("ChunkX");
      this.d = var2.f("ChunkZ");
      if (var2.c("BB")) {
         this.b = new aqe(var2.l("BB"));
      }

      du var3 = var2.c("Children", 10);

      for(int var4 = 0; var4 < var3.c(); ++var4) {
         this.a.add(aqr.b(var3.b(var4), var1));
      }

      this.b(var2);
   }

   public dn a(int var1, int var2) {
      dn var3 = new dn();
      var3.a("id", aqr.a(this));
      var3.a("ChunkX", var1);
      var3.a("ChunkZ", var2);
      var3.a((String)"BB", (eb)this.b.g());
      du var4 = new du();
      Iterator var5 = this.a.iterator();

      while(var5.hasNext()) {
         aqt var6 = (aqt)var5.next();
         var4.a((eb)var6.b());
      }

      var3.a((String)"Children", (eb)var4);
      this.a(var3);
      return var3;
   }

   public void a(dn var1) {
   }

   public int e() {
      return this.c;
   }

   public boolean d() {
      return true;
   }

   public aqu(int var1, int var2) {
      this.c = var1;
      this.d = var2;
   }

   public int f() {
      return this.d;
   }

   public boolean a(adg var1) {
      return true;
   }

   protected void c() {
      this.b = aqe.a();
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         aqt var2 = (aqt)var1.next();
         this.b.b(var2.c());
      }

   }

   public void b(dn var1) {
   }

   public aqe a() {
      return this.b;
   }

   public aqu() {
   }

   public LinkedList<aqt> b() {
      return this.a;
   }

   protected void a(adm var1, Random var2, int var3, int var4) {
      int var5 = var4 - var3 + 1 - this.b.d();
      boolean var6 = true;
      int var10;
      if (var5 > 1) {
         var10 = var3 + var2.nextInt(var5);
      } else {
         var10 = var3;
      }

      int var7 = var10 - this.b.b;
      this.b.a(0, var7, 0);
      Iterator var8 = this.a.iterator();

      while(var8.hasNext()) {
         aqt var9 = (aqt)var8.next();
         var9.a(0, var7, 0);
      }

   }

   public void b(adg var1) {
   }
}
