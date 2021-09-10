package net.minecraft.entity.ai.attributes;

import io.netty.util.internal.ThreadLocalRandom;
import java.util.UUID;
import net.minecraft.util.MathHelper;
import org.apache.commons.lang3.Validate;

public class AttributeModifier {
   private final double amount;
   private final UUID id;
   private final String name;
   private final int operation;
   private boolean isSaved;

   public String toString() {
      return "AttributeModifier{amount=" + this.amount + ", operation=" + this.operation + ", name='" + this.name + '\'' + ", id=" + this.id + ", serialize=" + this.isSaved + '}';
   }

   public AttributeModifier(UUID var1, String var2, double var3, int var5) {
      this.isSaved = true;
      this.id = var1;
      this.name = var2;
      this.amount = var3;
      this.operation = var5;
      Validate.notEmpty(var2, "Modifier name cannot be empty", new Object[0]);
      Validate.inclusiveBetween(0L, 2L, (long)var5, "Invalid operation");
   }

   public String getName() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         AttributeModifier var2 = (AttributeModifier)var1;
         if (this.id != null) {
            if (!this.id.equals(var2.id)) {
               return false;
            }
         } else if (var2.id != null) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean isSaved() {
      return this.isSaved;
   }

   public int hashCode() {
      return this.id != null ? this.id.hashCode() : 0;
   }

   public AttributeModifier setSaved(boolean var1) {
      this.isSaved = var1;
      return this;
   }

   public UUID getID() {
      return this.id;
   }

   public double getAmount() {
      return this.amount;
   }

   public AttributeModifier(String var1, double var2, int var4) {
      this(MathHelper.getRandomUuid(ThreadLocalRandom.current()), var1, var2, var4);
   }

   public int getOperation() {
      return this.operation;
   }
}
