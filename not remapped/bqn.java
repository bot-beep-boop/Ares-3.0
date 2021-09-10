import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.properties.Property;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.lwjgl.opengl.GL11;
import tv.twitch.AuthToken;
import tv.twitch.ErrorCode;
import tv.twitch.broadcast.EncodingCpuUsage;
import tv.twitch.broadcast.FrameBuffer;
import tv.twitch.broadcast.GameInfo;
import tv.twitch.broadcast.IngestList;
import tv.twitch.broadcast.IngestServer;
import tv.twitch.broadcast.StreamInfo;
import tv.twitch.broadcast.VideoParams;
import tv.twitch.chat.ChatRawMessage;
import tv.twitch.chat.ChatTokenizedMessage;
import tv.twitch.chat.ChatUserInfo;
import tv.twitch.chat.ChatUserMode;
import tv.twitch.chat.ChatUserSubscription;

public class bqn implements bqm, bqk.e, bqj.b, bql.a {
   private boolean n;
   private long l = 0L;
   private boolean p;
   private boolean o;
   public static final Marker a = MarkerManager.getMarker("STREAM");
   private static final Logger b = LogManager.getLogger();
   private int k = 30;
   private bfw i;
   private String e;
   private final ave f;
   private boolean m = false;
   private boolean j;
   private final Map<String, ChatUserInfo> h = Maps.newHashMap();
   private static boolean r;
   private final eu g = new fa("Twitch");
   private final bqk d;
   private bqm.a q;
   private final bqj c;

   public void b(ErrorCode var1) {
      b.warn(a, "Issue submitting frame: {} (Error code {})", new Object[]{ErrorCode.getString(var1), var1.getValue()});
      this.f.q.d().a(new fa("Issue streaming frame: " + var1 + " (" + ErrorCode.getString(var1) + ")"), 2);
   }

   public void a(bql var1, bql.b var2) {
      b.debug(a, "Ingest test state changed to {}", new Object[]{var2});
      if (var2 == bql.b.f) {
         this.m = true;
      }

   }

   public void c(String var1) {
   }

   public boolean w() {
      return this.c.o();
   }

   static bqk b(bqn var0) {
      return var0.d;
   }

   public void a(boolean var1) {
      this.p = var1;
      this.p();
   }

   public boolean l() {
      return this.c.p();
   }

   public boolean i() {
      return this.c.q();
   }

   public void a(ErrorCode var1, AuthToken var2) {
   }

   public void a(StreamInfo var1) {
      b.debug(a, "Stream info updated; {} viewers on stream ID {}", new Object[]{var1.viewers, var1.streamId});
   }

   public boolean k() {
      return this.c.m();
   }

   public void f(String var1) {
      this.d.a(this.e, var1);
   }

   static bqj a(bqn var0) {
      return var0.c;
   }

   public void a(String var1, ChatTokenizedMessage[] var2) {
   }

   public void d(String var1) {
   }

   public void a(bqh var1, long var2) {
      if (this.k() && this.j) {
         long var4 = this.c.x();
         if (!this.c.a(var1.c(), var4 + var2, var1.a(), var1.b())) {
            b.warn(a, "Couldn't send stream metadata action at {}: {}", new Object[]{var4 + var2, var1});
         } else {
            b.debug(a, "Sent stream metadata action at {}: {}", new Object[]{var4 + var2, var1});
         }

      }
   }

   public void c() {
      b.info(a, "Broadcast to Twitch has stopped");
   }

   public void u() {
      bql var1 = this.c.M();
      if (var1 != null) {
         var1.a((bql.a)this);
      }

   }

   public void a(ErrorCode var1, GameInfo[] var2) {
   }

   public void a() {
      b.info(a, "Logged out of twitch");
   }

   static {
      try {
         if (g.a() == g.a.c) {
            System.loadLibrary("avutil-ttv-51");
            System.loadLibrary("swresample-ttv-0");
            System.loadLibrary("libmp3lame-ttv");
            if (System.getProperty("os.arch").contains("64")) {
               System.loadLibrary("libmfxsw64");
            } else {
               System.loadLibrary("libmfxsw32");
            }
         }

         r = true;
      } catch (Throwable var1) {
         r = false;
      }

   }

   public static float c(float var0) {
      return 0.1F + var0 * 0.1F;
   }

   public void d() {
   }

   public void p() {
      if (this.k()) {
         float var1 = this.f.t.M;
         boolean var2 = this.o || var1 <= 0.0F;
         this.c.b(var2 ? 0.0F : var1);
         this.c.a(this.D() ? 0.0F : this.f.t.L);
      }

   }

   public void a(bqk.c var1) {
   }

   public void a(String var1, String var2) {
   }

   public bql v() {
      return this.c.w();
   }

   public void n() {
      this.c.I();
      this.o = true;
      this.p();
   }

   public ChatUserInfo e(String var1) {
      return (ChatUserInfo)this.h.get(var1);
   }

   public void g() {
      int var1 = this.f.t.S;
      boolean var2 = this.e != null && this.d.d(this.e);
      boolean var3 = this.d.h() == bqk.c.c && (this.e == null || this.d.e(this.e) == bqk.a.e);
      if (var1 == 2) {
         if (var2) {
            b.debug(a, "Disconnecting from twitch chat per user options");
            this.d.l(this.e);
         }
      } else if (var1 == 1) {
         if (var3 && this.c.q()) {
            b.debug(a, "Connecting to twitch chat per user options");
            this.F();
         }
      } else if (var1 == 0) {
         if (var2 && !this.k()) {
            b.debug(a, "Disconnecting from twitch chat as user is no longer streaming");
            this.d.l(this.e);
         } else if (var3 && this.k()) {
            b.debug(a, "Connecting to twitch chat as user is streaming");
            this.F();
         }
      }

      this.c.K();
      this.d.q();
   }

   public boolean C() {
      return this.n;
   }

   public String z() {
      return this.e;
   }

   public bqm.a E() {
      return this.q;
   }

   public void a(IngestList var1) {
   }

   public void q() {
      avh var1 = this.f.t;
      VideoParams var2 = this.c.a(b(var1.N), a(var1.O), c(var1.K), (float)this.f.d / (float)this.f.e);
      switch(var1.P) {
      case 0:
         var2.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_LOW;
         break;
      case 1:
         var2.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_MEDIUM;
         break;
      case 2:
         var2.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
      }

      if (this.i == null) {
         this.i = new bfw(var2.outputWidth, var2.outputHeight, false);
      } else {
         this.i.a(var2.outputWidth, var2.outputHeight);
      }

      if (var1.R != null && var1.R.length() > 0) {
         IngestServer[] var3 = this.s();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            IngestServer var6 = var3[var5];
            if (var6.serverUrl.equals(var1.R)) {
               this.c.a(var6);
               break;
            }
         }
      }

      this.k = var2.targetFps;
      this.j = var1.Q;
      this.c.a(var2);
      b.info(a, "Streaming at {}/{} at {} kbps to {}", new Object[]{var2.outputWidth, var2.outputHeight, var2.maxKbps, this.c.s().serverUrl});
      this.c.a((String)null, "Minecraft", (String)null);
   }

   protected void F() {
      bqk.c var1 = this.d.h();
      String var2 = this.c.l().name;
      this.e = var2;
      if (var1 != bqk.c.c) {
         b.warn("Invalid twitch chat state {}", new Object[]{var1});
      } else if (this.d.e(this.e) == bqk.a.e) {
         this.d.j(var2);
      } else {
         b.warn("Invalid twitch chat state {}", new Object[]{var1});
      }

   }

   private boolean a(Set<ChatUserMode> var1, Set<ChatUserSubscription> var2, int var3) {
      if (var1.contains(ChatUserMode.TTV_CHAT_USERMODE_BANNED)) {
         return false;
      } else if (var1.contains(ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR)) {
         return true;
      } else if (var1.contains(ChatUserMode.TTV_CHAT_USERMODE_MODERATOR)) {
         return true;
      } else if (var1.contains(ChatUserMode.TTV_CHAT_USERMODE_STAFF)) {
         return true;
      } else if (var3 == 0) {
         return true;
      } else {
         return var3 == 1 ? var2.contains(ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER) : false;
      }
   }

   public static int a(float var0) {
      return ns.d(10.0F + var0 * 50.0F);
   }

   public void e(ErrorCode var1) {
      if (ErrorCode.failed(var1)) {
         b.error(a, "Chat failed to shutdown");
      }

   }

   public int x() {
      return this.k() ? this.c.j().viewers : 0;
   }

   public void o() {
      this.c.J();
      this.o = false;
      this.p();
   }

   public IngestServer[] s() {
      return this.c.t().getServers();
   }

   public void a(ErrorCode var1) {
      if (ErrorCode.succeeded(var1)) {
         b.debug(a, "Login attempt successful");
         this.n = true;
      } else {
         b.warn(a, "Login attempt unsuccessful: {} (error code {})", new Object[]{ErrorCode.getString(var1), var1.getValue()});
         this.n = false;
      }

   }

   public void b(String var1) {
      b.debug(a, "Chat disconnected");
      this.h.clear();
   }

   public void d(ErrorCode var1) {
      if (ErrorCode.failed(var1)) {
         b.error(a, "Chat failed to initialize");
      }

   }

   public boolean y() {
      return this.e != null && this.e.equals(this.c.l().name);
   }

   static bqm.a a(bqn var0, bqm.a var1) {
      return var0.q = var1;
   }

   public void c(ErrorCode var1) {
      fb var2;
      if (var1 == ErrorCode.TTV_EC_SOUNDFLOWER_NOT_INSTALLED) {
         var2 = new fb("stream.unavailable.soundflower.chat.link", new Object[0]);
         var2.b().a(new et(et.a.a, "https://help.mojang.com/customer/portal/articles/1374877-configuring-soundflower-for-streaming-on-apple-computers"));
         var2.b().d(true);
         fb var3 = new fb("stream.unavailable.soundflower.chat", new Object[]{var2});
         var3.b().a(.a.e);
         this.f.q.d().a((eu)var3);
      } else {
         var2 = new fb("stream.unavailable.unknown.chat", new Object[]{ErrorCode.getString(var1)});
         var2.b().a(.a.e);
         this.f.q.d().a((eu)var2);
      }

   }

   public void a(String var1, ChatRawMessage[] var2) {
      ChatRawMessage[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ChatRawMessage var6 = var3[var5];
         this.a(var6.userName, var6);
         if (this.a(var6.modes, var6.subscriptions, this.f.t.T)) {
            fa var7 = new fa(var6.userName);
            fb var8 = new fb("chat.stream." + (var6.action ? "emote" : "text"), new Object[]{this.g, var7, .a.a(var6.message)});
            if (var6.action) {
               var8.b().b(true);
            }

            fa var9 = new fa("");
            var9.a((eu)(new fb("stream.userinfo.chatTooltip", new Object[0])));
            Iterator var10 = bab.a(var6.modes, var6.subscriptions, (bqm)null).iterator();

            while(var10.hasNext()) {
               eu var11 = (eu)var10.next();
               var9.a("\n");
               var9.a(var11);
            }

            var7.b().a(new ew(ew.a.a, var9));
            var7.b().a(new et(et.a.d, var6.userName));
            this.f.q.d().a((eu)var8);
         }
      }

   }

   public void r() {
      if (this.c.H()) {
         b.info(a, "Stopped streaming to Twitch");
      } else {
         b.warn(a, "Could not stop streaming to Twitch");
      }

   }

   public void m() {
      if (this.c.G()) {
         b.debug(a, "Requested commercial from Twitch");
      } else {
         b.warn(a, "Could not request commercial from Twitch");
      }

   }

   public static int b(float var0) {
      return ns.d(230.0F + var0 * 3270.0F);
   }

   private void a(String var1, ChatRawMessage var2) {
      ChatUserInfo var3 = (ChatUserInfo)this.h.get(var1);
      if (var3 == null) {
         var3 = new ChatUserInfo();
         var3.displayName = var1;
         this.h.put(var1, var3);
      }

      var3.subscriptions = var2.subscriptions;
      var3.modes = var2.modes;
      var3.nameColorARGB = var2.nameColorARGB;
   }

   public void a(String var1, ChatUserInfo[] var2, ChatUserInfo[] var3, ChatUserInfo[] var4) {
      ChatUserInfo[] var5 = var3;
      int var6 = var3.length;

      int var7;
      ChatUserInfo var8;
      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var5[var7];
         this.h.remove(var8.displayName);
      }

      var5 = var4;
      var6 = var4.length;

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var5[var7];
         this.h.put(var8.displayName, var8);
      }

      var5 = var2;
      var6 = var2.length;

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var5[var7];
         this.h.put(var8.displayName, var8);
      }

   }

   public boolean j() {
      return this.c.n();
   }

   public void a(bqh var1, long var2, long var4) {
      if (this.k() && this.j) {
         long var6 = this.c.x();
         String var8 = var1.a();
         String var9 = var1.b();
         long var10 = this.c.b(var1.c(), var6 + var2, var8, var9);
         if (var10 < 0L) {
            b.warn(a, "Could not send stream metadata sequence from {} to {}: {}", new Object[]{var6 + var2, var6 + var4, var1});
         } else if (this.c.a(var1.c(), var6 + var4, var10, var8, var9)) {
            b.debug(a, "Sent stream metadata sequence from {} to {}: {}", new Object[]{var6 + var2, var6 + var4, var1});
         } else {
            b.warn(a, "Half-sent stream metadata sequence from {} to {}: {}", new Object[]{var6 + var2, var6 + var4, var1});
         }

      }
   }

   public boolean A() {
      return r && this.c.b();
   }

   public void e() {
   }

   public void h() {
      if (this.c.m() && !this.c.p()) {
         long var1 = System.nanoTime();
         long var3 = (long)(1000000000 / this.k);
         long var5 = var1 - this.l;
         boolean var7 = var5 >= var3;
         if (var7) {
            FrameBuffer var8 = this.c.Q();
            bfw var9 = this.f.b();
            this.i.a(true);
            bfl.n(5889);
            bfl.E();
            bfl.D();
            bfl.a(0.0D, (double)this.i.c, (double)this.i.d, 0.0D, 1000.0D, 3000.0D);
            bfl.n(5888);
            bfl.E();
            bfl.D();
            bfl.b(0.0F, 0.0F, -2000.0F);
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            bfl.b(0, 0, this.i.c, this.i.d);
            bfl.w();
            bfl.c();
            bfl.k();
            float var10 = (float)this.i.c;
            float var11 = (float)this.i.d;
            float var12 = (float)var9.c / (float)var9.a;
            float var13 = (float)var9.d / (float)var9.b;
            var9.c();
            GL11.glTexParameterf(3553, 10241, 9729.0F);
            GL11.glTexParameterf(3553, 10240, 9729.0F);
            bfx var14 = bfx.a();
            bfd var15 = var14.c();
            var15.a(7, bms.g);
            var15.b(0.0D, (double)var11, 0.0D).a(0.0D, (double)var13).d();
            var15.b((double)var10, (double)var11, 0.0D).a((double)var12, (double)var13).d();
            var15.b((double)var10, 0.0D, 0.0D).a((double)var12, 0.0D).d();
            var15.b(0.0D, 0.0D, 0.0D).a(0.0D, 0.0D).d();
            var14.b();
            var9.d();
            bfl.F();
            bfl.n(5889);
            bfl.F();
            bfl.n(5888);
            this.c.a(var8);
            this.i.e();
            this.c.b(var8);
            this.l = var1;
         }

      }
   }

   public ErrorCode B() {
      return !r ? ErrorCode.TTV_EC_OS_TOO_OLD : this.c.A();
   }

   public boolean D() {
      boolean var1 = this.f.t.U == 1;
      return this.o || this.f.t.L <= 0.0F || var1 != this.p;
   }

   public void a(bqj.a var1) {
      b.debug(a, "Broadcast state changed to {}", new Object[]{var1});
      if (var1 == bqj.a.b) {
         this.c.a(bqj.a.d);
      }

   }

   public void a(String var1) {
      b.debug(a, "Chat connected");
   }

   static Logger G() {
      return b;
   }

   public void f() {
      b.debug(a, "Shutdown streaming");
      this.c.E();
      this.d.p();
   }

   public void b() {
      this.p();
      b.info(a, "Broadcast to Twitch has started");
   }

   public bqn(ave var1, Property var2) {
      this.q = bqm.a.a;
      this.f = var1;
      this.c = new bqj();
      this.d = new bqk();
      this.c.a((bqj.b)this);
      this.d.a((bqk.e)this);
      this.c.a("nmt37qblda36pvonovdkbopzfzw3wlq");
      this.d.a("nmt37qblda36pvonovdkbopzfzw3wlq");
      this.g.b().a(.a.f);
      if (var2 != null && !Strings.isNullOrEmpty(var2.getValue()) && bqs.l) {
         Thread var3 = new Thread(this, "Twitch authenticator", var2) {
            final Property a;
            final bqn b;

            public void run() {
               try {
                  URL var1 = new URL("https://api.twitch.tv/kraken?oauth_token=" + URLEncoder.encode(this.a.getValue(), "UTF-8"));
                  String var2 = nj.a(var1);
                  JsonObject var3 = ni.l((new JsonParser()).parse(var2), "Response");
                  JsonObject var4 = ni.s(var3, "token");
                  if (ni.i(var4, "valid")) {
                     String var5 = ni.h(var4, "user_name");
                     bqn.G().debug(bqn.a, "Authenticated with twitch; username is {}", new Object[]{var5});
                     AuthToken var6 = new AuthToken();
                     var6.data = this.a.getValue();
                     bqn.a(this.b).a(var5, var6);
                     bqn.b(this.b).c(var5);
                     bqn.b(this.b).a(var6);
                     Runtime.getRuntime().addShutdownHook(new Thread(this, "Twitch shutdown hook") {
                        final <undefinedtype> a;

                        {
                           this.a = var1;
                        }

                        public void run() {
                           this.a.b.f();
                        }
                     });
                     bqn.a(this.b).C();
                     bqn.b(this.b).n();
                  } else {
                     bqn.a(this.b, bqm.a.b);
                     bqn.G().error(bqn.a, "Given twitch access token is invalid");
                  }
               } catch (IOException var7) {
                  bqn.a(this.b, bqm.a.a);
                  bqn.G().error(bqn.a, "Could not authenticate with twitch", var7);
               }

            }

            {
               this.b = var1;
               this.a = var3;
            }
         };
         var3.setDaemon(true);
         var3.start();
      }

   }
}
