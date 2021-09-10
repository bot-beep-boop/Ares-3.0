package net.minecraft.scoreboard;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;

public abstract class Team {
   public abstract String formatString(String var1);

   public boolean isSameTeam(Team var1) {
      if (var1 == null) {
         return false;
      } else {
         return this == var1;
      }
   }

   public abstract boolean getSeeFriendlyInvisiblesEnabled();

   public abstract Collection<String> getMembershipCollection();

   public abstract Team.EnumVisible getNameTagVisibility();

   public abstract String getRegisteredName();

   public abstract boolean getAllowFriendlyFire();

   public abstract Team.EnumVisible getDeathMessageVisibility();

   public static enum EnumVisible {
      private static Map<String, Team.EnumVisible> field_178828_g = Maps.newHashMap();
      public final String internalName;
      private static final Team.EnumVisible[] ENUM$VALUES = new Team.EnumVisible[]{ALWAYS, NEVER, HIDE_FOR_OTHER_TEAMS, HIDE_FOR_OWN_TEAM};
      NEVER("never", 1),
      ALWAYS("always", 0),
      HIDE_FOR_OTHER_TEAMS("hideForOtherTeams", 2);

      public final int id;
      HIDE_FOR_OWN_TEAM("hideForOwnTeam", 3);

      private EnumVisible(String var3, int var4) {
         this.internalName = var3;
         this.id = var4;
      }

      static {
         Team.EnumVisible[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            Team.EnumVisible var0 = var3[var1];
            field_178828_g.put(var0.internalName, var0);
         }

      }

      public static Team.EnumVisible func_178824_a(String var0) {
         return (Team.EnumVisible)field_178828_g.get(var0);
      }

      public static String[] func_178825_a() {
         return (String[])field_178828_g.keySet().toArray(new String[field_178828_g.size()]);
      }
   }
}
