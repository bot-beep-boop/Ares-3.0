package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class CommandGameMode extends CommandBase {
   public String getCommandName() {
      return "gamemode";
   }

   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length <= 0) {
         throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
      } else {
         WorldSettings.GameType var3 = this.getGameModeFromCommand(var1, var2[0]);
         EntityPlayerMP var4 = var2.length >= 2 ? getPlayer(var1, var2[1]) : getCommandSenderAsPlayer(var1);
         var4.setGameType(var3);
         var4.fallDistance = 0.0F;
         if (var1.getEntityWorld().getGameRules().getBoolean("sendCommandFeedback")) {
            var4.addChatMessage(new ChatComponentTranslation("gameMode.changed", new Object[0]));
         }

         ChatComponentTranslation var5 = new ChatComponentTranslation("gameMode." + var3.getName(), new Object[0]);
         if (var4 != var1) {
            notifyOperators(var1, this, 1, "commands.gamemode.success.other", new Object[]{var4.getName(), var5});
         } else {
            notifyOperators(var1, this, 1, "commands.gamemode.success.self", new Object[]{var5});
         }

      }
   }

   protected WorldSettings.GameType getGameModeFromCommand(ICommandSender var1, String var2) throws CommandException, NumberInvalidException {
      if (!var2.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.getName()) && !var2.equalsIgnoreCase("s")) {
         if (!var2.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.getName()) && !var2.equalsIgnoreCase("c")) {
            if (!var2.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.getName()) && !var2.equalsIgnoreCase("a")) {
               return !var2.equalsIgnoreCase(WorldSettings.GameType.SPECTATOR.getName()) && !var2.equalsIgnoreCase("sp") ? WorldSettings.getGameTypeById(parseInt(var2, 0, WorldSettings.GameType.values().length - 2)) : WorldSettings.GameType.SPECTATOR;
            } else {
               return WorldSettings.GameType.ADVENTURE;
            }
         } else {
            return WorldSettings.GameType.CREATIVE;
         }
      } else {
         return WorldSettings.GameType.SURVIVAL;
      }
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length == 1) {
         return getListOfStringsMatchingLastWord(var2, new String[]{"survival", "creative", "adventure", "spectator"});
      } else {
         return var2.length == 2 ? getListOfStringsMatchingLastWord(var2, this.getListOfPlayerUsernames()) : null;
      }
   }

   protected String[] getListOfPlayerUsernames() {
      return MinecraftServer.getServer().getAllUsernames();
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public boolean isUsernameIndex(String[] var1, int var2) {
      return var2 == 1;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.gamemode.usage";
   }
}
