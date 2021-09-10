import java.util.Random;

public class ayx {
   private Random b = new Random();
   private static final ayx a = new ayx();
   private String[] c = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");

   public static ayx a() {
      return a;
   }

   private ayx() {
   }

   public void a(long var1) {
      this.b.setSeed(var1);
   }

   public String b() {
      int var1 = this.b.nextInt(2) + 3;
      String var2 = "";

      for(int var3 = 0; var3 < var1; ++var3) {
         if (var3 > 0) {
            var2 = var2 + " ";
         }

         var2 = var2 + this.c[this.b.nextInt(this.c.length)];
      }

      return var2;
   }
}
