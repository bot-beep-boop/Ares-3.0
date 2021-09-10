package net.minecraft.command.server;

import io.netty.buffer.ByteBuf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;

public abstract class CommandBlockLogic implements ICommandSender {
   private String commandStored = "";
   private static final SimpleDateFormat timestampFormat = new SimpleDateFormat("HH:mm:ss");
   private boolean trackOutput = true;
   private String customName = "@";
   private int successCount;
   private IChatComponent lastOutput = null;
   private final CommandResultStats resultStats = new CommandResultStats();

   public void setCommand(String var1) {
      this.commandStored = var1;
      this.successCount = 0;
   }

   public void writeDataToNBT(NBTTagCompound var1) {
      var1.setString("Command", this.commandStored);
      var1.setInteger("SuccessCount", this.successCount);
      var1.setString("CustomName", this.customName);
      var1.setBoolean("TrackOutput", this.trackOutput);
      if (this.lastOutput != null && this.trackOutput) {
         var1.setString("LastOutput", IChatComponent.Serializer.componentToJson(this.lastOutput));
      }

      this.resultStats.writeStatsToNBT(var1);
   }

   public CommandResultStats getCommandResultStats() {
      return this.resultStats;
   }

   public boolean shouldTrackOutput() {
      return this.trackOutput;
   }

   public abstract void updateCommand();

   public boolean sendCommandFeedback() {
      MinecraftServer var1 = MinecraftServer.getServer();
      return var1 == null || !var1.isAnvilFileSet() || var1.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
   }

   public void setName(String var1) {
      this.customName = var1;
   }

   public abstract void func_145757_a(ByteBuf var1);

   public void addChatMessage(IChatComponent var1) {
      if (this.trackOutput && this.getEntityWorld() != null && !this.getEntityWorld().isRemote) {
         this.lastOutput = (new ChatComponentText("[" + timestampFormat.format(new Date()) + "] ")).appendSibling(var1);
         this.updateCommand();
      }

   }

   public IChatComponent getLastOutput() {
      return this.lastOutput;
   }

   public abstract int func_145751_f();

   public String getCommand() {
      return this.commandStored;
   }

   public void setCommandStat(CommandResultStats.Type var1, int var2) {
      this.resultStats.setCommandStatScore(this, var1, var2);
   }

   public int getSuccessCount() {
      return this.successCount;
   }

   public void setTrackOutput(boolean var1) {
      this.trackOutput = var1;
   }

   public boolean canCommandSenderUseCommand(int var1, String var2) {
      return var1 <= 2;
   }

   public void readDataFromNBT(NBTTagCompound var1) {
      this.commandStored = var1.getString("Command");
      this.successCount = var1.getInteger("SuccessCount");
      if (var1.hasKey("CustomName", 8)) {
         this.customName = var1.getString("CustomName");
      }

      if (var1.hasKey("TrackOutput", 1)) {
         this.trackOutput = var1.getBoolean("TrackOutput");
      }

      if (var1.hasKey("LastOutput", 8) && this.trackOutput) {
         this.lastOutput = IChatComponent.Serializer.jsonToComponent(var1.getString("LastOutput"));
      }

      this.resultStats.readStatsFromNBT(var1);
   }

   public IChatComponent getDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public String getName() {
      return this.customName;
   }

   public void trigger(World var1) {
      if (var1.isRemote) {
         this.successCount = 0;
      }

      MinecraftServer var2 = MinecraftServer.getServer();
      if (var2 != null && var2.isAnvilFileSet() && var2.isCommandBlockEnabled()) {
         ICommandManager var3 = var2.getCommandManager();

         try {
            this.lastOutput = null;
            this.successCount = var3.executeCommand(this, this.commandStored);
         } catch (Throwable var7) {
            CrashReport var5 = CrashReport.makeCrashReport(var7, "Executing command block");
            CrashReportCategory var6 = var5.makeCategory("Command to be executed");
            var6.addCrashSectionCallable("Command", new Callable<String>(this) {
               final CommandBlockLogic this$0;

               {
                  this.this$0 = var1;
               }

               public String call() throws Exception {
                  return this.this$0.getCommand();
               }

               public Object call() throws Exception {
                  return this.call();
               }
            });
            var6.addCrashSectionCallable("Name", new Callable<String>(this) {
               final CommandBlockLogic this$0;

               public String call() throws Exception {
                  return this.this$0.getName();
               }

               {
                  this.this$0 = var1;
               }

               public Object call() throws Exception {
                  return this.call();
               }
            });
            throw new ReportedException(var5);
         }
      } else {
         this.successCount = 0;
      }

   }

   public void setLastOutput(IChatComponent var1) {
      this.lastOutput = var1;
   }

   public boolean tryOpenEditCommandBlock(EntityPlayer var1) {
      if (!var1.capabilities.isCreativeMode) {
         return false;
      } else {
         if (var1.getEntityWorld().isRemote) {
            var1.openEditCommandBlock(this);
         }

         return true;
      }
   }
}
