import com.google.common.collect.Lists;
import java.util.List;
import tv.twitch.AuthToken;
import tv.twitch.ErrorCode;
import tv.twitch.broadcast.ArchivingState;
import tv.twitch.broadcast.AudioParams;
import tv.twitch.broadcast.ChannelInfo;
import tv.twitch.broadcast.EncodingCpuUsage;
import tv.twitch.broadcast.FrameBuffer;
import tv.twitch.broadcast.GameInfoList;
import tv.twitch.broadcast.IStatCallbacks;
import tv.twitch.broadcast.IStreamCallbacks;
import tv.twitch.broadcast.IngestList;
import tv.twitch.broadcast.IngestServer;
import tv.twitch.broadcast.PixelFormat;
import tv.twitch.broadcast.RTMPState;
import tv.twitch.broadcast.StartFlags;
import tv.twitch.broadcast.StatType;
import tv.twitch.broadcast.Stream;
import tv.twitch.broadcast.StreamInfo;
import tv.twitch.broadcast.UserInfo;
import tv.twitch.broadcast.VideoParams;

public class bql {
   protected IStreamCallbacks A;
   protected float w;
   protected long k;
   protected IngestServer p;
   protected long g;
   protected List<FrameBuffer> l;
   protected long u;
   protected boolean z;
   protected long f;
   protected int t;
   protected RTMPState h;
   protected AudioParams j;
   protected long e;
   protected bql.a a = null;
   protected VideoParams i;
   protected boolean y;
   protected IngestList c = null;
   protected bql.b d;
   protected float v;
   protected Stream b = null;
   protected IStatCallbacks o;
   protected boolean r;
   protected boolean x;
   protected IStreamCallbacks n;
   protected int s;
   protected boolean m;
   protected boolean q;
   protected IStatCallbacks B;

   public boolean f() {
      return this.d == bql.b.f || this.d == bql.b.h || this.d == bql.b.i;
   }

   public void k() {
      if (!this.f() && this.d != bql.b.a) {
         if (!this.y && !this.z) {
            switch(this.d) {
            case b:
            case e:
               if (this.p != null) {
                  if (this.r || !this.m) {
                     this.p.bitrateKbps = 0.0F;
                  }

                  this.b(this.p);
               } else {
                  this.k = 0L;
                  this.r = false;
                  this.m = true;
                  if (this.d != bql.b.b) {
                     ++this.s;
                  }

                  if (this.s < this.c.getServers().length) {
                     this.p = this.c.getServers()[this.s];
                     this.a(this.p);
                  } else {
                     this.a(bql.b.f);
                  }
               }
               break;
            case c:
            case d:
               this.c(this.p);
               break;
            case g:
               this.a(bql.b.h);
            }

            this.o();
            if (this.d == bql.b.h || this.d == bql.b.f) {
               this.p();
            }

         }
      }
   }

   protected void a(bql.b var1) {
      if (var1 != this.d) {
         this.d = var1;
         if (this.a != null) {
            this.a.a(this, var1);
         }

      }
   }

   protected void o() {
      float var1 = (float)this.n();
      switch(this.d) {
      case b:
      case c:
      case a:
      case f:
      case h:
      case i:
         this.w = 0.0F;
         break;
      case e:
         this.w = 1.0F;
         break;
      case d:
      case g:
      default:
         this.w = var1 / (float)this.e;
      }

      switch(this.d) {
      case f:
      case h:
      case i:
         this.v = 1.0F;
         break;
      default:
         this.v = (float)this.s / (float)this.c.getServers().length;
         this.v += this.w / (float)this.c.getServers().length;
      }

   }

   public float i() {
      return this.w;
   }

   protected void b(IngestServer var1) {
      if (this.y) {
         this.r = true;
      } else if (this.x) {
         this.z = true;
         ErrorCode var2 = this.b.stop(true);
         if (ErrorCode.failed(var2)) {
            this.A.stopCallback(ErrorCode.TTV_EC_SUCCESS);
            System.out.println("Stop failed: " + var2.toString());
         }

         this.b.pollStats();
      } else {
         this.A.stopCallback(ErrorCode.TTV_EC_SUCCESS);
      }

   }

   public void a(bql.a var1) {
      this.a = var1;
   }

   public void j() {
      if (this.d == bql.b.a) {
         this.s = 0;
         this.q = false;
         this.r = false;
         this.x = false;
         this.y = false;
         this.z = false;
         this.o = this.b.getStatCallbacks();
         this.b.setStatCallbacks(this.B);
         this.n = this.b.getStreamCallbacks();
         this.b.setStreamCallbacks(this.A);
         this.i = new VideoParams();
         this.i.targetFps = 60;
         this.i.maxKbps = 3500;
         this.i.outputWidth = 1280;
         this.i.outputHeight = 720;
         this.i.pixelFormat = PixelFormat.TTV_PF_BGRA;
         this.i.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
         this.i.disableAdaptiveBitrate = true;
         this.i.verticalFlip = false;
         this.b.getDefaultParams(this.i);
         this.j = new AudioParams();
         this.j.audioEnabled = false;
         this.j.enableMicCapture = false;
         this.j.enablePlaybackCapture = false;
         this.j.enablePassthroughAudio = false;
         this.l = Lists.newArrayList();
         byte var1 = 3;

         for(int var2 = 0; var2 < var1; ++var2) {
            FrameBuffer var3 = this.b.allocateFrameBuffer(this.i.outputWidth * this.i.outputHeight * 4);
            if (!var3.getIsValid()) {
               this.p();
               this.a(bql.b.i);
               return;
            }

            this.l.add(var3);
            this.b.randomizeFrameBuffer(var3);
         }

         this.a(bql.b.b);
         this.k = System.currentTimeMillis();
      }
   }

   protected boolean c(IngestServer var1) {
      if (!this.r && !this.q && this.n() < this.e) {
         if (!this.y && !this.z) {
            ErrorCode var2 = this.b.submitVideoFrame((FrameBuffer)this.l.get(this.t));
            if (ErrorCode.failed(var2)) {
               this.m = false;
               this.a(bql.b.e);
               return false;
            } else {
               this.t = (this.t + 1) % this.l.size();
               this.b.pollStats();
               if (this.h == RTMPState.SendVideo) {
                  this.a(bql.b.d);
                  long var3 = this.n();
                  if (var3 > 0L && this.g > this.u) {
                     var1.bitrateKbps = (float)(this.g * 8L) / (float)this.n();
                     this.u = this.g;
                  }
               }

               return true;
            }
         } else {
            return true;
         }
      } else {
         this.a(bql.b.e);
         return true;
      }
   }

   public IngestServer c() {
      return this.p;
   }

   public void m() {
      if (!this.f() && !this.q) {
         this.q = true;
         if (this.p != null) {
            this.p.bitrateKbps = 0.0F;
         }

      }
   }

   protected void p() {
      this.p = null;
      if (this.l != null) {
         for(int var1 = 0; var1 < this.l.size(); ++var1) {
            ((FrameBuffer)this.l.get(var1)).free();
         }

         this.l = null;
      }

      if (this.b.getStatCallbacks() == this.B) {
         this.b.setStatCallbacks(this.o);
         this.o = null;
      }

      if (this.b.getStreamCallbacks() == this.A) {
         this.b.setStreamCallbacks(this.n);
         this.n = null;
      }

   }

   public int d() {
      return this.s;
   }

   protected boolean a(IngestServer var1) {
      this.m = true;
      this.g = 0L;
      this.h = RTMPState.Idle;
      this.p = var1;
      this.y = true;
      this.a(bql.b.c);
      ErrorCode var2 = this.b.start(this.i, this.j, var1, StartFlags.TTV_Start_BandwidthTest, true);
      if (ErrorCode.failed(var2)) {
         this.y = false;
         this.m = false;
         this.a(bql.b.e);
         return false;
      } else {
         this.u = this.g;
         var1.bitrateKbps = 0.0F;
         this.t = 0;
         return true;
      }
   }

   protected long n() {
      return System.currentTimeMillis() - this.k;
   }

   public bql(Stream var1, IngestList var2) {
      this.d = bql.b.a;
      this.e = 8000L;
      this.f = 2000L;
      this.g = 0L;
      this.h = RTMPState.Invalid;
      this.i = null;
      this.j = null;
      this.k = 0L;
      this.l = null;
      this.m = false;
      this.n = null;
      this.o = null;
      this.p = null;
      this.q = false;
      this.r = false;
      this.s = -1;
      this.t = 0;
      this.u = 0L;
      this.v = 0.0F;
      this.w = 0.0F;
      this.x = false;
      this.y = false;
      this.z = false;
      this.A = new IStreamCallbacks(this) {
         final bql a;

         public void getStreamInfoCallback(ErrorCode var1, StreamInfo var2) {
         }

         public void getUserInfoCallback(ErrorCode var1, UserInfo var2) {
         }

         public void runCommercialCallback(ErrorCode var1) {
         }

         public void getArchivingStateCallback(ErrorCode var1, ArchivingState var2) {
         }

         public void startCallback(ErrorCode var1) {
            this.a.y = false;
            if (ErrorCode.succeeded(var1)) {
               this.a.x = true;
               this.a.k = System.currentTimeMillis();
               this.a.a(bql.b.c);
            } else {
               this.a.m = false;
               this.a.a(bql.b.e);
            }

         }

         public void sendStartSpanMetaDataCallback(ErrorCode var1) {
         }

         public void requestAuthTokenCallback(ErrorCode var1, AuthToken var2) {
         }

         public void bufferUnlockCallback(long var1) {
         }

         public void stopCallback(ErrorCode var1) {
            if (ErrorCode.failed(var1)) {
               System.out.println("IngestTester.stopCallback failed to stop - " + this.a.p.serverName + ": " + var1.toString());
            }

            this.a.z = false;
            this.a.x = false;
            this.a.a(bql.b.e);
            this.a.p = null;
            if (this.a.q) {
               this.a.a(bql.b.g);
            }

         }

         public void getIngestServersCallback(ErrorCode var1, IngestList var2) {
         }

         public void getGameNameListCallback(ErrorCode var1, GameInfoList var2) {
         }

         public void loginCallback(ErrorCode var1, ChannelInfo var2) {
         }

         public void setStreamInfoCallback(ErrorCode var1) {
         }

         public void sendEndSpanMetaDataCallback(ErrorCode var1) {
         }

         public void sendActionMetaDataCallback(ErrorCode var1) {
         }

         {
            this.a = var1;
         }
      };
      this.B = new IStatCallbacks(this) {
         final bql a;

         {
            this.a = var1;
         }

         public void statCallback(StatType var1, long var2) {
            switch(var1) {
            case TTV_ST_RTMPSTATE:
               this.a.h = RTMPState.lookupValue((int)var2);
               break;
            case TTV_ST_RTMPDATASENT:
               this.a.g = var2;
            }

         }
      };
      this.b = var1;
      this.c = var2;
   }

   public interface a {
      void a(bql var1, bql.b var2);
   }

   public static enum b {
      g,
      i,
      c,
      d,
      f;

      private static final bql.b[] j = new bql.b[]{a, b, c, d, e, f, g, h, i};
      h,
      b,
      e,
      a;
   }
}
