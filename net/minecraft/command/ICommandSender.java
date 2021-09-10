package net.minecraft.command;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public interface ICommandSender {
   boolean canCommandSenderUseCommand(int var1, String var2);

   World getEntityWorld();

   void setCommandStat(CommandResultStats.Type var1, int var2);

   void addChatMessage(IChatComponent var1);

   Vec3 getPositionVector();

   IChatComponent getDisplayName();

   String getName();

   boolean sendCommandFeedback();

   Entity getCommandSenderEntity();

   BlockPos getPosition();
}
