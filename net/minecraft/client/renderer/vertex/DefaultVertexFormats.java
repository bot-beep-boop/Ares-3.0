package net.minecraft.client.renderer.vertex;

import java.lang.reflect.Field;
import net.minecraft.src.Config;
import net.optifine.reflect.ReflectorClass;
import net.optifine.reflect.ReflectorField;
import net.optifine.shaders.SVertexFormat;

public class DefaultVertexFormats {
   public static final VertexFormatElement POSITION_3F;
   private static final VertexFormat BLOCK_VANILLA;
   public static final VertexFormat POSITION_TEX_NORMAL;
   public static final VertexFormat POSITION_NORMAL;
   private static final VertexFormat FORGE_BAKED;
   public static final VertexFormat POSITION_TEX_COLOR;
   public static final VertexFormat POSITION_TEX_LMAP_COLOR;
   public static final VertexFormatElement TEX_2F;
   public static ReflectorClass Attributes;
   public static VertexFormat ITEM = new VertexFormat();
   public static final VertexFormatElement PADDING_1B;
   public static final VertexFormatElement TEX_2S;
   private static final VertexFormat ITEM_VANILLA;
   public static final VertexFormat PARTICLE_POSITION_TEX_COLOR_LMAP;
   public static final VertexFormat POSITION_TEX_COLOR_NORMAL;
   public static final VertexFormat POSITION_COLOR;
   public static final VertexFormat POSITION;
   public static final VertexFormat POSITION_TEX;
   public static final VertexFormat OLDMODEL_POSITION_TEX_NORMAL;
   public static final VertexFormatElement NORMAL_3B;
   public static ReflectorField Attributes_DEFAULT_BAKED_FORMAT;
   public static VertexFormat BLOCK = new VertexFormat();
   public static final VertexFormatElement COLOR_4UB;

   public static Object getFieldValue(ReflectorField var0) {
      try {
         Field var1 = var0.getTargetField();
         if (var1 == null) {
            return null;
         } else {
            Object var2 = var1.get((Object)null);
            return var2;
         }
      } catch (Throwable var3) {
         var3.printStackTrace();
         return null;
      }
   }

   static {
      BLOCK_VANILLA = BLOCK;
      ITEM_VANILLA = ITEM;
      Attributes = new ReflectorClass("net.minecraftforge.client.model.Attributes");
      Attributes_DEFAULT_BAKED_FORMAT = new ReflectorField(Attributes, "DEFAULT_BAKED_FORMAT");
      FORGE_BAKED = SVertexFormat.duplicate((VertexFormat)getFieldValue(Attributes_DEFAULT_BAKED_FORMAT));
      OLDMODEL_POSITION_TEX_NORMAL = new VertexFormat();
      PARTICLE_POSITION_TEX_COLOR_LMAP = new VertexFormat();
      POSITION = new VertexFormat();
      POSITION_COLOR = new VertexFormat();
      POSITION_TEX = new VertexFormat();
      POSITION_NORMAL = new VertexFormat();
      POSITION_TEX_COLOR = new VertexFormat();
      POSITION_TEX_NORMAL = new VertexFormat();
      POSITION_TEX_LMAP_COLOR = new VertexFormat();
      POSITION_TEX_COLOR_NORMAL = new VertexFormat();
      POSITION_3F = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3);
      COLOR_4UB = new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4);
      TEX_2F = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2);
      TEX_2S = new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.UV, 2);
      NORMAL_3B = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3);
      PADDING_1B = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1);
      BLOCK.addElement(POSITION_3F);
      BLOCK.addElement(COLOR_4UB);
      BLOCK.addElement(TEX_2F);
      BLOCK.addElement(TEX_2S);
      ITEM.addElement(POSITION_3F);
      ITEM.addElement(COLOR_4UB);
      ITEM.addElement(TEX_2F);
      ITEM.addElement(NORMAL_3B);
      ITEM.addElement(PADDING_1B);
      OLDMODEL_POSITION_TEX_NORMAL.addElement(POSITION_3F);
      OLDMODEL_POSITION_TEX_NORMAL.addElement(TEX_2F);
      OLDMODEL_POSITION_TEX_NORMAL.addElement(NORMAL_3B);
      OLDMODEL_POSITION_TEX_NORMAL.addElement(PADDING_1B);
      PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(POSITION_3F);
      PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(TEX_2F);
      PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(COLOR_4UB);
      PARTICLE_POSITION_TEX_COLOR_LMAP.addElement(TEX_2S);
      POSITION.addElement(POSITION_3F);
      POSITION_COLOR.addElement(POSITION_3F);
      POSITION_COLOR.addElement(COLOR_4UB);
      POSITION_TEX.addElement(POSITION_3F);
      POSITION_TEX.addElement(TEX_2F);
      POSITION_NORMAL.addElement(POSITION_3F);
      POSITION_NORMAL.addElement(NORMAL_3B);
      POSITION_NORMAL.addElement(PADDING_1B);
      POSITION_TEX_COLOR.addElement(POSITION_3F);
      POSITION_TEX_COLOR.addElement(TEX_2F);
      POSITION_TEX_COLOR.addElement(COLOR_4UB);
      POSITION_TEX_NORMAL.addElement(POSITION_3F);
      POSITION_TEX_NORMAL.addElement(TEX_2F);
      POSITION_TEX_NORMAL.addElement(NORMAL_3B);
      POSITION_TEX_NORMAL.addElement(PADDING_1B);
      POSITION_TEX_LMAP_COLOR.addElement(POSITION_3F);
      POSITION_TEX_LMAP_COLOR.addElement(TEX_2F);
      POSITION_TEX_LMAP_COLOR.addElement(TEX_2S);
      POSITION_TEX_LMAP_COLOR.addElement(COLOR_4UB);
      POSITION_TEX_COLOR_NORMAL.addElement(POSITION_3F);
      POSITION_TEX_COLOR_NORMAL.addElement(TEX_2F);
      POSITION_TEX_COLOR_NORMAL.addElement(COLOR_4UB);
      POSITION_TEX_COLOR_NORMAL.addElement(NORMAL_3B);
      POSITION_TEX_COLOR_NORMAL.addElement(PADDING_1B);
   }

   public static void updateVertexFormats() {
      if (Config.isShaders()) {
         BLOCK = SVertexFormat.makeDefVertexFormatBlock();
         ITEM = SVertexFormat.makeDefVertexFormatItem();
         if (Attributes_DEFAULT_BAKED_FORMAT.exists()) {
            SVertexFormat.setDefBakedFormat((VertexFormat)Attributes_DEFAULT_BAKED_FORMAT.getValue());
         }
      } else {
         BLOCK = BLOCK_VANILLA;
         ITEM = ITEM_VANILLA;
         if (Attributes_DEFAULT_BAKED_FORMAT.exists()) {
            SVertexFormat.copy(FORGE_BAKED, (VertexFormat)Attributes_DEFAULT_BAKED_FORMAT.getValue());
         }
      }

   }
}
