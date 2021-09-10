import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

public class bhc {
   public adm f;
   public static double c;
   public pk g;
   public double l;
   public static double d;
   private avn n;
   public bmj e;
   public double j;
   public float h;
   public static double b;
   public double k;
   private Map<Class<? extends akw>, bhd<? extends akw>> m = Maps.newHashMap();
   public static bhc a = new bhc();
   public float i;

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      bhd var10 = this.b(var1);
      if (var10 != null) {
         try {
            var10.a(var1, var2, var4, var6, var8, var9);
         } catch (Throwable var14) {
            b var12 = b.a(var14, "Rendering Block Entity");
            c var13 = var12.a("Block Entity Details");
            var1.a(var13);
            throw new e(var12);
         }
      }

   }

   public <T extends akw> bhd<T> b(akw var1) {
      return var1 == null ? null : this.a(var1.getClass());
   }

   public avn a() {
      return this.n;
   }

   public <T extends akw> bhd<T> a(Class<? extends akw> var1) {
      bhd var2 = (bhd)this.m.get(var1);
      if (var2 == null && var1 != akw.class) {
         var2 = this.a(var1.getSuperclass());
         this.m.put(var1, var2);
      }

      return var2;
   }

   public void a(adm var1) {
      this.f = var1;
   }

   public void a(adm var1, bmj var2, avn var3, pk var4, float var5) {
      if (this.f != var1) {
         this.a(var1);
      }

      this.e = var2;
      this.g = var4;
      this.n = var3;
      this.h = var4.A + (var4.y - var4.A) * var5;
      this.i = var4.B + (var4.z - var4.B) * var5;
      this.j = var4.P + (var4.s - var4.P) * (double)var5;
      this.k = var4.Q + (var4.t - var4.Q) * (double)var5;
      this.l = var4.R + (var4.u - var4.R) * (double)var5;
   }

   private bhc() {
      this.m.put(aln.class, new bhj());
      this.m.put(all.class, new bhh());
      this.m.put(alu.class, new bhi());
      this.m.put(aky.class, new bhe());
      this.m.put(alf.class, new bhg());
      this.m.put(ale.class, new bhf());
      this.m.put(alp.class, new bhl());
      this.m.put(akv.class, new bhb());
      this.m.put(alo.class, new bhk());
      this.m.put(aku.class, new bha());
      Iterator var1 = this.m.values().iterator();

      while(var1.hasNext()) {
         bhd var2 = (bhd)var1.next();
         var2.a(this);
      }

   }

   public void a(akw var1, float var2, int var3) {
      if (var1.a(this.j, this.k, this.l) < var1.s()) {
         int var4 = this.f.b(var1.v(), 0);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         bqs.a(bqs.r, (float)var5 / 1.0F, (float)var6 / 1.0F);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         cj var7 = var1.v();
         this.a(var1, (double)var7.n() - b, (double)var7.o() - c, (double)var7.p() - d, var2, var3);
      }

   }

   public void a(akw var1, double var2, double var4, double var6, float var8) {
      this.a(var1, var2, var4, var6, var8, -1);
   }
}
