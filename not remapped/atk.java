import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class atk extends atn {
   private static final Logger b = LogManager.getLogger();

   public atk(File var1) {
      super(var1);
   }

   public boolean a(String var1, nu var2) {
      var2.a(0);
      ArrayList var3 = Lists.newArrayList();
      ArrayList var4 = Lists.newArrayList();
      ArrayList var5 = Lists.newArrayList();
      File var6 = new File(this.a, var1);
      File var7 = new File(var6, "DIM-1");
      File var8 = new File(var6, "DIM1");
      b.info("Scanning folders...");
      this.a((File)var6, (Collection)var3);
      if (var7.exists()) {
         this.a((File)var7, (Collection)var4);
      }

      if (var8.exists()) {
         this.a((File)var8, (Collection)var5);
      }

      int var9 = var3.size() + var4.size() + var5.size();
      b.info("Total conversion count is " + var9);
      ato var10 = this.c(var1);
      Object var11 = null;
      if (var10.u() == adr.c) {
         var11 = new aef(ady.q, 0.5F);
      } else {
         var11 = new aec(var10.b(), var10.u(), var10.B());
      }

      this.a(new File(var6, "region"), (Iterable)var3, (aec)var11, 0, var9, var2);
      this.a(new File(var7, "region"), (Iterable)var4, new aef(ady.x, 0.0F), var3.size(), var9, var2);
      this.a(new File(var8, "region"), (Iterable)var5, new aef(ady.y, 0.0F), var3.size() + var4.size(), var9, var2);
      var10.e(19133);
      if (var10.u() == adr.h) {
         var10.a(adr.b);
      }

      this.g(var1);
      atp var12 = this.a(var1, false);
      var12.a(var10);
      return true;
   }

   private void a(File var1, Iterable<File> var2, aec var3, int var4, int var5, nu var6) {
      Iterator var7 = var2.iterator();

      while(var7.hasNext()) {
         File var8 = (File)var7.next();
         this.a(var1, var8, var3, var4, var5, var6);
         ++var4;
         int var9 = (int)Math.round(100.0D * (double)var4 / (double)var5);
         var6.a(var9);
      }

   }

   public void d() {
      ani.a();
   }

   protected int c() {
      return 19133;
   }

   public atp a(String var1, boolean var2) {
      return new atj(this.a, var1, var2);
   }

   private void a(File var1, Collection<File> var2) {
      File var3 = new File(var1, "region");
      File[] var4 = var3.listFiles(new FilenameFilter(this) {
         final atk a;

         public boolean accept(File var1, String var2) {
            return var2.endsWith(".mcr");
         }

         {
            this.a = var1;
         }
      });
      if (var4 != null) {
         Collections.addAll(var2, var4);
      }

   }

   private void g(String var1) {
      File var2 = new File(this.a, var1);
      if (!var2.exists()) {
         b.warn("Unable to create level.dat_mcr backup");
      } else {
         File var3 = new File(var2, "level.dat");
         if (!var3.exists()) {
            b.warn("Unable to create level.dat_mcr backup");
         } else {
            File var4 = new File(var2, "level.dat_mcr");
            if (!var3.renameTo(var4)) {
               b.warn("Unable to create level.dat_mcr backup");
            }

         }
      }
   }

   public boolean b(String var1) {
      ato var2 = this.c(var1);
      return var2 != null && var2.l() != this.c();
   }

   public List<ats> b() throws atq {
      if (this.a != null && this.a.exists() && this.a.isDirectory()) {
         ArrayList var1 = Lists.newArrayList();
         File[] var2 = this.a.listFiles();
         File[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            File var6 = var3[var5];
            if (var6.isDirectory()) {
               String var7 = var6.getName();
               ato var8 = this.c(var7);
               if (var8 != null && (var8.l() == 19132 || var8.l() == 19133)) {
                  boolean var9 = var8.l() != this.c();
                  String var10 = var8.k();
                  if (StringUtils.isEmpty(var10)) {
                     var10 = var7;
                  }

                  long var11 = 0L;
                  var1.add(new ats(var7, var10, var8.m(), var11, var8.r(), var9, var8.t(), var8.v()));
               }
            }
         }

         return var1;
      } else {
         throw new atq("Unable to read or access folder where game worlds are saved!");
      }
   }

   public String a() {
      return "Anvil";
   }

   public boolean a(String var1) {
      ato var2 = this.c(var1);
      return var2 != null && var2.l() == 19132;
   }

   private void a(File var1, File var2, aec var3, int var4, int var5, nu var6) {
      try {
         String var7 = var2.getName();
         anh var8 = new anh(var2);
         anh var9 = new anh(new File(var1, var7.substring(0, var7.length() - ".mcr".length()) + ".mca"));

         for(int var10 = 0; var10 < 32; ++var10) {
            int var11;
            for(var11 = 0; var11 < 32; ++var11) {
               if (var8.c(var10, var11) && !var9.c(var10, var11)) {
                  DataInputStream var12 = var8.a(var10, var11);
                  if (var12 == null) {
                     b.warn("Failed to fetch input stream");
                  } else {
                     dn var13 = dx.a(var12);
                     var12.close();
                     dn var14 = var13.m("Level");
                     ang.a var15 = ang.a(var14);
                     dn var16 = new dn();
                     dn var17 = new dn();
                     var16.a((String)"Level", (eb)var17);
                     ang.a(var15, var17, var3);
                     DataOutputStream var18 = var9.b(var10, var11);
                     dx.a((dn)var16, (DataOutput)var18);
                     var18.close();
                  }
               }
            }

            var11 = (int)Math.round(100.0D * (double)(var4 * 1024) / (double)(var5 * 1024));
            int var20 = (int)Math.round(100.0D * (double)((var10 + 1) * 32 + var4 * 1024) / (double)(var5 * 1024));
            if (var20 > var11) {
               var6.a(var20);
            }
         }

         var8.c();
         var9.c();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

   }
}
