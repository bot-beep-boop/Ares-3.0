import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class la {
   private final le b;
   private Set<lh> c = Sets.newHashSet();
   private static final Logger a = LogManager.getLogger();
   private int e;
   private nm<lh> d = new nm();

   public void a(pk var1, int var2, int var3, boolean var4) {
      if (var2 > this.e) {
         var2 = this.e;
      }

      try {
         if (this.d.b(var1.F())) {
            throw new IllegalStateException("Entity is already tracked!");
         }

         lh var5 = new lh(var1, var2, var3, var4);
         this.c.add(var5);
         this.d.a(var1.F(), var5);
         var5.b(this.b.j);
      } catch (Throwable var11) {
         b var6 = b.a(var11, "Adding entity to track");
         c var7 = var6.a("Entity To Track");
         var7.a((String)"Tracking range", (Object)(var2 + " blocks"));
         var7.a("Update interval", new Callable<String>(this, var3) {
            final la b;
            final int a;

            {
               this.b = var1;
               this.a = var2;
            }

            public Object call() throws Exception {
               return this.a();
            }

            public String a() throws Exception {
               String var1 = "Once per " + this.a + " ticks";
               if (this.a == Integer.MAX_VALUE) {
                  var1 = "Maximum (" + var1 + ")";
               }

               return var1;
            }
         });
         var1.a(var7);
         c var8 = var6.a("Entity That Is Already Tracked");
         ((lh)this.d.a(var1.F())).a.a(var8);

         try {
            throw new e(var6);
         } catch (e var10) {
            a.error("\"Silently\" catching entity tracking error.", var10);
         }
      }

   }

   public void a(lf var1, amy var2) {
      Iterator var3 = this.c.iterator();

      while(var3.hasNext()) {
         lh var4 = (lh)var3.next();
         if (var4.a != var1 && var4.a.ae == var2.a && var4.a.ag == var2.b) {
            var4.b(var1);
         }
      }

   }

   public void a(pk var1, ff var2) {
      lh var3 = (lh)this.d.a(var1.F());
      if (var3 != null) {
         var3.a(var2);
      }

   }

   public void b(lf var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         lh var3 = (lh)var2.next();
         var3.d(var1);
      }

   }

   public void a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         lh var3 = (lh)var2.next();
         var3.a(this.b.j);
         if (var3.n && var3.a instanceof lf) {
            var1.add((lf)var3.a);
         }
      }

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         lf var7 = (lf)var1.get(var6);
         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            lh var5 = (lh)var4.next();
            if (var5.a != var7) {
               var5.b(var7);
            }
         }
      }

   }

   public void a(lf var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         lh var3 = (lh)var2.next();
         if (var3.a == var1) {
            var3.b(this.b.j);
         } else {
            var3.b(var1);
         }
      }

   }

   public la(le var1) {
      this.b = var1;
      this.e = var1.r().ap().d();
   }

   public void a(pk var1, int var2, int var3) {
      this.a(var1, var2, var3, false);
   }

   public void b(pk var1) {
      if (var1 instanceof lf) {
         lf var2 = (lf)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            lh var4 = (lh)var3.next();
            var4.a(var2);
         }
      }

      lh var5 = (lh)this.d.d(var1.F());
      if (var5 != null) {
         this.c.remove(var5);
         var5.a();
      }

   }

   public void a(pk var1) {
      if (var1 instanceof lf) {
         this.a(var1, 512, 2);
         lf var2 = (lf)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            lh var4 = (lh)var3.next();
            if (var4.a != var2) {
               var4.b(var2);
            }
         }
      } else if (var1 instanceof ur) {
         this.a(var1, 64, 5, true);
      } else if (var1 instanceof wq) {
         this.a(var1, 64, 20, false);
      } else if (var1 instanceof ww) {
         this.a(var1, 64, 10, false);
      } else if (var1 instanceof ws) {
         this.a(var1, 64, 10, false);
      } else if (var1 instanceof wx) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof xa) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof wr) {
         this.a(var1, 64, 4, true);
      } else if (var1 instanceof wz) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof xc) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof xb) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof wt) {
         this.a(var1, 64, 10, true);
      } else if (var1 instanceof uz) {
         this.a(var1, 64, 20, true);
      } else if (var1 instanceof va) {
         this.a(var1, 80, 3, true);
      } else if (var1 instanceof ux) {
         this.a(var1, 80, 3, true);
      } else if (var1 instanceof tx) {
         this.a(var1, 64, 3, true);
      } else if (var1 instanceof uk) {
         this.a(var1, 80, 3, false);
      } else if (var1 instanceof tk) {
         this.a(var1, 80, 3, false);
      } else if (var1 instanceof ug) {
         this.a(var1, 160, 3, true);
      } else if (var1 instanceof pi) {
         this.a(var1, 80, 3, true);
      } else if (var1 instanceof vj) {
         this.a(var1, 160, 10, true);
      } else if (var1 instanceof uy) {
         this.a(var1, 160, 20, true);
      } else if (var1 instanceof un) {
         this.a(var1, 160, Integer.MAX_VALUE, false);
      } else if (var1 instanceof um) {
         this.a(var1, 160, 3, true);
      } else if (var1 instanceof pp) {
         this.a(var1, 160, 20, true);
      } else if (var1 instanceof uf) {
         this.a(var1, 256, Integer.MAX_VALUE, false);
      }

   }

   public void b(pk var1, ff var2) {
      lh var3 = (lh)this.d.a(var1.F());
      if (var3 != null) {
         var3.b(var2);
      }

   }
}
