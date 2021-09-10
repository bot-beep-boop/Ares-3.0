import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class re {
   private int f = 3;
   private List<re.a> c = Lists.newArrayList();
   private final nt d;
   private List<re.a> b = Lists.newArrayList();
   private static final Logger a = LogManager.getLogger();
   private int e;

   public void a(int var1, rd var2) {
      this.b.add(new re.a(this, var1, var2));
   }

   private boolean a(re.a var1, re.a var2) {
      return (var1.a.j() & var2.a.j()) == 0;
   }

   private boolean a(re.a var1) {
      boolean var2 = var1.a.b();
      return var2;
   }

   public void a(rd var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         re.a var3 = (re.a)var2.next();
         rd var4 = var3.a;
         if (var4 == var1) {
            if (this.c.contains(var3)) {
               var4.d();
               this.c.remove(var3);
            }

            var2.remove();
         }
      }

   }

   private boolean b(re.a var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         re.a var3 = (re.a)var2.next();
         if (var3 != var1) {
            if (var1.b >= var3.b) {
               if (!this.a(var1, var3) && this.c.contains(var3)) {
                  return false;
               }
            } else if (!var3.a.i() && this.c.contains(var3)) {
               return false;
            }
         }
      }

      return true;
   }

   public void a() {
      this.d.a("goalSetup");
      Iterator var1;
      re.a var2;
      if (this.e++ % this.f == 0) {
         var1 = this.b.iterator();

         label69:
         while(true) {
            while(true) {
               if (!var1.hasNext()) {
                  break label69;
               }

               var2 = (re.a)var1.next();
               boolean var3 = this.c.contains(var2);
               if (!var3) {
                  break;
               }

               if (!this.b(var2) || !this.a(var2)) {
                  var2.a.d();
                  this.c.remove(var2);
                  break;
               }
            }

            if (this.b(var2) && var2.a.a()) {
               var2.a.c();
               this.c.add(var2);
            }
         }
      } else {
         var1 = this.c.iterator();

         while(var1.hasNext()) {
            var2 = (re.a)var1.next();
            if (!this.a(var2)) {
               var2.a.d();
               var1.remove();
            }
         }
      }

      this.d.b();
      this.d.a("goalTick");
      var1 = this.c.iterator();

      while(var1.hasNext()) {
         var2 = (re.a)var1.next();
         var2.a.e();
      }

      this.d.b();
   }

   public re(nt var1) {
      this.d = var1;
   }

   class a {
      public int b;
      final re c;
      public rd a;

      public a(re var1, int var2, rd var3) {
         this.c = var1;
         this.b = var2;
         this.a = var3;
      }
   }
}
