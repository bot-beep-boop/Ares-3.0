package net.minecraft.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

public class CommandHelp extends CommandBase {
   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      List var3 = this.getSortedPossibleCommands(var1);
      boolean var4 = true;
      int var5 = (var3.size() - 1) / 7;
      boolean var6 = false;

      int var13;
      try {
         var13 = var2.length == 0 ? 0 : parseInt(var2[0], 1, var5 + 1) - 1;
      } catch (NumberInvalidException var12) {
         Map var8 = this.getCommands();
         ICommand var9 = (ICommand)var8.get(var2[0]);
         if (var9 != null) {
            throw new WrongUsageException(var9.getCommandUsage(var1), new Object[0]);
         }

         if (MathHelper.parseIntWithDefault(var2[0], -1) != -1) {
            throw var12;
         }

         throw new CommandNotFoundException();
      }

      int var7 = Math.min((var13 + 1) * 7, var3.size());
      ChatComponentTranslation var14 = new ChatComponentTranslation("commands.help.header", new Object[]{var13 + 1, var5 + 1});
      var14.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
      var1.addChatMessage(var14);

      for(int var15 = var13 * 7; var15 < var7; ++var15) {
         ICommand var10 = (ICommand)var3.get(var15);
         ChatComponentTranslation var11 = new ChatComponentTranslation(var10.getCommandUsage(var1), new Object[0]);
         var11.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + var10.getCommandName() + " "));
         var1.addChatMessage(var11);
      }

      if (var13 == 0 && var1 instanceof EntityPlayer) {
         ChatComponentTranslation var16 = new ChatComponentTranslation("commands.help.footer", new Object[0]);
         var16.getChatStyle().setColor(EnumChatFormatting.GREEN);
         var1.addChatMessage(var16);
      }

   }

   public String getCommandName() {
      return "help";
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length == 1) {
         Set var4 = this.getCommands().keySet();
         return getListOfStringsMatchingLastWord(var2, (String[])var4.toArray(new String[var4.size()]));
      } else {
         return null;
      }
   }

   public int getRequiredPermissionLevel() {
      return 0;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.help.usage";
   }

   protected List<ICommand> getSortedPossibleCommands(ICommandSender var1) {
      List var2 = MinecraftServer.getServer().getCommandManager().getPossibleCommands(var1);
      Collections.sort(var2);
      return var2;
   }

   protected Map<String, ICommand> getCommands() {
      return MinecraftServer.getServer().getCommandManager().getCommands();
   }

   public List<String> getCommandAliases() {
      return Arrays.asList("?");
   }
}
