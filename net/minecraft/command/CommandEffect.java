package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;

public class CommandEffect extends CommandBase {
   public List<String> addTabCompletionOptions(ICommandSender var1, String[] var2, BlockPos var3) {
      if (var2.length == 1) {
         return getListOfStringsMatchingLastWord(var2, this.getAllUsernames());
      } else if (var2.length == 2) {
         return getListOfStringsMatchingLastWord(var2, Potion.getPotionLocations());
      } else {
         return var2.length == 5 ? getListOfStringsMatchingLastWord(var2, new String[]{"true", "false"}) : null;
      }
   }

   public String getCommandName() {
      return "effect";
   }

   protected String[] getAllUsernames() {
      return MinecraftServer.getServer().getAllUsernames();
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public void processCommand(ICommandSender var1, String[] var2) throws CommandException {
      if (var2.length < 2) {
         throw new WrongUsageException("commands.effect.usage", new Object[0]);
      } else {
         EntityLivingBase var3 = (EntityLivingBase)getEntity(var1, var2[0], EntityLivingBase.class);
         if (var2[1].equals("clear")) {
            if (var3.getActivePotionEffects().isEmpty()) {
               throw new CommandException("commands.effect.failure.notActive.all", new Object[]{var3.getName()});
            }

            var3.clearActivePotions();
            notifyOperators(var1, this, "commands.effect.success.removed.all", new Object[]{var3.getName()});
         } else {
            int var4;
            try {
               var4 = parseInt(var2[1], 1);
            } catch (NumberInvalidException var11) {
               Potion var6 = Potion.getPotionFromResourceLocation(var2[1]);
               if (var6 == null) {
                  throw var11;
               }

               var4 = var6.id;
            }

            int var5 = 600;
            int var12 = 30;
            int var7 = 0;
            if (var4 < 0 || var4 >= Potion.potionTypes.length || Potion.potionTypes[var4] == null) {
               throw new NumberInvalidException("commands.effect.notFound", new Object[]{var4});
            }

            Potion var8 = Potion.potionTypes[var4];
            if (var2.length >= 3) {
               var12 = parseInt(var2[2], 0, 1000000);
               if (var8.isInstant()) {
                  var5 = var12;
               } else {
                  var5 = var12 * 20;
               }
            } else if (var8.isInstant()) {
               var5 = 1;
            }

            if (var2.length >= 4) {
               var7 = parseInt(var2[3], 0, 255);
            }

            boolean var9 = true;
            if (var2.length >= 5 && "true".equalsIgnoreCase(var2[4])) {
               var9 = false;
            }

            if (var12 > 0) {
               PotionEffect var10 = new PotionEffect(var4, var5, var7, false, var9);
               var3.addPotionEffect(var10);
               notifyOperators(var1, this, "commands.effect.success", new Object[]{new ChatComponentTranslation(var10.getEffectName(), new Object[0]), var4, var7, var3.getName(), var12});
            } else {
               if (!var3.isPotionActive(var4)) {
                  throw new CommandException("commands.effect.failure.notActive", new Object[]{new ChatComponentTranslation(var8.getName(), new Object[0]), var3.getName()});
               }

               var3.removePotionEffect(var4);
               notifyOperators(var1, this, "commands.effect.success.removed", new Object[]{new ChatComponentTranslation(var8.getName(), new Object[0]), var3.getName()});
            }
         }

      }
   }

   public boolean isUsernameIndex(String[] var1, int var2) {
      return var2 == 0;
   }

   public String getCommandUsage(ICommandSender var1) {
      return "commands.effect.usage";
   }
}
