import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
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

public class bqj {
   private static final np<String> E = new np(String.class, 50);
   protected String f = "";
   protected bql A;
   protected final int a = 30;
   protected Core h = null;
   private ErrorCode G;
   protected AudioParams r;
   protected long z;
   private static final Logger D = LogManager.getLogger();
   protected List<FrameBuffer> k = Lists.newArrayList();
   protected boolean g = true;
   protected ChannelInfo v;
   protected String d = "";
   protected IStatCallbacks C;
   protected AuthToken u;
   protected String e = "";
   protected bqj.a o;
   protected bqj.b c = null;
   protected List<FrameBuffer> j = Lists.newArrayList();
   protected IngestServer t;
   protected IngestList s;
   protected IStreamCallbacks B;
   protected ArchivingState y;
   protected VideoParams q;
   protected boolean n = false;
   protected StreamInfo x;
   private String F = null;
   protected final int b = 3;
   protected UserInfo w;
   protected String p;
   protected Stream i = null;
   protected boolean m = false;
   protected boolean l = false;

   public bqj() {
      this.o = bqj.a.a;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = new IngestList(new IngestServer[0]);
      this.t = null;
      this.u = new AuthToken();
      this.v = new ChannelInfo();
      this.w = new UserInfo();
      this.x = new StreamInfo();
      this.y = new ArchivingState();
      this.z = 0L;
      this.A = null;
      this.B = new IStreamCallbacks(this) {
         final bqj a;

         public void getIngestServersCallback(ErrorCode var1, IngestList var2) {
            if (ErrorCode.succeeded(var1)) {
               this.a.s = var2;
               this.a.t = this.a.s.getDefaultServer();
               this.a.a(bqj.a.h);

               try {
                  if (this.a.c != null) {
                     this.a.c.a(var2);
                  }
               } catch (Exception var4) {
                  this.a.d(var4.toString());
               }
            } else {
               String var3 = ErrorCode.getString(var1);
               this.a.d(String.format("IngestListCallback got failure: %s", var3));
               this.a.a(bqj.a.e);
            }

         }

         public void stopCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               this.a.q = null;
               this.a.r = null;
               this.a.P();

               try {
                  if (this.a.c != null) {
                     this.a.c.c();
                  }
               } catch (Exception var3) {
                  this.a.d(var3.toString());
               }

               if (this.a.m) {
                  this.a.a(bqj.a.i);
               } else {
                  this.a.a(bqj.a.b);
               }
            } else {
               this.a.a(bqj.a.i);
               String var2 = ErrorCode.getString(var1);
               this.a.d(String.format("stopCallback got failure: %s", var2));
            }

         }

         public void sendStartSpanMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.a.d(String.format("sendStartSpanMetaDataCallback got failure: %s", var2));
            }

         }

         public void requestAuthTokenCallback(ErrorCode var1, AuthToken var2) {
            if (ErrorCode.succeeded(var1)) {
               this.a.u = var2;
               this.a.a(bqj.a.d);
            } else {
               this.a.u.data = "";
               this.a.a(bqj.a.b);
               String var3 = ErrorCode.getString(var1);
               this.a.d(String.format("RequestAuthTokenDoneCallback got failure: %s", var3));
            }

            try {
               if (this.a.c != null) {
                  this.a.c.a(var1, var2);
               }
            } catch (Exception var4) {
               this.a.d(var4.toString());
            }

         }

         public void bufferUnlockCallback(long var1) {
            FrameBuffer var3 = FrameBuffer.lookupBuffer(var1);
            this.a.k.add(var3);
         }

         public void getStreamInfoCallback(ErrorCode var1, StreamInfo var2) {
            if (ErrorCode.succeeded(var1)) {
               this.a.x = var2;

               try {
                  if (this.a.c != null) {
                     this.a.c.a(var2);
                  }
               } catch (Exception var4) {
                  this.a.d(var4.toString());
               }
            } else {
               String var3 = ErrorCode.getString(var1);
               this.a.e(String.format("StreamInfoDoneCallback got failure: %s", var3));
            }

         }

         public void sendEndSpanMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.a.d(String.format("sendEndSpanMetaDataCallback got failure: %s", var2));
            }

         }

         public void loginCallback(ErrorCode var1, ChannelInfo var2) {
            if (ErrorCode.succeeded(var1)) {
               this.a.v = var2;
               this.a.a(bqj.a.f);
               this.a.m = true;
            } else {
               this.a.a(bqj.a.b);
               this.a.m = false;
               String var3 = ErrorCode.getString(var1);
               this.a.d(String.format("LoginCallback got failure: %s", var3));
            }

            try {
               if (this.a.c != null) {
                  this.a.c.a(var1);
               }
            } catch (Exception var4) {
               this.a.d(var4.toString());
            }

         }

         public void sendActionMetaDataCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.a.d(String.format("sendActionMetaDataCallback got failure: %s", var2));
            }

         }

         {
            this.a = var1;
         }

         public void runCommercialCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.a.e(String.format("RunCommercialCallback got failure: %s", var2));
            }

         }

         public void getUserInfoCallback(ErrorCode var1, UserInfo var2) {
            this.a.w = var2;
            if (ErrorCode.failed(var1)) {
               String var3 = ErrorCode.getString(var1);
               this.a.d(String.format("UserInfoDoneCallback got failure: %s", var3));
            }

         }

         public void setStreamInfoCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.a.e(String.format("SetStreamInfoCallback got failure: %s", var2));
            }

         }

         public void getGameNameListCallback(ErrorCode var1, GameInfoList var2) {
            if (ErrorCode.failed(var1)) {
               String var3 = ErrorCode.getString(var1);
               this.a.d(String.format("GameNameListCallback got failure: %s", var3));
            }

            try {
               if (this.a.c != null) {
                  this.a.c.a(var1, var2 == null ? new GameInfo[0] : var2.list);
               }
            } catch (Exception var4) {
               this.a.d(var4.toString());
            }

         }

         public void startCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               try {
                  if (this.a.c != null) {
                     this.a.c.b();
                  }
               } catch (Exception var4) {
                  this.a.d(var4.toString());
               }

               this.a.a(bqj.a.k);
            } else {
               this.a.q = null;
               this.a.r = null;
               this.a.a(bqj.a.i);

               try {
                  if (this.a.c != null) {
                     this.a.c.c(var1);
                  }
               } catch (Exception var3) {
                  this.a.d(var3.toString());
               }

               String var2 = ErrorCode.getString(var1);
               this.a.d(String.format("startCallback got failure: %s", var2));
            }

         }

         public void getArchivingStateCallback(ErrorCode var1, ArchivingState var2) {
            this.a.y = var2;
            if (ErrorCode.failed(var1)) {
            }

         }
      };
      this.C = new IStatCallbacks(this) {
         final bqj a;

         public void statCallback(StatType var1, long var2) {
         }

         {
            this.a = var1;
         }
      };
      this.h = Core.getInstance();
      if (Core.getInstance() == null) {
         this.h = new Core(new StandardCoreAPI());
      }

      this.i = new Stream(new DesktopStreamAPI());
   }

   public void a(IngestServer var1) {
      this.t = var1;
   }

   public void a(FrameBuffer var1) {
      try {
         this.i.captureFrameBuffer_ReadPixels(var1);
      } catch (Throwable var5) {
         .b var3 = .b.a(var5, "Trying to submit a frame to Twitch");
         c var4 = var3.a("Broadcast State");
         var4.a((String)"Last reported errors", (Object)Arrays.toString(E.c()));
         var4.a((String)"Buffer", (Object)var1);
         var4.a((String)"Free buffer count", (Object)this.k.size());
         var4.a((String)"Capture buffer count", (Object)this.j.size());
         throw new e(var3);
      }
   }

   public boolean a(String var1, long var2, long var4, String var6, String var7) {
      if (var4 == -1L) {
         this.d(String.format("Invalid sequence id: %d\n", var4));
         return false;
      } else {
         ErrorCode var8 = this.i.sendEndSpanMetaData(this.u, var1, var2, var4, var6, var7);
         if (ErrorCode.failed(var8)) {
            String var9 = ErrorCode.getString(var8);
            this.d(String.format("Error in SendStopSpanMetaData: %s\n", var9));
            return false;
         } else {
            return true;
         }
      }
   }

   public boolean C() {
      if (this.l) {
         return false;
      } else {
         this.i.setStreamCallbacks(this.B);
         ErrorCode var1 = this.h.initialize(this.d, System.getProperty("java.library.path"));
         if (!this.a(var1)) {
            this.i.setStreamCallbacks((IStreamCallbacks)null);
            this.G = var1;
            return false;
         } else {
            var1 = this.h.setTraceLevel(MessageLevel.TTV_ML_ERROR);
            if (!this.a(var1)) {
               this.i.setStreamCallbacks((IStreamCallbacks)null);
               this.h.shutdown();
               this.G = var1;
               return false;
            } else if (ErrorCode.succeeded(var1)) {
               this.l = true;
               this.a(bqj.a.b);
               return true;
            } else {
               this.G = var1;
               this.h.shutdown();
               return false;
            }
         }
      }
   }

   public boolean D() {
      if (!this.l) {
         return true;
      } else if (this.o()) {
         return false;
      } else {
         this.n = true;
         this.F();
         this.i.setStreamCallbacks((IStreamCallbacks)null);
         this.i.setStatCallbacks((IStatCallbacks)null);
         ErrorCode var1 = this.h.shutdown();
         this.a(var1);
         this.l = false;
         this.n = false;
         this.a(bqj.a.a);
         return true;
      }
   }

   public boolean a(VideoParams var1) {
      if (var1 != null && this.n()) {
         this.q = var1.clone();
         this.r = new AudioParams();
         this.r.audioEnabled = this.g && this.y();
         this.r.enableMicCapture = this.r.audioEnabled;
         this.r.enablePlaybackCapture = this.r.audioEnabled;
         this.r.enablePassthroughAudio = false;
         if (!this.O()) {
            this.q = null;
            this.r = null;
            return false;
         } else {
            ErrorCode var2 = this.i.start(var1, this.r, this.t, StartFlags.None, true);
            if (ErrorCode.failed(var2)) {
               this.P();
               String var3 = ErrorCode.getString(var2);
               this.d(String.format("Error while starting to broadcast: %s", var3));
               this.q = null;
               this.r = null;
               return false;
            } else {
               this.a(bqj.a.j);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public boolean a(String var1, AuthToken var2) {
      if (this.o()) {
         return false;
      } else {
         this.F();
         if (var1 != null && !var1.isEmpty()) {
            if (var2 != null && var2.data != null && !var2.data.isEmpty()) {
               this.p = var1;
               this.u = var2;
               if (this.b()) {
                  this.a(bqj.a.d);
               }

               return true;
            } else {
               this.d("Auth token must be valid");
               return false;
            }
         } else {
            this.d("Username must be valid");
            return false;
         }
      }
   }

   public ErrorCode A() {
      return this.G;
   }

   protected boolean a(ErrorCode var1) {
      if (ErrorCode.failed(var1)) {
         this.d(ErrorCode.getString(var1));
         return false;
      } else {
         return true;
      }
   }

   public boolean a(String var1, String var2, String var3) {
      if (!this.m) {
         return false;
      } else {
         if (var1 == null || var1.equals("")) {
            var1 = this.p;
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
         ErrorCode var5 = this.i.setStreamInfo(this.u, var1, var4);
         this.a(var5);
         return ErrorCode.succeeded(var5);
      }
   }

   public IngestList t() {
      return this.s;
   }

   public StreamInfo j() {
      return this.x;
   }

   public void K() {
      if (this.i != null && this.l) {
         ErrorCode var1 = this.i.pollTasks();
         this.a(var1);
         if (this.o()) {
            this.A.k();
            if (this.A.f()) {
               this.A = null;
               this.a(bqj.a.i);
            }
         }

         String var2;
         switch(this.o) {
         case d:
            this.a(bqj.a.e);
            var1 = this.i.login(this.u);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.d(String.format("Error in TTV_Login: %s\n", var2));
            }
            break;
         case f:
            this.a(bqj.a.g);
            var1 = this.i.getIngestServers(this.u);
            if (ErrorCode.failed(var1)) {
               this.a(bqj.a.f);
               var2 = ErrorCode.getString(var1);
               this.d(String.format("Error in TTV_GetIngestServers: %s\n", var2));
            }
            break;
         case h:
            this.a(bqj.a.i);
            var1 = this.i.getUserInfo(this.u);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.d(String.format("Error in TTV_GetUserInfo: %s\n", var2));
            }

            this.L();
            var1 = this.i.getArchivingState(this.u);
            if (ErrorCode.failed(var1)) {
               var2 = ErrorCode.getString(var1);
               this.d(String.format("Error in TTV_GetArchivingState: %s\n", var2));
            }
         case j:
         case l:
         case g:
         case c:
         case b:
         case a:
         case n:
         default:
            break;
         case m:
         case k:
            this.L();
         }

      }
   }

   public boolean F() {
      if (this.o()) {
         return false;
      } else {
         if (this.m()) {
            this.i.stop(false);
         }

         this.p = "";
         this.u = new AuthToken();
         if (!this.m) {
            return false;
         } else {
            this.m = false;
            if (!this.n) {
               try {
                  if (this.c != null) {
                     this.c.a();
                  }
               } catch (Exception var2) {
                  this.d(var2.toString());
               }
            }

            this.a(bqj.a.b);
            return true;
         }
      }
   }

   public long x() {
      return this.i.getStreamTime();
   }

   protected void a(bqj.a var1) {
      if (var1 != this.o) {
         this.o = var1;

         try {
            if (this.c != null) {
               this.c.a(var1);
            }
         } catch (Exception var3) {
            this.d(var3.toString());
         }

      }
   }

   public long b(String var1, long var2, String var4, String var5) {
      long var6 = this.i.sendStartSpanMetaData(this.u, var1, var2, var4, var5);
      if (var6 == -1L) {
         this.d(String.format("Error in SendStartSpanMetaData\n"));
      }

      return var6;
   }

   public boolean m() {
      return this.o == bqj.a.k || this.o == bqj.a.m;
   }

   public boolean n() {
      return this.o == bqj.a.i;
   }

   public void E() {
      if (this.o != bqj.a.a) {
         if (this.A != null) {
            this.A.m();
         }

         for(; this.A != null; this.K()) {
            try {
               Thread.sleep(200L);
            } catch (Exception var2) {
               this.d(var2.toString());
            }
         }

         this.D();
      }

   }

   protected void P() {
      for(int var1 = 0; var1 < this.j.size(); ++var1) {
         FrameBuffer var2 = (FrameBuffer)this.j.get(var1);
         var2.free();
      }

      this.k.clear();
      this.j.clear();
   }

   public boolean I() {
      if (!this.m()) {
         return false;
      } else {
         ErrorCode var1 = this.i.pauseVideo();
         if (ErrorCode.failed(var1)) {
            this.H();
            String var2 = ErrorCode.getString(var1);
            this.d(String.format("Error pausing stream: %s\n", var2));
         } else {
            this.a(bqj.a.m);
         }

         return ErrorCode.succeeded(var1);
      }
   }

   public void a(float var1) {
      this.i.setVolume(AudioDeviceType.TTV_RECORDER_DEVICE, var1);
   }

   protected void L() {
      long var1 = System.nanoTime();
      long var3 = (var1 - this.z) / 1000000000L;
      if (var3 >= 30L) {
         this.z = var1;
         ErrorCode var5 = this.i.getStreamInfo(this.u, this.p);
         if (ErrorCode.failed(var5)) {
            String var6 = ErrorCode.getString(var5);
            this.d(String.format("Error in TTV_GetStreamInfo: %s", var6));
         }

      }
   }

   public boolean b() {
      return this.l;
   }

   public boolean q() {
      return this.m;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public void b(float var1) {
      this.i.setVolume(AudioDeviceType.TTV_PLAYBACK_DEVICE, var1);
   }

   public FrameBuffer Q() {
      if (this.k.size() == 0) {
         this.d(String.format("Out of free buffers, this should never happen"));
         return null;
      } else {
         FrameBuffer var1 = (FrameBuffer)this.k.get(this.k.size() - 1);
         this.k.remove(this.k.size() - 1);
         return var1;
      }
   }

   public boolean H() {
      if (!this.m()) {
         return false;
      } else {
         ErrorCode var1 = this.i.stop(true);
         if (ErrorCode.failed(var1)) {
            String var2 = ErrorCode.getString(var1);
            this.d(String.format("Error while stopping the broadcast: %s", var2));
            return false;
         } else {
            this.a(bqj.a.l);
            return ErrorCode.succeeded(var1);
         }
      }
   }

   public void a(bqj.b var1) {
      this.c = var1;
   }

   public ErrorCode b(FrameBuffer var1) {
      if (this.p()) {
         this.J();
      } else if (!this.m()) {
         return ErrorCode.TTV_EC_STREAM_NOT_STARTED;
      }

      ErrorCode var2 = this.i.submitVideoFrame(var1);
      if (var2 != ErrorCode.TTV_EC_SUCCESS) {
         String var3 = ErrorCode.getString(var2);
         if (ErrorCode.succeeded(var2)) {
            this.e(String.format("Warning in SubmitTexturePointer: %s\n", var3));
         } else {
            this.d(String.format("Error in SubmitTexturePointer: %s\n", var3));
            this.H();
         }

         if (this.c != null) {
            this.c.b(var2);
         }
      }

      return var2;
   }

   public bql M() {
      if (this.n() && this.s != null) {
         if (this.o()) {
            return null;
         } else {
            this.A = new bql(this.i, this.s);
            this.A.j();
            this.a(bqj.a.n);
            return this.A;
         }
      } else {
         return null;
      }
   }

   protected void e(String var1) {
      E.a("<Warning> " + var1);
      D.warn(bqn.a, "[Broadcast controller] {}", new Object[]{var1});
   }

   protected PixelFormat B() {
      return PixelFormat.TTV_PF_RGBA;
   }

   protected boolean O() {
      for(int var1 = 0; var1 < 3; ++var1) {
         FrameBuffer var2 = this.i.allocateFrameBuffer(this.q.outputWidth * this.q.outputHeight * 4);
         if (!var2.getIsValid()) {
            this.d(String.format("Error while allocating frame buffer"));
            return false;
         }

         this.j.add(var2);
         this.k.add(var2);
      }

      return true;
   }

   public boolean J() {
      if (!this.p()) {
         return false;
      } else {
         this.a(bqj.a.k);
         return true;
      }
   }

   protected boolean y() {
      return true;
   }

   public boolean G() {
      if (!this.m()) {
         return false;
      } else {
         ErrorCode var1 = this.i.runCommercial(this.u);
         this.a(var1);
         return ErrorCode.succeeded(var1);
      }
   }

   public ChannelInfo l() {
      return this.v;
   }

   public boolean p() {
      return this.o == bqj.a.m;
   }

   public bql w() {
      return this.A;
   }

   protected void d(String var1) {
      this.F = var1;
      E.a("<Error> " + var1);
      D.error(bqn.a, "[Broadcast controller] {}", new Object[]{var1});
   }

   public boolean o() {
      return this.o == bqj.a.n;
   }

   public IngestServer s() {
      return this.t;
   }

   public VideoParams a(int var1, int var2, float var3, float var4) {
      int[] var5 = this.i.getMaxResolution(var1, var2, var3, var4);
      VideoParams var6 = new VideoParams();
      var6.maxKbps = var1;
      var6.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
      var6.pixelFormat = this.B();
      var6.targetFps = var2;
      var6.outputWidth = var5[0];
      var6.outputHeight = var5[1];
      var6.disableAdaptiveBitrate = false;
      var6.verticalFlip = false;
      return var6;
   }

   public boolean a(String var1, long var2, String var4, String var5) {
      ErrorCode var6 = this.i.sendActionMetaData(this.u, var1, var2, var4, var5);
      if (ErrorCode.failed(var6)) {
         String var7 = ErrorCode.getString(var6);
         this.d(String.format("Error while sending meta data: %s\n", var7));
         return false;
      } else {
         return true;
      }
   }

   public interface b {
      void a(bqj.a var1);

      void c(ErrorCode var1);

      void a(ErrorCode var1);

      void b(ErrorCode var1);

      void a(ErrorCode var1, GameInfo[] var2);

      void a(StreamInfo var1);

      void a(IngestList var1);

      void b();

      void a();

      void c();

      void a(ErrorCode var1, AuthToken var2);
   }

   public static enum a {
      f,
      b,
      c,
      m,
      j,
      k,
      i,
      g,
      n,
      d,
      a,
      l,
      h,
      e;

      private static final bqj.a[] o = new bqj.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n};
   }
}
