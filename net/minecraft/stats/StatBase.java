package net.minecraft.stats;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.event.HoverEvent;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IJsonSerializable;

public class StatBase {
   private static NumberFormat numberFormat;
   public static IStatType simpleStatType;
   private final IStatType type;
   private Class<? extends IJsonSerializable> field_150956_d;
   private final IScoreObjectiveCriteria objectiveCriteria;
   public static IStatType field_111202_k;
   public static IStatType timeStatType;
   private static DecimalFormat decimalFormat;
   public final String statId;
   private final IChatComponent statName;
   public boolean isIndependent;
   public static IStatType distanceStatType;

   public StatBase func_150953_b(Class<? extends IJsonSerializable> var1) {
      this.field_150956_d = var1;
      return this;
   }

   static {
      numberFormat = NumberFormat.getIntegerInstance(Locale.US);
      simpleStatType = new IStatType() {
         public String format(int var1) {
            return StatBase.access$0().format((long)var1);
         }
      };
      decimalFormat = new DecimalFormat("########0.00");
      timeStatType = new IStatType() {
         public String format(int var1) {
            double var2 = (double)var1 / 20.0D;
            double var4 = var2 / 60.0D;
            double var6 = var4 / 60.0D;
            double var8 = var6 / 24.0D;
            double var10 = var8 / 365.0D;
            if (var10 > 0.5D) {
               return StatBase.access$1().format(var10) + " y";
            } else if (var8 > 0.5D) {
               return StatBase.access$1().format(var8) + " d";
            } else if (var6 > 0.5D) {
               return StatBase.access$1().format(var6) + " h";
            } else {
               return var4 > 0.5D ? StatBase.access$1().format(var4) + " m" : var2 + " s";
            }
         }
      };
      distanceStatType = new IStatType() {
         public String format(int var1) {
            double var2 = (double)var1 / 100.0D;
            double var4 = var2 / 1000.0D;
            if (var4 > 0.5D) {
               return StatBase.access$1().format(var4) + " km";
            } else {
               return var2 > 0.5D ? StatBase.access$1().format(var2) + " m" : var1 + " cm";
            }
         }
      };
      field_111202_k = new IStatType() {
         public String format(int var1) {
            return StatBase.access$1().format((double)var1 * 0.1D);
         }
      };
   }

   static DecimalFormat access$1() {
      return decimalFormat;
   }

   public boolean isAchievement() {
      return false;
   }

   public StatBase initIndependentStat() {
      this.isIndependent = true;
      return this;
   }

   public StatBase(String var1, IChatComponent var2, IStatType var3) {
      this.statId = var1;
      this.statName = var2;
      this.type = var3;
      this.objectiveCriteria = new ObjectiveStat(this);
      IScoreObjectiveCriteria.INSTANCES.put(this.objectiveCriteria.getName(), this.objectiveCriteria);
   }

   public String toString() {
      return "Stat{id=" + this.statId + ", nameId=" + this.statName + ", awardLocallyOnly=" + this.isIndependent + ", formatter=" + this.type + ", objectiveCriteria=" + this.objectiveCriteria + '}';
   }

   public int hashCode() {
      return this.statId.hashCode();
   }

   public Class<? extends IJsonSerializable> func_150954_l() {
      return this.field_150956_d;
   }

   public IChatComponent getStatName() {
      IChatComponent var1 = this.statName.createCopy();
      var1.getChatStyle().setColor(EnumChatFormatting.GRAY);
      var1.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ACHIEVEMENT, new ChatComponentText(this.statId)));
      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         StatBase var2 = (StatBase)var1;
         return this.statId.equals(var2.statId);
      } else {
         return false;
      }
   }

   public IScoreObjectiveCriteria getCriteria() {
      return this.objectiveCriteria;
   }

   static NumberFormat access$0() {
      return numberFormat;
   }

   public StatBase registerStat() {
      if (StatList.oneShotStats.containsKey(this.statId)) {
         throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.oneShotStats.get(this.statId)).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
      } else {
         StatList.allStats.add(this);
         StatList.oneShotStats.put(this.statId, this);
         return this;
      }
   }

   public String format(int var1) {
      return this.type.format(var1);
   }

   public StatBase(String var1, IChatComponent var2) {
      this(var1, var2, simpleStatType);
   }

   public IChatComponent createChatComponent() {
      IChatComponent var1 = this.getStatName();
      IChatComponent var2 = (new ChatComponentText("[")).appendSibling(var1).appendText("]");
      var2.setChatStyle(var1.getChatStyle());
      return var2;
   }
}
