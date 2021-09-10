package net.minecraft.client.renderer.chunk;

import java.util.Iterator;
import java.util.Set;
import net.minecraft.util.EnumFacing;

public class SetVisibility {
   private static final int COUNT_FACES = EnumFacing.values().length;
   private long bits;

   public void setVisible(EnumFacing var1, EnumFacing var2, boolean var3) {
      this.setBit(var1.ordinal() + var2.ordinal() * COUNT_FACES, var3);
      this.setBit(var2.ordinal() + var1.ordinal() * COUNT_FACES, var3);
   }

   public boolean isVisible(EnumFacing var1, EnumFacing var2) {
      return this.getBit(var1.ordinal() + var2.ordinal() * COUNT_FACES);
   }

   private void setBit(int var1) {
      this.bits |= (long)(1 << var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(' ');
      EnumFacing[] var5;
      int var4 = (var5 = EnumFacing.values()).length;

      EnumFacing var2;
      int var3;
      for(var3 = 0; var3 < var4; ++var3) {
         var2 = var5[var3];
         var1.append(' ').append(var2.toString().toUpperCase().charAt(0));
      }

      var1.append('\n');
      var4 = (var5 = EnumFacing.values()).length;

      for(var3 = 0; var3 < var4; ++var3) {
         var2 = var5[var3];
         var1.append(var2.toString().toUpperCase().charAt(0));
         EnumFacing[] var9;
         int var8 = (var9 = EnumFacing.values()).length;

         for(int var7 = 0; var7 < var8; ++var7) {
            EnumFacing var6 = var9[var7];
            if (var2 == var6) {
               var1.append("  ");
            } else {
               boolean var10 = this.isVisible(var2, var6);
               var1.append(' ').append((char)(var10 ? 'Y' : 'n'));
            }
         }

         var1.append('\n');
      }

      return var1.toString();
   }

   public void setManyVisible(Set<EnumFacing> var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         EnumFacing var2 = (EnumFacing)var3.next();
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            EnumFacing var4 = (EnumFacing)var5.next();
            this.setVisible(var2, var4, true);
         }
      }

   }

   private void clearBit(int var1) {
      this.bits &= (long)(~(1 << var1));
   }

   public void setAllVisible(boolean var1) {
      if (var1) {
         this.bits = -1L;
      } else {
         this.bits = 0L;
      }

   }

   private boolean getBit(int var1) {
      return (this.bits & (long)(1 << var1)) != 0L;
   }

   private void setBit(int var1, boolean var2) {
      if (var2) {
         this.setBit(var1);
      } else {
         this.clearBit(var1);
      }

   }
}
