import com.google.common.collect.Maps;
import java.util.Map;

public enum bpg {
   private final String l;
   private static final Map<Integer, bpg> k = Maps.newHashMap();
   private static final bpg[] n = new bpg[]{a, b, c, d, e, f, g, h, i};
   g("neutral", 6),
   b("music", 1);

   private static final Map<String, bpg> j = Maps.newHashMap();
   f("hostile", 5),
   e("block", 4),
   h("player", 7),
   d("weather", 3),
   c("record", 2);

   private final int m;
   i("ambient", 8),
   a("master", 0);

   public static bpg a(String var0) {
      return (bpg)j.get(var0);
   }

   private bpg(String var3, int var4) {
      this.l = var3;
      this.m = var4;
   }

   static {
      bpg[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         bpg var3 = var0[var2];
         if (j.containsKey(var3.a()) || k.containsKey(var3.b())) {
            throw new Error("Clash in Sound Category ID & Name pools! Cannot insert " + var3);
         }

         j.put(var3.a(), var3);
         k.put(var3.b(), var3);
      }

   }

   public int b() {
      return this.m;
   }

   public String a() {
      return this.l;
   }
}
