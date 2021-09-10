package net.minecraft.profiler;

import com.google.common.collect.Maps;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.util.HttpUtil;

public class PlayerUsageSnooper {
   private final Object syncLock = new Object();
   private final long minecraftStartTimeMilis;
   private final IPlayerUsage playerStatsCollector;
   private final Timer threadTrigger = new Timer("Snooper Timer", true);
   private final URL serverUrl;
   private int selfCounter;
   private final Map<String, Object> clientStats = Maps.newHashMap();
   private boolean isRunning;
   private final String uniqueID = UUID.randomUUID().toString();
   private final Map<String, Object> snooperStats = Maps.newHashMap();

   public void addStatToSnooper(String var1, Object var2) {
      synchronized(this.syncLock) {
         this.snooperStats.put(var1, var2);
      }
   }

   private void addOSData() {
      this.addJvmArgsToSnooper();
      this.addClientStat("snooper_token", this.uniqueID);
      this.addStatToSnooper("snooper_token", this.uniqueID);
      this.addStatToSnooper("os_name", System.getProperty("os.name"));
      this.addStatToSnooper("os_version", System.getProperty("os.version"));
      this.addStatToSnooper("os_architecture", System.getProperty("os.arch"));
      this.addStatToSnooper("java_version", System.getProperty("java.version"));
      this.addClientStat("version", "1.8.9");
      this.playerStatsCollector.addServerTypeToSnooper(this);
   }

   public Map<String, String> getCurrentStats() {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      synchronized(this.syncLock) {
         this.addMemoryStatsToSnooper();
         Iterator var4 = this.snooperStats.entrySet().iterator();

         Entry var3;
         while(var4.hasNext()) {
            var3 = (Entry)var4.next();
            var1.put((String)var3.getKey(), var3.getValue().toString());
         }

         var4 = this.clientStats.entrySet().iterator();

         while(var4.hasNext()) {
            var3 = (Entry)var4.next();
            var1.put((String)var3.getKey(), var3.getValue().toString());
         }

         return var1;
      }
   }

   static Map access$4(PlayerUsageSnooper var0) {
      return var0.snooperStats;
   }

   public PlayerUsageSnooper(String var1, IPlayerUsage var2, long var3) {
      try {
         this.serverUrl = new URL("http://snoop.minecraft.net/" + var1 + "?version=" + 2);
      } catch (MalformedURLException var6) {
         throw new IllegalArgumentException();
      }

      this.playerStatsCollector = var2;
      this.minecraftStartTimeMilis = var3;
   }

   static int access$3(PlayerUsageSnooper var0) {
      return var0.selfCounter;
   }

   public void stopSnooper() {
      this.threadTrigger.cancel();
   }

   static void access$5(PlayerUsageSnooper var0, int var1) {
      var0.selfCounter = var1;
   }

   private void addJvmArgsToSnooper() {
      RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
      List var2 = var1.getInputArguments();
      int var3 = 0;
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         String var4 = (String)var5.next();
         if (var4.startsWith("-X")) {
            this.addClientStat("jvm_arg[" + var3++ + "]", var4);
         }
      }

      this.addClientStat("jvm_args", var3);
   }

   static Object access$1(PlayerUsageSnooper var0) {
      return var0.syncLock;
   }

   public void startSnooper() {
      if (!this.isRunning) {
         this.isRunning = true;
         this.addOSData();
         this.threadTrigger.schedule(new TimerTask(this) {
            final PlayerUsageSnooper this$0;

            {
               this.this$0 = var1;
            }

            public void run() {
               if (PlayerUsageSnooper.access$0(this.this$0).isSnooperEnabled()) {
                  HashMap var1;
                  synchronized(PlayerUsageSnooper.access$1(this.this$0)) {
                     var1 = Maps.newHashMap(PlayerUsageSnooper.access$2(this.this$0));
                     if (PlayerUsageSnooper.access$3(this.this$0) == 0) {
                        var1.putAll(PlayerUsageSnooper.access$4(this.this$0));
                     }

                     PlayerUsageSnooper var10002 = this.this$0;
                     int var10004 = PlayerUsageSnooper.access$3(var10002);
                     PlayerUsageSnooper.access$5(var10002, var10004 + 1);
                     var1.put("snooper_count", var10004);
                     var1.put("snooper_token", PlayerUsageSnooper.access$6(this.this$0));
                  }

                  HttpUtil.postMap(PlayerUsageSnooper.access$7(this.this$0), var1, true);
               }

            }
         }, 0L, 900000L);
      }

   }

   public void addMemoryStatsToSnooper() {
      this.addStatToSnooper("memory_total", Runtime.getRuntime().totalMemory());
      this.addStatToSnooper("memory_max", Runtime.getRuntime().maxMemory());
      this.addStatToSnooper("memory_free", Runtime.getRuntime().freeMemory());
      this.addStatToSnooper("cpu_cores", Runtime.getRuntime().availableProcessors());
      this.playerStatsCollector.addServerStatsToSnooper(this);
   }

   public long getMinecraftStartTimeMillis() {
      return this.minecraftStartTimeMilis;
   }

   static IPlayerUsage access$0(PlayerUsageSnooper var0) {
      return var0.playerStatsCollector;
   }

   static Map access$2(PlayerUsageSnooper var0) {
      return var0.clientStats;
   }

   public String getUniqueID() {
      return this.uniqueID;
   }

   static URL access$7(PlayerUsageSnooper var0) {
      return var0.serverUrl;
   }

   static String access$6(PlayerUsageSnooper var0) {
      return var0.uniqueID;
   }

   public void addClientStat(String var1, Object var2) {
      synchronized(this.syncLock) {
         this.clientStats.put(var1, var2);
      }
   }

   public boolean isSnooperRunning() {
      return this.isRunning;
   }
}
