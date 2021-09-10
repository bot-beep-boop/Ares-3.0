package net.minecraft.client.stream;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ThreadSafeBoundList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tv.twitch.AuthToken;
import tv.twitch.Core;
import tv.twitch.ErrorCode;
import tv.twitch.MessageLevel;
import tv.twitch.StandardCoreAPI;
import tv.twitch.broadcast.ArchivingState;
import tv.twitch.broadcast.AudioDeviceType;
import tv.twitch.broadcast.AudioParams;
import tv.twitch.broadcast.ChannelInfo;
import tv.twitch.broadcast.DesktopStreamAPI;
import tv.twitch.broadcast.EncodingCpuUsage;
import tv.twitch.broadcast.FrameBuffer;
import tv.twitch.broadcast.GameInfo;
import tv.twitch.broadcast.GameInfoList;
import tv.twitch.broadcast.IStatCallbacks;
import tv.twitch.broadcast.IStreamCallbacks;
import tv.twitch.broadcast.IngestList;
import tv.twitch.broadcast.IngestServer;
import tv.twitch.broadcast.PixelFormat;
import tv.twitch.broadcast.StartFlags;
import tv.twitch.broadcast.StatType;
import tv.twitch.broadcast.Stream;
import tv.twitch.broadcast.StreamInfo;
import tv.twitch.broadcast.StreamInfoForSetting;
import tv.twitch.broadcast.UserInfo;
import tv.twitch.broadcast.VideoParams;

public class BroadcastController {
   protected List<FrameBuffer> field_152874_j = Lists.newArrayList();
   protected IngestServer ingestServ;
   protected String field_152870_f = "";
   protected boolean field_152877_m = false;
   protected String field_152869_e = "";
   protected final int field_152865_a = 30;
   protected BroadcastController.BroadcastState broadcastState;
   protected boolean field_152871_g = true;
   protected String field_152880_p;
   protected StreamInfo streamInfo;
   protected Core streamCore = null;
   protected ArchivingState archivingState;
   protected final int field_152866_b = 3;
   protected IStatCallbacks field_177949_C;
   protected ChannelInfo channelInfo;
   protected boolean field_152878_n = false;
   protected IngestList ingestList;
   private static final ThreadSafeBoundList<String> field_152862_C = new ThreadSafeBoundList(String.class, 50);
   protected boolean field_152876_l = false;
   private static int[] $SWITCH_TABLE$net$minecraft$client$stream$BroadcastController$BroadcastState;
   protected BroadcastController.BroadcastListener broadcastListener = null;
   private ErrorCode errorCode;
   protected VideoParams videoParamaters;
   protected AuthToken authenticationToken;
   protected IngestServerTester ingestServTester;
   protected Stream theStream = null;
   protected String field_152868_d = "";
   protected IStreamCallbacks streamCallback;
   protected List<FrameBuffer> field_152875_k = Lists.newArrayList();
   protected long field_152890_z;
   private static final Logger logger = LogManager.getLogger();
   private String lastError = null;
   protected UserInfo userInfo;
   protected AudioParams audioParamaters;

   public void setPlaybackDeviceVolume(float var1) {
      this.theStream.setVolume(AudioDeviceType.TTV_PLAYBACK_DEVICE, var1);
   }

   public BroadcastController() {
      this.broadcastState = BroadcastController.BroadcastState.Uninitialized;
      this.field_152880_p = null;
      this.videoParamaters = null;
      this.audioParamaters = null;
      this.ingestList = new IngestList(new IngestServer[0]);
      this.ingestServ = null;
      this.authenticationToken = new AuthToken();
      this.channelInfo = new ChannelInfo();
      this.userInfo = new UserInfo();
      this.streamInfo = new StreamInfo();
      this.archivingState = new ArchivingState();
      this.field_152890_z = 0L;
      this.ingestServTester = null;
      this.streamCallback = new IStreamCallbacks(this) {
         final BroadcastController this$0;

         {
            this.this$0 = var1;
         }

         public void getUserInfoCallback(ErrorCode var1, UserInfo var2) {
            this.this$0.userInfo = var2;
            if (ErrorCode.failed(var1)) {
               String var3 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("UserInfoDoneCallback got failure: %s", var3));
            }

         }

         public void sendStartSpanMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("sendStartSpanMetaDataCallback got failure: %s", var2));
            }

         }

         public void sendEndSpanMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("sendEndSpanMetaDataCallback got failure: %s", var2));
            }

         }

         public void sendActionMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("sendActionMetaDataCallback got failure: %s", var2));
            }

         }

         public void loginCallback(ErrorCode var1, ChannelInfo var2) {
            if (ErrorCode.succeeded(var1)) {
               this.this$0.channelInfo = var2;
               this.this$0.func_152827_a(BroadcastController.BroadcastState.LoggedIn);
               this.this$0.field_152877_m = true;
            } else {
               this.this$0.func_152827_a(BroadcastController.BroadcastState.Initialized);
               this.this$0.field_152877_m = false;
               String var3 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("LoginCallback got failure: %s", var3));
            }

            try {
               if (this.this$0.broadcastListener != null) {
                  this.this$0.broadcastListener.func_152897_a(var1);
               }
            } catch (Exception var4) {
               this.this$0.logError(var4.toString());
            }

         }

         public void getStreamInfoCallback(ErrorCode var1, StreamInfo var2) {
            if (ErrorCode.succeeded(var1)) {
               this.this$0.streamInfo = var2;

               try {
                  if (this.this$0.broadcastListener != null) {
                     this.this$0.broadcastListener.func_152894_a(var2);
                  }
               } catch (Exception var4) {
                  this.this$0.logError(var4.toString());
               }
            } else {
               String var3 = ErrorCode.getString(var1);
               this.this$0.logWarning(String.format("StreamInfoDoneCallback got failure: %s", var3));
            }

         }

         public void startCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               try {
                  if (this.this$0.broadcastListener != null) {
                     this.this$0.broadcastListener.func_152899_b();
                  }
               } catch (Exception var4) {
                  this.this$0.logError(var4.toString());
               }

               this.this$0.func_152827_a(BroadcastController.BroadcastState.Broadcasting);
            } else {
               this.this$0.videoParamaters = null;
               this.this$0.audioParamaters = null;
               this.this$0.func_152827_a(BroadcastController.BroadcastState.ReadyToBroadcast);

               try {
                  if (this.this$0.broadcastListener != null) {
                     this.this$0.broadcastListener.func_152892_c(var1);
                  }
               } catch (Exception var3) {
                  this.this$0.logError(var3.toString());
               }

               String var2 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("startCallback got failure: %s", var2));
            }

         }

         public void stopCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               this.this$0.videoParamaters = null;
               this.this$0.audioParamaters = null;
               this.this$0.func_152831_M();

               try {
                  if (this.this$0.broadcastListener != null) {
                     this.this$0.broadcastListener.func_152901_c();
                  }
               } catch (Exception var3) {
                  this.this$0.logError(var3.toString());
               }

               if (this.this$0.field_152877_m) {
                  this.this$0.func_152827_a(BroadcastController.BroadcastState.ReadyToBroadcast);
               } else {
                  this.this$0.func_152827_a(BroadcastController.BroadcastState.Initialized);
               }
            } else {
               this.this$0.func_152827_a(BroadcastController.BroadcastState.ReadyToBroadcast);
               String var2 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("stopCallback got failure: %s", var2));
            }

         }

         public void getIngestServersCallback(ErrorCode var1, IngestList var2) {
            if (ErrorCode.succeeded(var1)) {
               this.this$0.ingestList = var2;
               this.this$0.ingestServ = this.this$0.ingestList.getDefaultServer();
               this.this$0.func_152827_a(BroadcastController.BroadcastState.ReceivedIngestServers);

               try {
                  if (this.this$0.broadcastListener != null) {
                     this.this$0.broadcastListener.func_152896_a(var2);
                  }
               } catch (Exception var4) {
                  this.this$0.logError(var4.toString());
               }
            } else {
               String var3 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("IngestListCallback got failure: %s", var3));
               this.this$0.func_152827_a(BroadcastController.BroadcastState.LoggingIn);
            }

         }

         public void runCommercialCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.this$0.logWarning(String.format("RunCommercialCallback got failure: %s", var2));
            }

         }

         public void getGameNameListCallback(ErrorCode var1, GameInfoList var2) {
            if (ErrorCode.failed(var1)) {
               String var3 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("GameNameListCallback got failure: %s", var3));
            }

            try {
               if (this.this$0.broadcastListener != null) {
                  this.this$0.broadcastListener.func_152898_a(var1, var2 == null ? new GameInfo[0] : var2.list);
               }
            } catch (Exception var4) {
               this.this$0.logError(var4.toString());
            }

         }

         public void requestAuthTokenCallback(ErrorCode var1, AuthToken var2) {
            if (ErrorCode.succeeded(var1)) {
               this.this$0.authenticationToken = var2;
               this.this$0.func_152827_a(BroadcastController.BroadcastState.Authenticated);
            } else {
               this.this$0.authenticationToken.data = "";
               this.this$0.func_152827_a(BroadcastController.BroadcastState.Initialized);
               String var3 = ErrorCode.getString(var1);
               this.this$0.logError(String.format("RequestAuthTokenDoneCallback got failure: %s", var3));
            }

            try {
               if (this.this$0.broadcastListener != null) {
                  this.this$0.broadcastListener.func_152900_a(var1, var2);
               }
            } catch (Exception var4) {
               this.this$0.logError(var4.toString());
            }

         }

         public void getArchivingStateCallback(ErrorCode var1, ArchivingState var2) {
            this.this$0.archivingState = var2;
            if (ErrorCode.failed(var1)) {
            }

         }

         public void setStreamInfoCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.this$0.logWarning(String.format("SetStreamInfoCallback got failure: %s", var2));
            }

         }

         public void bufferUnlockCallback(long var1) {
            FrameBuffer var3 = FrameBuffer.lookupBuffer(var1);
            this.this$0.field_152875_k.add(var3);
         }
      };
      this.field_177949_C = new IStatCallbacks(this) {
         final BroadcastController this$0;

         {
            this.this$0 = var1;
         }

         public void statCallback(StatType var1, long var2) {
         }
      };
      this.streamCore = Core.getInstance();
      if (Core.getInstance() == null) {
         this.streamCore = new Core(new StandardCoreAPI());
      }

      this.theStream = new Stream(new DesktopStreamAPI());
   }

   public boolean isReadyToBroadcast() {
      return this.broadcastState == BroadcastController.BroadcastState.ReadyToBroadcast;
   }

   public boolean isBroadcasting() {
      return this.broadcastState == BroadcastController.BroadcastState.Broadcasting || this.broadcastState == BroadcastController.BroadcastState.Paused;
   }

   public boolean func_152818_a(String var1, AuthToken var2) {
      if (this.isIngestTesting()) {
         return false;
      } else {
         this.func_152845_C();
         if (var1 != null && !var1.isEmpty()) {
            if (var2 != null && var2.data != null && !var2.data.isEmpty()) {
               this.field_152880_p = var1;
               this.authenticationToken = var2;
               if (this.func_152858_b()) {
                  this.func_152827_a(BroadcastController.BroadcastState.Authenticated);
               }

               return true;
            } else {
               this.logError("Auth token must be valid");
               return false;
            }
         } else {
            this.logError("Username must be valid");
            return false;
         }
      }
   }

   public boolean isIngestTesting() {
      return this.broadcastState == BroadcastController.BroadcastState.IngestTesting;
   }

   public ErrorCode getErrorCode() {
      return this.errorCode;
   }

   protected void logWarning(String var1) {
      field_152862_C.func_152757_a("<Warning> " + var1);
      logger.warn(TwitchStream.STREAM_MARKER, "[Broadcast controller] {}", new Object[]{var1});
   }

   public IngestServerTester func_152838_J() {
      if (this.isReadyToBroadcast() && this.ingestList != null) {
         if (this.isIngestTesting()) {
            return null;
         } else {
            this.ingestServTester = new IngestServerTester(this.theStream, this.ingestList);
            this.ingestServTester.func_176004_j();
            this.func_152827_a(BroadcastController.BroadcastState.IngestTesting);
            return this.ingestServTester;
         }
      } else {
         return null;
      }
   }

   protected void func_152827_a(BroadcastController.BroadcastState var1) {
      if (var1 != this.broadcastState) {
         this.broadcastState = var1;

         try {
            if (this.broadcastListener != null) {
               this.broadcastListener.func_152891_a(var1);
            }
         } catch (Exception var3) {
            this.logError(var3.toString());
         }
      }

   }

   public boolean func_152851_B() {
      if (!this.field_152876_l) {
         return true;
      } else if (this.isIngestTesting()) {
         return false;
      } else {
         this.field_152878_n = true;
         this.func_152845_C();
         this.theStream.setStreamCallbacks((IStreamCallbacks)null);
         this.theStream.setStatCallbacks((IStatCallbacks)null);
         ErrorCode var1 = this.streamCore.shutdown();
         this.func_152853_a(var1);
         this.field_152876_l = false;
         this.field_152878_n = false;
         this.func_152827_a(BroadcastController.BroadcastState.Uninitialized);
         return true;
      }
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$stream$BroadcastController$BroadcastState() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$stream$BroadcastController$BroadcastState;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[BroadcastController.BroadcastState.values().length];

         try {
            var0[BroadcastController.BroadcastState.Authenticated.ordinal()] = 4;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[BroadcastController.BroadcastState.Authenticating.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[BroadcastController.BroadcastState.Broadcasting.ordinal()] = 11;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[BroadcastController.BroadcastState.FindingIngestServer.ordinal()] = 7;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[BroadcastController.BroadcastState.IngestTesting.ordinal()] = 14;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[BroadcastController.BroadcastState.Initialized.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[BroadcastController.BroadcastState.LoggedIn.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[BroadcastController.BroadcastState.LoggingIn.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[BroadcastController.BroadcastState.Paused.ordinal()] = 13;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[BroadcastController.BroadcastState.ReadyToBroadcast.ordinal()] = 9;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[BroadcastController.BroadcastState.ReceivedIngestServers.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BroadcastController.BroadcastState.Starting.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BroadcastController.BroadcastState.Stopping.ordinal()] = 12;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[BroadcastController.BroadcastState.Uninitialized.ordinal()] = 1;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$stream$BroadcastController$BroadcastState = var0;
         return var0;
      }
   }

   public boolean func_152858_b() {
      return this.field_152876_l;
   }

   public boolean func_152836_a(VideoParams var1) {
      if (var1 != null && this.isReadyToBroadcast()) {
         this.videoParamaters = var1.clone();
         this.audioParamaters = new AudioParams();
         this.audioParamaters.audioEnabled = this.field_152871_g && this.func_152848_y();
         this.audioParamaters.enableMicCapture = this.audioParamaters.audioEnabled;
         this.audioParamaters.enablePlaybackCapture = this.audioParamaters.audioEnabled;
         this.audioParamaters.enablePassthroughAudio = false;
         if (!this.func_152823_L()) {
            this.videoParamaters = null;
            this.audioParamaters = null;
            return false;
         } else {
            ErrorCode var2 = this.theStream.start(var1, this.audioParamaters, this.ingestServ, StartFlags.None, true);
            if (ErrorCode.failed(var2)) {
               this.func_152831_M();
               String var3 = ErrorCode.getString(var2);
               this.logError(String.format("Error while starting to broadcast: %s", var3));
               this.videoParamaters = null;
               this.audioParamaters = null;
               return false;
            } else {
               this.func_152827_a(BroadcastController.BroadcastState.Starting);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public IngestServerTester isReady() {
      return this.ingestServTester;
   }

   protected void logError(String var1) {
      this.lastError = var1;
      field_152862_C.func_152757_a("<Error> " + var1);
      logger.error(TwitchStream.STREAM_MARKER, "[Broadcast controller] {}", new Object[]{var1});
   }

   public IngestServer getIngestServer() {
      return this.ingestServ;
   }

   public void setRecordingDeviceVolume(float var1) {
      this.theStream.setVolume(AudioDeviceType.TTV_RECORDER_DEVICE, var1);
   }

   public void statCallback() {
      if (this.broadcastState != BroadcastController.BroadcastState.Uninitialized) {
         if (this.ingestServTester != null) {
            this.ingestServTester.func_153039_l();
         }

         for(; this.ingestServTester != null; this.func_152821_H()) {
            try {
               Thread.sleep(200L);
            } catch (Exception var2) {
               this.logError(var2.toString());
            }
         }

         this.func_152851_B();
      }

   }

   public StreamInfo getStreamInfo() {
      return this.streamInfo;
   }

   protected boolean func_152853_a(ErrorCode var1) {
      if (ErrorCode.failed(var1)) {
         this.logError(ErrorCode.getString(var1));
         return false;
      } else {
         return true;
      }
   }

   public IngestList getIngestList() {
      return this.ingestList;
   }

   public boolean func_152817_A() {
      if (this.field_152876_l) {
         return false;
      } else {
         this.theStream.setStreamCallbacks(this.streamCallback);
         ErrorCode var1 = this.streamCore.initialize(this.field_152868_d, System.getProperty("java.library.path"));
         if (!this.func_152853_a(var1)) {
            this.theStream.setStreamCallbacks((IStreamCallbacks)null);
            this.errorCode = var1;
            return false;
         } else {
            var1 = this.streamCore.setTraceLevel(MessageLevel.TTV_ML_ERROR);
            if (!this.func_152853_a(var1)) {
               this.theStream.setStreamCallbacks((IStreamCallbacks)null);
               this.streamCore.shutdown();
               this.errorCode = var1;
               return false;
            } else if (ErrorCode.succeeded(var1)) {
               this.field_152876_l = true;
               this.func_152827_a(BroadcastController.BroadcastState.Initialized);
               return true;
            } else {
               this.errorCode = var1;
               this.streamCore.shutdown();
               return false;
            }
         }
      }
   }

   public ChannelInfo getChannelInfo() {
      return this.channelInfo;
   }

   public boolean func_152845_C() {
      if (this.isIngestTesting()) {
         return false;
      } else {
         if (this.isBroadcasting()) {
            this.theStream.stop(false);
         }

         this.field_152880_p = "";
         this.authenticationToken = new AuthToken();
         if (!this.field_152877_m) {
            return false;
         } else {
            this.field_152877_m = false;
            if (!this.field_152878_n) {
               try {
                  if (this.broadcastListener != null) {
                     this.broadcastListener.func_152895_a();
                  }
               } catch (Exception var2) {
                  this.logError(var2.toString());
               }
            }

            this.func_152827_a(BroadcastController.BroadcastState.Initialized);
            return true;
         }
      }
   }

   public void captureFramebuffer(FrameBuffer var1) {
      try {
         this.theStream.captureFrameBuffer_ReadPixels(var1);
      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.makeCrashReport(var5, "Trying to submit a frame to Twitch");
         CrashReportCategory var4 = var3.makeCategory("Broadcast State");
         var4.addCrashSection("Last reported errors", Arrays.toString(field_152862_C.func_152756_c()));
         var4.addCrashSection("Buffer", var1);
         var4.addCrashSection("Free buffer count", this.field_152875_k.size());
         var4.addCrashSection("Capture buffer count", this.field_152874_j.size());
         throw new ReportedException(var3);
      }
   }

   public boolean func_177947_a(String var1, long var2, long var4, String var6, String var7) {
      if (var4 == -1L) {
         this.logError(String.format("Invalid sequence id: %d\n", var4));
         return false;
      } else {
         ErrorCode var8 = this.theStream.sendEndSpanMetaData(this.authenticationToken, var1, var2, var4, var6, var7);
         if (ErrorCode.failed(var8)) {
            String var9 = ErrorCode.getString(var8);
            this.logError(String.format("Error in SendStopSpanMetaData: %s\n", var9));
            return false;
         } else {
            return true;
         }
      }
   }

   public boolean func_152840_a(String var1, long var2, String var4, String var5) {
      ErrorCode var6 = this.theStream.sendActionMetaData(this.authenticationToken, var1, var2, var4, var5);
      if (ErrorCode.failed(var6)) {
         String var7 = ErrorCode.getString(var6);
         this.logError(String.format("Error while sending meta data: %s\n", var7));
         return false;
      } else {
         return true;
      }
   }

   public boolean func_152847_F() {
      if (!this.isBroadcasting()) {
         return false;
      } else {
         ErrorCode var1 = this.theStream.pauseVideo();
         if (ErrorCode.failed(var1)) {
            this.stopBroadcasting();
            String var2 = ErrorCode.getString(var1);
            this.logError(String.format("Error pausing stream: %s\n", var2));
         } else {
            this.func_152827_a(BroadcastController.BroadcastState.Paused);
         }

         return ErrorCode.succeeded(var1);
      }
   }

   public boolean func_152854_G() {
      if (!this.isBroadcastPaused()) {
         return false;
      } else {
         this.func_152827_a(BroadcastController.BroadcastState.Broadcasting);
         return true;
      }
   }

   public void setBroadcastListener(BroadcastController.BroadcastListener var1) {
      this.broadcastListener = var1;
   }

   public boolean func_152828_a(String var1, String var2, String var3) {
      if (!this.field_152877_m) {
         return false;
      } else {
         if (var1 == null || var1.equals("")) {
            var1 = this.field_152880_p;
         }

         if (var2 == null) {
            var2 = "";
         }

         if (var3 == null) {
            var3 = "";
         }

         StreamInfoForSetting var4 = new StreamInfoForSetting();
         var4.streamTitle = var3;
         var4.gameName = var2;
         ErrorCode var5 = this.theStream.setStreamInfo(this.authenticationToken, var1, var4);
         this.func_152853_a(var5);
         return ErrorCode.succeeded(var5);
      }
   }

   protected boolean func_152848_y() {
      return true;
   }

   protected boolean func_152823_L() {
      for(int var1 = 0; var1 < 3; ++var1) {
         FrameBuffer var2 = this.theStream.allocateFrameBuffer(this.videoParamaters.outputWidth * this.videoParamaters.outputHeight * 4);
         if (!var2.getIsValid()) {
            this.logError(String.format("Error while allocating frame buffer"));
            return false;
         }

         this.field_152874_j.add(var2);
         this.field_152875_k.add(var2);
      }

      return true;
   }

   public boolean isBroadcastPaused() {
      return this.broadcastState == BroadcastController.BroadcastState.Paused;
   }

   public void func_152821_H() {
      if (this.theStream != null && this.field_152876_l) {
         ErrorCode var1 = this.theStream.pollTasks();
         this.func_152853_a(var1);
         if (this.isIngestTesting()) {
            this.ingestServTester.func_153041_j();
            if (this.ingestServTester.func_153032_e()) {
               this.ingestServTester = null;
               this.func_152827_a(BroadcastController.BroadcastState.ReadyToBroadcast);
            }
         }

         String var2;
         switch($SWITCH_TABLE$net$minecraft$client$stream$BroadcastController$BroadcastState()[this.broadcastState.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 5:
         case 7:
         case 9:
         case 10:
         case 12:
         case 14:
         default:
            break;
         case 4:
            this.func_152827_a(BroadcastController.BroadcastState.LoggingIn);
            var1 = this.theStream.login(this.authenticationToken);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.logError(String.format("Error in TTV_Login: %s\n", var2));
            }
            break;
         case 6:
            this.func_152827_a(BroadcastController.BroadcastState.FindingIngestServer);
            var1 = this.theStream.getIngestServers(this.authenticationToken);
            if (ErrorCode.failed(var1)) {
               this.func_152827_a(BroadcastController.BroadcastState.LoggedIn);
               var2 = ErrorCode.getString(var1);
               this.logError(String.format("Error in TTV_GetIngestServers: %s\n", var2));
            }
            break;
         case 8:
            this.func_152827_a(BroadcastController.BroadcastState.ReadyToBroadcast);
            var1 = this.theStream.getUserInfo(this.authenticationToken);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.logError(String.format("Error in TTV_GetUserInfo: %s\n", var2));
            }

            this.func_152835_I();
            var1 = this.theStream.getArchivingState(this.authenticationToken);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.logError(String.format("Error in TTV_GetArchivingState: %s\n", var2));
            }
            break;
         case 11:
         case 13:
            this.func_152835_I();
         }
      }

   }

   public ErrorCode submitStreamFrame(FrameBuffer var1) {
      if (this.isBroadcastPaused()) {
         this.func_152854_G();
      } else if (!this.isBroadcasting()) {
         return ErrorCode.TTV_EC_STREAM_NOT_STARTED;
      }

      ErrorCode var2 = this.theStream.submitVideoFrame(var1);
      if (var2 != ErrorCode.TTV_EC_SUCCESS) {
         String var3 = ErrorCode.getString(var2);
         if (ErrorCode.succeeded(var2)) {
            this.logWarning(String.format("Warning in SubmitTexturePointer: %s\n", var3));
         } else {
            this.logError(String.format("Error in SubmitTexturePointer: %s\n", var3));
            this.stopBroadcasting();
         }

         if (this.broadcastListener != null) {
            this.broadcastListener.func_152893_b(var2);
         }
      }

      return var2;
   }

   public void func_152842_a(String var1) {
      this.field_152868_d = var1;
   }

   public boolean requestCommercial() {
      if (!this.isBroadcasting()) {
         return false;
      } else {
         ErrorCode var1 = this.theStream.runCommercial(this.authenticationToken);
         this.func_152853_a(var1);
         return ErrorCode.succeeded(var1);
      }
   }

   public boolean stopBroadcasting() {
      if (!this.isBroadcasting()) {
         return false;
      } else {
         ErrorCode var1 = this.theStream.stop(true);
         if (ErrorCode.failed(var1)) {
            String var2 = ErrorCode.getString(var1);
            this.logError(String.format("Error while stopping the broadcast: %s", var2));
            return false;
         } else {
            this.func_152827_a(BroadcastController.BroadcastState.Stopping);
            return ErrorCode.succeeded(var1);
         }
      }
   }

   public long func_177946_b(String var1, long var2, String var4, String var5) {
      long var6 = this.theStream.sendStartSpanMetaData(this.authenticationToken, var1, var2, var4, var5);
      if (var6 == -1L) {
         this.logError(String.format("Error in SendStartSpanMetaData\n"));
      }

      return var6;
   }

   protected PixelFormat getPixelFormat() {
      return PixelFormat.TTV_PF_RGBA;
   }

   public long getStreamTime() {
      return this.theStream.getStreamTime();
   }

   public VideoParams func_152834_a(int var1, int var2, float var3, float var4) {
      int[] var5 = this.theStream.getMaxResolution(var1, var2, var3, var4);
      VideoParams var6 = new VideoParams();
      var6.maxKbps = var1;
      var6.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
      var6.pixelFormat = this.getPixelFormat();
      var6.targetFps = var2;
      var6.outputWidth = var5[0];
      var6.outputHeight = var5[1];
      var6.disableAdaptiveBitrate = false;
      var6.verticalFlip = false;
      return var6;
   }

   protected void func_152835_I() {
      long var1 = System.nanoTime();
      long var3 = (var1 - this.field_152890_z) / 1000000000L;
      if (var3 >= 30L) {
         this.field_152890_z = var1;
         ErrorCode var5 = this.theStream.getStreamInfo(this.authenticationToken, this.field_152880_p);
         if (ErrorCode.failed(var5)) {
            String var6 = ErrorCode.getString(var5);
            this.logError(String.format("Error in TTV_GetStreamInfo: %s", var6));
         }
      }

   }

   public void setIngestServer(IngestServer var1) {
      this.ingestServ = var1;
   }

   protected void func_152831_M() {
      for(int var1 = 0; var1 < this.field_152874_j.size(); ++var1) {
         FrameBuffer var2 = (FrameBuffer)this.field_152874_j.get(var1);
         var2.free();
      }

      this.field_152875_k.clear();
      this.field_152874_j.clear();
   }

   public boolean func_152849_q() {
      return this.field_152877_m;
   }

   public FrameBuffer func_152822_N() {
      if (this.field_152875_k.size() == 0) {
         this.logError(String.format("Out of free buffers, this should never happen"));
         return null;
      } else {
         FrameBuffer var1 = (FrameBuffer)this.field_152875_k.get(this.field_152875_k.size() - 1);
         this.field_152875_k.remove(this.field_152875_k.size() - 1);
         return var1;
      }
   }

   public static enum BroadcastState {
      ReadyToBroadcast,
      Initialized,
      Authenticated,
      FindingIngestServer,
      ReceivedIngestServers,
      Authenticating,
      Broadcasting;

      private static final BroadcastController.BroadcastState[] ENUM$VALUES = new BroadcastController.BroadcastState[]{Uninitialized, Initialized, Authenticating, Authenticated, LoggingIn, LoggedIn, FindingIngestServer, ReceivedIngestServers, ReadyToBroadcast, Starting, Broadcasting, Stopping, Paused, IngestTesting};
      LoggedIn,
      Starting,
      Paused,
      Stopping,
      LoggingIn,
      IngestTesting,
      Uninitialized;
   }

   public interface BroadcastListener {
      void func_152893_b(ErrorCode var1);

      void func_152899_b();

      void func_152898_a(ErrorCode var1, GameInfo[] var2);

      void func_152897_a(ErrorCode var1);

      void func_152892_c(ErrorCode var1);

      void func_152896_a(IngestList var1);

      void func_152900_a(ErrorCode var1, AuthToken var2);

      void func_152901_c();

      void func_152894_a(StreamInfo var1);

      void func_152891_a(BroadcastController.BroadcastState var1);

      void func_152895_a();
   }
}
