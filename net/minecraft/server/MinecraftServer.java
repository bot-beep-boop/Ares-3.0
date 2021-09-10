package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Util;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer implements IPlayerUsage, Runnable, ICommandSender, IThreadListener {
   private static MinecraftServer mcServer;
   private static final Logger logger = LogManager.getLogger();
   private int tickCounter;
   private final File anvilFile;
   public final Profiler theProfiler = new Profiler();
   private boolean canSpawnAnimals;
   private boolean pvpEnabled;
   private long timeOfLastWarning;
   private KeyPair serverKeyPair;
   private final YggdrasilAuthenticationService authService;
   protected final Proxy serverProxy;
   private long nanoTimeSinceStatusRefresh = 0L;
   private int maxPlayerIdleMinutes = 0;
   private final MinecraftSessionService sessionService;
   private final Random random = new Random();
   public String currentTask;
   private boolean worldIsBeingDeleted;
   public static final File USER_CACHE_FILE = new File("usercache.json");
   private ServerConfigurationManager serverConfigManager;
   private final PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("server", this, getCurrentTimeMillis());
   private String serverOwner;
   private boolean isDemo;
   private boolean allowFlight;
   private int serverPort = -1;
   private final ServerStatusResponse statusResponse = new ServerStatusResponse();
   private int buildLimit;
   private boolean isGamemodeForced;
   private String resourcePackHash = "";
   private final NetworkSystem networkSystem;
   public final long[] tickTimeArray = new long[100];
   private final GameProfileRepository profileRepo;
   private String resourcePackUrl = "";
   protected final ICommandManager commandManager;
   private Thread serverThread;
   private boolean onlineMode;
   private String userMessage;
   private boolean serverStopped;
   private String folderName;
   private boolean startProfiling;
   private boolean enableBonusChest;
   private String worldName;
   private boolean serverIsRunning;
   private final List<ITickable> playersOnline = Lists.newArrayList();
   private boolean serverRunning = true;
   public int percentDone;
   private long currentTime = getCurrentTimeMillis();
   public WorldServer[] worldServers;
   private final PlayerProfileCache profileCache;
   private final ISaveFormat anvilConverterForAnvilFile;
   public long[][] timeOfLastDimensionTick;
   private boolean canSpawnNPCs;
   protected final Queue<FutureTask<?>> futureTaskQueue = Queues.newArrayDeque();
   private String motd;

   public boolean isBlockProtected(World var1, BlockPos var2, EntityPlayer var3) {
      return false;
   }

   public void startServerThread() {
      this.serverThread = new Thread(this, "Server thread");
      this.serverThread.start();
   }

   public <V> ListenableFuture<V> callFromMainThread(Callable<V> var1) {
      Validate.notNull(var1);
      if (!this.isCallingFromMinecraftThread() && !this.isServerStopped()) {
         ListenableFutureTask var2 = ListenableFutureTask.create(var1);
         synchronized(this.futureTaskQueue) {
            this.futureTaskQueue.add(var2);
            return var2;
         }
      } else {
         try {
            return Futures.immediateFuture(var1.call());
         } catch (Exception var5) {
            return Futures.immediateFailedCheckedFuture(var5);
         }
      }
   }

   public boolean isAnnouncingPlayerAchievements() {
      return true;
   }

   public String[] getAllUsernames() {
      return this.serverConfigManager.getAllUsernames();
   }

   public void setFolderName(String var1) {
      this.folderName = var1;
   }

   public abstract boolean isDedicatedServer();

   static Logger access$0() {
      return logger;
   }

   public void stopServer() {
      if (!this.worldIsBeingDeleted) {
         logger.info("Stopping server");
         if (this.getNetworkSystem() != null) {
            this.getNetworkSystem().terminateEndpoints();
         }

         if (this.serverConfigManager != null) {
            logger.info("Saving players");
            this.serverConfigManager.saveAllPlayerData();
            this.serverConfigManager.removeAllPlayers();
         }

         if (this.worldServers != null) {
            logger.info("Saving worlds");
            this.saveAllWorlds(false);

            for(int var1 = 0; var1 < this.worldServers.length; ++var1) {
               WorldServer var2 = this.worldServers[var1];
               var2.flush();
            }
         }

         if (this.usageSnooper.isSnooperRunning()) {
            this.usageSnooper.stopSnooper();
         }
      }

   }

   public void addChatMessage(IChatComponent var1) {
      logger.info(var1.getUnformattedText());
   }

   public static long getCurrentTimeMillis() {
      return System.currentTimeMillis();
   }

   public String getMOTD() {
      return this.motd;
   }

   public ISaveFormat getActiveAnvilConverter() {
      return this.anvilConverterForAnvilFile;
   }

   public int getNetworkCompressionTreshold() {
      return 256;
   }

   protected void setInstance() {
      mcServer = this;
   }

   public MinecraftSessionService getMinecraftSessionService() {
      return this.sessionService;
   }

   public boolean isCallingFromMinecraftThread() {
      return Thread.currentThread() == this.serverThread;
   }

   protected void convertMapIfNeeded(String var1) {
      if (this.getActiveAnvilConverter().isOldMapFormat(var1)) {
         logger.info("Converting map!");
         this.setUserMessage("menu.convertingLevel");
         this.getActiveAnvilConverter().convertMapFormat(var1, new IProgressUpdate(this) {
            private long startTime;
            final MinecraftServer this$0;

            {
               this.this$0 = var1;
               this.startTime = MinecraftServer.getCurrentTimeMillis();
            }

            public void setDoneWorking() {
            }

            public void displayLoadingString(String var1) {
            }

            public void setLoadingProgress(int var1) {
               if (MinecraftServer.getCurrentTimeMillis() - this.startTime >= 1000L) {
                  this.startTime = MinecraftServer.getCurrentTimeMillis();
                  MinecraftServer.access$0().info("Converting... " + var1 + "%");
               }

            }

            public void resetProgressAndMessage(String var1) {
            }

            public void displaySavingString(String var1) {
            }
         });
      }

   }

   public MinecraftServer(File var1, Proxy var2, File var3) {
      this.serverProxy = var2;
      mcServer = this;
      this.anvilFile = var1;
      this.networkSystem = new NetworkSystem(this);
      this.profileCache = new PlayerProfileCache(this, var3);
      this.commandManager = this.createNewCommandManager();
      this.anvilConverterForAnvilFile = new AnvilSaveConverter(var1);
      this.authService = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
      this.sessionService = this.authService.createMinecraftSessionService();
      this.profileRepo = this.authService.createProfileRepository();
   }

   public void logWarning(String var1) {
      logger.warn(var1);
   }

   public void setKeyPair(KeyPair var1) {
      this.serverKeyPair = var1;
   }

   public Entity getEntityFromUuid(UUID var1) {
      WorldServer[] var5;
      int var4 = (var5 = this.worldServers).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         WorldServer var2 = var5[var3];
         if (var2 != null) {
            Entity var6 = var2.getEntityFromUuid(var1);
            if (var6 != null) {
               return var6;
            }
         }
      }

      return null;
   }

   public abstract boolean shouldBroadcastConsoleToOps();

   public boolean isSnooperEnabled() {
      return true;
   }

   public boolean canCommandSenderUseCommand(int var1, String var2) {
      return true;
   }

   public void initiateShutdown() {
      this.serverRunning = false;
   }

   public boolean sendCommandFeedback() {
      return getServer().worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
   }

   public String getName() {
      return "Server";
   }

   public void setServerOwner(String var1) {
      this.serverOwner = var1;
   }

   public abstract boolean shouldUseNativeTransport();

   protected void loadAllWorlds(String var1, String var2, long var3, WorldType var5, String var6) {
      this.convertMapIfNeeded(var1);
      this.setUserMessage("menu.loadingLevel");
      this.worldServers = new WorldServer[3];
      this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
      ISaveHandler var7 = this.anvilConverterForAnvilFile.getSaveLoader(var1, true);
      this.setResourcePackFromWorld(this.getFolderName(), var7);
      WorldInfo var8 = var7.loadWorldInfo();
      WorldSettings var9;
      if (var8 == null) {
         if (this.isDemo()) {
            var9 = DemoWorldServer.demoWorldSettings;
         } else {
            var9 = new WorldSettings(var3, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), var5);
            var9.setWorldName(var6);
            if (this.enableBonusChest) {
               var9.enableBonusChest();
            }
         }

         var8 = new WorldInfo(var9, var2);
      } else {
         var8.setWorldName(var2);
         var9 = new WorldSettings(var8);
      }

      for(int var10 = 0; var10 < this.worldServers.length; ++var10) {
         byte var11 = 0;
         if (var10 == 1) {
            var11 = -1;
         }

         if (var10 == 2) {
            var11 = 1;
         }

         if (var10 == 0) {
            if (this.isDemo()) {
               this.worldServers[var10] = (WorldServer)(new DemoWorldServer(this, var7, var8, var11, this.theProfiler)).init();
            } else {
               this.worldServers[var10] = (WorldServer)(new WorldServer(this, var7, var8, var11, this.theProfiler)).init();
            }

            this.worldServers[var10].initialize(var9);
         } else {
            this.worldServers[var10] = (WorldServer)(new WorldServerMulti(this, var7, var11, this.worldServers[0], this.theProfiler)).init();
         }

         this.worldServers[var10].addWorldAccess(new WorldManager(this, this.worldServers[var10]));
         if (!this.isSinglePlayer()) {
            this.worldServers[var10].getWorldInfo().setGameType(this.getGameType());
         }
      }

      this.serverConfigManager.setPlayerManager(this.worldServers);
      this.setDifficultyForAllWorlds(this.getDifficulty());
      this.initialWorldChunkLoad();
   }

   public abstract boolean isCommandBlockEnabled();

   public void setBuildLimit(int var1) {
      this.buildLimit = var1;
   }

   public void setConfigManager(ServerConfigurationManager var1) {
      this.serverConfigManager = var1;
   }

   public boolean getForceGamemode() {
      return this.isGamemodeForced;
   }

   protected abstract boolean startServer() throws IOException;

   static ServerConfigurationManager access$1(MinecraftServer var0) {
      return var0.serverConfigManager;
   }

   public File getDataDirectory() {
      return new File(".");
   }

   public int getSpawnProtectionSize() {
      return 16;
   }

   public boolean getCanSpawnNPCs() {
      return this.canSpawnNPCs;
   }

   protected void outputPercentRemaining(String var1, int var2) {
      this.currentTask = var1;
      this.percentDone = var2;
      logger.info(var1 + ": " + var2 + "%");
   }

   public abstract boolean shouldBroadcastRconToOps();

   public void setWorldName(String var1) {
      this.worldName = var1;
   }

   public void setDemo(boolean var1) {
      this.isDemo = var1;
   }

   public boolean getGuiEnabled() {
      return false;
   }

   protected boolean allowSpawnMonsters() {
      return true;
   }

   public String getWorldName() {
      return this.worldName;
   }

   public abstract boolean canStructuresSpawn();

   public synchronized String getUserMessage() {
      return this.userMessage;
   }

   public void setPlayerIdleTimeout(int var1) {
      this.maxPlayerIdleMinutes = var1;
   }

   public void setMOTD(String var1) {
      this.motd = var1;
   }

   public int getBuildLimit() {
      return this.buildLimit;
   }

   public void run() {
      boolean var43 = false;

      label585: {
         try {
            CrashReport var2;
            try {
               var43 = true;
               if (this.startServer()) {
                  this.currentTime = getCurrentTimeMillis();
                  long var1 = 0L;
                  this.statusResponse.setServerDescription(new ChatComponentText(this.motd));
                  this.statusResponse.setProtocolVersionInfo(new ServerStatusResponse.MinecraftProtocolVersionIdentifier("1.8.9", 47));
                  this.addFaviconToStatusResponse(this.statusResponse);

                  while(this.serverRunning) {
                     long var52 = getCurrentTimeMillis();
                     long var5 = var52 - this.currentTime;
                     if (var5 > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L) {
                        logger.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[]{var5, var5 / 50L});
                        var5 = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                     }

                     if (var5 < 0L) {
                        logger.warn("Time ran backwards! Did the system time change?");
                        var5 = 0L;
                     }

                     var1 += var5;
                     this.currentTime = var52;
                     if (this.worldServers[0].areAllPlayersAsleep()) {
                        this.tick();
                        var1 = 0L;
                     } else {
                        while(var1 > 50L) {
                           var1 -= 50L;
                           this.tick();
                        }
                     }

                     Thread.sleep(Math.max(1L, 50L - var1));
                     this.serverIsRunning = true;
                  }

                  var43 = false;
                  break label585;
               }

               this.finalTick((CrashReport)null);
               var43 = false;
               break label585;
            } catch (Throwable var50) {
               logger.error("Encountered an unexpected exception", var50);
               var2 = null;
               if (var50 instanceof ReportedException) {
                  var2 = this.addServerInfoToCrashReport(((ReportedException)var50).getCrashReport());
               } else {
                  var2 = this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", var50));
               }
            }

            File var3 = new File(new File(this.getDataDirectory(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
            if (var2.saveToFile(var3)) {
               logger.error("This crash report has been saved to: " + var3.getAbsolutePath());
            } else {
               logger.error("We were unable to save this crash report to disk.");
            }

            this.finalTick(var2);
            var43 = false;
         } finally {
            if (var43) {
               try {
                  this.serverStopped = true;
                  this.stopServer();
               } catch (Throwable var44) {
                  logger.error("Exception stopping the server", var44);
               } finally {
                  this.systemExitNow();
               }

            }
         }

         boolean var26 = false;

         try {
            label586: {
               try {
                  var26 = true;
                  this.serverStopped = true;
                  this.stopServer();
               } catch (Throwable var48) {
                  logger.error("Exception stopping the server", var48);
                  var26 = false;
                  break label586;
               }

               this.systemExitNow();
               var26 = false;
               return;
            }
         } finally {
            if (var26) {
               this.systemExitNow();
            }
         }

         this.systemExitNow();
         return;
      }

      try {
         this.serverStopped = true;
         this.stopServer();
      } catch (Throwable var46) {
         logger.error("Exception stopping the server", var46);
      } finally {
         this.systemExitNow();
      }

   }

   public void addServerStatsToSnooper(PlayerUsageSnooper var1) {
      var1.addClientStat("whitelist_enabled", false);
      var1.addClientStat("whitelist_count", 0);
      if (this.serverConfigManager != null) {
         var1.addClientStat("players_current", this.getCurrentPlayerCount());
         var1.addClientStat("players_max", this.getMaxPlayers());
         var1.addClientStat("players_seen", this.serverConfigManager.getAvailablePlayerDat().length);
      }

      var1.addClientStat("uses_auth", this.onlineMode);
      var1.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
      var1.addClientStat("run_time", (getCurrentTimeMillis() - var1.getMinecraftStartTimeMillis()) / 60L * 1000L);
      var1.addClientStat("avg_tick_ms", (int)(MathHelper.average(this.tickTimeArray) * 1.0E-6D));
      int var2 = 0;
      if (this.worldServers != null) {
         for(int var3 = 0; var3 < this.worldServers.length; ++var3) {
            if (this.worldServers[var3] != null) {
               WorldServer var4 = this.worldServers[var3];
               WorldInfo var5 = var4.getWorldInfo();
               var1.addClientStat("world[" + var2 + "][dimension]", var4.provider.getDimensionId());
               var1.addClientStat("world[" + var2 + "][mode]", var5.getGameType());
               var1.addClientStat("world[" + var2 + "][difficulty]", var4.getDifficulty());
               var1.addClientStat("world[" + var2 + "][hardcore]", var5.isHardcoreModeEnabled());
               var1.addClientStat("world[" + var2 + "][generator_name]", var5.getTerrainType().getWorldTypeName());
               var1.addClientStat("world[" + var2 + "][generator_version]", var5.getTerrainType().getGeneratorVersion());
               var1.addClientStat("world[" + var2 + "][height]", this.buildLimit);
               var1.addClientStat("world[" + var2 + "][chunks_loaded]", var4.getChunkProvider().getLoadedChunkCount());
               ++var2;
            }
         }
      }

      var1.addClientStat("worlds", var2);
   }

   public CrashReport addServerInfoToCrashReport(CrashReport var1) {
      var1.getCategory().addCrashSectionCallable("Profiler Position", new Callable<String>(this) {
         final MinecraftServer this$0;

         {
            this.this$0 = var1;
         }

         public String call() throws Exception {
            return this.this$0.theProfiler.profilingEnabled ? this.this$0.theProfiler.getNameOfLastSection() : "N/A (disabled)";
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      if (this.serverConfigManager != null) {
         var1.getCategory().addCrashSectionCallable("Player Count", new Callable<String>(this) {
            final MinecraftServer this$0;

            {
               this.this$0 = var1;
            }

            public Object call() throws Exception {
               return this.call();
            }

            public String call() {
               return MinecraftServer.access$1(this.this$0).getCurrentPlayerCount() + " / " + MinecraftServer.access$1(this.this$0).getMaxPlayers() + "; " + MinecraftServer.access$1(this.this$0).getPlayerList();
            }
         });
      }

      return var1;
   }

   public IChatComponent getDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public boolean getCanSpawnAnimals() {
      return this.canSpawnAnimals;
   }

   public void setResourcePack(String var1, String var2) {
      this.resourcePackUrl = var1;
      this.resourcePackHash = var2;
   }

   public int getMaxPlayers() {
      return this.serverConfigManager.getMaxPlayers();
   }

   public String getServerModName() {
      return "vanilla";
   }

   public GameProfile[] getGameProfiles() {
      return this.serverConfigManager.getAllProfiles();
   }

   public PlayerProfileCache getPlayerProfileCache() {
      return this.profileCache;
   }

   public abstract EnumDifficulty getDifficulty();

   public void setCanSpawnNPCs(boolean var1) {
      this.canSpawnNPCs = var1;
   }

   public void setAllowFlight(boolean var1) {
      this.allowFlight = var1;
   }

   protected void systemExitNow() {
   }

   public void setCanSpawnAnimals(boolean var1) {
      this.canSpawnAnimals = var1;
   }

   public String getFolderName() {
      return this.folderName;
   }

   public void canCreateBonusChest(boolean var1) {
      this.enableBonusChest = var1;
   }

   protected void initialWorldChunkLoad() {
      boolean var1 = true;
      boolean var2 = true;
      boolean var3 = true;
      boolean var4 = true;
      int var5 = 0;
      this.setUserMessage("menu.generatingTerrain");
      byte var6 = 0;
      logger.info("Preparing start region for level " + var6);
      WorldServer var7 = this.worldServers[var6];
      BlockPos var8 = var7.getSpawnPoint();
      long var9 = getCurrentTimeMillis();

      for(int var11 = -192; var11 <= 192 && this.isServerRunning(); var11 += 16) {
         for(int var12 = -192; var12 <= 192 && this.isServerRunning(); var12 += 16) {
            long var13 = getCurrentTimeMillis();
            if (var13 - var9 > 1000L) {
               this.outputPercentRemaining("Preparing spawn area", var5 * 100 / 625);
               var9 = var13;
            }

            ++var5;
            var7.theChunkProviderServer.loadChunk(var8.getX() + var11 >> 4, var8.getZ() + var12 >> 4);
         }
      }

      this.clearCurrentTask();
   }

   public ServerConfigurationManager getConfigurationManager() {
      return this.serverConfigManager;
   }

   public MinecraftServer(Proxy var1, File var2) {
      this.serverProxy = var1;
      mcServer = this;
      this.anvilFile = null;
      this.networkSystem = null;
      this.profileCache = new PlayerProfileCache(this, var2);
      this.commandManager = null;
      this.anvilConverterForAnvilFile = null;
      this.authService = new YggdrasilAuthenticationService(var1, UUID.randomUUID().toString());
      this.sessionService = this.authService.createMinecraftSessionService();
      this.profileRepo = this.authService.createProfileRepository();
   }

   public BlockPos getPosition() {
      return BlockPos.ORIGIN;
   }

   public void setCommandStat(CommandResultStats.Type var1, int var2) {
   }

   public boolean getAllowNether() {
      return true;
   }

   public abstract WorldSettings.GameType getGameType();

   public abstract String shareToLAN(WorldSettings.GameType var1, boolean var2);

   public PlayerUsageSnooper getPlayerUsageSnooper() {
      return this.usageSnooper;
   }

   public boolean isServerInOnlineMode() {
      return this.onlineMode;
   }

   public void updateTimeLightAndEntities() {
      this.theProfiler.startSection("jobs");
      synchronized(this.futureTaskQueue) {
         while(!this.futureTaskQueue.isEmpty()) {
            Util.runTask((FutureTask)this.futureTaskQueue.poll(), logger);
         }
      }

      this.theProfiler.endStartSection("levels");

      int var1;
      for(var1 = 0; var1 < this.worldServers.length; ++var1) {
         long var2 = System.nanoTime();
         if (var1 == 0 || this.getAllowNether()) {
            WorldServer var4 = this.worldServers[var1];
            this.theProfiler.startSection(var4.getWorldInfo().getWorldName());
            if (this.tickCounter % 20 == 0) {
               this.theProfiler.startSection("timeSync");
               this.serverConfigManager.sendPacketToAllPlayersInDimension(new S03PacketTimeUpdate(var4.getTotalWorldTime(), var4.getWorldTime(), var4.getGameRules().getBoolean("doDaylightCycle")), var4.provider.getDimensionId());
               this.theProfiler.endSection();
            }

            this.theProfiler.startSection("tick");

            CrashReport var6;
            try {
               var4.tick();
            } catch (Throwable var8) {
               var6 = CrashReport.makeCrashReport(var8, "Exception ticking world");
               var4.addWorldInfoToCrashReport(var6);
               throw new ReportedException(var6);
            }

            try {
               var4.updateEntities();
            } catch (Throwable var7) {
               var6 = CrashReport.makeCrashReport(var7, "Exception ticking world entities");
               var4.addWorldInfoToCrashReport(var6);
               throw new ReportedException(var6);
            }

            this.theProfiler.endSection();
            this.theProfiler.startSection("tracker");
            var4.getEntityTracker().updateTrackedEntities();
            this.theProfiler.endSection();
            this.theProfiler.endSection();
         }

         this.timeOfLastDimensionTick[var1][this.tickCounter % 100] = System.nanoTime() - var2;
      }

      this.theProfiler.endStartSection("connection");
      this.getNetworkSystem().networkTick();
      this.theProfiler.endStartSection("players");
      this.serverConfigManager.onTick();
      this.theProfiler.endStartSection("tickables");

      for(var1 = 0; var1 < this.playersOnline.size(); ++var1) {
         ((ITickable)this.playersOnline.get(var1)).update();
      }

      this.theProfiler.endSection();
   }

   public abstract int getOpPermissionLevel();

   public String getResourcePackUrl() {
      return this.resourcePackUrl;
   }

   public void setAllowPvp(boolean var1) {
      this.pvpEnabled = var1;
   }

   protected void setResourcePackFromWorld(String var1, ISaveHandler var2) {
      File var3 = new File(var2.getWorldDirectory(), "resources.zip");
      if (var3.isFile()) {
         this.setResourcePack("level://" + var1 + "/" + var3.getName(), "");
      }

   }

   public List<String> getTabCompletions(ICommandSender var1, String var2, BlockPos var3) {
      ArrayList var4 = Lists.newArrayList();
      String var7;
      if (var2.startsWith("/")) {
         var2 = var2.substring(1);
         boolean var11 = !var2.contains(" ");
         List var12 = this.commandManager.getTabCompletionOptions(var1, var2, var3);
         if (var12 != null) {
            Iterator var13 = var12.iterator();

            while(var13.hasNext()) {
               var7 = (String)var13.next();
               if (var11) {
                  var4.add("/" + var7);
               } else {
                  var4.add(var7);
               }
            }
         }

         return var4;
      } else {
         String[] var5 = var2.split(" ", -1);
         String var6 = var5[var5.length - 1];
         String[] var10;
         int var9 = (var10 = this.serverConfigManager.getAllUsernames()).length;

         for(int var8 = 0; var8 < var9; ++var8) {
            var7 = var10[var8];
            if (CommandBase.doesStringStartWith(var6, var7)) {
               var4.add(var7);
            }
         }

         return var4;
      }
   }

   public Entity getCommandSenderEntity() {
      return null;
   }

   public String getMinecraftVersion() {
      return "1.8.9";
   }

   public void enableProfiling() {
      this.startProfiling = true;
   }

   public boolean isSinglePlayer() {
      return this.serverOwner != null;
   }

   public void deleteWorldAndStopServer() {
      this.worldIsBeingDeleted = true;
      this.getActiveAnvilConverter().flushCache();

      for(int var1 = 0; var1 < this.worldServers.length; ++var1) {
         WorldServer var2 = this.worldServers[var1];
         if (var2 != null) {
            var2.flush();
         }
      }

      this.getActiveAnvilConverter().deleteWorldDirectory(this.worldServers[0].getSaveHandler().getWorldDirectoryName());
      this.initiateShutdown();
   }

   protected void finalTick(CrashReport var1) {
   }

   public NetworkSystem getNetworkSystem() {
      return this.networkSystem;
   }

   public static MinecraftServer getServer() {
      return mcServer;
   }

   public WorldServer worldServerForDimension(int var1) {
      if (var1 == -1) {
         return this.worldServers[1];
      } else {
         return var1 == 1 ? this.worldServers[2] : this.worldServers[0];
      }
   }

   protected synchronized void setUserMessage(String var1) {
      this.userMessage = var1;
   }

   public int getCurrentPlayerCount() {
      return this.serverConfigManager.getCurrentPlayerCount();
   }

   public boolean isDemo() {
      return this.isDemo;
   }

   public void setGameType(WorldSettings.GameType var1) {
      for(int var2 = 0; var2 < this.worldServers.length; ++var2) {
         getServer().worldServers[var2].getWorldInfo().setGameType(var1);
      }

   }

   public Vec3 getPositionVector() {
      return new Vec3(0.0D, 0.0D, 0.0D);
   }

   public void refreshStatusNextTick() {
      this.nanoTimeSinceStatusRefresh = 0L;
   }

   public ListenableFuture<Object> addScheduledTask(Runnable var1) {
      Validate.notNull(var1);
      return this.callFromMainThread(Executors.callable(var1));
   }

   public boolean isServerRunning() {
      return this.serverRunning;
   }

   protected void clearCurrentTask() {
      this.currentTask = null;
      this.percentDone = 0;
   }

   private void addFaviconToStatusResponse(ServerStatusResponse var1) {
      File var2 = this.getFile("server-icon.png");
      if (var2.isFile()) {
         ByteBuf var3 = Unpooled.buffer();

         try {
            BufferedImage var4 = ImageIO.read(var2);
            Validate.validState(var4.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
            Validate.validState(var4.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
            ImageIO.write(var4, "PNG", new ByteBufOutputStream(var3));
            ByteBuf var5 = Base64.encode(var3);
            var1.setFavicon("data:image/png;base64," + var5.toString(Charsets.UTF_8));
         } catch (Exception var9) {
            logger.error("Couldn't load server icon", var9);
         } finally {
            var3.release();
         }
      }

   }

   public void setDifficultyForAllWorlds(EnumDifficulty var1) {
      for(int var2 = 0; var2 < this.worldServers.length; ++var2) {
         WorldServer var3 = this.worldServers[var2];
         if (var3 != null) {
            if (var3.getWorldInfo().isHardcoreModeEnabled()) {
               var3.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
               var3.setAllowedSpawnTypes(true, true);
            } else if (this.isSinglePlayer()) {
               var3.getWorldInfo().setDifficulty(var1);
               var3.setAllowedSpawnTypes(var3.getDifficulty() != EnumDifficulty.PEACEFUL, true);
            } else {
               var3.getWorldInfo().setDifficulty(var1);
               var3.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
            }
         }
      }

   }

   public abstract boolean isHardcore();

   public int getMaxPlayerIdleMinutes() {
      return this.maxPlayerIdleMinutes;
   }

   public ServerStatusResponse getServerStatusResponse() {
      return this.statusResponse;
   }

   public void tick() {
      long var1 = System.nanoTime();
      ++this.tickCounter;
      if (this.startProfiling) {
         this.startProfiling = false;
         this.theProfiler.profilingEnabled = true;
         this.theProfiler.clearProfiling();
      }

      this.theProfiler.startSection("root");
      this.updateTimeLightAndEntities();
      if (var1 - this.nanoTimeSinceStatusRefresh >= 5000000000L) {
         this.nanoTimeSinceStatusRefresh = var1;
         this.statusResponse.setPlayerCountData(new ServerStatusResponse.PlayerCountData(this.getMaxPlayers(), this.getCurrentPlayerCount()));
         GameProfile[] var3 = new GameProfile[Math.min(this.getCurrentPlayerCount(), 12)];
         int var4 = MathHelper.getRandomIntegerInRange(this.random, 0, this.getCurrentPlayerCount() - var3.length);

         for(int var5 = 0; var5 < var3.length; ++var5) {
            var3[var5] = ((EntityPlayerMP)this.serverConfigManager.getPlayerList().get(var4 + var5)).getGameProfile();
         }

         Collections.shuffle(Arrays.asList(var3));
         this.statusResponse.getPlayerCountData().setPlayers(var3);
      }

      if (this.tickCounter % 900 == 0) {
         this.theProfiler.startSection("save");
         this.serverConfigManager.saveAllPlayerData();
         this.saveAllWorlds(true);
         this.theProfiler.endSection();
      }

      this.theProfiler.startSection("tallying");
      this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - var1;
      this.theProfiler.endSection();
      this.theProfiler.startSection("snooper");
      if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100) {
         this.usageSnooper.startSnooper();
      }

      if (this.tickCounter % 6000 == 0) {
         this.usageSnooper.addMemoryStatsToSnooper();
      }

      this.theProfiler.endSection();
      this.theProfiler.endSection();
   }

   public void addServerTypeToSnooper(PlayerUsageSnooper var1) {
      var1.addStatToSnooper("singleplayer", this.isSinglePlayer());
      var1.addStatToSnooper("server_brand", this.getServerModName());
      var1.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
      var1.addStatToSnooper("dedicated", this.isDedicatedServer());
   }

   public void setOnlineMode(boolean var1) {
      this.onlineMode = var1;
   }

   public boolean isPVPEnabled() {
      return this.pvpEnabled;
   }

   public boolean isFlightAllowed() {
      return this.allowFlight;
   }

   public int getTickCounter() {
      return this.tickCounter;
   }

   public int getMaxWorldSize() {
      return 29999984;
   }

   public Proxy getServerProxy() {
      return this.serverProxy;
   }

   protected void saveAllWorlds(boolean var1) {
      if (!this.worldIsBeingDeleted) {
         WorldServer[] var5;
         int var4 = (var5 = this.worldServers).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            WorldServer var2 = var5[var3];
            if (var2 != null) {
               if (!var1) {
                  logger.info("Saving chunks for level '" + var2.getWorldInfo().getWorldName() + "'/" + var2.provider.getDimensionName());
               }

               try {
                  var2.saveAllChunks(true, (IProgressUpdate)null);
               } catch (MinecraftException var7) {
                  logger.warn(var7.getMessage());
               }
            }
         }
      }

   }

   public String getResourcePackHash() {
      return this.resourcePackHash;
   }

   public ICommandManager getCommandManager() {
      return this.commandManager;
   }

   public boolean isAnvilFileSet() {
      return this.anvilFile != null;
   }

   public KeyPair getKeyPair() {
      return this.serverKeyPair;
   }

   public boolean isServerStopped() {
      return this.serverStopped;
   }

   public File getFile(String var1) {
      return new File(this.getDataDirectory(), var1);
   }

   public GameProfileRepository getGameProfileRepository() {
      return this.profileRepo;
   }

   public World getEntityWorld() {
      return this.worldServers[0];
   }

   public boolean serverIsInRunLoop() {
      return this.serverIsRunning;
   }

   protected ServerCommandManager createNewCommandManager() {
      return new ServerCommandManager();
   }

   public String getServerOwner() {
      return this.serverOwner;
   }
}
