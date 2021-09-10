package net.minecraft.command;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CommandExecuteAt extends CommandBase {
   public String getCommandName() {
      return "execute";
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.execute.usage";
   }

   public boolean isUsernameIndex(String[] var1, int var2) {
      return var2 == 0;
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length == 1) {
         return getListOfStringsMatchingLastWord(var2, MinecraftServer.getServer().getAllUsernames());
      } else if (var2.length > 1 && var2.length <= 4) {
         return func_175771_a(var2, 1, var3);
      } else if (var2.length > 5 && var2.length <= 8 && "detect".equals(var2[4])) {
         return func_175771_a(var2, 5, var3);
      } else {
         return var2.length == 9 && "detect".equals(var2[4]) ? getListOfStringsMatchingLastWord(var2, Block.blockRegistry.getKeys()) : null;
      }
   }

   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length < 5) {
         throw new WrongUsageException("commands.execute.usage", new Object[0]);
      } else {
         Entity var3 = getEntity(var1, var2[0], Entity.class);
         double var4 = parseDouble(var3.posX, var2[1], false);
         double var6 = parseDouble(var3.posY, var2[2], false);
         double var8 = parseDouble(var3.posZ, var2[3], false);
         BlockPos var10 = new BlockPos(var4, var6, var8);
         byte var11 = 4;
         if ("detect".equals(var2[4]) && var2.length > 10) {
            World var12 = var3.getEntityWorld();
            double var13 = parseDouble(var4, var2[5], false);
            double var15 = parseDouble(var6, var2[6], false);
            double var17 = parseDouble(var8, var2[7], false);
            Block var19 = getBlockByText(var1, var2[8]);
            int var20 = parseInt(var2[9], -1, 15);
            BlockPos var21 = new BlockPos(var13, var15, var17);
            IBlockState var22 = var12.getBlockState(var21);
            if (var22.getBlock() != var19 || var20 >= 0 && var22.getBlock().getMetaFromState(var22) != var20) {
               throw new CommandException("commands.execute.failed", new Object[]{"detect", var3.getName()});
            }

            var11 = 10;
         }

         String var24 = buildString(var2, var11);
         ICommandSender var14 = new ICommandSender(this, var3, var1, var10, var4, var6, var8) {
            final CommandExecuteAt this$0;
            private final Entity val$entity;
            private final double val$d0;
            private final BlockPos val$blockpos;
            private final double val$d1;
            private final ICommandSender val$icommandsender1;
            private final double val$d2;

            public IChatComponent getDisplayName() {
               return this.val$entity.getDisplayName();
            }

            public void addChatMessage(IChatComponent var1) {
               this.val$icommandsender1.addChatMessage(var1);
            }

            public boolean canCommandSenderUseCommand(int var1, String var2) {
               return this.val$icommandsender1.canCommandSenderUseCommand(var1, var2);
            }

            {
               this.this$0 = var1;
               this.val$entity = var2;
               this.val$icommandsender1 = var3;
               this.val$blockpos = var4;
               this.val$d0 = var5;
               this.val$d1 = var7;
               this.val$d2 = var9;
            }

            public BlockPos getPosition() {
               return this.val$blockpos;
            }

            public World getEntityWorld() {
               return this.val$entity.worldObj;
            }

            public Vec3 getPositionVector() {
               return new Vec3(this.val$d0, this.val$d1, this.val$d2);
            }

            public String getName() {
               return this.val$entity.getName();
            }

            public void setCommandStat(CommandResultStats.Type var1, int var2) {
               this.val$entity.setCommandStat(var1, var2);
            }

            public Entity getCommandSenderEntity() {
               return this.val$entity;
            }

            public boolean sendCommandFeedback() {
               MinecraftServer var1 = MinecraftServer.getServer();
               return var1 == null || var1.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
            }
         };
         ICommandManager var25 = MinecraftServer.getServer().getCommandManager();

         try {
            int var16 = var25.executeCommand(var14, var24);
            if (var16 < 1) {
               throw new CommandException("commands.execute.allInvocationsFailed", new Object[]{var24});
            }
         } catch (Throwable var23) {
            throw new CommandException("commands.execute.failed", new Object[]{var24, var3.getName()});
         }
      }
   }
}
