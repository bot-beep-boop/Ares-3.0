package net.minecraft.command.server;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

public class CommandWhitelist extends CommandBase {
   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length < 1) {
         throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
      } else {
         MinecraftServer var3 = MinecraftServer.getServer();
         if (var2[0].equals("on")) {
            var3.getConfigurationManager().setWhiteListEnabled(true);
            notifyOperators(var1, this, "commands.whitelist.enabled", new Object[0]);
         } else if (var2[0].equals("off")) {
            var3.getConfigurationManager().setWhiteListEnabled(false);
            notifyOperators(var1, this, "commands.whitelist.disabled", new Object[0]);
         } else if (var2[0].equals("list")) {
            var1.addChatMessage(new ChatComponentTranslation("commands.whitelist.list", new Object[]{var3.getConfigurationManager().getWhitelistedPlayerNames().length, var3.getConfigurationManager().getAvailablePlayerDat().length}));
            String[] var4 = var3.getConfigurationManager().getWhitelistedPlayerNames();
            var1.addChatMessage(new ChatComponentText(joinNiceString(var4)));
         } else {
            GameProfile var5;
            if (var2[0].equals("add")) {
               if (var2.length < 2) {
                  throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
               }

               var5 = var3.getPlayerProfileCache().getGameProfileForUsername(var2[1]);
               if (var5 == null) {
                  throw new CommandException("commands.whitelist.add.failed", new Object[]{var2[1]});
               }

               var3.getConfigurationManager().addWhitelistedPlayer(var5);
               notifyOperators(var1, this, "commands.whitelist.add.success", new Object[]{var2[1]});
            } else if (var2[0].equals("remove")) {
               if (var2.length < 2) {
                  throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
               }

               var5 = var3.getConfigurationManager().getWhitelistedPlayers().getBannedProfile(var2[1]);
               if (var5 == null) {
                  throw new CommandException("commands.whitelist.remove.failed", new Object[]{var2[1]});
               }

               var3.getConfigurationManager().removePlayerFromWhitelist(var5);
               notifyOperators(var1, this, "commands.whitelist.remove.success", new Object[]{var2[1]});
            } else if (var2[0].equals("reload")) {
               var3.getConfigurationManager().loadWhiteList();
               notifyOperators(var1, this, "commands.whitelist.reloaded", new Object[0]);
            }
         }

      }
   }

   public int getRequiredPermissionLevel() {
      return 3;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.whitelist.usage";
   }

   public String getCommandName() {
      return "whitelist";
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length == 1) {
         return getListOfStringsMatchingLastWord(var2, new String[]{"on", "off", "list", "add", "remove", "reload"});
      } else {
         if (var2.length == 2) {
            if (var2[0].equals("remove")) {
               return getListOfStringsMatchingLastWord(var2, MinecraftServer.getServer().getConfigurationManager().getWhitelistedPlayerNames());
            }

            if (var2[0].equals("add")) {
               return getListOfStringsMatchingLastWord(var2, MinecraftServer.getServer().getPlayerProfileCache().getUsernames());
            }
         }

         return null;
      }
   }
}
