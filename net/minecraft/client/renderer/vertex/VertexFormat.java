package net.minecraft.client.renderer.vertex;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VertexFormat {
   private int normalElementOffset;
   private final List<VertexFormatElement> elements;
   private List<Integer> uvOffsetsById;
   private final List<Integer> offsets;
   private int nextOffset;
   private static final Logger LOGGER = LogManager.getLogger();
   private int colorElementOffset;
   private static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;

   public int getUvOffsetById(int var1) {
      return (Integer)this.uvOffsetsById.get(var1);
   }

   public VertexFormat() {
      this.elements = Lists.newArrayList();
      this.offsets = Lists.newArrayList();
      this.nextOffset = 0;
      this.colorElementOffset = -1;
      this.uvOffsetsById = Lists.newArrayList();
      this.normalElementOffset = -1;
   }

   public VertexFormat addElement(VertexFormatElement var1) {
      if (var1.isPositionElement() && this.hasPosition()) {
         LOGGER.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
         return this;
      } else {
         this.elements.add(var1);
         this.offsets.add(this.nextOffset);
         switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[var1.getUsage().ordinal()]) {
         case 2:
            this.normalElementOffset = this.nextOffset;
            break;
         case 3:
            this.colorElementOffset = this.nextOffset;
            break;
         case 4:
            this.uvOffsetsById.add(var1.getIndex(), this.nextOffset);
         }

         this.nextOffset += var1.getSize();
         return this;
      }
   }

   public int getIntegerSize() {
      return this.getNextOffset() / 4;
   }

   public int getElementCount() {
      return this.elements.size();
   }

   public void clear() {
      this.elements.clear();
      this.offsets.clear();
      this.colorElementOffset = -1;
      this.uvOffsetsById.clear();
      this.normalElementOffset = -1;
      this.nextOffset = 0;
   }

   public boolean hasColor() {
      return this.colorElementOffset >= 0;
   }

   public boolean hasNormal() {
      return this.normalElementOffset >= 0;
   }

   public int getColorOffset() {
      return this.colorElementOffset;
   }

   public VertexFormat(VertexFormat var1) {
      this();

      for(int var2 = 0; var2 < var1.getElementCount(); ++var2) {
         this.addElement(var1.getElement(var2));
      }

      this.nextOffset = var1.getNextOffset();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         VertexFormat var2 = (VertexFormat)var1;
         if (this.nextOffset != var2.nextOffset) {
            return false;
         } else {
            return !this.elements.equals(var2.elements) ? false : this.offsets.equals(var2.offsets);
         }
      } else {
         return false;
      }
   }

   public int getOffset(int var1) {
      return (Integer)this.offsets.get(var1);
   }

   public List<VertexFormatElement> getElements() {
      return this.elements;
   }

   public String toString() {
      String var1 = "format: " + this.elements.size() + " elements: ";

      for(int var2 = 0; var2 < this.elements.size(); ++var2) {
         var1 = var1 + ((VertexFormatElement)this.elements.get(var2)).toString();
         if (var2 != this.elements.size() - 1) {
            var1 = var1 + " ";
         }
      }

      return var1;
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[VertexFormatElement.EnumUsage.values().length];

         try {
            var0[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = var0;
         return var0;
      }
   }

   public VertexFormatElement getElement(int var1) {
      return (VertexFormatElement)this.elements.get(var1);
   }

   public int getNormalOffset() {
      return this.normalElementOffset;
   }

   public int hashCode() {
      int var1 = this.elements.hashCode();
      var1 = 31 * var1 + this.offsets.hashCode();
      var1 = 31 * var1 + this.nextOffset;
      return var1;
   }

   public boolean hasUvOffset(int var1) {
      return this.uvOffsetsById.size() - 1 >= var1;
   }

   private boolean hasPosition() {
      int var1 = 0;

      for(int var2 = this.elements.size(); var1 < var2; ++var1) {
         VertexFormatElement var3 = (VertexFormatElement)this.elements.get(var1);
         if (var3.isPositionElement()) {
            return true;
         }
      }

      return false;
   }

   public int getNextOffset() {
      return this.nextOffset;
   }
}
