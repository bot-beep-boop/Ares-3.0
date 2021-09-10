import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class adk {
   private TreeMap<String, adk.a> a = new TreeMap();

   public void a(String var1, String var2, adk.b var3) {
      this.a.put(var1, new adk.a(var2, var3));
   }

   public int c(String var1) {
      adk.a var2 = (adk.a)this.a.get(var1);
      return var2 != null ? var2.c() : 0;
   }

   public void a(dn var1) {
      Set var2 = var1.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var6 = var1.j(var4);
         this.a(var4, var6);
      }

   }

   public boolean e(String var1) {
      return this.a.containsKey(var1);
   }

   public dn a() {
      dn var1 = new dn();
      Iterator var2 = this.a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         adk.a var4 = (adk.a)this.a.get(var3);
         var1.a(var3, var4.a());
      }

      return var1;
   }

   public adk() {
      this.a("doFireTick", "true", adk.b.b);
      this.a("mobGriefing", "true", adk.b.b);
      this.a("keepInventory", "false", adk.b.b);
      this.a("doMobSpawning", "true", adk.b.b);
      this.a("doMobLoot", "true", adk.b.b);
      this.a("doTileDrops", "true", adk.b.b);
      this.a("doEntityDrops", "true", adk.b.b);
      this.a("commandBlockOutput", "true", adk.b.b);
      this.a("naturalRegeneration", "true", adk.b.b);
      this.a("doDaylightCycle", "true", adk.b.b);
      this.a("logAdminCommands", "true", adk.b.b);
      this.a("showDeathMessages", "true", adk.b.b);
      this.a("randomTickSpeed", "3", adk.b.c);
      this.a("sendCommandFeedback", "true", adk.b.b);
      this.a("reducedDebugInfo", "false", adk.b.b);
   }

   public void a(String var1, String var2) {
      adk.a var3 = (adk.a)this.a.get(var1);
      if (var3 != null) {
         var3.a(var2);
      } else {
         this.a(var1, var2, adk.b.a);
      }

   }

   public boolean a(String var1, adk.b var2) {
      adk.a var3 = (adk.a)this.a.get(var1);
      return var3 != null && (var3.e() == var2 || var2 == adk.b.a);
   }

   public String[] b() {
      Set var1 = this.a.keySet();
      return (String[])var1.toArray(new String[var1.size()]);
   }

   public boolean b(String var1) {
      adk.a var2 = (adk.a)this.a.get(var1);
      return var2 != null ? var2.b() : false;
   }

   public String a(String var1) {
      adk.a var2 = (adk.a)this.a.get(var1);
      return var2 != null ? var2.a() : "";
   }

   public static enum b {
      private static final adk.b[] d = new adk.b[]{a, b, c};
      b,
      c,
      a;
   }

   static class a {
      private int c;
      private boolean b;
      private String a;
      private final adk.b e;
      private double d;

      public adk.b e() {
         return this.e;
      }

      public a(String var1, adk.b var2) {
         this.e = var2;
         this.a(var1);
      }

      public void a(String var1) {
         this.a = var1;
         this.b = Boolean.parseBoolean(var1);
         this.c = this.b ? 1 : 0;

         try {
            this.c = Integer.parseInt(var1);
         } catch (NumberFormatException var4) {
         }

         try {
            this.d = Double.parseDouble(var1);
         } catch (NumberFormatException var3) {
         }

      }

      public String a() {
         return this.a;
      }

      public boolean b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }
   }
}
