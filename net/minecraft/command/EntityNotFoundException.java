package net.minecraft.command;

public class EntityNotFoundException extends CommandException {
   public EntityNotFoundException(String var1, Object... var2) {
      super(var1, var2);
   }

   public EntityNotFoundException() {
      this("commands.generic.entity.notFound");
   }
}
