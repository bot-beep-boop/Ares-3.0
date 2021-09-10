package net.minecraft.command;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.EnumDifficulty;

public class CommandDifficulty extends CommandBase {
   public String getCommandName() {
      return "difficulty";
   }

   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length <= 0) {
         throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
      } else {
         EnumDifficulty var3 = this.getDifficultyFromCommand(var2[0]);
         MinecraftServer.getServer().setDifficultyForAllWorlds(var3);
         notifyOperators(var1, this, "commands.difficulty.success", new Object[]{new ChatComponentTranslation(var3.getDifficultyResourceKey(), new Object[0])});
      }
   }

   protected EnumDifficulty getDifficultyFromCommand(String var1) throws CommandException, NumberInvalidException {
      if (!var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")) {
         if (!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")) {
            if (!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")) {
               return !var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h") ? EnumDifficulty.getDifficultyEnum(parseInt(var1, 0, 3)) : EnumDifficulty.HARD;
            } else {
               return EnumDifficulty.NORMAL;
            }
         } else {
            return EnumDifficulty.EASY;
         }
      } else {
         return EnumDifficulty.PEACEFUL;
      }
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      return var2.length == 1 ? getListOfStringsMatchingLastWord(var2, new String[]{"peaceful", "easy", "normal", "hard"}) : null;
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.difficulty.usage";
   }
}
