package net.minecraft.command;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CommandResultStats {
   private static final int NUM_RESULT_TYPES = CommandResultStats.Type.values().length;
   private String[] objectives;
   private String[] entitiesID;
   private static final String[] STRING_RESULT_TYPES;

   public static void setScoreBoardStat(CommandResultStats var0, CommandResultStats.Type var1, String var2, String var3) {
      if (var2 != null && var2.length() != 0 && var3 != null && var3.length() != 0) {
         if (var0.entitiesID == STRING_RESULT_TYPES || var0.objectives == STRING_RESULT_TYPES) {
            var0.entitiesID = new String[NUM_RESULT_TYPES];
            var0.objectives = new String[NUM_RESULT_TYPES];
         }

         var0.entitiesID[var1.getTypeID()] = var2;
         var0.objectives[var1.getTypeID()] = var3;
      } else {
         removeScoreBoardStat(var0, var1);
      }

   }

   public void setCommandStatScore(ICommandSender var1, CommandResultStats.Type var2, int var3) {
      String var4 = this.entitiesID[var2.getTypeID()];
      if (var4 != null) {
         ICommandSender var5 = new ICommandSender(this, var1) {
            final CommandResultStats this$0;
            private final ICommandSender val$sender;

            {
               this.this$0 = var1;
               this.val$sender = var2;
            }

            public String getName() {
               return this.val$sender.getName();
            }

            public boolean sendCommandFeedback() {
               return this.val$sender.sendCommandFeedback();
            }

            public World getEntityWorld() {
               return this.val$sender.getEntityWorld();
            }

            public void setCommandStat(CommandResultStats.Type var1, int var2) {
               this.val$sender.setCommandStat(var1, var2);
            }

            public Entity getCommandSenderEntity() {
               return this.val$sender.getCommandSenderEntity();
            }

            public BlockPos getPosition() {
               return this.val$sender.getPosition();
            }

            public void addChatMessage(IChatComponent var1) {
               this.val$sender.addChatMessage(var1);
            }

            public boolean canCommandSenderUseCommand(int var1, String var2) {
               return true;
            }

            public Vec3 getPositionVector() {
               return this.val$sender.getPositionVector();
            }

            public IChatComponent getDisplayName() {
               return this.val$sender.getDisplayName();
            }
         };

         String var6;
         try {
            var6 = CommandBase.getEntityName(var5, var4);
         } catch (EntityNotFoundException var11) {
            return;
         }

         String var7 = this.objectives[var2.getTypeID()];
         if (var7 != null) {
            Scoreboard var8 = var1.getEntityWorld().getScoreboard();
            ScoreObjective var9 = var8.getObjective(var7);
            if (var9 != null && var8.entityHasObjective(var6, var9)) {
               Score var10 = var8.getValueFromObjective(var6, var9);
               var10.setScorePoints(var3);
            }
         }
      }

   }

   private static void removeScoreBoardStat(CommandResultStats var0, CommandResultStats.Type var1) {
      if (var0.entitiesID != STRING_RESULT_TYPES && var0.objectives != STRING_RESULT_TYPES) {
         var0.entitiesID[var1.getTypeID()] = null;
         var0.objectives[var1.getTypeID()] = null;
         boolean var2 = true;
         CommandResultStats.Type[] var6;
         int var5 = (var6 = CommandResultStats.Type.values()).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            CommandResultStats.Type var3 = var6[var4];
            if (var0.entitiesID[var3.getTypeID()] != null && var0.objectives[var3.getTypeID()] != null) {
               var2 = false;
               break;
            }
         }

         if (var2) {
            var0.entitiesID = STRING_RESULT_TYPES;
            var0.objectives = STRING_RESULT_TYPES;
         }
      }

   }

   public void addAllStats(CommandResultStats var1) {
      CommandResultStats.Type[] var5;
      int var4 = (var5 = CommandResultStats.Type.values()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         CommandResultStats.Type var2 = var5[var3];
         setScoreBoardStat(this, var2, var1.entitiesID[var2.getTypeID()], var1.objectives[var2.getTypeID()]);
      }

   }

   public CommandResultStats() {
      this.entitiesID = STRING_RESULT_TYPES;
      this.objectives = STRING_RESULT_TYPES;
   }

   public void readStatsFromNBT(NBTTagCompound var1) {
      if (var1.hasKey("CommandStats", 10)) {
         NBTTagCompound var2 = var1.getCompoundTag("CommandStats");
         CommandResultStats.Type[] var6;
         int var5 = (var6 = CommandResultStats.Type.values()).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            CommandResultStats.Type var3 = var6[var4];
            String var7 = var3.getTypeName() + "Name";
            String var8 = var3.getTypeName() + "Objective";
            if (var2.hasKey(var7, 8) && var2.hasKey(var8, 8)) {
               String var9 = var2.getString(var7);
               String var10 = var2.getString(var8);
               setScoreBoardStat(this, var3, var9, var10);
            }
         }
      }

   }

   public void writeStatsToNBT(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      CommandResultStats.Type[] var6;
      int var5 = (var6 = CommandResultStats.Type.values()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         CommandResultStats.Type var3 = var6[var4];
         String var7 = this.entitiesID[var3.getTypeID()];
         String var8 = this.objectives[var3.getTypeID()];
         if (var7 != null && var8 != null) {
            var2.setString(var3.getTypeName() + "Name", var7);
            var2.setString(var3.getTypeName() + "Objective", var8);
         }
      }

      if (!var2.hasNoTags()) {
         var1.setTag("CommandStats", var2);
      }

   }

   static {
      STRING_RESULT_TYPES = new String[NUM_RESULT_TYPES];
   }

   public static enum Type {
      AFFECTED_BLOCKS(1, "AffectedBlocks"),
      QUERY_RESULT(4, "QueryResult");

      final String typeName;
      final int typeID;
      AFFECTED_ITEMS(3, "AffectedItems"),
      SUCCESS_COUNT(0, "SuccessCount");

      private static final CommandResultStats.Type[] ENUM$VALUES = new CommandResultStats.Type[]{SUCCESS_COUNT, AFFECTED_BLOCKS, AFFECTED_ENTITIES, AFFECTED_ITEMS, QUERY_RESULT};
      AFFECTED_ENTITIES(2, "AffectedEntities");

      public String getTypeName() {
         return this.typeName;
      }

      public static String[] getTypeNames() {
         String[] var0 = new String[values().length];
         int var1 = 0;
         CommandResultStats.Type[] var5;
         int var4 = (var5 = values()).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            CommandResultStats.Type var2 = var5[var3];
            var0[var1++] = var2.getTypeName();
         }

         return var0;
      }

      public int getTypeID() {
         return this.typeID;
      }

      private Type(int var3, String var4) {
         this.typeID = var3;
         this.typeName = var4;
      }

      public static CommandResultStats.Type getTypeByName(String var0) {
         CommandResultStats.Type[] var4;
         int var3 = (var4 = values()).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            CommandResultStats.Type var1 = var4[var2];
            if (var1.getTypeName().equals(var0)) {
               return var1;
            }
         }

         return null;
      }
   }
}
