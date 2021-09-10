package net.minecraft.event;

import com.google.common.collect.Maps;
import java.util.Map;

public class ClickEvent {
   private final ClickEvent.Action action;
   private final String value;

   public int hashCode() {
      int var1 = this.action.hashCode();
      var1 = 31 * var1 + (this.value != null ? this.value.hashCode() : 0);
      return var1;
   }

   public ClickEvent(ClickEvent.Action var1, String var2) {
      this.action = var1;
      this.value = var2;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         ClickEvent var2 = (ClickEvent)var1;
         if (this.action != var2.action) {
            return false;
         } else {
            if (this.value != null) {
               if (!this.value.equals(var2.value)) {
                  return false;
               }
            } else if (var2.value != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public ClickEvent.Action getAction() {
      return this.action;
   }

   public String toString() {
      return "ClickEvent{action=" + this.action + ", value='" + this.value + '\'' + '}';
   }

   public String getValue() {
      return this.value;
   }

   public static enum Action {
      OPEN_URL("open_url", true);

      private final String canonicalName;
      CHANGE_PAGE("change_page", true);

      private static final ClickEvent.Action[] ENUM$VALUES = new ClickEvent.Action[]{OPEN_URL, OPEN_FILE, RUN_COMMAND, TWITCH_USER_INFO, SUGGEST_COMMAND, CHANGE_PAGE};
      TWITCH_USER_INFO("twitch_user_info", false);

      private static final Map<String, ClickEvent.Action> nameMapping = Maps.newHashMap();
      private final boolean allowedInChat;
      SUGGEST_COMMAND("suggest_command", true),
      OPEN_FILE("open_file", false),
      RUN_COMMAND("run_command", true);

      public static ClickEvent.Action getValueByCanonicalName(String var0) {
         return (ClickEvent.Action)nameMapping.get(var0);
      }

      public String getCanonicalName() {
         return this.canonicalName;
      }

      public boolean shouldAllowInChat() {
         return this.allowedInChat;
      }

      static {
         ClickEvent.Action[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            ClickEvent.Action var0 = var3[var1];
            nameMapping.put(var0.getCanonicalName(), var0);
         }

      }

      private Action(String var3, boolean var4) {
         this.canonicalName = var3;
         this.allowedInChat = var4;
      }
   }
}
