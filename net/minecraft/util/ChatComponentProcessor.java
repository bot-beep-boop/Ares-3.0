package net.minecraft.util;

import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.Entity;

public class ChatComponentProcessor {
   public static IChatComponent processComponent(ICommandSender var0, IChatComponent var1, Entity var2) throws CommandException {
      Object var3 = null;
      if (var1 instanceof ChatComponentScore) {
         ChatComponentScore var4 = (ChatComponentScore)var1;
         String var5 = var4.getName();
         if (PlayerSelector.hasArguments(var5)) {
            List var6 = PlayerSelector.matchEntities(var0, var5, Entity.class);
            if (var6.size() != 1) {
               throw new EntityNotFoundException();
            }

            var5 = ((Entity)var6.get(0)).getName();
         }

         var3 = var2 != null && var5.equals("*") ? new ChatComponentScore(var2.getName(), var4.getObjective()) : new ChatComponentScore(var5, var4.getObjective());
         ((ChatComponentScore)var3).setValue(var4.getUnformattedTextForChat());
      } else if (var1 instanceof ChatComponentSelector) {
         String var7 = ((ChatComponentSelector)var1).getSelector();
         var3 = PlayerSelector.matchEntitiesToChatComponent(var0, var7);
         if (var3 == null) {
            var3 = new ChatComponentText("");
         }
      } else if (var1 instanceof ChatComponentText) {
         var3 = new ChatComponentText(((ChatComponentText)var1).getChatComponentText_TextValue());
      } else {
         if (!(var1 instanceof ChatComponentTranslation)) {
            return var1;
         }

         Object[] var8 = ((ChatComponentTranslation)var1).getFormatArgs();

         for(int var10 = 0; var10 < var8.length; ++var10) {
            Object var11 = var8[var10];
            if (var11 instanceof IChatComponent) {
               var8[var10] = processComponent(var0, (IChatComponent)var11, var2);
            }
         }

         var3 = new ChatComponentTranslation(((ChatComponentTranslation)var1).getKey(), var8);
      }

      ChatStyle var9 = var1.getChatStyle();
      if (var9 != null) {
         ((IChatComponent)var3).setChatStyle(var9.createShallowCopy());
      }

      Iterator var12 = var1.getSiblings().iterator();

      while(var12.hasNext()) {
         IChatComponent var13 = (IChatComponent)var12.next();
         ((IChatComponent)var3).appendSibling(processComponent(var0, var13, var2));
      }

      return (IChatComponent)var3;
   }
}
