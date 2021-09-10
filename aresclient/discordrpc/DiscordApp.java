package com.aresclient.discordrpc;

import com.aresclient.Ares;
import java.util.UUID;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DiscordApp {
   public static boolean isBeta = false;
   public static String myId;
   public static boolean log = false;
   private static long created;
   private static String key = "751919026401312778";
   private static String partyid;
   private static String joinSecret;
   public static boolean running;

   public static void update(String var0, String var1, boolean var2) {
      DiscordRichPresence.Builder var3 = new DiscordRichPresence.Builder(var1);
      var3.setBigImage("main", "Ares - 1.8.9 | " + Ares.getData().mcVersion);
      var3.setDetails(var0);
      if (var2) {
         var3.setStartTimestamps(created);
      }

      DiscordRPC.discordUpdatePresence(var3.build());
   }

   public static void close() {
      running = false;
      DiscordRPC.discordShutdown();
   }

   public static void init() {
      partyid = UUID.randomUUID().toString();
      joinSecret = UUID.randomUUID().toString();
      new DiscordRPC();
      DiscordEventHandlers var1 = new DiscordEventHandlers();
      DiscordRichPresence var2 = new DiscordRichPresence();
      running = true;
      var2.partyId = partyid;
      var2.partySize = 1;
      var2.partyMax = 4;
      var2.joinSecret = joinSecret;
      created = System.currentTimeMillis();
      (new Thread("Discord RPC Callback") {
         public void run() {
            while(DiscordApp.running) {
               DiscordRPC.discordRunCallbacks();
            }

         }
      }).start();
      DiscordRPC.discordInitialize(key, var1, true);
   }
}
