import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class abo {
   private Map<zx, Float> c = Maps.newHashMap();
   private static final abo a = new abo();
   private Map<zx, zx> b = Maps.newHashMap();

   private boolean a(zx var1, zx var2) {
      return var2.b() == var1.b() && (var2.i() == 32767 || var2.i() == var1.i());
   }

   private abo() {
      this.a(afi.p, new zx(zy.j), 0.7F);
      this.a(afi.o, new zx(zy.k), 1.0F);
      this.a(afi.ag, new zx(zy.i), 1.0F);
      this.a((afh)afi.m, new zx(afi.w), 0.1F);
      this.a(zy.al, new zx(zy.am), 0.35F);
      this.a(zy.bi, new zx(zy.bj), 0.35F);
      this.a(zy.bk, new zx(zy.bl), 0.35F);
      this.a(zy.bo, new zx(zy.bp), 0.35F);
      this.a(zy.bm, new zx(zy.bn), 0.35F);
      this.a(afi.e, new zx(afi.b), 0.1F);
      this.a(new zx(afi.bf, 1, ajz.b), new zx(afi.bf, 1, ajz.O), 0.1F);
      this.a(zy.aI, new zx(zy.aH), 0.3F);
      this.a(afi.aL, new zx(afi.cz), 0.35F);
      this.a((afh)afi.aK, new zx(zy.aW, 1, zd.n.b()), 0.2F);
      this.a(afi.r, new zx(zy.h, 1, 1), 0.15F);
      this.a(afi.s, new zx(zy.h, 1, 1), 0.15F);
      this.a(afi.bP, new zx(zy.bO), 1.0F);
      this.a(zy.bS, new zx(zy.bT), 0.35F);
      this.a(afi.aV, new zx(zy.cf), 0.1F);
      this.a(new zx(afi.v, 1, 1), new zx(afi.v, 1, 0), 0.15F);
      zp.a[] var1 = zp.a.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         zp.a var4 = var1[var3];
         if (var4.g()) {
            this.a(new zx(zy.aU, 1, var4.a()), new zx(zy.aV, 1, var4.a()), 0.35F);
         }
      }

      this.a(afi.q, new zx(zy.h), 0.1F);
      this.a(afi.aC, new zx(zy.aC), 0.7F);
      this.a(afi.x, new zx(zy.aW, 1, zd.l.b()), 0.2F);
      this.a(afi.co, new zx(zy.cg), 0.2F);
   }

   public void a(zx var1, zx var2, float var3) {
      this.b.put(var1, var2);
      this.c.put(var2, var3);
   }

   public Map<zx, zx> b() {
      return this.b;
   }

   public float b(zx var1) {
      Iterator var2 = this.c.entrySet().iterator();

      Entry var3;
      do {
         if (!var2.hasNext()) {
            return 0.0F;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (zx)var3.getKey()));

      return (Float)var3.getValue();
   }

   public zx a(zx var1) {
      Iterator var2 = this.b.entrySet().iterator();

      Entry var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (zx)var3.getKey()));

      return (zx)var3.getValue();
   }

   public void a(afh var1, zx var2, float var3) {
      this.a(zw.a(var1), var2, var3);
   }

   public void a(zw var1, zx var2, float var3) {
      this.a(new zx(var1, 1, 32767), var2, var3);
   }

   public static abo a() {
      return a;
   }
}
