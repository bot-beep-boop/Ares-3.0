import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class atn implements atr {
   private static final Logger b = LogManager.getLogger();
   protected final File a;

   public boolean b(String var1) {
      return false;
   }

   public boolean a(String var1) {
      return false;
   }

   public boolean a(String var1, nu var2) {
      return false;
   }

   public void d() {
   }

   public String a() {
      return "Old Format";
   }

   public ato c(String var1) {
      File var2 = new File(this.a, var1);
      if (!var2.exists()) {
         return null;
      } else {
         File var3 = new File(var2, "level.dat");
         dn var4;
         dn var5;
         if (var3.exists()) {
            try {
               var4 = dx.a((InputStream)(new FileInputStream(var3)));
               var5 = var4.m("Data");
               return new ato(var5);
            } catch (Exception var7) {
               b.error("Exception reading " + var3, var7);
            }
         }

         var3 = new File(var2, "level.dat_old");
         if (var3.exists()) {
            try {
               var4 = dx.a((InputStream)(new FileInputStream(var3)));
               var5 = var4.m("Data");
               return new ato(var5);
            } catch (Exception var6) {
               b.error("Exception reading " + var3, var6);
            }
         }

         return null;
      }
   }

   public boolean d(String var1) {
      File var2 = new File(this.a, var1);
      if (var2.exists()) {
         return false;
      } else {
         try {
            var2.mkdir();
            var2.delete();
            return true;
         } catch (Throwable var4) {
            b.warn("Couldn't make new level", var4);
            return false;
         }
      }
   }

   public atn(File var1) {
      if (!var1.exists()) {
         var1.mkdirs();
      }

      this.a = var1;
   }

   protected static boolean a(File[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         File var2 = var0[var1];
         b.debug("Deleting " + var2);
         if (var2.isDirectory() && !a(var2.listFiles())) {
            b.warn("Couldn't delete directory " + var2);
            return false;
         }

         if (!var2.delete()) {
            b.warn("Couldn't delete file " + var2);
            return false;
         }
      }

      return true;
   }

   public atp a(String var1, boolean var2) {
      return new atm(this.a, var1, var2);
   }

   public void a(String var1, String var2) {
      File var3 = new File(this.a, var1);
      if (var3.exists()) {
         File var4 = new File(var3, "level.dat");
         if (var4.exists()) {
            try {
               dn var5 = dx.a((InputStream)(new FileInputStream(var4)));
               dn var6 = var5.m("Data");
               var6.a("LevelName", var2);
               dx.a((dn)var5, (OutputStream)(new FileOutputStream(var4)));
            } catch (Exception var7) {
               var7.printStackTrace();
            }
         }

      }
   }

   public boolean f(String var1) {
      File var2 = new File(this.a, var1);
      return var2.isDirectory();
   }

   public boolean e(String var1) {
      File var2 = new File(this.a, var1);
      if (!var2.exists()) {
         return true;
      } else {
         b.info("Deleting level " + var1);

         for(int var3 = 1; var3 <= 5; ++var3) {
            b.info("Attempt " + var3 + "...");
            if (a(var2.listFiles())) {
               break;
            }

            b.warn("Unsuccessful in deleting contents.");
            if (var3 < 5) {
               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var5) {
               }
            }
         }

         return var2.delete();
      }
   }

   public List<ats> b() throws atq {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < 5; ++var2) {
         String var3 = "World" + (var2 + 1);
         ato var4 = this.c(var3);
         if (var4 != null) {
            var1.add(new ats(var3, "", var4.m(), var4.h(), var4.r(), false, var4.t(), var4.v()));
         }
      }

      return var1;
   }
}
