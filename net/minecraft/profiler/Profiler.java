package net.minecraft.profiler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.src.Config;
import net.optifine.Lagometer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Profiler {
   private static final String DISPLAY = "display";
   private static final Logger logger = LogManager.getLogger();
   private final List<String> sectionList = Lists.newArrayList();
   private String profilingSection = "";
   private static final String SCHEDULED_EXECUTABLES = "scheduledExecutables";
   public boolean profilerGlobalEnabled = true;
   private static final String PRE_RENDER_ERRORS = "preRenderErrors";
   private static final String TICK = "tick";
   private static final int HASH_TICK = "tick".hashCode();
   public boolean profilingEnabled;
   private boolean profilerLocalEnabled;
   private final List<Long> timestampList = Lists.newArrayList();
   private static final int HASH_PRE_RENDER_ERRORS = "preRenderErrors".hashCode();
   private final Map<String, Long> profilingMap = Maps.newHashMap();
   private static final int HASH_DISPLAY = "display".hashCode();
   private static final int HASH_SCHEDULED_EXECUTABLES = "scheduledExecutables".hashCode();
   private static final int HASH_RENDER = "render".hashCode();
   private static final String RENDER = "render";

   public void clearProfiling() {
      this.profilingMap.clear();
      this.profilingSection = "";
      this.sectionList.clear();
      this.profilerLocalEnabled = this.profilerGlobalEnabled;
   }

   public void startSection(String var1) {
      int var2;
      if (Lagometer.isActive()) {
         var2 = var1.hashCode();
         if (var2 == HASH_SCHEDULED_EXECUTABLES && var1.equals("scheduledExecutables")) {
            Lagometer.timerScheduledExecutables.start();
         } else if (var2 == HASH_TICK && var1.equals("tick") && Config.isMinecraftThread()) {
            Lagometer.timerScheduledExecutables.end();
            Lagometer.timerTick.start();
         } else if (var2 == HASH_PRE_RENDER_ERRORS && var1.equals("preRenderErrors")) {
            Lagometer.timerTick.end();
         }
      }

      if (Config.isFastRender()) {
         var2 = var1.hashCode();
         if (var2 == HASH_RENDER && var1.equals("render")) {
            GlStateManager.clearEnabled = false;
         } else if (var2 == HASH_DISPLAY && var1.equals("display")) {
            GlStateManager.clearEnabled = true;
         }
      }

      if (this.profilerLocalEnabled && this.profilingEnabled) {
         if (this.profilingSection.length() > 0) {
            this.profilingSection = this.profilingSection + ".";
         }

         this.profilingSection = this.profilingSection + var1;
         this.sectionList.add(this.profilingSection);
         this.timestampList.add(System.nanoTime());
      }

   }

   public void startSection(Class<?> var1) {
      if (this.profilingEnabled) {
         this.startSection(var1.getSimpleName());
      }

   }

   public Profiler() {
      this.profilerLocalEnabled = this.profilerGlobalEnabled;
   }

   public String getNameOfLastSection() {
      return this.sectionList.size() == 0 ? "[UNKNOWN]" : (String)this.sectionList.get(this.sectionList.size() - 1);
   }

   public void endSection() {
      if (this.profilerLocalEnabled && this.profilingEnabled) {
         long var1 = System.nanoTime();
         long var3 = (Long)this.timestampList.remove(this.timestampList.size() - 1);
         this.sectionList.remove(this.sectionList.size() - 1);
         long var5 = var1 - var3;
         if (this.profilingMap.containsKey(this.profilingSection)) {
            this.profilingMap.put(this.profilingSection, (Long)this.profilingMap.get(this.profilingSection) + var5);
         } else {
            this.profilingMap.put(this.profilingSection, var5);
         }

         if (var5 > 100000000L) {
            logger.warn("Something's taking too long! '" + this.profilingSection + "' took aprox " + (double)var5 / 1000000.0D + " ms");
         }

         this.profilingSection = !this.sectionList.isEmpty() ? (String)this.sectionList.get(this.sectionList.size() - 1) : "";
      }

   }

   public List<Profiler.Result> getProfilingData(String var1) {
      if (!this.profilingEnabled) {
         return null;
      } else {
         long var2 = this.profilingMap.containsKey("root") ? (Long)this.profilingMap.get("root") : 0L;
         long var4 = this.profilingMap.containsKey(var1) ? (Long)this.profilingMap.get(var1) : -1L;
         ArrayList var6 = Lists.newArrayList();
         if (var1.length() > 0) {
            var1 = var1 + ".";
         }

         long var7 = 0L;
         Iterator var10 = this.profilingMap.keySet().iterator();

         while(var10.hasNext()) {
            String var9 = (String)var10.next();
            if (var9.length() > var1.length() && var9.startsWith(var1) && var9.indexOf(".", var1.length() + 1) < 0) {
               var7 += (Long)this.profilingMap.get(var9);
            }
         }

         float var19 = (float)var7;
         if (var7 < var4) {
            var7 = var4;
         }

         if (var2 < var7) {
            var2 = var7;
         }

         Iterator var11 = this.profilingMap.keySet().iterator();

         String var20;
         while(var11.hasNext()) {
            var20 = (String)var11.next();
            if (var20.length() > var1.length() && var20.startsWith(var1) && var20.indexOf(".", var1.length() + 1) < 0) {
               long var12 = (Long)this.profilingMap.get(var20);
               double var14 = (double)var12 * 100.0D / (double)var7;
               double var16 = (double)var12 * 100.0D / (double)var2;
               String var18 = var20.substring(var1.length());
               var6.add(new Profiler.Result(var18, var14, var16));
            }
         }

         var11 = this.profilingMap.keySet().iterator();

         while(var11.hasNext()) {
            var20 = (String)var11.next();
            this.profilingMap.put(var20, (Long)this.profilingMap.get(var20) * 950L / 1000L);
         }

         if ((float)var7 > var19) {
            var6.add(new Profiler.Result("unspecified", (double)((float)var7 - var19) * 100.0D / (double)var7, (double)((float)var7 - var19) * 100.0D / (double)var2));
         }

         Collections.sort(var6);
         var6.add(0, new Profiler.Result(var1, 100.0D, (double)var7 * 100.0D / (double)var2));
         return var6;
      }
   }

   public void endStartSection(String var1) {
      if (this.profilerLocalEnabled) {
         this.endSection();
         this.startSection(var1);
      }

   }

   public static final class Result implements Comparable<Profiler.Result> {
      public double field_76330_b;
      public double field_76332_a;
      public String field_76331_c;

      public int compareTo(Object var1) {
         return this.compareTo((Profiler.Result)var1);
      }

      public Result(String var1, double var2, double var4) {
         this.field_76331_c = var1;
         this.field_76332_a = var2;
         this.field_76330_b = var4;
      }

      public int compareTo(Profiler.Result var1) {
         return var1.field_76332_a < this.field_76332_a ? -1 : (var1.field_76332_a > this.field_76332_a ? 1 : var1.field_76331_c.compareTo(this.field_76331_c));
      }

      public int getColor() {
         return (this.field_76331_c.hashCode() & 11184810) + 4473924;
      }
   }
}
