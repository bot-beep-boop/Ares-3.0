import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tv.twitch.chat.ChatUserInfo;
import tv.twitch.chat.ChatUserMode;
import tv.twitch.chat.ChatUserSubscription;

public class bab extends axu {
   private final eu i;
   private final bqm s;
   private static final a a;
   private final ChatUserInfo h;
   private static final a f;
   private final List<eu> r = Lists.newArrayList();
   private static final a g;
   private int t;

   public void b() {
      int var1 = this.l / 3;
      int var2 = var1 - 130;
      this.n.add(new avs(1, var1 * 0 + var2 / 2, this.m - 70, 130, 20, bnq.a("stream.userinfo.timeout")));
      this.n.add(new avs(0, var1 * 1 + var2 / 2, this.m - 70, 130, 20, bnq.a("stream.userinfo.ban")));
      this.n.add(new avs(2, var1 * 2 + var2 / 2, this.m - 70, 130, 20, bnq.a("stream.userinfo.mod")));
      this.n.add(new avs(5, var1 * 0 + var2 / 2, this.m - 45, 130, 20, bnq.a("gui.cancel")));
      this.n.add(new avs(3, var1 * 1 + var2 / 2, this.m - 45, 130, 20, bnq.a("stream.userinfo.unban")));
      this.n.add(new avs(4, var1 * 2 + var2 / 2, this.m - 45, 130, 20, bnq.a("stream.userinfo.unmod")));
      int var3 = 0;

      eu var5;
      for(Iterator var4 = this.r.iterator(); var4.hasNext(); var3 = Math.max(var3, this.q.a(var5.d()))) {
         var5 = (eu)var4.next();
      }

      this.t = this.l / 2 - var3 / 2;
   }

   public static List<eu> a(Set<ChatUserMode> var0, Set<ChatUserSubscription> var1, bqm var2) {
      String var3 = var2 == null ? null : var2.z();
      boolean var4 = var2 != null && var2.y();
      ArrayList var5 = Lists.newArrayList();
      Iterator var6 = var0.iterator();

      eu var8;
      fa var9;
      while(var6.hasNext()) {
         ChatUserMode var7 = (ChatUserMode)var6.next();
         var8 = a(var7, var3, var4);
         if (var8 != null) {
            var9 = new fa("- ");
            var9.a(var8);
            var5.add(var9);
         }
      }

      var6 = var1.iterator();

      while(var6.hasNext()) {
         ChatUserSubscription var10 = (ChatUserSubscription)var6.next();
         var8 = a(var10, var3, var4);
         if (var8 != null) {
            var9 = new fa("- ");
            var9.a(var8);
            var5.add(var9);
         }
      }

      return var5;
   }

   public bab(bqm var1, ChatUserInfo var2) {
      this.s = var1;
      this.h = var2;
      this.i = new fa(var2.displayName);
      this.r.addAll(a(var2.modes, var2.subscriptions, var1));
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.i.c(), this.l / 2, 70, 16777215);
      int var4 = 80;

      for(Iterator var5 = this.r.iterator(); var5.hasNext(); var4 += this.q.a) {
         eu var6 = (eu)var5.next();
         this.c(this.q, var6.d(), this.t, var4, 16777215);
      }

      super.a(var1, var2, var3);
   }

   static {
      a = a.c;
      f = a.m;
      g = a.f;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 0) {
            this.s.f("/ban " + this.h.displayName);
         } else if (var1.k == 3) {
            this.s.f("/unban " + this.h.displayName);
         } else if (var1.k == 2) {
            this.s.f("/mod " + this.h.displayName);
         } else if (var1.k == 4) {
            this.s.f("/unmod " + this.h.displayName);
         } else if (var1.k == 1) {
            this.s.f("/timeout " + this.h.displayName);
         }

         this.j.a((axu)null);
      }
   }

   public static eu a(ChatUserSubscription var0, String var1, boolean var2) {
      fb var3 = null;
      if (var0 == ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER) {
         if (var1 == null) {
            var3 = new fb("stream.user.subscription.subscriber", new Object[0]);
         } else if (var2) {
            var3 = new fb("stream.user.subscription.subscriber.self", new Object[0]);
         } else {
            var3 = new fb("stream.user.subscription.subscriber.other", new Object[]{var1});
         }

         var3.b().a(a);
      } else if (var0 == ChatUserSubscription.TTV_CHAT_USERSUB_TURBO) {
         var3 = new fb("stream.user.subscription.turbo", new Object[0]);
         var3.b().a(g);
      }

      return var3;
   }

   public static eu a(ChatUserMode var0, String var1, boolean var2) {
      fb var3 = null;
      if (var0 == ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR) {
         var3 = new fb("stream.user.mode.administrator", new Object[0]);
         var3.b().a(g);
      } else if (var0 == ChatUserMode.TTV_CHAT_USERMODE_BANNED) {
         if (var1 == null) {
            var3 = new fb("stream.user.mode.banned", new Object[0]);
         } else if (var2) {
            var3 = new fb("stream.user.mode.banned.self", new Object[0]);
         } else {
            var3 = new fb("stream.user.mode.banned.other", new Object[]{var1});
         }

         var3.b().a(f);
      } else if (var0 == ChatUserMode.TTV_CHAT_USERMODE_BROADCASTER) {
         if (var1 == null) {
            var3 = new fb("stream.user.mode.broadcaster", new Object[0]);
         } else if (var2) {
            var3 = new fb("stream.user.mode.broadcaster.self", new Object[0]);
         } else {
            var3 = new fb("stream.user.mode.broadcaster.other", new Object[0]);
         }

         var3.b().a(a);
      } else if (var0 == ChatUserMode.TTV_CHAT_USERMODE_MODERATOR) {
         if (var1 == null) {
            var3 = new fb("stream.user.mode.moderator", new Object[0]);
         } else if (var2) {
            var3 = new fb("stream.user.mode.moderator.self", new Object[0]);
         } else {
            var3 = new fb("stream.user.mode.moderator.other", new Object[]{var1});
         }

         var3.b().a(a);
      } else if (var0 == ChatUserMode.TTV_CHAT_USERMODE_STAFF) {
         var3 = new fb("stream.user.mode.staff", new Object[0]);
         var3.b().a(g);
      }

      return var3;
   }
}
