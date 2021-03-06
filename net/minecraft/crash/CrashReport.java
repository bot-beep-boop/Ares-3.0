package net.minecraft.crash;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.util.ReportedException;
import net.minecraft.world.gen.layer.IntCache;
import net.optifine.CrashReporter;
import net.optifine.reflect.Reflector;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrashReport {
   private final CrashReportCategory theReportCategory = new CrashReportCategory(this, "System Details");
   private final String description;
   private StackTraceElement[] stacktrace = new StackTraceElement[0];
   private boolean firstCategoryInCrashReport = true;
   private static final Logger logger = LogManager.getLogger();
   private boolean reported = false;
   private final Throwable cause;
   private final List<CrashReportCategory> crashReportSections = Lists.newArrayList();
   private File crashReportFile;

   public boolean saveToFile(File var1) {
      if (this.crashReportFile != null) {
         return false;
      } else {
         if (var1.getParentFile() != null) {
            var1.getParentFile().mkdirs();
         }

         try {
            FileWriter var2 = new FileWriter(var1);
            var2.write(this.getCompleteReport());
            var2.close();
            this.crashReportFile = var1;
            return true;
         } catch (Throwable var3) {
            logger.error("Could not save crash report to " + var1, var3);
            return false;
         }
      }
   }

   public CrashReportCategory makeCategory(String var1) {
      return this.makeCategoryDepth(var1, 1);
   }

   public Throwable getCrashCause() {
      return this.cause;
   }

   private void populateEnvironment() {
      this.theReportCategory.addCrashSectionCallable("Minecraft Version", new Callable<String>(this) {
         final CrashReport this$0;

         public String call() {
            return "1.8.9";
         }

         {
            this.this$0 = var1;
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      this.theReportCategory.addCrashSectionCallable("Operating System", new Callable<String>(this) {
         final CrashReport this$0;

         {
            this.this$0 = var1;
         }

         public String call() {
            return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      this.theReportCategory.addCrashSectionCallable("Java Version", new Callable<String>(this) {
         final CrashReport this$0;

         public String call() {
            return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
         }

         public Object call() throws Exception {
            return this.call();
         }

         {
            this.this$0 = var1;
         }
      });
      this.theReportCategory.addCrashSectionCallable("Java VM Version", new Callable<String>(this) {
         final CrashReport this$0;

         public String call() {
            return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
         }

         public Object call() throws Exception {
            return this.call();
         }

         {
            this.this$0 = var1;
         }
      });
      this.theReportCategory.addCrashSectionCallable("Memory", new Callable<String>(this) {
         final CrashReport this$0;

         public String call() {
            Runtime var1 = Runtime.getRuntime();
            long var2 = var1.maxMemory();
            long var4 = var1.totalMemory();
            long var6 = var1.freeMemory();
            long var8 = var2 / 1024L / 1024L;
            long var10 = var4 / 1024L / 1024L;
            long var12 = var6 / 1024L / 1024L;
            return var6 + " bytes (" + var12 + " MB) / " + var4 + " bytes (" + var10 + " MB) up to " + var2 + " bytes (" + var8 + " MB)";
         }

         {
            this.this$0 = var1;
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      this.theReportCategory.addCrashSectionCallable("JVM Flags", new Callable<String>(this) {
         final CrashReport this$0;

         public String call() {
            RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
            List var2 = var1.getInputArguments();
            int var3 = 0;
            StringBuilder var4 = new StringBuilder();
            Iterator var6 = var2.iterator();

            while(var6.hasNext()) {
               String var5 = (String)var6.next();
               if (var5.startsWith("-X")) {
                  if (var3++ > 0) {
                     var4.append(" ");
                  }

                  var4.append(var5);
               }
            }

            return String.format("%d total; %s", var3, var4.toString());
         }

         {
            this.this$0 = var1;
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      this.theReportCategory.addCrashSectionCallable("IntCache", new Callable<String>(this) {
         final CrashReport this$0;

         {
            this.this$0 = var1;
         }

         public Object call() throws Exception {
            return this.call();
         }

         public String call() throws Exception {
            return IntCache.getCacheSizes();
         }
      });
      if (Reflector.FMLCommonHandler_enhanceCrashReport.exists()) {
         Object var1 = Reflector.call(Reflector.FMLCommonHandler_instance);
         Reflector.callString(var1, Reflector.FMLCommonHandler_enhanceCrashReport, this, this.theReportCategory);
      }

   }

   public static CrashReport makeCrashReport(Throwable var0, String var1) {
      CrashReport var2;
      if (var0 instanceof ReportedException) {
         var2 = ((ReportedException)var0).getCrashReport();
      } else {
         var2 = new CrashReport(var1, var0);
      }

      return var2;
   }

   public CrashReportCategory getCategory() {
      return this.theReportCategory;
   }

   public CrashReportCategory makeCategoryDepth(String var1, int var2) {
      CrashReportCategory var3 = new CrashReportCategory(this, var1);
      if (this.firstCategoryInCrashReport) {
         int var4 = var3.getPrunedStackTrace(var2);
         StackTraceElement[] var5 = this.cause.getStackTrace();
         StackTraceElement var6 = null;
         StackTraceElement var7 = null;
         int var8 = var5.length - var4;
         if (var8 < 0) {
            System.out.println("Negative index in crash report handler (" + var5.length + "/" + var4 + ")");
         }

         if (var5 != null && var8 >= 0 && var8 < var5.length) {
            var6 = var5[var8];
            if (var5.length + 1 - var4 < var5.length) {
               var7 = var5[var5.length + 1 - var4];
            }
         }

         this.firstCategoryInCrashReport = var3.firstTwoElementsOfStackTraceMatch(var6, var7);
         if (var4 > 0 && !this.crashReportSections.isEmpty()) {
            CrashReportCategory var9 = (CrashReportCategory)this.crashReportSections.get(this.crashReportSections.size() - 1);
            var9.trimStackTraceEntriesFromBottom(var4);
         } else if (var5 != null && var5.length >= var4 && var8 >= 0 && var8 < var5.length) {
            System.arraycopy(var5, 0, this.stacktrace = new StackTraceElement[var8], 0, this.stacktrace.length);
         } else {
            this.firstCategoryInCrashReport = false;
         }
      }

      this.crashReportSections.add(var3);
      return var3;
   }

   public File getFile() {
      return this.crashReportFile;
   }

   public String getDescription() {
      return this.description;
   }

   public String getCauseStackTraceOrString() {
      StringWriter var1 = null;
      PrintWriter var2 = null;
      Object var3 = this.cause;
      if (((Throwable)var3).getMessage() == null) {
         if (var3 instanceof NullPointerException) {
            var3 = new NullPointerException(this.description);
         } else if (var3 instanceof StackOverflowError) {
            var3 = new StackOverflowError(this.description);
         } else if (var3 instanceof OutOfMemoryError) {
            var3 = new OutOfMemoryError(this.description);
         }

         ((Throwable)var3).setStackTrace(this.cause.getStackTrace());
      }

      String var4 = ((Throwable)var3).toString();

      try {
         var1 = new StringWriter();
         var2 = new PrintWriter(var1);
         ((Throwable)var3).printStackTrace(var2);
         var4 = var1.toString();
         IOUtils.closeQuietly(var1);
         IOUtils.closeQuietly(var2);
         return var4;
      } finally {
         IOUtils.closeQuietly(var1);
         IOUtils.closeQuietly(var2);
      }
   }

   private static String getWittyComment() {
      String[] var0 = new String[]{"Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine."};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public CrashReport(String var1, Throwable var2) {
      this.description = var1;
      this.cause = var2;
      this.populateEnvironment();
   }

   public String getCompleteReport() {
      if (!this.reported) {
         this.reported = true;
         CrashReporter.onCrashReport(this, this.theReportCategory);
      }

      StringBuilder var1 = new StringBuilder();
      var1.append("---- Minecraft Crash Report ----\n");
      Reflector.call(Reflector.BlamingTransformer_onCrash, var1);
      Reflector.call(Reflector.CoreModManager_onCrash, var1);
      var1.append("// ");
      var1.append(getWittyComment());
      var1.append("\n\n");
      var1.append("Time: ");
      var1.append((new SimpleDateFormat()).format(new Date()));
      var1.append("\n");
      var1.append("Description: ");
      var1.append(this.description);
      var1.append("\n\n");
      var1.append(this.getCauseStackTraceOrString());
      var1.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

      for(int var2 = 0; var2 < 87; ++var2) {
         var1.append("-");
      }

      var1.append("\n\n");
      this.getSectionsInStringBuilder(var1);
      return var1.toString();
   }

   public void getSectionsInStringBuilder(StringBuilder var1) {
      if ((this.stacktrace == null || this.stacktrace.length <= 0) && this.crashReportSections.size() > 0) {
         this.stacktrace = (StackTraceElement[])ArrayUtils.subarray(((CrashReportCategory)this.crashReportSections.get(0)).getStackTrace(), 0, 1);
      }

      if (this.stacktrace != null && this.stacktrace.length > 0) {
         var1.append("-- Head --\n");
         var1.append("Stacktrace:\n");
         StackTraceElement[] var5;
         int var4 = (var5 = this.stacktrace).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            StackTraceElement var2 = var5[var3];
            var1.append("\t").append("at ").append(var2.toString());
            var1.append("\n");
         }

         var1.append("\n");
      }

      Iterator var7 = this.crashReportSections.iterator();

      while(var7.hasNext()) {
         CrashReportCategory var6 = (CrashReportCategory)var7.next();
         var6.appendToStringBuilder(var1);
         var1.append("\n\n");
      }

      this.theReportCategory.appendToStringBuilder(var1);
   }
}
