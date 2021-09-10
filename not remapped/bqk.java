import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tv.twitch.AuthToken;
import tv.twitch.Core;
import tv.twitch.ErrorCode;
import tv.twitch.StandardCoreAPI;
import tv.twitch.chat.Chat;
import tv.twitch.chat.ChatBadgeData;
import tv.twitch.chat.ChatChannelInfo;
import tv.twitch.chat.ChatEmoticonData;
import tv.twitch.chat.ChatEvent;
import tv.twitch.chat.ChatRawMessage;
import tv.twitch.chat.ChatTokenizationOption;
import tv.twitch.chat.ChatTokenizedMessage;
import tv.twitch.chat.ChatUserInfo;
import tv.twitch.chat.IChatAPIListener;
import tv.twitch.chat.IChatChannelListener;
import tv.twitch.chat.StandardChatAPI;

public class bqk {
   private static final Logger q = LogManager.getLogger();
   protected HashMap<String, bqk.b> i;
   protected String b = "";
   protected int j;
   protected ChatEmoticonData m;
   protected bqk.d k;
   protected int n;
   protected Core e = null;
   protected String d = "";
   protected int o;
   protected AuthToken h;
   protected String c = "";
   protected Chat f = null;
   protected IChatAPIListener p;
   protected bqk.e a = null;
   protected bqk.c g;
   protected bqk.d l;

   protected void r() {
      if (this.l != bqk.d.a) {
         if (this.m == null) {
            ErrorCode var1 = this.f.downloadEmoticonData();
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.n(String.format("Error trying to download emoticon data: %s", var2));
            }
         }

      }
   }

   public void c(String var1) {
      this.b = var1;
   }

   public void a(String var1) {
      this.c = var1;
   }

   public boolean d(String var1) {
      if (!this.i.containsKey(var1)) {
         return false;
      } else {
         bqk.b var2 = (bqk.b)this.i.get(var1);
         return var2.a() == bqk.a.c;
      }
   }

   public void p() {
      if (this.h() != bqk.c.a) {
         this.o();
         if (this.h() == bqk.c.d) {
            while(this.h() != bqk.c.a) {
               try {
                  Thread.sleep(200L);
                  this.q();
               } catch (InterruptedException var2) {
               }
            }
         }
      }

   }

   public boolean a(String var1, String var2) {
      if (this.g != bqk.c.c) {
         return false;
      } else if (!this.i.containsKey(var1)) {
         this.n("Not in channel: " + var1);
         return false;
      } else {
         bqk.b var3 = (bqk.b)this.i.get(var1);
         return var3.b(var2);
      }
   }

   public bqk.c h() {
      return this.g;
   }

   public bqk.a e(String var1) {
      if (!this.i.containsKey(var1)) {
         return bqk.a.e;
      } else {
         bqk.b var2 = (bqk.b)this.i.get(var1);
         return var2.a();
      }
   }

   public boolean n() {
      if (this.g != bqk.c.a) {
         return false;
      } else {
         this.a(bqk.c.b);
         ErrorCode var1 = this.e.initialize(this.c, (String)null);
         if (ErrorCode.failed(var1)) {
            this.a(bqk.c.a);
            String var4 = ErrorCode.getString(var1);
            this.n(String.format("Error initializing Twitch sdk: %s", var4));
            return false;
         } else {
            this.l = this.k;
            HashSet var2 = new HashSet();
            switch(this.k) {
            case a:
               var2.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_NONE);
               break;
            case b:
               var2.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_EMOTICON_URLS);
               break;
            case c:
               var2.add(ChatTokenizationOption.TTV_CHAT_TOKENIZATION_OPTION_EMOTICON_TEXTURES);
            }

            var1 = this.f.initialize(var2, this.p);
            if (ErrorCode.failed(var1)) {
               this.e.shutdown();
               this.a(bqk.c.a);
               String var3 = ErrorCode.getString(var1);
               this.n(String.format("Error initializing Twitch chat: %s", var3));
               return false;
            } else {
               this.a(bqk.c.c);
               return true;
            }
         }
      }
   }

   protected void n(String var1) {
      q.error(bqn.a, "[Chat controller] {}", new Object[]{var1});
   }

   public bqk() {
      this.g = bqk.c.a;
      this.h = new AuthToken();
      this.i = new HashMap();
      this.j = 128;
      this.k = bqk.d.a;
      this.l = bqk.d.a;
      this.m = null;
      this.n = 500;
      this.o = 2000;
      this.p = new IChatAPIListener(this) {
         final bqk a;

         public void chatInitializationCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               this.a.f.setMessageFlushInterval(this.a.n);
               this.a.f.setUserChangeEventInterval(this.a.o);
               this.a.r();
               this.a.a(bqk.c.c);
            } else {
               this.a.a(bqk.c.a);
            }

            try {
               if (this.a.a != null) {
                  this.a.a.d(var1);
               }
            } catch (Exception var3) {
               this.a.n(var3.toString());
            }

         }

         {
            this.a = var1;
         }

         public void chatEmoticonDataDownloadCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               this.a.s();
            }

         }

         public void chatShutdownCallback(ErrorCode var1) {
            if (ErrorCode.succeeded(var1)) {
               ErrorCode var2 = this.a.e.shutdown();
               if (ErrorCode.failed(var2)) {
                  String var3 = ErrorCode.getString(var2);
                  this.a.n(String.format("Error shutting down the Twitch sdk: %s", var3));
               }

               this.a.a(bqk.c.a);
            } else {
               this.a.a(bqk.c.c);
               this.a.n(String.format("Error shutting down Twith chat: %s", var1));
            }

            try {
               if (this.a.a != null) {
                  this.a.a.e(var1);
               }
            } catch (Exception var4) {
               this.a.n(var4.toString());
            }

         }
      };
      this.e = Core.getInstance();
      if (this.e == null) {
         this.e = new Core(new StandardCoreAPI());
      }

      this.f = new Chat(new StandardChatAPI());
   }

   public boolean o() {
      if (this.g != bqk.c.c) {
         return false;
      } else {
         ErrorCode var1 = this.f.shutdown();
         if (ErrorCode.failed(var1)) {
            String var2 = ErrorCode.getString(var1);
            this.n(String.format("Error shutting down chat: %s", var2));
            return false;
         } else {
            this.t();
            this.a(bqk.c.d);
            return true;
         }
      }
   }

   public void a(AuthToken var1) {
      this.h = var1;
   }

   public boolean j(String var1) {
      return this.a(var1, false);
   }

   public void a(bqk.e var1) {
      this.a = var1;
   }

   protected void a(bqk.c var1) {
      if (var1 != this.g) {
         this.g = var1;

         try {
            if (this.a != null) {
               this.a.a(var1);
            }
         } catch (Exception var3) {
            this.n(var3.toString());
         }

      }
   }

   protected boolean a(String var1, boolean var2) {
      if (this.g != bqk.c.c) {
         return false;
      } else if (this.i.containsKey(var1)) {
         this.n("Already in channel: " + var1);
         return false;
      } else if (var1 != null && !var1.equals("")) {
         bqk.b var3 = new bqk.b(this, var1);
         this.i.put(var1, var3);
         boolean var4 = var3.a(var2);
         if (!var4) {
            this.i.remove(var1);
         }

         return var4;
      } else {
         return false;
      }
   }

   public boolean l(String var1) {
      if (this.g != bqk.c.c) {
         return false;
      } else if (!this.i.containsKey(var1)) {
         this.n("Not in channel: " + var1);
         return false;
      } else {
         bqk.b var2 = (bqk.b)this.i.get(var1);
         return var2.g();
      }
   }

   protected void s() {
      if (this.m == null) {
         this.m = new ChatEmoticonData();
         ErrorCode var1 = this.f.getEmoticonData(this.m);
         if (ErrorCode.succeeded(var1)) {
            try {
               if (this.a != null) {
                  this.a.d();
               }
            } catch (Exception var3) {
               this.n(var3.toString());
            }
         } else {
            this.n("Error preparing emoticon data: " + ErrorCode.getString(var1));
         }

      }
   }

   protected void t() {
      if (this.m != null) {
         ErrorCode var1 = this.f.clearEmoticonData();
         if (ErrorCode.succeeded(var1)) {
            this.m = null;

            try {
               if (this.a != null) {
                  this.a.e();
               }
            } catch (Exception var3) {
               this.n(var3.toString());
            }
         } else {
            this.n("Error clearing emoticon data: " + ErrorCode.getString(var1));
         }

      }
   }

   public void q() {
      if (this.g != bqk.c.a) {
         ErrorCode var1 = this.f.flushEvents();
         if (ErrorCode.failed(var1)) {
            String var2 = ErrorCode.getString(var1);
            this.n(String.format("Error flushing chat events: %s", var2));
         }

      }
   }

   public class b implements IChatChannelListener {
      protected bqk.a c;
      protected String a;
      protected LinkedList<ChatTokenizedMessage> f;
      protected boolean b;
      protected LinkedList<ChatRawMessage> e;
      final bqk h;
      protected ChatBadgeData g;
      protected List<ChatUserInfo> d;

      public void chatChannelTokenizedMessageCallback(String var1, ChatTokenizedMessage[] var2) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.f.addLast(var2[var3]);
         }

         try {
            if (this.h.a != null) {
               this.h.a.a(this.a, var2);
            }
         } catch (Exception var4) {
            this.h.n(var4.toString());
         }

         while(this.f.size() > this.h.j) {
            this.f.removeFirst();
         }

      }

      public void chatStatusCallback(String var1, ErrorCode var2) {
         if (!ErrorCode.succeeded(var2)) {
            this.h.i.remove(var1);
            this.k();
         }
      }

      public boolean b(String var1) {
         if (this.c != bqk.a.c) {
            return false;
         } else {
            ErrorCode var2 = this.h.f.sendMessage(this.a, var1);
            if (ErrorCode.failed(var2)) {
               String var3 = ErrorCode.getString(var2);
               this.h.n(String.format("Error sending chat message: %s", var3));
               return false;
            } else {
               return true;
            }
         }
      }

      protected void i() {
         if (this.g == null) {
            this.g = new ChatBadgeData();
            ErrorCode var1 = this.h.f.getBadgeData(this.a, this.g);
            if (ErrorCode.succeeded(var1)) {
               try {
                  if (this.h.a != null) {
                     this.h.a.c(this.a);
                  }
               } catch (Exception var3) {
                  this.h.n(var3.toString());
               }
            } else {
               this.h.n("Error preparing badge data: " + ErrorCode.getString(var1));
            }

         }
      }

      public b(bqk var1, String var2) {
         this.h = var1;
         this.a = null;
         this.b = false;
         this.c = bqk.a.a;
         this.d = Lists.newArrayList();
         this.e = new LinkedList();
         this.f = new LinkedList();
         this.g = null;
         this.a = var2;
      }

      public boolean g() {
         switch(this.c) {
         case c:
         case b:
            ErrorCode var1 = this.h.f.disconnect(this.a);
            if (ErrorCode.failed(var1)) {
               String var2 = ErrorCode.getString(var1);
               this.h.n(String.format("Error disconnecting: %s", var2));
               return false;
            }

            this.a(bqk.a.d);
            return true;
         case a:
         case e:
         case d:
         default:
            return false;
         }
      }

      public void chatBadgeDataDownloadCallback(String var1, ErrorCode var2) {
         if (ErrorCode.succeeded(var2)) {
            this.i();
         }

      }

      public void a(String var1) {
         if (this.h.l == bqk.d.a) {
            this.e.clear();
            this.f.clear();
         } else {
            ListIterator var2;
            if (this.e.size() > 0) {
               var2 = this.e.listIterator();

               while(var2.hasNext()) {
                  ChatRawMessage var3 = (ChatRawMessage)var2.next();
                  if (var3.userName.equals(var1)) {
                     var2.remove();
                  }
               }
            }

            if (this.f.size() > 0) {
               var2 = this.f.listIterator();

               while(var2.hasNext()) {
                  ChatTokenizedMessage var5 = (ChatTokenizedMessage)var2.next();
                  if (var5.displayName.equals(var1)) {
                     var2.remove();
                  }
               }
            }
         }

         try {
            if (this.h.a != null) {
               this.h.a.a(this.a, var1);
            }
         } catch (Exception var4) {
            this.h.n(var4.toString());
         }

      }

      protected void d(String var1) {
         try {
            if (this.h.a != null) {
               this.h.a.b(var1);
            }
         } catch (Exception var3) {
            this.h.n(var3.toString());
         }

      }

      protected void j() {
         if (this.g != null) {
            ErrorCode var1 = this.h.f.clearBadgeData(this.a);
            if (ErrorCode.succeeded(var1)) {
               this.g = null;

               try {
                  if (this.h.a != null) {
                     this.h.a.d(this.a);
                  }
               } catch (Exception var3) {
                  this.h.n(var3.toString());
               }
            } else {
               this.h.n("Error releasing badge data: " + ErrorCode.getString(var1));
            }

         }
      }

      protected void a(bqk.a var1) {
         if (var1 != this.c) {
            this.c = var1;
         }
      }

      public bqk.a a() {
         return this.c;
      }

      protected void h() {
         if (this.h.l != bqk.d.a) {
            if (this.g == null) {
               ErrorCode var1 = this.h.f.downloadBadgeData(this.a);
               if (ErrorCode.failed(var1)) {
                  String var2 = ErrorCode.getString(var1);
                  this.h.n(String.format("Error trying to download badge data: %s", var2));
               }
            }

         }
      }

      public void chatChannelRawMessageCallback(String var1, ChatRawMessage[] var2) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.e.addLast(var2[var3]);
         }

         try {
            if (this.h.a != null) {
               this.h.a.a(this.a, var2);
            }
         } catch (Exception var4) {
            this.h.n(var4.toString());
         }

         while(this.e.size() > this.h.j) {
            this.e.removeFirst();
         }

      }

      public void chatClearCallback(String var1, String var2) {
         this.a(var2);
      }

      private void k() {
         if (this.c != bqk.a.e) {
            this.a(bqk.a.e);
            this.d(this.a);
            this.j();
         }

      }

      protected void c(String var1) {
         try {
            if (this.h.a != null) {
               this.h.a.a(var1);
            }
         } catch (Exception var3) {
            this.h.n(var3.toString());
         }

      }

      public void chatChannelMembershipCallback(String var1, ChatEvent var2, ChatChannelInfo var3) {
         switch(var2) {
         case TTV_CHAT_JOINED_CHANNEL:
            this.a(bqk.a.c);
            this.c(var1);
            break;
         case TTV_CHAT_LEFT_CHANNEL:
            this.k();
         }

      }

      public void chatChannelUserChangeCallback(String var1, ChatUserInfo[] var2, ChatUserInfo[] var3, ChatUserInfo[] var4) {
         int var5;
         int var6;
         for(var5 = 0; var5 < var3.length; ++var5) {
            var6 = this.d.indexOf(var3[var5]);
            if (var6 >= 0) {
               this.d.remove(var6);
            }
         }

         for(var5 = 0; var5 < var4.length; ++var5) {
            var6 = this.d.indexOf(var4[var5]);
            if (var6 >= 0) {
               this.d.remove(var6);
            }

            this.d.add(var4[var5]);
         }

         for(var5 = 0; var5 < var2.length; ++var5) {
            this.d.add(var2[var5]);
         }

         try {
            if (this.h.a != null) {
               this.h.a.a(this.a, var2, var3, var4);
            }
         } catch (Exception var7) {
            this.h.n(var7.toString());
         }

      }

      public boolean a(boolean var1) {
         this.b = var1;
         ErrorCode var2 = ErrorCode.TTV_EC_SUCCESS;
         if (var1) {
            var2 = this.h.f.connectAnonymous(this.a, this);
         } else {
            var2 = this.h.f.connect(this.a, this.h.b, this.h.h.data, this);
         }

         if (ErrorCode.failed(var2)) {
            String var3 = ErrorCode.getString(var2);
            this.h.n(String.format("Error connecting: %s", var3));
            this.d(this.a);
            return false;
         } else {
            this.a(bqk.a.b);
            this.h();
            return true;
         }
      }
   }

   public static enum c {
      private static final bqk.c[] e = new bqk.c[]{a, b, c, d};
      c,
      d,
      a,
      b;
   }

   public interface e {
      void e(ErrorCode var1);

      void d(String var1);

      void a(bqk.c var1);

      void b(String var1);

      void a(String var1, ChatTokenizedMessage[] var2);

      void a(String var1, ChatRawMessage[] var2);

      void d(ErrorCode var1);

      void a(String var1, ChatUserInfo[] var2, ChatUserInfo[] var3, ChatUserInfo[] var4);

      void d();

      void e();

      void c(String var1);

      void a(String var1, String var2);

      void a(String var1);
   }

   public static enum d {
      b;

      private static final bqk.d[] d = new bqk.d[]{a, b, c};
      a,
      c;
   }

   public static enum a {
      c;

      private static final bqk.a[] f = new bqk.a[]{a, b, c, d, e};
      e,
      a,
      b,
      d;
   }
}
