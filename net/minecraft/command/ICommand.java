package net.minecraft.command;

import java.util.List;
import net.minecraft.util.BlockPos;

public interface ICommand extends Comparable<ICommand> {
   boolean canCommandSenderUseCommand(ICommandSender var1);

   void processCommand(ICommandSender var1, String[] var2) throws CommandException;

   List<String> getCommandAliases();

   String getCommandName();

   List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3);

   String getCommandUsage(ICommandSender var1);

   boolean isUsernameIndex(String[] var1, int var2);
}
