package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandHandler implements ICommandManager {
   private final Set<ICommand> commandSet = Sets.newHashSet();
   private static final Logger logger = LogManager.getLogger();
   private final Map<String, ICommand> commandMap = Maps.newHashMap();

   public ICommand registerCommand(ICommand var1) {
      this.commandMap.put(var1.getCommandName(), var1);
      this.commandSet.add(var1);
      Iterator var3 = var1.getCommandAliases().iterator();

      while(true) {
         String var2;
         ICommand var4;
         do {
            if (!var3.hasNext()) {
               return var1;
            }

            var2 = (String)var3.next();
            var4 = (ICommand)this.commandMap.get(var2);
         } while(var4 != null && var4.getCommandName().equals(var2));

         this.commandMap.put(var2, var1);
      }
   }

   protected boolean tryExecute(ICommandSender var1, String[] var2, ICommand var3, String var4) {
      ChatComponentTranslation var6;
      try {
         var3.processCommand(var1, var2);
         return true;
      } catch (WrongUsageException var7) {
         var6 = new ChatComponentTranslation("commands.generic.usage", new Object[]{new ChatComponentTranslation(var7.getMessage(), var7.getErrorObjects())});
         var6.getChatStyle().setColor(EnumChatFormatting.RED);
         var1.addChatMessage(var6);
      } catch (CommandException var8) {
         var6 = new ChatComponentTranslation(var8.getMessage(), var8.getErrorObjects());
         var6.getChatStyle().setColor(EnumChatFormatting.RED);
         var1.addChatMessage(var6);
      } catch (Throwable var9) {
         var6 = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
         var6.getChatStyle().setColor(EnumChatFormatting.RED);
         var1.addChatMessage(var6);
         logger.warn("Couldn't process command: '" + var4 + "'");
      }

      return false;
   }

   private static String[] dropFirstString(String[] var0) {
      String[] var1 = new String[var0.length - 1];
      System.arraycopy(var0, 1, var1, 0, var0.length - 1);
      return var1;
   }

   public Map<String, ICommand> getCommands() {
      return this.commandMap;
   }

   public List<String> getTabCompletionOptions(ICommandSender var1, String var2, BlockPos var3) {
      String[] var4 = var2.split(" ", -1);
      String var5 = var4[0];
      if (var4.length == 1) {
         ArrayList var9 = Lists.newArrayList();
         Iterator var8 = this.commandMap.entrySet().iterator();

         while(var8.hasNext()) {
            Entry var7 = (Entry)var8.next();
            if (CommandBase.doesStringStartWith(var5, (String)var7.getKey()) && ((ICommand)var7.getValue()).canCommandSenderUseCommand(var1)) {
               var9.add((String)var7.getKey());
            }
         }

         return var9;
      } else {
         if (var4.length > 1) {
            ICommand var6 = (ICommand)this.commandMap.get(var5);
            if (var6 != null && var6.canCommandSenderUseCommand(var1)) {
               return var6.addTabCompletionOptions(var1, dropFirstString(var4), var3);
            }
         }

         return null;
      }
   }

   public int executeCommand(ICommandSender var1, String var2) {
      var2 = var2.trim();
      if (var2.startsWith("/")) {
         var2 = var2.substring(1);
      }

      String[] var3 = var2.split(" ");
      String var4 = var3[0];
      var3 = dropFirstString(var3);
      ICommand var5 = (ICommand)this.commandMap.get(var4);
      int var6 = this.getUsernameIndex(var5, var3);
      int var7 = 0;
      ChatComponentTranslation var8;
      if (var5 == null) {
         var8 = new ChatComponentTranslation("commands.generic.notFound", new Object[0]);
         var8.getChatStyle().setColor(EnumChatFormatting.RED);
         var1.addChatMessage(var8);
      } else if (var5.canCommandSenderUseCommand(var1)) {
         if (var6 > -1) {
            List var12 = PlayerSelector.matchEntities(var1, var3[var6], Entity.class);
            String var9 = var3[var6];
            var1.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, var12.size());
            Iterator var11 = var12.iterator();

            while(var11.hasNext()) {
               Entity var10 = (Entity)var11.next();
               var3[var6] = var10.getUniqueID().toString();
               if (this.tryExecute(var1, var3, var5, var2)) {
                  ++var7;
               }
            }

            var3[var6] = var9;
         } else {
            var1.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, 1);
            if (this.tryExecute(var1, var3, var5, var2)) {
               ++var7;
            }
         }
      } else {
         var8 = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
         var8.getChatStyle().setColor(EnumChatFormatting.RED);
         var1.addChatMessage(var8);
      }

      var1.setCommandStat(CommandResultStats.Type.SUCCESS_COUNT, var7);
      return var7;
   }

   public List<ICommand> getPossibleCommands(ICommandSender var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var4 = this.commandSet.iterator();

      while(var4.hasNext()) {
         ICommand var3 = (ICommand)var4.next();
         if (var3.canCommandSenderUseCommand(var1)) {
            var2.add(var3);
         }
      }

      return var2;
   }

   private int getUsernameIndex(ICommand var1, String[] var2) {
      if (var1 == null) {
         return -1;
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var1.isUsernameIndex(var2, var3) && PlayerSelector.matchesMultiplePlayers(var2[var3])) {
               return var3;
            }
         }

         return -1;
      }
   }
}
