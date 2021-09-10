package net.minecraft.event;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.util.IChatComponent;

public class HoverEvent {
   private final IChatComponent value;
   private final HoverEvent.Action action;

   public IChatComponent getValue() {
      return this.value;
   }

   public String toString() {
      return "HoverEvent{action=" + this.action + ", value='" + this.value + '\'' + '}';
   }

   public HoverEvent.Action getAction() {
      return this.action;
   }

   public HoverEvent(HoverEvent.Action var1, IChatComponent var2) {
      this.action = var1;
      this.value = var2;
   }

   public int hashCode() {
      int var1 = this.action.hashCode();
      var1 = 31 * var1 + (this.value != null ? this.value.hashCode() : 0);
      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         HoverEvent var2 = (HoverEvent)var1;
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

   public static enum Action {
      SHOW_ENTITY("show_entity", true);

      private final boolean allowedInChat;
      private final String canonicalName;
      SHOW_TEXT("show_text", true);

      private static final HoverEvent.Action[] ENUM$VALUES = new HoverEvent.Action[]{SHOW_TEXT, SHOW_ACHIEVEMENT, SHOW_ITEM, SHOW_ENTITY};
      SHOW_ACHIEVEMENT("show_achievement", true);

      private static final Map<String, HoverEvent.Action> nameMapping = Maps.newHashMap();
      SHOW_ITEM("show_item", true);

      static {
         HoverEvent.Action[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            HoverEvent.Action var0 = var3[var1];
            nameMapping.put(var0.getCanonicalName(), var0);
         }

      }

      public boolean shouldAllowInChat() {
         return this.allowedInChat;
      }

      private Action(String var3, boolean var4) {
         this.canonicalName = var3;
         this.allowedInChat = var4;
      }

      public static HoverEvent.Action getValueByCanonicalName(String var0) {
         return (HoverEvent.Action)nameMapping.get(var0);
      }

      public String getCanonicalName() {
         return this.canonicalName;
      }
   }
}
